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

    public void grow() {
        int bonus = 0;
        if (this.getType() == Type.EVIL) {
            bonus = 1;
        } else if (this.getType() == Type.EVIL) {
            bonus = 3;
        } 
        int[] BonusStats = super.getStatsBonus();
        for (int i = 0; i < BonusStats.length; i++) {
            BonusStats[i] += bonus;
        }
        this.setStatsBonus(BonusStats);
        System.out.println(this.getName() + " GROWS");
    }
    
    
    
    public static Rat[] nest(int size, Type type) {
        Rat[] ratsNest = new Rat[size];
        for (int i = 0; i<ratsNest.length; i++) {
            ratsNest[i] = new Rat(type);
        }
        return ratsNest;
    }

    public void setNameWithType(String name) {
       if (this.getType() == Type.EVIL) {
           this.setName(Type.EVIL.value + " " + name);
       } else if (this.getType() == Type.OFDOOM) {
           this.setName(name + " " + Type.OFDOOM.value);       
       } else {
           this.setName(name);
       }
    }

}
