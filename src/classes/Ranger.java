package classes;

public class Ranger extends PlayerClass
{
  public Ranger()
  {
    this.setName(this.getClass().getSimpleName());
    int[] BonusStats = super.getStatsBonus();
    BonusStats[1] += 2;
    BonusStats[3] += 2;
    BonusStats[6] += 2;
    BonusStats[7] += 10;
    this.setStatsBonus(BonusStats);
  }
}
