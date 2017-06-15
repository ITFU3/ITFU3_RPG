package character;

import base.Helper;
import interfaces.Growable;
import character.classes.*;
import character.races.*;

/**
 *
 * @author Steffen Haas
 * @author Matthias Dröge
 */
public class MonsterCharacter extends PlayerCharacter implements Growable{
    
    /**
     * Constuctor that creates a random monster 
     */
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
    }
    
    /**
     * Constuctor that creates rats
     * @param y
     * @param x 
     */
    public MonsterCharacter(int y, int x) {
        this( new Rat() );
        this.setCoordinates(y, x);
        this.setCoordinates_future(y, x);
        this.setCoordinates_past(y, x);
    }
    
    /**
     * Constuctor that creates a monster with a given race.
     * @param y
     * @param x
     * @param race 
     */
    public MonsterCharacter(int y, int x, Race race){
        this(race);
        this.setCoordinates(y, x);
        this.setCoordinates_future(y, x);
        this.setCoordinates_past(y, x);
    }
    
    /**
     * Constuctor that creates a monster with a given race.
     * @param race 
     */
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
        this.setCoordinates(0, 0);
        this.setCoordinates_past(0, 0);
        this.setCoordinates_future(0, 0);
    }
    
    /**
     * show basic monster information
     * @return String
     */
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
    
    /**
     * show advanced monster information
     * @return String
     */
    public String showAllCharInfo(){
        return super.showCharInfo();
    }
    
    /**
     * Safty override to ensure that P marker is for player
     * @param mapToken char
     */
    @Override
    public void setMapToken(char mapToken) {
        //safty reason. Because P is for Player!!
        if(mapToken == 'P'){
            this.mapToken = 'M';
        }else{
            this.mapToken = mapToken;
        }
    }

    /**
     * implementation of the grow method from interface
     */
    @Override
    public void grow() {
        if (getpRace() instanceof MonsterRace) {
            ((MonsterRace) getpRace()).grow();
            // increases the exp that a monster drops by a factor of 2
            this.setExperience( this.getExperience() * 2 );
            // adds the modifier bonus ontop of the grow modifier bonus
            //setStatsWithBonus();
        }
    }
    
    /**
     * Seting the Stats with all class and race boni.
     */
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
