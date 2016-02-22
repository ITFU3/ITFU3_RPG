package classes;
public class Warrior extends PlayerClass
{
  public Warrior()
  {
	setName(this.getClass().getSimpleName());
	double[] BonusStats = super.getStatsBonus();
	BonusStats[0] += 2;
	BonusStats[2] += 2;
	setStatsBonus(BonusStats);
  }
}
