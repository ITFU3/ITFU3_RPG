package weapons;

public class Weapon
{
  private String name;
  private int damageDie;
  private int durability;
  private int dieCount;
  private String type;
  private String cat;
  private int distance;
  
  public Weapon()
  {
    this.setName("Fist");
    this.setDamageDie(4);
    this.setDurability(100);
    this.setDieCount(2);
    this.setType("Hand");
    this.setCat("melee");
    this.setDistance(1);
  }
  
  public Weapon(Object[] input)
  {
    this.setName((String)input[0]);
    this.setDamageDie((int) input[1]);
    this.setDurability((int) input[2]);
    this.setDieCount((int)input[3]);
    this.setType((String) input[4]);
    this.setCat((String) input[5]);
    this.setDistance((int) input[6]);
  }

  // ######### Getter / Setter #########
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
  public int getDurability() {
  	return durability;
  }
  public void setDurability(int durability) {
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
  public int getDistance() {
    return distance;
  }
  public void setDistance(int distance) {
    this.distance = distance;
  }
}
