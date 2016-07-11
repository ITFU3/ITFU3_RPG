package gameHandler;
import main.*;
import characters.*;

/**
 * The Handler for all things related to turns
 * of player or monster
 * 
 * @author Matthias Dröge
 */
public class TurnHandler
{
  BattleHandler battleHandler;
  
  /**
   * Constructor for the TurnHandler that gets the
   * BattleHandler to use in combat as param
   * @param battleHandler - BattleHandler
   */
  public TurnHandler(BattleHandler battleHandler)
  {
    this.battleHandler = battleHandler;
  }
  
  /**
   * The actual "turn" the player makes.
   * That means the input dispatcher
   * for the players command words.
   * 
   * @param player The choosen charater
   * @param monster The choosen monster
   * @param tempMovement The tempural movement points
   * @param dungeonMap The map in which the action takes place
   * @param playerHasAction A blocking state inside the players turn
   * @param game A blocking state for the overall game
   * @return game (changed if so chosen)
   */
  public boolean doPlayersTurn(
                              PlayerCharacter player,
                              MonsterCharacter monster,
                              Map dungeonMap,
                              boolean game
  )
  {
    boolean playerTurn = true;
    boolean playerHasAction = true;
    int tempMovement = player.getMovement();
    
    while(playerTurn) {
      System.out.println("--- It is Your Turn! ---");
      System.out.println("What do you want to do?");
      String[] command = utilities.InputHandler.readStringValue().toLowerCase().split(" ");
      
      for (int i=0;i<command.length;i++) {
        System.out.println("[" + i + "] " + command[i]);
      }
      
      switch (command[0]) {
        case "":
        case "help":
          this.showPlayerHelp(player);
          break;

        case "charinfo":
          this.showPlayerInfo(player);
          break;

        case "inspect":
          this.doPlayerInspection(command, monster, dungeonMap);
          break;

        case "walk":
          tempMovement = this.doMovement(command, tempMovement, dungeonMap, true);
          break;

        case "attack":
          playerHasAction = this.doAttack(playerHasAction, command, dungeonMap, player, monster, true, false);
          break;

        case "cast":
          if(player.getpClass().getName().equalsIgnoreCase("wizzard")
          || player.getpClass().getName().equalsIgnoreCase("cleric")
          ) {
            playerHasAction = this.doAttack(playerHasAction, command, dungeonMap, player, monster, true, true);
          }
          break;

        case "use":
          //TODO: abilities that are not bind by the "hasAction"?
          break;

        case "end":
          playerTurn = true;
          game = true;
          if(command.length >= 2) {
            if(command[1].equalsIgnoreCase("turn")) {
              playerTurn = false;
              game = true;
            } else if(command[1].equalsIgnoreCase("game")) {
              playerTurn = false;
              game = false;
            }
          }
          break;

        default:
          System.out.println("No such command. Try 'help' for help.");
      }
    }
    return game;
  }
  
  /**
   * The actual "turn" the monster makes.
   * This is the point where the AI gets triggered.
   * 
   * @param player The choosen charater
   * @param monster The choosen monster
   * @param tempMovement The tempural movement points
   * @param dungeonMap The map in which the action takes place
   * @param monsterHasAction A blocking state inside the monster turn
   * @param game A blocking state for the overall game
   */
  public void doMonsterTurn(
                            PlayerCharacter player,
                            MonsterCharacter monster,
                            Map dungeonMap,
                            boolean game
  )
  {
    boolean monsterTurn = true;
    boolean monsterHasAction = true;
    int tempMovement = monster.getMovement();
    
    while( game && monsterTurn && ( monster.getTempHP() > 0 ) ) {
      System.out.println("--- It is the Monsters Turn! ---");
      if(dungeonMap.getDistance() == monster.getpWeapon().getDistance()) {
        if(monsterHasAction) {
          monsterHasAction = this.doAttack( game, new String[0], dungeonMap, player, monster, false, false );
        } else {
          monsterTurn = false;
          // quit OR move away depends on AI...
        }
      } else {
        if(tempMovement > 0) {
          System.out.println( "... tick tick  tick ... " + tempMovement );
          tempMovement = this.doMovement( new String[]{"walk", "left", "1"}, tempMovement, dungeonMap, false );
          // For later use in AI ...          
          monsterTurn = false;
        } else {
          monsterHasAction = false;
        }
      }
    }
  }
  
