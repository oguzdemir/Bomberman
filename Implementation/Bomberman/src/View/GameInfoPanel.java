package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by od on 29.4.2016.
 */
public class GameInfoPanel extends JPanel
{

    Font customFont,customFont2;
    JLabel livesLabel, limitLabel, magnitudeLabel,speedLimit;

    public GameInfoPanel(boolean t)
    {
        super();
        setLayout(new GridLayout(5,1));
        setSize(new Dimension(200,768));
        setPreferredSize(new Dimension(200,768));
        setMaximumSize(new Dimension(200,768));
        setBackground(new Color (231,234,187));

        try {
            //create the font to use. Specify the size!
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/Sources/fonts/Bombing.ttf")).deriveFont(30f);
            customFont2 = Font.createFont(Font.TRUETYPE_FONT, new File("src/Sources/fonts/Bombing.ttf")).deriveFont(180f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //register the font
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/Sources/fonts/Bombing.ttf")));
        } catch (IOException e) {
            customFont = new Font("Century", Font.PLAIN + Font.BOLD, 30);
            customFont2 = new Font("Century", Font.PLAIN + Font.BOLD, 200);
        } catch(FontFormatException e) {
            customFont = new Font("Century", Font.PLAIN + Font.BOLD, 30);
            customFont2 = new Font("Century", Font.PLAIN + Font.BOLD, 200);
        }

        if(t)
        {
            JButton mainMenu;

            mainMenu = new JButton("PauseX");
            mainMenu.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    MainFrame.getInstance().changeStatus(7);
                }
            });
            mainMenu.setFont(customFont);
            mainMenu.setSize(mainMenu.getPreferredSize());
            this.add(mainMenu);
            mainMenu.setLocation(0,250);
            mainMenu.setOpaque(false);
            mainMenu.setContentAreaFilled(false);
            mainMenu.setBorderPainted(false);
            mainMenu.setForeground(Color.BLUE);
        }




        livesLabel = new JLabel("");
        livesLabel.setFont(customFont);
        livesLabel.setForeground(Color.BLUE);
        livesLabel.setVisible(true);
        this.add(livesLabel);


        limitLabel = new JLabel("");
        limitLabel.setFont(customFont);
        limitLabel.setForeground(Color.BLUE);
        limitLabel.setVisible(true);
        this.add(limitLabel);

        speedLimit = new JLabel("");
        speedLimit.setFont(customFont);
        speedLimit.setForeground(Color.BLUE);
        speedLimit.setVisible(true);
        add(speedLimit);

        magnitudeLabel = new JLabel("");
        magnitudeLabel.setFont(customFont);
        magnitudeLabel.setForeground(Color.BLUE);
        magnitudeLabel.setVisible(true);
        add(magnitudeLabel);


        setVisible(true);

    }
    public void updateHUD(int lives,int speed, int limit, int magnitude)
    {
        speedLimit.setText("        Speed: " + speed);
        livesLabel.setText("        Lives: " + lives);
        limitLabel.setText("        Bombs: " + limit);
        magnitudeLabel.setText("    Magnitude: " + magnitude);
    }
}
