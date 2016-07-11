/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package room;
import java.util.ArrayList;

/**
 *
 * @author steffen
 */
public class Room extends BaseSpace {
    private ArrayList<Door> doors;
       
    public Room() {
        super();
        Door door = new Door();
        doors = new ArrayList();
        doors.add(door);
    }
    
    public void addDoorsToRoomString() {
        int numberOfDoors = getDoors().size();
        char door = 'D';
        for (int i = 0; i< numberOfDoors; i++) {
            int doorsXPosition = getDoors().get(i).coordinate.x;
            int doorsYPosition = getDoors().get(i).coordinate.y;
            ArrayList<String> room = getRoomStrings();
            char[] horizontalCharArray = room.get(doorsXPosition).toCharArray();
            horizontalCharArray[doorsYPosition] = door;
            room.remove(doorsXPosition);
            room.add(doorsXPosition, String.valueOf(horizontalCharArray));
        }
    }

    /**
     * @return the doors
     */
    public ArrayList<Door> getDoors() {
        return doors;
    }

    /**
     * @param doors the doors to set
     */
    public void setDoors(ArrayList<Door> doors) {
        this.doors = doors;
    }
}
