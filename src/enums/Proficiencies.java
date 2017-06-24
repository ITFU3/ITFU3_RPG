package enums;

/**
 *
 * @author Matthias Dröge
 */
public enum Proficiencies {
//nothing
    NONE("none"),
//Armor Groups
    LIGHT_ARMOR("light armor"),
    MEDIUM_ARMOR("medium armor"),
    HEAVY_ARMOR("heavy armor"),
//shield group    
    SHIELDS("shields"),
//main weapon groups
    SIMPLE_WEAPONS("simple weapons"),
    MARTIAL_WEAPONS("martial weapons"),
// single melee weapons to list!
    QUATERSTAFF("quaterstaff"),
    DAGGER("dagger"),
    SHORTSWORD("shortsword"),
    LONGSWORD("longsword"),
// single range weapon to list!
    DARTS("darts"),
    SLING("sling"),
    LIGHT_CROSSBOW("light crossbow"),
    LONGBOW("longbow"),
//Stats names
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
