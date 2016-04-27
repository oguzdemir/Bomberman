/**
 * Top level controller class for the communication between other
 * subsystems of the application.
 *
 * Created by Anıl Sert on 26.04.2016.
 */
public class GameManager {
    // Instance of the class for satisfying singleton property
    private static GameManager instance = null;

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
   // private SoundManager sManager;

    /**
     * Initializes the GameManager object with default properties and
     * settings taken from the FileManager.
     */
    private GameManager ()
    {
        currentLevel = 1;
        remainingTime = 300;
        currentScore = 0;
        gameState = 0; // Main menu state is 0


        fManager = new FileManager();
        //sManager = new SoundManager();
        loadLevel(currentLevel);
        frame = new MainFrame (this, gEngine);
        frame.setVisible( true );
        /*
        String settings = fManager.loadSettings();

        soundLevel =
        musicLevel =
        musicAdr =
        */
    }

    /**
     * Creates the GameManager instance for the first time if doesn't exist
     * or return the instance.
     *
     * @return singleton instance of the class.
     */
    public static GameManager getInstance ()
    {
        if(instance == null)
            instance = new GameManager();
        return instance;
    }

    /**
     * Get the information of the next level from the FileManager
     * and load it.
     */
    public void loadNextLevel ()
    {
        loadLevel(currentLevel + 1);
    }

    /**
     * Finishes the game and change the game state.
     */
    public void finishGame ()
    {
        gameState = 6; // Game Over state = 6
        gEngine = null;
    }

    /**
     * Load the desired level from the FileManager and load it.
     *
     * @param levelNo desired level to be loaded.
     */
    public void loadLevel (int levelNo)
    {
        currentLevel = levelNo;
        int[][] gameData = fManager.getGameData(levelNo);
        int size = gameData.length;
       // boolean twoPlayer = getGameState() == 2; // Two player state = 2
        boolean twoPlayer = false;
        gEngine = new GameEngine(gameData, size, twoPlayer);
    }

    /**
     * Called by the MainFrame to change the high scores with the
     * user name and new high score and update the list with the help of
     * FileManager.
     */
   /* public void registerHighScores ()
    {
        fManager.setHighScores (highScores);
    }
*/
    /**
     * Called by the MainFrame to get high scores data.
     *
     * @return high scores String representation.
     */
    /*public String getHighScores ()
    {
        return fManager.loadHighScores();
    }*/

    /**
     * Called by the MainFrame to get settings data.
     *
     * @return settings String representation.
     */
    /*public String getSettings ()
    {
        return fManager.loadSettings ();
    }*/

    /**
     * Update high scores string.
     *
     * @param scores changed high scores String representation.
     */
    /*public void updateHighScores (String scores)
    {
        String[] scoreList = getHighScores().split(" ");
        String newName = scores.split(" ")[0]
        String newScore = scores.split(" ")[1];
        String newHighScores = "";

        for (int i = 0; i < scoreList.length - 1; i = i + 2)
        {
            String name = scoreList[i];
            String score = scoreList[i + 1];

            if (Integer.parseInt(score) < Integer.parseInt(newScore))
            {
                newHighScores += newName + " " + newScore + " ";
            }

            newHighScores += name + " " + score + " ";
        }

        highScores = newHighScores;
    }
*/
    /**
     * Update settings with using the FileManager.
     *
     * @param settings changed settings String representation.
     */
    /*public void updateSettings (String settings)
    {
        fManager.saveSettings (settings);
    }*/

    /**
     * Single player version of controlling players.
     * Lets player to control the Bomberman using GameEngine.
     *
     * @param directions user input coming from MainFrame.
     */
    public void controlPlayer (int[] directions)
    {
        boolean dropBomb = directions[2] == 1;

        gEngine.elapseTime(directions[0], directions[1], dropBomb);
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
        boolean dropBomb1 = directions1[2] == 1;
        boolean dropBomb2 = directions2[2] == 1;

        gEngine.elapseTime(directions1[0], directions1[1], dropBomb1, directions2[0], directions2[1], dropBomb2);
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

   /* public SoundManager getsManager() {
        return sManager;
    }

    public void setsManager(SoundManager sManager) {
        this.sManager = sManager;
    }*/
}
