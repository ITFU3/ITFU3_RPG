package characters;
import classes.*;
import races.*;
import weapons.*;
import armor.*;
import spells.*;

public class PlayerCharacter 
{
  private String name;
  private char gender;
  private int experience;
  private PlayerClass pClass;
  private Race pRace;
  private Weapon pWeapon;
  private Armor pArmor;
  private int[] basicStats = new int[8];
/*
 *	[0] strength
 *	[1] dexterity
 *	[2] Constitution
 *	[3] wisdom
 *	[4] inteligent
 *	[5] charisma
 *	[6] movement
 *	[7] health (calculated)
 *	---
 *	[8] initiative => Fehlt auch noch
 */
  
  public PlayerCharacter(String inputName, char inputGender, PlayerClass inputClass, Race inputRace)
  {
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
    inputStats[7] = this.getpClass().getStatsBonus()[7];
    inputStats[7] += this.getModifier(this.getConstitution());
    if(this.getpClass().getLevel() > 1){
      for(int i = 2; i <= this.getpClass().getLevel(); i++){
        inputStats[7] += main.Die.rollDie(this.getpClass().getHitDie(),1);
      }
    }
    this.setBasicStats(inputStats);
  }
  public PlayerCharacter(String inputName, char inputGender, int[] inputStats, PlayerClass inputClass, Race inputRace)
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
    inputStats[7] = this.getpClass().getStatsBonus()[7];
    inputStats[7] += this.getModifier(this.getConstitution());
    if(this.getpClass().getLevel() > 1){
      for(int i = 2; i <= this.getpClass().getLevel(); i++){
        inputStats[7] += main.Die.rollDie(this.getpClass().getHitDie(),1);
      }
    }
    this.setBasicStats(inputStats);
  }
  
  public void DebugChar()
  {
	String output = "";
	
	output = "Playername: " + this.getName() + "\n"
		  + "Racename: " + this.getpRace().getName() + "\n"
		  + "Classname: " + this.getpClass().getName() + "\n"
		  + "Gender: " + this.getGender() + "\n"
      + "Level: " + this.getpClass().getLevel() + "\n"
		  + "HP: " + this.getHealth() + "\n"
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
		  + "= = = = = = = = = = = = = =\n"
		  ;
	System.out.println(output);
  }
  public void DebugDMG(int Hit_X_Times)
  {
	int cth = 0;
	String output = "";
	for(int i = 1; i <= Hit_X_Times; i++)
	{
	  cth = this.tryHit();
	  output += "Attack " + i + ": ";
	  if( (int) cth >= (int) 10 ){
		output += "Hits for " + this.doDamage() + " dmg "; 
	  }else{
		output += "Is a miss. ";
	  }
	  output += "(Rolled: " + cth + ")\n";
	}
	System.out.println(output + "= = = = = = = = = = = = = =\n");
  }
  
  public int tryHit()
  {
    // Stread D20 roll.
    int output = main.Die.rollDie(20, 1);
    switch(this.getpClass().getName())
    {
      case "wizzard":
        output += this.getModifier(this.getIntelegent());
        break;
      case "ranger":
        output += this.getModifier(this.getDexterity());
        break;
      default:
        output += this.getModifier(this.getStrength());
    }
    return output;
  }
  
  public int doDamage()
  {
	int dmg = 0;
	switch(this.getpWeapon().getCat())
	{
	  // do I have melee weapon?
	  case "melee":
		dmg = this.doMeleeDamage();
		break;
		// do I have range weapon?
	  case "range":
		dmg = this.doRangeDamage();
		break;
	  case "spell":
//		dmg
		break;
	}
	return dmg;
  }
  
  public int doMeleeDamage()
  {
	int dmg = 0;
	// am I close enough to attack?
	if(true)
	{
	  dmg = this.calcDamage();
	}
	else
	{
	  // move closer.
	}
	return dmg;
  }
  
  public int doRangeDamage()
  {
	int dmg = 0;
	// am I distant enough to attack?
	if(true)
	{
	  dmg = this.calcDamage();
	}
	else
	{
	  // move away.
	}
	return dmg;
  }

  private int calcDamage()
  {
	int dmg = main.Die.rollDie(
                    this.getpWeapon().getDamageDie(),
                    this.getpWeapon().getDieCount()
                  );
	dmg += this.getModifier(this.getStrength());
	//TODO: add Proficiency Bonus If exist
	return dmg;
  }
  
  public int castSpell(String spellname)
  {
    int output = 0;
    int spellBookSize = this.getpClass().getMyBook().getSpellBook().size();
    String tempName;
    for(int i = 0; i < spellBookSize; i++)
    {
        tempName = this.getpClass().getMyBook().getSpellBook().get(i).getClass().getSimpleName();
        if(tempName.equalsIgnoreCase(spellname))
        {
          Spell tempSpell = (Spell) this.getpClass().getMyBook().getSpellBook().get(i);
          output = main.Die.rollDie(
                            tempSpell.getDamageDie(),
                            tempSpell.getDieCount()
                          );
        }
    }
    return output;
  }
    
  private int getModifier(int input){
	int output = 0;
	switch((int)input)
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
  
  public void addWeapon(Weapon input)
  {
	this.setpWeapon(input);
  }
  public void removeWeapon()
  {
	this.setpWeapon(new Weapon());
  }
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
  public void removeArmor()
  {
	Armor input = new Armor();
	input.setArmorValue(
		  input.getArmorValue() 
		  + this.getModifier(this.getDexterity())
		);
	this.setpArmor(input);
  }
  
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
}