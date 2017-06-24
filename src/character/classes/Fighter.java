package character.classes;

import enums.Proficiencies;
import enums.StatsIndex;

public class Fighter extends PlayerClass
{
  public Fighter()
  {
    this.setName(this.getClass().getSimpleName());
    int[] BonusStats = super.getStatsBonus();
    BonusStats[StatsIndex.STRENGTH.toInt()] += 2;
    BonusStats[StatsIndex.CONSTITUTION.toInt()] += 2;
    BonusStats[StatsIndex.HEALTH.toInt()] += 10;
    this.setStatsBonus(BonusStats);
    String[] profs = {
        Proficiencies.NONE.toString(),
        Proficiencies.LIGHT_ARMOR.toString(),
        Proficiencies.MEDIUM_ARMOR.toString(),
        Proficiencies.HEAVY_ARMOR.toString(),
        Proficiencies.SHIELDS.toString(), 
        Proficiencies.SIMPLE_WEAPONS.toString(),
        Proficiencies.MARTIAL_WEAPONS.toString(),
        Proficiencies.STRENGTH.toString(),
        Proficiencies.CONSTITUTION.toString()
    };
    this.setProficiencies(profs);
  }
}
