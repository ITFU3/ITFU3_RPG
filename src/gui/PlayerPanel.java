/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author steffen
 */
public class PlayerPanel extends JPanel {
    int x;
    int y;
    
    
    
    public PlayerPanel(int x, int y) {
        this.x = x;
        this.y = y;   
    }
    
    @Override
    public void paint(Graphics g) {
        g.drawRect(x, y, 5 ,5);
        g.setColor(Color.BLUE);
    }
}
