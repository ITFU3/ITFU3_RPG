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
    private boolean isPlayer_Token;

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
    public boolean isIsPlayer_Token() {
        return isPlayer_Token;
    }
    public void setIsPlayer_Token(boolean isPlayer_Token) {
        this.isPlayer_Token = isPlayer_Token;
    }
    
}
