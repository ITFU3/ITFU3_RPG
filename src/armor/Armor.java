package armor;
public class Armor
{
  private String name;
  private String type;
  private double armorValue;
  
  public Armor()
  {
	setName("None");
	setType("Cloth");
	setArmorValue(10.0);
  }
  
  public Armor(Plate input)
  {
	setName(input.getName());
	setType(input.getType());
	setArmorValue(input.getArmorValue());
  }

  public Armor(ChainMail input)
  {
	setName(input.getName());
	setType(input.getType());
	setArmorValue(input.getArmorValue());
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
