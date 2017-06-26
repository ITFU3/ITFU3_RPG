package character.races;

import enums.Proficiency;

public class Elf extends Race
{
  public Elf()
  {
    this.setName(this.getClass().getSimpleName());
    int[] BonusStats = super.getStatsBonus();
    BonusStats[Proficiency.DEXTERITY.getIndex()] += 2;
    BonusStats[Proficiency.WISDOM.getIndex()] += 2;
    this.setStatsBonus(BonusStats);
  }
}
