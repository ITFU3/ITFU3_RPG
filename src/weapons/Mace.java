package weapons;
public class Mace extends Weapon
{
  public Mace()
  {
	setName("NoName");
	setDamageDie(6);
	setDieCount(1);
	setDurability(100.0);
	setType(this.getClass().getSimpleName());
	setCat("melee");
	setDistance(1.0);
  }
  
  public Mace(String name, int damageDie, int dieCount, double distance)
  {
	setName(name);
	setDamageDie(damageDie);
	setDieCount(dieCount);
	setDurability(100.0);
	setType(this.getClass().getSimpleName());
	setCat("melee");
	setDistance(distance);
  }
}
