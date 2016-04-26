/**
 * Bomb class for the bomb objects created by the Bomberman.
 *
 * Created by Anıl Sert on 24.4.2016.
 */
public class Bomb extends GameObject
{

    // Local Variables
    private int owner;
    private int timeLeft;

    /**
     *
     * @param x x position of the created Bomb.
     * @param y y position of the created Bomb.
     * @param owner owner of the Bomb.
     */
    public Bomb (int x, int y, int owner)
    {
        xPosition = x;
        yPosition = y;
        this.owner = owner;
        timeLeft = 3;
    }

    /**
     * This method is called when the bomb is exploded and the GameEngine
     * deletes the GameObject.
     *
     * @param engine reference for the GameEngine class of the game.
     */
    @Override
    public void beExploded (GameEngine engine)
    {
        return;
    }

    /**
     * The count down for the explosion of the Bomb.
     *
     * @return the bomb time is 0 or not.
     */
    public boolean countDown ()
    {
        timeLeft--;

        return timeLeft <= 0;
    }


    public int getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(int timeLeft) {
        this.timeLeft = timeLeft;
    }

    public int getOwner()
    {
        return owner;
    }

    public void setOwner(int owner)
    {
        this.owner = owner;
    }


}
