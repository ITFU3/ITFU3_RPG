package character.races;
public class Race
{
  private String name;
  private int[] BonusStats;
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
    this.setName("unkown");
    this.BonusStats = new int[8];
    for(int i = 0; i < this.BonusStats.length; i++)
    {
      this.BonusStats[i] = 0;
    }
  }
    
  // ######### Getter / Setter #########
  public int[] getStatsBonus(){
    return BonusStats;
  }
  public void setStatsBonus(int[] input){
    this.BonusStats = input;
  }
  public String getName(){
    return name;
  }
  public void setName(String name){
    this.name = name;
  }
}
