package gameHandler;

import base.*;
import enums.MoveDirection;
import enums.Spell;
import gui.popups.CharacterInfoFrame;
import gui.popups.InventoryFrame;
import gui.popups.SpellbookFrame;
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
        boolean playerTurn = Game.isPlayerTurn();
        if (playerTurn == true) {
            if (Game.getMonsters().size() > 0) {
                character.PlayerCharacter attacker = Game.getPlayer();
                character.MonsterCharacter target = Game.getMonsters().get(
                        Game.getInstance().getMonsterClosestToPlayer()
                );
                gameHandler.BattleHandler.tryToAttack(attacker, target);
            } else {
                Game.addToAttackInfoString(
                        "What do you want to attack?\n"
                                + "There are no Monsters around. "
                                + UserInfo.END_ROUND_PROMPT,
                        true
                );
            }
            
            if (Game.getPlayer().getAllowedAttacks() == 0) {
                Game.addToAttackInfoString(
                        UserInfo.NO_ATTACKS_LEFT + UserInfo.END_ROUND_PROMPT,
                        playerTurn
                );
            }
            Game.updateGUI();
        } else {
            System.out.println("NOT YOUR TURN");
        }
        Game.updateGUI();
    }
    
    public static void spellattack(String spellname){
        boolean playerTurn = Game.isPlayerTurn();
        if (playerTurn == true){
            character.PlayerCharacter attacker;
            character.PlayerCharacter target;
            attacker = Game.getPlayer();
            if(!spellname.equals(Spell.NONE.string)) {
                // we have a primary spell
                if(attacker.getSpellBook().getSpellByName(spellname).getSpellEffect().equalsIgnoreCase("heal")){
                    target = attacker;
                } else{
                    target = Game.getMonsters().get(
                            Game.getInstance().getMonsterClosestToPlayer()
                    );
                }
                BattleHandler.tryToSpellAttack(attacker, target, spellname);
            } else {
                // no primary spell
                Game.updateAttackInfo(UserInfo.NO_SPELL_AVAILABLE, true);
            }
            
            
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
            Game.updateAttackInfo("You ended your round.");
            Game.endRound();
        } else {
            System.out.println("NOT YOUR TURN");
        }
    }
    
    /**
     * open spellbook action for every input to trigger.
     */
    public static void openCloseSpellbook(){
        SpellbookFrame.getInstance().setVisible(!getInstance().isSpellbookShown);
        getInstance().isSpellbookShown = !getInstance().isSpellbookShown;
    }
    
    /**
     * open inventory action for every input to trigger.
     */
    public static void openCloseInventory(){
        InventoryFrame.getInstance().setVisible(!getInstance().isInventoryShown);
        getInstance().isInventoryShown = !getInstance().isInventoryShown;
    }
    
    /**
     *
     */
    public static void openCloseCharacterScreen(){
        CharacterInfoFrame.getInstance().setVisible(!getInstance().isCharInfoShown);
        getInstance().isCharInfoShown = !getInstance().isCharInfoShown;
    }
    
    /**
     * set focus for controls for every input to trigger.
     * @param isKeyboard Boolean to know which input type should be used.
     */
    public static void setControlFocus(boolean isKeyboard){
        System.out.println("FocusChange");
        Game.getInstance().getGameFrame().setButtonFocus( !isKeyboard );
    }
    
    /**
     * Setting the Primary Spell from a Frame
     * 
     * @param spellname - String
     */
    public static void setPrimarySpell(String spellname){
        Game.getPlayer().getSpellBook().setPrimarySpell(spellname);
    }
}
