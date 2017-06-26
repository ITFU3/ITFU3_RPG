/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package character.item.weapons;

import enums.Proficiency;

/**
 *
 * @author Steffen Haas
 */
public class Bow  extends Weapon {
    
    public static Bow SHORTBOW = getShortBow();
    public static Bow LONGBOW = getLongBow();
    
    public Bow() {
        super();
        this.setCat(Proficiency.WEAPON_TYPE_RANGE);
        this.setWeaponGroup(Proficiency.WEAPON_GROUP_SIMPLE);
        this.getProperties().add(Proficiency.DUALHANDED);
    }
    
    public Bow(String name, int damageDie, int durability, int dieCount, Proficiency type, Proficiency cat, int distance, Proficiency weaponGroup) {
        super(name, damageDie, durability, dieCount, type, cat, distance, weaponGroup);
    }
    
    public Bow(Proficiency type) {
        super(type);
    }
    
    private static Bow getShortBow() {
        Bow shortbow = new Bow();
        shortbow.setDamageDie(8);
        shortbow.setDieCount(1);
        shortbow.setDistance(10);
        shortbow.setType(Proficiency.WEAPON_SHORTBOW);
        shortbow.setCat(Proficiency.WEAPON_TYPE_RANGE);
        shortbow.setWeaponGroup(Proficiency.WEAPON_GROUP_SIMPLE);
        return shortbow;
    }
    
    private static Bow getLongBow() {
        Bow longbow = new Bow();
        longbow.setDamageDie(8);
        longbow.setDistance(12);
        longbow.setType(Proficiency.WEAPON_LONGBOW);
        longbow.setCat(Proficiency.WEAPON_TYPE_RANGE);
        longbow.setWeaponGroup(Proficiency.WEAPON_GROUP_MARTIAL);
        return longbow;
    }

   
    
    
    
    
    
    
    
    
    
}
