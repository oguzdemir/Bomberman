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
        super("MainFrame");
        gManager = manager;
        gEngine = engine;

        JButton b1 = new JButton("OPEN GAME");
        int [] x = new int[8];
        GamePanel p1 = new GamePanel(engine.serveGameMap(x),x);

        Container con = getContentPane();
        con.setLayout(new FlowLayout());
        this.setSize(500,400);

        con.add(b1);
        con.add(p1);



        p1.setVisible(false);

        b1. addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                p1.setVisible(true);

            }
        });
        setSize(500,500);
        add(b1);
        add(p1);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);


    }


}
