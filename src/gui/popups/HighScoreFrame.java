package gui.popups;

import java.awt.*;
import java.util.ArrayList;
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
        this.addSorter();
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
     * adding a sorter
     */
    private void addSorter()
    {
        TableRowSorter<TableModel> sorter = new TableRowSorter(this.table.getModel());
        this.table.setRowSorter(sorter);
        ArrayList<RowSorter.SortKey> sortKeys = new ArrayList(25);
        sortKeys.add(new RowSorter.SortKey(2, SortOrder.DESCENDING));
        sorter.setSortKeys(sortKeys);
    }
}