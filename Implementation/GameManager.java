public class GameManager
{

	private GameManager instance;
	private int currentLevel;
	private int remainingTime;
	private int currentScore;
	private int gameState;
	private int soundLevel;
	private int musicLevel;
	private string musicAdr;
	private string highScores;
	private GameEngine gEngine;
	private MainFrame frame;
	private FileManager fManager;
	private SoundManager sManager;

	public GameManager getInstance()
	{
		return this.instance;
	}

	public GameManager()
	{
		// TODO - implement GameManager.GameManager
		throw new UnsupportedOperationException();
	}

	public void loadNextLevel()
	{
		// TODO - implement GameManager.loadNextLevel
		throw new UnsupportedOperationException();
	}

	public void finishGame()
	{
		// TODO - implement GameManager.finishGame
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param levelNo
	 */
	public void loadLevel(int levelNo)
	{
		// TODO - implement GameManager.loadLevel
		throw new UnsupportedOperationException();
	}

	public void registerHighScore()
	{
		// TODO - implement GameManager.registerHighScore
		throw new UnsupportedOperationException();
	}

	public string getHighScores()
	{
		return this.highScores;
	}

	public string getSettings()
	{
		// TODO - implement GameManager.getSettings
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param settings
	 */
	public void updateSettings(string settings)
	{
		// TODO - implement GameManager.updateSettings
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param scores
	 */
	public void updateHighScores(string scores)
	{
		// TODO - implement GameManager.updateHighScores
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param directions
	 */
	public void controlPlayer(int[] directions)
	{
		// TODO - implement GameManager.controlPlayer
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param directions1
	 * @param directions2
	 */
	public void controlPlayer(int[] directions1, int[] directions2)
	{
		// TODO - implement GameManager.controlPlayer
		throw new UnsupportedOperationException();
	}

	public int getGameState()
	{
		return this.gameState;
	}

	/**
	 * 
	 * @param status
	 */
	public void changeGameStatus(int status)
	{
		// TODO - implement GameManager.changeGameStatus
		throw new UnsupportedOperationException();
	}

}