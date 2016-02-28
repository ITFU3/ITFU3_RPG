package spells;

public class HealingWord extends Spell
{
  public HealingWord()
  {
    setName(this.getClass().getSimpleName());
    setCastingTime(1);
    setSpellEffect("heal");
    setDamageDie(4);
    setDieCount(2);
  }
}  