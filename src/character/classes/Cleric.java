package character.classes;

import enums.Proficiencies;

public class Cleric extends PlayerClass
{
  public Cleric()
  {
    this.setName(this.getClass().getSimpleName());
    int[] BonusStats = super.getStatsBonus();
    BonusStats[Proficiencies.WISDOM.getIndex()] += 2;
    BonusStats[Proficiencies.CHARISMA.getIndex()] += 2;
    BonusStats[Proficiencies.HEALTH.getIndex()] += 8;
    this.setStatsBonus(BonusStats);
    String[] profs = {
        Proficiencies.NONE.toString(),
        Proficiencies.LIGHT_ARMOR.toString(),
        Proficiencies.MEDIUM_ARMOR.toString(),
        Proficiencies.SHIELDS.toString(),
        Proficiencies.SIMPLE_WEAPONS.toString(),
        Proficiencies.WISDOM.toString(),
        Proficiencies.CHARISMA.toString()
    };
    this.setProficiencies(profs);
  }
}
