
package gameHandler;

import main.*;

/**
 *
 * @author Steffen Haas
 * @author Matthias Dröge
 */
public class MovementHandler {    
    /*
        DONE: Asks TurnHandler whose turn it is
                Or take them directliy from game.player
        DONE: Tell Map, whom to move
        DONE: Tells game to update / redraws
    */
    private static void move(String direction){
        int steps = 1;
        int tempMovement = Game.getInstance().getPlayer().getAllowedMoves();
        // ( direction | movement pool | steps to do | player identifier )        
        tempMovement = Map.getInstance().walkOnMap(
            direction, tempMovement, steps, Game.getInstance().getPlayer()
        );
        Game.getInstance().getPlayer().setAllowedMoves( tempMovement );
        Game.updateGUI();
    }
    public static void up(){ move("up"); }
    
    public static void upRight(){ }
    
    public static void right(){ move("right"); }
    
    public static void downRight(){ }
    
    public static void down(){ move("down"); }
    
    public static void downLeft(){ }
    
    public static void left(){ move("left"); }
    
    public static void upLeft() { }
}