package Model;

/**
 * Magnitude up power up for hte game.
 *
 * Created by Oguz Demir on 24.4.2016.
 */
public class MagnitudeUp extends PowerUp
{
    /**
     * Constructor for the power up.
     * @param x position.
     * @param y position.
     */
    public MagnitudeUp (int x, int y)
    {
        xPosition = x;
        yPosition = y;
    }

    @Override
    public void beTaken(Bomberman bomber)
    {
        bomber.increaseMagnitude();
    }
}
