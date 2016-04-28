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
    public HelpPanel()
    {

        super("Help");


        JTextArea text = new JTextArea("\t SAMPLE TEXT TEXT TEXT TEXT" +
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
        text.setLocation(450,250);
    }

}
