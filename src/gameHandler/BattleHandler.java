package gameHandler;
import characters.*;
import room.*;
import spells.*;
import java.util.ArrayList;

/**
 *
 * @author steffen / Matthias Dröge
 */
public class BattleHandler
{
    private ArrayList<PlayerCharacter> players = new ArrayList();
    private ArrayList<Integer> initiativeOrderPlayers = new ArrayList();
    
    private ArrayList<MonsterCharacter> monsters = new ArrayList();
    private ArrayList<Integer> initiativeOrderMonsters = new ArrayList();
        
    private ArrayList<BaseSpace> spaces = new ArrayList();
    
    /**
     * Constructor with Demo Chars and Monsters for testing.
     */
    public BattleHandler()
    {
      MonsterCharacter[] monsterArray = main.Demos.getDemoMonster();
      for (MonsterCharacter monster : monsterArray) {
        this.addMonsterToBattle(monster);
      }
      
      PlayerCharacter[] playerArray = CharacterSelecter.getDemoChars();
      for (PlayerCharacter player : playerArray) {
        this.addPlayerToBattle(player);
      }
      this.sortPlayerByInitiative();
      this.sortMonsterByInitiative();
      this.DebugOutput();
    }
    
    public BattleHandler(ArrayList<PlayerCharacter> players, ArrayList<MonsterCharacter> monsters)
    {
      for(PlayerCharacter player : players){
        this.addPlayerToBattle(player);
      }
      for(MonsterCharacter monster : monsters){
        this.addMonsterToBattle(monster);
      }
      this.sortPlayerByInitiative();
      this.sortMonsterByInitiative();
    }
    
    public BattleHandler(PlayerCharacter player, MonsterCharacter monster)
    {
      this.addPlayerToBattle(player);
      this.addMonsterToBattle(monster);
      // no sorting => only one item per ArrayList
    }
    
    /**
     * Adds a monster to the Combat and Initiative List
     * @param monster - one MonsterCharacter
     */
    public void addMonsterToBattle(MonsterCharacter monster)
    {
      this.getMonsters().add(monster);
      this.getInitiativeOrderMonsters().add(monster.getInitiative());
      // missing a sort by Initiative for the monsters
    }
    
    /**
     * Adds a player to the Combat and Initiative List
     * @param player - one PlayerCharacter
     */
    public void addPlayerToBattle(PlayerCharacter player)
    {
      this.getPlayers().add(player);
      this.getInitiativeOrderPlayers().add(player.getInitiative());
      // missing a sort by Initiative for the players
    }
    
    /**
     * Just a Debug output of the created Chars and Monsters.
     */
    private void DebugOutput()
    {
      for(int i=0; i<this.getMonsters().size(); i++)
      {
        System.out.println("Name: " + this.getMonsters().get(i).getName() 
                          + " Initiative Order: " + this.getInitiativeOrderMonsters().get(i) 
                          + " DexMod: " + this.getMonsters().get(i).getModifier(this.getMonsters().get(i).getDexterity())
                          + " calc.Roll: " + ( this.getInitiativeOrderMonsters().get(i) - this.getMonsters().get(i).getModifier(this.getMonsters().get(i).getDexterity()) )
        );
      }
      System.out.println("");
      
      for(int i=0; i<this.getPlayers().size(); i++)
      {
        System.out.println("Name: " + this.getPlayers().get(i).getName() 
                          + " Initiative Order: " + this.getInitiativeOrderPlayers().get(i) 
                          + " DexMod: " + this.getPlayers().get(i).getModifier(this.getPlayers().get(i).getDexterity())
                          + " calc.Roll: " + ( this.getInitiativeOrderPlayers().get(i) - this.getPlayers().get(i).getModifier(this.getPlayers().get(i).getDexterity()) )
        );
      }
      System.out.println("");
    }
    
// ########################################################    
    
