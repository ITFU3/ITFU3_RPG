/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enum;

/**
 *
 * @author steffen
 */
public enum MonsterType {
    
    NORMAL(""), EVIL("Evil"), OFDOOM("of Doom");
   
      public String value;
      
    private MonsterType(String value) {
        this.value = value;
    }    
}
    

