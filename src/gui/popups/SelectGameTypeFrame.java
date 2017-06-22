/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.popups;

import gui.SelectionFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

/**
 *
 * @author steffen
 */
public class SelectGameTypeFrame extends JFrame{
    
    JLabel titleLabel;
    JLabel userPromptLabel;
    JButton singlePlayerButton;
    JButton twoPlayerCoopButton;
    JButton multiPlayerButton;
    JButton vsButton;
    
    public SelectGameTypeFrame() {
        
    initFrame();
    initComponents();
    
    this.setVisible(true);
    
    }
    public void initFrame() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE); 
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        this.setResizable(false);
        Dimension dimensions = new Dimension(380, 260);
        this.setPreferredSize(dimensions);
        this.setMinimumSize(dimensions);
        this.setMaximumSize(dimensions);
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        int buttonSize = 100;
        int spacing = 20;
        Font titleFont = new java.awt.Font("Courier New", Font.BOLD, 16);
        Font subTitleFont = new java.awt.Font("Courier New", 0, 13);
        Dimension labelDimension = new Dimension(320, 20);
        Dimension buttonDimension = new Dimension(buttonSize, buttonSize);
        
        titleLabel = new JLabel();
        titleLabel.setText("Welcome to Death's Domain");
        titleLabel.setFont(titleFont);
        Point titlePosition = new Point(20, spacing);
        AbsoluteConstraints constraints = new AbsoluteConstraints(titlePosition, labelDimension) ;
        getContentPane().add(titleLabel, constraints);
        
        userPromptLabel = new JLabel();
        userPromptLabel.setText("Choose a game mode.");
        userPromptLabel.setFont(subTitleFont);
        userPromptLabel.setSize(labelDimension);
        Point userPrompLabelPosition = new Point(spacing, spacing + titlePosition.y);
        AbsoluteConstraints constraintSubtitle = new AbsoluteConstraints(userPrompLabelPosition, labelDimension) ;
        getContentPane().add(userPromptLabel, constraintSubtitle);
        
        int buttonY = spacing + userPrompLabelPosition.y + userPromptLabel.getHeight();
        
        singlePlayerButton = new JButton();
        singlePlayerButton.setText("SinglePlayer");
        singlePlayerButton.setSize(buttonDimension);
        Point singlePlayerButtonPoint = new Point(spacing, buttonY);
        AbsoluteConstraints constraintsSpB = new AbsoluteConstraints(singlePlayerButtonPoint, buttonDimension);
        getContentPane().add(singlePlayerButton, constraintsSpB);
        singlePlayerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                singlePlayerButtonActionPerformed(evt);
            }
        });
        
        multiPlayerButton = new JButton();
        multiPlayerButton.setText("Cooperation");
        multiPlayerButton.setSize(buttonDimension);
        Point multiPlayerButtonPoint = new Point(spacing + buttonSize + spacing , buttonY);
        AbsoluteConstraints constraintsMultiPlayer = new AbsoluteConstraints(multiPlayerButtonPoint, buttonDimension);
        getContentPane().add(multiPlayerButton, constraintsMultiPlayer);
        multiPlayerButton.setEnabled(false);
        
        vsButton = new JButton();
        vsButton.setText("VS");
        vsButton.setSize(buttonDimension);
        Point vsModeButtonPoint = new Point(spacing + buttonSize + spacing +buttonSize + spacing, buttonY);
        AbsoluteConstraints constraintsVSMode = new AbsoluteConstraints(vsModeButtonPoint, buttonDimension);
        getContentPane().add(vsButton, constraintsVSMode);
        vsButton.setEnabled(false);
        
    }
    
    public int getCetterPosHorz(JComponent component) {
        int centerHorzFrame = getWidth()/2;
        int halfComponentWidth = component.getWidth()/2;
        int centerPosMinusComponentWidth = centerHorzFrame - halfComponentWidth;
       
        return centerPosMinusComponentWidth;
    }
    
    public void singlePlayerButtonActionPerformed(ActionEvent evt) {
        new SelectionFrame();
        this.setVisible(false);
    }
    
}

