package View;

import Controller.GameManager;
import Model.GameEngine;

import javax.swing.*;
import java.awt.*;

/**
 * Main frame of the game.
 *
 * Created by Oğuz Demir on 27.4.2016.
 */
public class MainFrame extends JFrame
{
    private static MainFrame instance = null;
    private GameManager gManager;

    private MainMenuPanel mainMenuPanel;
    private JPanel gameContainer;
    private GamePanel gamePanel;
    private SettingsPanel settingsPanel;
    private HelpPanel helpPanel;
    private HighScoresPanel highScoresPanel;
    private CreditsPanel creditsPanel;
    private GameInfoPanel infop1,infop2;
    private GameInfoHeaderPanel hudPanel;

    /**
     * Constructor for the main frame.
     * @param manager GameManager of the game.
     */
    private MainFrame(GameManager manager)
    {
        super("Bombalamasyon");
        instance = this;
        gManager = manager;

        //Frame initialized

        setSize(1024,768);
        setResizable(false);//Not changable
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        mainMenuPanel = new MainMenuPanel();
        settingsPanel = new SettingsPanel(gManager.getSettings());
        helpPanel = new HelpPanel();
        highScoresPanel = new HighScoresPanel(gManager.getHighScores());
        creditsPanel = new CreditsPanel();


        gameContainer = new JPanel();
        gamePanel = new GamePanel();
        infop1 = new GameInfoPanel(true);
        infop2 = new GameInfoPanel(false);
        hudPanel = new GameInfoHeaderPanel();


        gameContainer.setLayout(new BorderLayout());
        gameContainer.add(hudPanel,BorderLayout.PAGE_START);
        gameContainer.add(infop1,BorderLayout.LINE_START);
        gameContainer.add(gamePanel,BorderLayout.CENTER);
        gameContainer.add(infop2,BorderLayout.LINE_END);

        add(mainMenuPanel);



        gamePanel.setVisible(true);
        pack();//Size

    }

    /**
     * Updates the screen of the game.
     * @param map map to draw.
     * @param bomberMap bombers to draw.
     * @param info information to draw.
     * @param currentLevel current level information.
     * @param remainingTime remaining time information.
     * @param currentScore1 current score for player1.
     * @param currentScore2 current score for player2.
     * @param b two or one player game.
     */
    public void updateGameView(int[][] map, int[]bomberMap, int[]info,int currentLevel, int remainingTime, int currentScore1, int currentScore2, boolean b )
    {
        gamePanel.update(map,bomberMap);
        infop1.updateHUD(info[0],info[1],info[2],info[3] );
        if(b)
        {
            infop2.updateHUD(info[4],info[5],info[6],info[7] );
            hudPanel.updateHUD(remainingTime,currentScore1,currentScore2,currentLevel);
        }
        else
        hudPanel.updateHUD(remainingTime,currentScore1,currentLevel);
    }

    /**
     * Register the new high score.
     * @param name name of the player.
     */
    public void registerScore(String name)
    {
        gManager.registerScore(name);
    }

    /**
     * Starts the game.
     */
    public void startGame()
    {

        gamePanel.startGame();
    }

    /**
     * Update the view for current status.
     * @param status state of the game.
     * @param result win or lose.
     */
    public void updateStatusView(int status,int result)
    {
        getContentPane().removeAll();
        switch (status) {
            case 0:
                getContentPane().add(mainMenuPanel);
                gamePanel.stopGame();
                break;
            case 1:
                getContentPane().add(gameContainer);
                gamePanel.setFocusable(true);
                gamePanel.requestFocus(true);
                break;
            case 2:
                getContentPane().add(gameContainer);
                gamePanel.setFocusable(true);
                gamePanel.requestFocus(true);
                break;
            case 3:
                settingsPanel = new SettingsPanel(gManager.getSettings());
                getContentPane().add(settingsPanel);
                break;
            case 4:
                highScoresPanel = new HighScoresPanel(gManager.getHighScores());
                getContentPane().add(highScoresPanel);
                break;
            case 5:
                getContentPane().add(helpPanel);

                break;
            case 6:
                getContentPane().add(creditsPanel);
                break;
            case 7:
                getContentPane().add(gameContainer);
                gamePanel.setFocusable(true);
                gamePanel.requestFocus(true);
                gamePanel.showPause();
                break;
            case 8:
                getContentPane().add(gameContainer);
                gamePanel.setFocusable(true);
                gamePanel.requestFocus(true);
                gamePanel.endLevel(result);
                break;
            case 9:
                getContentPane().add(gameContainer);
                gamePanel.setFocusable(true);
                gamePanel.requestFocus(true);
                gamePanel.gameOver(result);
                break;
            default:
                break;
        }
        getContentPane().revalidate();
        getContentPane().repaint();
    }

    /**
     * Change the status of the game.
     * @param status desired state.
     */
    public void changeStatus(int status)
    {
        gManager.changeGameStatus(status,0);
    }

    /**
     * Save the changed settings.
     * @param s string representation of the settings.
     */
    public void saveSettings(String s)
    {
        gManager.updateSettings(s);
    }

    /**
     * Control the first player.
     * @param d1 x coordinates.
     * @param d2 y coordinates.
     */
    public void controlPlayer(int []d1, int[]d2)
    {
        gManager.controlPlayer(d1,d2);
    }

    /**
     * Get the instance of the frame.
     * @return current frame.
     */
    public static MainFrame getInstance()
    {
        return instance;
    }

    /**
     * Create new frame with given manager.
     * @param manager desired manager for the game.
     * @return the created frame.
     */
    public static MainFrame getInstance(GameManager manager)
    {
        instance = new MainFrame(manager);
        return instance;
    }

}
