package fileHandler;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * @author Matthias Dröge
 */
public class FileController
{
    private static final String FILENAME = "HighScore.dat";
    
    public static ArrayList<String[]> read()
    {
        ArrayList<String[]> output = new ArrayList();
        String row;
        try(BufferedReader br = new BufferedReader(new FileReader(FILENAME)))
        {
            while( ( row = br.readLine() ) != null ){
                String[] tmp = row.split(", ");
                output.add(tmp);
            }
        } catch(IOException e){ System.err.println(e.getMessage()); }
        return output;
    }
    
    public static void write(ArrayList<String[]> input)
    {
        String scorelist = "";
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME)))
        {
            for(Iterator<String[]> iterator = input.iterator(); iterator.hasNext();) {
                String[] buffer =  iterator.next();
                scorelist += buffer[0] + ", ";
                scorelist += buffer[1] + ", ";
                scorelist += buffer[2] + "\n";
            }
            bw.write(scorelist);
        }catch(IOException e){ System.err.println(e.getMessage()); }
    }
}