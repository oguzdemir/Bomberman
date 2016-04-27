import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * Created by od on 27.4.2016.
 */
public class GamePanel extends JPanel
{
    int[][] abc;
    int []bombers;
    private final static int GRID_SIZE = 13;
    private BufferedImage img1,img2,img3,img4;
    public GamePanel(int[][] given, int [] given2)
    {
        setBackground(new Color(255,255,255));
        setPreferredSize(new Dimension(1000,1000));
        setMaximumSize(getPreferredSize());

        abc = given;
        bombers = given2;
        Random generator = new Random();


        try {
            img1 = ImageIO.read(new File("1.png"));
            img2 = ImageIO.read(new File("2.png"));
            img3 = ImageIO.read(new File("3.png"));
            img4 = ImageIO.read(new File("4.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        repaint();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        int xCoordinate = 0;
        int yCoordinate = 0;
        for(int i = 0; i < GRID_SIZE ; i++)
        {
            for (int j = 0; j < GRID_SIZE; j++)
            {
                System.out.print(abc[i][j]);
            }
            System.out.println("");
        }
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

}
