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
    public static MonsterCharacter createOgerShaman(){
        MonsterCharacter ogerShaman = new MonsterCharacter( new Oger() );
        ogerShaman.setHealth(10);
        ogerShaman.setpClass(new Cleric());
        ogerShaman.addWeapon(new Mace());
        ogerShaman.addArmor(new Cloth());
        ogerShaman.getpClass().getMyBook().addSpell(new HealingWord());
        return ogerShaman;
    }
    
}
