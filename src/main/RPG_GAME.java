package main;
import characters.*;
import classes.*;
import races.*;
import weapons.*;
import armor.*;
import spells.*;
import backpack.*;
import BaseStats.*;

public class RPG_GAME
{
  public static void main(String[] args)
  {
//	System.out.println(main.Die.rollDie_recursively(10, 3));
// =============================================================================
	PlayerCharacter player1 = new PlayerCharacter(
                                    "Zelo",
                                    'm',
                                    new Fighter(), 
                                    new Human()
                                  );
	player1.addWeapon(new LongSword("Excalibur", 10, 1, 1));
	player1.addArmor(new Plate());
	player1.DebugChar();
	player1.DebugDMG(5);	
// =============================================================================
	PlayerCharacter player2 = new PlayerCharacter(
                                    "Gwen",
                                    'f',
                                    new Cleric(), 
                                    new Dwarf()
                                  );
	player2.addWeapon(new Mace("Glower", 8, 1, 1));
	player2.addArmor(new ChainMail());
	player2.DebugChar();
//	player2.DebugDMG(5);
  player2.getpClass().getMyBook().addSpell(new HealingWord());
  System.out.println(player2.getpClass().getMyBook().showSpellBook());
  System.out.println("= = = = = = = = = = = = = =");
// =============================================================================
	PlayerCharacter player3 = new PlayerCharacter(
                                    "Vahlran",
                                    'm',
                                    new Ranger(), 
                                    new Elf()
                                  );
	player3.addWeapon(new ShortBow("Feather", 6, 2, 10));
	player3.addArmor(new Leather());
	player3.DebugChar();
//	player3.DebugDMG(5);
// =============================================================================
  PlayerCharacter player4 = new PlayerCharacter(
                              "Simon",
                              'm',
                              new Wizzard(), 
                              new Human()
                            );
  player4.addWeapon(new Weapon());
  player4.addArmor(new Cloth());
  player4.DebugChar();
// =============================================================================
  player4.getpClass().getMyBook().addSpell(new Fireball());
  System.out.println(player4.getpClass().getMyBook().showSpellBook());
  System.out.println("= = = = = = = = = = = = = =");
// =============================================================================
//	System.out.println(Demos.firstFight(player1, player2));
//  System.out.println(Demos.secendFight(player1, player2));
//  System.out.println(Demos.secendFight(player4, player2));
// =============================================================================
//	Demos.alphaVersion(player1);
  
      System.out.println("BAG testing");
  Item item1 = new Item();
  Item item2;
      item2 = new Item(2.0, 2.0, 2.0);
      System.out.println(item1.getWeigth());
  Bag bag = new Bag();
  bag.addItem(item1);
  bag.addItem(item2);
  if (bag.addItem(item1)) {
      System.out.println("Oh it worked!!!");
  } else {
      System.out.println("It did not work, but I won't tell you why.");
  }
  
  
  }
}