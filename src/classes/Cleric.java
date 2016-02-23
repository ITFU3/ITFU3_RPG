package classes;
public class Cleric extends PlayerClass
{
  public Cleric()
  {
	setName(this.getClass().getSimpleName());
	double[] BonusStats = super.getStatsBonus();
	BonusStats[3] += 2;
	BonusStats[5] += 2;
	setStatsBonus(BonusStats);
  }
}
