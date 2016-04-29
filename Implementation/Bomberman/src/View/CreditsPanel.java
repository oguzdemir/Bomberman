package View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by od on 28.4.2016.
 */
public class CreditsPanel extends InfoPanel
{
    public CreditsPanel()
    {
        super("Credits  ");

        JTextArea text = new JTextArea("Oguz Demir - oguz.demir@ug.bilkent.edu.tr\n" +
                "Kaan Kale - \n" +
                "Anil Sert - anil.sert@ug.bilkent.edu.tr\n");


        text.setSize(new Dimension(900,900));

        text.setFont(customFont3);
        text.setLineWrap(true);
        text.setEditable(false);
        text.setVisible(true);

        text.setForeground(Color.BLUE);
        text.setOpaque(false);

        this.add(text);
        text.setLocation(50,350);
    }
}