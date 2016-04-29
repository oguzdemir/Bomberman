package Controller;

import java.io.*;

/**
 * Controller class for file interactions for the program.
 *
 * Created by od on 27.4.2016.
 *
 * Revised by Anıl Sert on 29.04.2016.
 */


public class FileManager
{
    private final static int GRID_SIZE = 13;

    /**
     * Reads data from level files and return the data.
     * @param levelNo level that needs to be drawn to screen.
     * @return level data.
     */
    public int[][] getGameData(int levelNo)
    {
        int [][] data = new int[GRID_SIZE][GRID_SIZE];
        String name = "src/Sources/levels/level" + levelNo +".txt";
        try (BufferedReader br = new BufferedReader(new FileReader(name))) {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                for(int i = 0; i < GRID_SIZE ; i++)
                {
                    data[count][i] = Integer.parseInt(line.substring(i,i+1));
                }
                count++;
            }
        }
        catch(IOException e)
        {
            System.out.println("File cannot be opppened");
        }
        return data;
    }

    /**
     * Load high scores from the high scores file.
     * @return high scores string representation.
     */
    public String loadHighScores()
    {
        String highScores = "";
        String name = "src/Sources/highscores.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(name))) {
            highScores = br.readLine();
        }
        catch(IOException e)
        {
            System.out.println("File cannot be opened");
        }
        return highScores;
    }

    /**
     * Change the high scores file with the new one.
     * @param highScores new high scores.
     */
    public void setHighScores(String highScores)
    {
        String name = "src/Sources/highscores_tmp.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(name))) {
            bw.write(highScores);
        }
        catch(IOException e)
        {
            System.out.println("File cannot be opened");
        }
        File newFile = new File("src/Sources/highscores_tmp.txt");
        File oldFile = new File("src/Sources/highscores.txt");

        oldFile.delete();
        newFile.renameTo(oldFile);
    }

}
