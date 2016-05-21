/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameHandler;

import main.Demos;
import armor.*;
import backpack.*;
import Base.*;
import characters.*;
import classes.*;
import races.*;
import spells.*;
import weapons.*;
import java.util.ArrayList;
import room.*;

/**
 *
 * @author steffen
 */
public class GameHandler {

    ArrayList<PlayerCharacter> players;
    ArrayList<MonsterCharacter> monsters;
    ArrayList<BaseSpace> spaces;
    
    
    
    public void turn(String[] input, PlayerCharacter player) {
        switch (input[0]) {
            case "":
            case "help":
                String output
                        = "These are your command options: \n"
                        + "\t help \n"
                        + "\t charInfo \n"
                        + "\t inspect [target] \n"
                        + "\t walk [direction] [steps] \n"
                        + "\t attack [target] \n";
                if (p1.getpClass().getName().equalsIgnoreCase("wizzard")) {
                    output += "\t cast [spellname] \n";
                }
                output += "\t demofight \n"
                        + "\t end turn \n"
                        + "\t end game \n";
                System.out.println(output);
                break;

            case "charInfo":
                p1.DebugChar();
                break;

            case "inspect":
                if (input.length >= 2 && input[1].equalsIgnoreCase("monster")) {
//              p2.DebugChar();
                    System.out.println(p2.getName());
                }
                break;

            case "walk":
                if (input.length >= 3) {
                    if (tempPlayerMovement > 0) {
                        tempPlayerMovement = dungeon.walkOnMap(input[1], tempPlayerMovement, Integer.parseInt(input[2]));
                    } else {
                        System.out.println("You hav no Movement left to use.");
                    }
                } else {
                    System.out.println("More parameters needed.");
                }
                break;
            case "demofight": // only if M and p is on the same spott!!
                System.out.println(Demos.fight_1(p1, p2));
                break;

            case "attack":
                if (toDoAction) {
                    if (input.length >= 2) {
                        if (input[1].equalsIgnoreCase(p2.getName())) {
                            int distance = dungeon.getDistance();
                            System.out.println(p1.tryToAttack(p2, distance));
                            if (p2.getTempHP() <= 0) {
                                if (dungeon.getPlayerX() == dungeon.getmX()
                                        && dungeon.getPlayerY() == dungeon.getmY()) {
                                    dungeon.setMarkerOnMap(dungeon.getmY(), dungeon.getmX(), 'P');
                                } else {
                                    dungeon.setMarkerOnMap(dungeon.getmY(), dungeon.getmX(), ' ');
                                }
                            }
                            toDoAction = false;
                        } else {
                            System.out.println("Who??");
                        }
                    } else {
                        System.out.println("More parameters needed.");
                    }
                } else {
                    System.out.println("You have used your action.");
                }
                break;

            case "end":
                if (input.length >= 2 && input[1].equalsIgnoreCase("turn")) {
                    playerTurn = false;
                    monsterTurn = true;
                } else if (input.length >= 2 && input[1].equalsIgnoreCase("game")) {
                    playerTurn = false;
                    monsterTurn = false;
                    game = false;
                }
                break;

            case "cast":
                if (toDoAction) {
                    if (p1.getpClass().getName().equalsIgnoreCase("wizzard")
                            || p1.getpClass().getName().equalsIgnoreCase("cleric")) {
                        if (input.length >= 2) {
                            int distance = dungeon.getDistance();
                            System.out.println(p1.tryToSpellAttack(p2, distance, input[2]));
                            toDoAction = false;
                        } else {
                            System.out.println(p1.getpClass().getMyBook().showSpellBook());
                        }
                    } else {
                        System.out.println("You are not a caster.");
                    }
                } else {
                    System.out.println("You have used your action.");
                }
                break;

            case "use":
                // for abilities that are not bind by the "action"
                break;

            default:
                System.out.println("No such command. Try 'help' for help.");
        }
    }
}
