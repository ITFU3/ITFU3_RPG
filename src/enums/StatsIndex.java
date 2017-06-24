package enums;

/**
 *
 * @author Matthias Dröge
 */
public enum StatsIndex {
    STRENGTH(0),
    DEXTERITY(1),
    CONSTITUTION(2),
    WISDOM(3),
    INTELLIGENT(4),
    CHARISMA(5),
    MOVMENT(6),
    HEALTH(7);

    private int index;
    private StatsIndex(int input){
        this.index = input;
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.index);
    }
    
    public int toInt(){
        return this.index;
    }
}
