package character.helper;

import character.item.spells.*;
import character.races.*;
import character.classes.*;
import character.*;
import character.item.weapons.*;
import character.item.armor.*;
import character.item.shields.Shield;
import character.item.shields.SmallShield;

import java.util.ArrayList;

/**
 *
 * @author Matthias Dröges
 */
public class CharacterSelecter
{
  
  /**
   * Building a preset of characters for fast use in testing.
   * 
   * @return An array of prebuild charaters
   */
  public static PlayerCharacter[] getDemoChars()
  {
    PlayerCharacter player1 = new PlayerCharacter(
        "Zelo",
        'm',
        new Fighter(), 
        new Human(), 
        0 // id 
    );
    player1.addWeapon(new LongSword("Excalibur", 10, 1, 1));
    player1.addArmor(new Plate());
    
    PlayerCharacter player2 = new PlayerCharacter(
        "Gwen",
        'f',
        new Cleric(), 
        new Dwarf(),
        0
    );
    player2.addWeapon( new Mace("Glower", 8, 1, 1) );
    player2.addArmor( new ChainMail() );
    player2.addShield( new SmallShield() );
    player2.getpClass().getMyBook().addSpell( new HealingWord() );
    
    PlayerCharacter player3 = new PlayerCharacter(
        "Vahlran",
        'm',
        new Ranger(), 
        new Elf(),
        0
    );
    player3.addWeapon(new ShortBow("Feather", 6, 2, 10));
    player3.addArmor(new Leather());
    
    PlayerCharacter player4 = new PlayerCharacter(
        "Simon",
        'm',
        new Wizzard(), 
        new Human(), 
        0
    );
    player4.addWeapon( new Weapon() );
    player4.addArmor( new Cloth() );
    player4.getpClass().getMyBook().addSpell(new Fireball());
    
    PlayerCharacter player5 = new PlayerCharacter(
        "Egeord",
        'm',
        new Fighter(), 
        new Dwarf(), 
        0 // id 
    );
    player5.addWeapon( new Handaxe() );
    player5.addOffHandWeapon( new Handaxe() );
    player5.addArmor(new Plate());
//    player5.addShield( new Shield() );
    
    PlayerCharacter[] output = {player1, player2, player3, player4, player5};
    return output;
  }
  
  public static ArrayList<PlayerCharacter> getDemoCharArrayList()
  {
    PlayerCharacter[] player = getDemoChars();
    ArrayList<PlayerCharacter> chars = new ArrayList<>();
    chars.add(player[0]);
    chars.add(player[1]);
    chars.add(player[2]);
    chars.add(player[3]);
    chars.add(player[4]);
    return chars;
    
  }
}