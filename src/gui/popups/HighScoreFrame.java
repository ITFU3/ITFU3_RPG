package gui.popups;

import gui.SelectionFrame;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Matthias Dröge
 */
public class HighScoreFrame extends JFrame
{
    private JScrollPane scrollPane = new JScrollPane();
    private JTable table = new JTable();
    
    public HighScoreFrame() {
        this.setLayout(new GridLayout(0, 1));
        this.initList();
        this.configInternals();
        
        TableRowSorter<TableModel> sorter = new TableRowSorter(table.getModel());
        table.setRowSorter(sorter);
        ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
        sortKeys.add(new RowSorter.SortKey(2, SortOrder.DESCENDING));
        sorter.setSortKeys(sortKeys);
        table.setEnabled(false);
        table.setFocusable(false);
    }

    private void initList() {
        String[] colName = {"Name", "level", "Score"};
        ArrayList<String[]> scoreList = fileHandler.DataHandler.readHighscoreList();
        String[][] output = new String[scoreList.size()][3];
        
        for(int i = 0; i < scoreList.size(); i++) {
            String[] temp = { scoreList.get(i)[0], scoreList.get(i)[1], scoreList.get(i)[2] };
            output[i] = temp;
        }
        DefaultTableModel scoreTableModel = new DefaultTableModel(output, colName);

        this.table.setModel(scoreTableModel);
        this.scrollPane.setViewportView(table);
        this.add(this.scrollPane);
    }

    private void configInternals() {
        Dimension d = new Dimension(400, 150);
        this.scrollPane.setSize(d);
        this.setSize(d);
        this.setResizable(false);
        this.setName("HighScore");
        this.setTitle(this.getName());
    }
}