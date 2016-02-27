package armor;
public class Armor
{
  private String name;
  private String type;
  private double armorValue;
  
  public Armor()
  {
	setName("None");
	setType("None");
	setArmorValue(10.0);
  }
  
  public Armor(Object[] input)
  {
	setName((String) input[0]);
	setType((String) input[1]);
	setArmorValue((double) input[2]);
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
  
  public Armor(Leather input)
  {
	setName(input.getName());
	setType(input.getType());
	setArmorValue(input.getArmorValue());
  }
  
  public Armor(Cloth input)
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
