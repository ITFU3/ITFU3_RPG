package main;
import characters.*;
import classes.*;
import races.*;
import weapons.*;
import armor.*;
import spells.*;

public class RPG_GAME
{
  public static void main(String[] args)
  {
//	System.out.println(main.Die.rollDie_recursively(10.0, 3.0));
// =============================================================================
	PlayerCharacter player1 = new PlayerCharacter(
                                    "Zelo",
                                    'm',
                                    new PlayerClass(new Warrior()), 
                                    new Race(new Human())
                                  );
	player1.addWeapon(new Weapon(new LongSword("Excalibur", 10, 1, 1.0)));
	player1.addArmor(new Armor(new Plate()));
	player1.DebugChar();
//	player1.DebugDMG(5);	
// =============================================================================
	PlayerCharacter player2 = new PlayerCharacter(
                                    "Gwen",
                                    'f',
                                    new PlayerClass(new Cleric()), 
                                    new Race(new Dwarf())
                                  );
	player2.addWeapon(new Weapon(new Mace("Glower", 8, 1, 1.0)));
	player2.addArmor(new Armor(new ChainMail()));
	player2.DebugChar();
//	player2.DebugDMG(5);
// =============================================================================
	PlayerCharacter player3 = new PlayerCharacter(
                                    "Vahlran",
                                    'm',
                                    new PlayerClass(new Ranger()), 
                                    new Race(new Elf())
                                  );
	player3.addWeapon(new Weapon(new ShortBow("Feather", 6, 2, 10.0)));
	player3.addArmor(new Armor(new Leather()));
	player3.DebugChar();
//	player3.DebugDMG(5);
// =============================================================================
        PlayerCharacter player4 = new PlayerCharacter(
                                    "Simon",
                                    'm',
                                    new PlayerClass(new Wizzard()), 
                                    new Race(new Human())
                                  );
        player4.addWeapon(new Weapon());
        player4.addArmor(new Armor(new Cloth()));
        player4.DebugChar();
// =============================================================================
        System.out.println("################################");
        player4.getpClass().getPBook().addSpell(new Fireball());
        System.out.println(player4.getpClass().getPBook().showSpellBook());
// =============================================================================
//	System.out.println(Demos.firstFight(player1, player2));
// =============================================================================
//	Demos.alphaVersion(player1);
  }
}