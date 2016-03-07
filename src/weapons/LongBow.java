package weapons;

public class LongBow extends Weapon
{
  public LongBow()
  {
    this.setName("NoName");
    this.setDamageDie(10);
    this.setDieCount(1);
    this.setDurability(100);
    this.setType(this.getClass().getSimpleName());
    this.setCat("range");
    this.setDistance(15);
    this.setWeaponGroup("martial weapons");
  }
  
  public LongBow(String name, int damageDie, int dieCount, int distance)
  {
    this.setName(name);
    this.setDamageDie(damageDie);
    this.setDieCount(dieCount);
    this.setDurability(100);
    this.setType(this.getClass().getSimpleName());
    this.setCat("range");
    this.setDistance(distance);
    this.setWeaponGroup("martial weapons");
  }
}
