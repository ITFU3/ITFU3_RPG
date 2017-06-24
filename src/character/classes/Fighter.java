package character.classes;

import enums.StatsIndex;

public class Fighter extends PlayerClass
{
  public Fighter()
  {
    this.setName(this.getClass().getSimpleName());
    int[] BonusStats = super.getStatsBonus();
    BonusStats[StatsIndex.STRENGTH.toInt()] += 2;
    BonusStats[StatsIndex.CONSTITUTION.toInt()] += 2;
    BonusStats[StatsIndex.HEALTH.toInt()] += 10;
    this.setStatsBonus(BonusStats);
    String[] profs = {"none","light armor","medium armor","heavy armor","shields", 
      "simple weapons","martial weapons","stregnth","constitution"};
    this.setProficiencies(profs);
  }
}
