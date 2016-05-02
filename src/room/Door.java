/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package room;

enum DoorType {
    HEAVY,
    LIGHT
}
/**
 *
 * @author steffen
 */
public class Door {
    boolean open = false;
    boolean locked = false;
    DoorType type = DoorType.LIGHT;
}

