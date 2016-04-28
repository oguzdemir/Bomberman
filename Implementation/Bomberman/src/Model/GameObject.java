package Model;

/**
 * Model.GameObject class that base for the many objects in the game.
 *
 * Created by Anıl Sert on 24.4.2016.
 */
public abstract class GameObject implements Explodable
{
    // Local Variables
    protected int xPosition, yPosition;

    public int getxPosition()
    {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }
}
