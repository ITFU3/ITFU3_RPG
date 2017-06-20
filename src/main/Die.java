package main;
import java.util.Random;

/**
 * 
 * @author Matthias Dröge
 */
public class Die
{
  /**
   * The dice roller of this game.
   * 
   * @param nSides The highest number on the die
   * @param dieCount The amount of dice to roll
   * @return The sum of the dice values of all
   */
  public static int rollDie(int nSides, int dieCount)
  {
    int output = 0;
    // to make sure not 0 sides are selected by accident
    if (nSides > 0) {
         Random r = new Random();
    for(int i = 1; i <= dieCount; i++)
    {
      // Weil nextInt(int) von 0 bis nSides-1 geht.
      output += r.nextInt(nSides) + 1;
    }
    }
   
    return output;
  }
  
  /**
   * The dice roller of this game
   * in a recursive method
   * 
   * @param nSides The highest number on the die
   * @param dieCount The amount of dice to roll
   * @return The sum of the dice values of all
   */
  public static int rollDie_recursively(int nSides, int dieCount)
  {
    int output = 0;
    Random r = new Random();
    output += r.nextInt(nSides) + 1;
    dieCount -= 1;
    output += (dieCount > 0) ? rollDie_recursively(nSides, dieCount) : 0;
    return output;
  }
}
