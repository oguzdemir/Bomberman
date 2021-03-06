package Model;

/**
 * Model.Bomberman class for bomber object in the game.
 *
 * Created by Anıl Sert on 24.4.2016.
 *
 * Revised on 26.4.2016 by Oguz Demir
 */
public class Bomberman extends GameObject
{
    // Local Variables
    private int id;
    private int lives;
    private double speed;
    private int bombLimit;
    private int bombMagnitude;
    private int shield;


    /**
     * Create a Model.Bomberman instance with the given position values.
     *
     * @param x x position of the created Model.Bomberman.
     * @param y y position of the created Model.Bomberman.
     * @param id unique id for bomber
     */
    public Bomberman (int x, int y, int id)
    {
        xPosition = x;
        yPosition = y;
        this.id = id;

        lives = 2;
        speed = 1;
        bombLimit = 1;
        bombMagnitude = 1;
        shield = 0;
    }

    /**
     * Method is called when the bomber collide with an explosion
     * and if the remaining lives is 0 Model.GameEngine deletes the object.
     *
     * @param engine reference for the Model.GameEngine class of the game.
     */
    @Override
    public void beExploded (GameEngine engine, int owner)
    {

        if(shield <= 0)
        {
            if(lives == 0)
            {
                engine.deleteGameObject(this);
                allZeros();
                if(owner == id)
                {
                    engine.addScore(owner, - 100);
                }
                else
                    engine.addScore(owner, 100);
            }
            else
                lives--;
        }
        else
            shield = 0;
    }

    public int getLives()
    {
        return lives;
    }

    public int getShield()
    {
        return shield;
    }

    /**
     * Move the bomberman to the desired location.
     *
     * @param x x position for the targeted place.
     * @param y y position for the targeted place.
     */
    public void move (int x, int y)
    {
        setxPosition(xPosition + x);
        setyPosition(yPosition + y);

        if(shield > 0)
            shield--;
    }

    /**
     * This method called when the bomberman takes the shield power up and
     * set the shield attribute accordingly.
     */
    public void giveShield ()
    {
        shield = 900;
    }

    /**
     * This method called when the bomberman takes the limit up power up
     * and set the bombLimit attribute accordingly.
     */
    public void increaseLimit ()
    {
        if(bombLimit < 3)
            bombLimit++;
    }

    /**
     * This method called when the bomberman takes the magnitude up power
     * up and set the bombMagnitude attribute accordingly.
     */
    public void increaseMagnitude ()
    {
        if(bombMagnitude < 3)
            bombMagnitude++;
    }

    /**
     * This method called when the bomberman takes the speed up power up
     * and set the speed attribute accordingly.
     */
    public void increaseSpeed ()
    {
        if(speed < 1.4)
            speed+= 0.1;
    }

    /**
     * Sets all variables to the zero for the bomberman.
     */
    public void allZeros()
    {
        xPosition = 0;
        yPosition = 0;

        lives = 0;
        speed = 0;
        bombLimit = 0;
        bombMagnitude = 0;
        shield = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBombMagnitude()
    {
        return bombMagnitude;
    }

    public int getBombLimit()
    {
        return bombLimit;
    }

    public double getSpeed()
    {
        return speed;
    }
}

