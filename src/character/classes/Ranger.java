package character.classes;

import enums.Proficiencies;

public class Ranger extends PlayerClass
{
  public Ranger()
  {
    this.setName(this.getClass().getSimpleName());
    int[] BonusStats = super.getStatsBonus();
    BonusStats[Proficiencies.DEXTERITY.getIndex()] += 2;
    BonusStats[Proficiencies.WISDOM.getIndex()] += 2;
    BonusStats[Proficiencies.MOVEMENT.getIndex()] += 2;
    BonusStats[Proficiencies.HEALTH.getIndex()] += 10;
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
