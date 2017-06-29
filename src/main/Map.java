package main;

import enums.FieldContains;
import enums.MoveDirection;
import character.*;
import character.helper.MonsterPreset;

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
        instance = this;
        // without \n !!!
        String init_map =
                "#######################################"+
                "#                                     #"+
                "#                                     #"+
                "#        P                            #"+
                "#        W                            #"+
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
//        Game.getInstance().addMonster( new MonsterCharacter(new Rat()));
        Game.getInstance().addMonster( MonsterPreset.createWolf());
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
                else if( field != '#' && field != ' ' )
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
            }
            this.map += "\n";
        }
    }
    private void singleSpawn(int y,int x, int mapLevel){
        MonsterCharacter monster;
        switch(mapLevel){
            case 4:
                monster = MonsterPreset.createOgerGrunt();
                break;
            case 6:
                monster = MonsterPreset.createOgerShaman();
                break;
            default:
                // spawn rat
                monster = MonsterPreset.createNormalRandom();
        }
        monster.setAllCoordinates(y, x);
        Game.getInstance().addMonster( monster );
        this.labyrinthMap[y][x] = monster.getMapToken();
    }
    
    public void spawnRandomMonster(int mapLevel, int monsterCount){
        for (int i = 0; i < monsterCount; i++){
            int y = Die.rollDie(height-1, 1);
            int x = Die.rollDie(width-1, 1);
            char pos = this.labyrinthMap[y][x];
            if( pos != ' '){
                i--;
            }else{
                singleSpawn(y,x, mapLevel);
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

                l_Y = this.entity.getCoordinates_past()[0];
                l_X = this.entity.getCoordinates_past()[1];
                
                n_y = this.entity.getCoordinates_future()[0];
                n_x = this.entity.getCoordinates_future()[1];
                
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
                l_Y = this.entity.getCoordinates_past()[0];
                l_X = this.entity.getCoordinates_past()[1];
                n_y = this.entity.getCoordinates_future()[0];
                n_x = this.entity.getCoordinates_future()[1];
                
                char mapIndicator = this.entity.getMapToken();
                
                char field = this.labyrinthMap[n_y][n_x];
                
                if(field != ' '){
                    // Not empty Field
                    this.resetNewPos(l_Y, l_X);
                    // no move wasted for player.
                    tempMovement++;
                    // Following is the possibility for Attack Info Message
                    
                }else{
                    //walk freely
                    this.resetMarkerOnMap(l_Y, l_X);
                    this.setMarkerOnMap(n_y, n_x, mapIndicator);
                    this.setLastPos(n_y, n_x);
                }
                this.buildMapString();
                tempMovement--;
            }
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
    // checks if the entered Move direction is not occupied and returns an alternative if necessary
    public MoveDirection getMovedirectionAlternativeIfNecessary(MoveDirection direction) {
        //TODO
        return MoveDirection.DOWN;
    }
    
     
    /**checks what lies in the field where one wants to go
     * 
     * created by Steffen Haas
     * 
     * @param character
     * @param direction
     * @return 
     */
    public static FieldContains getWhatsWhereIGo(BaseCharacter character, MoveDirection direction) {
        
        switch (direction) {
            
        }
        
        return FieldContains.NOTHING;
    }
    
    // gets future Coordinates for Direction
    public static int[] getFutureCoordinates(int currentY, int currentX, MoveDirection direction) {
        int futureY = currentY;
        int futureX = currentX;
        //add or substract for movement
        switch (direction) {
            case UP:
                //UP == Y--
                futureY--;
                break;
            case UP_RIGHT:
                futureY--;
                futureX++;
            case RIGHT:
                //Right == X++
                futureX++;
                break;
            case DOWN_RIGHT:
                futureY++;
                futureX++;
                break;
            case DOWN:
                // DOWN == Y++
                futureY++;
                break;
            case DOWN_LEFT:
                futureY++;
                futureX--;
                break;
            case LEFT:
                //LEFT == X--
                futureX--;
                break;
            case UP_LEFT:
                futureY--;
                futureX--;
                break;
        }
        // array as coordinates
        int[] futureCoordinates= {futureX,futureY};   
        return futureCoordinates;
    }
}