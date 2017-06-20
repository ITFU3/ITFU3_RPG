/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameHandler;

import character.PlayerCharacter;
import gui.popups.PlayerUpdate;
import main.Game;

/**
 *
 * @author steffen
 */
public class PlayerUpdateHandler {
    
    public static void addExperience(PlayerCharacter pc, int xp) {
        pc.addExperience(xp);
        Game.updateXPInfo();
        
        if (pc.getUnUsedExperience() >= 100) {
        new PlayerUpdate(pc).setVisible(true);
        }
        
    }
    
}
