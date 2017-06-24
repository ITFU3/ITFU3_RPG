package character.races;

import enums.StatsIndex;

public class Dwarf extends Race
{
  public Dwarf()
  {
    this.setName(this.getClass().getSimpleName());
    int[] BonusStats = super.getStatsBonus();
    BonusStats[StatsIndex.CONSTITUTION.toInt()] += 2;
    BonusStats[StatsIndex.MOVMENT.toInt()] -= 2;
    this.setStatsBonus(BonusStats);
  }
}
