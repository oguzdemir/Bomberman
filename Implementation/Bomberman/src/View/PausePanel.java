package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Pause screen for the game.
 *
 * Created by Oğuz Demir on 30.4.2016.
 */
public class PausePanel extends JPanel
{
    Font customFont;

    /**
     * Default pause screen.
     */
    public PausePanel()
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

        JButton continueGame;

        continueGame = new JButton("Continue Game");
        continueGame.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MainFrame.getInstance().changeStatus(1);
            }
        });
        continueGame.setFont(customFont);
        continueGame.setSize(continueGame.getPreferredSize());
        this.add(continueGame);
        continueGame.setLocation(0,0);
        continueGame.setOpaque(false);
        continueGame.setContentAreaFilled(false);
        continueGame.setBorderPainted(false);
        continueGame.setForeground(Color.WHITE);


        JButton helpButton;

        helpButton = new JButton("Help");
        helpButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MainFrame.getInstance().changeStatus(5);
            }
        });
        helpButton.setFont(customFont);
        helpButton.setSize(helpButton.getPreferredSize());
        this.add(helpButton);
        helpButton.setLocation(150,0);
        helpButton.setOpaque(false);
        helpButton.setContentAreaFilled(false);
        helpButton.setBorderPainted(false);
        helpButton.setForeground(Color.WHITE);

        JButton mainMenu;

        mainMenu = new JButton("Exit To Main Menu  ");
        mainMenu.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MainFrame.getInstance().changeStatus(0);
            }
        });
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
