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
public class Orc extends MonsterRace{
    
    public static int XP  = 200;
    
    public Orc(){
        this(MonsterRace.getRandomType());
    }
    public Orc(MonsterRace.Type type){
        // strength, dexterity, Constitution, wisdom, inteligent, charisma, movement, health (calculated)
        int[] bonus = {10,2,5,0,0,0,0,0};
        
        this.setStatsBonus(bonus);
        this.setType(type);
        this.setNameWithType(this.getClass().getSimpleName());
    }
    public Orc(MonsterRace.Type type, int [] bonus){
        this( type );
        this.setStatsBonus(bonus);
    }
    
    @Override
    public int XP() {
        return XP; 
    }
    
}