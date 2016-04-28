package Model;

/**
 * Created by Oguz Demir on 24.4.2016.
 */
public class MagnitudeUp extends PowerUp
{
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
