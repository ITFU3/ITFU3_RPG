package character.races;

/**
 *
 * @author Matthias Dröge
 */
public class monsterRace extends Race{
    
    public enum Type {
      NORMAL("normal"),
      EVIL("evil"),
      OFDOOM("of doom");
      public String value;
      private Type(String value) {
          this.value = value;
      }
    }
    private Type type;
    
    public monsterRace() {
        this(Type.NORMAL, 50);
    }

    public monsterRace(Type type, int xpDrop) {
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
}
