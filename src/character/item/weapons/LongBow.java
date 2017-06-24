package character.item.weapons;

import enums.Proficiencies;

public class LongBow extends Weapon
{
  public LongBow()
  {
    this.setName("NoName");
    this.setDamageDie(10);
    this.setDieCount(1);
    this.setDurability(100);
    this.setType(this.getClass().getSimpleName());
    this.setCat(Proficiencies.RANGE);
    this.setDistance(15);
    this.setWeaponGroup(Proficiencies.MARTIAL_WEAPONS.toString());
    String[] prop = { Proficiencies.DUALHANDED.toString() };
    this.setProperties(prop);
  }
  
  public LongBow(String name, int damageDie, int dieCount, int distance)
  {
    this();
    this.setName(name);
    this.setDamageDie(damageDie);
    this.setDieCount(dieCount);
    this.setDistance(distance);
  }
}
