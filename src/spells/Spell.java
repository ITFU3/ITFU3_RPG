package spells;

public class Spell
{
  private String name;
  private double castingTime;
  private String spellEffect;
  private int damageDie;
  private int dieCount;
  // ...

  public String getName() {
	return name;
  }
  public void setName(String name) {
	this.name = name;
  }
  public double getCastingTime() {
	return castingTime;
  }
  public void setCastingTime(double castingTime) {
	this.castingTime = castingTime;
  }
  public String getSpellEffect() {
	return spellEffect;
  }
  public void setSpellEffect(String spellEffect) {
	this.spellEffect = spellEffect;
  }
  public int getDamageDie() {
	return damageDie;
  }
  public void setDamageDie(int damageDie) {
	this.damageDie = damageDie;
  }

  public int getDieCount() {
	return dieCount;
  }

  public void setDieCount(int dieCount) {
	this.dieCount = dieCount;
  }
}
