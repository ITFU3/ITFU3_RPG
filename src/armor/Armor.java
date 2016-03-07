package armor;
public class Armor
{
  private String name;
  private String type;
  private int armorValue;
  private String cat;
  
  public Armor()
  {
    this.setName("None");
    this.setType("None");
    this.setArmorValue(10);
    this.setCat("light");
  }
  
  public Armor(Object[] input)
  {
    this.setName((String) input[0]);
    this.setType((String) input[1]);
    this.setArmorValue((int) input[2]);
  }
    
// ######### Getter / Setter #########
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
  public int getArmorValue() {
    return armorValue;
  }
  public void setArmorValue(int armorValue) {
    this.armorValue = armorValue;
  }
  public String getCat() {
    return cat;
  }
  public void setCat(String cat) {
    this.cat = cat;
  }
}
