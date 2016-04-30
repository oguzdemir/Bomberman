package Model;

/**
 * Speed up power up for the game.
 *
 * Created by Oguz Demir on 24.4.2016.
 */
public class SpeedUp extends PowerUp
{

    /**
     * Constructor for the power up.
     * @param x position.
     * @param y position.
     */
    public SpeedUp (int x, int y)
    {
        xPosition = x;
        yPosition = y;
    }

    @Override
    public void beTaken(Bomberman bomber)
    {
        bomber.increaseSpeed();
    }
}
