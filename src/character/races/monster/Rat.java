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
public class Rat extends MonsterRace {
    
    public static int XP  = 10;

    public Rat() {
        this(MonsterRace.getRandomType());
    }

    public Rat(Type type) {
        // strength, dexterity, Constitution, wisdom, inteligent, charisma, movement, health (calculated)
        int[] bonus = {0,5,1,0,0,0,0,0};
        
        this.setStatsBonus(bonus);
        this.setType(type);
        this.setNameWithType(this.getClass().getSimpleName());
        
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

    @Override
    public int XP() {
        return XP; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
