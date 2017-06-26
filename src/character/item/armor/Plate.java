package character.item.armor;

import enums.Proficiency;

public class Plate extends Armor
{
  public Plate()
  {
    this.setName(this.getClass().getSimpleName());
    this.setType(this.getClass().getSimpleName());
    this.setArmorValue(18);
    this.setCat(Proficiency.HEAVY_ARMOR);
  }
  
  public Plate(String inputName, int inputArmorValue)
  {
    this();
    this.setName(inputName);
    this.setArmorValue(inputArmorValue);
  } 
}
