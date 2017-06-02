/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import gui.Player;
import java.awt.Graphics;
import main.Game;

/**
 *
 * @author steffen
 */
public class GameState extends State{

    private Player player;

    public GameState(Game game) {
        super(game);
        this.player =  new Player(game, 50, 50);
    }
    
    @Override
    public void update() {
        player.update();
      
    }

    @Override
    public void render(Graphics g) {
      player.render(g);
    }
    
}
