/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sven-oliverpatzel
 */
public class InputHandler {

    private static BufferedReader br;

    /**
     * Creates new InputStream (only invoke once)
     */
    public static void openInputReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    
    /**
     * Returns a primitve Integer value for later use
     * @return primitve int value
     */
    public static int readIntegerValue(){
        int toReturn = 0;
        try {
            toReturn = Integer.parseInt(br.readLine());
        } catch (IOException ex) {
            Logger.getLogger(InputHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return toReturn;
    }
    /**
     * Returns a primitive 
     * @return 
     */
    public static double readDoubleValue(){
        double toReturn = 0.0;
        try {
            toReturn = Double.parseDouble(br.readLine());
        } catch (Exception e) {
        }
        return toReturn;
    }
    
     public static String readStringValue(){
         String toReturn = "";
         try {
             toReturn = br.readLine();
         } catch (Exception e) {
             // TODO remove later
             e.printStackTrace();
         }
        return toReturn;
    }
    /**
    * Closes static opened InputStream 
    */
    public static void closeInputReader() {
        try {
            br.close();
        } catch (IOException e) {
            System.err.println("Reader couldn't be closed.");
            // TODO remove later
            e.printStackTrace();
        }
    }

}
