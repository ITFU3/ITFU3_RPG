package main;
import java.util.Random;

public class Die
{
  public static double rollDie(double nSides, double dieCount)
  {
	int output = 0;
	Random r = new Random();
	for(int i = 1; i <= (int) dieCount; i++)
	{
	  output += r.nextInt((int)nSides);
	  // Weil nextInt(int) von 0 bis nSides-1 geht.
	  output += 1;
	}
	return (double) output;
  }
}
