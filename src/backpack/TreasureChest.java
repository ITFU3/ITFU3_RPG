/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backpack;

/**
 *
 * @author steffen
 */
public class TreasureChest extends Bag {
    
    public TreasureChest() {
        this.allowedTotalWeight = 10000000000000000000000.0;
        this.maxNumberOfItems = 100;
        this.space = 100;
        
    }
}
