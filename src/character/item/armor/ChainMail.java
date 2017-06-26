package character.item.armor;

import enums.Proficiency;

public class ChainMail extends Armor
{
  public ChainMail()
  {
    this.setName(this.getClass().getSimpleName());
    this.setType(this.getClass().getSimpleName());
    this.setArmorValue(16);
    this.setCat(Proficiency.MEDIUM_ARMOR);
  }
  
  public ChainMail(String inputName, int inputArmorValue)
  {
    this();
    this.setName(inputName);
    this.setArmorValue(inputArmorValue);
  }
}
