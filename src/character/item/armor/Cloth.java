package character.item.armor;

import enums.Proficiency;

public class Cloth extends Armor
{
  public Cloth()
  {
    super();
    this.setArmorValue(10);
    this.setType(Proficiency.ARMOR_CLOTH);
    this.setCat(Proficiency.NONE);
  }
  
  public Cloth(String inputName, int inputArmorValue)
  {
    this();
    this.setName(inputName);
    this.setArmorValue(inputArmorValue);
  }
}
