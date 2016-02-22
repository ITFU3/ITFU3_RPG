package races;
public class Race
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
  
  public Race()
  {
	name = "PlayerRace";
	BonusStats = new double[8];
	for(int i = 0; i < BonusStats.length; i++)
	{
	  BonusStats[i] = 0;
	}
  }
  
  public Race(Human human)
  {
	this.name = human.getName();
	this.BonusStats = human.getStatsBonus();
  }
  
  public Race(Elf elf)
  {
	this.name = elf.getName();
	this.BonusStats = elf.getStatsBonus();
  }
  
  public Race(Dwarf dwarf)
  {
	this.name = dwarf.getName();
	this.BonusStats = dwarf.getStatsBonus();
  }
  
  public double[] getStatsBonus()
  {
	return BonusStats;
  }
  
  public void setStatsBonus(double[] input)
  {
	BonusStats = input;
  }
  
  public String getName()
  {
	return name;
  }
  
  public void setName(String name)
  {
	this.name = name;
  }
}
