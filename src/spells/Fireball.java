package spells;

public class Fireball extends Spell
{
  public Fireball()
  {
	setName(this.getClass().getSimpleName());
	setCastingTime(1);
	setSpellEffect("An explosion of fire, with an areal effect.");
	setDamageDie(6);
	setDieCount(3);
  }
}
