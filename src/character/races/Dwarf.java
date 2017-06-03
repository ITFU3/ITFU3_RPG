package character.races;
public class Dwarf extends Race
{
  public Dwarf()
  {
    this.setName(this.getClass().getSimpleName());
    int[] BonusStats = super.getStatsBonus();
    BonusStats[2] += 2;
    BonusStats[6] -= 2;
    this.setStatsBonus(BonusStats);
  }
}
