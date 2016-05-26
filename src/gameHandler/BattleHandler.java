package gameHandler;
import characters.*;
import room.*;
import java.util.ArrayList;

/**
 *
 * @author steffen / Matthias Dröge
 */
public class BattleHandler
{
    ArrayList<PlayerCharacter> players = new ArrayList();
    ArrayList<Integer> initiativeOrderPlayers = new ArrayList();
    
    ArrayList<MonsterCharacter> monsters = new ArrayList();
    ArrayList<Integer> initiativeOrderMonsters = new ArrayList();
    
    ArrayList<BaseSpace> spaces = new ArrayList();
    
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
      
      this.DebugOutput();
    }
    
    /**
     * Adds a monster to the Combat and Initiative List
     * @param monster - one MonsterCharacter
     */
    public void addMonsterToBattle(MonsterCharacter monster)
    {
      this.monsters.add(monster);
      this.initiativeOrderMonsters.add(monster.getInitiative());
      // missing a sort by Initiative for the monsters
    }
    
    /**
     * Adds a player to the Combat and Initiative List
     * @param player - one PlayerCharacter
     */
    public void addPlayerToBattle(PlayerCharacter player)
    {
      this.players.add(player);
      this.initiativeOrderPlayers.add(player.getInitiative());
      // missing a sort by Initiative for the players
    }
    
    /**
     * Just a Debug output of the created Chars and Monsters.
     */
    private void DebugOutput()
    {
      for(int i=0; i<this.monsters.size(); i++)
      {
        System.out.println( "Name: " + this.monsters.get(i).getName() 
                          + " Initiative Order: " + this.initiativeOrderMonsters.get(i) 
                          + " DexMod: " + this.monsters.get(i).getModifier(this.monsters.get(i).getDexterity())
                          + " calc.Roll: " + ( this.initiativeOrderMonsters.get(i) - this.monsters.get(i).getModifier(this.monsters.get(i).getDexterity()) )
        );
      }
      System.out.println("");
      
      for(int i=0; i<this.players.size(); i++)
      {
        System.out.println( "Name: " + this.players.get(i).getName() 
                          + " Initiative Order: " + this.initiativeOrderPlayers.get(i) 
                          + " DexMod: " + this.players.get(i).getModifier(this.players.get(i).getDexterity())
                          + " calc.Roll: " + ( this.initiativeOrderPlayers.get(i) - this.players.get(i).getModifier(this.players.get(i).getDexterity()) )
        );
      }
      System.out.println("");
    }
}
