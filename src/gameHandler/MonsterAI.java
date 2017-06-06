/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package gameHandler;

import Enum.MoveDirection;
import java.util.ArrayList;
import main.Map;

/**
 *
 * @author steffen
 */
public class MonsterAI {
    
    ArrayList<MoveDirection> moves = new ArrayList<MoveDirection>();
    int mX;
    int mY;
    
    public MonsterAI (int x, int y) {
        this.mX = x;
        this.mY = y;
        System.out.println("Monster X" + x);
        System.out.println("Monster Y" + y);
    }
    
    
    public void calcMovesToPlayer() {
        int playerX = Map.getInstance().getPlayerX();
        int playerY = Map.getInstance().getPlayerY();
         System.out.println("Player X" + playerX);
        System.out.println("Player Y" + playerY);
        
        int differenceX = playerX - mX;
        int differenceY = playerY - mY;
        
        MoveDirection directionX = MoveDirection.LEFT;
        if (differenceX < 0) {
            differenceX = differenceX * (-1);
            directionX = MoveDirection.RIGHT;
        }
        if(differenceX != 0) {
            for (int i = 0; i < differenceX; i++) {
                moves.add(directionX);
            }
        }
        
        
        MoveDirection directionY = MoveDirection.DOWN;
        if (differenceY < 0) {
            differenceY = differenceY * (-1);
            directionY = MoveDirection.UP;
        }
        
        if(differenceY != 0) {
            for (int i = 0; i < differenceY; i++) {
                moves.add(directionY);
            }
        }
        System.out.println("MOVES");
        System.out.println(moves.toString());
    }
    
    
    
    
}
