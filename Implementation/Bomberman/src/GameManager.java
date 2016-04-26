/**
 * Top level controller class for the communication between other
 * subsystems of the application.
 *
 * Created by Anıl Sert on 26.04.2016.
 */
public class GameManager {
    // Instance of the class for satisfying singleton property
    private static GameManager instance;

    // Local variables
    private int currentLevel;
    private int remainingTime;
    private int currentScore;
    private int gameState;
    private int soundLevel;
    private int musicLevel;

    private String musicAdr;
    private String highScores;
    private GameEngine gEngine;
    private MainFrame frame;
    private FileManager fManager;
    private SoundManager sManager;

    /**
     * Initializes the GameManager object with default properties and
     * settings taken from the FileManager.
     */
    public GameManager ()
    {

    }
}
