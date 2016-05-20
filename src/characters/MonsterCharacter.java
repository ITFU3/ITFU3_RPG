/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characters;

import classes.PlayerClass;
import races.Race;
import races.Rat;

/*protected final int strength = 0;
  protected final int dexterity = 1;
  protected final int Constitution = 2;
  protected final int wisdom = 3;
  protected final int inteligence = 4;
  protected final int charisma = 5;
  protected final int movement = 6;
  protected final int health = 7;*/

/**
 *
 * @author steffen
 */
public class MonsterCharacter extends PlayerCharacter {
    
    public MonsterCharacter() {
        this.setName(base.Base.randomName(5));
        this.setGender('m');
        this.setpClass(new PlayerClass());
        int[] stats = new int[8];
        stats[this.strength] = 5;
        stats[this.dexterity] = 5;
        stats[this.Constitution] = 5;
        stats[this.wisdom] = 5;
        stats[this.inteligence] = 5;
        stats[this.charisma] = 5;
        stats[this.movement] = 5;
        stats[this.health] = 5;
        this.setBasicStats(stats);
        this.setTempHP(this.getHealth());
    }
    
    public MonsterCharacter(Race race) {
      this.setName(race.getClass().getSimpleName());
      this.setGender('m');
      this.setpClass(new PlayerClass());
      this.setpRace(race);

      int[] inputStats = new int[8];
      inputStats[this.strength] = 5;
      inputStats[this.dexterity] = 5;
      inputStats[this.Constitution] = 5;
      inputStats[this.wisdom] = 5;
      inputStats[this.inteligence] = 5;
      inputStats[this.charisma] = 5;
      inputStats[this.movement] = 5;
      inputStats[this.health] = 5;
      
      this.setBasicStats(inputStats);
      inputStats[0] += this.getpClass().getStatsBonus()[0] 
                    + this.getpRace().getStatsBonus()[0];
      inputStats[1] += this.getpClass().getStatsBonus()[1] 
                    + this.getpRace().getStatsBonus()[1];
      inputStats[2] += this.getpClass().getStatsBonus()[2] 
                    + this.getpRace().getStatsBonus()[2];
      inputStats[3] += this.getpClass().getStatsBonus()[3] 
                    + this.getpRace().getStatsBonus()[3];
      inputStats[4] += this.getpClass().getStatsBonus()[4] 
                    + this.getpRace().getStatsBonus()[4];
      inputStats[5] += this.getpClass().getStatsBonus()[5] 
                    + this.getpRace().getStatsBonus()[5];
      inputStats[6] += this.getpClass().getStatsBonus()[6] 
                    + this.getpRace().getStatsBonus()[6];
      inputStats[7] += this.getpClass().getStatsBonus()[7];
//      inputStats[7] += this.getModifier(this.getConstitution());
      
      if(this.getpClass().getLevel() > 1){
        for(int i = 2; i <= this.getpClass().getLevel(); i++){
          inputStats[7] += main.Die.rollDie(this.getpClass().getHitDie(),1);
        }
      }
      this.setBasicStats(inputStats);
      this.setExperience(0);
      this.setTempHP(this.getHealth());
    }
    
    @Override
    public void DebugChar()
    {
      // get not used because auto cast from Montser to player ...
      String output;
      output = "Einfaches Monster: " + this.getName() + "\n"
            + "Racename: " + this.getpRace().getName() + "\n"
            + "HP: " + this.getTempHP() + " / " + this.getHealth() + "\n";
      System.out.println(output);
    }
}
