package armor;
public class Plate extends Armor
{
  public Plate()
  {
	setName(this.getClass().getSimpleName());
	setType(this.getClass().getSimpleName());
	setArmorValue(15.0);
  }
  
  public Plate(String inputName, double inputArmorValue)
  {
	setName(inputName);
	setType(this.getClass().getSimpleName());
	setArmorValue(inputArmorValue);
  } 
}
