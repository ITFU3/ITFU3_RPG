
package gameHandler;

import main.*;

/**
 *
 * @author Steffen Haas
 * @author Matthias Dröge
 */
public class MovementHandler {    
    /*
        TODO: Asks TurnHandler whose turn it is
        DONE: Tell Map, whom to move
        DONE: Tells game to update / redraws
    */
    
    public static void up() {
        // TODO: Getting Params for walkOnMap!!
        // ( direction | movement pool | steps to do | player identifier )
        Game.getInstance().getPlayer().setAllowedMoves(
            Map.getInstance().walkOnMap(
                "up",
                Game.getInstance().getPlayer().getAllowedMoves(),
                1,
                true
            )
        );
        Game.updateGUI();
    }
    
    public static void upRight() {
        
    }
    
    public static void right() {
        Game.getInstance().getPlayer().setAllowedMoves(
            Map.getInstance().walkOnMap(
                "right",
                Game.getInstance().getPlayer().getAllowedMoves(),
                1,
                true
            )
        );
        Game.updateGUI();
    }
    
    public static void downRight() {
        
    }
    
    public static void down() {
        Game.getInstance().getPlayer().setAllowedMoves(
            Map.getInstance().walkOnMap(
                "down",
                Game.getInstance().getPlayer().getAllowedMoves(),
                1,
                true
            )
        );
        Game.updateGUI();
    }
    
    public static void downLeft() {
        
    }
    
    public static void left() {
       Game.getInstance().getPlayer().setAllowedMoves(
            Map.getInstance().walkOnMap(
                    "left",
                Game.getInstance().getPlayer().getAllowedMoves(),
                1,
                true
            )
        );
        Game.updateGUI();
    }
    
    public static void upLeft() {
        
    }
    
}

