package character.classes;

import enums.StatsIndex;

public class Ranger extends PlayerClass
{
  public Ranger()
  {
    this.setName(this.getClass().getSimpleName());
    int[] BonusStats = super.getStatsBonus();
    BonusStats[StatsIndex.DEXTERITY.toInt()] += 2;
    BonusStats[StatsIndex.WISDOM.toInt()] += 2;
    BonusStats[StatsIndex.MOVMENT.toInt()] += 2;
    BonusStats[StatsIndex.HEALTH.toInt()] += 10;
    this.setStatsBonus(BonusStats);
    String[] profs = {"none","light armor","medium armor","shields", 
      "simple weapons","martial weapons","strength","dexterity"};
    this.setProficiencies(profs);
  }
}
