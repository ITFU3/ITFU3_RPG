package character.classes;
public class Fighter extends PlayerClass
{
  public Fighter()
  {
    this.setName(this.getClass().getSimpleName());
    int[] BonusStats = super.getStatsBonus();
    BonusStats[0] += 2;
    BonusStats[2] += 2;
    BonusStats[7] += 10;
    this.setStatsBonus(BonusStats);
    String[] profs = {"none","light armor","medium armor","heavy armor","shields", 
      "simple weapons","martial weapons","stregnth","constitution"};
    this.setProficiencies(profs);
  }
}
