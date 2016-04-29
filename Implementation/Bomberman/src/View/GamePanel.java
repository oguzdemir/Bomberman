package View;

import Controller.GameManager;
import Model.GameEngine;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * Created by od on 27.4.2016.
 */
public class GamePanel extends JPanel
{
    Timer timer;

    int delay = 20;
    int [] directions1;
    int [] directions2 = new int[3];
    private GameManager gManager;
    private GameEngine gEngine;

    int[][] gameMap;
    int[] bomberMap;

    private final static int GRID_SIZE = 13;
    private BufferedImage c1,c2,c3,c4;
    private BufferedImage c1s,c2s,c3s,c4s;
    private BufferedImage b1,b2,b3,b4;
    private BufferedImage w1,w2,w3;
    private BufferedImage p1,p2,p3,p4;


    public GamePanel(GameManager manager, GameEngine engine)
    {
        gManager = manager;
        gEngine = engine;
        setBackground(new Color(255,255,255));
        setPreferredSize(new Dimension(400,400));
        //setLocation(100,100);
        setLayout(null);
        setMaximumSize(getPreferredSize());

        addKeyListener(new KeyboardListener());

        setFocusable(true);
        requestFocusInWindow(true);



        directions1 = new int[3];
        directions1[0] = 0;
        directions1[1] = 0;
        directions1[2] = 0;
        Random generator = new Random();

        timer = new Timer(delay, new TimerListener());

        try {
            c1 = ImageIO.read(new File("src/Sources/img/c1.png"));
            c2 = ImageIO.read(new File("src/Sources/img/c2.png"));
            c3 = ImageIO.read(new File("src/Sources/img/c3.png"));
            c4 = ImageIO.read(new File("src/Sources/img/c4.png"));
            c1s = ImageIO.read(new File("src/Sources/img/c1-shield.png"));
            c2s = ImageIO.read(new File("src/Sources/img/c2-shield.png"));
            c3s = ImageIO.read(new File("src/Sources/img/c3-shield.png"));
            c4s = ImageIO.read(new File("src/Sources/img/c4-shield.png"));
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


    }
    public void endGame()
    {
        pauseGame();
        removeAll();
        validate();



        JPanel x = new EndPanel();
        add(x);
        x.setLocation(0,200);

        repaint();
    }
    public void endLevel(boolean b)
    {
        pauseGame();
        removeAll();
        validate();



        JPanel x = new EndPanel(b);
        add(x);
        x.setLocation(0,200);

        repaint();
    }

    public void showPause()
    {
        pauseGame();
        removeAll();
        validate();



        JPanel x = new PausePanel();
        add(x);
        x.setLocation(0,200);

        repaint();
    }
    public void pauseGame()
    {
        timer.stop();
    }
    public void startGame()
    {
        removeAll();
        validate();
        repaint();

        timer.start();
    }



    public void update(int[][] map, int[]data)
    {
        gameMap = map;
        bomberMap = data;
        repaint();
    }
    private class KeyboardListener implements KeyListener
    {
        @Override
        public void keyTyped(KeyEvent e)
        {
            return;
        }

        @Override
        public void keyPressed(KeyEvent e)
        {
            int keyCode = e.getKeyCode();
            switch (keyCode)
            {
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
                case KeyEvent.VK_RIGHT:
                    directions1[0] = 1;
                    // handle right
                    break;
                case KeyEvent.VK_SPACE:
                    directions1[2] = 1;
                    // handle right
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e)
        {
            int keyCode = e.getKeyCode();
            switch (keyCode)
            {
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
                case KeyEvent.VK_RIGHT:
                    directions1[0] = 0;
                    // handle right
                    break;

            }
        }
    }


    public void paintComponent(Graphics g)
    {

        super.paintComponent(g);
        if(gameMap == null)
            return;
        Graphics2D g2d = (Graphics2D) g.create();

        int xCoordinate = 0;
        int yCoordinate = 0;


        for(int i = 0; i < GRID_SIZE ; i++)
        {
            for(int j = 0 ; j < GRID_SIZE ; j++)
            {
                if( gameMap[i][j] == 1)
                    g2d.drawImage(w1,xCoordinate,yCoordinate,40,40,Color.gray,null);
                if( gameMap[i][j] == 2)
                    g2d.drawImage(w2,xCoordinate,yCoordinate,40,40,Color.gray,null);
                if( gameMap[i][j] == 3)
                    g2d.drawImage(w3,xCoordinate,yCoordinate,40,40,Color.gray,null);
                if( gameMap[i][j] == 4)
                    g2d.drawImage(b1,xCoordinate,yCoordinate,40,40,Color.gray,null);
                if( gameMap[i][j] == 5)
                    g2d.drawImage(b2,xCoordinate,yCoordinate,40,40,Color.gray,null);
                if( gameMap[i][j] == 6)
                    g2d.drawImage(b3,xCoordinate,yCoordinate,40,40,Color.gray,null);
                if( gameMap[i][j] == 7)
                    g2d.drawImage(b4,xCoordinate,yCoordinate,40,40,Color.gray,null);
                if( gameMap[i][j] == 8)
                    g2d.drawImage(p1,xCoordinate,yCoordinate,40,40,Color.gray,null);
                if( gameMap[i][j] == 9)
                    g2d.drawImage(p2,xCoordinate,yCoordinate,40,40,Color.gray,null);
                if( gameMap[i][j] == 10)
                    g2d.drawImage(p3,xCoordinate,yCoordinate,40,40,Color.gray,null);
                if( gameMap[i][j] == 11)
                    g2d.drawImage(p4,xCoordinate,yCoordinate,40,40,Color.gray,null);
                yCoordinate += 40;
            }




            xCoordinate += 40;
            yCoordinate = 0;
        }

        if(bomberMap[0] != 0 && bomberMap[1] != 0)
            if(bomberMap[2]>0)
                g2d.drawImage(c1s,bomberMap[0],bomberMap[1],40,40,Color.white,null);
            else
                g2d.drawImage(c1,bomberMap[0],bomberMap[1],40,40,Color.white,null);

        if(bomberMap[3] != 0 && bomberMap[4] != 0)
            if(bomberMap[5]>0)
                g2d.drawImage(c2s,bomberMap[3],bomberMap[4],40,40,Color.white,null);
            else
                g2d.drawImage(c2,bomberMap[3],bomberMap[4],40,40,Color.white,null);

        if(bomberMap[6] != 0 && bomberMap[7] != 0)
            if(bomberMap[8]>0)
                g2d.drawImage(c3s,bomberMap[6],bomberMap[7],40,40,Color.white,null);
            else
                g2d.drawImage(c3,bomberMap[6],bomberMap[7],40,40,Color.white,null);

        if(bomberMap[9] != 0 && bomberMap[10] != 0)
            if(bomberMap[11]>0)
                g2d.drawImage(c4s,bomberMap[9],bomberMap[10],40,40,Color.white,null);
            else
                g2d.drawImage(c1,bomberMap[9],bomberMap[10],40,40,Color.white,null);


        /*
        if(paused)
        {
            System.out.println("AAAAA");
            int alpha = 127; // 50% transparent
            Color myColour = new Color(0, 0, 0, alpha);
            g2d.setPaint(myColour);
            g2d.fill(new Rectangle2D.Double(0, 0, 800, 800));

            g2d.setPaint(Color.white);
            g2d.drawString("GAME IS PAUSED",100,100);

            timer.stop();
        }*/
    }


    private class TimerListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if(gManager == null)
                System.out.println("Manager NUll");
            gManager.controlPlayer(directions1);

            directions1[2] = 0;

           /* for(int i = 0; i< 3 ; i++)
                directions1[i] = 0;*/

        }
    }
}
