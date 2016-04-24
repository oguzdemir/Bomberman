/**
 * GameObject class that base for the many objects in the game.
 *
 * Created by Anıl Sert on 24.4.2016.
 */
public abstract class GameObject
{
    // Local Variables
    int xPosition, yPosition;

    /**
     * The constructor of the GameObject class.
     *
     * @param x x position of the created GameObject.
     * @param y y position of the created GameObject.
     */
    public GameObject (int x, int y)
    {
        this.xPosition = x;
        this.yPosition = y;
    }

    public int getXPosition() {
        return xPosition;
    }

    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }
}
