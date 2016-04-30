package Model;

/**
 * Shield powerup for the game.
 *
 * Created by Oguz Demir on 24.4.2016.
 */
public class Shield extends PowerUp
{

    /**
     * Constructor for the power up.
     * @param x position.
     * @param y position.
     */
    public Shield (int x, int y)
    {
        xPosition = x;
        yPosition = y;
    }
    @Override
    public void beTaken(Bomberman bomber)
    {
        bomber.giveShield();
    }
}
