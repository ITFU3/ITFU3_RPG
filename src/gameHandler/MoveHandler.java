/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameHandler;

import main.Map;

/**
 *
 * @author Sven-Oliver Pätzel
 */
public class MoveHandler {    
    /**
     * Holds the directions
     */
    public enum Direction {
        NORTH, SOUTH, WEST, EAST, NORTHWEST, NORTHEAST, SOUTHWEST, SOUTHEAST
    }
    
    
    // Current Map
    private Map map;
    private char[][] labyrinthMap;  // the map as CharArray with [Y][X]
    
        // TODO: arrange for Array...
    private int sX; // the X of starting point
    private int sY; // the Y of starting point

    // TODO: arrange for Array...
    private int mX; // till I get more monster
    private int mY; // till I get more monster

    // TODO: arrange for Array...
    private int LastX;  // the X Position I came from
    private int LastY;  // the Y Position I came from
    private int newX; // the X to go to
    private int newY; // the Y to go to

    // TODO: arrange for Array...
    private int mLastX; // for monster movment
    private int mLastY;
    private int mNewX;
    private int mNewY;
    
//<editor-fold defaultstate="collapsed" desc="not yet uses code">
    /**
     * This methodes
     *
     * @param direction
     * 
     * public void goDirection(MovementHandler.Direction direction, int steps) {
     * switch (direction) {
     * case NORTH:
     * System.out.println("Head North by " + steps);
     * //TODO create
     * break;
     * case NORTHWEST:
     * System.out.println("Head North by " + steps);
     * //TODO create
     * break;
     * case NORTHEAST:
     * System.out.println("Head North by " + steps);
     * //TODO create
     * break;
     * case SOUTH:
     * System.out.println("Head South by " + steps);
     * break;
     * case SOUTHWEST:
     * System.out.println("Head South by " + steps);
     * break;
     * case SOUTHEAST:
     * System.out.println("Head South by " + steps);
     * break;
     * case WEST:
     * System.out.println("Head West by " + steps);
     * break;
     * case EAST:
     * System.out.println("Head East by " + steps);
     * break;
     * }
     * }
     * 
     * private void moveNorth() {
     * }
     * 
     * private void moveEast() {
     * }
     * 
     * private void moveNorthWest() {
     * }
     * 
     * private void moveSouthEast() {
     * }
     * 
     * private void moveSouthWest() {
     * }
     * 
     * private void moveSouth() {
     * }
     * 
     * private void moveWest() {
     * }
     * 
     * private void moveNorthEast() {
     * }
     */
//</editor-fold>
    
    /**
     *
     *
     * @param input Command word for direction
     * @param tempMovement The max movement to walk
     * @param steps Amount of steps to walk
     * @param playerSwitch The condition for player or monster
     * @return The movement left to walk
     */
    public int walkOnMap(String input, int tempMovement, int steps, boolean playerSwitch) {
        int l_X;
        int l_Y;
        int n_x;
        int n_y;

        if (steps <= tempMovement) {
            for (int i = 0; i < steps; i++) {
// not nice needs a redo
                if (playerSwitch) {
                    l_X = this.getLastX();
                    l_Y = this.getLastY();
                    n_x = this.getNewX();
                    n_y = this.getNewY();
                } else {
                    l_X = this.getmLastX();
                    l_Y = this.getmLastY();
                    n_x = this.getmNewX();
                    n_y = this.getmNewY();
                }
                System.out.println("steps: " + steps
                        + " | tempMovement: " + tempMovement
                        + " | x: " + n_x + " | y:" + n_y + " | l_X: " + l_X
                        + " | l_Y: " + l_Y
                );
                switch (input) {
                    case "left":
                        this.moveLeft(l_Y, l_X, playerSwitch);
                        break;
                    case "right":
                        this.moveRight(l_Y, l_X, playerSwitch);
                        break;
                    case "down":
                        this.moveDown(l_Y, l_X, playerSwitch);
                        break;
                    case "up":
                        this.moveUp(l_Y, l_X, playerSwitch);
                        break;
                }

// not nice needs a redo
                if (playerSwitch) {
                    l_X = this.getLastX();
                    l_Y = this.getLastY();
                    n_x = this.getNewX();
                    n_y = this.getNewY();
                } else {
                    l_X = this.getmLastX();
                    l_Y = this.getmLastY();
                    n_x = this.getmNewX();
                    n_y = this.getmNewY();
                }

                char mapIndicator = labyrinthMap[l_Y][l_X];
                System.out.println("Indicator: " + mapIndicator);
                switch (this.labyrinthMap[n_y][n_x]) // the field I'm in right now!
                {
                    case 'M':
                        if (playerSwitch) {
                            System.out.println("\nYou cannot fill the same space.\n");
                            this.resetNewPos(l_Y, l_X, playerSwitch);
                        } else {
                            this.resetMarkerOnMap(l_Y, l_X);
                            this.setMarkerOnMap(n_y, n_x, mapIndicator);
                            this.setLastPos(n_y, n_x, playerSwitch);
                        }
                        break;

                    case 'P':
                        if (!playerSwitch) {
                            System.out.println("\nYou cannot fill the same space.\n");
                            this.resetNewPos(l_Y, l_X, playerSwitch);
                        } else {
                            this.resetMarkerOnMap(l_Y, l_X);
                            this.setMarkerOnMap(n_y, n_x, mapIndicator);
                            this.setLastPos(n_y, n_x, playerSwitch);
                        }
                        break;

                    case ' ':
                        this.resetMarkerOnMap(l_Y, l_X);
                        this.setMarkerOnMap(n_y, n_x, mapIndicator);
                        this.setLastPos(n_y, n_x, playerSwitch);
                        break;

                    case '#':
                        if (!playerSwitch) {
                            // AI behavior
                        }
                        break;
                    default:
                }
                map.showLabyrinth();
                tempMovement--;
            }
        } else {
            System.out.println("That is " + (steps - tempMovement) + " too far.");
        }
        return tempMovement;
    }

