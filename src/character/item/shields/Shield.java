package character.item.shields;

import character.item.OffHandItem;
import enums.Proficiency;

/**
 * @author Matthias Dröge
 */
//public class Shield extends Item
public class Shield extends OffHandItem
{
    private String name;
    private int armorValue;

    public Shield()
    {
      this.setName("NoName");
      this.setArmorValue(0);
      this.setType(Proficiency.SHIELD);
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
