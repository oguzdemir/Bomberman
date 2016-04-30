package View;

import javax.swing.*;
import java.awt.*;

/**
 * Class for the credits screen.
 *
 * Created by od on 28.4.2016.
 *
 * Revised by Anıl Sert on 29.4.2016
 */
public class CreditsPanel extends InfoPanel
{
    /**
     * Default constructor for the Credits screen.
     */
    public CreditsPanel()
    {
        super("Credits  ");

        JTextArea text = new JTextArea("Oguz Demir - oguz.demir (at) ug.bilkent.edu.tr\n" +
                "Kaan Kale - kkale (at) ug.bilkent.edu.tr\n" +
                "Anil Sert - anil.sert (at) ug.bilkent.edu.tr\n\n" +
                "This project is created for Bilkent University CS319 Object Oriented Programming Course in Spring 2016");


        text.setSize(new Dimension(900,900));

        text.setFont(customFont3);
        text.setLineWrap(true);
        text.setEditable(false);
        text.setVisible(true);

        text.setForeground(Color.BLUE);
        text.setOpaque(false);

        this.add(text);
        text.setLocation(50,300);
    }
}