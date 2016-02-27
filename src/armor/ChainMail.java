package armor;
public class ChainMail extends Armor
{
  public ChainMail()
  {
	setName(this.getClass().getSimpleName());
	setType(this.getClass().getSimpleName());
	setArmorValue(14.0);
  }
  
  public ChainMail(String inputName, double inputArmorValue)
  {
	setName(inputName);
	setType(this.getClass().getSimpleName());
	setArmorValue(inputArmorValue);
  }
}
