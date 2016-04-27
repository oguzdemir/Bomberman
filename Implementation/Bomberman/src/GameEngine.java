import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Oguz Demir on 23.4.2016.
 */
public class GameEngine
{
    //Properties
    private Bomberman[] bomberList;
    private ArrayList<Bomb> bombList;
    private ArrayList<Wall> wallList;
    private ArrayList<PowerUp> powerUpList;
    private GameObject[][] objectMap;
    private int[][] objectIntMap;
    private OverlapEngine oEngine;
    private int gridSize;
    private boolean gameState;
    private boolean twoPlayers;
    private static final int GRID_DIMENSION = 40;
    //Constructor
    /**
    Constructor called by GameManager with 2D array holding the wall map and the dimension size.
    Also, gametype is given with a boolean
     */
    public GameEngine(int[][] map, int n, boolean twoPlayers)
    {
        //Initializing the collections
        bomberList = new Bomberman[4];
        bombList = new ArrayList<Bomb>();
        wallList = new ArrayList<Wall>();
        objectIntMap = new int [n][n];
        objectMap =  new GameObject[n][n];
        gridSize = n;
        gameState = true;
        this.twoPlayers = twoPlayers;
        for(int i = 0; i < n ; i ++)
        {
            for(int j = 0; j < n; j++)
            {
                objectMap[i][j] = null;
                objectIntMap[i][j] = 0;
            }
        }
        //In the corners, bombermans will be placed. So if there is any wall on corners in the given map
        //they will be deleted to open up space for bombers.
        map[1][1] = 0;
        map[1][n-2] = 0;
        map[n-2][1] = 0;
        map[n-2][n-2] = 0;


        int xCoordinate = 0;
        int yCoordinate = 0;
        for(int i = 0; i < n ; i ++)
        {
            for(int j = 0; j < n; j++)
            {
                if(map[i][j] != 0)
                {
                    Wall newWall = new Wall(xCoordinate,yCoordinate, map[i][j]);
                    wallList.add(newWall);
                    objectMap[i][j] = newWall;
                    objectIntMap[i][j] = map[i][j];
                }
                xCoordinate += GRID_DIMENSION;
            }
            yCoordinate += GRID_DIMENSION;
            xCoordinate = 0;
        }

        int dimension = (n-2) * GRID_DIMENSION;

        //Creating Bomber 1: top left
        bomberList[0] = new Bomberman(GRID_DIMENSION,GRID_DIMENSION,0);

        //Creating Bomber 2: top right
        bomberList[1] = new Bomberman(GRID_DIMENSION,dimension,1);

        //Creating Bomber 3: bottom left
        bomberList[2] = new Bomberman(dimension, GRID_DIMENSION,2);

        //Creating Bomber 4: bottom right
        bomberList[3]  = new Bomberman(dimension, dimension,3);


        oEngine = new OverlapEngine();
    }

    /**
     * In singleplayer game, elapseTime method is called by GameManager to advance game
     * with directions of player
     * @param x1 movement in x axis for player1's bomber
     * @param y1 movement in y axis for player1's bomber
     * @param b1 is action flag for dropping bomb for player1's bomber
     * @return flag for indicating game is ended or not.
     */
    public int[][]serveGameMap(int [] x)
    {
        x[0] = bomberList[0].getxPosition();
        x[1] = bomberList[0].getyPosition();
        x[2] = bomberList[1].getxPosition();
        x[3] = bomberList[1].getyPosition();
        x[4] = bomberList[2].getxPosition();
        x[5] = bomberList[2].getyPosition();
        x[6] = bomberList[3].getxPosition();
        x[7] = bomberList[3].getyPosition();
        return objectIntMap;
    }
    public boolean elapseTime(int x1, int y1, boolean b1)
    {
        if(!gameState)
        {
            return true;
        }
        for(int i = 0 ; i < bombList.size() ; i++)
        {
            boolean b = bombList.get(i).countDown();
            if(b)
            {
                explodeBomb(bombList.get(i));
            }
        }
        if(b1)
        {
            dropBomb(bomberList[0].getxPosition(), bomberList[0].getyPosition(), 0 );
        }
        int pixelConstant = GRID_DIMENSION / 4;
        moveBomberman(0,x1 *pixelConstant * bomberList[0].getSpeed() ,y1 * pixelConstant * bomberList[0].getSpeed());

        Random generator = new Random();
        int randomIndex1, randomIndex2;

        //MOVING CPU BOMBERS
        //Moving second
        randomIndex1= generator.nextInt( 3 ) - 1;
        randomIndex2= generator.nextInt( 3 ) - 1;

        moveBomberman(1,randomIndex1 * pixelConstant * bomberList[1].getSpeed() ,randomIndex2 * pixelConstant * bomberList[1].getSpeed());

        //Moving 3rd
        randomIndex1= generator.nextInt( 3 ) - 1;
        randomIndex2= generator.nextInt( 3 ) - 1;

        moveBomberman(2,randomIndex1 * pixelConstant * bomberList[2].getSpeed() ,randomIndex2 * pixelConstant * bomberList[2].getSpeed());

        //Moving 4th
        randomIndex1= generator.nextInt( 3 ) - 1;
        randomIndex2= generator.nextInt( 3 ) - 1;

        moveBomberman(3,randomIndex1 * pixelConstant * bomberList[3].getSpeed() ,randomIndex2 * pixelConstant * bomberList[3].getSpeed());

        //RANDOMLY DROP BOMBS FOR 3 CPU BOMBERS, WITH 10% probability
        randomIndex1= generator.nextInt( 10 );
        if(randomIndex1 == 5)
        {
            dropBomb(bomberList[1].getxPosition(), bomberList[1].getyPosition(), 1 );
        }

        randomIndex1= generator.nextInt( 10 );
        if(randomIndex1 == 5)
        {
            dropBomb(bomberList[2].getxPosition(), bomberList[2].getyPosition(), 1 );
        }

        randomIndex1= generator.nextInt( 10 );
        if(randomIndex1 == 5)
        {
            dropBomb(bomberList[2].getxPosition(), bomberList[2].getyPosition(), 1 );
        }

        return false;

    }

