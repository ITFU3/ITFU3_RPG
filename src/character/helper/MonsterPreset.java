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
     * more like the standart MonsterCharacter default Rat
     * @return MonsterCharacter
     */
    public static MonsterCharacter createRat(){
        MonsterCharacter monster = new MonsterCharacter( new Rat() );
        monster.setHealth(3);
        monster.setTempHP(3);
        monster.setpClass(new PlayerClass());
        monster.addWeapon(new Weapon());
        monster.addArmor(new Armor());
        return monster;
    }
    /**
     * creates an Oger Grunt
     * @return MonsterCharacter
     */
    public static MonsterCharacter createOgerGrunt(){
        MonsterCharacter monster = new MonsterCharacter( new Oger() );
        monster.setHealth(15);
        monster.setTempHP(15);
        monster.setpClass(new Fighter());
        monster.addWeapon(new Mace());
        monster.addArmor(new Leather());
        return monster;
    }
    /**
     * creates an Oger Shaman that can heal
     * @return MonsterCharacter
     */
    public static MonsterCharacter createOgerShaman(){
        MonsterCharacter monster = new MonsterCharacter( new Oger() );
        monster.setHealth(10);
        monster.setTempHP(10);
        monster.setpClass(new Cleric());
        monster.addWeapon(new Mace());
        monster.addArmor(new Cloth());
        monster.getpClass().getMyBook().addSpell(new HealingWord());
        return monster;
    }    
}
