package character.races;

import enums.Proficiencies;

public class Dwarf extends Race
{
  public Dwarf()
  {
    this.setName(this.getClass().getSimpleName());
    int[] BonusStats = super.getStatsBonus();
    BonusStats[Proficiencies.CONSTITUTION.getIndex()] += 2;
    BonusStats[Proficiencies.MOVEMENT.getIndex()] -= 2;
    this.setStatsBonus(BonusStats);
  }
}
