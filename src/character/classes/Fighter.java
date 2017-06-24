package character.classes;

import enums.Proficiencies;

public class Fighter extends PlayerClass
{
  public Fighter()
  {
    this.setName(this.getClass().getSimpleName());
    int[] BonusStats = super.getStatsBonus();
    BonusStats[Proficiencies.STRENGTH.getIndex()] += 2;
    BonusStats[Proficiencies.CONSTITUTION.getIndex()] += 2;
    BonusStats[Proficiencies.HEALTH.getIndex()] += 10;
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
