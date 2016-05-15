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
        super.setName("Einfaches Monster: \n" +  Base.Base.randomName(5));
        int[] stats = new int[8];
                stats[super.strength] = 5;
                stats[super.dexterity] = 5;
                stats[super.Constitution] = 5;
                stats[super.wisdom] = 5;
                stats[super.inteligence] = 5;
                stats[super.charisma] = 5;
                stats[super.movement] = 5;
                stats[super.health] = 5;
        this.setBasicStats(stats);
    }
    
    public MonsterCharacter(Race race) {
        this.setpRace(race);
    }
    
}
