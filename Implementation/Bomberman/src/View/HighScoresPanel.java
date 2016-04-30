package View;

import Controller.GameManager;

import javax.swing.*;
import java.awt.*;

/**
 * High Scores screen.
 *
 * Created by An?l Sert on 29.4.2016.
 */
public class HighScoresPanel extends InfoPanel
{


    public HighScoresPanel(String highScores)
    {
        super("High Scores  ");


        String[] columnNames = {"Name", "Score"};
        String[] scores = highScores.split(" ");

        String[][] data = new String[10][2];

        for (int i = 0; i < scores.length/2; i++)
        {
            //System.out.println(scores[i]);
            data[i][0] = scores[2 * i];
            data[i][1] = scores[2 * i + 1];
        }

        JTable table = new JTable(data, columnNames);

        table.setFont(customFont);
        table.setForeground(Color.BLUE);
        table.setSize(new Dimension(500,500));
        table.setRowHeight(50);
        table.setVisible(true);
        table.setLocation(250, 250);
        this.add(table);
    }
}
