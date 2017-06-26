package character.item.armor;

import enums.Proficiency;

public class Plate extends Armor
{
  public Plate()
  {
    super();
    this.setArmorValue(18);
    this.setType(Proficiency.ARMOR_PLATEMAIL);
    this.setCat(Proficiency.HEAVY_ARMOR);
  }
  
  public Plate(String inputName, int inputArmorValue)
  {
    this();
    this.setName(inputName);
    this.setArmorValue(inputArmorValue);
  } 
}
