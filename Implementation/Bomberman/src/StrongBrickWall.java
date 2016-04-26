/**
 * Created by od on 24.4.2016.
 */
public class StrongBrickWall  extends WallRole
{
    public void destroy(GameEngine engine, Wall wall)
    {
        wall.changeRole();
    }
}
