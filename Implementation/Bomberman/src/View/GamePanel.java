package View;

import Controller.GameManager;
import Model.GameEngine;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * Created by od on 27.4.2016.
 */
public class GamePanel extends JPanel implements KeyListener
{
    Timer timer;

    int delay = 1;
    int [] directions1;
    int [] directions2 = new int[3];
    private GameManager gManager;
    private GameEngine gEngine;

    private final static int GRID_SIZE = 13;
    private BufferedImage c1;
    private BufferedImage b1,b2,b3,b4;
    private BufferedImage w1,w2,w3;
    private BufferedImage p1,p2,p3,p4;
    public GamePanel(GameManager manager, GameEngine engine)
    {
        gManager = manager;
        gEngine = engine;
        setBackground(new Color(255,255,255));
        setPreferredSize(new Dimension(1000,1000));
        setMaximumSize(getPreferredSize());


        directions1 = new int[3];
        directions1[0] = 0;
        directions1[1] = 0;
        directions1[2] = 0;
        Random generator = new Random();

        timer = new Timer(delay, new TimerListener());

        try {
            c1 = ImageIO.read(new File("src/Sources/img/c1.png"));
            b1 = ImageIO.read(new File("src/Sources/img/b1.png"));
            b2 = ImageIO.read(new File("src/Sources/img/b2.png"));
            b3 = ImageIO.read(new File("src/Sources/img/b3.png"));
            b4 = ImageIO.read(new File("src/Sources/img/b4.png"));
            w1 = ImageIO.read(new File("src/Sources/img/w1.png"));
            w2 = ImageIO.read(new File("src/Sources/img/w2.png"));
            w3 = ImageIO.read(new File("src/Sources/img/w3.png"));
            p1 = ImageIO.read(new File("src/Sources/img/p1.png"));
            p2 = ImageIO.read(new File("src/Sources/img/p2.png"));
            p3 = ImageIO.read(new File("src/Sources/img/p3.png"));
            p4 = ImageIO.read(new File("src/Sources/img/p4.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }




        repaint();
    }

    public void keyTyped(KeyEvent e)
    {
        return;
    }
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch( keyCode ) {
            case KeyEvent.VK_UP:
                directions1[1] = -1;
                break;
            case KeyEvent.VK_DOWN:
                directions1[1] = 1;
                // handle down
                break;
            case KeyEvent.VK_LEFT:
                directions1[0] = -1;
                // handle left
                break;
            case KeyEvent.VK_RIGHT :
                directions1[0] = 1;
                // handle right
                break;
            case KeyEvent.VK_SPACE :
                directions1[2] = 1;
                // handle right
                break;
        }
    }
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch( keyCode ) {
            case KeyEvent.VK_UP:
                directions1[1] = 0;
                break;
            case KeyEvent.VK_DOWN:
                directions1[1] = 0;
                // handle down
                break;
            case KeyEvent.VK_LEFT:
                directions1[0] = 0;
                // handle left
                break;
            case KeyEvent.VK_RIGHT :
                directions1[0] = 0;
                // handle right
                break;

        }
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        int xCoordinate = 0;
        int yCoordinate = 0;

        int [] bombers = new int[8];
        int[][] abc = gEngine.serveGameMap(bombers);



        for(int i = 0; i < GRID_SIZE ; i++)
        {
            for(int j = 0 ; j < GRID_SIZE ; j++)
            {
                if( abc[i][j] == 1)
                    g2d.drawImage(w1,xCoordinate,yCoordinate,40,40,Color.gray,null);
                if( abc[i][j] == 2)
                    g2d.drawImage(w2,xCoordinate,yCoordinate,40,40,Color.gray,null);
                if( abc[i][j] == 3)
                    g2d.drawImage(w3,xCoordinate,yCoordinate,40,40,Color.gray,null);
                if( abc[i][j] == 4)
                    g2d.drawImage(b1,xCoordinate,yCoordinate,40,40,Color.gray,null);
                if( abc[i][j] == 5)
                    g2d.drawImage(b2,xCoordinate,yCoordinate,40,40,Color.gray,null);
                if( abc[i][j] == 6)
                    g2d.drawImage(b3,xCoordinate,yCoordinate,40,40,Color.gray,null);
                if( abc[i][j] == 7)
                    g2d.drawImage(b4,xCoordinate,yCoordinate,40,40,Color.gray,null);
                if( abc[i][j] == 8)
                    g2d.drawImage(p1,xCoordinate,yCoordinate,40,40,Color.gray,null);
                if( abc[i][j] == 9)
                    g2d.drawImage(p2,xCoordinate,yCoordinate,40,40,Color.gray,null);
                if( abc[i][j] == 10)
                    g2d.drawImage(p3,xCoordinate,yCoordinate,40,40,Color.gray,null);
                if( abc[i][j] == 11)
                    g2d.drawImage(p4,xCoordinate,yCoordinate,40,40,Color.gray,null);
                yCoordinate += 40;
            }
            g2d.drawImage(c1,bombers[0],bombers[1],40,40,Color.gray,null);
            g2d.drawImage(c1,bombers[2],bombers[3],40,40,Color.gray,null);
            g2d.drawImage(c1,bombers[4],bombers[5],40,40,Color.gray,null);
            g2d.drawImage(c1,bombers[6],bombers[7],40,40,Color.gray,null);
            xCoordinate += 40;
            yCoordinate = 0;
        }
    }


    private class TimerListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if(gManager == null)
                System.out.println("Manager NUll");
            gManager.controlPlayer(directions1);

            directions1[2] = 0;
            repaint();

           /* for(int i = 0; i< 3 ; i++)
                directions1[i] = 0;*/

        }
    }
}
