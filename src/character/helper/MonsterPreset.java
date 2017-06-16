package character.helper;

import character.*;
import character.races.*;
import character.classes.*;
import character.item.armor.*;
import character.item.weapons.*;
import character.item.spells.*;

/**
 *
 * @author Matthias Dröge
 */
public class MonsterPreset {
    /**
     * creates an Oger Shaman that can heal
     * @return MonsterCharacter
     */
    public static MonsterCharacter createOgerShaman(){
        MonsterCharacter ogerShaman = new MonsterCharacter( new Oger() );
        ogerShaman.setHealth(10);
        ogerShaman.setpClass(new Cleric());
        ogerShaman.addWeapon(new Mace());
        ogerShaman.addArmor(new Cloth());
        ogerShaman.getpClass().getMyBook().addSpell(new HealingWord());
        return ogerShaman;
    }
    
    /**
     * creates an Oger Grunt
     * @return MonsterCharacter
     */
    public static MonsterCharacter createOgerGrunt(){
        MonsterCharacter ogerShaman = new MonsterCharacter( new Oger() );
        ogerShaman.setHealth(15);
        ogerShaman.setpClass(new Fighter());
        ogerShaman.addWeapon(new Mace());
        ogerShaman.addArmor(new Leather());
        return ogerShaman;
    }
    
    /**
     * more like the standart MonsterCharacter default Rat
     * @return MonsterCharacter
     */
    public static MonsterCharacter createRat(){
        MonsterCharacter rat = new MonsterCharacter( new Rat() );
        rat.setHealth(3);
        rat.setpClass(new PlayerClass());
        rat.addWeapon(new Weapon());
        rat.addArmor(new Armor());
        return rat;
    }
}
