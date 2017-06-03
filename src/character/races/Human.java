package character.races;
public class Human extends Race
{
  public Human()
  {
    this.setName(this.getClass().getSimpleName());
    int[] BonusStats = super.getStatsBonus();
    for(int i = 0; i < BonusStats.length; i++)
    {
      BonusStats[i] += 1;
    }
    this.setStatsBonus(BonusStats);
  }
}
