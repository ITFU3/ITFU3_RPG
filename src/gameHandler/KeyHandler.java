/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameHandler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//import java.util.ArrayList;

/**
 *
 * @author steffen
 */
public class KeyHandler implements KeyListener {

   // key setup
    
    private final int up = KeyEvent.VK_W;
    private final int down = KeyEvent.VK_S;
    private final int left = KeyEvent.VK_A;
    private final int right = KeyEvent.VK_D;
    private final int attack = KeyEvent.VK_SPACE;
    
    private final int upperEnemy = KeyEvent.VK_NUMPAD8;
    private final int upperEnemy2 = KeyEvent.VK_UP;
    
    private final int pause = KeyEvent.VK_P;
    private final int esc = KeyEvent.VK_ESCAPE;
   
    
   
    public KeyHandler() {
        System.out.println("KeyHandler: init");
    }
    
    
    
    
    
    
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        keyAction(e);
    }
    
    public void keyAction(KeyEvent e) {
       int keyCode = e.getKeyCode();
        switch (keyCode) {
            // Movement
            case up:
                // to inputhandler
                System.out.println("Up");
                main.Map.getInstance().walkOnMap( "up" , 2 , 1 , true );
                break;
            case down:
                System.out.println("Down");
                main.Map.getInstance().walkOnMap( "down" , 2 , 1 , true );
                break;
            case left:
                System.out.println("Left");
                main.Map.getInstance().walkOnMap( "left" , 2 , 1 , true );
                break;
            case right:
                System.out.println("Right");
                main.Map.getInstance().walkOnMap( "right" , 2 , 1 , true );
                break;
            // Battle Commands
            case attack:
                System.out.println("Attack");
                break;
            // Info
                
                
            // System Commands
            case pause:
                System.out.println("Pause");
                break;
            case esc:
                System.out.println("Esc");
                break;

        }
        
        
    }
    
}