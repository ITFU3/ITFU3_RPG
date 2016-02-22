package armor;
public class Plate extends Armor
{
  private String name;
  private String type;
  private double armorValue;
  
  public Plate()
  {
	setName(this.getClass().getSimpleName());
	setType(this.getClass().getSimpleName());
	setArmorValue(14.0);
  }
  
  public Plate(String inputName, double inputArmorValue)
  {
	setName(inputName);
	setType(this.getClass().getSimpleName());
	setArmorValue(inputArmorValue);
  }

  public String getName() {
	return name;
  }
  public void setName(String name) {
	this.name = name;
  }
  public String getType() {
	return type;
  }
  public void setType(String type) {
	this.type = type;
  }
  public double getArmorValue() {
	return armorValue;
  }
  public void setArmorValue(double armorValue) {
	this.armorValue = armorValue;
  }  
}
