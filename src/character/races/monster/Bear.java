/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character.races.monster;

/**
 *
 * @author steffen
 */
public class Bear extends MonsterRace {
    
    public static int XP  = 100;
    
    public Bear() {
        this(MonsterRace.getRandomType());
    }

    public Bear(MonsterRace.Type type) {
        // strength, dexterity, Constitution, wisdom, inteligent, charisma, movement, health (calculated)
        int[] bonus = {3,2,1,0,0,0,0,0};
        
        this.setStatsBonus(bonus);
        this.setType(type);
        this.setNameWithType(this.getClass().getSimpleName());  
    }
    /**
     * To tweak the Stats on spawn.
     * @param type
     * @param bonus 
     */
    public Bear(MonsterRace.Type type, int [] bonus){
        this( type );
        this.setStatsBonus(bonus);
    }
    
    @Override
    public int XP() {
        return XP; 
    }
    
    
}
