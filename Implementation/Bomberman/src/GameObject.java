/**
 * Created by od on 23.4.2016.
 */
public abstract class GameObject implements Explodable
{
    int xPosition;
    int yPosition;

    public int getxPosition()
    {
        return xPosition;
    }

    public void setxPosition(int xPosition)
    {
        this.xPosition = xPosition;
    }

    public int getyPosition()
    {
        return yPosition;
    }

    public void setyPosition(int yPosition)
    {
        this.yPosition = yPosition;
    }
}
