package spells;

public class Spell
{
  private String name;
  private int level;
  private double castingTime;
  private String spellEffect;
  private int damageDie;
  private int dieCount;

  public Spell()
  {
    setName("-");
    setLevel(1);
    setCastingTime(0.0);
    setSpellEffect("-");
    setDamageDie(0);
    setDieCount(0);
  }

  public Spell(Object[] input)
  {
    setName((String)input[0]);
    setLevel((int) input[1]);
    setCastingTime((double) input[2]);
    setSpellEffect((String)input[3]);
    setDamageDie((int) input[4]);
    setDieCount((int) input[5]);
  }
  
  // ######### Getter / Setter #########
  public String getName() {
	return name;
  }
  public void setName(String name) {
	this.name = name;
  }
  public int getLevel(){
    return level;
  }
  public void setLevel(int level){
    this.level = level;
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
