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

public class RPG_GAME
{
  public static void main(String[] args)
  {
    // for testing some chars in an array
    // in this way it is not so much overhead
    PlayerCharacter[] players = Demos.getDemoChars();
    // can be used for ramdom monster selection
    MonsterCharacter[] monsters = Demos.getDemoMonster();
    
    Demos.alphaVersion(players[2], monsters[1]);

//    Demos.bagTesting();
//    Demos.monstertesting();
  }
}