package gui.popups;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author Matthias Dröge
 */
public class HighScoreFrame extends JFrame
{
    private final JScrollPane scrollPane;
    private final JTable table;
    
    public HighScoreFrame()
    {
        this.scrollPane = new JScrollPane();
        this.table = new JTable();
        
        this.initFrame();
        this.addTableModel();
    }

    /**
     * std. frame preps
     */
    private void initFrame()
    {
        this.setName("HighScore");
        this.setTitle(this.getName());
        
        this.setLayout(new GridLayout(0, 1));
        this.setSize(new Dimension(400, 150));
        this.setResizable(false);
        
        this.table.setEnabled(false);
        this.table.setFocusable(false);
        
        this.scrollPane.setEnabled(false);
        this.scrollPane.setFocusable(false);
        
        this.add(this.scrollPane);
    }
    
    /**
     * adding the model to the table
     */
    private void addTableModel()
    {
        String[] colName = {"Name", "level", "Score"};
        ArrayList<String[]> scoreList = fileHandler.DataHandler.readHighscoreList();
        
        scoreList = preSorter(scoreList);
        
        String[][] output = new String[scoreList.size()][3];
        for(int i = 0; i < scoreList.size(); i++)
        {
            String[] temp = { scoreList.get(i)[0], scoreList.get(i)[1], scoreList.get(i)[2] };
            output[i] = temp;
        }
        DefaultTableModel scoreTableModel = new DefaultTableModel(output, colName);
        this.table.setModel(scoreTableModel);
        this.scrollPane.setViewportView(this.table);
    }
    
    /**
     * ArrayList<String[]> preSorter
     * That is better than the TableRowSorter
     */
    private ArrayList<String[]> preSorter(ArrayList<String[]> input){
        Collections.sort(input, new Comparator<String[]>(){
            @Override
            public int compare(String[] b, String[] a){
                //[2] => Score row
                int one = Integer.parseInt(a[2]);
                int two = Integer.parseInt(b[2]);
                int output = 0;
                if(one == two){ output=0; }
                else if(one < two){ output=-1; }
                else if(one > two){ output=1; }
                System.err.println(one+" | "+two+" | "+output);
                return output;
            }
        });
        ArrayList<String[]> output = input;        
        return output;
    }
}