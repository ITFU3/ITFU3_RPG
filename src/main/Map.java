package main;
public class Map
{
  private final String map;		  // String of the original Map
  private final int width;		  // right and left
  private final int height;		  // up and down
    
  private char[][] labyrinthMap;  // the map as CharArray with [Y][X]
  private int sX;				  // the X of starting point
  private int sY;				  // the Y of starting point
  
  private int LastX;			  // the X Position I came from
  private int LastY;			  // the Y Position I came from
  private int newX;				  // the X to go to
  private int newY;				  // the Y to go to
  
  private boolean debuging;		  // to show the debuging system.out
  
  public Map(String map, int width, int height)
  {
    this.map = map;
    this.width = width;
    this.height = height;
    this.sX = 0;
    this.sY = 0;
    this.buildLabyrinth();

    this.LastY = this.sY;
    this.LastX = this.sX;

    // config setings default
    this.debuging = false;
  }
  
  private void buildLabyrinth()
  {
    this.labyrinthMap = new char[this.height][this.width];
    for(int y=0; y < this.height; y++)
    {
      for(int x=0; x < this.width; x++)
      {
        char field = map.charAt((y * this.width) + x);
        this.labyrinthMap[y][x] = field;
        if(field == 'S')
        {
          this.sX = x;
          this.sY = y;
        }
      }
    }
    this.showLabyrinth();
  }
  
  public void showLabyrinth()
  {
    for(int y=0; y < this.height; y++)
    {
      for(int x=0; x < this.width; x++)
      {
        char field = this.labyrinthMap[y][x];
        if(field == 'S')
        {
          this.sX = x;
          this.sY = y;
        }
        System.out.print(field);
      }
      System.out.print("\n");
    }
  }
  
  public void walkOnMap(String input)
  {
	
	switch(input)
	{
	  case "walk left":
		this.moveLeft(this.LastY, this.LastX);
		break;
	  case "walk right":
		this.moveRight(this.LastY, this.LastX);
		break;
	  case "walk down":
		this.moveDown(this.LastY, this.LastX);
		break;
	  case "walk up":
		this.moveUp(this.LastY, this.LastX);
		break;
	}
	
	switch(this.labyrinthMap[this.newY][this.newX])	  // the field I'm in right now!
	{
    case 'M':
      System.out.println("\nYou are confronted with a monster.\n");
	  case ' ':
      this.resetPlayerOnMap(this.LastY, this.LastX);
      this.setPlayerOnMap(this.newY, this.newX);
      this.setLastPos(this.newY, this.newX); // set Last GOOD pos !!!
      break;
	  case '#':
      break;
	  default:
	}
	showLabyrinth();
  }
   
  //##### MOVEMENT #####
  private void moveUp(int y, int x)		// D: 0
  {
	//UP == Y--
    this.newY = y-1;
    this.newX = x;
  }
  private void moveRight(int y, int x)	// D: 1
  {
	//Right == x++
    this.newY = y;
    this.newX = x+1;
  }
  private void moveDown(int y, int x)	// D: 2
  {
	// DOWN == Y++
	this.newY = y+1;
	this.newX = x;
  }
  private void moveLeft(int y, int x)	// D: 3
  {
	// LEFT == x--
    this.newY = y;
    this.newX = x-1;
  }

  private void setLastPos(int y, int x)
  {
    this.LastY = y;
    this.LastX = x;
  }

  private void setPlayerOnMap(int y, int x)
  {
    this.labyrinthMap[y][x] = 'P';
  }
  private void resetPlayerOnMap(int y, int x)
  {
    this.labyrinthMap[y][x] = ' ';
  }
  
  //##### START POSITION #####
  public int getSX(){
    return this.sX;
  }
  public int getSY(){
    return this.sY;
  }
    
//##### DEBUGING #####
  public void setDebuging(boolean input)
  {
    this.debuging = input;
  }
  public boolean isDebuging()
  {
    return this.debuging;
  }
}