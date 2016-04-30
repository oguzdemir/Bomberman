package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by od on 28.4.2016.
 */
public class HelpPanel extends InfoPanel
{
    private BufferedImage p1,p2,p3,p4,cont1, cont2;

    public HelpPanel()
    {

        super("Help");


        try {
            p1 = ImageIO.read(new File("src/Sources/img/p1.png"));
            p2 = ImageIO.read(new File("src/Sources/img/p2.png"));
            p3 = ImageIO.read(new File("src/Sources/img/p3.png"));
            p4 = ImageIO.read(new File("src/Sources/img/p4.png"));
            cont1 = ImageIO.read(new File("src/Sources/img/cont1.png"));
            cont2 = ImageIO.read(new File("src/Sources/img/cont2.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        JTextArea aim = new JTextArea("Blow up your opponents before they kill you!" +
                "You can play against three opponent and have two player or single player game." +
                "You have 2 minutes to do this.");

        aim.setSize(new Dimension (800, 800));

        aim.setFont(customFont);
        aim.setLineWrap(true);
        aim.setEditable(false);
        aim.setVisible(true);

        aim.setForeground(Color.BLUE);
        aim.setOpaque(false);

        this.add(aim);
        aim.setLocation(50,300);

        JTextArea shield = new JTextArea("Shield power up will protect you from one bomb explosion");

        shield.setSize(new Dimension (800, 800));

        shield.setFont(customFont);
        shield.setLineWrap(true);
        shield.setEditable(false);
        shield.setVisible(true);

        shield.setForeground(Color.BLUE);
        shield.setOpaque(false);

        this.add(shield);
        shield.setLocation(120,500);

        JTextArea speedUp = new JTextArea("Speed up power up will increase your bomberman speed.");

        speedUp.setSize(new Dimension (800, 800));

        speedUp.setFont(customFont);
        speedUp.setLineWrap(true);
        speedUp.setEditable(false);
        speedUp.setVisible(true);

        speedUp.setForeground(Color.BLUE);
        speedUp.setOpaque(false);

        this.add(speedUp);
        speedUp.setLocation(120,550);

        JTextArea countUp = new JTextArea("This power up will increase your bomb count.");

        countUp.setSize(new Dimension (800, 800));

        countUp.setFont(customFont);
        countUp.setLineWrap(true);
        countUp.setEditable(false);
        countUp.setVisible(true);

        countUp.setForeground(Color.BLUE);
        countUp.setOpaque(false);

        this.add(countUp);
        countUp.setLocation(120,600);

        JTextArea magnitudeUp = new JTextArea("Magnitude up power up increase your explosion area.");

        magnitudeUp.setSize(new Dimension (800, 800));

        magnitudeUp.setFont(customFont);
        magnitudeUp.setLineWrap(true);
        magnitudeUp.setEditable(false);
        magnitudeUp.setVisible(true);

        magnitudeUp.setForeground(Color.BLUE);
        magnitudeUp.setOpaque(false);

        this.add(magnitudeUp);
        magnitudeUp.setLocation(120,650);

        /*JTextArea text = new JTextArea("\t SAMPLE TEXT TEXT TEXT TEXT" +
                "\t SAMPLE TEXT TEXT TEXT TEXT" +
                "\t SAMPLE TEXT TEXT TEXT TEXT" +
                "\t SAMPLE TEXT TEXT TEXT TEXT" +
                "\t SAMPLE TEXT TEXT TEXT TEXT" +
                "\t SAMPLE TEXT TEXT TEXT TEXT" +
                "\t SAMPLE TEXT TEXT TEXT TEXT" +
                "\t SAMPLE TEXT TEXT TEXT TEXT" +
                "\t SAMPLE TEXT TEXT TEXT TEXT" +
                "\t SAMPLE TEXT TEXT TEXT TEXT" +
                "\t SAMPLE TEXT TEXT TEXT TEXT" +
                "\t SAMPLE TEXT TEXT TEXT TEXT" );


        text.setSize(new Dimension(400,400));

        text.setFont(customFont);
        text.setLineWrap(true);
        text.setEditable(false);
        text.setVisible(true);

        text.setForeground(Color.BLUE);
        text.setOpaque(false);

        this.add(text);
        text.setLocation(450,250);*/
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(p1, 50, 500, 50, 50, this);
        g.drawImage(p2, 50, 550, 50, 50, this);
        g.drawImage(p3, 50, 600, 50, 50, this);
        g.drawImage(p4, 50, 650, 50, 50, this);
        g.drawImage(cont1, 50, 400, 200, 100, this);
        g.drawImage(cont2, 400, 400, 200, 100, this);
    }
}
