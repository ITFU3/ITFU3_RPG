/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backpack;
import java.util.ArrayList;

/**
 *
 * @author steffen
 */
public class TreasureChest extends Bag {
    
    boolean locked;
    
    public TreasureChest() {
        this.allowedTotalWeight = 10000000000000000000000.0;
        this.maxNumberOfItems = 10;
        this.space = 100;
        this.items = new ArrayList();
        this.currentWeigth = 0;
        this.locked = false;
    }
}
