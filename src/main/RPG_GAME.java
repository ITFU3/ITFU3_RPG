package main;
import characters.*;
import classes.*;
import races.*;
import weapons.*;
import armor.*;

public class RPG_GAME
{
  public static void main(String[] args)
  {
// =============================================================================
	PlayerCharacter player1 = new PlayerCharacter(
									"Zelo",
									'm',
									new PlayerClass(new Warrior()), 
									new Race(new Human())
								  );
	player1.addWeapon(new Weapon(new LongSword("Excalibur", 10, 1)));
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
	player2.addWeapon(new Weapon(new Mace("Glower", 8, 1)));
	player2.addArmor(new Armor(new ChainMail()));
	player2.DebugChar();
//	player2.DebugDMG(5);
// =============================================================================
	Object[] tempClass = {
						  "Ragner",
						  new double[]{
									  0.0, 2.0, 0.0, 2.0, 
									  0.0, 0.0, 2.0, 0.0
									  }
						  };
	PlayerCharacter player3 = new PlayerCharacter(
									"Vahlran",
									'm',
									new PlayerClass(tempClass), 
									new Race(new Elf())
								  );
	Object[] tempWeapon = {"Feather",8,100.0,1,"ShortBow","range"};
	player3.addWeapon(new Weapon(tempWeapon));
	Object[] tempArmor = {"ForestSkin","Leather",12.0};
	player3.addArmor(new Armor(tempArmor));
	player3.DebugChar();
//	player3.DebugDMG(5);
// =============================================================================
//	System.out.println(Demos.firstFight(player1, player2));
// =============================================================================
//	Demos.alphaVersion(player1);
  }
}
