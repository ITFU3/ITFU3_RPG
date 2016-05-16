package spells;

public class Spell
{
  private String name;
  private int level;
  private int castingTime;
  private String spellEffect;
  private int damageDie;
  private int dieCount;
  private int spellRange;

  public Spell()
  {
    this.setName("-");
    this.setLevel(1);
    this.setCastingTime(0);
    this.setSpellEffect("-");
    this.setDamageDie(0);
    this.setDieCount(0);
    this.setSpellRange(0);
  }

  public Spell(Object[] input)
  {
    this.setName((String)input[0]);
    this.setLevel((int) input[1]);
    this.setCastingTime((int) input[2]);
    this.setSpellEffect((String)input[3]);
    this.setDamageDie((int) input[4]);
    this.setDieCount((int) input[5]);
    this.setSpellRange((int) input[6]);
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
  public int getCastingTime() {
    return castingTime;
  }
  public void setCastingTime(int castingTime) {
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

  public int getSpellRange() {
    return spellRange;
  }
  public void setSpellRange(int spellRange) {
    this.spellRange = spellRange;
  }
}
