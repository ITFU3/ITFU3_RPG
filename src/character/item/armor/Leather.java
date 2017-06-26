package character.item.armor;

import enums.Proficiency;

public class Leather extends Armor
{
  public Leather()
  {
    super();
    this.setArmorValue(11);
    this.setType(Proficiency.ARMOR_LETHER);
    this.setCat(Proficiency.LIGHT_ARMOR);
  }
  
  public Leather(String inputName, int inputArmorValue)
  {
    this();
    this.setName(inputName);
    this.setArmorValue(inputArmorValue);
  }
}
