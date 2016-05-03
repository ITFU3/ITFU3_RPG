/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

    import java.util.Random;

/**
 *
 * @author steffen
 */


public class Base {
    
    public static String randomName(int nameLength) {
        Random r = new Random();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String vocals = "aeiou";
        char[] nameAsCharArray = new char[nameLength];
        for (int i = 0; i<nameAsCharArray.length; i++) {
            char c = ' ';
            if (i % 2 == 1) {
                c = vocals.charAt(r.nextInt(vocals.length()));
            } else {
                c = alphabet.charAt(r.nextInt(alphabet.length()));
            }
            if (i == 0) {
                c = Character.toUpperCase(c);
            } 
            nameAsCharArray[i] = c;
        }
        return String.valueOf(nameAsCharArray);
    }
    
}
