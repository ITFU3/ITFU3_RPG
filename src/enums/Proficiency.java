package enums;

/**
 *
 * @author Matthias Dröge
 */
public enum Proficiency {
//nothing
//nothing
    NONE("none"),
    
// Armor Groups
    LIGHT_ARMOR("light armor"),
    MEDIUM_ARMOR("medium armor"),
    HEAVY_ARMOR("heavy armor"),
    
// Armor Types
    ARMOR_CLOTH("cloth"),
    ARMOR_LETHER("leather"),
    ARMOR_CHAINMAIL("chainmail"),
    ARMOR_PLATEMAIL("platemail"),
    
// Shield Group
    SHIELD("shield"),
    
// Shield Types
    SMALL_SHIELD("small shield"),
    MEDIUM_SHIELD("medium shield"),
    HEAVY_SHIELD("heavy shield"),
    
// Weapon Groups
    WEAPON_GROUP_SIMPLE("simple weapons"),
    WEAPON_GROUP_MARTIAL("martial weapons"),
    
// Weapon Type
    WEAPON_HAND("hand"),
    WEAPON_HANDAXE("handaxe"),
    WEAPON_QUATERSTAFF("quaterstaff"),
    WEAPON_MACE("mace"),
    WEAPON_DAGGER("dagger"),
    WEAPON_SHORTSWORD("shortsword"),
    WEAPON_LONGSWORD("longsword"),
    WEAPON_DARTS("darts"),
    WEAPON_SLING("sling"),
    WEAPON_LIGHT_CROSSBOW("light crossbow"),
    WEAPON_SHORTBOW("shortbow"),
    WEAPON_LONGBOW("longbow"),
    WEAPON_CLAW("claw"),
    
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
    WEAPON_TYPE_MELEE("melee"), 
    WEAPON_TYPE_RANGE("range"),
    
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
