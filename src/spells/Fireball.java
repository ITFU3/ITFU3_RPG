package spells;

public class Fireball extends Spell
{
  public Fireball()
  {
    this.setName(this.getClass().getSimpleName());
    this.setCastingTime(1);
    this.setSpellEffect("damage");
    this.setDamageDie(6);
    this.setDieCount(4);
  }
}
