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
 *
 */
public class Sword extends Weapon{
   
    public static Sword LONGSWORD = getLongsword();
    
    public Sword() {
        this.setCat(Proficiency.WEAPON_TYPE_MELEE);
        this.setDieCount(1);
        this.setDurability(100);
        
    }
    
    public Sword(String name, int damageDie, int durability, int dieCount, Proficiency type, Proficiency cat, int distance, Proficiency weaponGroup) {
        super(name, damageDie, durability, dieCount, type, cat, distance, weaponGroup);
    }
    
    public Sword(Proficiency type) {
        super(type);
    }
    
    private static Sword getLongsword() {
        
        Sword longsword = new Sword();
        longsword.setName("Simple " + Proficiency.WEAPON_LONGSWORD);
        longsword.setDamageDie(8);
        longsword.setType(Proficiency.WEAPON_LONGSWORD);
        longsword.setWeaponGroup(Proficiency.MARTIAL_WEAPONS);
        longsword.getProperties().add(Proficiency.VERSITILE);
        
        return longsword;
    }
    
    
    
    
    
}
