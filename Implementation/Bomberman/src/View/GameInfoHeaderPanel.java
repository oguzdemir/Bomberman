package View;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Information labels for the gamepanel.
 *
 * Created by Oğuz Demir on 29.4.2016.
 */


public class GameInfoHeaderPanel extends JPanel
{
    Font customFont,customFont2;
    JLabel timeLabel,scoreLabel,levelLabel;

    /**
     * Default constructor for the information panel.
     */
    public GameInfoHeaderPanel()
    {
        super();
        setLayout(new GridLayout(1,4));
        setSize(new Dimension(1024,100));
        setPreferredSize(new Dimension(1024,100));
        setMaximumSize(new Dimension(1024,100));
        setBackground(new Color (231,234,187));

        try {
            //create the font to use. Specify the size!
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/Sources/fonts/Bombing.ttf")).deriveFont(40f);
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

        JLabel marginLabel = new JLabel("");
        add(marginLabel);


        timeLabel = new JLabel("Time: XX:XX");
        timeLabel.setFont(customFont);
        timeLabel.setForeground(Color.BLUE);
        timeLabel.setVisible(true);
        add(timeLabel);


        scoreLabel = new JLabel("Score: XXXX");
        scoreLabel.setFont(customFont);
        scoreLabel.setForeground(Color.BLUE);
        scoreLabel.setVisible(true);
        add(scoreLabel);

        levelLabel = new JLabel("Level: X");
        levelLabel.setFont(customFont);
        levelLabel.setForeground(Color.BLUE);
        levelLabel.setVisible(true);
        add(levelLabel);


        setVisible(true);
    }

    /**
     * Updates the screen with different actions.
     *
     * @param time remaining time.
     * @param score current score.
     * @param level current level.
     */
    public void updateHUD(int time, int score, int level)
    {
        timeLabel.setText("Time: " + (time/60)/60 + ":" + (time/60)%60 );
        scoreLabel.setText("Score: " + score);
        levelLabel.setText("Level: " + level);
    }

    /**
     * Screen update for multiplayer.
     *
     * @param time remaining time.
     * @param score1 player1 score.
     * @param score2 player2 score.
     * @param level current level.
     */
    public void updateHUD(int time, int score1,int score2, int level)
    {
        timeLabel.setText("Time: " + (time/60)/60 + ":" + (time/60)%60 );
        scoreLabel.setText(score1 + " vs " + score2 );
        levelLabel.setText("Level: " + level);
    }
}
