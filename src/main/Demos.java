package main;
import GameHandler.*;
import base.Base;
import base.Item;
import armor.*;
import backpack.*;
import characters.*;
import classes.*;
import races.*;
import spells.*;
import weapons.*;

import java.util.Scanner;


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
    String map =  "#########P#############################" +
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
    TurnHandler tH = new TurnHandler();
    
    boolean game = true;
       
    // ##### GAME CYCLE #####
    while(game)
    {
      // ##### PLAYERS TURN #####
      game = tH.doPlayersTurn(cmd, p1, p2, p1.getMovement(), dungeon, true, game);
      
      // ##### MONSTERS TURN #####
      tH.doMonsterTurn(p1, p2, p2.getMovement(), dungeon, false, game);
    }
  }
}
