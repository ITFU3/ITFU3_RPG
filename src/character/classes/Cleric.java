package character.classes;

import enums.Proficiency;

public class Cleric extends PlayerClass
{
  public Cleric()
  {
    this.setName(this.getClass().getSimpleName());
    int[] BonusStats = super.getStatsBonus();
    BonusStats[Proficiency.WISDOM.getIndex()] += 2;
    BonusStats[Proficiency.CHARISMA.getIndex()] += 2;
    BonusStats[Proficiency.HEALTH.getIndex()] += 8;
    this.setStatsBonus(BonusStats);
    Proficiency[] profs = {
        Proficiency.NONE,
        Proficiency.LIGHT_ARMOR,
        Proficiency.MEDIUM_ARMOR,
        Proficiency.SHIELDS,
        Proficiency.WEAPON_GROUP_SIMPLE,
        Proficiency.WISDOM,
        Proficiency.CHARISMA
    };
    this.setProficiencies(profs);
  }
}