  /**
   * Lists all actions that can be taken from the player .
   * This needs to be taken care of manually.
   * 
   * @param player The choosen charater
   */
  private void showPlayerHelp(PlayerCharacter player)
  {
    String output = 
      "These are your command options: \n"
      + "\t help \n"
      + "\t charinfo \n"
      + "\t inspect [target] \n"
      + "\t walk [direction] [steps] \n"
      + "\t attack [target] \n";
    if(player.getpClass().getName().equalsIgnoreCase("wizzard"))
    {
      output += "\t cast [spellname] \n";
    }
      output += "\t end turn \n"
              + "\t end game \n"
              + "\t demofight \n";
    System.out.println(output);
  }
  
  /**
   * Gives all the information of the player character.
   * Like: stats, armor, weapon, etc.
   * 
   * @param player The choosen charater
   */
  private void showPlayerInfo(PlayerCharacter player)
  {
    System.out.println(player.showCharInfo());
  }
  
  /**
   * 
   * @param command The entered command line
   * @param monster The choosen monster
   * @param dungeonMap The map in which the action takes place
   */
  private void doPlayerInspection(String[] command, MonsterCharacter monster, Map dungeonMap)
  {
    if (command.length >= 2 && command[1].equalsIgnoreCase("monster")) {
      //p2.DebugChar();
      System.out.println(monster.getName() + " is " + dungeonMap.getDistance() + " steps away.");
    }
  }
  
  /**
   * Can be used for player and monster to "make a move"
   * 
   * @param command The entered command line
   * @param tempMovement The tempural movement points
   * @param dungeonMap The map in which the action takes place
   * @param playerSwitch The condition for player or monster
   * @return The left tempural movement points
   */
  private int doMovement(String[] command, int tempMovement, Map dungeonMap, boolean playerSwitch)
  {
    if(playerSwitch)
    {
      if (command.length >= 3) {
        if (tempMovement > 0) {
          tempMovement = dungeonMap.walkOnMap(command[1], tempMovement, Integer.parseInt(command[2]),playerSwitch);
        }else{System.out.println("You have no Movement left to use.");}
      }else{System.out.println("More parameters needed.");}
    }
    else
    {
      tempMovement = dungeonMap.walkOnMap(command[1], tempMovement, Integer.parseInt(command[2]),playerSwitch);
    }
    return tempMovement;
  }
  
  /**
   * Can be used for player and monster to "make an attack"
   * Perhaps redo this method.
   * 
   * @param hasAction The condition if attack is possible
   * @param command The entered command line
   * @param dungeonMap The map in which the action takes place
   * @param player The choosen charater
   * @param monster The choosen monster
   * @param playerSwitch The condition for player or monster
   * @param UseSpell The condition for normal or spell attack
   * @return The condition if attack is still possible or not
   */
  private boolean doAttack(
                          boolean hasAction, 
                          String[] command, 
                          Map dungeonMap, 
                          PlayerCharacter player, 
                          MonsterCharacter monster, 
                          boolean playerSwitch,
                          boolean UseSpell
  )
  {
    if(playerSwitch){
      if(hasAction){
        if(command.length>=2){
          if(command[1].equalsIgnoreCase(monster.getName())
			|| command[1].equalsIgnoreCase(player.getName()))
		  {
            if(UseSpell){
			  // For healing, to self target.
			  if(command[1].equalsIgnoreCase(player.getName())){
				System.out.println(battleHandler.tryToSpellAttack(player, player, dungeonMap.getDistance(), command[2]));
			  }else{
				System.out.println(battleHandler.tryToSpellAttack(player, monster, dungeonMap.getDistance(), command[2]));
			  }
            }else{
              System.out.println(battleHandler.tryToAttack(player, monster, dungeonMap.getDistance()));
            }
            if(monster.getTempHP() <= 0){
              dungeonMap.setMarkerOnMap(dungeonMap.getmY(), dungeonMap.getmX(), 'c');
            }
            hasAction = false;
		  }else{System.out.println("Who? Target not known.");}
        }else{System.out.println("More parameters needed.");}
      }else{System.out.println("You have used your action.");}
    }else{
      if(hasAction)
      {
        System.out.println("quiek");
        if(UseSpell)
        {
		  // Also implement self heal for monster as a fix call is needed.(b/c no external input)
          System.out.println(battleHandler.tryToSpellAttack(monster, player,dungeonMap.getDistance(), command[2]));
          hasAction = false;
        }else{
          System.out.println(battleHandler.tryToAttack(monster, player, dungeonMap.getDistance()));
          hasAction = false;
        }
        if(player.getTempHP() <= 0)
        {
          dungeonMap.setMarkerOnMap(dungeonMap.getLastY(), dungeonMap.getLastX(), 'c');
        }
        hasAction = false;
      }
    }
    return hasAction;
  }
}