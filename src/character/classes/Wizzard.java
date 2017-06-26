package character.classes;

import enums.Proficiency;

public class Wizzard extends PlayerClass
{
  public Wizzard()
  {
    this.setName(this.getClass().getSimpleName());
    int[] BonusStats = super.getStatsBonus();
    BonusStats[Proficiency.WISDOM.getIndex()] += 2;
    BonusStats[Proficiency.INTELLEGENCE.getIndex()] += 2;
    BonusStats[Proficiency.HEALTH.getIndex()] += 6;
    this.setStatsBonus(BonusStats);
    String[] profs = {
        Proficiency.NONE.toString(),
        Proficiency.DAGGER.toString(),
        Proficiency.QUATERSTAFF.toString(),
        Proficiency.DARTS.toString(),
        Proficiency.SLING.toString(),
        Proficiency.LIGHT_CROSSBOW.toString(),
        Proficiency.INTELLEGENCE.toString(),
        Proficiency.WISDOM.toString()
    };
    this.setProficiencies(profs);
  }
}
