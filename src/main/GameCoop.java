/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import character.PlayerCharacter;
import java.util.ArrayList;

/**
 *
 * @author steffen
 */
public class GameCoop extends Game{
    
     public static GameCoop instance;
     
     public ArrayList<String> playerNames = new ArrayList<>();
     
     public ArrayList<PlayerCharacter> players;
     
     private int playerIndex= 0;
     
    public static GameCoop getInstance() {
        if (instance == null) {
            instance = new GameCoop();
        }
        return instance;
    }
    
    
    
    public static void endRound() {
       // add to playerIndex to get next player 
       getInstance().setPlayerIndex(getInstance().getPlayerIndex() + 1);
       if (getInstance().getPlayerIndex() < getPlayers().size()) {
           getInstance().setPlayer(getPlayers().get(getInstance().getPlayerIndex()));
           updateGUI();
           return;
       };
       
       
       
       
       
       
       
    }

    public GameCoop() {
    }

    
    
    public ArrayList<String> getPlayerNames() {
        return playerNames;
    }

    public void setPlayerNames(ArrayList<String> playerNames) {
        this.playerNames = playerNames;
    }

    public static ArrayList<PlayerCharacter> getPlayers() {
        return getInstance().players;
    }

    public void setPlayers(ArrayList<PlayerCharacter> players) {
        this.players = players;
    }

    public int getPlayerIndex() {
        return playerIndex;
    }

    public void setPlayerIndex(int playerIndex) {
        this.playerIndex = playerIndex;
    }
    
    
     
   
    
     
    
}
