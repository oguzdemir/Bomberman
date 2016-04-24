/**
 * Created by Anıl Sert on 24.4.2016.
 */
public abstract class GameObject
{
    // Local Variables
    private int xPosition, yPosition;

    /**
     * The constructor of the GameObject class
     *
     * @param x x position of the created GameObject
     * @param y y position of the created GameObject
     */
    public GameObject (int x, int y)
    {
        this.xPosition = x;
        this.yPosition = y;
    }
}
