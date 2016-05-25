package main;

import gameHandler.*;
import characters.*;

public class RPG_GAME
{
  public static void main(String[] args)
  {
    utilities.InputHandler.openInputReader();
    
    // can be used for ramdom monster selection
    MonsterCharacter[] monsters = Demos.getDemoMonster();
       
    // Selecting Player
    PlayerCharacter selectedCharacter = CharacterSelecter.selectCharacter();
    
	  selectedCharacter.showCharInfo();
    
    // Starting the Game
    Demos.alphaVersion(selectedCharacter, monsters[1]);
    
    utilities.InputHandler.closeInputReader();
  }
}