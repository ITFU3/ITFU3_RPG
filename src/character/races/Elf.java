package character.races;

import enums.StatsIndex;

public class Elf extends Race
{
  public Elf()
  {
    this.setName(this.getClass().getSimpleName());
    int[] BonusStats = super.getStatsBonus();
    BonusStats[StatsIndex.DEXTERITY.toInt()] += 2;
    BonusStats[StatsIndex.WISDOM.toInt()] += 2;
    this.setStatsBonus(BonusStats);
  }
}
