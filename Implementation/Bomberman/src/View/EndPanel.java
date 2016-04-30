package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by od on 30.4.2016.
 */
public class EndPanel extends JPanel
{
    Font customFont;

    public EndPanel(int situation)
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

        switch(situation)
        {
            case 1:
                endGame = new JLabel("You are died :( ");
                break;
            case 2:
                endGame = new JLabel("You are the last man standing!");
                break;
            case 3:
                endGame = new JLabel("Players are died:( ");
                break;
            case 4:
                endGame = new JLabel("Player1 is the last man standing! ");
                break;
            case 5:
                endGame = new JLabel("Player2 is the last man standing!");
                break;
            default:
                endGame = new JLabel("Level is ended");
                break;

        }

        endGame.setFont(customFont);
        endGame.setSize(endGame.getPreferredSize());
        this.add(endGame);
        endGame.setLocation(0,0);
        endGame.setOpaque(false);
        endGame.setForeground(Color.WHITE);


        JButton mainMenu;

        mainMenu = new JButton("Load Next Level...");
        mainMenu.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MainFrame.getInstance().changeStatus(1);
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
