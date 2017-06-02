/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GuiHelper;

import characters.PlayerCharacter;
import gameHandler.CharacterSelecter;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author steffen
 */
public class ListModels {
    
    public static DefaultListModel<PlayerCharacter> getCharacterModel() {
        DefaultListModel<PlayerCharacter> listmodel = new DefaultListModel<>();
        ArrayList<PlayerCharacter> chars = CharacterSelecter.getDemoCharArrayList();
        
        for (PlayerCharacter aChar : chars) {
            listmodel.addElement(aChar);
        }
        
        
        return listmodel;
    }
}
