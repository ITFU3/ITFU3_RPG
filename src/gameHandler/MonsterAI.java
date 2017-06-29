/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package gameHandler;

import base.*;
import enums.MoveDirection;
import java.util.ArrayList;
import character.*;
import character.item.spells.SpellBook;
import javax.swing.text.html.HTML;
import main.Die;
import main.Game;
import main.Map;
/**
 *
 * @author steffen
 */
public class MonsterAI {
    MonsterCharacter ego;
    ArrayList<MoveDirection> moves = new ArrayList();
    int mX;
    int mY;
    
    public MonsterAI (MonsterCharacter monster) {
        this.ego = monster;
        int[]position = ego.getCoordinates();
        this.mY = position[0];
        this.mX = position[1];
        System.out.println("gameHandler.MonsterAI.MonsterAI: => Monster: Y[" + this.mY + "] " + "X[" + this.mX + "]");
    }
    /**
     * calculates the the moves,
     * a monster has to take,
     * to get to the player.
     */
    private void calcMovesToPlayer() {
        int[] coords = main.Game.getPlayer().getCoordinates();
        int playerY = coords[0];
        int playerX = coords[1];
        System.out.println("gameHandler.MonsterAI.calcMovesToPlayer: => Player Y[" + playerY + "] X[" + playerX + "]");
        
        int differenceX = playerX - mX;
        int differenceY = playerY - mY;
        /*
        0,0    0,6
        #######
        #     #
        #     #
        #######
        3,0    3,6
        */
        MoveDirection directionX = MoveDirection.RIGHT;
        if (differenceX < 0) {
            differenceX = differenceX * (-1);
            directionX = MoveDirection.LEFT;
        }
        if(differenceX != 0) {
            for (int i = 0; i < differenceX; i++) {
                moves.add(directionX);
            }
        }
        MoveDirection directionY = MoveDirection.DOWN;
        if (differenceY < 0) {
            differenceY = differenceY * (-1);
            directionY = MoveDirection.UP;
        }
        if(differenceY != 0) {
            for (int i = 0; i < differenceY; i++) {
                moves.add(directionY);
            }
        }
        System.out.println("gameHandler.MonsterAI.calcMovesToPlayer: => MOVES: " + moves.toString());
    }

    /**
     * moves Monster randomly anlong move path
     */
    private void move() {
        int index = 0;
        if(moves.size() > 0) {
            index = Die.rollDie(moves.size(), 1) -1; // because dice done have no zero
        }else{
            // preventing a crash!!
            calcMovesToPlayer();
            System.err.println( "gameHandler.MonsterAI.move => NEW moves.size: " + moves.size() );
        }
        MoveDirection directionIntent = moves.get(index);
        boolean needToChange;
        int counter = 0;
        do{
            needToChange = false;
            int before = this.ego.getAllowedMoves();
            
            MovementHandler.move(ego, directionIntent);
            
            int after = this.ego.getAllowedMoves();
            if(before == after){
                needToChange = true;
                // Labyrinth Logic here:
                // always turn left...
                System.out.println("gameHandler.MonsterAI.move ==> PRE LABYRINTH MOVE [" + directionIntent +"]");
                switch(directionIntent){
                    case UP:
                        directionIntent = MoveDirection.LEFT;
                        break;
                    case DOWN:
                        directionIntent = MoveDirection.RIGHT;
                        break;
                    case RIGHT:
                        directionIntent = MoveDirection.UP;
                        break;
                    case LEFT:
                        directionIntent = MoveDirection.DOWN;
                        break;
                }
                if(counter >= 4){ needToChange = false; }
            }
            counter++;
        }while(needToChange);
        moves.remove(index);
    }
    
    /**
     * checks if Monster can attack
     **/
    private boolean isInAttackRange() {
       int distance = Map.getInstance().getDistance(Game.getPlayer(), ego);
//        System.out.println("gameHandler.MonsterAI.isInAttackRange: ==> Monster is "+ distance+" away."); 
//        System.out.println("gameHandler.MonsterAI.isInAttackRange: ==> Monster can attack in a range of "+ ego.getWeaponSlot().getDistance()+".");
       if (distance <= ego.getWeaponSlot().getDistance()) {
//           System.out.println("gameHandler.MonsterAI.isInAttackRange: ==> IS IN RANGE");
           return true;
       }
//       System.out.println("gameHandler.MonsterAI.isInAttackRange: => IS NOT RANGE");
        return false;
    }
    
