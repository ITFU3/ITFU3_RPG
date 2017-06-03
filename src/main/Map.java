package main;

import java.util.ArrayList;

/**
 * 
 * @author Matthias Dröge
 */
public class Map
{
  private String map; // String of the original Map
  private final int width;  // right and left
  private final int height; // up and down
    
  private char[][] labyrinthMap;  // the map as CharArray with [Y][X]
  
    // TODO: arrange for Array...
  private int playerX; // the X of starting point
  private int playerY; // the Y of starting point
    // TODO: arrange for Array...
  private int playerLastX;  // the X Position I came from
  private int playerLastY;  // the Y Position I came from
    // TODO: arrange for Array...
  private int playerNewX; // the X to go to
  private int playerNewY; // the Y to go to
  
    // TODO: arrange for Array...
  private ArrayList<int[]> monsterCoordinates;
  private int monsterX; // till I get more monster
  private int monsterY; // till I get more monster
    // TODO: arrange for Array...
  private ArrayList<int[]> monsterLastCoordinates;
  private int monsterLastX; // for monster movment
  private int monsterLastY;
    // TODO: arrange for Array...
  private ArrayList<int[]> monsterNewCoordinates;
  private int monsterNewX;
  private int monsterNewY;
  
  private static Map instance;

/**
 * Instance of the Singelton Map
 * 
 * @return Map Class
 */  
  public static Map getInstance() {
      if (instance == null) {
          Map.instance = new Map();
      }
      return instance;
  }
  
  /**
   * The Constructor
   * 
   * @param map A String with the "map"
   * @param width The width of the "map"
   * @param height The height of the "map"
   */
  public Map(String map, int width, int height)
  {
    this.map = map;
    this.width = width;
    this.height = height;
    this.playerX = 0;
    this.playerY = 0;
    
    this.monsterCoordinates = new ArrayList();
    this.monsterCoordinates.add(new int[]{0, 0} );
//    this.mX = 0;
//    this.mY = 0;
    
    this.buildLabyrinth();

    this.playerLastX = this.playerX;
    this.playerLastY = this.playerY;
    
    this.monsterLastCoordinates = this.monsterCoordinates;
//    this.monsterLastY = this.monsterY;
//    this.monsterLastX = this.monsterX;
  }

  /**
   * The default Constructor
   */
    public Map() {
        // without \n !!!
        String init_map =  
                "#########P#############################"+
                "#                                     #"+
                "#                                     #"+
                "#                                     #"+
                "#        M                            #"+
                "#                                     #"+
                "#                                     #"+
                "#                                     #"+
                "#                                     #"+
                "#                                     #"+
                "#                                     #"+
                "#######################################";
    this.map = init_map;
    this.width = 39;
    this.height = 12;
    
    this.monsterCoordinates = new ArrayList();
    this.buildLabyrinth();
    
    this.playerLastY = this.playerY;
    this.playerLastX = this.playerX;
    
    this.monsterLastCoordinates = this.monsterCoordinates;
    this.monsterLastY = this.monsterY;
    this.monsterLastX = this.monsterX;
    }

    /**
     * Getter for prepared map-String
     * 
     * @return String
     */
    public String getMap() {
        return map;
    }
  
  /**
   * Parsing the map string into char array
   * To get the Coordinates of player and monster
   */
  private void buildLabyrinth()
  {
    this.labyrinthMap = new char[this.height][this.width];
    for(int y=0; y < this.height; y++)
    {
      for(int x=0; x < this.width; x++)
      {
        char field = map.charAt((y * this.width) + x);
        this.labyrinthMap[y][x] = field;
        if(field == 'P')
        {
          this.playerX = x;
          this.playerY = y;
        }
        if(field == 'M')
        {
          this.monsterCoordinates.add( new int[]{y,x} );
          this.monsterX = x;
          this.monsterY = y;
        }
      }
    }
    this.showLabyrinth();
  }
  
