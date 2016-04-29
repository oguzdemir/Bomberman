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
    private GamePanel gamePanel;
    private SettingsPanel settingsPanel;
    private HelpPanel helpPanel;
    private HighScoresPanel highScoresPanel;
    private CreditsPanel creditsPanel;


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
        gamePanel = new GamePanel(gManager,gEngine);
        settingsPanel = new SettingsPanel();
        helpPanel = new HelpPanel();
        highScoresPanel = new HighScoresPanel(gManager);
        creditsPanel = new CreditsPanel();


        add(mainMenuPanel);



        gamePanel.setVisible(true);
        pack();//Size

    }
    public void updateStatusView(int status)
    {
        getContentPane().removeAll();g
        switch (status) {
            case 0:
                getContentPane().add(mainMenuPanel);
                break;
            case 1:
                getContentPane().add(gamePanel);
                break;
            case 2:
                getContentPane().add(gamePanel);
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
            default:
                break;
        }
        getContentPane().revalidate();
        getContentPane().repaint();
    }
    public void changeStatus(int status)
    {
        gManager.changeGameStatus(status);
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
