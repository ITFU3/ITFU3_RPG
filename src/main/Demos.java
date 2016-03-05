package main;
import characters.PlayerCharacter;
import java.util.Scanner;

public class Demos 
{
  public static String firstFight(PlayerCharacter p1, PlayerCharacter p2)
  {
	int p1Health = p1.getHealth();
	int p1ArmorValue = p1.getAC();
	
	int p2Health = p2.getHealth();
	int p2ArmorValue = p2.getAC();
	
	String output = "";
	int[] cTh = new int[2];
	int dmg = 0;
	
	int i = 1;
	while(p1Health > 0 || p2Health > 0)
	{
// =============================================================================
	  cTh = p1.tryHit();
	  output += "Round " + i + ": " + p1.getName() + " ";
	  if(cTh[0] == 20 || cTh[1] >= p2ArmorValue){
		dmg = p1.doDamage();
    if(cTh[0] == 20)
    {
      dmg *= 2;
      output += "*";
    }
		p2Health -= dmg;
		output += "hits " + p2.getName() + " with a " + cTh[1] 
			  + " and does " + dmg + " damage. " 
			  + p2.getName() + " has " + p2Health + "/" + p2.getHealth()
			  + " HP left.\n";
	  }else{
		output += "misses with a " + cTh[1] + "\n";
	  }
	  if(p2Health <= 0){
		output += p2.getName() + " is no more.\n";
		output += p1.getName() + " has " + p1Health + " HP left.\n";
		break;
	  }
// =============================================================================
	  cTh = p2.tryHit();
	  output += "Round " + i + ": " + p2.getName() + " ";
	  if(cTh[0] == 20 || cTh[1] >= p1ArmorValue){
		dmg = p2.doDamage();
    if(cTh[0] == 20)
    {
      dmg *= 2;
      output += "*";
    }
		p1Health -= dmg;
		output += "hits " + p1.getName() + " with a " + cTh[1] 
				+ " and does " + dmg + " damage. " 
				+ p1.getName() + " has " + p1Health + "/" + p1.getHealth() 
				+ " HP left.\n";
	  }else{
		output += "misses with a " + cTh[1] + "\n";
	  }
	  if(p1Health <= 0){
		output += p1.getName() + " is no more.\n";
		output += p2.getName() + " has " + p2Health + " HP left.\n";
		break;
	  }
// =============================================================================
	  i++;
	}
	return output;
  }
  
  public static String secendFight(PlayerCharacter p1, PlayerCharacter p2)
  {
    int p1Health = p1.getHealth();
    int p1ArmorValue = p1.getpArmor().getArmorValue();

    int p2Health = p2.getHealth();
    int p2ArmorValue = p2.getpArmor().getArmorValue();

    String output = "";
    int[] cTh = new int[2];
    int dmg = 0;

    int tempheal = 0;
    
    int i = 1;
    
  while(p1Health > 0 || p2Health > 0)
  {
    // =============================================================================
    cTh = p1.tryHit();
    output += "Round " + i + ": " + p1.getName() + " ";
    if(cTh[0] == 20 || cTh[1] >= p2ArmorValue){
      if(p1.getpClass().getName().equalsIgnoreCase("wizzard")){
        dmg = p1.castSpell("fireball");
      }else{
        dmg = p1.doDamage();
      }
      if(cTh[0] == 20)
      {
        dmg *= 2;
        output += "*";
      }
      p2Health -= dmg;
      output += "hits " + p2.getName() + " with a " + cTh[1] 
        + " and does " + dmg + " damage. " 
        + p2.getName() + " has " + p2Health + "/" + p2.getHealth()
        + " HP left.\n";
    }else{
      output += "misses with a " + cTh[1] + "\n";
    }
    if(p1.getpClass().getName().equalsIgnoreCase("cleric") && (p1Health < p1.getHealth()))
    {
      tempheal = p1.castSpell("healingword");
        p1Health += tempheal;
        if(p1Health > p1.getHealth()){
          p1Health = p1.getHealth();
        }
        output += p1.getName() + " did self healing for " 
                + tempheal + "\n";
    }
    if(p2Health <= 0){
      output += p2.getName() + " is no more.\n";
      output += p1.getName() + " has " + p1Health + " HP left.\n";
      break;
    }
    // =============================================================================
    cTh = p2.tryHit();
    output += "Round " + i + ": " + p2.getName() + " ";
    if(cTh[0] == 20 || cTh[1] >= p1ArmorValue){
      if(p1.getpClass().getName().equalsIgnoreCase("wizzard")){
        dmg = p1.castSpell("fireball");
      }else{
        dmg = p1.doDamage();
      }
      if(cTh[0] == 20)
      {
        dmg *= 2;
        output += "*";
      }
      p1Health -= dmg;
      output += "hits " + p1.getName() + " with a " + cTh[1] 
        + " and does " + dmg + " damage. " 
        + p1.getName() + " has " + p1Health + "/" + p1.getHealth() 
        + " HP left.\n";
    }else{
      output += "misses with a " + cTh[1] + "\n";
    }
    if(p2.getpClass().getName().equalsIgnoreCase("cleric") && (p2Health < p2.getHealth()))
    {
      tempheal = p2.castSpell("healingword");
        p2Health += tempheal;
        if(p2Health > p2.getHealth()){
          p2Health = p2.getHealth();
        }
        output += "\t" + p2.getName() + " did self healing for " 
                + tempheal + "\n";
    }
    if(p1Health <= 0){
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
