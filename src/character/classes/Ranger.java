package character.classes;

import enums.Proficiency;

public class Ranger extends PlayerClass
{
  public Ranger()
  {
    this.setName(this.getClass().getSimpleName());
    int[] BonusStats = super.getStatsBonus();
    BonusStats[Proficiency.DEXTERITY.getIndex()] += 2;
    BonusStats[Proficiency.WISDOM.getIndex()] += 2;
    BonusStats[Proficiency.MOVEMENT.getIndex()] += 2;
    BonusStats[Proficiency.HEALTH.getIndex()] += 10;
    this.setStatsBonus(BonusStats);
    Proficiency[] profs = {
        Proficiency.NONE,
        Proficiency.LIGHT_ARMOR,
        Proficiency.MEDIUM_ARMOR,
        Proficiency.SHIELDS, 
        Proficiency.SIMPLE_WEAPONS,
        Proficiency.MARTIAL_WEAPONS,
        Proficiency.STRENGTH,
        Proficiency.DEXTERITY
    };
    this.setProficiencies(profs);
  }
}
