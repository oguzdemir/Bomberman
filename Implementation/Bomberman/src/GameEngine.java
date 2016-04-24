import java.util.ArrayList;

/**
 * Created by od on 23.4.2016.
 */
public class GameEngine
{
    ArrayList<Bomberman> bomberList;
    ArrayList<Bomb> bombList;
    ArrayList<Wall> wallList;
    ArrayList<PowerUp> powerUpList;
    ArrayList<GameObject> objectList;
    OverlapEngine oEngine;

    public boolean elapseTime(int x1, int y1, boolean b1, int timeAmount)
    {

        return true;
    }
    public boolean elapseTime(int x1, int y1, boolean b1, int x2, int y2, boolean b2, int timeAmount)
    {

        return true;
    }

    private void moveBomberman(int index, int x, int y)
    {
        Bomberman b = bomberList.get(index);
        b.move(x,y);
        for(int i = 0; i < objectList.size(); i++)
        {
            GameObject obj = objectList.get(i);
            if(oEngine.checkCollide(b, obj))
            {
                if(obj instanceof PowerUp)
                {
                    ((PowerUp)obj).beTaken(b);

                }
            }
        }
    }
}
