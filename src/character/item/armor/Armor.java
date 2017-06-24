package character.item.armor;
import character.item.Item;

public class Armor extends Item
{
  private String name;
  private String type;
  private int armorValue;
  private String cat;
  
  public Armor()
  {
    this.setName("none");
    this.setType("none");
    this.setArmorValue(10);
    this.setCat("none");
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
  
  @Override
  public String toString(){
      return this.getType();
  }
}
