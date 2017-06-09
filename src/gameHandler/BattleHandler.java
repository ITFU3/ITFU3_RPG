package gameHandler;
import character.item.spells.Spell;
import character.MonsterCharacter;
import character.PlayerCharacter;
import java.util.ArrayList;
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
   * @return String - protokoll of what happend
   */
    
    
    
  public static String tryToAttack(PlayerCharacter attacker, PlayerCharacter target)
  {
    int distance = Map.getInstance().getDistance(attacker, target);
    System.out.println("MAP:Distance: " + distance);
    
    int[] a_pos = attacker.getCoordinates();
    System.out.println(a_pos[0] + "|" + a_pos[1]);
    
    int[] t_pos = target.getCoordinates();
    System.out.println(t_pos[0] + "|" + t_pos[1]);
    
    String output = "";
    int aa = attacker.getAllowedAttacks();
    if( aa > 0)
    {
        attacker.setAllowedAttacks(--aa);
        if(distance <= attacker.getpWeapon().getDistance())
        {
          output += attacker.getName() + " ";
          // TODO: the Type of attack
          int[] cTh = tryHit(attacker, false/*useSpell*/);

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
              //reset Marker on Map if I would know the Coords of the one that died.
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
    Game.updateMonsterInfo();
    Game.updateAttackInfo(output);
    
    
    return output;
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
  private static int doDamage( PlayerCharacter attacker )
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
  private static int castSpell(PlayerCharacter attacker, Spell input)
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
  public static String tryToSpellAttack(PlayerCharacter attacker, PlayerCharacter target, int distance, String spellname)
  {
    String output = "";
    Spell iSpell = attacker.getpClass().getMyBook().getSpellByName(spellname);
    if(distance <= iSpell.getSpellRange())
    {
      output += attacker.getName() + " ";
      // TODO: redo spell handling with Healing Spells !!!
      if(iSpell.getSpellEffect().equalsIgnoreCase("heal"))
      {
        int heal = castSpell(attacker, iSpell);
        output += "healed " + target.getName() + " for " + heal + " HP. ";
        target.setTempHP( target.getTempHP() + heal );
        if(target.getTempHP() > target.getHealth()){
          target.setTempHP(target.getHealth());
        }
        output += "Health is now back to " + target.getTempHP() + "/" + target.getHealth() +".";
        return output;
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
		  if(target.getTempHP() <= 0){
			output += target.getName() + " is no more.\n";
		  }
		}
		else
		{
		  output += "misses with a " + cTh[1] + "\n";
		}
	  }
    }else{
      output += "Target is too far away. Move closer.\n";
    }
    Game.getInstance().setAttackInfo(output);
    return output;
  }
}