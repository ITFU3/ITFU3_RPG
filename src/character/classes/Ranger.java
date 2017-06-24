package character.classes;

import enums.Proficiencies;
import enums.StatsIndex;

public class Ranger extends PlayerClass
{
  public Ranger()
  {
    this.setName(this.getClass().getSimpleName());
    int[] BonusStats = super.getStatsBonus();
    BonusStats[StatsIndex.DEXTERITY.toInt()] += 2;
    BonusStats[StatsIndex.WISDOM.toInt()] += 2;
    BonusStats[StatsIndex.MOVMENT.toInt()] += 2;
    BonusStats[StatsIndex.HEALTH.toInt()] += 10;
    this.setStatsBonus(BonusStats);
    String[] profs = {
        Proficiencies.NONE.toString(),
        Proficiencies.LIGHT_ARMOR.toString(),
        Proficiencies.MEDIUM_ARMOR.toString(),
        Proficiencies.SHIELDS.toString(), 
        Proficiencies.SIMPLE_WEAPONS.toString(),
        Proficiencies.MARTIAL_WEAPONS.toString(),
        Proficiencies.STRENGTH.toString(),
        Proficiencies.DEXTERITY.toString()
    };
    this.setProficiencies(profs);
  }
}
