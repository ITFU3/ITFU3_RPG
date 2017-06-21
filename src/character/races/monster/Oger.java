package character.races.monster;

/**
 *
 * @author Matthias Dröge
 */
public class Oger extends MonsterRace{
    
    public static int XP  = 400;
    
    
    
    public Oger(){
        this(MonsterRace.getRandomType());
    }
    public Oger(Type type){
        // strength, dexterity, Constitution, wisdom, inteligent, charisma, movement, health (calculated)
        int[] bonus = {5,2,5,0,0,0,0,0};
        
        this.setStatsBonus(bonus);
        this.setType(type);
        this.setNameWithType(this.getClass().getSimpleName());
        
        grow();
    }
    public Oger(Type type, int [] bonus){
        this( type );
        this.setStatsBonus(bonus);
    }
    
    @Override
    public int XP() {
        return XP; 
    }
    
}
