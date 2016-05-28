package main;
import gameHandler.*;
import base.Base;
import base.Item;
import backpack.*;
import characters.*;
import races.*;

/**
 * 
 * @author Matthias Dröge
 */
public class Demos 
{
  /**
   * Building a preset of monster for fast use in testing.
   * 
   * @return An array of prebuild monsters
   */
  public static MonsterCharacter[] getDemoMonster()
  {
    MonsterCharacter monster = new MonsterCharacter();
    MonsterCharacter rat = new MonsterCharacter(new Rat(Race.Type.EVIL));
    MonsterCharacter[] output = {monster, rat};
    return output;
  }
  
  /**
   * A test function for the new Bag-Class
   */
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
  
  /**
   * A test function for the monster creation
   */
  public static void monstertesting()
  {
    System.out.println(Base.randomBossName(9));
    MonsterCharacter monster = new MonsterCharacter(new Rat(Race.Type.EVIL));
    monster.showCharInfo();
    Rat[] rat = Rat.nest(10, Race.Type.EVIL);
  }
    
  /**
   * The alpha version of the text based rpg of ours.
   * 
   * @param p1 The player character
   * @param p2 The monster to fight
   */
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
    Map dungeon = new Map(map, 39, 12);
    BattleHandler bH = new BattleHandler(p1, p2);
    TurnHandler tH = new TurnHandler(bH);
    boolean gameLoop = true;
       
    // ##### GAME CYCLE #####
    while(gameLoop)
    {
      // ##### PLAYERS TURN #####
      gameLoop = tH.doPlayersTurn( p1, p2, dungeon, gameLoop);
      
      // ##### MONSTERS TURN #####
      tH.doMonsterTurn(p1, p2, dungeon, gameLoop);
    }
  }
}
