package Model;

/**
 * Created by Oguz Demir on 23.4.2016.
 */
public abstract class PowerUp extends GameObject
{
    /**
     * Generic method for powerups to be called whenever that powerup is taken by a bomber
     * @param bomber the bomber who takes that powerup
     */
    public abstract void beTaken(Bomberman bomber);

    /**
     * Method for deleting the powerup when it collided in an explosion.
     * @param engine the Model.GameEngine reference is hold to delete the object
     */
    public void beExploded(GameEngine engine)
    {
        engine.deleteGameObject(this);
    }
}
