package character.item.weapons;
import character.item.*;
import java.util.Arrays;

//public class Weapon extends Item
public class Weapon extends OffHandItem
{
  private String name;
  private int damageDie;
  private int durability;
  private int dieCount;
  private String type;
  private String cat;
  private int distance;
  private String weaponGroup;
  private String[] properties  = {"none"};
  
  public Weapon()
  {
    this.setName("Fist");
    this.setDamageDie(4);
    this.setDurability(100);
    this.setDieCount(2);
    this.setType("hand");
    this.setCat("melee");
    this.setDistance(1);
    this.setWeaponGroup("none");
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
  public String getWeaponGroup() {
    return weaponGroup;
  }
  public void setWeaponGroup(String weaponGroup) {
    this.weaponGroup = weaponGroup;
  }
  public String[] getProperties() {
    return properties;
  }
  public void setProperties(String[] properties) {
    this.properties = properties;
  }
  public boolean isProperty(String input){
      return Arrays.asList(this.getProperties()).contains(input);
  }
  @Override
  public String toString(){
    return this.getClass().getSimpleName();
  }
}
