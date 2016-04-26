/**
 * Created by od on 23.4.2016.
 */
public class Wall  extends GameObject
{
    private WallRole role;
    private int type;
    public Wall (int x, int y , int type)
    {
        xPosition = x;
        yPosition = y;

        if(type == 1)
        {
            role = new BrickWall();
            type = 1;
        }
        else if (type == 2)
        {
            role = new StrongBrickWall();
            type = 2;
        }
        else
        {
            role = new SteelWall();
            type = 3;
        }
    }
    public void beExploded(GameEngine engine)
    {
        role.destroy(engine,this);
    }

    public void changeRole()
    {
        role = new BrickWall();
        type = 1;
    }

    public int getType()
    {
        return type;
    }
}
