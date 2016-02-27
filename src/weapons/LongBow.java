package weapons;

public class LongBow extends Weapon
{
  public LongBow()
  {
	setName("NoName");
	setDamageDie(10);
	setDieCount(1);
	setDurability(100.0);
	setType(this.getClass().getSimpleName());
	setCat("range");
	setDistance(15.0);
  }
  
  public LongBow(String name, int damageDie, int dieCount, double distance)
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
