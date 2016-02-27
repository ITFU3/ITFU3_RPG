package weapons;

public class ShortBow extends Weapon
{
  public ShortBow()
  {
	setName("NoName");
	setDamageDie(8);
	setDieCount(1);
	setDurability(100.0);
	setType(this.getClass().getSimpleName());
	setCat("range");
	setDistance(10.0);
  }
  
  public ShortBow(String name, int damageDie, int dieCount, double distance)
  {
	setName(name);
	setDamageDie(damageDie);
	setDieCount(dieCount);
	setDurability(100.0);
	setType(this.getClass().getSimpleName());
	setCat("range");
	setDistance(distance);
  }
}
