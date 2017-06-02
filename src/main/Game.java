/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import gameHandler.KeyManager;
import gui.ArenaDisplay;
import gui.GameFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;
import state.GameState;
import state.State;

/**
 *
 * @author steffen
 */
public class Game implements Runnable{
    
    private Game instance;

    private GameFrame gameGui;
    
    private Thread thread;
      
    // Input
    private KeyManager keymanager;
    private boolean running = false;
    
    public int width, height;
    public String title;
    
    public Game() {
        
    }

    public Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }
    
    

    private void init() {
        gameGui = new GameFrame();
        
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

    public GameFrame getGameGui() {
        return gameGui;
    }

   

    public KeyManager getKeymanager() {
        return keymanager;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
    
    
    
    
    
}
