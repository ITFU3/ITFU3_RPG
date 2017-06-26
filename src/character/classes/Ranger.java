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
    String[] profs = {
        Proficiency.NONE.toString(),
        Proficiency.LIGHT_ARMOR.toString(),
        Proficiency.MEDIUM_ARMOR.toString(),
        Proficiency.SHIELDS.toString(), 
        Proficiency.SIMPLE_WEAPONS.toString(),
        Proficiency.MARTIAL_WEAPONS.toString(),
        Proficiency.STRENGTH.toString(),
        Proficiency.DEXTERITY.toString()
    };
    this.setProficiencies(profs);
  }
}
