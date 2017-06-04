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
    private ArrayList<BaseCharacter> pc_npc;
    private ArrayList<Integer> tempMovement;
    private int actionCounter;

    /**
     * Constuctor
     */
    private TurnHandler(){
        this.pc_npc = new ArrayList();
        this.tempMovement = new ArrayList();
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
    public int addCharacter(BaseCharacter c){
        // adding all charater to the turn handler to work with
        this.pc_npc.add(c);
        // adding the initial Movemt to the temp array
        this.tempMovement.add(c.getAllowedMoves());
        
        return (this.pc_npc.size()-1);
    }
    
    
    
    
}
