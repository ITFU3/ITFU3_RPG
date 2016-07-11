/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package room;
import base.Item;
import characters.*;
import java.util.ArrayList;
import main.Die;


/**
 *
 * @author steffen
 */
public class BaseSpace {
    private ArrayList<String> roomStrings;
    private String name;
    private int height;
    private int length;
    private int width;
    private Coordinate startPoint;
    private Coordinate endPoint;
    private boolean isEmpty;
    private ArrayList<Item> items;
    private ArrayList<PlayerCharacter> playerCharacters;
    private ArrayList<MonsterCharacter> monsterCharacters;
    
    public enum Direction {
      NORTH,
      SOUTH,
      WEST,
      EAST;   
  }
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
         this.endPoint = new Coordinate(getLength(), getWidth());   
     }
    

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
     

     public BaseSpace(
             Coordinate startPoint, 
             Coordinate endPoint, 
             ArrayList<Item> items, 
             ArrayList<PlayerCharacter> playerCharacters
     
     ) {

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
         this.getItems().add(item);
     }
     

     public void addCharacter(PlayerCharacter playerCharacter) {
         this.getPlayerCharacters().add(playerCharacter);

     }
     // creates an empty RoomString
     public void createEmptyRoomString() {
         char[] northAndSouthWall = new char[getWidth()];
         char[] eastAndWestWall = new char[getWidth()];
         /// create charArrays for walls
         for (int i=0; i<getWidth(); i++) {
             northAndSouthWall[i] = '#';
             if (i==0 || i == (getWidth()-1)) {
                 eastAndWestWall[i] = '#';
             } else {
                 eastAndWestWall[i] = ' ';
             }
         } 
         /// fill roomString with Strings
         for (int i=0; i<getLength(); i++) {
             // add north and South walls
             if (i==0 || i == (getLength()-1)) {
                 getRoomStrings().add(i, String.valueOf(northAndSouthWall));
             } else {
                 getRoomStrings().add(i, String.valueOf(eastAndWestWall));
             }
         }
     }
     
     public boolean addWall(int length, Coordinate startPoint, Direction direction, boolean passable) {
         if (!areCoordinatesInMap(startPoint)) {
             System.out.println("Coordinates are not on map");
             return false;
         }
         if (direction == Direction.NORTH || direction == Direction.SOUTH) {
             if (length >= getLength()) {
                 length = getLength()-2;
             }        
         } else {
             if (length >= getWidth()) {
                 length = getWidth()-2;
             }
         }
         Coordinate coordinateOfWallElement = startPoint;
         
          
         switch (direction) {
             case NORTH: 
                 System.out.println("North"); 
                 coordinateOfWallElement.x = startPoint.x + 1;
                 break;
             case EAST:
                 System.out.println("East");
                 coordinateOfWallElement.y = startPoint.y + 1;
                 break;
             case SOUTH:
                 System.out.println("SOUTH");
                 coordinateOfWallElement.x = startPoint.x - 1;
                 break;
            default: 
                System.out.println("WEST");  
                coordinateOfWallElement.y = startPoint.y - 1;
            }   
            if (areCoordinatesInMap(coordinateOfWallElement)) {
                System.out.println("new Wallelement");
                addWallElement(coordinateOfWallElement);
                addWall(length-1, coordinateOfWallElement, direction, true);
            } else {
                System.out.println("Wallelement out of bounds when new wallElement is added");
                
            }
            
         
         
         
         
          return true; 
    }
     
     
     //adds a single Wallelement
     public boolean addWallElement(Coordinate coordinate){
         char[] roomLineStringAsCharArray = getRoomStrings().get(coordinate.y).toCharArray();
         
         roomLineStringAsCharArray[coordinate.x] = '#';
         String newPartForRoomString = String.copyValueOf(roomLineStringAsCharArray);
         ArrayList<String> newRoomString = getRoomStrings();
         newRoomString.set(coordinate.x, newPartForRoomString);
         setRoomStrings(newRoomString);
         
         return true;
     }
      
     /**
      * 
      * @param coordinate the point from where you want to check
      * @param direction the direction in which you want to check for walls
      * @param checkForCloseWall 
      * true if you want to check wall next to coordinate in set direction, 
      * false if you want to check for wall 2 space away in set direction
      * @return true is wall is close or far, false if coordinate is not 
      */
     public boolean isWallCloseOrFar(Coordinate coordinate, Direction direction, boolean checkForCloseWall) {
         int value = 2;
         if (checkForCloseWall) {
             value = 1;
         }
              
         switch (direction) {
             case NORTH: 
                 // subtract from y
                 System.out.println("North"); 
                 coordinate.y = coordinate.y -2;
                 break; 
            case EAST:
                 // add to x 
                 System.out.println("East");
                 coordinate.x = coordinate.x +2;
                 break;
             case SOUTH:
                 // add to y
                 System.out.println("SOUTH");
                 coordinate.y = coordinate.y +2;
                 break;
            default: 
                //substract from x
                System.out.println("WEST");  
                coordinate.x = coordinate.x -2;
         }
         
         return areCoordinatesInMap(coordinate);
     }
     
     public boolean areCoordinatesInMap(Coordinate coordinate) {
         if (coordinate.x < getLength() && coordinate.y < getWidth() && coordinate.x >= 0 && coordinate.y >= 0) {
             return true;
         }
         return false;
     }
     
     public Direction getRandomDirection() {
         int directionInt =  Die.rollDie(4,1);
         Direction direction;
         switch (directionInt) {
             case 1: 
                 direction = Direction.NORTH;
             case 2:
                 direction = Direction.EAST;
             case 3:
                 direction = Direction.SOUTH;
             default: 
                 direction = Direction.WEST; 
         }
         return direction;
     }
     /*
     adds a random wall 
     */
     public void randomWall() {
        
         Direction direction = getRandomDirection();
         
         int walllength = 0;
         if (direction == Direction.NORTH || direction == Direction.SOUTH) {
             walllength = Die.rollDie(getLength(), 1);
         } else {
             walllength = Die.rollDie(getWidth(), 1);
         }
         Coordinate wallStartPoint = Coordinate.getRandomCoordinate(length, width);
         addWall(walllength, wallStartPoint, direction, false);
         
     }
     
    
     
     /// print room
     public void debugSpace() {
         System.out.println("Number of Items: \t\t"+ getItems().size());
         System.out.println("Number of Characters: \t\t" + getPlayerCharacters().size());
         System.out.println("Number of Monsters: \t\t" + getMonsterCharacters().size());
         for (int i = 0; i<this.getRoomStrings().size(); i++) {
             System.out.println(getRoomStrings().get(i));
         }
     }

    /**
     * @return the roomStrings
     */
    public ArrayList<String> getRoomStrings() {
        return roomStrings;
    }

    /**
     * @param roomStrings the roomStrings to set
     */
    public void setRoomStrings(ArrayList<String> roomStrings) {
        this.roomStrings = roomStrings;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return the length
     */
    public int getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return the startPoint
     */
    public Coordinate getStartPoint() {
        return startPoint;
    }

    /**
     * @param startPoint the startPoint to set
     */
    public void setStartPoint(Coordinate startPoint) {
        this.startPoint = startPoint;
    }

    /**
     * @return the endPoint
     */
    public Coordinate getEndPoint() {
        return endPoint;
    }

    /**
     * @param endPoint the endPoint to set
     */
    public void setEndPoint(Coordinate endPoint) {
        this.endPoint = endPoint;
    }

    /**
     * @return the isEmpty
     */
    public boolean isIsEmpty() {
        return isEmpty;
    }

    /**
     * @param isEmpty the isEmpty to set
     */
    public void setIsEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    /**
     * @return the items
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    /**
     * @return the playerCharacters
     */
    public ArrayList<PlayerCharacter> getPlayerCharacters() {
        return playerCharacters;
    }

    /**
     * @param playerCharacters the playerCharacters to set
     */
    public void setPlayerCharacters(ArrayList<PlayerCharacter> playerCharacters) {
        this.playerCharacters = playerCharacters;
    }

    /**
     * @return the monsterCharacters
     */
    public ArrayList<MonsterCharacter> getMonsterCharacters() {
        return monsterCharacters;
    }

    /**
     * @param monsterCharacters the monsterCharacters to set
     */
    public void setMonsterCharacters(ArrayList<MonsterCharacter> monsterCharacters) {
        this.monsterCharacters = monsterCharacters;
    }
     
    
   
}
