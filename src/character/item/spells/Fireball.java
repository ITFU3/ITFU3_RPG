package character.item.spells;

import enums.Proficiency;

public class Fireball extends Spell
{
  public Fireball()
  {
    this.setName(this.getClass().getSimpleName());
    this.setCastingTime(1);
    this.setSpellEffect(Proficiency.SPELLEFFECT_DAMAGE);
    this.setDamageDie(6);
    this.setDieCount(4);
    this.setSpellRange(6);
  }
}
