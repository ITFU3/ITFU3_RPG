package character.item.weapons;
public class LongSword extends Weapon
{
  public LongSword()
  {
    this.setName("NoName");
    this.setDamageDie(8);
    this.setDieCount(1);
    this.setDurability(100);
    this.setType(this.getClass().getSimpleName());
    this.setCat("melee");
    this.setDistance(1);
    this.setWeaponGroup("martial weapons");
    String[] prop = {"versitile"};
    this.setProperties(prop);
  }
  
  public LongSword(String name, int damageDie, int dieCount, int distance)
  {
    this.setName(name);
    this.setDamageDie(damageDie);
    this.setDieCount(dieCount);
    this.setDurability(100);
    this.setType(this.getClass().getSimpleName());
    this.setCat("melee");
    this.setDistance(distance);
    this.setWeaponGroup("martial weapons");
  }
}
