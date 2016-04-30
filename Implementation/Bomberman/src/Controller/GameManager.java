package Controller;

import Model.GameEngine;
import View.MainFrame;

import java.util.ArrayList;

/**
 * Top level controller class for the communication between other
 * subsystems of the application.
 *
 * Created by An?l Sert on 26.04.2016.
 */
public class GameManager {
    // Instance of the class for satisfying singleton property
    private static GameManager instance = null;

    // Local variables
    private int currentLevel;
    private int remainingTime;

    private int currentScore1;
    private int currentScore2;

    private int gameState;

    private int soundLevel;
    private int musicLevel;

    private boolean twoPlayer;
    private boolean initialGame;

    private boolean currentlyPlaying;
    private boolean bgOn;
    private boolean soundOn;


    private String musicAdr;
    private String highScores;
    private GameEngine gEngine;
    private MainFrame frame;
    private FileManager fManager;
    private SoundManager sManager;

    /**
     * Initializes the Controller.GameManager object with default properties and
     * settings taken from the Controller.FileManager.
     */
    private GameManager ()
    {
        initialGame = true;
        currentLevel = 1;
        currentScore1 = 0;
        currentScore2 = 0;

        gameState = 0; // Main menu state is 0

        fManager = new FileManager();

        String settings = fManager.loadSettings();

        bgOn = Boolean.parseBoolean(settings.split(" ")[0]);
        soundOn = Boolean.parseBoolean(settings.split(" ")[1]);
        soundLevel = Integer.parseInt(settings.split(" ")[2]);
        musicLevel = Integer.parseInt(settings.split(" ")[2]);


        sManager = new SoundManager();
        frame = MainFrame.getInstance(this, gEngine);
        frame.setVisible( true );


        currentlyPlaying = false;
        /*
        String settings = fManager.loadSettings();

        soundLevel =
        musicLevel =
        musicAdr =
        */
    }

    /**
     * Creates the Controller.GameManager instance for the first time if doesn't exist
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

    public void updateGameView(int[][] objectData, int[] bomberData, int[] bomberInfo, int []scores)
    {
        currentScore1 += scores[0];
        currentScore2 += scores[3];

            frame.updateGameView(objectData,bomberData,bomberInfo,currentLevel,remainingTime,currentScore1,currentScore2, twoPlayer);
    }

    /**
     * Single player version of controlling players.
     * Lets player to control the Model.Bomberman using Model.GameEngine.
     *
     * @param directions1 user input coming from View.MainFrame.
     * @param directions2 user input coming from View.MainFrame.
     */
    public void controlPlayer (int[] directions1, int[] directions2 )
    {
        boolean dropBomb1 = directions1[2] == 1;
        boolean dropBomb2 = directions2[2] == 1;

        remainingTime--;

        int result;
        //SinglePlayer Game
        if(!twoPlayer)
            result = gEngine.elapseTime(directions1[0], directions1[1], dropBomb1);
        else
            result = gEngine.elapseTime(directions1[0], directions1[1], dropBomb1,directions2[0], directions2[1], dropBomb2 );

        if(result != 0 )
        {

            if (currentLevel < 4)
            {
                changeGameStatus(8 , result);
                currentLevel++;
            }
            else
            {
                if(twoPlayer)
                {
                    if(currentScore2 > currentScore1)
                    {
                        boolean b = checkHighScores(currentScore2);
                        if(b)
                            result = 8;
                        else
                            result = 3;
                    }

                    changeGameStatus(9,result);
                    return;
                }

                boolean b = checkHighScores(currentScore1);
                if(b)
                    result = 7;
                else
                    result = 3;


                changeGameStatus(9,result);

            }
        }
    }

