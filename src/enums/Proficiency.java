package enums;

/**
 *
 * @author Matthias Dröge
 */
public enum Proficiency {
//nothing
    NONE("none"),
    
// Armor Type
    LIGHT_ARMOR("light armor"),
    MEDIUM_ARMOR("medium armor"),
    HEAVY_ARMOR("heavy armor"),
    
// Shields    
    SHIELDS("shields"),
    
// Weapon Groups
    SIMPLE_WEAPONS("simple weapons"),
    MARTIAL_WEAPONS("martial weapons"),
    
// Weapon Type
    QUATERSTAFF("quaterstaff"),
    DAGGER("dagger"),
    SHORTSWORD("shortsword"),
    LONGSWORD("longsword"),
    DARTS("darts"),
    SLING("sling"),
    LIGHT_CROSSBOW("light crossbow"),
    LONGBOW("longbow"),
    
// Stats Names
    STRENGTH("strength"), 
    DEXTERITY("dexterityy"),
    CONSTITUTION("constitution"),
    WISDOM("wisdom"),
    INTELLEGENCE("intellegence"),
    CHARISMA("charisma"),
    MOVEMENT("movement"),
    HEALTH("health"),
    
// Weapon Category
    MELEE("melee"), 
    RANGE("range"),
    
// Properties
    DUALHANDED("dualhanded"),
    SINGLEHANDED("singelhanded"),
    VERSITILE("versitile"),
    THROWABLE("throwable"),
    REACH("reach"),//=> distance of 2
    
// Spell Effect
    DAMAGE("damage"),
    HEAL("heal");
// ========================
    
    private String proficiency;
    private Proficiency(String s){
        this.proficiency = s;
    }
    @Override
    public String toString() {
        return this.proficiency;
    }
    
    public int getIndex(){
        int output = -1;
        switch(this){
            case STRENGTH:
                output=0;
                break;
            case DEXTERITY:
                output=1;
                break;
            case CONSTITUTION:
                output=2;
                break;
            case WISDOM:
                output=3;
                break;
            case INTELLEGENCE:
                output=4;
                break;
            case CHARISMA:
                output=5;
                break;
            case MOVEMENT:
                output=6;
                break;
            case HEALTH:
                output=7;
                break;
        }
        return output;
    }
}
