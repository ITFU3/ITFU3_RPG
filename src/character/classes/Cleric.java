package character.classes;

public class Cleric extends PlayerClass
{
  public Cleric()
  {
    this.setName(this.getClass().getSimpleName());
    int[] BonusStats = super.getStatsBonus();
    BonusStats[3] += 2;
    BonusStats[5] += 2;
    BonusStats[7] += 8;
    this.setStatsBonus(BonusStats);
    String[] profs = {"none","light armor","medium armor", "shields",
      "simple weapons","wisdom","charisma"};
    this.setProficiencies(profs);
  }
}
