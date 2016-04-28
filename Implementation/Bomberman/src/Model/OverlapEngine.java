package Model;

/**
 * Engine for checking collisions between Model.GameObject's.
 *
 * Created by Anıl Sert on 24.4.2016.
 */
public class OverlapEngine
{
    /**
     * Check the collisions between two Model.GameObject given as a parameter
     * and give the result according to their positions.
     *
     * @param obj1 first object for checking collisions between.
     * @param obj2 second object for checking collisions between.
     * @return objects are colliding or not.
     */
    public boolean checkCollide(GameObject obj1, GameObject obj2)
    {
        return  obj1.getxPosition() == obj2.getxPosition() &&
                obj1.getyPosition() == obj2.getyPosition();
    }
}
