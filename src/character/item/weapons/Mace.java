package character.item.weapons;

import enums.Proficiencies;

public class Mace extends Weapon
{
  public Mace()
  {
    this.setName("NoName");
    this.setDamageDie(6);
    this.setDieCount(1);
    this.setDurability(100);
    this.setType(this.getClass().getSimpleName());
    this.setCat(Proficiencies.MELEE);
    this.setDistance(1);
    this.setWeaponGroup(Proficiencies.SIMPLE_WEAPONS.toString());
    String[] prop = { Proficiencies.SINGLEHANDED.toString() };
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
