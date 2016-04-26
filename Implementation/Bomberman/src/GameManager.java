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

    

    public static GameManager getInstance() {
        return instance;
    }

    public static void setInstance(GameManager instance) {
        GameManager.instance = instance;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public int getGameState() {
        return gameState;
    }

    public void setGameState(int gameState) {
        this.gameState = gameState;
    }

    public int getSoundLevel() {
        return soundLevel;
    }

    public void setSoundLevel(int soundLevel) {
        this.soundLevel = soundLevel;
    }

    public int getMusicLevel() {
        return musicLevel;
    }

    public void setMusicLevel(int musicLevel) {
        this.musicLevel = musicLevel;
    }

    public String getMusicAdr() {
        return musicAdr;
    }

    public void setMusicAdr(String musicAdr) {
        this.musicAdr = musicAdr;
    }

    public String getHighScores() {
        return highScores;
    }

    public void setHighScores(String highScores) {
        this.highScores = highScores;
    }

    public GameEngine getgEngine() {
        return gEngine;
    }

    public void setgEngine(GameEngine gEngine) {
        this.gEngine = gEngine;
    }

    public MainFrame getFrame() {
        return frame;
    }

    public void setFrame(MainFrame frame) {
        this.frame = frame;
    }

    public FileManager getfManager() {
        return fManager;
    }

    public void setfManager(FileManager fManager) {
        this.fManager = fManager;
    }

    public SoundManager getsManager() {
        return sManager;
    }

    public void setsManager(SoundManager sManager) {
        this.sManager = sManager;
    }
}
