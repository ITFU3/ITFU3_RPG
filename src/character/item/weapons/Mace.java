package character.item.weapons;

import enums.Proficiency;

public class Mace extends Weapon
{
  public Mace()
  {
    this.setName("NoName");
    this.setDamageDie(6);
    this.setDieCount(1);
    this.setDurability(100);
    this.setType(this.getClass().getSimpleName());
    this.setCat(Proficiency.MELEE);
    this.setDistance(1);
    this.setWeaponGroup(Proficiency.SIMPLE_WEAPONS.toString());
    String[] prop = { Proficiency.SINGLEHANDED.toString() };
    this.setProperties(prop);
  }
  
  public Mace(String name, int damageDie, int dieCount, int distance)
  {
    this();
    this.setName(name);
    this.setDamageDie(damageDie);
    this.setDieCount(dieCount);
    this.setDistance(distance);
  }
}
