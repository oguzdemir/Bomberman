/**
 * Created by Oguz Demir on 24.4.2016.
 */
public class SpeedUp extends PowerUp
{
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
