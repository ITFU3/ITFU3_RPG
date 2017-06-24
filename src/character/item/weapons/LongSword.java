package character.item.weapons;

import enums.Proficiencies;

public class LongSword extends Weapon
{
  public LongSword()
  {
    this.setName("NoName");
    this.setDamageDie(8);
    this.setDieCount(1);
    this.setDurability(100);
    this.setType(this.getClass().getSimpleName());
    this.setCat(Proficiencies.MELEE);
    this.setDistance(1);
    this.setWeaponGroup(Proficiencies.MARTIAL_WEAPONS.toString());
    String[] prop = { Proficiencies.VERSITILE.toString() };
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