    /**
     * test if in range else moves towards player
     */
    public void think() {
        boolean next = false;
        calcMovesToPlayer();
        do{
            Game.addToAttackInfoString(ego.getName()+" thinks...", false);
            Game.waitFor(SleepTime.MONSTER_THINK_FIRST);
            SpellBook spellbook = ego.getSpellBook();
            
            if( !spellbook.isEmpty() ){
                System.err.println(
                    "gameHandler.MonsterAI.spell_Check: => " +  
                    spellbook.conainsSpellWithName( "HealingWord" )
                );
                if( spellbook.conainsSpellWithName("HealingWord") ){
                    // cast healingword on friend if in range
                    next = casting(true);
                }else if( spellbook.conainsSpellWithName("Fireball") ){
                    // cast fireball player if in range
                    next = casting(false);
                }
            }
            if( isInAttackRange() ){
                next = attacking();
            }else{
                next = moving();
            }
            Game.waitFor(SleepTime.MONSTER_AFTER_THOUHGT);
            //Game.updateGUI();
        } while(next);
        resetTurnStats();
    }
    
    /**
     * The attacking part of think()
     * @return next - for think()
     */
    private boolean attacking(){
        Game.updateAttackInfo(ego.getName() + " is in Range.");
//        System.out.println("gameHandler.MonsterAI.think: => AllowedAttacks: " + ego.getAllowedAttacks());
        if (ego.getAllowedAttacks() > 0)
        {
//            System.out.println("gameHandler.MonsterAI.think: => attack");
            BattleHandler.tryToAttack(ego, Game.getPlayer());

            return true;
        }
        else
        {
//            System.out.println("gameHandler.MonsterAI.think: => DON'T attack");
            Game.updateAttackInfo(ego.getName()+" can't attack anymore.");
            return false;
            // monster is in range and does not want to run away 
            // here ends round for monstere
        }
    }
    
    /**
     * The moving part of think()
     * @return next - for think()
     */
    private boolean moving(){
        if (ego.getAllowedMoves() > 0)
        {
//            System.out.println("gameHandler.MonsterAI.think: => MONSTER: " + ego.getName()+" moves");
            Game.updateAttackInfo(ego.getName() + " chooses to move.", true);
            move();
            return true;
        }
        else
        {
//            System.out.println("gameHandler.MonsterAI.think: => NOT Moving");
            return false; // cant move and cant attack since not in range
        }
    }
    
    private boolean casting(boolean healing){
        if( ego.getAllowedAttacks() > 0 && healing == true){
            // healing
            PlayerCharacter target = findFriendToHeal();
            if(target.getTempHP() <= target.getHealth()){
                BattleHandler.tryToSpellAttack(ego, target, "HealingWord");
            }
            return true;
        }else if( ego.getAllowedAttacks() > 0 && healing == false){
            // DMG
            BattleHandler.tryToSpellAttack(ego, Game.getPlayer(), "Fireball");
            return true;
        }else{
            // not casting at all
            return false;
        }
    }
    
    /**
     * finding the right target 
     * @return PlayerCharacter - target to cast heal on
     */
    private PlayerCharacter findFriendToHeal(){
        int healingDistance = ego.getSpellBook().getSpellByName("HealingWord").getSpellRange();
        int monsterDistance;
        MonsterCharacter lowest = null;
        for (MonsterCharacter monster : Game.getMonsters()) {
            if( monster.getTempHP() < monster.getHealth() ){
                monsterDistance = Map.getInstance().getDistance(ego, monster);
                if( monsterDistance <= healingDistance ){
                    if( lowest == null || monster.getTempHP() < lowest.getTempHP() )
                    lowest = monster;
                }
            }
        }
        return (lowest == null) ? ego : lowest;
    }
    
    /**
     * The Forgotten Reset Fuction for the AI
     */
    private void resetTurnStats(){
        this.ego.setAllowedMoves( this.ego.getMovement() );
        this.ego.setAllowedAttacks( 1 );
    }
}