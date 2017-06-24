package character.item.weapons;

import enums.Proficiencies;

public class ShortBow extends Weapon
{
  public ShortBow()
  {
    this.setName("NoName");
    this.setDamageDie(8);
    this.setDieCount(1);
    this.setDurability(100);
    this.setType(this.getClass().getSimpleName());
    this.setCat(Proficiencies.RANGE);
    this.setDistance(10);
    this.setWeaponGroup(Proficiencies.SIMPLE_WEAPONS.toString());
    String[] prop = { Proficiencies.DUALHANDED.toString() };
    this.setProperties(prop);
  }
  
  public ShortBow(String name, int damageDie, int dieCount, int distance)
  {
    this();
    this.setName(name);
    this.setDamageDie(damageDie);
    this.setDieCount(dieCount);
    this.setDistance(distance);
  }
}
