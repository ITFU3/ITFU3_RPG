package gameHandler;

import enums.Spell;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import main.Game;

/**
 *
 * @author Steffen Haas
 */
public class KeyHandler implements KeyListener {
    
    
    
    // key setup
    private final int up = KeyEvent.VK_W;
    private final int down = KeyEvent.VK_S;
    private final int left = KeyEvent.VK_A;
    private final int right = KeyEvent.VK_D;
    private final int attack = KeyEvent.VK_SPACE;
    
    private final int changeFocus = KeyEvent.VK_M;
    private final int spellbook = KeyEvent.VK_C;
    private final int inventory = KeyEvent.VK_I;
    private final int character = KeyEvent.VK_V;
    
    
    private final int upperEnemy = KeyEvent.VK_NUMPAD8;
    private final int upperEnemy2 = KeyEvent.VK_UP;
    
    private final int pause = KeyEvent.VK_P;
    private final int esc = KeyEvent.VK_ESCAPE;
    
    private final int enter = KeyEvent.VK_ENTER;
    
    public KeyHandler() {
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
            InputHandler.moveUp();
            break;
        case down:
            InputHandler.moveDown();
            break;
        case left:
            InputHandler.moveLeft();
            break;
        case right:
            InputHandler.moveRight();
            break;
            // Battle Commands
        case attack:
            InputHandler.attack();
            break;
        case spellbook:
            InputHandler.openCloseSpellbook();
            break;
        case inventory:
            InputHandler.openCloseInventory();
            break;
        case character:
            InputHandler.openCloseCharacterScreen();
            break;
            // Info
        case changeFocus:
            InputHandler.setControlFocus(false);
            break;
            // System Commands
        case pause:
            System.err.println("Pause");
            break;
        case esc:
            System.err.println("Esc");
            break;
        case enter:
            InputHandler.endRound();
            break;
        }
    }
}