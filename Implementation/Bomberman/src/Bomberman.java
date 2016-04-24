/**
 * Bomberman class for the players to interact with the game.
 *
 * Created by Anıl Sert on 24.4.2016.
 */
public class Bomberman extends GameObject implements Explodable
{
    // Local Variables
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
    public Bomberman (int x, int y)
    {
        super (x, y);
        this.lives = 2;
        this.speed = 1;
        this.bombLimit = 1;
        this.bombMagnitude = 1;
        this.shield = 0;
    }
}

