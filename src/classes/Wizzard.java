package classes;
import spells.SpellBook;
public class Wizzard extends PlayerClass
{
  private SpellBook myBook;
  
  public Wizzard()
  {
	setName(this.getClass().getSimpleName());
	double[] BonusStats = super.getStatsBonus();
	BonusStats[3] += 2;
	BonusStats[4] += 2;
	setStatsBonus(BonusStats);
        setNewBook();
  }

    public void setNewBook()
    {
        this.myBook = new SpellBook();
    }
    public SpellBook getMyBook() {
        return myBook;
    }
    public void setMyBook(SpellBook myBook) {
        this.myBook = myBook;
    }
}
