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

        //JButton b1 = new JButton("OPEN GAME");



        Container con = getContentPane();
        con.setLayout(new FlowLayout());

       // con.add(b1);

        GamePanel p1 = new GamePanel(manager,engine);
        p1.addKeyListener(p1);
        p1.setFocusable(true);
        con.add(p1);



        p1.setVisible(true);
/*
        b1. addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                p1.setVisible(true);

            }
        });*/
        setSize(1100,1100);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);


    }


}
