package classes;
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
  }
}
