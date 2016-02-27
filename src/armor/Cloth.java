package armor;

public class Cloth extends Armor
{
  public Cloth()
  {
	setName(this.getClass().getSimpleName());
	setType(this.getClass().getSimpleName());
	setArmorValue(12.0);
  }
  
  public Cloth(String inputName, double inputArmorValue)
  {
	setName(inputName);
	setType(this.getClass().getSimpleName());
	setArmorValue(inputArmorValue);
  }
}
