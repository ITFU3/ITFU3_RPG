/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author steffen
 */
public class ArenaPanel extends JPanel{
    
    private JPanel form;
    
    Dimension screenSize;
    
    JPanel player;
    ArrayList<JPanel> monster;
    
    public int border = 5;
    public Color color = Color.BLACK;
    
    private int startX = 0;
    private int startY = 20;
    
    private int playerPosX = -1;
    private int playerPosY = -1;
    
    private int width;
    private int height;
    
    private ArrayList<Integer> borderTop;
    private ArrayList<Integer> borderLeft;
    private ArrayList<Integer> borderBottom;
    private ArrayList<Integer> borderRight;

    public ArenaPanel(JPanel form, int width, int height) {
        
        this.form = form;
        screenSize = form.getSize();
        
        this.width = width;
        this.height = height;
        
        
        
        setStartX();
        borderTop = new ArrayList();
        borderLeft = new ArrayList();
        borderBottom = new ArrayList();
        borderRight = new ArrayList();
        
        borderTop.add(startX); // startpoint x
        borderTop.add(startY); //startpoint y
        borderTop.add(startX); //endpoint x
        borderTop.add(width); //endpoint y
        
        borderLeft.add(startX); // startpoint x
        borderLeft.add(startY); //startpoint y
        borderLeft.add(height); //endpoint x
        borderLeft.add(startX); //endpoint y
        
        borderBottom.add(height); // startpoint x
        borderBottom.add(startY); //startpoint y
        borderBottom.add(height); //endpoint x
        borderBottom.add(width); //endpoint y

        
    }
    
    public ArenaPanel(JPanel form) {
        
        this.form = form;
        setPreferredSize(form.getPreferredSize());
        this.width = form.getPreferredSize().width;
        this.height = form.getPreferredSize().height;
                
        
        screenSize = form.getSize();
        setStartX();
        
        
                
        borderTop = new ArrayList();
        borderLeft = new ArrayList();
        borderBottom = new ArrayList();
        borderRight = new ArrayList();
        
        borderTop.add(startX); // startpoint x
        borderTop.add(startY); //startpoint y
        borderTop.add(startX); //endpoint x
        borderTop.add(width); //endpoint y
        
        borderLeft.add(startX); // startpoint x
        borderLeft.add(startY); //startpoint y
        borderLeft.add(height); //endpoint x
        borderLeft.add(startX); //endpoint y
        
        borderBottom.add(height); // startpoint x
        borderBottom.add(startY); //startpoint y
        borderBottom.add(height); //endpoint x
        borderBottom.add(width); //endpoint y

        
    }
      
    public JPanel drawLine(int x1, int y1,int x2, int y2) {
        JPanel linePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
              Graphics2D g2 = (Graphics2D) g;
              g2.setStroke(new BasicStroke(border));
              g.drawLine(x1, y1, x2 ,y2);
              
            }
            
        };
        form.add(linePanel);
        linePanel.setBounds(0, 0, form.getWidth(),form.getHeight());
        return linePanel;
    }
    
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
              
    }
    
    public JPanel drawLine(int x1, int y1,int x2, int y2, Color color) {
        JPanel linePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
              Graphics2D g2 = (Graphics2D) g;
              g2.setStroke(new BasicStroke(border));
              g2.setColor(color);
              g.drawLine(x1, y1, x2 ,y2);
              
            }
            
        };
        linePanel.setBounds(0, 0, form.getWidth(),form.getHeight());
        return linePanel;
    }
    
    public JPanel drawArena() {
        JPanel arenaPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
              Graphics2D g2 = (Graphics2D) g;
              g2.setStroke(new BasicStroke(border));
              g.drawRect(startX, startY, width, height);
            }
        };
        form.add(arenaPanel);
        arenaPanel.setBounds(0, 0, form.getWidth(),form.getHeight());
        return arenaPanel;
    }
    
    public void setStartX() {
        startX = (int) (((double)screenSize.width / 2) - width/2);
    }
    
    public void drawPlayerAt(int x,int y) {
         
            player = drawLine(x, y, x, y+1, Color.BLUE);
            playerPosX = x;
            playerPosY = y;
            form.add(player);
        
    }
    
    public void erasePlayerAt(int x,int y) {
         
            player = drawLine(x, y, x, y+1, form.getBackground());
            playerPosX = x;
            playerPosY = y;
            form.add(player);
        
    }
    
    public void movePlayerUpBy(int i) {
        
        drawPlayerAt(playerPosX, playerPosY+i);
    }
    
    public void movePlayerDownBy(int i) {
        drawPlayerAt(playerPosX, playerPosY-i);
    }
    
    public void movePlayerLeftBy(int i) {
        drawPlayerAt(playerPosX+i, playerPosY);
    }
    
    public void movePlayerRightBy(int i) {
        drawPlayerAt(playerPosX-i, playerPosY);
    }
    
    
    public int getMiddleHorizonal() {
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return (int) (((double)screenSize.width / 2));
    }
    
    public int getMiddleVertical() {
        return (int) (((double)screenSize.height / 2));
    }
    
    public void addDrawing(JPanel drawing) {
        form.add(drawing);
    }
    
    public void removeDrawing(JPanel drawing) {
        form.remove(drawing);
    }
}
    

