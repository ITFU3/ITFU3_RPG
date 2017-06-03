package character;
import character.races.Race;
import character.classes.PlayerClass;
import character.item.weapons.Weapon;
import character.item.armor.Armor;
import base.Base;

/**
 * @author Matthias Dröge
 */
public class PlayerCharacter extends BaseCharacter 
{
  private String name;
  private char gender;
  private int experience;
  private PlayerClass pClass;
  private Race pRace;
  private Weapon pWeapon;
  private Armor pArmor;
  private int[] basicStats = new int[8];
  private int tempHP;

  protected final int strength = 0;
  protected final int dexterity = 1;
  protected final int Constitution = 2;
  protected final int wisdom = 3;
  protected final int inteligence = 4;
  protected final int charisma = 5;
  protected final int movement = 6;
  protected final int health = 7;
  
 
// ################# CONSTRUCTOR #################
  /**
   * Constructor for PlayerCharacter using
   * the name of the character, the gender,
   * the class and the race
   * @param inputName - String
   * @param inputGender - Char
   * @param inputClass - PlayerClass
   * @param inputRace - Race
   */
  public PlayerCharacter(
          String inputName, 
          char inputGender, 
          PlayerClass inputClass, 
          Race inputRace, int id, int allowedActions)
  {
      super.allowedActions = allowedActions;
      super.id = id;
    this.setName(inputName);
    this.setGender(inputGender);
    this.setpClass(inputClass);
    this.setpRace(inputRace);
    int[] inputStats = {10, 10, 10, 10, 10, 10, 10, 0};
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
    // - - - - - - - - - - - - - - - - - - - - - - - - - - -
    inputStats[6] += this.getpClass().getStatsBonus()[6] 
                  + this.getpRace().getStatsBonus()[6];
    inputStats[7] += this.getpClass().getStatsBonus()[7];
    inputStats[7] += this.getModifier(this.getConstitution());
    if(this.getpClass().getLevel() > 1){
      for(int i = 2; i <= this.getpClass().getLevel(); i++){
        inputStats[7] += main.Die.rollDie(this.getpClass().getHitDie(),1);
      }
    }
    this.setBasicStats(inputStats);
    this.setExperience(0);
    this.setTempHP(this.getHealth());
  }
  /**
   * Constructor for PlayerCharacter using
   * the name of the character, the gender,
   * the starting stats of the character, 
   * the class and the race
   * @param inputName - String
   * @param inputGender - Char
   * @param inputStats - Int Array
   * @param inputClass - PlayerClass
   * @param inputRace - Race
   */
  public PlayerCharacter(
          String inputName, 
          char inputGender, 
          int[] inputStats, 
          PlayerClass inputClass, 
          Race inputRace)
  {
    this.setName(inputName);
    this.setGender(inputGender);
    this.setpClass(inputClass);
    this.setpRace(inputRace);
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
    // - - - - - - - - - - - - - - - - - - - - - - - - - - -
    inputStats[6] += this.getpClass().getStatsBonus()[6] 
                  + this.getpRace().getStatsBonus()[6];
    inputStats[7] += this.getpClass().getStatsBonus()[7];
    inputStats[7] += this.getModifier(this.getConstitution());
    if(this.getpClass().getLevel() > 1){
      for(int i = 2; i <= this.getpClass().getLevel(); i++){
        inputStats[7] += main.Die.rollDie(this.getpClass().getHitDie(),1);
      }
    }
    this.setBasicStats(inputStats);
    this.setExperience(0);
    this.setTempHP(this.getHealth());
  }
  /**
   * Constructor for PlayerCharacter with no parameter.
   * Gives only basic values.
   */
  public PlayerCharacter () {
      this.setName (Base.randomName(5));
      this.setGender(Base.randomGender());
      this.setExperience(100);
      this.setpClass(new PlayerClass());
      this.setpRace(new Race());
      this.setpWeapon(new Weapon());
      this.setpArmor(new Armor());
      
      int[] inputStats = {10, 10, 10, 10, 10, 10, 10, 0};
      this.setBasicStats(inputStats);
      this.setTempHP(this.getHealth());
  }
// ################# EQUIPMENT #################
  /**
   * Puts a weanpon in the characters hand.
   * @param input - Weapon
   */
  public void addWeapon(Weapon input)
  {
    this.setpWeapon(input);
  }
  /**
   * Puts the weanpon out of the characters hand.
   */
  public void removeWeapon()
  {
    this.setpWeapon(new Weapon());
  }
  /**
   * Puts a armor on the characters.
   * @param input - Armor
   */
  public void addArmor(Armor input)
  {
    if(input.getType().equalsIgnoreCase("None"))
    {
      input.setArmorValue(
                      input.getArmorValue() 
                      + this.getModifier(this.getDexterity())
                    );
    }
    setpArmor(input);
  }
  /**
   * Puts the armor off the characters.
   */
  public void removeArmor()
  {
    Armor input = new Armor();
    input.setArmorValue(
        input.getArmorValue() 
        + this.getModifier(this.getDexterity())
      );
    this.setpArmor(input);
  }
// ################# CALCULATIONS #################
  /**
   * Returns the modifier value for the given ability stat value.
   * @param ability - int (the stats value)
   * @return int (modifier)
   */
  public int getModifier(int ability)
  {
	int output = -5;
	switch(ability)
	{
	  case 1:
      output = -5;
      break;
	  case 2:
	  case 3:
      output = -4;
      break;
	  case 4:
	  case 5:
      output = -3;
      break;
	  case 6:
	  case 7:
      output = -2;
      break;
	  case 8:
	  case 9:
      output = -1;
      break;
	  case 10:
	  case 11:
      output = 0;
      break;
	  case 12:
	  case 13:
      output = 1;
      break;
	  case 14:
	  case 15:
      output = 2;
      break;
	  case 16:
	  case 17:
      output = 3;
      break;
	  case 18:
	  case 19:
      output = 4;
      break;
	  case 20:
	  case 21:
      output = 5;
      break;
	  case 22:
	  case 23:
      output = 6;
      break;
	  case 24:
	  case 25:
      output = 7;
      break;
	  case 26:
	  case 27:
      output = 8;
      break;
	  case 28:
	  case 29:
      output = 9;
      break;
	  case 30:
      output = 10;
      break;
	}
	return output;
  }
  /**
   * Returns the calculated max Armor value of the Character.
   * @return - int
   */
  public int getAC()
  {
    if(this.getpArmor().getCat().equalsIgnoreCase("heavy"))
    {
      return this.getpArmor().getArmorValue();
    }
    else
    {
      return (this.getpArmor().getArmorValue() 
            + this.getModifier(this.getDexterity()));
    }
  }
  /**
   * Returns the initiative value of the Character.
   * (incl. die roll)
   * @return - int
   */
  public int getInitiative()
  {
    return (main.Die.rollDie(20, 1) + this.getModifier(this.getDexterity()));
  }
  /**
   * Returns the passiv perception value of the Character.
   * @return - int
   */
  public int getPassivPerception()
  {
    return (10 + this.getWisdom());
  }
  /**
   * Returns the (activ) perception value of the Character.
   * (incl. die roll)
   * @return - int
   */
  public int getActivPerception()
  {
    return (main.Die.rollDie(20, 1) + this.getModifier(this.getWisdom()));
  }
  /**
   * Return if for a given type of weapon oder armor etc,
   * the character has a proficiency given by his class.
   * @param inputType - String (type of weapon oder armor)
   * @return - boolean
   */
  public boolean isProfThere(String inputType)
  {
    boolean output = false;
    /**
     * This is a new thing in java called "foreach"
     * Foreach element from array "this.getpClass().getProficiencies()"
     * as "String proficiency"
     */ 
    for(String proficiency : this.getpClass().getProficiencies())
    {
      if(proficiency.equalsIgnoreCase(inputType))
      {
        output = true;
      }
    }
    return output;
  }
  /**
   * Returns the proficiency bonus
   * OR the character level
   * by experience points
   * @param fork - char [l]evel | [p]roficiency
   * @return - int (Level | Proficiency Bonus)
   */
  public int getProficiencyOrLevel(char fork)
  {
    int xp = this.getExperience();
    int output = 0;
    if(xp >= 0){
      if(fork == 'l'){
        output = 1;
      }else if(fork == 'p'){
        output = 2;
      }
    }else if(xp >= 300){
      if(fork == 'l')
      {
        output = 2;
      }
      else if(fork == 'p')
      {
        output = 2;
      }
    }else if(xp >= 900){
      if(fork == 'l'){
        output = 3;
      }else if(fork == 'p'){
        output = 2;
      }
    }else if(xp >= 2700){
     if(fork == 'l'){
        output = 4;
      }else if(fork == 'p'){
        output = 2;
      }
    }else if(xp >= 6500){
      if(fork == 'l'){
        output = 5;
      }else if(fork == 'p'){
        output = 3;
      }
    }else if(xp >= 14000){
      if(fork == 'l'){
        output = 6;
      }else if(fork == 'p'){
        output = 3;
      }
    }else if(xp >= 23000){
      if(fork == 'l'){
        output = 7;
      }else if(fork == 'p'){
        output = 3;
      }
    }else if(xp >= 34000){
      if(fork == 'l'){
        output = 8;
      }else if(fork == 'p'){
        output = 3;
      }
    }else if(xp >= 48000){
      if(fork == 'l'){
        output = 9;
      }else if(fork == 'p'){
        output = 4;
      }
    }else if(xp >= 64000){
      if(fork == 'l'){
        output = 10;
      }else if(fork == 'p'){
        output = 4;
      }
    }else if(xp >= 85000){
      if(fork == 'l'){
        output = 11;
      }else if(fork == 'p'){
        output = 4;
      }
    }else if(xp >= 100000){
      if(fork == 'l'){
        output = 12;
      }else if(fork == 'p'){
        output = 4;
      }
    }else if(xp >= 120000){
      if(fork == 'l'){
        output = 13;
      }else if(fork == 'p'){
        output = 5;
      }
    }else if(xp >= 140000){
      if(fork == 'l'){
        output = 14;
      }else if(fork == 'p'){
        output = 5;
      }
    }else if(xp >= 165000){
      if(fork == 'l'){
        output = 15;
      }else if(fork == 'p'){
        output = 5;
      }
    }else if(xp >= 195000){
      if(fork == 'l'){
        output = 16;
      }else if(fork == 'p'){
        output = 5;
      }
    }else if(xp >= 225000){
      if(fork == 'l'){
        output = 17;
      }else if(fork == 'p'){
        output = 6;
      }
    }else if(xp >= 265000){
      if(fork == 'l'){
        output = 18;
      }else if(fork == 'p'){
        output = 6;
      }
    }else if(xp >= 305000){
      if(fork == 'l'){
        output = 19;
      }else if(fork == 'p'){
        output = 6;
      }
    }else if(xp >= 355000){
      if(fork == 'l'){
        output = 20;
      }else if(fork == 'p'){
        output = 6;
      }
    }
    return output;
  }
  
// ################# OUTPUT #################
  /**
   * Printout of all important information of the character.
   * @return - String
   */
  public String showCharInfo()
  {
    String output = "Playername: " + this.getName() + "\n"
        + "Racename: " + this.getpRace().getName() + "\n"
        + "Classname: " + this.getpClass().getName() + "\n"
        + "Gender: " + this.getGender() + "\n"
        + "Level: " + this.getpClass().getLevel() + "\n"
        + "HP: " + this.getTempHP() + " / " + this.getHealth() + "\n"
        + "Armor: " + this.getpArmor().getType() + " (" 
                    + this.getAC() + ")\n"
        + "Mov: " + this.getMovement() + "\n"
        + "\n"
        + "Str: " + this.getStrength() + " | " + this.getModifier(this.getStrength()) + "\n"
        + "Dex: " + this.getDexterity() + " | " + this.getModifier(this.getDexterity())+ "\n"
        + "Con: " + this.getConstitution() + " | " + this.getModifier(this.getConstitution())+ "\n"
        + "Wis: " + this.getWisdom() + " | " + this.getModifier(this.getWisdom())+ "\n"
        + "Int: " + this.getIntelegent() + " | " + this.getModifier(this.getIntelegent())+ "\n"
        + "Cha: " + this.getCharisma() + " | " + this.getModifier(this.getCharisma())+ "\n"
        + "\n"
        + "Weapon: " + this.getpWeapon().getType() + "\n"
        + "Weaponname: " + this.getpWeapon().getName() + "\n"
        + "DMG Die: " + this.getpWeapon().getDamageDie() + "\n"
        + "Die Count: " + this.getpWeapon().getDieCount() + "\n"
        + "Weapon Type: " + this.getpWeapon().getType() + "\n"
        + "Weapon Range: " + this.getpWeapon().getDistance() + "\n"
        + "= = = = = = = = = = = = = =\n";
    if(this.getpClass().getName().equalsIgnoreCase("wizzard") 
    || this.getpClass().getName().equalsIgnoreCase("cleric")){
      output += "'Spellbook':\n" + this.getpClass().getMyBook().showSpellBook() + "\n";
    }
    return output;
  }
  
// ################# GETTER | SETTER #################
  public void setBasicStats(int[] input){
	this.basicStats = input;
  }
  public String getName() {
	return name;
  }
  public void setName(String name) {
	this.name = name;
  }
  public char getGender() {
	return gender;
  }
  public void setGender(char gender) {
	this.gender = gender;
  }
  public int getStrength(){
	return basicStats[0];
  }
  public void setStrength(int input){
	this.basicStats[0] = input;
  }
  public int getDexterity(){
	return basicStats[1];
  }
  public void setDexterity(int input){
	this.basicStats[1] = input;
  }
  public int getConstitution(){
	return basicStats[2];
  }
  public void setConstitution(int input){
	this.basicStats[2] = input;
  }
  public int getWisdom(){
	return basicStats[3];
  }
  public void setWisdom(int input){
	this.basicStats[3] = input;
  }
  public int getIntelegent(){
	return basicStats[4];
  }
  public void setInteligent(int input){
	this.basicStats[4] = input;
  }
  public int getCharisma(){
	return basicStats[5];
  }
  public void setCharisma(int input){
	this.basicStats[5] = input;
  }
  public int getMovement(){
	return basicStats[6];
  }
  public void setMovement(int input){
	this.basicStats[6] = input;
  }
  public int getHealth(){
	return basicStats[7];
  }
  public void setHealth(int input){
	this.basicStats[7] = input;
  }
  public int getExperience() {
	return experience;
  }
  public void setExperience(int experience) {
	this.experience = experience;
  }
  public PlayerClass getpClass() {
	return pClass;
  }
  public void setpClass(PlayerClass pClass) {
	this.pClass = pClass;
  }
  public Race getpRace() {
	return pRace;
  }
  public void setpRace(Race pRace) {
	this.pRace = pRace;
  }
  public Weapon getpWeapon(){
	return pWeapon;
  }
  public void setpWeapon(Weapon pWeapon){
	this.pWeapon = pWeapon;
  }
  public Armor getpArmor() {
	return pArmor;
  }
  public void setpArmor(Armor pArmor) {
	this.pArmor = pArmor;
  }
  public int getTempHP() {
      return tempHP;
  }
  public void setTempHP(int tempHP) {
      this.tempHP = tempHP;
  }

    @Override
    public String toString() {
        return getName(); //To change body of generated methods, choose Tools | Templates.
    }
  
  
}