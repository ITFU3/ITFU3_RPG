package character.races;

import interfaces.Growable;
import main.Die;

/**
 *
 * @author Matthias Dröge
 */
public class MonsterRace extends Race implements Growable{

    @Override
    public void grow() {
        // sub
    }
    
    public enum Type {
      NORMAL("normal"),
      EVIL("evil"),
      OFDOOM("of DOOM");
      public String value;
      private Type(String value) {
          this.value = value;
      }
    }
    private Type type;
    
    public MonsterRace() {
        this(Type.NORMAL, 50);
    }

    public MonsterRace(Type type, int xpDrop) {
        super();
        this.type = type;
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
    
    
    
}