    /**
     * Calculate the pythagorean distance between player and monster
     *
     * @return the euclidean distance
     */
    public int getDistance() {
        int x = Math.abs(this.getLastX() - this.getmX());
        int y = Math.abs(this.getLastY() - this.getmY());
        return Math.round((float) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
    }

    //##### MOVEMENT #####
    /**
     * move up
     *
     * @param y
     * @param x
     * @param playerSwitch
     */
    private void moveUp(int y, int x, boolean playerSwitch) {
        //UP == Y--
        if (playerSwitch) {
            this.setNewY(y - 1);
            this.setNewX(x);
        } else {
            this.setmNewY(y - 1);
            this.setmNewX(x);
        }
    }

    /**
     * move right
     *
     * @param y
     * @param x
     * @param playerSwitch
     */
    private void moveRight(int y, int x, boolean playerSwitch) {
        //Right == x++
        if (playerSwitch) {
            this.setNewY(y);
            this.setNewX(x + 1);
        } else {
            this.setmNewY(y);
            this.setmNewX(x + 1);
        }
    }

    /**
     * move down
     *
     * @param y
     * @param x
     * @param playerSwitch
     */
    private void moveDown(int y, int x, boolean playerSwitch) {
        // DOWN == Y++
        if (playerSwitch) {
            this.setNewY(y + 1);
            this.setNewX(x);
        } else {
            this.setmNewY(y + 1);
            this.setmNewX(x);
        }
    }

    /**
     * move left
     *
     * @param y
     * @param x
     * @param playerSwitch
     */
    private void moveLeft(int y, int x, boolean playerSwitch) {
        // LEFT == x--
        if (playerSwitch) {
            this.setNewY(y);
            this.setNewX(x - 1);
        } else {
            this.setmNewY(y);
            this.setmNewX(x - 1);
        }
    }

    /**
     * set last position
     *
     * @param y
     * @param x
     * @param playerSwitch
     */
    private void setLastPos(int y, int x, boolean playerSwitch) {
        if (playerSwitch) {
            this.setLastY(y);
            this.setLastX(x);
        } else {
            this.setmLastY(y);
            this.setmLastX(x);
        }
    }

    /**
     * reset new position
     *
     * @param y
     * @param x
     * @param playerSwitch
     */
    private void resetNewPos(int y, int x, boolean playerSwitch) {
        if (playerSwitch) {
            this.setNewY(y);
            this.setNewX(x);
        } else {
            this.setmNewY(y);
            this.setmNewX(x);
        }
    }

    // ##### MARKERS ON THE MAP #####
    /**
     * set a marker on the map
     *
     * @param y
     * @param x
     * @param mark
     */
    public void setMarkerOnMap(int y, int x, char mark) {
        this.labyrinthMap[y][x] = mark;
    }

    /**
     * reset a marker on the map to blank space
     *
     * @param y
     * @param x
     */
    private void resetMarkerOnMap(int y, int x) {
        this.labyrinthMap[y][x] = ' ';
    }

    //##### POSITION PLAYER #####
    public int getSX() {
        return this.sX;
    }

    public int getSY() {
        return this.sY;
    }

    public int getLastX() {
        return this.LastX;
    }

    public int getLastY() {
        return this.LastY;
    }

    public void setLastX(int LastX) {
        this.LastX = LastX;
    }

    public void setLastY(int LastY) {
        this.LastY = LastY;
    }

    public int getNewX() {
        return newX;
    }

    public void setNewX(int newX) {
        this.newX = newX;
    }

    public int getNewY() {
        return newY;
    }

    public void setNewY(int newY) {
        this.newY = newY;
    }

    //##### POSITION MONSTER #####
    public int getmX() {
        return mX;
    }

    public int getmY() {
        return mY;
    }

    public int getmLastX() {
        return mLastX;
    }

    public void setmLastX(int mLastX) {
        this.mLastX = mLastX;
    }

    public int getmLastY() {
        return mLastY;
    }

    public void setmLastY(int mLastY) {
        this.mLastY = mLastY;
    }

    public int getmNewX() {
        return mNewX;
    }

    public void setmNewX(int mNewX) {
        this.mNewX = mNewX;
    }

    public int getmNewY() {
        return mNewY;
    }

    public void setmNewY(int mNewY) {
        this.mNewY = mNewY;
    }
    
}
