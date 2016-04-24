/**
 * Created by od on 23.4.2016.
 */
public class Bomb extends GameObject
{
    private int owner;
    private int timeLeft;

    public Bomb(int x, int y, int owner)
    {
        xPosition = x;
        yPosition = y;
        this.owner = owner;
        timeLeft = 3;
    }

    public int getOwner()
    {
        return owner;
    }

    public void setOwner(int owner)
    {
        this.owner = owner;
    }

    public boolean countDown()
    {
        timeLeft--;
        if (timeLeft == 0)
            return true;
        else
            return false;
    }

    public void beExploded(GameEngine Engine)
    {
        return;
    }
}
