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
    this.setWeaponGroup("simple weapons");
  }
  
  public Mace(String name, int damageDie, int dieCount, int distance)
  {
    this.setName(name);
    this.setDamageDie(damageDie);
    this.setDieCount(dieCount);
    this.setDurability(100);
    this.setType(this.getClass().getSimpleName());
    this.setCat(Proficiencies.MELEE);
    this.setDistance(distance);
    this.setWeaponGroup("simple weapons");
  }
}
