package character.classes;

import enums.StatsIndex;

public class Cleric extends PlayerClass
{
  public Cleric()
  {
    this.setName(this.getClass().getSimpleName());
    int[] BonusStats = super.getStatsBonus();
    BonusStats[StatsIndex.WISDOM.toInt()] += 2;
    BonusStats[StatsIndex.CHARISMA.toInt()] += 2;
    BonusStats[StatsIndex.HEALTH.toInt()] += 8;
    this.setStatsBonus(BonusStats);
    String[] profs = {"none","light armor","medium armor", "shields",
      "simple weapons","wisdom","charisma"};
    this.setProficiencies(profs);
  }
}
