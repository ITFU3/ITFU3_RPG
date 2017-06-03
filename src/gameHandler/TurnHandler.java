/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameHandler;

/**
 *
 * @author steffen
 */
public class TurnHandler {
    
    private static TurnHandler instance;

    private TurnHandler() {
    }
    
    public static TurnHandler getInstance() {
        if (instance == null) {
            instance = new TurnHandler();
        }
        return instance;
    }
    
    private int actionCounter;
    
    
    
}