    /**
     * Sorts the PlayerCharacter ArrayList 
     * by the right initiative Order
     */
    public void sortPlayerByInitiative()
    {
      ArrayList<PlayerCharacter> sortedListe = new ArrayList();
      ArrayList<Integer> sortedInit = new ArrayList();

      while(this.players.size()>0)
      {
        int tmpIndex=0;
        int tmpInitiative=0;
        for(int i = 0; i < this.players.size(); i++)
        {
          if(this.initiativeOrderPlayers.get(i) > tmpInitiative)
          {
            tmpInitiative = this.initiativeOrderPlayers.get(i);
            tmpIndex = i;
          }
        }
        sortedListe.add(this.players.get(tmpIndex));
        sortedInit.add(this.initiativeOrderPlayers.get(tmpIndex));
        this.players.remove(tmpIndex);
        this.initiativeOrderPlayers.remove(tmpIndex);
      }
      
      this.setPlayers(sortedListe);
      this.setInitiativeOrderPlayers(sortedInit);
    }
    
    /**
     * Sorts the MonsterCharacter ArrayList 
     * by the right initiative Order
     */
    public void sortMonsterByInitiative()
    {
      ArrayList<MonsterCharacter> sortedListe = new ArrayList();
      ArrayList<Integer> sortedInit = new ArrayList();

      while(this.monsters.size()>0)
      {
        int tmpIndex=0;
        int tmpInitiative=0;
        for(int i = 0; i < this.monsters.size(); i++)
        {
          if(this.initiativeOrderMonsters.get(i) > tmpInitiative)
          {
            tmpInitiative = this.initiativeOrderMonsters.get(i);
            tmpIndex = i;
          }
        }
        sortedListe.add(this.monsters.get(tmpIndex));
        sortedInit.add(this.initiativeOrderMonsters.get(tmpIndex));
        this.monsters.remove(tmpIndex);
        this.initiativeOrderMonsters.remove(tmpIndex);
      }
      
      this.setMonsters(sortedListe);
      this.setInitiativeOrderMonsters(sortedInit);
    }
    
    
  // ################# COMBAT #################
  
  /**
   * The actual Comabt Attack Action:
   * attcker tries to attack the target
   * @param attacker - PlayerCharacter (MonsterCharacters get casted)
   * @param target - PlayerCharacter (MonsterCharacters get casted)
   * @param distance - int - To Target
   * @return String - protokoll of what happend
   */
  public String tryToAttack(PlayerCharacter attacker, PlayerCharacter target, int distance/*, boolean useSpell*/)
  {
    String output = "";
    if(distance <= attacker.getpWeapon().getDistance())
    {
      
      output += attacker.getName() + " ";
      // TODO: the Type of attack
      int[] cTh = this.tryHit(attacker, false/*useSpell*/);

      if(cTh[0] == 20 || cTh[1] >= target.getpArmor().getArmorValue())
      {
        int dmg = this.doDamage(attacker);
        if(cTh[0] == 20)
        {
          dmg *= 2;
          output += "*";
        }
        target.setTempHP( target.getTempHP() - dmg );
        output += "hits " + target.getName() + " with a " + cTh[1] 
                + " and does " + dmg + " damage."
                + " And has " + target.getTempHP() + " HP left.";
        if(target.getTempHP() <= 0){
          output += target.getName() + " is no more.\n";
        }
      }else{
        output += "misses with a " + cTh[1] + "\n";
      }
    }else{
      output += "Target is too far away. Move closer.";
    }
    return output;
  }
  
  /**
   * Calculating the Chance to Hit for the attacker
   * @param attacker - PlayerCharacter
   * @param useSpell - if a spell is used or not
   * @return int[]
   * [0] = actual die roll
   * [1] = cTh with roll and modifier
   */
  public int[] tryHit( PlayerCharacter attacker, boolean useSpell )
  {
    int[] output = new int[2];
    // Stread D20 roll.
    output[0] = main.Die.rollDie(20, 1);
    output[1] = output[0];
// TODO: redo this switch case based on rules!!
    if(useSpell)
    {
      // gets change to ...getpClass().getSpellAttackBonus()
      output[1] += attacker.getModifier(attacker.getIntelegent());
      output[1] += attacker.getProficiencyOrLevel('p');
    }else{
      if(attacker.getpWeapon().getCat().equalsIgnoreCase("range")){
        output[1] += attacker.getModifier(attacker.getDexterity());
      }else{
        output[1] += attacker.getModifier(attacker.getStrength());
      }
      if(attacker.isProfThere(attacker.getpWeapon().getWeaponGroup())
      || attacker.isProfThere(attacker.getpWeapon().getType()))
      {
        output[1] += attacker.getProficiencyOrLevel('p');
      }
    }
    
    return output;
  }
  
