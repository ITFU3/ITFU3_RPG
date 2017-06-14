package gameHandler;

import Enum.MoveDirection;
import gui.popups.InventoryFrame;
import main.Game;

/**
 *
 * @author Matthias Dröge
 */
public class InputHandler {
    
    private boolean isInventoryShown    = false;
    private boolean isSpellbookShown    = false;
    private boolean isCharInfoShown     = false; 
    
    private static InputHandler instance;

    private InputHandler() {
    }
    
    
    public static InputHandler getInstance() {
        if (instance == null) {
            instance = new InputHandler();
        }
        return instance;
    }

    /**
     * attack action for every Input to triger.
     */
    public static void attack() {
        boolean playerTurn = main.Game.isPlayerTurn();
        if (playerTurn == true) {
            if (main.Game.getMonsters().size() > 0) {
                character.PlayerCharacter attacker = main.Game.getPlayer();
                character.MonsterCharacter target = main.Game.getMonsters().get(
                        main.Game.getInstance().getMonsterClosedToPlayer()
                );
                gameHandler.BattleHandler.tryToAttack(attacker, target);
            } else {
                Game.addToAttackInfoString(
                        "What do you want to attack?\n"
                        + "There are no Monsters around. "
                        + gameHandler.UserInfo.END_ROUND_PROMPT,
                        true
                );
            }

            if (Game.getPlayer().getAllowedAttacks() == 0) {
                Game.addToAttackInfoString(
                        gameHandler.UserInfo.NO_ATTACKS_LEFT + gameHandler.UserInfo.END_ROUND_PROMPT,
                        playerTurn
                );
            }
           Game.updateGUI();
        } else {
            System.out.println("NOT YOUR TURN");
        }
        main.Game.updateGUI();
    }

    public static void spellattack(String spellname){
        boolean playerTurn = main.Game.isPlayerTurn();
        if (playerTurn == true){
            character.PlayerCharacter attacker;
            character.PlayerCharacter target;
            attacker = main.Game.getPlayer();
            if(attacker.getpClass().getMyBook().getSpellByName(spellname).getSpellEffect().equalsIgnoreCase("heal")){
                target = attacker;
            }else{
                target = main.Game.getMonsters().get(
                    Game.getInstance().getMonsterClosedToPlayer()
                );
            }
            BattleHandler.tryToSpellAttack(attacker, target, spellname);
            Game.updateGUI();
        }
    }
    
    /**
     * move up action for every Input to triger.
     */
    public static void moveUp() {
        boolean playerTurn = main.Game.isPlayerTurn();
        if (playerTurn == true) {
            MovementHandler.move(MoveDirection.UP);
        } else {
            System.out.println("NOT YOUR TURN");
        }
    }

    /**
     * move down action for every Input to triger.
     */
    public static void moveDown() {
        boolean playerTurn = main.Game.isPlayerTurn();
        if (playerTurn == true) {
            MovementHandler.move(MoveDirection.DOWN);
        } else {
            System.out.println("NOT YOUR TURN");
        }
    }

    /**
     * move right action for every Input to triger.
     */
    public static void moveRight() {
        boolean playerTurn = main.Game.isPlayerTurn();
        if (playerTurn == true) {
            MovementHandler.move(MoveDirection.RIGHT);
        } else {
            System.out.println("NOT YOUR TURN");
        }
    }

    /**
     * move left action for every Input to triger.
     */
    public static void moveLeft() {
        boolean playerTurn = main.Game.isPlayerTurn();
        if (playerTurn == true) {
            MovementHandler.move(MoveDirection.LEFT);
        } else {
            System.out.println("NOT YOUR TURN");
        }
    }

    /**
     * end round action for every input to trigger.
     */
    public static void endRound(){
        boolean playerTurn = main.Game.isPlayerTurn();
        if(playerTurn == true) {
            main.Game.updateAttackInfo("You ended your round.");
            main.Game.endRound();
        } else {
            System.out.println("NOT YOUR TURN");
        }
    }
    
    
    
    
    
    /**
     * open spellbook action for every input to trigger.
     */
    public static void openCloseSpellbook(){
        // ToDo: more testing.
        new gui.popups.SpellbookFrame().setVisible(true);
    }
    
    /**
     * open inventory action for every input to trigger.
     */
    public static void openCloseInventory(){
        
        // ToDo: more testing.
        InventoryFrame.getInstance().setVisible(getInstance().isInventoryShown);
        getInstance().isInventoryShown = !getInstance().isInventoryShown;
    }
    
    /**
     * 
     */
    public static void openCloseCharacterScreen(){
        new gui.popups.CharacterFrame().setVisible(getInstance().isCharInfoShown);
    }
    
    /**
     * set focus for controls for every input to trigger.
     * @param isKeyboard Boolean to know which input type should be used.
     */
    public static void setControlFocus(boolean isKeyboard){
        System.out.println("FocusChange");
        main.Game.getInstance().getGameFrame().setButtonFocus( !isKeyboard );
    }
}
