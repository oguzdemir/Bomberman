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

    /**
     * Creates the GameManager instance for the first time if doesn't exist
     * or return the instance.
     *
     * @return singleton instance of the class.
     */
    public static GameManager getInstance ()
    {
        // TODO Write the method body
        return instance;
    }

    /**
     * Get the information of the next level from the FileManager
     * and load it.
     */
    public void loadNextLevel ()
    {

    }

    /**
     * Finishes the game and change the game state.
     */
    public void finishGame ()
    {

    }

    /**
     * Load the desired level from the FileManager and load it.
     *
     * @param levelNo desired level to be loaded.
     */
    public void loadLevel (int levelNo)
    {

    }

    /**
     * Called by the MainFrame to change the high scores with the
     * user name and new high score and update the list with the help of
     * FileManager.
     */
    public void registerHighScores ()
    {

    }

    /**
     * Called by the MainFrame to get high scores data.
     *
     * @return high scores String representation.
     */
    public String getHighScores ()
    {
        return highScores;
    }

    /**
     * Called by the MainFrame to get settings data.
     *
     * @return settings String representation.
     */
    public String getSettings ()
    {
        return fManager.loadSettings ();
    }

    /**
     * Update high scores with using the FileManager.
     *
     * @param scores changed high scores String representation.
     */
    public void updateHighScores (String scores)
    {
        fManager.setHighScores (scores);
    }

    /**
     * Update settings with using the FileManager.
     *
     * @param settings changed settings String representation.
     */
    public void updateSettings (String settings)
    {
        fManager.saveSettings (settings);
    }

    /**
     * Single player version of controlling players.
     * Lets player to control the Bomberman using GameEngine.
     *
     * @param directions user input coming from MainFrame.
     */
    public void controlPlayer (int[] directions)
    {

    }

    /**
     * Multi player version of controlling players.
     * Lets both players to control their Bomberman using GameEngine.
     *
     * @param directions1 user input for the first player.
     * @param directions2 user input for the second player.
     */
    public void controlPlayer (int[] directions1, int[] directions2)
    {

    }

    /**
     * Called by the MainFrame to learn the state of the game.
     *
     * @return state of the game.
     */
    public int getGameState ()
    {
        return gameState;
    }

    /**
     * Changes the state of the game.
     *
     * @param status desired state to be changed.
     */
    public void changeGameStatus (int status)
    {
        gameState = status;
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
