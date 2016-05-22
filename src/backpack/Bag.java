/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backpack;
import base.Item;
import java.util.ArrayList;
/**
 *
 * @author steffen
 */
public class Bag {
    
    int space;
    ArrayList<Item> items;
    double allowedTotalWeight;
    double currentWeigth = 0.0;
    int maxNumberOfItems = 3;
    
    public Bag() {
        this.space = 20;
        this.allowedTotalWeight = 100;
        // three as base
        this.items = new ArrayList();
        
        
    }
    
    public Bag(ArrayList<Item> items, int characterStrength, double armorCategory) {
        
        this.space = 20;
        this.items = items;
        this.currentWeigth = setCurrentWeigth();
        // to be defined how much can go into bags etc with 
        this.allowedTotalWeight = characterStrength * armorCategory * 100;
    }
    
    private double setCurrentWeigth() {
        double objectsWeigth = 0.0;
        for (int i = 0; i< items.size(); i++) {
            objectsWeigth += items.get(i).getWeigth();
        }
        return objectsWeigth;
    }
    /// add object to objectd in Bag
    // returns true if success
    // returns false if no success
    public boolean addItem(Item item) {
        //TODO: to heavy or out of bounds
        if (item.getWeigth() + currentWeigth < allowedTotalWeight) {
            if (items.size() + 1 < this.maxNumberOfItems) {
               this.items.add(item);
            return true; 
            } else {
                return false;  
            }
        } else {
            return false;
        }
    }
    
}
