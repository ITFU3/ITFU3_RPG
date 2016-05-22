package gameHandler;
import main.*;
import characters.*;

public class TurnHandler
{  
  public boolean doPlayersTurn(
                              PlayerCharacter player,
                              MonsterCharacter monster,
                              int tempMovement,
                              Map dungeon,
                              boolean playerHasAction,
                              boolean game
  )
  {
    boolean playerTurn = true;
    while(playerTurn)
    {
      System.out.println("--- It is Your Turn! ---");
      System.out.println("What do you want to do?");
      String[] command = utilities.InputHandler.readStringValue().toLowerCase().split(" ");
      
      switch (command[0])
      {
        case "":
        case "help":
          this.showPlayerHelp(player);
          break;

        case "charInfo":
          this.showPlayerInfo(player);
          break;

        case "inspect":
          this.doPlayerInspection(command, monster, dungeon);
          break;

        case "walk":
          tempMovement = this.doMovement(command, tempMovement, dungeon, true);
          break;

        case "attack":
          playerHasAction = this.doAttack(playerHasAction, command, dungeon, player, monster, true);
          break;

        case "cast":
          playerHasAction = this.doCasting(playerHasAction, command, dungeon, player, monster, true);
          break;

        case "use":
          //TODO: abilities that are not bind by the "hasAction"?
          break;

        case "end":
          playerTurn = this.endByCondition(command, "turn");
          game = this.endByCondition(command, "game");
          break;

        default:
          System.out.println("No such command. Try 'help' for help.");
      }
    }
    return game;
  }
  
  public void doMonsterTurn(
                            PlayerCharacter player,
                            MonsterCharacter monster,
                            int tempMovement,
                            Map dungeon,
                            boolean monsterHasAction,
                            boolean game
  )
  {
    boolean monsterTurn = true;
    while( monsterTurn && ( monster.getTempHP() > 0 ) )
    {
      System.out.println("--- It is the Monsters Turn! ---");
      if(dungeon.getDistance() == monster.getpWeapon().getDistance())
      {
        monsterHasAction = this.doAttack(game, new String[0], dungeon, player, monster, false);
      }
      else
      {
        if(tempMovement > 0)
        {
          System.out.println("... tick tick  tick ... " + tempMovement);
          
          tempMovement = this.doMovement(new String[]{"walk", "left", "1"}, tempMovement, dungeon, false);
          
          monsterTurn = false;
//          For later use in AI ...
//          monsterTurn = this.endByCondition(new String[]{"end", "turn"}, "turn");
        }
        else
        {
          monsterHasAction = false;
        }
      }
    }
  }
  
// ##### Actions for use in a turn / or both #####
  private void showPlayerHelp(PlayerCharacter player)
  {
// TODO: should be automated
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
  
  private void showPlayerInfo(PlayerCharacter player)
  {
    player.DebugChar();
  }
  
  private void doPlayerInspection(String[] command, MonsterCharacter monster, Map dungeon)
  {
    if (command.length >= 2 && command[1].equalsIgnoreCase("monster")) {
      //p2.DebugChar();
      System.out.println(monster.getName() + " is " + dungeon.getDistance() + " steps away.");
    }
  }
  
  // change boolean by condition (end turn / end game)
  private boolean endByCondition(String[] command, String condition)
  {
    boolean output = true;
    if (command.length >= 2 && command[1].equalsIgnoreCase(condition)){
      output = false;
    }
    return output; 
  }
  
  // can be used for player and monster!
  private int doMovement(String[] command, int tempMovement, Map dungeon, boolean playerSwitch)
  {
    if(playerSwitch)
    {
      if (command.length >= 3) {
        if (tempMovement > 0) {
          tempMovement = dungeon.walkOnMap(command[1], tempMovement, Integer.parseInt(command[2]),playerSwitch);
        }else{System.out.println("You have no Movement left to use.");}
      }else{System.out.println("More parameters needed.");}
    }
    else
    {
      tempMovement = dungeon.walkOnMap(command[1], tempMovement, Integer.parseInt(command[2]),playerSwitch);
    }
    return tempMovement;
  }
  
  // can be used for player and monster!
  private boolean doAttack(boolean hasAction, String[] command, Map dungeon, PlayerCharacter player, MonsterCharacter monster, boolean playerSwitch)
  {
    if(playerSwitch)
    {
      if(hasAction)
      {
        if(command.length>=2)
        {
          if(command[1].equalsIgnoreCase(monster.getName()))
          {
            System.out.println(player.tryToAttack(monster, dungeon.getDistance()));
            if(monster.getTempHP() <= 0)
            {
              dungeon.setMarkerOnMap(dungeon.getmY(), dungeon.getmX(), 'c');
            }
            hasAction = false;
          }else{System.out.println("Who??");}
        }else{System.out.println("More parameters needed.");}
      }else{System.out.println("You have used your action.");}
    }
    else
    {
      if(hasAction)
      {
        System.out.println("quiek");
        System.out.println(monster.tryToAttack(player, dungeon.getDistance()));
        if(player.getTempHP() <= 0)
        {
          dungeon.setMarkerOnMap(dungeon.getLastY(), dungeon.getLastX(), 'c');
        }
        hasAction = false;
      }
    }
    return hasAction;
  }
  
  // can be used for player and monster!
  private boolean doCasting(boolean hasAction, String[] command, Map dungeon, PlayerCharacter player, MonsterCharacter monster, boolean playerSwitch)
  {
    if(playerSwitch)
    {
      if (hasAction)
      {
        if (player.getpClass().getName().equalsIgnoreCase("wizzard")
                || player.getpClass().getName().equalsIgnoreCase("cleric"))
        {
            if (command.length >= 2)
            {
                System.out.println(player.tryToSpellAttack(monster, dungeon.getDistance(), command[2]));
                if(monster.getTempHP() <= 0)
                {
                  dungeon.setMarkerOnMap(dungeon.getmY(), dungeon.getmX(), 'c');
                }
                hasAction = false;
                
            }else{System.out.println(player.getpClass().getMyBook().showSpellBook());}
        }else{System.out.println("You are not a caster.");}
      }else{System.out.println("You have used your action.");}
    }
    else
    {
      if (hasAction)
      {
        System.out.println(monster.tryToSpellAttack(player, dungeon.getDistance(), command[2]));
        if(player.getTempHP() <= 0)
        {
          dungeon.setMarkerOnMap(dungeon.getLastY(), dungeon.getLastX(), 'c');
        }
        hasAction = false;
      }
    }
    return hasAction;
  }
}