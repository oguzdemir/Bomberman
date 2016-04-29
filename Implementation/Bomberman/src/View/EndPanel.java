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

    public EndPanel()
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

        endGame = new JLabel("Game is ended");

        endGame.setFont(customFont);
        endGame.setSize(endGame.getPreferredSize());
        this.add(endGame);
        endGame.setLocation(0,0);
        endGame.setOpaque(false);
        endGame.setForeground(Color.WHITE);


        JButton mainMenu;

        mainMenu = new JButton("Exit To Main Menu  ");
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

    public EndPanel(boolean b)
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

        if(b)
            endGame = new JLabel("Level is ended, you are last man standing!");
       else
            endGame = new JLabel("Level is ended, you are died:(");
        endGame.setFont(customFont);
        endGame.setSize(endGame.getPreferredSize());
        endGame.setForeground(Color.white);
        this.add(endGame);
        endGame.setLocation(0,0);
        endGame.setOpaque(false);



        JButton mainMenu;

        mainMenu = new JButton("Load next level ");
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
