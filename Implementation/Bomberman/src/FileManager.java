import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by od on 27.4.2016.
 */


public class FileManager
{
    private final static int GRID_SIZE = 13;

    public int[][] getGameData(int levelNo)
    {
        int [][] data = new int[GRID_SIZE][GRID_SIZE];
        String name = "level" + levelNo +".txt";
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

}
