/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character.races;

/**
 *
 * @author steffen
 */
public class Rat extends MonsterRace {

    public Rat() {
        this(MonsterRace.getRandomType());
    }

    public Rat(Type type) {
        this.setType(type);
        this.setNameWithType(this.getClass().getSimpleName());
        int[] BonusStats = super.getStatsBonus();
        grow();
    }
    /**
     * To tweak the Stats on spawn.
     * @param type
     * @param bonus 
     */
    public Rat(Type type, int [] bonus){
        this( type );
        this.setStatsBonus(bonus);
    }
}
