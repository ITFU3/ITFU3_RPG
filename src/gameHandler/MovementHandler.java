
package gameHandler;

import Enum.MoveDirection;
import character.PlayerCharacter;
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
    
    public static void move(PlayerCharacter pc, MoveDirection direction){
        int steps = 1;
        String directionString = "";
        switch (direction) {
            case UP:
               directionString = "up";
                break;
            case RIGHT:
                directionString = "right";
                break;
            case DOWN:
                directionString = "down";
                break;
            case LEFT:
                directionString = "left";
                break;
        }
        int tempMovement = pc.getAllowedMoves();
        // ( direction | movement pool | steps to do | player identifier )        
        tempMovement = Map.getInstance().walkOnMap(
            directionString, tempMovement, steps, pc
        );
        pc.setAllowedMoves( tempMovement );
        
        Game.updateGUI();
    }
    
}