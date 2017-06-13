/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import Enum.MonsterType;
import character.races.MonsterRace;
    import java.util.Random;

/**
 *
 * @author steffen
 */


public class Helper {
    
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
    
    public static String randomBossName(int nameLength) {
        Random r = new Random();
        String[] bossSuffixes = {
            "des Todes",
            "der Verruchte",
            "der Schlächter",
            "der Böse",
            "die Bestie",
            "von und zu Haudraufbisnurnochmatschedais",
            "der Nee",
            "der Blutige",
            "die Geile",
            "der Hacker",
            "der Spalter",
            "der Vernichter",
            "des Bösen"
        };
        
        String suffix = bossSuffixes[r.nextInt(bossSuffixes.length)];
        String bossName = randomName(nameLength) + " "+  suffix;
       return   bossName;
    }
    
    public static char randomGender() {
         char gender;
        int genderInt = main.Die.rollDie(2, 1);
        return (genderInt == 1)? 'm' : 'w';
      
    }
    
    public static String getNameWithType(String name, MonsterType type) {
       String newName = name;
        if (type == MonsterType.EVIL) {
           newName = type.value + " " + name;     
       } else if (type == MonsterType.OFDOOM) {
           newName = name + " " + MonsterType.OFDOOM.value;       
       } 
        return newName;
    }
   
}
