package character.races;
public class Race
{
  private String name;
  private int[] BonusStats;
  
  public Race(){
    // strength, dexterity, Constitution, wisdom, inteligent, charisma, movement, health (calculated)
    int[] bonus = {0,0,0,0,0,0,0,0};
    this.setStatsBonus(bonus);
    this.setName("unkown");
  }
  
  public Race(int[] bonus){
      this();
      this.setStatsBonus(bonus);
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
