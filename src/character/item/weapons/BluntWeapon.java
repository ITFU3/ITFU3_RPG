/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character.item.weapons;

import enums.Proficiency;

/**
 *
 * @author steffen
 */
public class BluntWeapon extends Weapon{
    
    public static BluntWeapon MACE = getMace();

    public BluntWeapon() {
        super();
        this.setCat(Proficiency.WEAPON_TYPE_MELEE);
        this.setWeaponGroup(Proficiency.WEAPON_GROUP_SIMPLE);
        this.getProperties().add(Proficiency.PROPERTY_SINGLEHANDED);
    }

    public BluntWeapon(String name, int damageDie, int durability, int dieCount, Proficiency type, Proficiency cat, int distance, Proficiency weaponGroup) {
        super(name, damageDie, durability, dieCount, type, cat, distance, weaponGroup);
    }

    public BluntWeapon(Proficiency type) {
        super(type);
    }
    
    public static BluntWeapon getMace() {
        BluntWeapon mace = new BluntWeapon();
        mace.setDamageDie(6);
        mace.setDieCount(1);
        mace.setType(Proficiency.WEAPON_MACE);
        mace.getProperties().add(Proficiency.PROPERTY_SINGLEHANDED);
        return mace;
    }
    
    public static BluntWeapon getMaul(){
        BluntWeapon maul = new BluntWeapon();
        maul.setDamageDie(10);
        maul.setDieCount(1);
        maul.setType(Proficiency.WEAPON_MAUL);
        maul.getProperties().add(Proficiency.PROPERTY_DUALHANDED);
        return maul;
    }
    
}
