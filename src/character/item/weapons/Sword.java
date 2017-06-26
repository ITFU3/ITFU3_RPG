/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package character.item.weapons;

import enums.Proficiency;
import jdk.nashorn.api.scripting.NashornScriptEngineFactory;

/**
 *
 * @author Steffen Haas
 *
 */
public class Sword extends Weapon{
   
    public static Sword LONGSWORD = getLongsword();
    public static Sword SHORTSWORD = getShortsword();
    
    public Sword() {
        super();
        this.setDamageDie(6);
        this.setDieCount(1);
        this.setCat(Proficiency.WEAPON_TYPE_MELEE);
        this.setWeaponGroup(Proficiency.WEAPON_GROUP_SIMPLE);
    }
    
    public Sword( String name, int damageDie, int durability, int dieCount,Proficiency type, Proficiency cat, int distance, Proficiency weaponGroup ){
        super( name, damageDie, durability, dieCount, type, cat, distance, weaponGroup );
    }
    
    public Sword(Proficiency type) {
        super(type);
    }
    
    private static Sword getLongsword() {
        Sword longsword = new Sword();
        longsword.setDamageDie(10);
        longsword.setDieCount(1);
        longsword.setType(Proficiency.WEAPON_LONGSWORD);
        longsword.setWeaponGroup(Proficiency.WEAPON_GROUP_MARTIAL);
        longsword.getProperties().add(Proficiency.VERSITILE);
        return longsword;
    }
    
    private static Sword getShortsword(){
        Sword shortsword = new Sword();
        shortsword.setDamageDie(8);
        shortsword.setDieCount(1);
        shortsword.setType(Proficiency.WEAPON_SHORTSWORD);
        shortsword.setWeaponGroup(Proficiency.WEAPON_GROUP_SIMPLE);
        shortsword.getProperties().add(Proficiency.SINGLEHANDED);
        return shortsword;
    }
    
    
    
}
