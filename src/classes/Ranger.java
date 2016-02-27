package classes;

public class Ranger extends PlayerClass
{
  public Ranger()
  {
	setName(this.getClass().getSimpleName());
	double[] BonusStats = super.getStatsBonus();
	BonusStats[1] += 2;
	BonusStats[3] += 2;
	BonusStats[6] += 2;
	setStatsBonus(BonusStats);
  }
}
