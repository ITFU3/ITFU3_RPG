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
public class Axe extends Weapon{
    
    public static Axe HANDAXE = getHandAxe();

    public Axe() {
        this.setDieCount(1);
        this.setDistance(1);
        this.setCat(Proficiency.WEAPON_TYPE_MELEE);
        this.setWeaponGroup(Proficiency.WEAPON_GROUP_SIMPLE);
    }

    public Axe(String name, int damageDie, int durability, int dieCount, Proficiency type, Proficiency cat, int distance, Proficiency weaponGroup) {
        super(name, damageDie, durability, dieCount, type, cat, distance, weaponGroup);
    }

    public Axe(Proficiency type) {
        super(type);
    }
    
    private static Axe getHandAxe() {
        Axe handaxe = new Axe();
        handaxe.setDamageDie(6);
        handaxe.setDieCount(1);
        handaxe.setType(Proficiency.WEAPON_HANDAXE);
        handaxe.getProperties().add(Proficiency.PROPERTY_SINGLEHANDED);
        return handaxe;
    }
    
}
