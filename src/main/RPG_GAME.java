package main;

import java.util.Scanner;
import armor.*;
import backpack.*;
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
    
    Scanner input = new Scanner(System.in);
    for(int i=0; i< players.length;i++)
    {
      System.out.println("Player " + (i+1) + ":");
      System.out.println(
          "Player name: " + players[i].getName() + "\n" +
          "Player class: " + players[i].getpClass().getName() + "\n" +
          "Player race: " + players[i].getpRace().getName() + "\n"
          );
    }

    System.out.println("Please select Player:");
    int choice = (input.nextInt()-1);

    System.out.println("\n");
    players[choice].DebugChar();
	
    Demos.alphaVersion(players[choice], monsters[1]);
  }
}