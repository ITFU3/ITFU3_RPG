package character.item.spells;

import enums.Proficiency;

public class HealingWord extends Spell
{
  public HealingWord()
  {
    this.setName(this.getClass().getSimpleName());
    this.setCastingTime(1);
    this.setSpellEffect(Proficiency.SPELLEFFECT_HEAL);
    this.setDamageDie(4);
    this.setDieCount(2);
    this.setSpellRange(4);
  }
}  