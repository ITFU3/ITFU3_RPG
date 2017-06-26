package character.item.weapons;

import enums.Proficiency;

public class LongSword extends Weapon
{
  public LongSword()
  {
    this.setName("NoName");
    this.setDamageDie(8);
    this.setDieCount(1);
    this.setDurability(100);
    this.setType(Proficiency.WEAPON_LONGSWORD);
    this.setCat(Proficiency.WEAPON_TYPE_MELEE);
    this.setDistance(1);
    this.setWeaponGroup(Proficiency.MARTIAL_WEAPONS);
    String[] prop = { Proficiency.VERSITILE.toString() };
    this.setProperties(prop);
  }
  
  public LongSword(String name, int damageDie, int dieCount, int distance)
  {
    this();
    this.setName(name);
    this.setDamageDie(damageDie);
    this.setDieCount(dieCount);
    this.setDistance(distance);
  }
}
