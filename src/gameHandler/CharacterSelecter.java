package gameHandler;
import character.item.spells.HealingWord;
import character.item.spells.Fireball;
import character.races.Dwarf;
import character.races.Human;
import character.races.Elf;
import character.classes.Wizzard;
import character.classes.Cleric;
import character.classes.Ranger;
import character.classes.Fighter;
import character.PlayerCharacter;
import character.item.weapons.Weapon;
import character.item.weapons.ShortBow;
import character.item.weapons.Mace;
import character.item.weapons.LongSword;
import character.item.armor.ChainMail;
import character.item.armor.Plate;
import character.item.armor.Cloth;
import character.item.armor.Leather;
import java.util.ArrayList;

/**
 *
 * @author Matthias
 */
public class CharacterSelecter
{
  /**
   * Select a character from a preset.
   * 
   * @return The choosen character
   */
  public static PlayerCharacter selectCharacter()
  {
    // for testing some chars in an array
    // in this way it is not so much overhead
    PlayerCharacter[] players = getDemoChars();
    
    // Preview
    for(int i=0; i< players.length;i++)
    {
      System.out.println("Player " + (i+1) + ":");
      System.out.println(
          "Player name: " + players[i].getName() + "\n" +
          "Player class: " + players[i].getpClass().getName() + "\n" +
          "Player race: " + players[i].getpRace().getName() + "\n"
          );
    }

    System.out.println("Please select Player:");
    
    // The Selecting
    int input = gameHandler.InputHandlerOld.readIntegerValue();
    int choice = (input-1);
    System.out.println("\n");
    
    // Final output
    return players[choice];
  }
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
                                        0, // id 
                                        6   // allowedActions
                                    );
    player1.addWeapon(new LongSword("Excalibur", 10, 1, 1));
    player1.addArmor(new Plate());
    
    PlayerCharacter player2 = new PlayerCharacter(
                                      "Gwen",
                                      'f',
                                      new Cleric(), 
                                      new Dwarf(),
                                      0,
                                      6
                                    );
    player2.addWeapon(new Mace("Glower", 8, 1, 1));
    player2.addArmor(new ChainMail());
    player2.getpClass().getMyBook().addSpell(new HealingWord());
    
    PlayerCharacter player3 = new PlayerCharacter(
                                      "Vahlran",
                                      'm',
                                      new Ranger(), 
                                      new Elf(),
                                      0,
                                      6
                                    );
    player3.addWeapon(new ShortBow("Feather", 6, 2, 10));
    player3.addArmor(new Leather());
    
    PlayerCharacter player4 = new PlayerCharacter(
                                "Simon",
                                'm',
                                new Wizzard(), 
                                new Human(), 
                                0, 
                                 6
                              );
    player4.addWeapon(new Weapon());
    player4.addArmor(new Cloth());
    player4.getpClass().getMyBook().addSpell(new Fireball());
    
    PlayerCharacter[] output = {player1, player2, player3, player4};
    return output;
  }
  
  public static ArrayList<PlayerCharacter> getDemoCharArrayList() {
      PlayerCharacter player1 = new PlayerCharacter(
                                      "Zelo",
                                      'm',
                                      new Fighter(), 
                                      new Human(),
              0, 6
                                    );
    player1.addWeapon(new LongSword("Excalibur", 10, 1, 1));
    player1.addArmor(new Plate());
    
    PlayerCharacter player2 = new PlayerCharacter(
                                      "Gwen",
                                      'f',
                                      new Cleric(), 
                                      new Dwarf(),
                                      0, 6
                                    );
    player2.addWeapon(new Mace("Glower", 8, 1, 1));
    player2.addArmor(new ChainMail());
    player2.getpClass().getMyBook().addSpell(new HealingWord());
    
    PlayerCharacter player3 = new PlayerCharacter(
                                      "Vahlran",
                                      'm',
                                      new Ranger(), 
                                      new Elf(),
            0, 6
                                    );
    player3.addWeapon(new ShortBow("Feather", 6, 2, 10));
    player3.addArmor(new Leather());
    
    PlayerCharacter player4 = new PlayerCharacter(
                                "Simon",
                                'm',
                                new Wizzard(), 
                                new Human(),
            0, 6
                              );
    player4.addWeapon(new Weapon());
    player4.addArmor(new Cloth());
    player4.getpClass().getMyBook().addSpell(new Fireball());
    
    ArrayList<PlayerCharacter> chars = new ArrayList<>();
    chars.add(player1);
    chars.add(player2);
    chars.add(player3);
    chars.add(player4);
    return chars;
    
  }
}