  /**
   * Printout of the map to console
   */
  public void showLabyrinth()
  {
    this.map = "";
    for(int y=0; y < this.height; y++)
    {
      for(int x=0; x < this.width; x++)
      {
        char field = this.labyrinthMap[y][x];
        this.map += field;
        System.out.print(field);
      }
      this.map += "\n";
      System.out.print("\n");
    }
//    gui.GameFrame.updateGUI( this.getMap() );
  }
  
  /**
   * @param input Command word for direction
   * @param tempMovement The max movement to walk
   * @param steps Amount of steps to walk
   * @param playerSwitch The condition for player or monster
   * @return The movement left to walk
   */
  public int walkOnMap(String input, int tempMovement, int steps, boolean playerSwitch)
  {
    int l_X;
    int l_Y;
    int n_x;
    int n_y;
    
    if(steps <= tempMovement)
    {
      for(int i=0; i<steps; i++)
      {
// not nice needs a redo
        if(playerSwitch){
          l_X = this.getPlayerLastX();
          l_Y = this.getPlayerLastY();
          n_x = this.getPlayerNewX();
          n_y = this.getPlayerNewY();
        }else{
          l_X = this.getMonsterLastX();
          l_Y = this.getMonsterLastY();
          n_x = this.getMonsterNewX();
          n_y = this.getMonsterNewY();
        }
        System.out.println("steps: " + steps + 
            " | tempMovement: " + tempMovement +
            " | x: " + n_x + " | y:" + n_y + " | l_X: " + l_X +
            " | l_Y: " + l_Y
        );
        switch(input)
        {
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
        if(playerSwitch){
          l_X = this.getPlayerLastX();
          l_Y = this.getPlayerLastY();
          n_x = this.getPlayerNewX();
          n_y = this.getPlayerNewY();
        }else{
          l_X = this.getMonsterLastX();
          l_Y = this.getMonsterLastY();
          n_x = this.getMonsterNewX();
          n_y = this.getMonsterNewY();
        }
        
        char mapIndicator = this.labyrinthMap[l_Y][l_X];
        System.out.println("Indicator: " + mapIndicator);
        switch(this.labyrinthMap[n_y][n_x])	  // the field I'm in right now!
        {
          case 'M':
            if( playerSwitch )
            {
              System.out.println("\nYou cannot fill the same space.\n");
              this.resetNewPos(l_Y, l_X, playerSwitch);
            }else{
              this.resetMarkerOnMap(l_Y, l_X);
              this.setMarkerOnMap(n_y, n_x, mapIndicator);
              this.setLastPos(n_y, n_x, playerSwitch);
            }
            break;
          case 'P':
            if( !playerSwitch )
            {
              System.out.println("\nYou cannot fill the same space.\n");
              this.resetNewPos(l_Y, l_X, playerSwitch);
            }else{
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
             if( !playerSwitch )
             {
               // AI behavior
             }
            break;
          default:
              //...
        }
        this.showLabyrinth();
        tempMovement--;
      }
    }
    else
    {
      System.out.println("That is " + (steps-tempMovement) + " too far.");
    }
    return tempMovement;
  }
  
  /**
   * Calculate the pythagorean distance 
   * between player and monster
   * 
   * @return the euclidean distance
   */
  public int getDistance()
  {
    int x = Math.abs(this.getPlayerLastX() - this.getMonsterX());
    int y = Math.abs(this.getPlayerLastY() - this.getMonsterY());
    return Math.round( (float) Math.sqrt( Math.pow(x, 2) + Math.pow(y, 2) ) );
  }
  
  //##### MOVEMENT #####
  /**
   * move up
   * 
   * @param y
   * @param x
   * @param playerSwitch 
   */
  private void moveUp(int y, int x, boolean playerSwitch)
  {
	//UP == Y--
    if(playerSwitch)
    {
      this.setPlayerNewY(y-1);
      this.setPlayerNewX(x);
    }else{
      this.setMonsterNewY(y-1);
      this.setMonsterNewX(x);
    }
  }
  
  /**
   * move right
   * 
   * @param y
   * @param x
   * @param playerSwitch 
   */
  private void moveRight(int y, int x, boolean playerSwitch)
  {
	//Right == x++
    if(playerSwitch)
    {
      this.setPlayerNewY(y);
      this.setPlayerNewX(x+1);
    }else{
      this.setMonsterNewY(y);
      this.setMonsterNewX(x+1);
    }
  }
  
  /**
   * move down
   * 
   * @param y
   * @param x
   * @param playerSwitch 
   */
  private void moveDown(int y, int x, boolean playerSwitch)
  {
	// DOWN == Y++
    if(playerSwitch)
    {
      this.setPlayerNewY(y+1);
      this.setPlayerNewX(x);
    }else{
      this.setMonsterNewY(y+1);
      this.setMonsterNewX(x);
    }
  }
  
  /**
   * move left
   * 
   * @param y
   * @param x
   * @param playerSwitch 
   */
  private void moveLeft(int y, int x, boolean playerSwitch)
  {
	// LEFT == x--
    if(playerSwitch)
    {
      this.setPlayerNewY(y);
      this.setPlayerNewX(x-1);
    }else{
      this.setMonsterNewY(y);
      this.setMonsterNewX(x-1);
    }
  }
  
  /**
   * set last position
   * 
   * @param y
   * @param x
   * @param playerSwitch 
   */
  private void setLastPos(int y, int x, boolean playerSwitch)
  {
    if(playerSwitch)
    {
      this.setPlayerLastY(y);
      this.setPlayerLastX(x);
    }else{
      this.setMonsterLastY(y);
      this.setMonsterLastX(x);
    }
  }
  
  /**
   * reset new position
   * 
   * @param y
   * @param x
   * @param playerSwitch 
   */
  private void resetNewPos(int y, int x, boolean playerSwitch)
  {
    if(playerSwitch)
    {
      this.setPlayerNewY(y);
      this.setPlayerNewX(x);
    }else{
      this.setMonsterNewY(y);
      this.setMonsterNewX(x);
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
  public void setMarkerOnMap(int y, int x, char mark)
  {
    this.labyrinthMap[y][x] = mark;
  }
  
  /**
   * reset a marker on the map to blank space
   * 
   * @param y
   * @param x 
   */
  private void resetMarkerOnMap(int y, int x)
  {
    this.labyrinthMap[y][x] = ' ';
  }
    
  //##### POSITION PLAYER #####
  public int getSX(){
    return this.playerX;
  }
  public int getSY(){
    return this.playerY;
  }
  public int getPlayerLastX(){
    return this.playerLastX;
  }
  public int getPlayerLastY(){
    return this.playerLastY;
  }
  public void setPlayerLastX(int playerLastX) {
    this.playerLastX = playerLastX;
  }
  public void setPlayerLastY(int playerLastY) {
    this.playerLastY = playerLastY;
  }
  public int getPlayerNewX() {
    return playerNewX;
  }
  public void setPlayerNewX(int playerNewX) {
    this.playerNewX = playerNewX;
  }
  public int getPlayerNewY() {
    return playerNewY;
  }
  public void setPlayerNewY(int playerNewY) {
    this.playerNewY = playerNewY;
  }
  
  //##### POSITION MONSTER #####
  public int getMonsterX() {
    return monsterX;
  }
  public int getMonsterY() {
    return monsterY;
  }
  public int getMonsterLastX() {
    return monsterLastX;
  }
  public void setMonsterLastX(int monsterLastX) {
    this.monsterLastX = monsterLastX;
  }
  public int getMonsterLastY() {
    return monsterLastY;
  }
  public void setMonsterLastY(int monsterLastY) {
    this.monsterLastY = monsterLastY;
  }
  public int getMonsterNewX() {
    return monsterNewX;
  }
  public void setMonsterNewX(int monsterNewX) {
    this.monsterNewX = monsterNewX;
  }
  public int getMonsterNewY() {
    return monsterNewY;
  }
  public void setMonsterNewY(int monsterNewY) {
    this.monsterNewY = monsterNewY;
  }

 
}