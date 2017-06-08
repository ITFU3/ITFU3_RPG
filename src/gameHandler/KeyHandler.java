package gameHandler;

import character.MonsterCharacter;
import character.PlayerCharacter;
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
                // to inputhandler
                System.out.println("Up");
                MovementHandler.up();

                break;
            case down:
                System.out.println("Down");
                MovementHandler.down();

                break;
            case left:
                System.out.println("Left");
                MovementHandler.left();
                break;
            case right:
                System.out.println("Right");
                MovementHandler.right();
                break;
            // Battle Commands
            case attack:
                System.out.println("Attack");
                PlayerCharacter attacker = main.Game.getInstance().getPlayer();
                MonsterCharacter target = main.Game.getInstance().getMonsters().get(
                    Game.getInstance().getMonsterClosedToPlayer()
                );
                String tmpOutput = BattleHandler.tryToAttack(attacker, target);
                System.out.println(tmpOutput);
                Game.updateGUI();
                
                break;
            // Info
                case changeFocus:
                System.out.println("FocusChange");
                Game.getInstance().getGameFrame().setButtonFocus(true);
                break;

            // System Commands
            case pause:
                System.out.println("Pause");
                break;
            case esc:
                System.out.println("Esc");
                break;
            case enter:
                if( Game.getInstance().getMonsters().size() <= 0 ){
                    Game.getInstance().nextLevel();
                    System.out.println("NEXT LEVEL: " + Game.getInstance().getLevel());
                }else{
                    //DoMonsters Turn HERE!!!
                    
                }
                // Reset PLayerCharacter
                Game.getInstance().getPlayer().setAllowedMoves(
                        //sollte eingerückt sein, ist ein Parameter
                        Game.getInstance().getPlayer().getMovement()
                );
                Game.getInstance().getPlayer().setAllowedAttacks(1);
                break;
        }
        
    }
    
    
}