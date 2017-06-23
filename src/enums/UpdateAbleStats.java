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
public enum UpdateAbleStats {
    STRENGTH("strength"), 
    DEXTERITY("dexterityy"),
    CONSTITUTION("constitution"),
    WISDOM("wisdom"),
    INTELLEGENCE("intellegence"),
    CHARISMA("charisma"),
    MOVEMENT("movement"),
    ATTACKS("attacks"),
    HEALTH("health");
    
    public String string;
    private UpdateAbleStats(String s) {
        this.string = s;
    }

    @Override
    public String toString() {
        return this.string;
    }
    
    
}
