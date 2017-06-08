package main;

import character.*;
import character.races.*;

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
  
  private PlayerCharacter entity;
  
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
    this.buildMapArray();
  }

  /**
   * The default Constructor
   */
    public Map() {
        // without \n !!!
        String init_map =  
                "#######################################"+
                "#                                     #"+
                "#                                     #"+
                "#        P                            #"+
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
    Game.getInstance().addMonster( new MonsterCharacter(new Rat()));
    Game.getInstance().setLevel(1);
    this.buildMapArray();
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
   * Parsing the map string into char array.
   * And setting the positions of Charater to them as they are found on the map.
   * To get the Coordinates of player and monster
   */
  private void buildMapArray()
  {
    this.labyrinthMap = new char[this.height][this.width];
    int monsterCounter = 0;
    for(int y=0; y < this.height; y++)
    {
      for(int x=0; x < this.width; x++)
      {
        char field = map.charAt((y * this.width) + x);
        this.labyrinthMap[y][x] = field;
        if(field == 'P')
        {
          Game.getPlayer().setCoordinates(y, x);
          Game.getPlayer().setCoordinates_past(y, x);
        }
        if(field == 'M')
        {
          Game.getMonsters().get(monsterCounter).setCoordinates(y, x);
          Game.getMonsters().get(monsterCounter).setCoordinates_past(y, x);
          monsterCounter++;
        }
      }
    }
    this.buildMapString();
  }
  
  /**
   * Parsing the MapArray to the MapString
   */
  public void buildMapString()
  {
    this.map = "";
    for(int y=0; y < this.height; y++)
    {
      for(int x=0; x < this.width; x++)
      {
        char field = this.labyrinthMap[y][x];
        this.map += field;
//        System.out.print(field);
      }
      this.map += "\n";
//      System.out.print("\n");
    }
  }
  
  public void spawnRandomMonster(int mapLevel){
      int y,x;
      char pos;
      // mapLevel == number of monster ???
      for (int i = 0; i < mapLevel; i++){
          y = Die.rollDie(height-1, 1);
          x = Die.rollDie(width-1, 1);
          pos = this.labyrinthMap[y][x];
          if(
            pos == '#' ||
            pos == 'P' ||
            pos == 'M'
          ){
              // WRONG: Redo
              i--;
          }else{
              //Correct: place monster in world
              this.labyrinthMap[y][x] = 'M';
              Game.getInstance().addMonster( new MonsterCharacter(y,x) );
          }
      }
      this.buildMapString();
  }
  
  /**
   * @param input Command word for direction
   * @param tempMovement The max movement to walk
   * @param steps Amount of steps to walk
   * @param entity The Character that is moving
   * @return The movement left to walk
   */
  public int walkOnMap(String input, int tempMovement, int steps, PlayerCharacter entity)
  {
    this.entity = entity;
    int l_X;
    int l_Y;
    int n_x;
    int n_y;
    
    if(steps <= tempMovement)
    {
      for(int i=0; i<steps; i++)
      {
// not nice needs a redo
          l_Y = this.entity.getCoordinates_past()[0];
          l_X = this.entity.getCoordinates_past()[1];
          
          n_y = this.entity.getCoordinates_future()[0];
          n_x = this.entity.getCoordinates_future()[1];
        
        System.out.println("steps: " + steps + 
            " | tempMovement: " + tempMovement +
            " | x: " + n_x + " | y:" + n_y + " | l_X: " + l_X +
            " | l_Y: " + l_Y
        );
        switch(input)
        {
          case "left":
          this.moveLeft(l_Y, l_X);
          break;
          case "right":
          this.moveRight(l_Y, l_X);
          break;
          case "down":
          this.moveDown(l_Y, l_X);
          break;
          case "up":
          this.moveUp(l_Y, l_X);
          break;
        }
        
// not nice needs a redo
        l_Y = this.entity.getCoordinates_past()[0];
        l_X = this.entity.getCoordinates_past()[1];
        
        n_y = this.entity.getCoordinates_future()[0];
        n_x = this.entity.getCoordinates_future()[1];
        
        char mapIndicator = this.labyrinthMap[l_Y][l_X];
        System.out.println("Indicator: " + mapIndicator);
        switch(this.labyrinthMap[n_y][n_x])	  // the field I'm in right now!
        {
          case 'M':
              //not monster => PLAYER
            if( !this.entity.getClass().getSimpleName().equalsIgnoreCase("monsterCharater") )
            {
              System.out.println("\nYou cannot fill the same space.\n");
              this.resetNewPos(l_Y, l_X);
            }else{
              this.resetMarkerOnMap(l_Y, l_X);
              this.setMarkerOnMap(n_y, n_x, mapIndicator);
              this.setLastPos(n_y, n_x);
            }
            break;
          case 'P':
              //Monster => NOT PLAYER
            if( this.entity.getClass().getSimpleName().equalsIgnoreCase("monsterCharater") )
            {
              System.out.println("\nYou cannot fill the same space.\n");
              this.resetNewPos(l_Y, l_X);
            }else{
              this.resetMarkerOnMap(l_Y, l_X);
              this.setMarkerOnMap(n_y, n_x, mapIndicator);
              this.setLastPos(n_y, n_x);
            }
            break;
          case ' ':
            this.resetMarkerOnMap(l_Y, l_X);
            this.setMarkerOnMap(n_y, n_x, mapIndicator);
            this.setLastPos(n_y, n_x);
            break;
            
          case '#':
              //Monster => NOT PLAYER
             if( this.entity.getClass().getSimpleName().equalsIgnoreCase("monsterCharater") )
             {
               // AI behavior
             }else{
                 System.out.println("\nYou bumped into a wall.\n");
             }
            break;
          default:
              //...
        }
        this.buildMapString();
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
     * @param a Charater from
     * @param b Charater to
   * @return the euclidean distance
   */
  public int getDistance(PlayerCharacter a, PlayerCharacter b)
  {
    int y = Math.abs( a.getCoordinates_past()[0] - b.getCoordinates()[0] );
    int x = Math.abs( a.getCoordinates_past()[1] - b.getCoordinates()[1] );
    int dist = Math.round( (float) Math.sqrt( Math.pow(x, 2) + Math.pow(y, 2) ) );
    System.out.println("Dist: " + dist);
    return dist;
  }
  
  //##### MOVEMENT #####
  /**
   * move up
   * 
   * @param y
   * @param x
   * @param character 
   */
  private void moveUp(int y, int x)
  {
    //UP == Y--
    this.entity.setCoordinates_future(y-1, x);
  }
  
  /**
   * move right
   * 
   * @param y
   * @param x
   * @param character 
   */
  private void moveRight(int y, int x)
  {
    //Right == x++
    this.entity.setCoordinates_future(y, x+1);
  }
  
  /**
   * move down
   * 
   * @param y
   * @param x
   * @param character 
   */
  private void moveDown(int y, int x)
  {
    // DOWN == Y++
    this.entity.setCoordinates_future(y+1, x);
  }
  
  /**
   * move left
   * 
   * @param y
   * @param x
   * @param character 
   */
  private void moveLeft(int y, int x)
  {
    // LEFT == x--
    this.entity.setCoordinates_future(y, x-1);
  }
  
  /**
   * set last position
   * 
   * @param y
   * @param x
   * @param character 
   */
  private void setLastPos(int y, int x)
  {
    this.entity.setCoordinates_past(y, x);
    this.entity.setCoordinates(y, x);
  }
  
  /**
   * reset new position
   * 
   * @param y
   * @param x
   * @param character 
   */
  private void resetNewPos(int y, int x)
  {
    this.entity.setCoordinates_future(y, x);
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
    this.buildMapString();
  }
  /**
   * reset a marker on the map to blank space
   * 
   * @param y
   * @param x 
   */
  public void resetMarkerOnMap(int y, int x)
  {
    this.labyrinthMap[y][x] = ' ';
    this.buildMapString();
  }
}