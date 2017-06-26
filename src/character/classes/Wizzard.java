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
        Proficiency.WEAPON_DAGGER,
        Proficiency.WEAPON_QUATERSTAFF,
        Proficiency.WEAPON_DARTS,
        Proficiency.WEAPON_SLING,
        Proficiency.WEAPON_LIGHT_CROSSBOW,
        Proficiency.INTELLEGENCE,
        Proficiency.WISDOM
    };
    this.setProficiencies(profs);
  }
}
