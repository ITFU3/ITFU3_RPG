/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package room;

/**
 *
 * @author steffen
 */

public class Coordinate {
    int x;
    int y;
    int z;
    int time;
    
    public Coordinate(int x, int y, int z, int time) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.time = time;
    }
    
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
        this.z = 1;
        this.time = 1;
    }
    
    public Coordinate() {
        this.x = 0;
        this.y = 0;
        this.z = 1;
        this.time = 1;
    }
}