    /**
     * In singleplayer game, elapseTime method is called by GameManager to advance game
     * with directions of players
     * @param x1 movement in x axis for player1's bomber
     * @param y1 movement in y axis for player1's bomber
     * @param b1 is action flag for dropping bomb for player1's bomber
     * @param x2 movement in x axis for player2's bomber
     * @param y2 movement in y axis for player2's bomber
     * @param b2 is action flag for dropping bomb for player2's bomber
     * @return flag for indicating game is ended or not.
     */
    public boolean elapseTime(int x1, int y1, boolean b1, int x2, int y2, boolean b2)
    {
        if(!gameState)
        {
            return true;
        }
        for(Bomb bomb: bombList)
        {
            boolean b = bomb.countDown();
            if(b)
            {
                explodeBomb(bomb);
            }
        }
        int pixelConstant = GRID_DIMENSION / 4;
        if(bomberList[0] != null)
        {
            if(b1)
            {
                dropBomb(bomberList[0].getxPosition(), bomberList[0].getyPosition(), 0 );
            }

            moveBomberman(0,x1 *pixelConstant * bomberList[0].getSpeed()  ,y1 * pixelConstant * bomberList[0].getSpeed());
        }
        if(bomberList[1] != null)
        {
            if(b2)
            {
                dropBomb(bomberList[1].getxPosition(), bomberList[1].getyPosition(), 1 );
            }
            pixelConstant = GRID_DIMENSION / 4;
            moveBomberman(1,x2 *pixelConstant * bomberList[1].getSpeed()  ,y2 * pixelConstant * bomberList[1].getSpeed());
        }


        Random generator = new Random();
        int randomIndex1, randomIndex2;

        //MOVING CPU BOMBERS

        //Moving 3rd
        randomIndex1= generator.nextInt( 3 ) - 1;
        randomIndex2= generator.nextInt( 3 ) - 1;

        moveBomberman(2,randomIndex1 * pixelConstant * bomberList[2].getSpeed() ,randomIndex2 * pixelConstant * bomberList[2].getSpeed());

        //Moving 4th
        randomIndex1= generator.nextInt( 3 ) - 1;
        randomIndex2= generator.nextInt( 3 ) - 1;

        moveBomberman(3,randomIndex1 * pixelConstant * bomberList[3].getSpeed() ,randomIndex2 * pixelConstant * bomberList[3].getSpeed());

        //RANDOMLY DROP BOMBS FOR 2 CPU BOMBERS, WITH 10% probability
        randomIndex1= generator.nextInt( 10 );
        if(randomIndex1 == 5)
        {
            dropBomb(bomberList[2].getxPosition(), bomberList[2].getyPosition(), 1 );
        }

        randomIndex1= generator.nextInt( 10 );
        if(randomIndex1 == 5)
        {
            dropBomb(bomberList[2].getxPosition(), bomberList[2].getyPosition(), 1 );
        }

        return false;

    }

    public void addPowerUp(int x, int y)
    {
        // TODO - implement GameEngine.addGameObject
        throw new UnsupportedOperationException();
    }

