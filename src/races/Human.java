package races;
public class Human extends Race
{
  private String name;
  private double[] BonusStats;
  // [0] strength
  // [1] dexterity
  // [2] Constitution
  // [3] wisdom
  // [4] inteligent
  // [5] charisma
  // [6] movement
  // [7] health (calculated)
  
  public Human()
  {
	name = this.getClass().getSimpleName();
	super.setName(name);
	BonusStats = new double[8];
	BonusStats = super.getStatsBonus();
	for(int i = 0; i < BonusStats.length; i++)
	{
	  BonusStats[i] += 1;
	}
  }
}
