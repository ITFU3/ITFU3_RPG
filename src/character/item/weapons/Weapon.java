package character.item.weapons;

import enums.Proficiency;
import character.item.*;
import java.util.ArrayList;
import java.util.Arrays;

//public class Weapon extends Item
public class Weapon extends OffHandItem
{
  private String name;
  private int damageDie;
  private int durability;
  private int dieCount;
  private Proficiency type;
  private Proficiency cat;
  private int distance;
  private Proficiency weaponGroup;
  
  private ArrayList<Proficiency> properties  = new ArrayList();
  
  public Weapon()
  {
    this.setName("NoName");
    this.setDamageDie(4);
    this.setDurability(100);
    this.setDieCount(2);
    this.setType(Proficiency.WEAPON_HAND);
    this.setCat(Proficiency.WEAPON_TYPE_MELEE);
    this.setDistance(1);
    this.setWeaponGroup(Proficiency.NONE);
    
  }

    public Weapon(String name, int damageDie, int durability, int dieCount, Proficiency type, Proficiency cat, int distance, Proficiency weaponGroup) {
        this.name = name;
        this.damageDie = damageDie;
        this.durability = durability;
        this.dieCount = dieCount;
        this.type = type;
        this.cat = cat;
        this.distance = distance;
        this.weaponGroup = weaponGroup;
    }

    public Weapon(Proficiency type) {
        this.type = type;
    }
    
    public void updateNameAndStats(String name, int damageDie, int dieCount, int distance) {
        this.setName(name);
        this.setDamageDie(damageDie);
        this.setDieCount(dieCount);
        this.setDistance(distance);  
    }
    
    public static String getSimpleName(Proficiency type) {
        return "Simple " + type.name();
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
  public Proficiency getType() {
  	return type;
  }
  public void setType(Proficiency type) {
    this.type = type;
  }
  
  public int getDistance() {
    return distance;
  }
  public void setDistance(int distance) {
    this.distance = distance;
  }
  public Proficiency getWeaponGroup() {
    return weaponGroup;
  }
  public void setWeaponGroup(Proficiency weaponGroup) {
    this.weaponGroup = weaponGroup;
  }

    public ArrayList<Proficiency> getProperties() {
        return properties;
    }

    public void setProperties(ArrayList<Proficiency> properties) {
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
