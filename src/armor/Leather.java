package armor;

public class Leather extends Armor
{
  public Leather()
  {
	setName(this.getClass().getSimpleName());
	setType(this.getClass().getSimpleName());
	setArmorValue(13.0);
  }
  
  public Leather(String inputName, double inputArmorValue)
  {
	setName(inputName);
	setType(this.getClass().getSimpleName());
	setArmorValue(inputArmorValue);
  }
}
