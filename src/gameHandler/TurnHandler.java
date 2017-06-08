package gameHandler;

import character.*;
import java.util.ArrayList;

/**
 *
 * @author Steffen Haas
 * @author Matthias Dröge
 */
public class TurnHandler{
    private static TurnHandler instance;
    private ArrayList<PlayerCharacter> pc_npc;
    private int actionCounter;

    /**
     * Constuctor
     */
    private TurnHandler(){
        this.pc_npc = new ArrayList();
    }
    
    /**
     * Singelton inplementation
     * @return TurnHandler Instance
     */
    public static TurnHandler getInstance() {
        if (instance == null){
            instance = new TurnHandler();
        }
        return instance;
    }
    
    /**
     * Adding Characters ...
     * @param c - BaseCharacter to add
     * @return int - Index of the added
     */
    public int addCharacter(PlayerCharacter c){
        // adding all charater to the turn handler to work with
        this.pc_npc.add(c);
        return (this.pc_npc.size()-1);
    }
    
    /**
     * Reading from the pc_npc ArrayList to get Player index
     * @return int Index
     */
    public int getPlayerIndex(){
        for(int i = 0; i < this.pc_npc.size(); i++) {
           if("PlayerCharacter".equals(this.pc_npc.get(i).getClass().getSimpleName())){
               return i;
           } 
        }
        return -1;
    }
    
    
}
