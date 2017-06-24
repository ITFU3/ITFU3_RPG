package character.classes;

import enums.Proficiencies;
import enums.StatsIndex;

public class Wizzard extends PlayerClass
{
  public Wizzard()
  {
    this.setName(this.getClass().getSimpleName());
    int[] BonusStats = super.getStatsBonus();
    BonusStats[StatsIndex.WISDOM.toInt()] += 2;
    BonusStats[StatsIndex.INTELLIGENT.toInt()] += 2;
    BonusStats[StatsIndex.HEALTH.toInt()] += 6;
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
