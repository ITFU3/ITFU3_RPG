package classes;
public class Warrior extends PlayerClass
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
  
  public Warrior()
  {
	name = this.getClass().getSimpleName();
	super.setName(name);
	BonusStats = new double[8];
	BonusStats = super.getStatsBonus();
	BonusStats[0] += 2;
	BonusStats[2] += 2;
	
  }
}
