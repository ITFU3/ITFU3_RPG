/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import character.PlayerCharacter;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author steffen
 */
public class ArenaHandler {
    
    private static ArenaHandler instance;
    
    ArenaPanel arenaPanel;
    ArenaFrame arenaFrame;
    public static ArenaHandler getInstance() {
        if(instance == null) {
            instance = new ArenaHandler();
        }
        return instance;
    }
    
    public void initArenaPanel(JPanel wrapPanel) {
        
        arenaPanel = new ArenaPanel(wrapPanel);
        arenaPanel.drawPlayerAt(arenaPanel.getMiddleHorizonal(),arenaPanel.getMiddleVertical());
        wrapPanel.repaint();
    }
    public void initArenaFrame(JFrame wrapFrame) {
     
        arenaFrame = new ArenaFrame(wrapFrame);
        arenaFrame.drawPlayerAt(arenaPanel.getMiddleHorizonal(),arenaPanel.getMiddleVertical());
        wrapFrame.setVisible(true);
    }

    public ArenaPanel getArenaPanel() {
        return arenaPanel;
    }
    
    
}
