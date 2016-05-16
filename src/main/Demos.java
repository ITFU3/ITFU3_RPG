package main;
import java.util.Scanner;
import armor.*;
import backpack.*;
import Base.*;
import characters.*;
import classes.*;
import races.*;
import spells.*;
import weapons.*;

public class Demos 
{
  public static PlayerCharacter[] getDemoChars()
  {
    PlayerCharacter player1 = new PlayerCharacter(
                                      "Zelo",
                                      'm',
                                      new Fighter(), 
                                      new Human()
                                    );
    player1.addWeapon(new LongSword("Excalibur", 10, 1, 1));
    player1.addArmor(new Plate());
    
    PlayerCharacter player2 = new PlayerCharacter(
                                      "Gwen",
                                      'f',
                                      new Cleric(), 
                                      new Dwarf()
                                    );
    player2.addWeapon(new Mace("Glower", 8, 1, 1));
    player2.addArmor(new ChainMail());
    player2.getpClass().getMyBook().addSpell(new HealingWord());
    
    PlayerCharacter player3 = new PlayerCharacter(
                                      "Vahlran",
                                      'm',
                                      new Ranger(), 
                                      new Elf()
                                    );
    player3.addWeapon(new ShortBow("Feather", 6, 2, 10));
    player3.addArmor(new Leather());
    
    PlayerCharacter player4 = new PlayerCharacter(
                                "Simon",
                                'm',
                                new Wizzard(), 
                                new Human()
                              );
    player4.addWeapon(new Weapon());
    player4.addArmor(new Cloth());
    player4.getpClass().getMyBook().addSpell(new Fireball());
    
    PlayerCharacter[] output = {player1, player2, player3, player4};
    return output;
  }
  public static MonsterCharacter[] getDemoMonster()
  {
    MonsterCharacter monster = new MonsterCharacter();
    MonsterCharacter rat = new MonsterCharacter(new Rat(Race.Type.EVIL));
    MonsterCharacter[] output = {monster, rat};
    return output;
  }
  public static void bagTesting()
  {
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
  public static void monstertesting()
  {
    System.out.println(Base.randomBossName(9));
    MonsterCharacter monster = new MonsterCharacter(new Rat(Race.Type.EVIL));
    monster.DebugChar();
    Rat[] rat = Rat.nest(10, Race.Type.EVIL);
  }
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
          dmg = p1.castSpell( p1.getpClass().getMyBook().getSpellByName("fireball") );
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
        tempheal = p1.castSpell( p1.getpClass().getMyBook().getSpellByName("healingword") );
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
        if(p2.getpClass().getName().equalsIgnoreCase("wizzard")){
          dmg = p2.castSpell( p2.getpClass().getMyBook().getSpellByName("fireball") );
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
        tempheal = p2.castSpell( p2.getpClass().getMyBook().getSpellByName("healingword") );
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
  
//  public static void alphaVersion(PlayerCharacter p1, PlayerCharacter p2)
  public static void alphaVersion(PlayerCharacter p1, MonsterCharacter p2)
  {
    String map =  "#########S#############################" +
                  "#            #   #                    #" +
                  "#            #   #                    #" +
                  "#            #   #                    #" +
                  "#        M   #   ###############      #" +
                  "#            #                        #" +
                  "#  ###########                        #" +
                  "#            #                        #" +
                  "#            #                        #" +
                  "#            #                        #" +
                  "#                                     #" +
                  "#######################################";
    Scanner cmd = new Scanner(System.in);
    Map dungeon = new Map(map, 39, 12);
    // just testing wise ....
    boolean playerTurn = true;
    boolean monsterTurn = false;
    boolean game = true;
    
    boolean toDoAction = true;
    
    int tempPlayerMovement = p1.getMovement();
    while(game){
// ##### PLAYERS TURN #####
      while(playerTurn){
        System.out.println("What do you want to do?");
        String[] input = cmd.nextLine().split(" ");
        switch(input[0])
        {
          case "":
          case "help":
            String output = 
              "These are your command options: \n"
              + "\t help \n"
              + "\t charInfo \n"
              + "\t inspect [target] \n"
              + "\t walk [direction] [steps] \n"
              + "\t attack [target] \n";
            if(p1.getpClass().getName().equalsIgnoreCase("wizzard"))
            {
              output += "\t cast [spellname] \n";
            }
              output += "\t demofight \n"
                      + "\t end turn \n"
                      + "\t end game \n";
            System.out.println(output);
            break;
            
          case "charInfo":
            p1.DebugChar();
            break;
            
          case "inspect":
            if(input.length>=2 && input[1].equalsIgnoreCase("monster")){
//              p2.DebugChar();
              System.out.println(p2.getName());
            }
            break;
            
          case "walk":
            if(input.length>=3){
              if(tempPlayerMovement>0){
                tempPlayerMovement = dungeon.walkOnMap(input[1], tempPlayerMovement, Integer.parseInt(input[2]));
              }else{System.out.println("You hav no Movement left to use.");}
            }else{System.out.println("More parameters needed.");}
            break;
          case "demofight": // only if M and p is on the same spott!!
            System.out.println(Demos.fight_1(p1, p2));
            break;
            
          case "attack":
            if(toDoAction){
              if(input.length>=2){
                if(input[1].equalsIgnoreCase(p2.getName())){
                  int distance = dungeon.getDistance();
                  System.out.println(p1.tryToAttack(p2, distance));
                  if(p2.getTempHP() <= 0){
                    if(dungeon.getPlayerX() == dungeon.getmX()
                    && dungeon.getPlayerY() == dungeon.getmY()){
                      dungeon.setMarkerOnMap(dungeon.getmY(), dungeon.getmX(), 'P');
                    }else{
                      dungeon.setMarkerOnMap(dungeon.getmY(), dungeon.getmX(), ' ');
                    }
                  }
                  toDoAction = false;
                }else{System.out.println("Who??");}
              }else{System.out.println("More parameters needed.");}
            }else{System.out.println("You have used your action.");}
            break;
            
          case "end":
            if(input.length>=2 && input[1].equalsIgnoreCase("turn")){
              playerTurn = false;
              monsterTurn = true;
            }else if(input.length>=2 && input[1].equalsIgnoreCase("game")){
              playerTurn = false;
              monsterTurn = false;
              game = false;
            }
            break;
            
          case "cast":
            if(toDoAction){
              if(p1.getpClass().getName().equalsIgnoreCase("wizzard") 
                || p1.getpClass().getName().equalsIgnoreCase("cleric")){
                if(input.length>=2){
                  int distance = dungeon.getDistance();
                  System.out.println( p1.tryToSpellAttack(p2, distance, input[2]) );
                  toDoAction = false;
                }else{System.out.println(p1.getpClass().getMyBook().showSpellBook());}
              }else{System.out.println("You are not a caster.");}
            }else{System.out.println("You have used your action.");}
            break;
          
          case "use":
            // for abilities that are not bind by the "action"
            break;
            
          default:
            System.out.println("No such command. Try 'help' for help.");
        }
      }
// ##### MONSTERS TURN #####
// could be excluded in a function
      while(monsterTurn){        
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
