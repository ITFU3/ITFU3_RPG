package gameHandler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
            inputHandler.moveUp();
            break;
        case down:
            inputHandler.moveDown();
            break;
        case left:
            inputHandler.moveLeft();
            break;
        case right:
            inputHandler.moveRight();
            break;
            // Battle Commands
        case attack:
            inputHandler.attack();
            break;
        case spellbook:
            inputHandler.openSpellbook();
            break;
            // Info
        case changeFocus:
            inputHandler.setControlFocus(false);
            break;
            // System Commands
        case pause:
            System.out.println("Pause");
            break;
        case esc:
            System.out.println("Esc");
            break;
        case enter:
            inputHandler.endRound();
            break;
        }
    }
}