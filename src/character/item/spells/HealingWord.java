package character.item.spells;

import enums.Proficiencies;

public class HealingWord extends Spell
{
  public HealingWord()
  {
    this.setName(this.getClass().getSimpleName());
    this.setCastingTime(1);
    this.setSpellEffect(Proficiencies.HEAL.toString());
    this.setDamageDie(4);
    this.setDieCount(2);
    this.setSpellRange(4);
  }
}  