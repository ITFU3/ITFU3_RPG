package weapons;

public class Weapon
{
  private String name;
  private int damageDie;
  private double durability;
  private int dieCount;
  private String type;
  private String cat;
  private double distance;
  
  public Weapon()
  {
	setName("Fist");
	setDamageDie(4);
	setDurability(100.0);
	setDieCount(2);
	setType("Hand");
	setCat("melee");
	setDistance(1.0);
  }
  
  // per Array. Try is funktional.
  public Weapon(Object[] input)
  {
	setName((String)input[0]);
	setDamageDie((int) input[1]);
	setDurability((double) input[2]);
	setDieCount((int)input[3]);
	setType((String) input[4]);
	setCat((String) input[5]);
	setDistance((double) input[6]);
  }
  
  public Weapon(LongSword input)
  {
	setName(input.getName());
	setDamageDie(input.getDamageDie());
	setDurability(input.getDurability());
	setDieCount(input.getDieCount());
	setType(input.getType());
	setCat(input.getCat());
	setDistance(input.getDistance());
  }
  
  public Weapon(Mace input)
  {
	setName(input.getName());
	setDamageDie(input.getDamageDie());
	setDurability(input.getDurability());
	setDieCount(input.getDieCount());
	setType(input.getType());
	setCat(input.getCat());
	setDistance(input.getDistance());
  }
  
  public Weapon(ShortBow input)
  {
	setName(input.getName());
	setDamageDie(input.getDamageDie());
	setDurability(input.getDurability());
	setDieCount(input.getDieCount());
	setType(input.getType());
	setCat(input.getCat());
	setDistance(input.getDistance());
  }
  
  public Weapon(LongBow input)
  {
	setName(input.getName());
	setDamageDie(input.getDamageDie());
	setDurability(input.getDurability());
	setDieCount(input.getDieCount());
	setType(input.getType());
	setCat(input.getCat());
	setDistance(input.getDistance());
  }

  public String getName() {
	return name;
  }
  public void setName(String name) {
	this.name = name;
  }
  public int getDamageDie() {
	return damageDie;
  }
  public void setDamageDie(int damageDie) {
	this.damageDie = damageDie;
  }
  public double getDurability() {
	return durability;
  }
  public void setDurability(double durability) {
	this.durability = durability;
  }
  public int getDieCount() {
	return dieCount;
  }
  public void setDieCount(int dieCount) {
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
  public double getDistance() {
	return distance;
  }
  public void setDistance(double distance) {
	this.distance = distance;
  }
}
