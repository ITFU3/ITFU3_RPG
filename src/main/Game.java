package main;

import character.MonsterCharacter;
import character.PlayerCharacter;
import character.races.MonsterRace;
import gameHandler.KeyHandler;
import gameHandler.MonsterAI;
import gameHandler.SleepTime;
import gameHandler.UserInfo;
//import gameHandler.MonsterAI;
import gui.GameFrame;
//import gui.GuiHelper.HealthBarLabel;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author Steffen Haas
 */
public class Game /*implements Runnable*/{
    
    public static Game instance;
      
    private PlayerCharacter player;
    private ArrayList<MonsterCharacter> monsters  = new ArrayList();
    
    private int level;
    private int roundCount = 1;
    
    private GameFrame gameFrame;
    public int width, height;
    public String title = "Death's domain";
    
    public String attackInfo = "";
    public String monsterInfo = "";
    
    // Input
    private KeyHandler keymanager;
    private boolean running = false;
    private boolean playerTurn = true;
    
    private Game() {
        
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    private void init() {
        gameFrame = new GameFrame();
        gameFrame.setTitle(title);
    }

    
    public /*synchronized*/ void start() {
//        
        init();
    }
    
    public void stop() {
        
    }
    /**
     * created by Steffen Haas
     * @param hit 
     */
    public static void hitDisplay() {
        updateAttackInfo(UserInfo.HIT, true);
        Game.waitFor(SleepTime.HIT);
    }

    public static void updateGUI(){
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
        
        // Update HP-Bar for the Player
        getInstance().updateHealthBar( getPlayer().getTempHP() );
        
        getInstance().getGameFrame().repaint();
        System.out.println("main.Game.updateGUI => UPDATED");
    }
    
    public static void updateMonsterInfo() {
        ArrayList<MonsterCharacter> monsters = getMonsters();
        String newMonsterInfo = "Monsters in Arena: " + monsters.size() + "\n";
        
        for(MonsterCharacter monster : monsters){
            newMonsterInfo += ((MonsterCharacter)monster).getName() + "\n" +
                monster.getTempHP() + "/" + monster.getHealth() + "\n";
        }
        getInstance().setMonsterInfo( newMonsterInfo );
        
        System.out.println("main.Game.updateMonsterInfo => UPDATED");
    }
    
    public static void endRound() {
        setPlayerTurn(false);
        upgradeMonsters();
        if( getMonsters().size() <= 0 || getInstance().roundCount % 2 == 0 ){
            getInstance().nextLevel();
            System.out.println("main.Game.endRound ==> NEXT LEVEL: " + getInstance().getLevel());
        }
        
        for (MonsterCharacter monster : getMonsters()) {
            getInstance().getGameFrame().getCurrentActiveCharLabel().setText(
                monster.getName() +"'s turn"
            );
            MonsterAI monsterAi = new MonsterAI(monster);
            monsterAi.calcMovesToPlayer();
            monsterAi.think();
            monsterAi.resetTurnStats();
            updateGUI();
            if (getPlayer().getTempHP() < 0) {
                Game.over();
                return;
            }
            
        }
        setPlayerTurn(true);
        
        getInstance().roundCount ++;
      
        updateAttackInfo(   "##############################\n"+
                            "# It is your turn. Wake up.! #\n"+
                            "##############################");
        System.out.println("main.Game.endRound ==> It is your turn. Wake up.!");
        getInstance().getGameFrame().getCurrentActiveCharLabel().setText(Game.getPlayer().getName() +"'s turn");
        // Reset PLayerCharacter
        getPlayer().setAllowedMoves(
            //sollte eingerückt sein, ist ein Parameter
            getPlayer().getMovement()
        );
        getPlayer().setAllowedAttacks(1);
        updateGUI();
    } 

    public void nextLevel(){
        updateAttackInfo(UserInfo.NEXT_LEVEL);
        Game.waitFor(SleepTime.NEXT_LEVEL);
        Map.getInstance().spawnRandomMonster(++this.level);
        updateMonsterInfo();
        Game.updateGUI();
    }
    
    public static void updateAttackInfo(String addString) {
        updateAttackInfo(addString, false);
    }
    
    public static void updateAttackInfo(String addString, boolean add) {
        
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
        
        getInstance().setAttackInfo(newOldString); //???
        System.out.println("main.Game.updateAttackInfo => UPDATED");
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
        System.out.println("main.Game.addToAttackInfoString => UPDATED");
    }
    
    
    public static void updateHealthBar(int newHP)
    {
        ((gui.GuiHelper.HealthBarLabel) Game.getInstance()
            .getGameFrame().getPlayerHealthBarLabel()
        ).setHealthText( newHP );
    }
    
    public static void waitFor(long millis) {
        
        try {
            
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public int getMonsterClosedToPlayer(){
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
    public KeyHandler getKeymanager() {
        return keymanager;
    }
    public boolean isRunning() {
        return running;
    }
    public void setRunning(boolean running) {
        this.running = running;
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
        System.out.println("main.Game.isPlayerTurn ==> Is player turn: " +getInstance().playerTurn);
        return getInstance().playerTurn;
    }

    public static void setPlayerTurn(boolean playerTurn) {
        getInstance().playerTurn = playerTurn;
    }
    
    private static void upgradeMonsters() {
        System.out.println("########################## UPGRADE MONSTERS #####START####################");
        for (MonsterCharacter monster : getMonsters()) {
            
            System.out.println(monster.showCharInfo());
            System.out.println("MONSTER "+monster.getName()+" is GROWING");
            monster.grow();
            System.out.println(monster.showCharInfo());
           
            
        }
        System.out.println("########################## UPGRADE MONSTERS #####END#####################");
    }
    
    private static void over() {
        
        Game.getInstance().stop();
        Game.updateAttackInfo(UserInfo.GAME_OVER);
        System.out.println(UserInfo.GAME_OVER);
    }
}
