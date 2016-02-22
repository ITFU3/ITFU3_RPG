package classes;
public class Wizzard extends PlayerClass
{
  public Wizzard()
  {
	setName(this.getClass().getSimpleName());
	double[] BonusStats = super.getStatsBonus();
	BonusStats[0] += 2;
	BonusStats[2] += 2;
	setStatsBonus(BonusStats);
  }
}
