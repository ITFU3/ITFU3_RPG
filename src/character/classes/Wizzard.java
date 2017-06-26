package character.classes;

import enums.Proficiency;

public class Wizzard extends PlayerClass
{
  public Wizzard()
  {
    this.setName(this.getClass().getSimpleName());
    int[] BonusStats = super.getStatsBonus();
    BonusStats[Proficiency.WISDOM.getIndex()] += 2;
    BonusStats[Proficiency.INTELLEGENCE.getIndex()] += 2;
    BonusStats[Proficiency.HEALTH.getIndex()] += 6;
    this.setStatsBonus(BonusStats);
    Proficiency[] profs = {
        Proficiency.NONE,
        Proficiency.DAGGER,
        Proficiency.QUATERSTAFF,
        Proficiency.DARTS,
        Proficiency.SLING,
        Proficiency.LIGHT_CROSSBOW,
        Proficiency.INTELLEGENCE,
        Proficiency.WISDOM
    };
    this.setProficiencies(profs);
  }
}
