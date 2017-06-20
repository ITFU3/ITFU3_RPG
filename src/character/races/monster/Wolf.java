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
public class Wolf extends MonsterRace{

    private static int XP = 50;
   
    
    public Wolf() {
        
    }

    public Wolf(Type type) {
        super(type);
        
        
          // strength, dexterity, Constitution, wisdom, inteligent, charisma, movement, health (calculated)
        int[] bonus = {2,7,2,0,0,0,0,0};
        
        this.setStatsBonus(bonus);
        this.setType(type);
        this.setNameWithType(this.getClass().getSimpleName());
    }

    public Wolf(Type type, int[] bonus) {
        this(type);
        this.setStatsBonus(bonus);
    }
    
    @Override
    public int XP() {
        return XP; 
    }
    
    
    
}
