/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backpack;
import baseStats.*;
/**
 *
 * @author steffen
 */
public class Bag {
    
    int space;
    BaseObject[] objects;
    double allowedTotalWeight;
    double currentWeigth;
    
    public Bag(int space, BaseObject[] objects, int characterStrength, double armorCategory) {
        this.space = space;
        this.objects = objects;
        this.currentWeigth = setCurrentWeigth();
        this.allowedTotalWeight = characterStrength * armorCategory * 100;
    }
    
    private double setCurrentWeigth() {
        double objectsWeigth = 0.0;
        for (int i = 0; i< objects.length; i++) {
            objectsWeigth += objects[i].weight;
        }
        return objectsWeigth;
    }
    /// add object to objectd in Bag
    public boolean addObject(BaseObject object) {
        if (object.weight + currentWeigth > allowedTotalWeight) {
            BaseObject[] newObjects = new BaseObject[objects.length];
            for (int i = 0; i<objects.length; i++) {
                newObjects[i] = object[i];
            }
            newObjects[objects.length] = object;
            return true;
        }
        return false;
    }
    
}
