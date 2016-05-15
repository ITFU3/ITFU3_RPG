package main;
import characters.PlayerCharacter;
import java.util.Scanner;

public class Demos 
{
  public static String fight_1(PlayerCharacter p1, PlayerCharacter p2)
  {
	System.out.println("## fight_1 ##");
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
  
  public static String fight_2(PlayerCharacter p1, PlayerCharacter p2)
  {
	System.out.println("## fight_2 ##");
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
  
  public static void alphaVersion(PlayerCharacter p1, PlayerCharacter p2)
  {
    String map =  "#########S#############################" +
          "#            #   #                    #" +
          "#            #   #                    #" +
          "#            #   #                    #" +
          "#  M         #   ###############      #" +
          "#            #                        #" +
          "#  ###########                        #" +
          "#            #                        #" +
          "#            #                        #" +
          "#            #                        #" +
          "#                                     #" +
          "#######################################";
    Scanner command = new Scanner(System.in);
    Map dungeon = new Map(map, 39, 12);
    // just testing wise ....
    boolean playerTurn = true;
    boolean monsterTurn = true;
    boolean game = true;
    
    int tempPlayerMovement = p1.getMovement();
    while(game)
    {
      while(playerTurn)
      {
        System.out.println("What do you want to do?");
        String[] input = command.nextLine().split(" ");
                
        switch(input[0])
        {
          case "":
          case "help":
            System.out.println(
                    "These are your command options: \n"
                  + "\t help \n"
                  + "\t walk left [steps] \n"
                  + "\t walk right [steps] \n"
                  + "\t walk down [steps] \n"
                  + "\t walk up [steps] \n"
                  + "\t demofight \n"
                  + "\t end turn \n"
                  + "\t end game \n"
            );
          case "walk":
            if(tempPlayerMovement>0)
            {
              tempPlayerMovement = dungeon.walkOnMap(input[1], tempPlayerMovement, Integer.parseInt(input[2]));
            }
            else
            {
              System.out.println("You hav no Movement left to use.");
            }
            break;
          case "demofight": // only if M and p is on the same spott!!
            System.out.println(Demos.fight_1(p1, p2));
            break;
          case "attack":
            if(dungeon.getPlayerX() == dungeon.getmX()
              && dungeon.getPlayerY() == dungeon.getmY())
            {
              int[] cTh = p1.tryHit();
              if(cTh[0] == 20 || cTh[1] >= p2.getpArmor().getArmorValue())
              {
                int dmg = p1.doDamage();
                if(cTh[0] == 20)
                {
                  dmg *= 2;
                }
                int newHealth = p2.getHealth() - dmg;
                // go on.
              }
            }
            break;
          case "end":
            if(input[1].equalsIgnoreCase("turn"))
            {
              playerTurn = false;
            }
            else if(input[1].equalsIgnoreCase("game"))
            {
              playerTurn = false;
              monsterTurn = false;
              game = false;
            }
            break;
        }
      }
      
      while(monsterTurn)
      {        
        // till the monster turn gets implemented.
        monsterTurn = false;
        game = false;
        
        if(dungeon.getPlayerX() != dungeon.getmX() || dungeon.getPlayerY() != dungeon.getmY())
        {
          // move to player
        }
        else
        {
          // same spott
          // attack player
        }
      }
    }
  }
}
