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
        Map.getInstance().walkOnMap( "up" , 2 , 1 , true );
        Game.updateGUI();
    }
    
    public static void upRight() {
        
    }
    
    public static void right() {
        Map.getInstance().walkOnMap( "right" , 2 , 1 , true );
        Game.updateGUI();
    }
    
    public static void downRight() {
        
    }
    
    public static void down() {
        Map.getInstance().walkOnMap( "down" , 2 , 1 , true );
        Game.updateGUI();
    }
    
    public static void downLeft() {
        
    }
    
    public static void left() {
        Map.getInstance().walkOnMap( "left" , 2 , 1 , true );
        Game.updateGUI();
    }
    
    public static void upLeft() {
        
    }
    
}