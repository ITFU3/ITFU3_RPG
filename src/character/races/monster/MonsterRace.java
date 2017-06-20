package character.races.monster;

import character.races.Race;
import interfaces.Growable;

import main.Die;

/**
 *
 * @author Matthias Dröge
 */
public class MonsterRace extends Race implements Growable{
    private static int BASE_XP = 50;
   
    
    /**
     * Enum Type that classifies Monsters
     */
    
    public enum Type {
      NORMAL("normal"),
      EVIL("evil"),
      OFDOOM("of DOOM");
      public String value;
      public static int EVIL_XP_BONUS = 5;
      public static int OFDOOM_XP_BONUS = 10;
     
      private Type(String value) {
          this.value = value;
          
      }
    }
    
    private Type type;
    
    /**
     * Constructor
     */
    public MonsterRace() {
        this(Type.NORMAL);
        
    }
    /**
     * Constuctor with Type
     * @param type
     */
    public MonsterRace(Type type){
        super();
        this.type = type;
        
    }
    /**
     * Constuctor with Bonus to Stats and Type
     * @param type
     * @param bonus 
     */
    public MonsterRace(Type type, int [] bonus){
        super(bonus);
        this.type = type;
       
    }
    /**
     * The grow methode, that makes Monsters stronger and harder to kill.
     */
    @Override
    public void grow() {
        int bonus = 0;
        
        if (this.getType() == Type.EVIL) {
            bonus = 1;
 
        } else if (this.getType() == Type.OFDOOM) {
            bonus = 3;
        } 
        int[] BonusStats = super.getStatsBonus();
        for (int i = 0; i < BonusStats.length; i++) {
            BonusStats[i] += bonus;
        }
        this.setStatsBonus(BonusStats);
        System.out.println(this.getName() + " GROWS");
    }
    /**
     * At the Name to the Type
     * @param name 
     */
    public void setNameWithType(String name){
        switch( this.getType() ){
            case EVIL:
                this.setName( Type.EVIL.value + " " + name );
                break;
            case OFDOOM:
                this.setName( name + " " + Type.OFDOOM.value );
                break;
            default:
                this.setName( name );
                break;
        }
    }
    /**
     * Get the Type
     * @return the type
     */
    public Type getType() {
        return type;
    }
    /**
     * Setting the Type
     * @param type the type to set
     */
    public void setType(Type type) {
        this.type = type;
    }
    /**
     * Getting a Random Type
     * @return Type
     */
    public static Type getRandomType() {
        int randomNumber = Die.rollDie(6, 1);
        Type type; 
        switch (randomNumber) {
            case 1:
                type = Type.OFDOOM;
                break;
            case 2:
                type = Type.EVIL; 
                break;
            case 3:
                type = Type.EVIL;
                break;
            default:
               type = Type.NORMAL;
                break;
        }
        System.out.println(type);
        return type;
    }

    @Override
    public int XP() {
        return BASE_XP; 
    }
    
    
        
}
