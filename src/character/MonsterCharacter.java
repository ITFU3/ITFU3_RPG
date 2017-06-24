/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character;

import base.*;
import interfaces.*;
import character.classes.*;
import character.races.monster.*;
import character.races.*;
import enums.Proficiencies;

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
        stats[Proficiencies.STRENGTH.getIndex()] = 5;
        stats[Proficiencies.DEXTERITY.getIndex()] = 5;
        stats[Proficiencies.CONSTITUTION.getIndex()] = 5;
        stats[Proficiencies.WISDOM.getIndex()] = 5;
        stats[Proficiencies.INTELLEGENCE.getIndex()] = 5;
        stats[Proficiencies.CHARISMA.getIndex()] = 5;
        stats[Proficiencies.MOVEMENT.getIndex()] = 5;
        stats[Proficiencies.HEALTH.getIndex()] = 3;
        this.setBasicStats(stats);
        this.setTempHP(this.getHealth());
        this.setAllowedAttacks(1);
        this.setAllowedMoves(this.getMovement());
        this.setAllCoordinates(0, 0);
    }
    /**
     * will create Rat as Base Monster
     * 
     * parameters are coordinates on Map
     * 
     * @param y 
     * @param x 
     */
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
        int mXP = getXPDependentOnMonsterRaceType(race);
        this.setExperience(mXP);
        // add 
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
            + "XP: " + this.getExperience() + "\n"
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
        }
    }
    
    private void setStatsWithBonus() {
        this.setStrength(
              this.getStrength()+
              this.getpClass().getStatsBonus()[Proficiencies.STRENGTH.getIndex()] +
              this.getpRace().getStatsBonus()[Proficiencies.STRENGTH.getIndex()]
        );
        this.setDexterity(
              this.getDexterity() +
              this.getpClass().getStatsBonus()[Proficiencies.DEXTERITY.getIndex()] +
              this.getpRace().getStatsBonus()[Proficiencies.DEXTERITY.getIndex()]
        );
        this.setConstitution(
              this.getConstitution() +
              this.getpClass().getStatsBonus()[Proficiencies.CONSTITUTION.getIndex()] +
              this.getpRace().getStatsBonus()[Proficiencies.CONSTITUTION.getIndex()]            
        );
        this.setWisdom(
              this.getWisdom() +
              this.getpClass().getStatsBonus()[Proficiencies.WISDOM.getIndex()] +
              this.getpRace().getStatsBonus()[Proficiencies.WISDOM.getIndex()]            
        );
        this.setIntellegence(
              this.getIntellegence() +
              this.getpClass().getStatsBonus()[Proficiencies.INTELLEGENCE.getIndex()] +
              this.getpRace().getStatsBonus()[Proficiencies.INTELLEGENCE.getIndex()]
        );
        this.setCharisma(
              this.getCharisma() +
              this.getpClass().getStatsBonus()[Proficiencies.CHARISMA.getIndex()] +
              this.getpRace().getStatsBonus()[Proficiencies.CHARISMA.getIndex()]
        );
        this.setMovement(
              this.getMovement() +
              this.getpClass().getStatsBonus()[Proficiencies.MOVEMENT.getIndex()] +
              this.getpRace().getStatsBonus()[Proficiencies.MOVEMENT.getIndex()]
        );
        this.setHealth(
              this.getHealth() +
              this.getpClass().getStatsBonus()[Proficiencies.HEALTH.getIndex()]
              
              //this.getModifier(this.getConstitution()) ???
        );
    }

    public int getXPDependentOnMonsterRaceType(Race race) {
        int mXP = race.XP();
        if (race instanceof MonsterRace) {
            MonsterRace.Type type = ((MonsterRace)race).getType();
            switch (type) {
                case OFDOOM:
                    mXP += MonsterRace.Type.OFDOOM_XP_BONUS;
                    break;
                case EVIL:
                    mXP += MonsterRace.Type.EVIL_XP_BONUS;
                    break;
            }
            System.out.println("################################");
            System.out.println("XP UPDATED");
            System.out.println(race.getName() + " XP: " + mXP);
            System.out.println("################################");
        }
        return mXP;
    }   
}