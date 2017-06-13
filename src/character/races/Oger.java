package character.races;

/**
 *
 * @author Matthias Dröge
 */
public class Oger extends MonsterRace{
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
}
