package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Main menu screen.
 *
 * Created by Oğuz Demir on 28.4.2016.
 */
public class MainMenuPanel extends JPanel
{
    private Font customFont;

    /**
     * Default constructor for the main menu.
     */
    public MainMenuPanel()
    {
        super();
        setLayout(null);

        setPreferredSize(new Dimension(1024,768));

        try {
            //create the font to use. Specify the size!
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/Sources/fonts/Bombing.ttf")).deriveFont(50f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //register the font
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/Sources/fonts/Bombing.ttf")));
        } catch (IOException e) {
            customFont = new Font("Century", Font.PLAIN + Font.BOLD, 20);
        } catch(FontFormatException e) {
            customFont = new Font("Century", Font.PLAIN + Font.BOLD, 20);
        }


        JButton b1;
        MenuListener m = new MenuListener();
        //Single Player button
        b1 = new JButton("SinglePlayer");
        b1.setFont(customFont);
        b1.setSize(b1.getPreferredSize());
        this.add(b1);
        b1.setLocation(630,280);
        b1.setOpaque(false);
        b1.setContentAreaFilled(false);
        b1.setBorderPainted(false);
        b1.setForeground(Color.BLUE);
        b1.addActionListener(m);

        //Multi Player button
        b1 = new JButton("MultiPlayer");
        b1.setFont(customFont);
        b1.setSize(b1.getPreferredSize());
        this.add(b1);
        b1.setLocation(630,350);
        b1.setOpaque(false);
        b1.setContentAreaFilled(false);
        b1.setBorderPainted(false);
        b1.setForeground(Color.BLUE);
        b1.addActionListener(m);

        //Settings button
        b1 = new JButton("Set tings");
        b1.setFont(customFont);
        b1.setSize(b1.getPreferredSize());
        this.add(b1);
        b1.setLocation(630,420);
        b1.setOpaque(false);
        b1.setContentAreaFilled(false);
        b1.setBorderPainted(false);
        b1.setForeground(Color.BLUE);
        b1.addActionListener(m);

        //HighScores button
        b1 = new JButton("High Scores");
        b1.setFont(customFont);
        b1.setSize(b1.getPreferredSize());
        this.add(b1);
        b1.setLocation(630,490);
        b1.setOpaque(false);
        b1.setContentAreaFilled(false);
        b1.setBorderPainted(false);
        b1.setForeground(Color.BLUE);
        b1.addActionListener(m);


        //Help button
        b1 = new JButton("Help");
        b1.setFont(customFont);
        b1.setSize(b1.getPreferredSize());
        this.add(b1);
        b1.setLocation(630,560);
        b1.setOpaque(false);
        b1.setContentAreaFilled(false);
        b1.setBorderPainted(false);
        b1.setForeground(Color.BLUE);
        b1.addActionListener(m);

        //Credits button
        b1 = new JButton("Credits");
        b1.setFont(customFont);
        b1.setSize(b1.getPreferredSize());
        this.add(b1);
        b1.setLocation(630,630);
        b1.setOpaque(false);
        b1.setContentAreaFilled(false);
        b1.setBorderPainted(false);
        b1.setForeground(Color.BLUE);
        b1.addActionListener(m);

        setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        try {
            BufferedImage b1 = ImageIO.read(new File("src/Sources/img/background.png"));
            g.drawImage(b1, 0,0,1024,768,this);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Listener for the menu items.
     */
    private class MenuListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            Object obj = event.getSource();
            String str = ((JButton)obj).getText();
            switch (str) {
                case "SinglePlayer":
                    MainFrame.getInstance().changeStatus(1);
                    break;
                case "MultiPlayer":
                    MainFrame.getInstance().changeStatus(2);
                    break;
                case "Set tings":
                    MainFrame.getInstance().changeStatus(3);
                    break;
                case "High Scores":
                    MainFrame.getInstance().changeStatus(4);
                    break;
                case "Help":
                    MainFrame.getInstance().changeStatus(5);
                    break;
                case "Credits":
                    MainFrame.getInstance().changeStatus(6);
                    break;
                default:
                    MainFrame.getInstance().changeStatus(0);
                    break;
            }
        }
    }
}
