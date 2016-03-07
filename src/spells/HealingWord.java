package spells;

public class HealingWord extends Spell
{
  public HealingWord()
  {
    this.setName(this.getClass().getSimpleName());
    this.setCastingTime(1);
    this.setSpellEffect("heal");
    this.setDamageDie(4);
    this.setDieCount(2);
  }
}  