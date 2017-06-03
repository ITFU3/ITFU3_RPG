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
public class Rat extends Race {

    private Type type;

    public Rat() {
        this.setType(Type.NORMAL);
        this.setNameWithType(this.getClass().getSimpleName());
        int[] BonusStats = super.getStatsBonus();
        grow();
    }

    public Rat(Type type) {
        this.setType(type);
        this.setNameWithType(this.getClass().getSimpleName());
        int[] BonusStats = super.getStatsBonus();
        grow();
    }

    public Rat grow() {
        int bonus = 0;
        if (this.getType() == Type.EVIL) {
            bonus = 1;
        } else if (this.getType() == Type.EVIL) {
            bonus = 3;
        } else {
            return this;
        }
        int[] BonusStats = super.getStatsBonus();
        for (int i = 0; i < BonusStats.length; i++) {
            BonusStats[i] += bonus;
        }
        this.setStatsBonus(BonusStats);
        return this;
    }
    
    public static Rat[] nest(int size, Type type) {
        Rat[] ratsNest = new Rat[size];
        for (int i = 0; i<ratsNest.length; i++) {
            ratsNest[i] = new Rat(type);
        }
        return ratsNest;
    }

    /**
     * @return the type
     */
    public Type getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Type type) {
        this.type = type;
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
