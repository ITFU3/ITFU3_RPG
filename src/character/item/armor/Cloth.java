package character.item.armor;

import enums.Proficiencies;

public class Cloth extends Armor
{
  public Cloth()
  {
    this.setName(this.getClass().getSimpleName());
    this.setType(this.getClass().getSimpleName());
    this.setArmorValue(10);
    this.setCat(Proficiencies.NONE.toString());
  }
  
  public Cloth(String inputName, int inputArmorValue)
  {
    this();
    this.setName(inputName);
    this.setArmorValue(inputArmorValue);
  }
}
