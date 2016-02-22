package main;
import characters.PlayerCharacter;
import java.util.Scanner;

public class Demos 
{
  public static String firstFight(PlayerCharacter p1, PlayerCharacter p2)
  {
	double p1Health = p1.getHealth();
	double p1ArmorValue = p1.getpArmor().getArmorValue();
	
	double p2Health = p2.getHealth();
	double p2ArmorValue = p2.getpArmor().getArmorValue();
	
	String output = "";
	double cTh = 0.0;
	double dmg = 0.0;
	
	int i = 1;
	while(p1Health > 0.0 || p2Health > 0.0)
	{
// =============================================================================
	  cTh = p1.tryHit();
	  output += "Round " + i + ": " + p1.getName() + " ";
	  if(cTh >= p2ArmorValue){
		dmg = p1.meleeDamage();
		if(cTh == 20.0){dmg *= 2;}
		p2Health -= dmg;
		output += "hits " + p2.getName() + " with a " + cTh 
			  + " and does " + dmg + ". " 
			  + p2.getName() + " has " + p2Health + "/" + p2.getHealth()
			  + " HP left.\n";
	  }else{
		output += "misses with a " + cTh + "\n";
	  }
	  if(p2Health <= 0.0){
		output += p2.getName() + " is no more.\n";
		output += p1.getName() + " has " + p1Health + " HP left.\n";
		break;
	  }
// =============================================================================
	  cTh = p2.tryHit();
	  output += "Round " + i + ": " + p2.getName() + " ";
	  if(cTh >= p1ArmorValue){
		dmg = p2.meleeDamage();
		if(cTh == 20.0){dmg *= 2;}
		p1Health -= dmg;
		output += "hits " + p1.getName() + " with a " + cTh 
				+ " and does " + dmg + ". " 
				+ p1.getName() + " has " + p1Health + "/" + p1.getHealth() 
				+ " HP left.\n";
	  }else{
		output += "misses with a " + cTh + "\n";
	  }
	  if(p1Health <= 0.0){
		output += p1.getName() + " is no more.\n";
		output += p2.getName() + " has " + p2Health + " HP left.\n";
		break;
	  }
// =============================================================================
	  i++;
	}
	return output;
  }
  
  public static void alphaVersion(PlayerCharacter p1)
  {
	Scanner scanner = new Scanner(System.in);
	boolean quit = false;
	String input = "";
	System.out.println("Welcome adventurer.");
	while(!quit){
	  System.out.println("What would you like to do?");
	  input = scanner.nextLine();
	  switch(input)
	  {
		case "exit":
		  System.out.println("Thanks for playering.");
		  quit = true;
		  break;
		case "":
		  System.out.println("You need to type in a command.");
		  break;
		case "help":
		  break;
		case "my name":
		  System.out.println("My is " + p1.getName());
		  break;
		
	  }
	}
  }
}
