package races;
public class Dwarf extends Race
{
  public Dwarf()
  {
	setName(this.getClass().getSimpleName());
	double[] BonusStats = super.getStatsBonus();
    BonusStats[2] += 2;
    BonusStats[6] -= 2;
	setStatsBonus(BonusStats);
  }
}
