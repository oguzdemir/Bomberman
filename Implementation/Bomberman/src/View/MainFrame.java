package View;

import Controller.GameManager;
import Model.GameEngine;

import javax.swing.*;
import java.awt.*;

/**
 * Created by od on 27.4.2016.
 */
public class MainFrame extends JFrame
{
    private static MainFrame instance = null;
    private GameManager gManager;
    private GameEngine gEngine;

    private MainMenuPanel mainMenuPanel;
    private JPanel gameContainer;
    private GamePanel gamePanel;
    private SettingsPanel settingsPanel;
    private HelpPanel helpPanel;
    private HighScoresPanel highScoresPanel;
    private CreditsPanel creditsPanel;
    private GameInfoPanel infop1,infop2;
    private GameInfoHeaderPanel hudPanel;

    private MainFrame(GameManager manager, GameEngine engine)
    {
        super("Bombalamasyon");
        instance = this;
        gManager = manager;
        gEngine = engine;

        //Frame initialized

        setSize(1024,768);
        setResizable(false);//Not changable
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        mainMenuPanel = new MainMenuPanel();
        settingsPanel = new SettingsPanel(gManager);
        helpPanel = new HelpPanel();
        highScoresPanel = new HighScoresPanel(gManager);
        creditsPanel = new CreditsPanel();


        gameContainer = new JPanel();
        gamePanel = new GamePanel(gManager);
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

    public void registerScore(String name)
    {
        gManager.registerScore(name);
    }
    public void startGame()
    {
        gamePanel.startGame();
    }


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
                getContentPane().add(settingsPanel);
                break;
            case 4:
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
    public void changeStatus(int status)
    {
        gManager.changeGameStatus(status,0);
    }
    public static MainFrame getInstance()
    {
        return instance;
    }
    public static MainFrame getInstance(GameManager manager, GameEngine engine)
    {
        instance = new MainFrame(manager,engine);
        return instance;
    }

}
