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
    private String type;
    private int armorValue;
    private Proficiency cat;

    public Shield()
    {
      this.setName("none");
      this.setType("none");
      this.setArmorValue(0);
      this.setCat(Proficiency.NONE);
    }

    @Override
    public String toString()
    {
        return this.getType();
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
  public Proficiency getCat() {
    return cat;
  }
    @Override
  public void setCat(Proficiency cat) {
    this.cat = cat;
  }
}
