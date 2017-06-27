package main;

import character.MonsterCharacter;
import character.PlayerCharacter;
import gameHandler.KeyHandler;
import gameHandler.MonsterAI;
import base.*;
import gui.GameFrame;
import gui.SelectionFrame;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author Steffen Haas
 */
public class Game
{
    
    public static Game instance;
    private KeyHandler keyhandler = new KeyHandler();
    
    private PlayerCharacter player;
    private ArrayList<MonsterCharacter> monsters  = new ArrayList();
    
    private int level;
    private int roundCount = 1;
    
    private GameFrame gameFrame;
    public int width, height;
    public String title = "Death's domain";
    
    public String attackInfo = "";
    public String monsterInfo = "";
    
    private boolean playerTurn = true;
    
    protected Game()
    {
        // empty due to singelton
    }

    public static Game getInstance()
    {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public void start()
    {
        this.playerTurn = true;
        this.attackInfo = "Good luck!";
        this.monsters = new ArrayList<>();
        this.level = 1;
        this.roundCount = 1;
        gameFrame = new GameFrame();
        gameFrame.setTitle(title);
        gameFrame.getPlayerNamelLabel().setText(player.getName());
        
        //updateGUI();
    }
    
    
    
    /**
     * created by Steffen Haas
     */
    public static void hitDisplay()
    {
        updateAttackInfo(UserInfo.HIT, true);
        Game.waitFor(SleepTime.HIT);
    }

    /**
     * main GUI update function
     */
    public static void updateGUI()
    {
        getInstance().getGameFrame().getArenaTextArea().setText(Map.getInstance().getMap());
        getInstance().getGameFrame().getArenaTextArea().update(
            getInstance().getGameFrame().getArenaTextArea().getGraphics()
        );
      
        updateAttackInfo(getInstance().getAttackInfo());
               
        int tmpLength = getAttackInfoTextArea().getText().length();
        getAttackInfoTextArea().setCaretPosition( ((tmpLength>0) ? --tmpLength : tmpLength) );
        
        getInstance().getGameFrame().getMonsterInfoTextArea().setText(getInstance().monsterInfo);
        getInstance().getGameFrame().getMonsterInfoTextArea().update(
            getInstance().getGameFrame().getMonsterInfoTextArea().getGraphics()
        );
        
        getInstance().getGameFrame().getValueMovesLeftLabel().setText(
            String.valueOf(getPlayer().getAllowedMoves())
        );
        getInstance().getGameFrame().getValueAttacksLeftLabel().setText(
            String.valueOf(getPlayer().getAllowedAttacks())
        );
        getInstance().getGameFrame().getRoundLabel().setText(
            "Round " + getInstance().roundCount
        );
        getInstance().getGameFrame().getLevelLabel().setText(
            "Level " + getInstance().getLevel()
        );
        
       getInstance().getGameFrame().getValueAttacksLeftLabel().setText(
               getPlayer().getAllowedAttacks() +"/"+getPlayer().getAttacks()
       );
       getInstance().getGameFrame().getValueMovesLeftLabel().setText(
               getPlayer().getAllowedMoves()+"/"+getPlayer().getMovement()
       );
        
        // Update HP-Bar for the Player
        updateHealthBar( getPlayer().getTempHP() );
        
        getInstance().getGameFrame().repaint();
    }
    
    /**
     * GUI MOnsterInfo Update for all monsters
     */
    public static void updateMonsterInfo()
    {
        ArrayList<MonsterCharacter> monsters = getMonsters();
        String newMonsterInfo = "Monsters in Arena: " + monsters.size() + "\n";
        
        for(MonsterCharacter monster : monsters){
            newMonsterInfo += ((MonsterCharacter)monster).getName() + "\n" +
                monster.getTempHP() + "/" + monster.getHealth() + "\n";
        }
        getInstance().setMonsterInfo( newMonsterInfo );
        
        //System.out.println("main.Game.updateMonsterInfo => UPDATED");
    }
    
    /**
     * EndRound Fuction for the Player
     * and the MonsterAI loop for all Monsters
     */
    public static void endRound()
    {
        setPlayerTurn(false);
        upgradeMonsters();
        if( getMonsters().size() <= 0 || getInstance().roundCount % 2 == 0 ){
            getInstance().nextLevel();
           
        }
        
        for (MonsterCharacter monster : getMonsters()) {
            getInstance().getGameFrame().getCurrentActiveCharLabel().setText(
                monster.getName() +"'s turn"
            );
            MonsterAI monsterAi = new MonsterAI(monster);
//            monsterAi.calcMovesToPlayer(); // now private in think
            monsterAi.think();
//            monsterAi.resetTurnStats(); // now private in think
            updateGUI();
            if (getPlayer().getTempHP() <= 0) {
                Game.over();
                return;
            }
            
        }
        setPlayerTurn(true);
        
        getInstance().roundCount ++;
      
        updateAttackInfo( UserInfo.PLAYERS_TURN );
       
        getInstance().getGameFrame().getCurrentActiveCharLabel().setText(Game.getPlayer().getName() +"'s turn");
        
        updateXPInfo();
        // Reset PLayerCharacter
        getPlayer().setAllowedMoves(
            //sollte eingerückt sein, ist ein Parameter
            getPlayer().getMovement()
        );
        getPlayer().setAllowedAttacks(
                getPlayer().getAttacks()
        );
        updateGUI();
    } 

    /**
     * starts the next level with new spawning monster
     * and GUI update
     */
    public void nextLevel()
    {
        updateAttackInfo(UserInfo.NEXT_LEVEL);
        Game.waitFor(SleepTime.NEXT_LEVEL);
        // This makes BOSS Monster spawn in groups of 1
        int monsterCout = ++this.level;
        if( ( this.level % 2) == 0 ){ monsterCout = 1; }
        Map.getInstance().spawnRandomMonster(this.level,monsterCout);
        updateMonsterInfo();
        Game.updateGUI();
    }
    
    /**
     * created by Steffen Haas
     * 
     * default false add
     * @param addString
     */
    public static void updateAttackInfo(String addString)
    {
        updateAttackInfo(addString, false);
    }
    
    /**
     * created by Steffen Haas
     * 
     * @param addString
     * @param add
     */
    public static void updateAttackInfo(String addString, boolean add)
    {
        
        String newOldString=  addString;
        if (add) {
          newOldString =  getInstance().getAttackInfo() + "\n"+ addString;
        }
        getAttackInfoTextArea().setText(addString);
        getAttackInfoTextArea().update(
            getAttackInfoTextArea().getGraphics()
        );
        
        int tmpLength = getAttackInfoTextArea().getText().length();
        getAttackInfoTextArea().setCaretPosition( ((tmpLength>0) ? --tmpLength : tmpLength) );
        
        getInstance().setAttackInfo(newOldString); 
        Game.waitFor(SleepTime.ATTACK_INFO);
      
    }
    
    public static void updateXPInfo() {
        getInstance().getGameFrame().getExperienceValueLabel().setText(getPlayer().getExperience() + "");
    }
    
    /**
     * created by Steffen Haas
     * 
     * @param addString
     * @param add
     */
    public static void addToAttackInfoString(String addString, boolean add)
    {
        String newOldString=  addString;
        if (add) {
          newOldString =  getInstance().getAttackInfo() + "\n"+ addString;
        }
        
        getInstance().setAttackInfo(newOldString);
    }
    
    /**
     * GUI HelthBar update
     * @param newHP - int
     */
    public static void updateHealthBar(int newHP)
    {
        ((gui.GuiHelper.HealthBarLabel) Game.getInstance()
            .getGameFrame().getPlayerHealthBarLabel()
        ).setHealthText( newHP );
    }
    
    /**
     * Makes the game wait for smother gameplay.
     * @param millis - long
     */
    public static void waitFor(long millis)
    {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * From all monsters calculates the closest and most wounded Monster.
     * In that Order.
     * @return int - MonsterIndex
     */
    public int getMonsterClosestToPlayer()
    {
        int output = 0, dist = 99, hp = 99;
        PlayerCharacter pc = getPlayer();
        for(int i = 0; i < getMonsters().size(); i++){
            MonsterCharacter monster = getMonsters().get(i);
            int tmpdist = Map.getInstance().getDistance( pc, monster );
            if(tmpdist < dist){
                hp = monster.getTempHP();
                output = i;
                dist = tmpdist;
            }else if(tmpdist == dist){
                int tmpHp = monster.getTempHP();
                if(tmpHp < hp){
                    hp = tmpHp;
                    output = i;
                    dist = tmpdist;
                }
            }
        }
        return output;
    }
    
    /**
     * Triggers the grow fuction for all monsters
     */
    private static void upgradeMonsters()
    {
        for (MonsterCharacter monster : getMonsters()) {
            monster.grow();
        }
    }
    
    /**
     * Prompt the Game Over Screen and stop the Game
     */
    private static void over()
    {
        Game.updateAttackInfo(UserInfo.GAME_OVER);
        System.out.println(UserInfo.GAME_OVER);
        
        String ObjButtons[] = {"Yes","No"};
        int PromptResult = javax.swing.JOptionPane.showOptionDialog(
            null, 
            "Game Over" + "\n" +
            "Do you want to save your HighScore before starting over?",
            "Game Over", 
            javax.swing.JOptionPane.DEFAULT_OPTION,
            javax.swing.JOptionPane.WARNING_MESSAGE,
            null, 
            ObjButtons,
            ObjButtons[1]
        );
        if(PromptResult==0)
        {
            fileHandler.DataHandler.writeHighScoreList();
        }
        Game.getInstance().getGameFrame().setVisible(false);
        // start again
        new SelectionFrame();
    }
    
    // Getter and Setter
    public static PlayerCharacter getPlayer() {
        return getInstance().player;
    }
    public void setPlayer(PlayerCharacter player) {
        this.player = player;
    }
    public static ArrayList<MonsterCharacter> getMonsters() {
        return getInstance().monsters;
    }
    public void setMonsters(ArrayList<MonsterCharacter> monsters) {
        this.monsters = monsters;
    }
    public void addMonster(MonsterCharacter monster){
        getMonsters().add(monster);
    }
    public GameFrame getGameFrame() {
        return gameFrame;
    }
   
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public String getAttackInfo() {
        return attackInfo;
    }
    public String getMonsterInfo() {
        Game.updateMonsterInfo();
        return monsterInfo;
    }
    public void setAttackInfo(String attackInfo) {
        this.attackInfo = attackInfo;
    }
    public void setMonsterInfo(String monsterInfo) {
        this.monsterInfo = monsterInfo;
    }
    public static JTextArea getAttackInfoTextArea() {
        return getInstance().getGameFrame().getAttackInfoTextArea();
    }
    public static boolean isPlayerTurn() {
       
        return getInstance().playerTurn;
    }
    public static void setPlayerTurn(boolean playerTurn) {
        getInstance().playerTurn = playerTurn;
    }
    public static KeyHandler getKeyhandler() {
        return getInstance().keyhandler;
    }
}