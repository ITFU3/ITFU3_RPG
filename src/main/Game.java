package main;

import character.MonsterCharacter;
import character.PlayerCharacter;
import gameHandler.KeyHandler;
import gameHandler.MonsterAI;
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
    
    private boolean playing = true;
    
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

//    @Override
//    public void run() {
//        init();
//        // Game Logic
//        
//        stop();
//    }
    
    public /*synchronized*/ void start() {
//        if(!running){
//            running = true;
//            thread = new Thread(this);
//            thread.start();
//        } 
        init();
    }
    
    public void stop() {
        
    }

    public static void updateGUI(){
        getInstance().getGameFrame().getArenaTextArea().setText(Map.getInstance().getMap());
        getInstance().getGameFrame().getArenaTextArea().update(
            getInstance().getGameFrame().getArenaTextArea().getGraphics()
        );
      
        int tmpLength = getAttackInfoTextArea().getText().length();
        getAttackInfoTextArea().setCaretPosition( ((tmpLength>0) ? --tmpLength : tmpLength) );
        
        getInstance().getGameFrame().getMonsterInfoTextArea().setText(getInstance().monsterInfo);
        getInstance().getGameFrame().getMonsterInfoTextArea().update(
            getInstance().getGameFrame().getMonsterInfoTextArea().getGraphics()
        );
        
        getInstance().getGameFrame().getValueMovesLeftLabel().setText(String.valueOf(getPlayer().getAllowedMoves()));
        getInstance().getGameFrame().getValueAttacksLeftLabel().setText(String.valueOf(getPlayer().getAllowedAttacks()));
        getInstance().getGameFrame().getRoundLabel().setText("Round " + getInstance().roundCount);
        getInstance().getGameFrame().getLevelLabel().setText("Level " + getInstance().getLevel());
        getInstance().getGameFrame().repaint();
        
// what else do we need here
        
        System.out.println("GUI UPDATE");
    }
    
    public static void updateMonsterInfo() {
        ArrayList<MonsterCharacter> monsters = getMonsters();
        String newMonsterInfo = "Monsters in Arena: " +monsters.size() +"\n";
        
        for(MonsterCharacter monster : monsters){
            newMonsterInfo += ((MonsterCharacter)monster).getName() + " " +
                monster.getTempHP() + "/" + monster.getHealth() + "\n";
        }
        getInstance().setMonsterInfo(newMonsterInfo);
    }
    
    public static void endRound() {
        setPlayerTurn(false);
        
        if( getMonsters().size() <= 0 || getInstance().roundCount % 2 == 0 ){
            getInstance().nextLevel();
            
            System.out.println("NEXT LEVEL: " + getInstance().getLevel());
        }
        
        for (MonsterCharacter monster : getMonsters()) {
            getInstance().getGameFrame().getCurrentActiveCharLabel().setText(
                monster.getName() +"'s turn"
            );
            MonsterAI monsterAi = new MonsterAI(monster);
            monsterAi.calcMovesToPlayer();
            monsterAi.think();
            updateGUI();
        }
        setPlayerTurn(true);
        
        getInstance().roundCount ++;
      
        updateAttackInfo(   "##############################\n"+
                            "# It is your turn. Wake up.! #\n"+
                            "##############################");
        System.out.println("It is your turn. Wake up.!");
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
        getAttackInfoTextArea().update(getAttackInfoTextArea().getGraphics());
        //getAttackInfoTextArea().setCaretPosition(getAttackInfoTextArea().getText().length() - 1);
        getInstance().setAttackInfo(newOldString);
    }
    
    public static void waitFor(long halfSeconds) {
        
        try {
            /*
            long t0,t1;
            t0=System.currentTimeMillis();
            do{
            t1=System.currentTimeMillis();
            }while (t1-t0<halfSeconds *500);
            */
            Thread.sleep(halfSeconds* 500);
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
        
        System.out.println("Is player turn: " +getInstance().playerTurn);
        return getInstance().playerTurn;
    }

    public static void setPlayerTurn(boolean playerTurn) {
        getInstance().playerTurn = playerTurn;
    }
    
    
}
