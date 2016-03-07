package main;
import java.util.Random;

public class Die
{
  public static int rollDie(int nSides, int dieCount)
  {
	int output = 0;
	Random r = new Random();
	for(int i = 1; i <= (int) dieCount; i++)
	{
	  // Weil nextInt(int) von 0 bis nSides-1 geht.
	  output += r.nextInt((int)nSides) + 1;
	}
	return (int) output;
  }
  
  public static int rollDie_recursively(int nSides, int dieCount)
  {
	int output = 0;
	Random r = new Random();
	output += r.nextInt((int)nSides) + 1;
	dieCount -= 1;
	output += (dieCount > 0) ? rollDie_recursively(nSides, dieCount) : 0;
	return output;
  }
}
