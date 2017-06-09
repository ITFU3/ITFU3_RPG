package gameHandler;

import Enum.MoveDirection;
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
        //TODO check if its players turn somehow
        switch (keyCode) {
            // Movement
            case up:
                // to inputhandler
                System.out.println("Up");
                MovementHandler.move(MoveDirection.UP);
                break;
            case down:
                System.out.println("Down");
                MovementHandler.move(MoveDirection.DOWN);
                break;
            case left:
                System.out.println("Left");
                 MovementHandler.move(MoveDirection.LEFT);
                break;
            case right:
                System.out.println("Right");
                MovementHandler.move(MoveDirection.RIGHT);
                break;
            // Battle Commands
            case attack:
                if( Game.getMonsters().size() > 0){
                    System.out.println("Attack");
                    PlayerCharacter attacker = Game.getPlayer();
                    MonsterCharacter target = Game.getMonsters().get(
                        Game.getInstance().getMonsterClosedToPlayer()
                    );
                    BattleHandler.tryToAttack(attacker, target);

                }else{ System.out.println("No Monster there to fight."); 
                    Game.updateAttackInfo("What do you want to attack?"
                            + "\n There are no Monsters around. "
                            + "\n Just end your round and see what comes next");
                }
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
                // end Player rount
                Game.updateAttackInfo("You ended your round.");
                Game.endRound();
                break;
        }
    } 
}