package main;
import Base.Helper;
import character.races.*;
import character.*;
import gameHandler.*;

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
    MonsterCharacter rat = new MonsterCharacter(new Rat(MonsterRace.Type.EVIL));
    MonsterCharacter[] output = {monster, rat};
    return output;
  }
    
  /**
   * A test function for the monster creation
   */
  public static void monstertesting()
  {
    System.out.println(Helper.randomBossName(9));
    MonsterCharacter monster = new MonsterCharacter(new Rat(MonsterRace.Type.EVIL));
    monster.showCharInfo();
    Rat[] rat = Rat.nest(10, MonsterRace.Type.EVIL);
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
//    BattleHandler bH = new BattleHandler(p1, p2);
    TurnHandlerOld tH = new TurnHandlerOld(/*bH*/);
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
