package Model;

/**
 * Created by od on 28.4.2016.
 */
public class AiEngine
{
    int []directions;



    private boolean collided;
    private boolean preCollided;
    private int count;
    boolean x;
    int preX,preY;
    int busyWait;
    public AiEngine(int wayX, int wayY)
    {
        directions = new int[3];
        x = false;
        directions[0] = wayX;
        directions[1] = wayY;
        directions[2] = 0;
        busyWait = -1;
    }

    public int[] getDirections()
    {
        if (busyWait < 0)
            return directions;
        else if (busyWait == 0)
        {
            busyWait--;
            directions[0] = -preX;
            directions[1] = -preY;
            directions[2] = 0;
            count = 0;
            return directions;
        } else
        {
            busyWait--;
            directions[0] = 0;
            directions[1] = 0;
            directions[2] = 0;
            return directions;
        }

    }
    public void bombPlaced(boolean given)
    {
        if(!given)
        {
            count = 0;
        }
    }
    public void setCollided(boolean given)
    {
        directions[2] = 0;
        if(given)
        {
            if (count == 0)
            {
                directions[0] *= -1;
                directions[1] *= -1;
                directions[2] = 1;
                count = 2;
                return;
            }
            if (count == 1)
            {

                if (busyWait < 0)
                    busyWait = 50;
                preX = directions[0];
                preY = directions[1];
                count--;
                return;
            }
            if (count == 2)
            {

                int temp = directions[0];
                directions[0] = directions[1];
                directions[1] = temp;
                count--;
            }
        }

    }
}
