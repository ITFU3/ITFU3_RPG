/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package room;
import Base.Item;
import characters.*;
import java.util.ArrayList;

/**
 *
 * @author steffen
 */
public class BaseSpace {
    int height;
    int length;
    int width;
    Coordinate startPoint;
    Coordinate endPoint;
    boolean isEmpty;
    ArrayList<Item> items;
    ArrayList<Character> characters;
    
    public BaseSpace() {
         this.height = 100;
         this.length = 20;
         this.width = 20;
         this.items = new ArrayList();
         this.characters = new ArrayList();
         this.isEmpty = isRoomEmpty();
         this.startPoint = new Coordinate();
         this.endPoint = new Coordinate(length, width);
         
     }
    
    public BaseSpace(int heigth, int length, int width, Coordinate startPoint, Coordinate endPoint, boolean isEmpty, ArrayList<Item> items, ArrayList<Character> characters) {
        this.height = heigth;
        this.length = length;
        this.width = width;
        this.startPoint = startPoint;
        this.isEmpty = isEmpty;
        this.characters = characters;
        this.items = items;
    }
    
     public BaseSpace(Coordinate startPoint, Coordinate endPoint) {
         this.height = 100;
         this.length = 20;
         this.width = 20;
         this.items = new ArrayList();
         this.characters = new ArrayList();
         this.isEmpty = isRoomEmpty();
     }
     
     public BaseSpace(Coordinate startPoint, Coordinate endPoint, ArrayList<Item> items, ArrayList<Character> characters) {
         this.height = 100;
         this.length = 20;
         this.width = 20;
         this.startPoint = startPoint;
         this.endPoint = endPoint;
         this.items = items;
         this.characters = characters;
     }
     
     
     
     public boolean isRoomEmpty() {
         return (items.isEmpty() && characters.isEmpty());
     }
     
     public void addItem(Item item) {
         this.items.add(item);
     }
     
     public void addCharacter(Character character) {
         this.characters.add(character);
     }
     
     
   
}