    public void changeGameStatus (int status,int result)
    {

        switch (status) {
            case -1:
                currentLevel = 1;
                currentScore1 = 0;
                currentScore2 = 0;
                initialGame = true;
                changeGameStatus(0,0);
                return;
            case 0:
                initialGame = true;
                currentlyPlaying = false;
                break;
            case 1:
                if(initialGame)
                    twoPlayer = false;
                if(!currentlyPlaying)
                    loadLevel(currentLevel);
                frame.startGame();
                currentlyPlaying = true;
                initialGame = false;
                break;
            case 2:
                if(initialGame)
                    twoPlayer = true;
                if(!currentlyPlaying)
                    loadLevel(currentLevel);
                frame.startGame();
                currentlyPlaying = true;
                initialGame = false;
                break;
            case 8:
                currentlyPlaying = false;
                break;
            case 9:
                currentlyPlaying = false;
                break;
        }

        gameState = status;

        frame.updateStatusView(status,result);

    }








    /**
     * Get the information of the next level from the Controller.FileManager
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
     * Load the desired level from the Controller.FileManager and load it.
     *
     * @param levelNo desired level to be loaded.
     */
    public void loadLevel (int levelNo)
    {
        remainingTime = 7200;
        int[][] gameData = fManager.getGameData(levelNo);
        int size = gameData.length;
       // boolean twoPlayer = getGameState() == 2; // Two player state = 2
        boolean twoPlayer = false;
        gEngine = new GameEngine(gameData, size, twoPlayer,this);

    }

    /**
     * Called by the View.MainFrame to change the high scores with the
     * user name and new high score and update the list with the help of
     * Controller.FileManager.
     */
    public void registerHighScores ()
    {
        fManager.setHighScores (highScores);
    }

    /**
     * Called by the View.MainFrame to get high scores data.
     *
     * @return high scores String representation.
     */
    public String getHighScores ()
    {
        return fManager.loadHighScores();
    }

    /**
     * Called by the View.MainFrame to get settings data.
     *
     * @return settings String representation.
     */
    public String getSettings ()
    {
        return fManager.loadSettings ();
    }


    public void registerScore(String name)
    {
        updateHighScores(name + " " + currentScore1);
    }
    /**
     * Update high scores string.
     *
     * @param scores changed high scores String representation.
     */
    public void updateHighScores (String scores)
    {
        String[] scoreList = getHighScores().split(" ");
        ArrayList<String> nameList = new ArrayList<String>();
        ArrayList<String> scoresList = new ArrayList<String>();

        String newName = scores.split(" ")[0];
        String newScore = scores.split(" ")[1];
        String newHighScores = "";

        boolean notput = false;

        for (int i = 0; i < scoreList.length - 1; i = i + 2)
        {
            String score = scoreList[i + 1];

            if (Integer.parseInt(score) < Integer.parseInt(newScore) && !notput)
            {
                notput = true;
                nameList.add(newName);
                scoresList.add(newScore);
            }

            nameList.add(scoreList[i]);
            scoresList.add(score);
        }

        if (nameList.size() > 10)
        {
            nameList.remove(nameList.size() - 1);
            scoresList.remove(scoresList.size() - 1);
        }
        
        for (int i = 0; i < scoresList.size(); i++)
        {
            newHighScores += nameList.get(i) + " " + scoresList.get(i) + " ";
        }

        highScores = newHighScores;


        registerHighScores();
    }

    public boolean checkHighScores (int given)
    {
        String[] scoreList = getHighScores().split(" ");

        int count = 0;
        for (int i = 0; i < scoreList.length - 1; i = i + 2)
        {
            String name = scoreList[i];
            String score = scoreList[i + 1];
            count ++;
            if (Integer.parseInt(score) < given)
            {
                return true;
            }

        }
        if(count < 10)
            return true;

        return false;
    }

    /**
     * Update settings with using the Controller.FileManager.
     *
     * @param settings changed settings String representation.
     */
    public void updateSettings (String settings)
    {
        fManager.saveSettings (settings);
    }



    /**
     * Called by the View.MainFrame to learn the state of the game.
     *
     * @return state of the game.
     */
    public int getGameState ()
    {
        return gameState;
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

    public boolean isBgOn() {
        return bgOn;
    }

    public void setBgOn(boolean bgOn) {
        this.bgOn = bgOn;
    }

    public boolean isSoundOn() {
        return soundOn;
    }

    public void setSoundOn(boolean soundOn) {
        this.soundOn = soundOn;
    }
}
