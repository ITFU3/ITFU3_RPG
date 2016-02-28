package classes;
import spells.SpellBook;

public class PlayerClass
{
    private String name;
    private double[] BonusStats;
    private SpellBook myBook;
    // [0] strength
    // [1] dexterity
    // [2] Constitution
    // [3] wisdom
    // [4] inteligent
    // [5] charisma
    // [6] movement
    // [7] health (calculated)

    public PlayerClass()
    {
          setName("PlayerClass");
          BonusStats = new double[8];
          for(int i = 0; i < BonusStats.length; i++)
          {
            BonusStats[i] = 0;
          }
          setMyBook(new SpellBook());
    }

    public PlayerClass(Object[] input)
    {
          setName((String) input[0]);
          setStatsBonus((double[]) input[1]);
          setMyBook(new SpellBook());
    }

    // TODO:
    public SpellBook getPBook()
    {
        if(this.getName().equalsIgnoreCase("Wizzard"))
        {
          return getMyBook();
        }
        else
        {
            return getMyBook();
        }
    }

    // ######### Getter / Setter #########
    public double[] getStatsBonus(){
          return BonusStats;
    }
    public void setStatsBonus(double[] input){
          BonusStats = input;
    }
    public String getName(){
          return name;
    }
    public void setName(String name){
          this.name = name;
    }
    public SpellBook getMyBook() {
        return myBook;
    }
    public void setMyBook(SpellBook myBook) {
        this.myBook = myBook;
    }
}
