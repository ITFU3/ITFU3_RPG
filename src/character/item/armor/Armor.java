package character.item.armor;
import character.item.Item;
import enums.Proficiency;

public class Armor extends Item
{
  private String name;
  private int armorValue;
  
  
  public Armor()
  {
    this.setName("NoName");
    this.setArmorValue(10);
    this.setType(Proficiency.NONE);
    this.setCat(Proficiency.NONE);
  }
    
// ######### Getter / Setter #########
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  
  public int getArmorValue() {
    return armorValue;
  }
  public void setArmorValue(int armorValue) {
    this.armorValue = armorValue;
  }
}
