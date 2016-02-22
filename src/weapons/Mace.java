package weapons;
public class Mace extends Weapon
{
  private String name;
  private double damageDie;
  private double durability;
  private double dieCount;
  private String type;
  private String cat;
  
  public Mace()
  {
	this.name = "NoName";
	this.damageDie = 6.0;
	this.dieCount = 1.0;
	this.durability = 100.0;
	this.type = this.getClass().getSimpleName();
	this.cat = "melee";
  }
  
  public Mace(String name, double damageDie, double dieCount)
  {
	this.name = name;
	this.damageDie = damageDie;
	this.dieCount = dieCount;
	this.durability = 100.0;
	this.type = this.getClass().getSimpleName();
	this.cat = "melee";
  }
}
