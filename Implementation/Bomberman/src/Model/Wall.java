package Model;

/**
 * Created by od on 23.4.2016.
 */
public class Wall  extends GameObject
{

    private int type;

    public Wall (int x, int y , int type)
    {
        xPosition = x;
        yPosition = y;
        this.type = type;

    }
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