  /**
   * Weapon damage calculation
   * @param attacker - PlayerCharacter
   * @return int - the damage value with modifier
   */
  public int doDamage( PlayerCharacter attacker )
  {
    int dmg = main.Die.rollDie( attacker.getpWeapon().getDamageDie(),
                            attacker.getpWeapon().getDieCount()
                          );
    if(attacker.getpWeapon().getCat().equalsIgnoreCase("range"))
    {
      dmg += attacker.getModifier(attacker.getDexterity());
    }else{
      // if weapon is versitile use DexMod
      dmg += attacker.getModifier(attacker.getStrength());
    }
    return dmg;
  }
  
  /**
   * Spell damage calculation
   * @param attacker - PlayerCharacter
   * @param input - Spell - the spell used in the attack
   * @return int - the damage value with modifier
   */
  public int castSpell(PlayerCharacter attacker, Spell input)
  {
    int spellDmg = main.Die.rollDie(
      input.getDamageDie(),
      input.getDieCount()
    );
    spellDmg += attacker.getModifier(attacker.getIntelegent());
    return spellDmg;
  }
  
  /**
   * The actual Comabt Spell Attack Action:
   * attcker tries to attack the target with spell
   * @param attacker - PlayerCharacter
   * @param target - PlayerCharacter
   * @param distance - int
   * @param spellname - String - the name of the spell in use
   * @return String - protokoll of what happend
   */
  public String tryToSpellAttack(PlayerCharacter attacker, PlayerCharacter target, int distance, String spellname)
  {
    String output = "";
    Spell iSpell = attacker.getpClass().getMyBook().getSpellByName(spellname);
    if(distance <= iSpell.getSpellRange())
    {
      output += attacker.getName() + " ";
      // TODO: redo spell handling with Healing Spells !!!
      if(iSpell.getName().equalsIgnoreCase("healingword"))
      {
        int heal = this.castSpell(attacker, iSpell);
        output += "healed " + target.getName() + " for " + heal + " HP. ";
        target.setTempHP( target.getTempHP() + heal );
        if(target.getTempHP() > target.getHealth()){
          target.setTempHP(target.getHealth());
        }
        output += "Health is now back to " + target.getTempHP() + "/" + target.getHealth() +".";
        return output;
      }
      // Damage Spells    
      int[] cTh = this.tryHit(attacker, true);
      if(cTh[0] == 20 || cTh[1] >= target.getpArmor().getArmorValue())
      {
        int dmg = this.castSpell(attacker, iSpell);
        if(cTh[0] == 20)
        {
          dmg *= 2;
          output += "*";
        }
        target.setTempHP( target.getTempHP() - dmg );
        output += "hits " + target.getName() + " with a " + cTh[1] 
                + " and does " + dmg + " damage."
                + " And has " + target.getTempHP() + " HP left.";
        if(target.getTempHP() <= 0){
          output += target.getName() + " is no more.\n";
        }
      }
      else
      {
        output += "misses with a " + cTh[1] + "\n";
      }
    }else{
      output += "Target is too far away. Move closer.";
    }
    return output;
  }

  
  // ################# Getter \ Setter #################
  public ArrayList<PlayerCharacter> getPlayers() {
    return players;
  }
  public void setPlayers(ArrayList<PlayerCharacter> players) {
    this.players = players;
  }
  public ArrayList<Integer> getInitiativeOrderPlayers() {
    return initiativeOrderPlayers;
  }
  public void setInitiativeOrderPlayers(ArrayList<Integer> initiativeOrderPlayers) {
    this.initiativeOrderPlayers = initiativeOrderPlayers;
  }
  public ArrayList<MonsterCharacter> getMonsters() {
    return monsters;
  }
  public void setMonsters(ArrayList<MonsterCharacter> monsters) {
    this.monsters = monsters;
  }
  public ArrayList<Integer> getInitiativeOrderMonsters() {
    return initiativeOrderMonsters;
  }
  public void setInitiativeOrderMonsters(ArrayList<Integer> initiativeOrderMonsters) {
    this.initiativeOrderMonsters = initiativeOrderMonsters;
  }
  public ArrayList<BaseSpace> getSpaces() {
    return spaces;
  }
  public void setSpaces(ArrayList<BaseSpace> spaces) {
    this.spaces = spaces;
  }
}