package gameHandler;

import Enum.MoveDirection;
import character.MonsterCharacter;
import character.PlayerCharacter;
import java.awt.Dialog;
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
        
        boolean playerTurn = Game.isPlayerTurn();
        
        switch (keyCode) {
            // Movement
            case up:
                // to inputhandler
                
                
                if(playerTurn== true) {
                    System.out.println("Up");
                    MovementHandler.move(MoveDirection.UP);
                } else {
                    System.out.println("NOT YOUR TURN");
                }
                
                
                break;
            case down:
                System.out.println("Down");
                if(playerTurn == true) {
                    MovementHandler.move(MoveDirection.DOWN);
                }else {
                    System.out.println("NOT YOUR TURN");
                }
                
                
                break;
            case left:
                System.out.println("Left");
                if(playerTurn == true) {
                    MovementHandler.move(MoveDirection.LEFT);
                }else {
                    System.out.println("NOT YOUR TURN");
                }
                
                break;
            case right:
                System.out.println("Right");
                if(playerTurn == true) {
                    MovementHandler.move(MoveDirection.RIGHT);
                }else {
                    System.out.println("NOT YOUR TURN");
                }
                break;
                // Battle Commands
            case attack:
                if(playerTurn == true) {
                    // Player may attack
                    if( Game.getMonsters().size() > 0){
                        PlayerCharacter attacker = Game.getPlayer();
                        MonsterCharacter target = Game.getMonsters().get(
                                Game.getInstance().getMonsterClosedToPlayer()
                        );
                        BattleHandler.tryToAttack(attacker, target);
                    }else{
                        Game.addToAttackInfoString("What do you want to attack?"
                                + "\n There are no Monsters around. "
                                + UserInfo.END_ROUND_PROMPT , true);
                    }
                    
                    if (Game.getPlayer().getAllowedAttacks() == 0) {
                        Game.addToAttackInfoString(UserInfo.NO_ATTACKS_LEFT + UserInfo.END_ROUND_PROMPT, playerTurn);
                    }
                    
                    Game.updateGUI();
                }else {
                    System.out.println("NOT YOUR TURN");
                }
                
                Game.updateGUI();
                break;
            case spellbook:
                new gui.popups.SpellbookFrame().setVisible(true);
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
                if(playerTurn == true) {
                    Game.updateAttackInfo("You ended your round.");
                    Game.endRound();
                } else {
                    System.out.println("NOT YOUR TURN");
                }
                
                break;
        }
    }
    
    
}