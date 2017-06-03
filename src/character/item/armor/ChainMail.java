package character.item.armor;
public class ChainMail extends Armor
{
  public ChainMail()
  {
    this.setName(this.getClass().getSimpleName());
    this.setType(this.getClass().getSimpleName());
    this.setArmorValue(16);
    this.setCat("heavy");
  }
  
  public ChainMail(String inputName, int inputArmorValue)
  {
    this.setName(inputName);
    this.setType(this.getClass().getSimpleName());
    this.setArmorValue(inputArmorValue);
  }
}
