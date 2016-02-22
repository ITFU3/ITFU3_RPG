package races;
public class Human extends Race
{
  public Human()
  {
	setName(this.getClass().getSimpleName());
	double[] BonusStats = super.getStatsBonus();
	for(int i = 0; i < BonusStats.length; i++)
	{
	  BonusStats[i] += 1;
	}
	setStatsBonus(BonusStats);
  }
}
