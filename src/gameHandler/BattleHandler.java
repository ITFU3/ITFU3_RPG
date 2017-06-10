package gameHandler;
import character.item.spells.Spell;
import character.MonsterCharacter;
import character.PlayerCharacter;
import main.Game;
import main.Map;

/**
 *
 * @author steffen / Matthias Dröge
 */
public class BattleHandler
{
  /**
   * The actual Comabt Attack Action:
   * attcker tries to attack the target
   * @param attacker - PlayerCharacter (MonsterCharacters get casted)
   * @param target - PlayerCharacter (MonsterCharacters get casted)
   */
    
    
    
  public static void tryToAttack(PlayerCharacter attacker, PlayerCharacter target)
  { 
    Game.updateAttackInfo(attacker.getName() + " wants to attack.\n");
    Game.waitFor(1);
    int distance = Map.getInstance().getDistance(attacker, target);
    
    String output = "";
    int aa = attacker.getAllowedAttacks();
      System.err.println("gameHandler.BattleHandler.tryToAttack: ==> Allowed Attacks: "+ attacker.getAllowedAttacks());
    if( aa > 0)
    {
        if(distance <= attacker.getpWeapon().getDistance())
        {
          attacker.setAllowedAttacks(--aa);
          output += attacker.getName() + " ";
          int[] cTh = tryHit(attacker, false);
          if(cTh[0] == 20 || cTh[1] >= target.getpArmor().getArmorValue())
          {
            int dmg = doDamage(attacker);
            if(cTh[0] == 20)
            {
              dmg *= 2;
              output += "*";
            }
            target.setTempHP( target.getTempHP() - dmg );
            output += "hits " + target.getName() + " with a " + cTh[1] 
                    + " and does " + dmg + " damage.\n"
                    + " And has " + target.getTempHP() + " HP left.\n";
            if(target.getTempHP() <= 0){
              output += target.getName() + " is no more.\n";
              int newXP = target.getExperience();
              attacker.addExperience( newXP );
              killStrike(target);
            }
          }else{
            output += "misses with a " + cTh[1] + "\n";
          }
        }else{
          output += "Target is too far away. Move closer.\n";
        }
    }else{
        output += "No Attacks left to do.\n";
    }
    System.err.println("gameHandler.BattleHandler.tryToAttack\n===>\n" + output + "\n<===");
    Game.addToAttackInfoString(output, true);
    Game.updateMonsterInfo();
    Game.updateGUI();
  }
  
  private static void killStrike(PlayerCharacter target){
    int monsterIndex = Game.getMonsters().indexOf(
        (MonsterCharacter)target
    );
    int[] monsterCoords = target.getCoordinates();
    Map.getInstance().resetMarkerOnMap(
        monsterCoords[0],
        monsterCoords[1]
    );
    Game.getMonsters().remove(
        monsterIndex
    );
  }
  
  /**
   * Calculating the Chance to Hit for the attacker
   * @param attacker - PlayerCharacter
   * @param useSpell - if a spell is used or not
   * @return int[]
   * [0] = actual die roll
   * [1] = cTh with roll and modifier
   */
  private static int[] tryHit( PlayerCharacter attacker, boolean useSpell )
  {
    int[] output = new int[2];
    // Stread D20 roll.
    output[0] = main.Die.rollDie(20, 1);
    output[1] = output[0];
    
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
  private static int doDamage( PlayerCharacter attacker ){
    int dmg = main.Die.rollDie(
        attacker.getpWeapon().getDamageDie(),
        attacker.getpWeapon().getDieCount()
    );
    if(attacker.getpWeapon().getCat().equalsIgnoreCase("range")){
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
  private static int castSpell(PlayerCharacter attacker, Spell input){
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
   * @param spellname - String - the name of the spell in use
   */
  public static void tryToSpellAttack(
    PlayerCharacter attacker,
    PlayerCharacter target,
    String spellname
  ){
        Game.updateAttackInfo(attacker.getName() + " wants to cast a spell.\n");
        Game.waitFor(1);
        int distance = Map.getInstance().getDistance(attacker, target);

        String output = "";
        int aa = attacker.getAllowedAttacks();
        if( aa > 0)
        {
            Spell iSpell = attacker.getpClass().getMyBook().getSpellByName(spellname);
            if(distance <= iSpell.getSpellRange())
            {
                attacker.setAllowedAttacks(--aa);
                output += attacker.getName() + " ";
            // TODO: redo spell handling with Healing Spells !!!
                if(iSpell.getSpellEffect().equalsIgnoreCase("heal"))
                {
                    int heal = castSpell(attacker, iSpell);
                    output += "healed " + target.getName() + " for " + heal + " HP. ";
                    target.setTempHP( target.getTempHP() + heal );
                    if(target.getTempHP() > target.getHealth())
                    {
                        target.setTempHP(target.getHealth());
                    }
                    output += "Health is now back to " + target.getTempHP() + "/" + target.getHealth() +".";
                }
                else if(iSpell.getSpellEffect().equalsIgnoreCase("damage"))
                {
                    // Damage Spells    
                    int[] cTh = tryHit(attacker, true);
                    if(cTh[0] == 20 || cTh[1] >= target.getpArmor().getArmorValue())
                    {
                        int dmg = castSpell(attacker, iSpell);
                        if(cTh[0] == 20)
                        {
                            dmg *= 2;
                            output += "*";
                        }
                        target.setTempHP( target.getTempHP() - dmg );
                        output += "hits " + target.getName() + " with a " + cTh[1] 
                            + " and does " + dmg + " damage.\n"
                            + " " + target.getName() + " has " + target.getTempHP() + " HP left.\n";
                        if(target.getTempHP() <= 0)
                        {
                            output += target.getName() + " is no more.\n";
                            int newXP = target.getExperience();
                            System.err.println("XP droped: " + newXP);
                            attacker.addExperience( newXP );
                            System.err.println("Player xp: " + attacker.getExperience());
                            System.err.println("Player lvl: " + attacker.getProficiencyOrLevel('l'));
                            killStrike(target);
                        }
                    }else{ output += "misses with a " + cTh[1] + "\n"; }
                }
            }else{ output += "Target is too far away. Move closer.\n"; }
            Game.updateAttackInfo(output,true);
        }else{ output += "No Attacks left to do.\n"; }
        System.out.println("gameHandler.BattleHandler.tryToSpellAttack ===> \n" + output + "<===");
        Game.addToAttackInfoString(output, true);
        Game.updateMonsterInfo();
        Game.updateGUI();
    }
}