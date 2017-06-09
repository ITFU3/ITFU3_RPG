package fileHandler;

import java.util.ArrayList;

/**
 * @author Matthias Dröge
 */
public class DataHandler
{
    public static ArrayList<String[]> readHighscoreList()
    {
        ArrayList<String[]> ScoreList = FileController.read();
        // Here is the packing of entries in the HighScore JTable
        // Because the JTable can sort the list
        // https://stackoverflow.com/questions/28823670/how-to-sort-jtable-in-shortest-way
        return ScoreList;
    }
    
    public static void writeHighScoreList(){
        ArrayList<String[]> input = new ArrayList();
        String[] tmp =  {"Zelo","2", "2"};
        input.add( tmp );
        
        String[] tmp2 = {"Zelo", "3", "4"};
        input.add(tmp2);
        
        String[] tmp3 = {"Zelo", "4", "6"};
        input.add(tmp3);
        
        // Reading from Table an writing it to the file.
        FileController.write(input);
    }
}
