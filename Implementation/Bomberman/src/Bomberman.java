/**
 * Created by od on 23.4.2016.
 */
public class Bomberman extends GameObject
{
    void beExploded(GameEngine Engine);
    private int lives;
    private int speed;
    private int bombLimit;
    private int bombMagnitude;
    private int shield;
    private int id;

    public int getId()
    {
        return id;
    }

    public Bomberman(int x, int y, int owner)
    {

    }
    public void move(int x, int y)
    {
        this.setxPosition(this.getxPosition() + x);
        this.setyPosition(this.getyPosition() + y);
    }

    public int getLives()
    {
        return lives;
    }

    public void setLives(int lives)
    {
        this.lives = lives;
    }

    public int getShield()
    {
        return shield;
    }

    public void setShield(int shield)
    {
        this.shield = shield;
    }

    public int getBombMagnitude()
    {
        return bombMagnitude;
    }

    public void setBombMagnitude(int bombMagnitude)
    {
        this.bombMagnitude = bombMagnitude;
    }

    public int getBombLimit()
    {
        return bombLimit;
    }

    public void setBombLimit(int bombLimit)
    {
        this.bombLimit = bombLimit;
    }

    public int getSpeed()
    {
        return speed;
    }

    public void setSpeed(int speed)
    {
        this.speed = speed;
    }
}

