package armor;

public class Cloth extends Armor
{
  public Cloth()
  {
    this.setName(this.getClass().getSimpleName());
    this.setType(this.getClass().getSimpleName());
    this.setArmorValue(10);
    this.setCat("light");
  }
  
  public Cloth(String inputName, int inputArmorValue)
  {
    this.setName(inputName);
    this.setType(this.getClass().getSimpleName());
    this.setArmorValue(inputArmorValue);
  }
}
