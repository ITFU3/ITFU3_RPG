package character.item.weapons;

public class ShortBow extends Weapon
{
  public ShortBow()
  {
    this.setName("NoName");
    this.setDamageDie(8);
    this.setDieCount(1);
    this.setDurability(100);
    this.setType(this.getClass().getSimpleName());
    this.setCat("range");
    this.setDistance(10);
    this.setWeaponGroup("simple weapons");
  }
  
  public ShortBow(String name, int damageDie, int dieCount, int distance)
  {
    this.setName(name);
    this.setDamageDie(damageDie);
    this.setDieCount(dieCount);
    this.setDurability(100);
    this.setType(this.getClass().getSimpleName());
    this.setCat("range");
    this.setDistance(distance);
    this.setWeaponGroup("simple weapons");
  }
}
