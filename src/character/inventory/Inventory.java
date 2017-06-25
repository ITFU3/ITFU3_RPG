package character.inventory;

import character.item.Item;
import java.util.ArrayList;

/**
 *
 * @author Matthias Dröge
 */
public class Inventory {
    String type;
    int maxSlots;
    ArrayList<Item> slots;

    public Inventory(){
        this.setType(this.getClass().getSimpleName());
        this.setMaxSlots(0);
        this.setSlots(new ArrayList());
    }

    public Inventory(int maxSlots, ArrayList<Item> slots){
        this();
        this.setMaxSlots( maxSlots );
        this.setSlots( slots );
    }
    
    /**
     * putting a given item in the inventory
     * 
     * @param newItem - Item
     * @return true / false
     */
    public boolean storeItem(Item newItem){
        if( (this.getSlots().size() + 1) <= this.getMaxSlots() ){
            this.getSlots().add(newItem);
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * removing a specific item from the inventory
     * 
     * @param index - int
     * @return true / false
     */
    public boolean dropItem(int index){
        if( this.getSlots().size() > 0 ){
            this.getSlots().remove(index);
            return true;
        }else{
            return false;
        }
    }

    /**
     * returning a specific item from inventory and removing it from it.
     * 
     * @param index
     * @return 
     */
    public Item equipItem(int index){
        Item output = this.getSlots().get(index);
        this.getSlots().remove(index);
        return output;
    }
    
    
    // ##### GETTER AND SETTER #####
    public int getMaxSlots() {
        return maxSlots;
    }
    public void setMaxSlots(int maxSlots) {
        this.maxSlots = maxSlots;
    }
    public ArrayList<Item> getSlots() {
        return slots;
    }
    public void setSlots(ArrayList<Item> slots) {
        this.slots = slots;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}