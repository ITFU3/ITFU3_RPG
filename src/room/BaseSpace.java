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
   
    int height;
    int length;
    int width;
    Coordinate startPoint;
    Coordinate endPoint;
    boolean isEmpty;
    ArrayList<Item> items;
    ArrayList<PlayerCharacter> playerCharacters;
    ArrayList<MonsterCharacter> monsterCharacter;
    
    public BaseSpace() {
         this.height = 100;
         this.length = 20;
         this.width = 20;
         this.items = new ArrayList();
         this.playerCharacters = new ArrayList();
         this.isEmpty = isRoomEmpty();
         this.startPoint = new Coordinate();
         this.endPoint = new Coordinate(length, width);
         
     }
    
    public BaseSpace(int heigth, int length, int width, Coordinate startPoint, Coordinate endPoint, boolean isEmpty, ArrayList<Item> items, ArrayList<PlayerCharacter> characters) {
        this.height = heigth;
        this.length = length;
        this.width = width;
        this.startPoint = startPoint;
        this.isEmpty = isEmpty;
        this.playerCharacters = characters;
        this.items = items;
    }
    
     public BaseSpace(Coordinate startPoint, Coordinate endPoint) {
         this.height = 100;
         this.length = 20;
         this.width = 20;
         this.items = new ArrayList();
         this.playerCharacters = new ArrayList();
         this.isEmpty = isRoomEmpty();
     }
     
     public BaseSpace(Coordinate startPoint, Coordinate endPoint, ArrayList<Item> items, ArrayList<PlayerCharacter> characters) {
         this.height = 100;
         this.length = 20;
         this.width = 20;
         this.startPoint = startPoint;
         this.endPoint = endPoint;
         this.items = items;
         this.playerCharacters = characters;
     }
     
     
     
     public boolean isRoomEmpty() {
         return (items.isEmpty() && playerCharacters.isEmpty());
     }
     
     public void addItem(Item item) {
         this.items.add(item);
     }
     
     public void addCharacter(PlayerCharacter character) {
         this.playerCharacters.add(character);
     }
     
     
   
}
