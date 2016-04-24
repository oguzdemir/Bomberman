/**
 * GameObject class that base for the many objects in the game.
 *
 * Created by Anıl Sert on 24.4.2016.
 */
public abstract class GameObject
{
    // Local Variables
    private int xPosition, yPosition;

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
