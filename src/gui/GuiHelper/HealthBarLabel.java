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

    public HealthBarLabel(int maxHealth) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.setFont(new java.awt.Font("Courier New", 0, 13));
        this.setForeground(Color.red);
    }
    
    
    
public void setHealthText(int newCurrentHealth) {
    this.currentHealth = newCurrentHealth;
    System.err.println("gui.GuiHelper.HealthBarLable.setHealthText: ==> HealthPoints " + this.currentHealth);
    String healthPointString = "";
    String healthIndicator = "|";
    for (int i = 0; i < this.currentHealth; i++) {
        healthPointString += healthIndicator;
    }
    
    String lostHealthIndicator = "-";
    int lostHealtPoints = maxHealth - newCurrentHealth;
    if (lostHealtPoints >= 1) {
        for (int i = 0; i < lostHealtPoints; i++) {
        healthPointString += lostHealthIndicator;
        }
    }
    
    healthPointString += "\t" + this.currentHealth +"/"+ maxHealth;
    
    
    this.setText(healthPointString);
}    


    
    
}
