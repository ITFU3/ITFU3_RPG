package main;

import gameHandler.*;
import gui.GameFrame;
import gui.SelectionFrame;
import java.awt.Dimension;
import java.awt.Toolkit;

public class RPG_GAME
{
  public static void main(String[] args)
  {
   /* utilities.InputHandler.openInputReader();
    
    // can be used for ramdom monster selection
    MonsterCharacter[] monsters = Demos.getDemoMonster();
       
    // Selecting Player
    PlayerCharacter selectedCharacter = CharacterSelecter.selectCharacter();
    
	  selectedCharacter.showCharInfo();
    
    // Starting the Game
    Demos.alphaVersion(selectedCharacter, monsters[1]);
    
    utilities.InputHandler.closeInputReader();*/
        /*StartFrame base = new StartFrame();
        ArenaFrame af = new ArenaFrame(base);
        af.drawArena();
        base.setVisible(true);*/
    /* StartFrame startFrame = new StartFrame();
     startFrame.setVisible(true);
     /*Game game = new Game("RPG", 400, 400);
      game.start();*/
     SelectionFrame sf = new SelectionFrame();
     sf.setVisible(true);
      
      
      
  }
}