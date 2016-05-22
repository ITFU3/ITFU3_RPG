package main;

import GameHandler.*;
import characters.*;

public class RPG_GAME
{
  public static void main(String[] args)
  {
    // can be used for ramdom monster selection
    MonsterCharacter[] monsters = Demos.getDemoMonster();
       
    // Selecting Player
    PlayerCharacter selectedCharacter = CharacterSelecter.selectCharacter();
    
	  selectedCharacter.DebugChar();
    
    // Starting the Game
    Demos.alphaVersion(selectedCharacter, monsters[1]);
  }
}