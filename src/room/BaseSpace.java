/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package room;
import base.Item;
import characters.*;
import java.util.ArrayList;

/**
 *
 * @author steffen
 */
public class BaseSpace {
    ArrayList<String> roomStrings;
    String name;
    int height;
    int length;
    int width;
    Coordinate startPoint;
    Coordinate endPoint;
    boolean isEmpty;
    ArrayList<Item> items;
    ArrayList<PlayerCharacter> playerCharacters;
    ArrayList<MonsterCharacter> monsterCharacters;
    
    
    /*
    Construktor for empty room
    */
    public BaseSpace() {
         this.roomStrings = new ArrayList();
         this.name = "Simple Space";
         this.height = 100;
         this.length = 20;
         this.width = 20;
         this.roomStrings = new ArrayList();
         this.items = new ArrayList();
         this.playerCharacters = new ArrayList();
         this.monsterCharacters = new ArrayList();
         this.isEmpty = isRoomEmpty();
         this.startPoint = new Coordinate();
         this.endPoint = new Coordinate(length, width);   
     }
    
<<<<<<< HEAD
    public BaseSpace(
            ArrayList<String> roomStrings,
            int heigth, 
            int length, 
            int width, 
            Coordinate startPoint, 
            Coordinate endPoint, 
            boolean isEmpty, 
            ArrayList<Item> items, 
            ArrayList<PlayerCharacter> playerCharacters, 
            ArrayList<MonsterCharacter> monsterCharacters
    ) {
        this.roomStrings = roomStrings;
=======
    public BaseSpace(int heigth, int length, int width, Coordinate startPoint, Coordinate endPoint, boolean isEmpty, ArrayList<Item> items, ArrayList<PlayerCharacter> characters) {
>>>>>>> 5af07f14cfe5fd97103c929369f381652a698bcf
        this.height = heigth;
        this.length = length;
        this.width = width;
        this.startPoint = startPoint;
        this.isEmpty = isEmpty;
        this.playerCharacters = playerCharacters;
        this.monsterCharacters = monsterCharacters;
        this.items = items;
    }
    /*
    empty room but coordinates for Entry and Exit can be set
    */
     public BaseSpace(
             Coordinate startPoint, 
             Coordinate endPoint
     ) {
         this.roomStrings = new ArrayList();
         this.height = 100;
         this.length = 20;
         this.width = 20;
         this.items = new ArrayList();
         this.playerCharacters = new ArrayList();
         this.monsterCharacters = new ArrayList();
         this.isEmpty = isRoomEmpty();
     }
     
<<<<<<< HEAD
     public BaseSpace(
             Coordinate startPoint, 
             Coordinate endPoint, 
             ArrayList<Item> items, 
             ArrayList<PlayerCharacter> playerCharacters) {
=======
     public BaseSpace(Coordinate startPoint, Coordinate endPoint, ArrayList<Item> items, ArrayList<PlayerCharacter> characters) {
>>>>>>> 5af07f14cfe5fd97103c929369f381652a698bcf
         this.height = 100;
         this.length = 20;
         this.width = 20;
         this.startPoint = startPoint;
         this.endPoint = endPoint;
         this.items = items;
         this.playerCharacters = playerCharacters;
     }
     
         public BaseSpace(
            int length, 
            int width 
        ) {
        this.roomStrings = new ArrayList();
        this.height = 100;
        this.length = length;
        this.width = width;
        this.startPoint = new Coordinate(1, 1);
        this.endPoint = new Coordinate (length-1, width-1);
        this.isEmpty = isEmpty;
        this.playerCharacters = new ArrayList();;
        this.monsterCharacters = new ArrayList();;
        this.items = new ArrayList();;
    }
     
     
     
     public boolean isRoomEmpty() {
         
         //return (items.isEmpty() && playerCharacters.isEmpty() && monsterCharacters.isEmpty());
         return true;
     }
     
     public void addItem(Item item) {
         this.items.add(item);
     }
     
<<<<<<< HEAD
     public void addCharacter(PlayerCharacter playerCharacter) {
         this.playerCharacters.add(playerCharacter);
=======
     public void addCharacter(PlayerCharacter character) {
         this.playerCharacters.add(character);
>>>>>>> 5af07f14cfe5fd97103c929369f381652a698bcf
     }
     
     public void createEmptyRoomString() {
         char[] northAndSouthWall = new char[width];
         char[] eastAndWestWall = new char[width];
         /// create charArrays for walls
         for (int i=0; i<width; i++) {
             northAndSouthWall[i] = '#';
             if (i==0 || i == (width-1)) {
                 eastAndWestWall[i] = '#';
             } else {
                 eastAndWestWall[i] = ' ';
             }
         } 
         /// fill roomString with Strings
         for (int i=0; i<length; i++) {
             // add north and South walls
             if (i==0 || i == (length-1)) {
                 roomStrings.add(i, String.valueOf(northAndSouthWall));
             } else {
                 roomStrings.add(i, String.valueOf(eastAndWestWall));
             }
         }
     }
     /// print room
     public void debugSpace() {
         System.out.println("Number of Items: \t\t"+ items.size());
         System.out.println("Number of Characters: \t\t" + playerCharacters.size());
         System.out.println("Number of Monsters: \t\t" + monsterCharacters.size());
         for (int i = 0; i<this.roomStrings.size(); i++) {
             System.out.println(roomStrings.get(i));
         }
     }
     
   
}
