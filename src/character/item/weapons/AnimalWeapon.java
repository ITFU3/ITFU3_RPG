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
public class AnimalWeapon extends Weapon {

    public static AnimalWeapon CLAW = getClaws();
    
    public AnimalWeapon() {
        this.setDurability(100);
        this.setDamageDie(10);
        this.setDistance(1);
        this.setDieCount(1);
        this.setCat(Proficiency.WEAPON_TYPE_MELEE);
        this.setWeaponGroup(Proficiency.WEAPON_GROUP_SIMPLE);
    }

    private static AnimalWeapon getClaws() {
        
        AnimalWeapon claw = new AnimalWeapon();
        claw.setType(Proficiency.WEAPON_HAND);
        claw.setName(Proficiency.WEAPON_HAND.name());
        claw.setDistance(2);
        claw.getProperties().add(Proficiency.DUALHANDED);
        claw.getProperties().add(Proficiency.REACH);
    return claw;
 
    }
    
    
    
}
