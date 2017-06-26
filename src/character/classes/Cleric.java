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
    String[] profs = {
        Proficiency.NONE.toString(),
        Proficiency.LIGHT_ARMOR.toString(),
        Proficiency.MEDIUM_ARMOR.toString(),
        Proficiency.SHIELDS.toString(),
        Proficiency.SIMPLE_WEAPONS.toString(),
        Proficiency.WISDOM.toString(),
        Proficiency.CHARISMA.toString()
    };
    this.setProficiencies(profs);
  }
}
