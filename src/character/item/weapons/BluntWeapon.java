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
        // Basics
        this.setDieCount(1);
        this.setDistance(1);
        this.setDurability(100);
        this.setCat(Proficiency.WEAPON_TYPE_MELEE);
        this.getProperties().add(Proficiency.SINGLEHANDED);
        this.setWeaponGroup(Proficiency.SIMPLE_WEAPONS);
        
    }

    public BluntWeapon(String name, int damageDie, int durability, int dieCount, Proficiency type, Proficiency cat, int distance, Proficiency weaponGroup) {
        super(name, damageDie, durability, dieCount, type, cat, distance, weaponGroup);
    }

    public BluntWeapon(Proficiency type) {
        super(type);
    }
    
    public static BluntWeapon getMace() {
        
        BluntWeapon mace = new BluntWeapon();
        mace.setName(Weapon.getSimpleName(Proficiency.WEAPON_MACE));
        mace.setDamageDie(6);
        mace.setType(Proficiency.WEAPON_MACE);
        return mace;
    }
    
}
