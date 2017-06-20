/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GuiHelper;

import Enum.UpdateAbleStats;
import static Enum.UpdateAbleStats.*;
import character.PlayerCharacter;
import character.helper.CharacterSelecter;
import java.util.ArrayList;
import static java.util.Arrays.asList;
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
    
    public static DefaultListModel<UpdateAbleStats> getUpdateablePlayerStats() {
        DefaultListModel<UpdateAbleStats> listmodel = new DefaultListModel<>();
        ArrayList<UpdateAbleStats> stats = new ArrayList<UpdateAbleStats>(asList(STRENGTH, DEXTERITY, CONSTITUTION, WISDOM, INTELLEGENCE, CHARISMA, MOVEMENT, ATTACKS, HEALTH));
        for (UpdateAbleStats stat : stats) {
            listmodel.addElement(stat);
        }
        
        return listmodel;
    }
    
}
