package character.classes;

import enums.Proficiencies;

public class Wizzard extends PlayerClass
{
  public Wizzard()
  {
    this.setName(this.getClass().getSimpleName());
    int[] BonusStats = super.getStatsBonus();
    BonusStats[Proficiencies.WISDOM.getIndex()] += 2;
    BonusStats[Proficiencies.INTELLEGENCE.getIndex()] += 2;
    BonusStats[Proficiencies.HEALTH.getIndex()] += 6;
    this.setStatsBonus(BonusStats);
    String[] profs = {
        Proficiencies.NONE.toString(),
        Proficiencies.DAGGER.toString(),
        Proficiencies.QUATERSTAFF.toString(),
        Proficiencies.DARTS.toString(),
        Proficiencies.SLING.toString(),
        Proficiencies.LIGHT_CROSSBOW.toString(),
        Proficiencies.INTELLEGENCE.toString(),
        Proficiencies.WISDOM.toString()
    };
    this.setProficiencies(profs);
  }
}
