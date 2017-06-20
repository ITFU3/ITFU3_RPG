/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character;

import base.Helper;
import interfaces.Growable;
import character.classes.PlayerClass;
import character.races.monster.MonsterRace;
import character.races.Race;
import character.races.monster.Rat;

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
 * @author Steffen Haas
 * @author Matthias Dröge
 */
public class MonsterCharacter extends PlayerCharacter implements Growable{
    
    
    public MonsterCharacter() {
        this.setName(Helper.randomName(5));
        this.setMapToken('M');
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
        stats[this.health] = 3;
        this.setBasicStats(stats);
        this.setTempHP(this.getHealth());
        this.setAllowedAttacks(1);
        this.setAllowedMoves(this.getMovement());
        this.setAllCoordinates(0, 0);
    }
    
    public MonsterCharacter(int y, int x) {
        this( new Rat() );
        this.setAllCoordinates(y, x);
    }
    
    public MonsterCharacter(int y, int x, Race race){
        this(race);
        this.setAllCoordinates(y, x);
    }
    
    public MonsterCharacter(Race race) {
        this();
        this.setExperience(50);
        this.setpRace(race);
        this.setName(
            this.getName() + " the " + this.getpRace().getName());
            
        // this.setMapToken(  this.getName().toUpperCase().charAt(0) );
        this.setMapToken(  this.getpRace().getClass().getSimpleName().toUpperCase().charAt(0) );

        // get all the Bonuses added to the Stats.
        this.setStatsWithBonus();

        // Player-Level-Bonus for total HP value.
        // Base Stats is 1, therefore this starts with 2!
        if(this.getpClass().getLevel() > 1){
          for(int i = 2; i <= this.getpClass().getLevel(); i++){
            this.setHealth(
              this.getHealth() +
              main.Die.rollDie(this.getpClass().getHitDie(),1)
            );
          }
        }
      
        this.setTempHP(this.getHealth());
      
        this.setAllowedMoves(this.getMovement());
        this.setAllowedAttacks(1);
    }
    
    @Override
    public String showCharInfo()
    {
      // get not used because auto cast from Montser to player ...
      String output;
      output = "Einfaches Monster: " + this.getName() + "\n"
            + "Racename: " + this.getpRace().getName() + "\n"
            + "HP: " + this.getTempHP() + " / " + this.getHealth() + "\n"
            + "STRENGHT:" + this.getStrength()+"\n";
      return output;
    }
    
    public String showAllCharInfo(){
        return super.showCharInfo();
    }
    
    @Override
    public void setMapToken(char mapToken) {
        //safty reason. Because P is for Player!!
        if(mapToken == 'P'){
            this.mapToken = 'M';
        }else{
            this.mapToken = mapToken;
        }
    }

    @Override
    public void grow() {
        if (getpRace() instanceof MonsterRace) {
            ((MonsterRace) getpRace()).grow();
            setStatsWithBonus();
        }
    }
    
    private void setStatsWithBonus() {
        this.setStrength(
              this.getStrength()+
              this.getpClass().getStatsBonus()[this.strength] +
              this.getpRace().getStatsBonus()[this.strength]
        );
        this.setDexterity(
              this.getDexterity() +
              this.getpClass().getStatsBonus()[this.dexterity] +
              this.getpRace().getStatsBonus()[this.dexterity]
        );
        this.setConstitution(
              this.getConstitution() +
              this.getpClass().getStatsBonus()[this.Constitution] +
              this.getpRace().getStatsBonus()[this.Constitution]            
        );
        this.setWisdom(
              this.getWisdom() +
              this.getpClass().getStatsBonus()[this.wisdom] +
              this.getpRace().getStatsBonus()[this.wisdom]            
        );
        this.setInteligent(
              this.getIntelegent() +
              this.getpClass().getStatsBonus()[this.inteligence] +
              this.getpRace().getStatsBonus()[this.inteligence]
        );
        this.setCharisma(
              this.getCharisma() +
              this.getpClass().getStatsBonus()[this.charisma] +
              this.getpRace().getStatsBonus()[this.charisma]
        );
        this.setMovement(
              this.getMovement() +
              this.getpClass().getStatsBonus()[this.movement] +
              this.getpRace().getStatsBonus()[this.movement]
        );
        this.setHealth(
              this.getHealth() +
              this.getpClass().getStatsBonus()[this.health]
              
              //this.getModifier(this.getConstitution()) ???
        );
    }

    
    
    
}
