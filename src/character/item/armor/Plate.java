package character.item.armor;
public class Plate extends Armor
{
  public Plate()
  {
    this.setName(this.getClass().getSimpleName());
    this.setType(this.getClass().getSimpleName());
    this.setArmorValue(18);
    this.setCat("heavy armor");
  }
  
  public Plate(String inputName, int inputArmorValue)
  {
    this.setName(inputName);
    this.setType(this.getClass().getSimpleName());
    this.setArmorValue(inputArmorValue);
  } 
}
