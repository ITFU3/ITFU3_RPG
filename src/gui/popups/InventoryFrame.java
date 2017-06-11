package gui.popups;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

import character.item.Item;
import character.item.weapons.*;
import character.item.armor.*;


/**
 *
 * @author Matthias Dröge
 */
public class InventoryFrame extends JFrame{
    private final JScrollPane scrollPane;
    private final JList itemList;
    private final JTextArea itemInfoArea;

    public InventoryFrame() {
        this.scrollPane = new JScrollPane();
        this.itemList = new JList();
        this.itemInfoArea = new JTextArea();
        
        this.initFrame();
        this.addListModel();
        this.addListListener();
    }    
    
    private void initFrame()
    {
        this.setName("Inventory");
        this.setTitle(this.getName());

        // setting the Size of the Frame
        // [width][height]
        this.setSize(new Dimension(300, 150));
        this.setResizable(false);
        this.setFocusable(true);
        
        // Grid Layout of the Frame to put the components in.
        // [row, col]
        this.setLayout(new GridLayout(1, 2));
        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        
        // adding the comonents to the Frame
        // the order predicts the Grid Position
        this.add(this.scrollPane);
        this.add(this.itemInfoArea);
    }
    
    /**
     * adding the data model to the list
     */
    private void addListModel()
    {
        DefaultListModel<Item> ItemListModel = new DefaultListModel<>();
        
        ItemListModel.addElement(main.Game.getPlayer().getpArmor());
        ItemListModel.addElement(main.Game.getPlayer().getpWeapon());
            
        this.itemList.setModel(ItemListModel);
        this.scrollPane.setViewportView(this.itemList);
    }
    
    /**
     * adding the selection listener to the list
     */
    private void addListListener(){
        this.itemList.addListSelectionListener(
            new ListSelectionListener(){
                @Override
                public void valueChanged(ListSelectionEvent e){
                    System.out.println("gui.popUps.InventoryFrame.addListListener.valueChanged: ==> CLICK");
                    try{
                        Item item = (Item) itemList.getSelectedValue();
                        Class[] itemClasses = item.getClass().getClasses();
                        for (Class itemClass : itemClasses)
                        {
                            if(itemClass.getSimpleName().equalsIgnoreCase("Weapon"))
                            {
                                Weapon w = (Weapon) item;
                                String tmp = "Name: " + w.getName() + "\n"
                                    + "Type: " + w.getType() + "\n"
                                    + "Max Dmg: " + (w.getDamageDie()*w.getDieCount()) + "\n"
                                    + "Range: " + w.getDistance() + "\n"
                                    + "Category: " + w.getCat() + "\n"
                                    + "Weapon Group: " + w.getWeaponGroup() + "\n";
                                itemInfoArea.setText(tmp);
                                break;
                            }
                            else if(itemClass.getSimpleName().equalsIgnoreCase("Armor"))
                            {
                                Armor a = (Armor) item;
                                String tmp = "Name: " + a.getName() + "\n"
                                    + "Type: " + a.getType() + "\n"
                                    + "Armor Value: " + a.getArmorValue()  + "\n"
                                    + "Category: " + a.getCat();
                                itemInfoArea.setText(tmp);
                                break;
                            }
                        }
                    }
                    catch (Exception exception)
                    {
                        System.err.println("Ooops!!! => Lieste?");
                    }
                }
            }
        );
    }
}
