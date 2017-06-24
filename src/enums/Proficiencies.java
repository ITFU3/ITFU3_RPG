package enums;

/**
 *
 * @author Matthias Dröge
 */
public enum Proficiencies {
    NONE("none"),
    
    LIGHT_ARMOR("light armor"),
    MEDIUM_ARMOR("medium armor"),
    HEAVY_ARMOR("heavy armor"),
    
    SHIELDS("shields"),
    
    SIMPLE_WEAPONS("simple weapons"),
    MARTIAL_WEAPONS("martial weapons"),
    
    QUATERSTAFF("quaterstaff"),
    DAGGER("dagger"),
    SHORTSWORD("shortsword"),
    LONGSWORD("longsword"),
    
    DARTS("darts"),
    SLING("sling"),
    LIGHT_CROSSBOW("light crossbow"),
    LONGBOW("longbow"),
    
    STRENGTH("strength"), 
    DEXTERITY("dexterityy"),
    CONSTITUTION("constitution"),
    WISDOM("wisdom"),
    INTELLEGENCE("intellegence"),
    CHARISMA("charisma");
    
    // ========================
    
    private String proficiency;
    private Proficiencies(String s){
        this.proficiency = s;
    }
    @Override
    public String toString() {
        return this.proficiency;
    }
}
