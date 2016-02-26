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
	  // Weil nextInt(int) von 0 bis nSides-1 geht.
	  output += r.nextInt((int)nSides) + 1;
	}
	return (double) output;
  }
  
  public static double rollDie_recursively(double nSides, double dieCount)
  {
	int output = 0;
	Random r = new Random();
	output += r.nextInt((int)nSides) + 1;
	dieCount -= 1.0;
	output += (dieCount > 0) ? rollDie_recursively(nSides, dieCount) : 0.0;
	return output;
  }
}
