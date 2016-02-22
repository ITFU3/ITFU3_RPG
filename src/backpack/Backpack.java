/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backpack;
import characters.*;
/**
 *
 * @author steffen
 */
public class Backpack {
    
    double pStrength;
    Object[] backpack;
    int baseBackpackSpaces = 6;
    
    public Backpack() {
        this.backpack = new Object[baseBackpackSpaces];
    }
    
}
