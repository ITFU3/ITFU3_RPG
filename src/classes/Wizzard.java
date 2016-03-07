package classes;
import spells.SpellBook;
public class Wizzard extends PlayerClass
{
  private SpellBook myBook;
  
  public Wizzard()
  {
    this.setName(this.getClass().getSimpleName());
    int[] BonusStats = super.getStatsBonus();
    BonusStats[3] += 2;
    BonusStats[4] += 2;
    BonusStats[7] += 6;
    this.setStatsBonus(BonusStats);
    this.setNewBook();
    String[] profs = {"dagger","quaterstaff",
      "darts","sling","light crossbow",
      "intelligence","wisdom"};
    this.setProficiencies(profs);
  }

    public void setNewBook(){
      this.myBook = new SpellBook();
    }
    public SpellBook getMyBook(){
      return myBook;
    }
    public void setMyBook(SpellBook myBook){
      this.myBook = myBook;
    }
}
