package character.races;
public class Elf extends Race
{
  public Elf()
  {
    this.setName(this.getClass().getSimpleName());
    int[] BonusStats = super.getStatsBonus();
    BonusStats[1] += 2;
    BonusStats[3] += 2;
    this.setStatsBonus(BonusStats);
  }
}
