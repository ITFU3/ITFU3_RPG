package character.races;

import enums.Proficiency;

public class Dwarf extends Race
{
  public Dwarf()
  {
    this.setName(this.getClass().getSimpleName());
    int[] BonusStats = super.getStatsBonus();
    BonusStats[Proficiency.CONSTITUTION.getIndex()] += 2;
    BonusStats[Proficiency.MOVEMENT.getIndex()] -= 2;
    this.setStatsBonus(BonusStats);
  }
}
