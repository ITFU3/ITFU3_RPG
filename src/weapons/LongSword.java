package weapons;
public class LongSword extends Weapon
{
  public LongSword()
  {
	setName("NoName");
	setDamageDie(8);
	setDieCount(1);
	setDurability(100.0);
	setType(this.getClass().getSimpleName());
	setCat("melee");
  }
  
  public LongSword(String name, int damageDie, int dieCount)
  {
	setName(name);
	setDamageDie(damageDie);
	setDieCount(dieCount);
	setDurability(100.0);
	setType(this.getClass().getSimpleName());
	setCat("melee");
  }
}
