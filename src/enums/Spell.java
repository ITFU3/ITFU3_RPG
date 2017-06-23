/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

/**
 *
 * @author steffen
 */
public enum Spell {
    
    HEALINGWORD("HealingWord"), FIREBALL("Fireball"), NONE("none");
    
    public String string;
      
    private Spell(String value) {
        this.string = value;
    }
    
    
    
}
