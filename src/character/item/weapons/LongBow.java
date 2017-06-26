package character.item.weapons;

import enums.Proficiency;

public class LongBow extends Weapon
{
  public LongBow()
  {
    this.setName("NoName");
    this.setDamageDie(10);
    this.setDieCount(1);
    this.setDurability(100);
    this.setType(Proficiency.WEAPON_LONGBOW);
    this.setCat(Proficiency.WEAPON_TYPE_RANGE);
    this.setDistance(15);
    this.setWeaponGroup(Proficiency.MARTIAL_WEAPONS);
    String[] prop = { Proficiency.DUALHANDED.toString() };
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
