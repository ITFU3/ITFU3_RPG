/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import gameHandler.KeyManager;
import gui.ArenaDisplay;
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

    private ArenaDisplay display;
    
    private Thread thread;
    // graphis
    private BufferStrategy bs;
    private Graphics g;
    
    // States
    private State gameState;
    
    
    // Input
    private KeyManager keymanager;
    private boolean running = false;
    
    public int width, height;
    public String title;
    
    
    
    
    
    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        
        keymanager = new KeyManager();
        
  
    }

    private void init() {
        display = new ArenaDisplay(title, width, height);
        display.getFrame().addKeyListener(keymanager);
        
        gameState = new GameState(this);
        State.setCurrentState(gameState);
    }
    
    private void update() {
        keymanager.update();
        if (State.getCurrentState() != null) {
            State.getCurrentState().update();
        }
    }
    int x = 50;
    int fps = 60;
    double timePerTick = 1000000000 / fps;
    double delta = 0;
    long now;
    long lastTime = System.nanoTime();
    
    
    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0, 0, width, height);
         // Draw here
        if (State.getCurrentState() != null) {
            State.getCurrentState().render(g);
        }
        // end Draw
        bs.show();
        g.dispose();
    }
    
    @Override
    public void run() {
        init();
        
        // Game Loop
        while (running) {
            now = System.nanoTime();
            delta += (now-lastTime) / timePerTick;
            lastTime = now;
            
            if (delta >= 1) {
                update();
                render(); 
            }
        }
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

    public ArenaDisplay getDisplay() {
        return display;
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
