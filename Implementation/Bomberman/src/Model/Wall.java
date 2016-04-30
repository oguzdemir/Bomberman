package Model;

/**
 * Walls of the game.
 *
 * Created by Oğuz Demir on 23.4.2016.
 */
public class Wall  extends GameObject
{

    private int type;

    /**
     * Constructor for the wall.
     * @param x position.
     * @param y position.
     * @param type of the wall.
     */
    public Wall (int x, int y , int type)
    {
        xPosition = x;
        yPosition = y;
        this.type = type;

    }

    /**
     * Called when the wall takes damage.
     * @param engine reference to the game engine.
     * @param owner owner of the bomb.
     */
    public void beExploded(GameEngine engine, int owner)
    {
        if(type == 1)
        {
            engine.addScore(owner,50);
            engine.deleteGameObject(this);
            engine.dropPowerUp(xPosition,yPosition);
        }
        if(type == 2)
        {
            engine.changeWallType(this);
            type = 1;
        }
    }

}
