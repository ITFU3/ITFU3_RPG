package characters;
import classes.*;
import races.*;
import weapons.*;
import armor.*;
import spells.*;
import backpack.*;
import Base.*;

public class PlayerCharacter 
{
  private String name;
  private char gender;
  private int experience;
  private PlayerClass pClass;
  private Race pRace;
  private Weapon pWeapon;
  private Armor pArmor;
  private Backpack backpack = new Backpack();
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
  
  public PlayerCharacter () {
      this.setName (Base.randomName(5));
      this.setGender(Base.randomGender());
      this.setExperience(100);
      this.setpClass(new PlayerClass());
      this.setpRace(new Race());
      this.setpWeapon(new Weapon());
      this.setpArmor(new Armor());
      this.setBackpack(new Backpack());
      
      int[] inputStats = {10, 10, 10, 10, 10, 10, 10, 0};
      this.setBasicStats(inputStats);
      this.setTempHP(this.getHealth());
  }
  
// ################# EQUIPMENT #################
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
  
// ################# CALCULATIONS #################
  protected int getModifier(int ability)
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
  public int getInitiativeBonus()
  {
    return this.getModifier(this.getDexterity());
  }
  public int getPassivPerception()
  {
    return (10 + this.getWisdom());
  }
  public int getActivPerception()
  {
    return (main.Die.rollDie_recursively(20, 1) + this.getModifier(this.getWisdom()));
  }
  protected boolean isProfThere(String inputType)
  {
    boolean output = false;
    for(String proficiency : this.getpClass().getProficiencies())
    {
      if(proficiency.equalsIgnoreCase(inputType))
      {
        output = true;
      }
    }
    return output;
  }
  protected int getProficiencyOrLevel(char fork)
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
  
// ################# COMBAT #################
  public int[] tryHit()
  {
    // Stread D20 roll.
    int[] output = new int[2];
    output[0] = main.Die.rollDie(20, 1);
    output[1] = output[0];
// TODO: redo this Switsch case!!
    switch(this.getpClass().getName())
    {
      case "wizzard":
        output[1] += this.getModifier(this.getIntelegent());
        break;
      case "ranger":
        output[1] += this.getModifier(this.getDexterity());
        break;
      default:
        output[1] += this.getModifier(this.getStrength());
    }
    
    if(this.isProfThere(this.getpWeapon().getWeaponGroup())
    || this.isProfThere(this.getpWeapon().getType()))
    {
    output[1] += this.getProficiencyOrLevel('p');
    }
    return output;
  }
  protected int calcMeleeDamage()
  {
    int dmg = main.Die.rollDie(
                      this.getpWeapon().getDamageDie(),
                      this.getpWeapon().getDieCount()
                    );
    // if weapon is versitile use DexMod
    dmg += this.getModifier(this.getStrength());
    return dmg;
  }
  protected int calcRangeDamage()
  {
    int dmg = main.Die.rollDie(
                      this.getpWeapon().getDamageDie(),
                      this.getpWeapon().getDieCount()
                    );
    dmg += this.getModifier(this.getDexterity());
    return dmg;
  }

