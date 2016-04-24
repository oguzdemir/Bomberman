/**
 * Bomberman class for the players to interact with the game.
 *
 * Created by Anıl Sert on 24.4.2016.
 */
public class Bomberman extends GameObject implements Explodable
{
    // Local Variables
    private int id;
    private int lives;
    private int speed;
    private int bombLimit;
    private int bombMagnitude;
    private int shield;

    /**
     * Create a Bomberman instance with the given position values.
     *
     * @param x x position of the created Bomberman.
     * @param y y position of the created Bomberman.
     */
    public Bomberman (int x, int y, int id)
    {
        this.setXPosition(x);
        this.setYPosition(y);
        this.id = id;
        this.lives = 2;
        this.speed = 1;
        this.bombLimit = 1;
        this.bombMagnitude = 1;
        this.shield = 0;
    }

    /**
     * Method is called when the bomber collide with an explosion
     * and if the remaining lives is 0 GameEngine deletes the object.
     *
     * @param engine reference for the GameEngine class of the game.
     */
    @Override
    public void beExploded (GameEngine engine)
    {
        if (getShield() <= 0 && getLives() <= 0)
        {
            engine.deleteGameObject(this);
        }
    }

    /**
     * Move the bomberman to the desired location.
     *
     * @param x x position for the targeted place.
     * @param y y position for the targeted place.
     */
    public void move (int x, int y)
    {
        setXPosition(x);
        setYPosition(y);
    }

    /**
     * This method called when the bomberman takes the shield power up and
     * set the shield attribute accordingly.
     */
    public void giveShield ()
    {
        setShield(getShield() + 1);
    }

    /**
     * This method called when the bomberman takes the limit up power up
     * and set the bombLimit attribute accordingly.
     */
    public void increaseLimit ()
    {
        setBombLimit(getBombLimit() + 1);
    }

    /**
     * This method called when the bomberman takes the magnitude up power
     * up and set the bombMagnitude attribute accordingly.
     */
    public void increaseMagnitude ()
    {
        setBombMagnitude(getBombMagnitude() + 1);
    }

    /**
     * This method called when the bomberman takes the speed up power up
     * and set the speed attribute accordingly.
     */
    public void increaseSpeed ()
    {
        setSpeed(getSpeed() + 1);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getBombLimit() {
        return bombLimit;
    }

    public void setBombLimit(int bombLimit) {
        this.bombLimit = bombLimit;
    }

    public int getBombMagnitude() {
        return bombMagnitude;
    }

    public void setBombMagnitude(int bombMagnitude) {
        this.bombMagnitude = bombMagnitude;
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }
}

