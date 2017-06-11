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
        ArrayList<String[]> input = readHighscoreList();
        // tmp ==> [name][level][Exp]
        String[] tmp =  {
            main.Game.getPlayer().getName(),
            main.Game.getPlayer().getLevel()+"",
            main.Game.getPlayer().getExperience()+""
        };
        input.add( tmp );
        // Reading from Table an writing it to the file.
        FileController.write(input);
    }
}
