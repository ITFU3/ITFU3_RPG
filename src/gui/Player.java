/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Graphics;
import main.Game;

/**
 *
 * @author steffen
 */
public class Player extends Creature {
    
    private Game game;

    public Player(Game game, float x, float y) {
        super(x, y);
        this.game = game;
    }

    @Override
    public void update() {
        /*
         if (game.getKeymanager().up) {
             y -= 3;
             
         }
         if (game.getKeymanager().down) {
             y += 3;
              
         }
         if (game.getKeymanager().left) {
             x -= 3;
            
         }
         if (game.getKeymanager().right) {
             x += 3;
             
         }
         if (game.getKeymanager().esc) {
            
            game.stop();
            game.getDisplay().getFrame().setVisible(false);
         }
                */
    }

    @Override
    public void render(Graphics g) {
        g.fillRect((int)x,(int) y, 50, 50);
    }
    
}
