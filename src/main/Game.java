/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import characters.MonsterCharacter;
import characters.PlayerCharacter;
import gameHandler.KeyHandler;
import gui.ArenaDisplay;
import gui.GameFrame;
import gui.Player;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import state.GameState;
import state.State;

/**
 *
 * @author steffen
 */
public class Game implements Runnable{
    
    public static Game instance;
    
    private PlayerCharacter player;
    private ArrayList<MonsterCharacter> monsters  = new ArrayList<MonsterCharacter>();
   

    private GameFrame gameFrame;
    
    private Thread thread;
      
    // Input
    private KeyHandler keymanager;
    private boolean running = false;
    
    public int width, height;
    public String title = "Death's domain";
    
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
    
    
    
    @Override
    public void run() {
        init();
        
        // Game Logic
        
        stop();
    }
    
    public synchronized void start() {
        if (running) {
            return;
        }
        
        running = true;
        thread = new Thread(this);
        thread.start();
        
    }
    
    public synchronized void stop() {
        if (!running) {
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    
    
    
    
}
