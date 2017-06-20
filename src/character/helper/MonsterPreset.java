package character.helper;

import character.races.monster.Rat;
import character.races.monster.Oger;
import character.*;
import character.races.*;
import character.classes.*;
import character.item.armor.*;
import character.item.weapons.*;
import character.item.spells.*;
import character.races.monster.Orc;

import java.lang.reflect.Method;

/**
 *
 * @author Matthias Dröge
 */
public class MonsterPreset {
    /**
     * Sweet little function to pic a preset at random.
     * self adjusting by using reflection of this class.
     * When these presets get bigger and more dangerous, this could be quite bad.
     * 
     * @return MonsterCharacter
     */
    public static MonsterCharacter createRandom(){
        try{
            Method[] ran = MonsterPreset.class.getDeclaredMethods();
            int monsterIndex = main.Die.rollDie(ran.length-1, 1);
            if(
                ran[monsterIndex].toString().equalsIgnoreCase(
                "public static MonsterCharacter character.helper.MonsterPreset.createRandom()"
            )){
                // on picking self, try again.
                return createRandom();
            }
            return (MonsterCharacter)ran[monsterIndex].invoke( MonsterPreset.class );
        }catch(Throwable e){
            System.err.println( e );
            // on error spwan rat.
            return createRat();
        }
    }
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
    
    public static MonsterCharacter createBear() {
        MonsterCharacter monster = new MonsterCharacter ( new Orc());
        monster.setHealth(12);
        monster.setTempHP(12);
        monster.setpClass(new Fighter());
        
        return monster; 
    }
}
