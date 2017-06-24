package character.helper;

import character.*;
import character.classes.*;
import character.item.armor.*;
import character.item.weapons.*;
import character.item.spells.*;
import character.races.monster.*;

import java.lang.reflect.Method;
import main.Die;

/**
 *
 * @author Matthias Dröge
 */
public class MonsterPreset {
    public static final int MOVEMENT_SLOW = 2;
    public static final int MOVEMENT_MEDIUM = 4;
    public static final int MOVEMENT_FAST = 6;
    
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
     * Random Creates normal monsters without bossmonster.
     * This is not automatic adapting to new Monster-Presets.
     * 
     * @return MonsterCharacter
     */
    public static MonsterCharacter createNormalRandom(){
        MonsterCharacter output = null;
        switch( Die.rollDie(3, 1) ){
            case 1:
                output = createRat();
                break;
            case 2:
                output = createWolf();
                break;
            case 3:
                output = createBear();
                break;
        }
        return output;
    }
    
    /**
     * more like the standart MonsterCharacter default Rat
     * @return MonsterCharacter
     */
    public static MonsterCharacter createRat(){
        MonsterCharacter monster = new MonsterCharacter( new Rat() );
        monster.setMovement(MOVEMENT_FAST);
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
        monster.setMovement(MOVEMENT_SLOW);
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
        monster.setMovement(MOVEMENT_SLOW);
        monster.setHealth(10);
        monster.setTempHP(10);
        monster.setpClass(new Cleric());
        monster.addWeapon(new Mace());
        monster.addArmor(new Cloth());
        monster.getSpellBook().addSpell(new HealingWord());
        return monster;
    } 
    /**
     * creates an ORC FIGHTER 
     * @return MonsterCharacter
     */
    public static MonsterCharacter createOrcFighter(){
        MonsterCharacter monster = new MonsterCharacter( new Orc() );
        monster.setMovement(MOVEMENT_MEDIUM);
        monster.setHealth(8);
        monster.setTempHP(8);
        monster.setpClass(new Fighter());
        monster.addWeapon(new Handaxe());
        monster.addArmor(new ChainMail());
        monster.setMapToken('o');
        return monster;
    }    
    /**
     * creates a BEAR FIGHTER 
     * 
     * @return MonsterCharacter
     */
    public static MonsterCharacter createBear() {
        MonsterCharacter monster = new MonsterCharacter ( new Bear());
        monster.setMovement(MOVEMENT_MEDIUM);
        monster.setHealth(12);
        monster.setTempHP(12);
        monster.setpClass(new Fighter());
        monster.setWeaponSlot(new Claw());
        monster.setOffHandWeaponSlot(new Claw());
        monster.setMapToken('B');
        return monster; 
    }
/**
     * creates a WOLF  
     * 
     * @return MonsterCharacter
     */
    public static MonsterCharacter createWolf() {
        MonsterCharacter monster = new MonsterCharacter ( new Wolf());
        monster.setMovement(MOVEMENT_MEDIUM);
        monster.setHealth(10);
        monster.setTempHP(10);
        monster.setpClass(new Fighter());
        monster.setWeaponSlot(new Claw());
        monster.setMapToken('W');
        return monster; 
    }
}