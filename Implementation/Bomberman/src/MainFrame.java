import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * Created by od on 27.4.2016.
 */
public class MainFrame extends JFrame
{
    private GameManager gManager;
    private GameEngine gEngine;

    public MainFrame(GameManager manager, GameEngine engine)
    {
        gManager = manager;
        gEngine = engine;

        JButton b1 = new JButton("OPEN GAME");
        GamePanel p1 = new GamePanel();
        p1.setVisible(false);

        b1. addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                p1.setVisible(true);

            }
        });

        this.add(b1);
        this.add(p1);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationByPlatform(true);
        this.setVisible(true);


    }


}
