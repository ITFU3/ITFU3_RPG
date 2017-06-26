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
    String[] profs = {
        Proficiency.NONE.toString(),
        Proficiency.LIGHT_ARMOR.toString(),
        Proficiency.MEDIUM_ARMOR.toString(),
        Proficiency.HEAVY_ARMOR.toString(),
        Proficiency.SHIELDS.toString(), 
        Proficiency.SIMPLE_WEAPONS.toString(),
        Proficiency.MARTIAL_WEAPONS.toString(),
        Proficiency.STRENGTH.toString(),
        Proficiency.CONSTITUTION.toString()
    };
    this.setProficiencies(profs);
  }
}