    /**
     * Method is called for deleting an object from game
     * @param object is object to be deleted.
     */
    public void deleteGameObject(GameObject object)
    {
        if(object instanceof Bomberman)
        {
            for(int i = 0 ; i < 4 ; i++)
            {
                if( ((Bomberman)object).getId() == i )
                {
                    bomberList[i] = null;
                }
            }
            if(!twoPlayers && bomberList[0] == null)
            {
                gameState = false;
            }
            if(twoPlayers && bomberList[0] == null && bomberList[1] == null)
            {
                gameState = false;
            }
            return;
        }
        int xCoordinate = object.getxPosition();
        int yCoordinate = object.getyPosition();

        int xGrid = xCoordinate / GRID_DIMENSION;
        int yGrid = yCoordinate / GRID_DIMENSION;

        if(object instanceof Bomb)
        {
            bombList.remove(object);
        }
        objectMap[xGrid][yGrid] = null;

    }

    /**
     *
     * @param index which bomberman to be moved
     * @param x delta x on x axis
     * @param y delta x on y axis
     */
    private void moveBomberman(int index, int x, int y)
    {
        Bomberman b = bomberList[index];

        b.move(x,y);

        int xCoordinate = b.getxPosition();
        int yCoordinate = b.getyPosition();

        int xGrid = xCoordinate / GRID_DIMENSION;
        int yGrid = yCoordinate / GRID_DIMENSION;

        GameObject o = objectMap[xGrid][yGrid];

        if(o instanceof PowerUp)
        {
            ((PowerUp) o).beTaken(b);
            return;
        }
        b.move(x *(-1), y * (-1));

    }

    /**
     *
     * @param x location of bomb on x axis
     * @param y location of bomb on y axis
     * @param owner the bomber dropped that bomb
     */
    private void dropBomb( int x , int y, int owner)
    {
        Bomb newBomb = new Bomb(x, y, owner);
        bombList.add(newBomb);

        int xGrid = x / GRID_DIMENSION;
        int yGrid = y / GRID_DIMENSION;

        objectMap[xGrid][yGrid] = newBomb;


    }

    /**
     * explodeBomb method is called whenever a bomb is exploded, it process the object nearby for explosion
     * @param bomb is the bomb exploded
     */
    private void explodeBomb(Bomb bomb)
    {
        int magnitude = bomberList[bomb.getOwner()].getBombMagnitude();

        int[] bombersXGrids = new int[4];
        int[] bombersYGrids = new int[4];

        for(int i = 0; i < 4 ; i++)
        {
            bombersXGrids[i] = bomberList[i].getxPosition()/ GRID_DIMENSION;
            bombersYGrids[i] = bomberList[i].getyPosition()/ GRID_DIMENSION;
        }

        int xCoordinate = bomb.getxPosition();
        int yCoordinate = bomb.getyPosition();

        int xGrid = xCoordinate / GRID_DIMENSION;
        int yGrid = yCoordinate / GRID_DIMENSION;

        //left direction
        for(int i = 1 ; i <= magnitude ; i++)
        {
            if(xGrid-i >= 0 && objectMap[xGrid-i][yGrid] != null)
            {
                objectMap[xGrid-i][yGrid].beExploded(this);
                break;
            }
            for(int j = 0; j < 4 ; j++)
            {
                boolean flag = false;
                if(xGrid-i == bombersXGrids[j] && yGrid == bombersYGrids[j])
                {
                    bomberList[j].beExploded(this);
                    flag = true;
                }
                if(flag)
                    break;
            }


        } // end of left direction

        //right direction
        for(int i = 1 ; i <= magnitude ; i++)
        {
            if( xGrid+i < gridSize && objectMap[xGrid+i][yGrid] != null)
            {
                objectMap[xGrid+i][yGrid].beExploded(this);
                break;
            }
            for(int j = 0; j < 4 ; j++)
            {
                boolean flag = false;
                if(xGrid + i == bombersXGrids[j] && yGrid == bombersYGrids[j])
                {
                    bomberList[j].beExploded(this);
                    flag = true;
                }
                if(flag)
                    break;
            }


        } // end of right direction

        //up direction
        for(int i = 1 ; i <= magnitude ; i++)
        {
            if( yGrid - i >= 0 && objectMap[xGrid][yGrid - i] != null)
            {
                objectMap[xGrid][yGrid - i].beExploded(this);
                break;
            }
            for(int j = 0; j < 4 ; j++)
            {
                boolean flag = false;
                if(xGrid == bombersXGrids[j] && yGrid - i == bombersYGrids[j])
                {
                    bomberList[j].beExploded(this);
                    flag = true;
                }
                if(flag)
                    break;
            }
        } // end of up direction

        //down direction
        for(int i = 1 ; i <= magnitude ; i++)
        {
            if( yGrid + i < gridSize && objectMap[xGrid][yGrid + i] != null)
            {
                objectMap[xGrid][yGrid + i].beExploded(this);
                break;
            }
            for(int j = 0; j < 4 ; j++)
            {
                boolean flag = false;
                if(xGrid == bombersXGrids[j] && yGrid + i == bombersYGrids[j])
                {
                    bomberList[j].beExploded(this);
                    flag = true;
                }
                if(flag)
                    break;
            }
        } // end of down direction
    }

}
