package character.classes;

import enums.Proficiencies;
import enums.StatsIndex;

public class Cleric extends PlayerClass
{
  public Cleric()
  {
    this.setName(this.getClass().getSimpleName());
    int[] BonusStats = super.getStatsBonus();
    BonusStats[StatsIndex.WISDOM.toInt()] += 2;
    BonusStats[StatsIndex.CHARISMA.toInt()] += 2;
    BonusStats[StatsIndex.HEALTH.toInt()] += 8;
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
