/**
 * Bomb class for the bomb objects created by the Bomberman.
 *
 * Created by Anıl Sert on 24.4.2016.
 */
public class Bomb extends GameObject
{
    // Local Variables
    private int timeLeft;

    /**
     *
     * @param x x position of the created Bomb.
     * @param y y position of the created Bomb.
     */
    public Bomb (int x, int y, int timeLeft)
    {
        super (x, y);
        this.timeLeft = timeLeft;
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
}
