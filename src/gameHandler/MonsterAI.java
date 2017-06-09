/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package gameHandler;

import Enum.MoveDirection;
import java.util.ArrayList;
import character.*;
import main.Die;
import main.Game;
import main.Map;
/**
 *
 * @author steffen
 */
public class MonsterAI {
    MonsterCharacter ego;
    ArrayList<MoveDirection> moves = new ArrayList();
    int mX;
    int mY;
    
    public MonsterAI (MonsterCharacter monster) {
        this.ego = monster;
        int[]position = ego.getCoordinates();
        this.mY = position[0];
        this.mX = position[1];
        System.out.println("Monster Y" + this.mY);
        System.out.println("Monster X" + this.mX);
    }
    
    
    public void calcMovesToPlayer() {
        int[] coords = main.Game.getPlayer().getCoordinates();
        int playerY = coords[0];
        int playerX = coords[1];
        System.out.println("Player X" + playerX);
        System.out.println("Player Y" + playerY);
        
        int differenceX = playerX - mX;
        int differenceY = playerY - mY;
        /*
        0,0    0,6
        #######
        #     #
        #     #
        #######
        3,0    3,6
        */
        MoveDirection directionX = MoveDirection.RIGHT;
        if (differenceX < 0) {
            differenceX = differenceX * (-1);
            directionX = MoveDirection.LEFT;
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
    /*
    moves Monster randomly anlong move path
    */
    public void move() {
        int index = Die.rollDie(moves.size(), 1) -1; // because dice done have no zero
        MovementHandler.move(ego, moves.get(index));
        Game.updateGUI();
        moves.remove(index);
    }
    // checks if Monster can attack
    public boolean isInAttackRange() {
       int distance = Map.getInstance().getDistance(Game.getPlayer(), ego);
        System.out.println("\n Monster is "+ distance+" away."); 
        System.out.println("\n Monster can attack in a range of "+ ego.getpWeapon().getDistance()+".");
       if (distance <= ego.getpWeapon().getDistance()) {
           System.out.println("IS IN RANGE");
           return true;
       }
       System.out.println("IS NOT RANGE");
        return false;
    }
    // test if in range else moves towards player
    public void think() {
        boolean next;
        do{
            long t0,t1;
            t0=System.currentTimeMillis();
            System.out.println("MONSTER:"+ego.getName()+" thinks");
            do{
                 t1=System.currentTimeMillis();
            }while (t1-t0<1000);
            
            System.out.println("MONSTER:"+ego.getName()+" acts");
        
            if (isInAttackRange() == true) {
                Game.getInstance().setAttackInfo(Game.getInstance().attackInfo + "\n" + ego.getName() + " is in Range.");
                
                if (ego.getAllowedAttacks() > 0) {
                    
                    Game.getInstance().setAttackInfo(Game.getInstance().attackInfo + "\n"+ ego.getName() + " Attacks");
                    String  guiAttackInfo = BattleHandler.tryToAttack(ego, Game.getPlayer());
                    Game.getInstance().setAttackInfo(guiAttackInfo);
                    ego.setAllowedAttacks(ego.getAllowedAttacks()-1);
                    next = true;
                } else {
                    Game.getInstance().setAttackInfo(Game.getInstance().attackInfo + "\n"+ ego.getName()+" can't attack anymore.");
                    next = false;
                    // monster is in range and does not want to run away 
                    // here ends round for monstere
                }
            } else {
                if (ego.getAllowedMoves() > 0) {
                    System.out.println("MONSTER:" + ego.getName()+"moves");
                    move();
                    next = true;
                } else {
                    next = false; // cant move and cant attack since not in range
                }
            }
        } while(next);
    }
}