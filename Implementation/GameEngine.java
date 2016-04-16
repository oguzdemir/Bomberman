public class GameEngine
{

	private OverlapEngine oEngine;
	private Bomberman[] bombers;
	private Bomb[] bombs;
	private Wall[] walls;
	private PowerUp[] powerUps;

	/**
	 * 
	 * @param map
	 */
	public GameEngine(int[][] map)
	{
		// TODO - implement GameEngine.GameEngine
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param x1
	 * @param y1
	 * @param b1
	 * @param timeAmount
	 */
	public boolean elapseTime(int x1, int y1, boolean b1, int timeAmount)
	{
		// TODO - implement GameEngine.elapseTime
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param timeAmount
	 * @param b1
	 * @param b2
	 */
	public boolean elapseTime(int x1, int y1, int x2, int y2, int timeAmount, boolean b1, boolean b2)
	{
		// TODO - implement GameEngine.elapseTime
		throw new UnsupportedOperationException();
	}

	public int[][] serveGameMap()
	{
		// TODO - implement GameEngine.serveGameMap
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param type
	 * @param x
	 * @param y
	 */
	public void addGameObject(int type, int x, int y)
	{
		// TODO - implement GameEngine.addGameObject
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param object
	 */
	public void deleteGameObject(GameObject object)
	{
		// TODO - implement GameEngine.deleteGameObject
		throw new UnsupportedOperationException();
	}

}