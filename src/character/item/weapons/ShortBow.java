package character.item.weapons;

import enums.Proficiency;

public class ShortBow extends Weapon
{
  public ShortBow()
  {
    this.setName("NoName");
    this.setDamageDie(8);
    this.setDieCount(1);
    this.setDurability(100);
    this.setType(this.getClass().getSimpleName());
    this.setCat(Proficiency.RANGE);
    this.setDistance(10);
    this.setWeaponGroup(Proficiency.SIMPLE_WEAPONS.toString());
    String[] prop = { Proficiency.DUALHANDED.toString() };
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
