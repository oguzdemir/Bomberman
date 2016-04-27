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
    private BufferedImage img1,img2,img3,img4;
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
            img1 = ImageIO.read(new File("1.png"));
            img2 = ImageIO.read(new File("2.png"));
            img3 = ImageIO.read(new File("3.png"));
            img4 = ImageIO.read(new File("4.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }


        timer.start();



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
                System.out.println("prees");
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
                System.out.println("prees");
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
                    g2d.drawImage(img1,xCoordinate,yCoordinate,40,40,Color.gray,null);
                if( abc[i][j] == 2)
                    g2d.drawImage(img2,xCoordinate,yCoordinate,40,40,Color.gray,null);
                if( abc[i][j] == 3)
                    g2d.drawImage(img3,xCoordinate,yCoordinate,40,40,Color.gray,null);
                xCoordinate += 40;
            }
            g2d.drawImage(img4,bombers[0],bombers[1],40,40,Color.gray,null);
            g2d.drawImage(img4,bombers[2],bombers[3],40,40,Color.gray,null);
            g2d.drawImage(img4,bombers[4],bombers[5],40,40,Color.gray,null);
            g2d.drawImage(img4,bombers[6],bombers[7],40,40,Color.gray,null);
            yCoordinate += 40;
            xCoordinate = 0;
        }
    }


    private class TimerListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if(gManager == null)
                System.out.println("Manager NUll");
            gManager.controlPlayer(directions1);

            repaint();

           /* for(int i = 0; i< 3 ; i++)
                directions1[i] = 0;*/

        }
    }
}
