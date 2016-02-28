package spells;

public class Fireball extends Spell
{
  public Fireball()
  {
	setName(this.getClass().getSimpleName());
	setCastingTime(1);
	setSpellEffect("damage");
	setDamageDie(6);
	setDieCount(4);
  }
}
