package character.classes;

import enums.StatsIndex;

public class Wizzard extends PlayerClass
{
  public Wizzard()
  {
    this.setName(this.getClass().getSimpleName());
    int[] BonusStats = super.getStatsBonus();
    BonusStats[StatsIndex.WISDOM.toInt()] += 2;
    BonusStats[StatsIndex.INTELLIGENT.toInt()] += 2;
    BonusStats[StatsIndex.HEALTH.toInt()] += 6;
    this.setStatsBonus(BonusStats);
    String[] profs = {"none","dagger","quaterstaff",
      "darts","sling","light crossbow",
      "intelligence","wisdom"};
    this.setProficiencies(profs);
  }
}
