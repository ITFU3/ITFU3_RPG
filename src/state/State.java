/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import java.awt.Graphics;
import main.Game;

/**
 *
 * @author steffen
 */
public abstract class State {
    
    private static State currentState = null;
    
    protected Game game;

    public State(Game game) {
        this.game = game;
    }

    
    public static void setCurrentState(State currentState) {
        State.currentState = currentState;
    }

    public static State getCurrentState() {
        return currentState;
    }
    
    
    // Methods
    public abstract void update();
    public abstract void render(Graphics g);
    
    
}
