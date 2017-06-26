package character.item.armor;
import character.item.Item;
import enums.Proficiency;

public class Armor extends Item
{
  private int armorValue;
  
  public Armor()
  {
    this.setName("NoName");
    this.setArmorValue(10);
    this.setType(Proficiency.NONE);
    this.setCat(Proficiency.NONE);
  }
    
// ######### Getter / Setter #########
  public int getArmorValue() {
    return armorValue;
  }
  public void setArmorValue(int armorValue) {
    this.armorValue = armorValue;
  }
}