  public int doDamage()
  {
    int dmg = 0;
    switch(this.getpWeapon().getCat())
    {
      case "melee":
      dmg = this.calcMeleeDamage();
      break;
      case "range":
      dmg = this.calcRangeDamage();
      break;
    }
    return dmg;
  }
  public String tryToAttack(PlayerCharacter p2, int distance)
  {
    String output = "";
     switch(this.getpWeapon().getCat())
    {
      case "melee":
        if(distance == 0)// or adjacent?
        {
          output += this.doAttack(p2);
        }else{
          output += "Target is too far away. Move closer.";
        }
        break;
      case "range":
        if(distance >= 1)
        {
          if(distance <= this.getpWeapon().getDistance())
          {
            output += this.doAttack(p2);
          }else{
            output += "Target is too far away. Move closer.";
          }
        }else{
          output += "Target is too close. Move away.";
        }
        break;
    }
     return output;
  }
  public String doAttack(PlayerCharacter p2)
  {
    String output = this.getName() + " ";
    int[] cTh = this.tryHit();
    
    if(cTh[0] == 20 || cTh[1] >= p2.getpArmor().getArmorValue())
    {
      int dmg = this.doDamage();
      if(cTh[0] == 20)
      {
        dmg *= 2;
        output += "*";
      }
      p2.setTempHP( p2.getTempHP() - dmg );
      output += "hits " + p2.getName() + " with a " + cTh[1] 
              + " and does " + dmg + " damage."
              + " And has " + p2.getTempHP() + " HP left.";
      if(p2.getTempHP() <= 0){
        output += p2.getName() + " is no more.\n";
      }
    }
    else
    {
      output += "misses with a " + cTh[1] + "\n";
    }
    return output;
  }
  
  public int castSpell(Spell input)
  {
    int output = main.Die.rollDie(
      input.getDamageDie(),
      input.getDieCount()
    );
    return output;
  }
  public String doSpellAttack(PlayerCharacter p2, Spell iSpell)
  {
    String output = this.getName() + " ";
// TODO: redo spell handling
    if(iSpell.getName().equalsIgnoreCase("healingword")){
      int heal = this.castSpell(iSpell);
      output += "healed for " + heal + ". ";
      this.setTempHP( this.getTempHP() + heal );
      if(this.getTempHP() > this.getHealth()){
        this.setTempHP(this.getHealth());
      }
      output += "Health is now back to " + this.getTempHP() + "/" + this.getHealth() +".";
      return output;
    }
    
    int[] cTh = this.tryHit();
    if(cTh[0] == 20 || cTh[1] >= p2.getpArmor().getArmorValue())
    {
      int dmg = this.castSpell(iSpell);
      if(cTh[0] == 20)
      {
        dmg *= 2;
        output += "*";
      }
      p2.setTempHP( p2.getTempHP() - dmg );
      output += "hits " + p2.getName() + " with a " + cTh[1] 
              + " and does " + dmg + " damage."
              + " And has " + p2.getTempHP() + " HP left.";
      if(p2.getTempHP() <= 0){
        output += p2.getName() + " is no more.\n";
      }
    }
    else
    {
      output += "misses with a " + cTh[1] + "\n";
    }
    return output;
  }
  public String tryToSpellAttack(PlayerCharacter p2, int distance, String spellname)
  {
    String output = "";
    Spell tempSpell = this.getpClass().getMyBook().getSpellByName(spellname);
    if(distance <= tempSpell.getSpellRange()){
      output += this.doSpellAttack(p2,tempSpell);
    }else{
      output += "Target is too far away. Move closer.";
    }
    return output;
  }
  
// ################# DEBUG OUTPUT #################
  public void DebugChar()
  {
	String output = "";
	
	output = "Playername: " + this.getName() + "\n"
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
		  + "= = = = = = = = = = = = = =\n"
		  ;
	System.out.println(output);
  }
  public void DebugDMG(int Hit_X_Times)
  {
    String output = "";
    int[] cTh = new int[2];
    int dmg = 0;
    for(int i = 1; i <= Hit_X_Times; i++)
    {
      cTh = this.tryHit();
      output += "Attack " + i + ": " + this.getName() + " ";;
      if(cTh[0] == 20 || cTh[1] >= this.getAC())
      {
        dmg = this.doDamage();
        if(cTh[0] == 20)
        {
          dmg *= 2;
          output += "*";
        }
      output += "hits with a " + cTh[1] 
              + " for " + dmg + " damage.\n"; 
      }
      else
      {
        output += "misses with a " + cTh[1] + "\n";
      }
    }
    System.out.println(output + "= = = = = = = = = = = = = =\n");
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

  public Backpack getBackpack() {
      return backpack;
  }
  public void setBackpack(Backpack backpack) {
      this.backpack = backpack;
  }
}