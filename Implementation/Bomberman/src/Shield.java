/**
 * Created by Oguz Demir on 24.4.2016.
 */
public class Shield extends PowerUp
{
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
