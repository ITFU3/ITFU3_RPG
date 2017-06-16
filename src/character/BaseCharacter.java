package character;

/**
 *
 * @author Steffen Haas
 */
public abstract class BaseCharacter {
    
    private int id;
    private int allowedAttacks;
    private int allowedMoves;
    private int hp;
    private int dmg;
    int[] coordinates_now;
    int[] coordinates_past;
    int[] coordinates_future;
    char mapToken;
    

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getAllowedAttacks() {
        return allowedAttacks;
    }
    public void setAllowedAttacks(int allowedAttacks) {
        this.allowedAttacks = allowedAttacks;
    }
    public int getAllowedMoves() {
        return allowedMoves;
    }
    public void setAllowedMoves(int allowedMoves) {
        this.allowedMoves = allowedMoves;
    }
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getDmg() {
        return dmg;
    }
    public void setDmg(int dmg) {
        this.dmg = dmg;
    }
    public void setAllCoordinates( int y, int x ){
        this.setCoordinates(y, x);
        this.setCoordinates_future(y, x);
        this.setCoordinates_past(y, x);
    }
    public int[] getCoordinates() {
        return coordinates_now;
    }
    public void setCoordinates(int[] coordinates) {
        this.coordinates_now = coordinates;
    }
    public void setCoordinates(int y, int x){
        int[] input = {y,x};
        this.setCoordinates(input);
    }
    public int[] getCoordinates_past() {
        return coordinates_past;
    }
    public void setCoordinates_past(int[] coordinates) {
        this.coordinates_past = coordinates;
    }
    public void setCoordinates_past(int y, int x){
        int[] input = {y,x};
        this.setCoordinates_past(input);
    }
    public int[] getCoordinates_future() {
        return coordinates_future;
    }
    public void setCoordinates_future(int[] coordinates_future) {
        this.coordinates_future = coordinates_future;
    }
    public void setCoordinates_future(int y, int x){
        int[] input = {y,x};
        this.setCoordinates_future(input);
    }
    public char getMapToken() {
        return mapToken;
    }
    public void setMapToken(char mapToken) {
        this.mapToken = mapToken;
    }
}
