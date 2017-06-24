package character.item.shields;

import character.item.OffHandItem;

/**
 * @author Matthias Dröge
 */
//public class Shield extends Item
public class Shield extends OffHandItem
{
    private String name;
    private String type;
    private int armorValue;
    private String cat;

    public Shield()
    {
      this.setName("none");
      this.setType("none");
      this.setArmorValue(0);
      this.setCat("none");
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
  public String getCat() {
    return cat;
  }
  public void setCat(String cat) {
    this.cat = cat;
  }
}
