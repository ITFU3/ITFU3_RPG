/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characters;

/**
 *
 * @author sven-oliverpatzel
 */
public class MovementHandler {
    
   /**
    * Holds the direction  
    */
   public enum Direction{
       NORTH, SOUTH, WEST, EAST
   }
   
   
   /**
    * This methodes 
    * @param direction 
    */
   public void goDirection(Direction direction){
       
       switch (direction){
           case NORTH:
               System.out.println("Head North");
               //TODO create 
               break;
           case SOUTH:
                System.out.println("Head South");
               break;
               
           case WEST:
                System.out.println("Head West");
               break;
               
           case EAST:
                System.out.println("Head East");
               break;
       }
   }
    
    
}
