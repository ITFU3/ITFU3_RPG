/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GuiHelper;

import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author steffen
 */
public class HealthBarLabel extends JLabel {
    
    int maxHealth;
    int currentHealth;

    public HealthBarLabel(int maxHealth, int currentHealth) {
        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
        this.setFont(new java.awt.Font("Courier New", 0, 13));
        this.setForeground(Color.red);
    }
    
    
    
public void setHealthText(int newCurrentHealth) {
    this.currentHealth = newCurrentHealth;
    int healthPoints = currentHealth;
    System.out.println("HealthPoints " +healthPoints);
    String healthPointString = "";
    String healthIndicator = "|";
    for (int i = 0; i < healthPoints; i++) {
        healthPointString += healthIndicator;
    }
    
    String lostHealthIndicator = "-";
    int lostHealtPoints = maxHealth - newCurrentHealth;
    if (lostHealtPoints >= 1) {
        for (int i = 0; i < lostHealtPoints; i++) {
        healthPointString += lostHealthIndicator;
        }
    }
    
    healthPointString += "\t" + currentHealth+"/"+maxHealth;
    
    
    this.setText(healthPointString);
}    


    
    
}
