package character.classes;

public class Wizzard extends PlayerClass
{
  public Wizzard()
  {
    this.setName(this.getClass().getSimpleName());
    int[] BonusStats = super.getStatsBonus();
    BonusStats[3] += 2;
    BonusStats[4] += 2;
    BonusStats[7] += 6;
    this.setStatsBonus(BonusStats);
    String[] profs = {"dagger","quaterstaff",
      "darts","sling","light crossbow",
      "intelligence","wisdom"};
    this.setProficiencies(profs);
  }
}
