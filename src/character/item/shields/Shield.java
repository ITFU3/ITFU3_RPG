package character.item.shields;
import character.item.Item;

/**
 * @author Matthias Dröge
 */
public class Shield extends Item
{
    private String name;
    private String type;
    private int armorValue;
    private String cat;
    private Category category;

    public enum Category
    {
        LIGHT(1.0),
        MEDIUM(0.6),
        HEAVY(0.3);
        private double value;
        private Category(double value)
        {
            this.value = value;
        }
    }

    public enum CategoryString
    {
        LIGHT("light"),
        MEDIUM("medium"),
        HEAVY("heavy");
        private String sValue;
        private CategoryString(String sValue)
        {
            this.sValue = sValue;
        }
    }

    public Shield()
    {
      this.setName("none");
      this.setType("none");
      this.setArmorValue(0);
      this.setCat("none");
    }

    public Shield(Object[] input)
    {
      this.setName((String) input[0]);
      this.setType((String) input[1]);
      this.setArmorValue((int) input[2]);
    }

    @Override
    public String toString()
    {
        return this.getClass().getSimpleName();
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
  public void setArmorCategory(Category category) {
      this.category = category;
  }
  public Category getCategory() {
      return category;
  }
}
