package main;

import character.MonsterCharacter;
import character.PlayerCharacter;
import gameHandler.KeyHandler;
import gameHandler.MonsterAI;
import gui.GameFrame;
import gui.GuiHelper.HealthBarLabel;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Steffen Haas
 */
public class Game implements Runnable{
    
    public static Game instance;
    
    private PlayerCharacter player;
    private ArrayList<MonsterCharacter> monsters  = new ArrayList<MonsterCharacter>();
    
    private int level;
    
    private GameFrame gameFrame;
    public int width, height;
    public String title = "Death's domain";
    
    public String attackInfo = "";
    public String monsterInfo = "";
    
    
    private Thread thread;
    
    private boolean playing = true;
    
    // Input
    private KeyHandler keymanager;
    private boolean running = false;
    
    
    
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

    @Override
    public void run() {
        init();
        // Game Logic
        
        stop();
    }
    
    public synchronized void start() {
        if(!running){
            running = true;
            thread = new Thread(this);
            thread.start();
        } 
    }
    
    public synchronized void stop() {
        if (running){
            running = false;
            try{
                thread.join();
            }catch(InterruptedException ex){
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void updateGUI(){
        
        getInstance().getGameFrame().getArenaTextArea().setText(Map.getInstance().getMap());
        System.out.println(Map.getInstance().getMap());
       
        getInstance().getGameFrame().getAttackInfoTextArea().setText(getInstance().attackInfo);
        getInstance().getGameFrame().getMonsterInfoTextArea().setText(getInstance().monsterInfo);
        getInstance().getGameFrame().getValueMovesLeftLabel().setText(String.valueOf(getInstance().getPlayer().getAllowedMoves()));
        getInstance().getGameFrame().getValueAttacksLeftLabel().setText(String.valueOf(getInstance().getPlayer().getAllowedAttacks()));
        System.out.println("GUI UPDATE");
    }
    
    public static void updateMonsterInfo() {
        ArrayList<MonsterCharacter> monsters = getInstance().getMonsters();
        String newMonsterInfo = "Monsters in Arena: " +monsters.size() +"\n";
        
        for (MonsterCharacter monster : monsters) {
            newMonsterInfo += monster.getName() + "\n"+
                    monster.getTempHP() + "/"+monster.getHealth()+ "\n";
        }
        getInstance().setMonsterInfo(newMonsterInfo);

    }
    
    public void nextLevel(){
        Map.getInstance().spawnRandomMonster(++this.level);
        Game.updateGUI();
    }
    
    public PlayerCharacter getPlayer() {
        return player;
    }
    public void setPlayer(PlayerCharacter player) {
        this.player = player;
    }
    public ArrayList<MonsterCharacter> getMonsters() {
        return monsters;
    }
    public void setMonsters(ArrayList<MonsterCharacter> monsters) {
        this.monsters = monsters;
    }
    public void addMonster(MonsterCharacter monster){
        this.getMonsters().add(monster);
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
    
    
    
    
}