package races;
public class Elf extends Race
{
  public Elf()
  {
	setName(this.getClass().getSimpleName());
	double[] BonusStats = super.getStatsBonus();
    BonusStats[1] += 2;
    BonusStats[3] += 2;
	setStatsBonus(BonusStats);
  }
}
