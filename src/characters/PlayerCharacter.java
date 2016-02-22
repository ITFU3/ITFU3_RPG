package characters;
import classes.*;
import races.*;
import weapons.*;
import armor.*;

public class PlayerCharacter 
{
  private String name;
  private char gender;
  private double experience;
  private PlayerClass pClass;
  private Race pRace;
  private Weapon pWeapon;
  private Armor pArmor;
  private double[] basicStats = new double[8];
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
  
  public PlayerCharacter()
  {
	setName("PlayerCharacter");
	setGender('m');
	double[] defaultStats = {10.0, 10.0, 10.0, 10.0, 10.0, 10.0, 10.0, 50.0};
	setBasicStats(defaultStats);
  }
  public PlayerCharacter(String inputName, char inputGender, PlayerClass inputClass, Race inputRace)
  {
	setName(inputName);
	setGender(inputGender);
	double[] defaultStats = {10.0, 10.0, 10.0, 10.0, 10.0, 10.0, 10.0, 50.0};
	setBasicStats(defaultStats);
	setpClass(inputClass);
	setpRace(inputRace);
  }
  public PlayerCharacter(String inputName, char inputGender, double[] inputStats, PlayerClass inputClass, Race inputRace)
  {
	setName(inputName);
	setGender(inputGender);
	setpClass(inputClass);
	setpRace(inputRace);
	setBasicStats(inputStats);
  }
  
  public void DebugChar()
  {
	String output = "";
	
	output = "Playername: " + getName() + "\n"
		  + "Racename: " + pRace.getName() + "\n"
		  + "Classname: " + pClass.getName() + "\n"
		  + "Gender: "+ getGender() + "\n"
		  + "HP: " + getHealth() + "\n"
		  + "Armor: " + pArmor.getType() + " (" + pArmor.getArmorValue() + ")\n"
		  + "Mov: " + getMovement() + "\n"
		  + "\n"
		  + "Str: " + getStrength() + "\n"
		  + "Dex: " + getDexterity() + "\n"
		  + "Con: " + getConstitution() + "\n"
		  + "Wis: " + getWisdom() + "\n"
		  + "Int: " + getIntelegent() + "\n"
		  + "Cha: " + getCharisma() + "\n"
		  + "\n"
		  + "Weapon: " + pWeapon.getType() + "\n"
		  + "Weaponname: " + pWeapon.getName() + "\n"
		  + "DMG Die: " + pWeapon.getDamageDie() + "\n"
		  + "Die Count: " + pWeapon.getDieCount() + "\n"
		  + "= = = = = = = = = = = = = =\n"
		  ;
	System.out.println(output);
  }
  public void DebugDMG(int Hit_X_Times)
  {
	double cth = 0.0;
	String output = "";
	for(int i = 1; i <= Hit_X_Times; i++)
	{
	  cth = tryHit();
	  output += "Attack " + i + ": ";
	  // Machmal funktioniert das IF nicht 
	  // und ein Wert der größer 10 macht 0 Schaden
	  if( (double) cth >= (double) 10.0 ){
		output += "Hits for " + meleeDamage() + " dmg "; 
	  }else{
		output += "Is a miss. ";
	  }
	  output += "(Rolled: " + cth + ")\n";
	}
	System.out.println(output + "= = = = = = = = = = = = = =\n");
  }
  
  public double tryHit()
  {
	return main.Die.rollDie(20.0, 1.0);
  }
  public double meleeDamage()
  {
	double dmg = main.Die.rollDie(
								  pWeapon.getDamageDie(),
								  pWeapon.getDieCount()
								);
	dmg += getModifier(getStrength());
	// + Proficiency Bonus If exist
	return dmg;
  }

  private double getModifier(double input){
	double output = 0.0;
	switch((int)input)
	{
	  case 1:
		output = -5.0;
		break;
	  case 2:
	  case 3:
		output = -4.0;
		break;
	  case 4:
	  case 5:
		output = -3.0;
		break;
	  case 6:
	  case 7:
		output = -2.0;
		break;
	  case 8:
	  case 9:
		output = -1.0;
		break;
	  case 10:
	  case 11:
		output = 0.0;
		break;
	  case 12:
	  case 13:
		output = 1.0;
		break;
	  case 14:
	  case 15:
		output = 2.0;
		break;
	  case 16:
	  case 17:
		output = 3.0;
		break;
	  case 18:
	  case 19:
		output = 4.0;
		break;
	  case 20:
	  case 21:
		output = 5.0;
		break;
	  case 22:
	  case 23:
		output = 6.0;
		break;
	  case 24:
	  case 25:
		output = 7.0;
		break;
	  case 26:
	  case 27:
		output = 8.0;
		break;
	  case 28:
	  case 29:
		output = 9.0;
		break;
	  case 30:
		output = 10.0;
		break;
	}
	return output;
  }
  
  public void addWeapon(Weapon input)
  {
	setpWeapon(input);
  }
  public void removeWeapon()
  {
	setpWeapon(new Weapon());
  }
  public void addArmor(Armor input)
  {
	setpArmor(input);
  }
  public void removeArmor()
  {
	setpArmor(new Armor());
  }
  
// ################# GETTER | SETTER #################
  public void setBasicStats(double[] input){
	basicStats = input;
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
  public double getStrength(){
	return basicStats[0] + pClass.getStatsBonus()[0] + pRace.getStatsBonus()[0];
  }
  public void setStrength(double input){
	basicStats[0] = input;
  }
  public double getDexterity(){
	return basicStats[1] + pClass.getStatsBonus()[1] + pRace.getStatsBonus()[1];
  }
  public void setDexterity(double input){
	basicStats[1] = input;
  }
  public double getConstitution(){
	return basicStats[2] + pClass.getStatsBonus()[2] + pRace.getStatsBonus()[2];
  }
  public void setConstitution(double input){
	basicStats[2] = input;
  }
  public double getWisdom(){
	return basicStats[3] + pClass.getStatsBonus()[3] + pRace.getStatsBonus()[3];
  }
  public void setWisdom(double input){
	basicStats[3] = input;
  }
  public double getIntelegent(){
	return basicStats[4] + pClass.getStatsBonus()[4] + pRace.getStatsBonus()[4];
  }
  public void setInteligent(double input){
	basicStats[4] = input;
  }
  public double getCharisma(){
	return basicStats[5] + pClass.getStatsBonus()[5] + pRace.getStatsBonus()[5];
  }
  public void setCharisma(double input){
	basicStats[5] = input;
  }
  public double getMovement(){
	return basicStats[6] + pClass.getStatsBonus()[6] + pRace.getStatsBonus()[6];
  }
  public void setMovement(double input){
	basicStats[6] = input;
  }
  public double getHealth(){
	return basicStats[7] + getModifier(getConstitution());
  }
  public void setHealth(double input){
	basicStats[7] = input;
  }
  public double getExperience() {
	return experience;
  }
  public void setExperience(double experience) {
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