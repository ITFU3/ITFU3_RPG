package character.item.armor;

import enums.Proficiency;

public class ChainMail extends Armor
{
  public ChainMail()
  {
    super();
    this.setArmorValue(16);
    this.setType(Proficiency.ARMOR_CHAINMAIL);
    this.setCat(Proficiency.MEDIUM_ARMOR);
  }
  
  public ChainMail(String inputName, int inputArmorValue)
  {
    this();
    this.setName(inputName);
    this.setArmorValue(inputArmorValue);
  }
}
