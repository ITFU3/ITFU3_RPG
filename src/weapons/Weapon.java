package weapons;

public class Weapon
{
  private String name;
  private double damageDie;
  private double durability;
  private double dieCount;
  private String type;
  private String cat;
  
  public Weapon()
  {
	name = "Fist";
	damageDie = 4.0;
	durability = 100.0;
	dieCount = 2.0;
	type = "Hand";
	cat = "melee";
  }
  
  public Weapon(LongSword input)
  {
	this.name = input.getName();
	this.damageDie = input.getDamageDie();
	this.durability = input.getDurability();
	this.dieCount = input.getDieCount();
	this.type = input.getType();
	this.cat = input.getCat();
  }
  
  public Weapon(Mace input)
  {
	this.name = input.getName();
	this.damageDie = input.getDamageDie();
	this.durability = input.getDurability();
	this.dieCount = input.getDieCount();
	this.type = input.getType();
	this.cat = input.getCat();
  }

  public String getName() {
	return name;
  }
  public void setName(String name) {
	this.name = name;
  }
  public double getDamageDie() {
	return damageDie;
  }
  public void setDamageDie(double damageDie) {
	this.damageDie = damageDie;
  }
  public double getDurability() {
	return durability;
  }
  public void setDurability(double durability) {
	this.durability = durability;
  }
  public double getDieCount() {
	return dieCount;
  }
  public void setDieCount(double dieCount) {
	this.dieCount = dieCount;
  }
  public String getType() {
	return type;
  }
  public void setType(String type) {
	this.type = type;
  }
  public String getCat() {
	return cat;
  }
  public void setCat(String cat) {
	this.cat = cat;
  }
}
