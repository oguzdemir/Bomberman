/**
 * Created by od on 24.4.2016.
 */
public class BrickWall extends WallRole
{
    public void destroy(GameEngine engine, Wall wall)
    {
        engine.deleteGameObject(wall);
    }
}
