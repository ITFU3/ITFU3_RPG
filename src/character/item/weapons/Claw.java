/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character.item.weapons;

import enums.Proficiencies;

/**
 *
 * @author steffen
 */
public class Claw extends Weapon{
    public Claw()
  {
    this.setName("Claw");
    this.setDamageDie(10);
    this.setDieCount(1);
    this.setDurability(100);
    this.setType(this.getClass().getSimpleName());
    this.setCat(Proficiencies.MELEE);
    this.setDistance(2);
    this.setWeaponGroup("simple weapons");
    String[] prop = {"dualhanded"};
    this.setProperties(prop);
  }
  
  public Claw(String name, int damageDie, int dieCount, int distance)
  {
    this.setName(name);
    this.setDamageDie(damageDie);
    this.setDieCount(dieCount);
    this.setDurability(100);
    this.setType(this.getClass().getSimpleName());
    this.setCat(Proficiencies.MELEE);
    this.setDistance(distance);
    this.setWeaponGroup("martial weapons");
  }
    
}
