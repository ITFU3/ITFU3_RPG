package armor;

public class Leather extends Armor
{
  public Leather()
  {
    this.setName(this.getClass().getSimpleName());
    this.setType(this.getClass().getSimpleName());
    this.setArmorValue(11);
    this.setCat("light");
  }
  
  public Leather(String inputName, int inputArmorValue)
  {
    this.setName(inputName);
    this.setType(this.getClass().getSimpleName());
    this.setArmorValue(inputArmorValue);
  }
}
