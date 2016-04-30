package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Class for the game is over.
 *
 * Created by Oğuz Demir on 30.4.2016.
 */
public class GameOverPanel extends JPanel
{
    Font customFont;
    JTextField enterName;

    /**
     * Constructor for the game over panel.
     * @param result win or lose.
     */
    public GameOverPanel(int result)
    {
        super();
        setLayout(new GridLayout(3,1));
        setSize(new Dimension(700,250));
        setPreferredSize(new Dimension(500,250));
        setMaximumSize(new Dimension(500,250));
        setBackground( new Color(0, 0, 0) );

        try {
            //create the font to use. Specify the size!
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/Sources/fonts/Bombing.ttf")).deriveFont(30f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //register the font
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/Sources/fonts/Bombing.ttf")));
        } catch (IOException e) {
            customFont = new Font("Century", Font.PLAIN + Font.BOLD, 30);
        } catch(FontFormatException e) {
            customFont = new Font("Century", Font.PLAIN + Font.BOLD, 30);
        }

        JLabel endGame;

        switch(result)
        {
            case 7: endGame = new JLabel("GAME OVER! Player 1 an high score! Enter your name to go on list! ");
                break;
            case 8: endGame = new JLabel("GAME OVER! Player 2 an high score! Enter your name to go on list! ");
                break;
            default:
                endGame = new JLabel("GAME OVER, You are not highscored");
                break;
        }


        endGame.setFont(customFont);
        endGame.setSize(endGame.getPreferredSize());
        endGame.setForeground(Color.white);
        this.add(endGame);
        endGame.setLocation(0,0);
        endGame.setOpaque(false);


        if(result==7 || result==8)
        {
            enterName = new JTextField("Enter Name");
            add(enterName);
        }


        JButton mainMenu;

        if(result==7 || result==8)
        {
            mainMenu = new JButton("Save me and go on main menu!");
            mainMenu.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    String a = enterName.getText();
                    MainFrame.getInstance().registerScore(a);
                    MainFrame.getInstance().changeStatus(-1);
                }
            });
        }
        else
        {
            mainMenu = new JButton("Go to Main Menu");
            mainMenu.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    MainFrame.getInstance().changeStatus(-1);
                }
            });
        }


        mainMenu.setFont(customFont);
        mainMenu.setSize(mainMenu.getPreferredSize());
        this.add(mainMenu);
        mainMenu.setLocation(250,0);
        mainMenu.setOpaque(false);
        mainMenu.setContentAreaFilled(false);
        mainMenu.setBorderPainted(false);
        mainMenu.setForeground(Color.RED);


    }
}
