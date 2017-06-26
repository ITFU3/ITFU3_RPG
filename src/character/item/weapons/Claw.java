/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character.item.weapons;

import enums.Proficiency;

/**
 *
 * @author steffen
 */
public class Claw extends Weapon{
    public Claw()
  {
    this.setType(this.getClass().getSimpleName());
    this.setName(this.getType());
    this.setDurability(100);
    this.setDamageDie(10);
    this.setDistance(2);
    this.setDieCount(1);
    this.setCat(Proficiency.MELEE);
    this.setWeaponGroup(Proficiency.SIMPLE_WEAPONS.toString());
    String[] prop = {
        Proficiency.DUALHANDED.toString(),
        Proficiency.REACH.toString()
    };
    this.setProperties(prop);
  }
  
  public Claw(String name, int damageDie, int dieCount, int distance)
  {
    this();
    this.setName(name);
    this.setDamageDie(damageDie);
    this.setDieCount(dieCount);
    this.setDistance(distance);
  }
    
}
