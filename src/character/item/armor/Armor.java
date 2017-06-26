package character.item.armor;
import character.item.Item;
import enums.Proficiency;

public class Armor extends Item
{
  private String name;
  private String type;
  private int armorValue;
  
  
  public Armor()
  {
    this.setName("none");
    this.setType("none");
    this.setArmorValue(10);
    this.setCat(Proficiency.NONE);
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
  
  
  @Override
  public String toString(){
      return this.getType();
  }
}
