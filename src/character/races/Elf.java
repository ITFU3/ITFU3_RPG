package character.races;

import enums.Proficiencies;

public class Elf extends Race
{
  public Elf()
  {
    this.setName(this.getClass().getSimpleName());
    int[] BonusStats = super.getStatsBonus();
    BonusStats[Proficiencies.DEXTERITY.getIndex()] += 2;
    BonusStats[Proficiencies.WISDOM.getIndex()] += 2;
    this.setStatsBonus(BonusStats);
  }
}
