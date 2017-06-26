package character.classes;

import enums.Proficiency;

public class Fighter extends PlayerClass
{
  public Fighter()
  {
    this.setName(this.getClass().getSimpleName());
    int[] BonusStats = super.getStatsBonus();
    BonusStats[Proficiency.STRENGTH.getIndex()] += 2;
    BonusStats[Proficiency.CONSTITUTION.getIndex()] += 2;
    BonusStats[Proficiency.HEALTH.getIndex()] += 10;
    this.setStatsBonus(BonusStats);
    Proficiency[] profs = {
        Proficiency.NONE,
        Proficiency.LIGHT_ARMOR,
        Proficiency.MEDIUM_ARMOR,
        Proficiency.HEAVY_ARMOR,
        Proficiency.SHIELDS, 
        Proficiency.WEAPON_GROUP_SIMPLE,
        Proficiency.WEAPON_GROUP_MARTIAL,
        Proficiency.STRENGTH,
        Proficiency.CONSTITUTION
    };
    this.setProficiencies(profs);
  }
}
