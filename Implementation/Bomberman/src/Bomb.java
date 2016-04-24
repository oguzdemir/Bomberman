/**
 * Created by od on 23.4.2016.
 */
public class Bomb extends GameObject
{
    private int owner;

    public Bomb(int x, int y, int owner)
    {
        xPosition = x;
        yPosition = y;
        this.owner = owner;
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

    }

    void beExploded(GameEngine Engine);
}
