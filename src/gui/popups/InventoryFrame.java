package gui.popups;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

import character.item.Item;
import character.item.weapons.*;
import character.item.armor.*;
import gameHandler.InputHandler;
import gameHandler.KeyHandler;
import main.Game;


/**
 *
 * @author Matthias Dröge
 */
public class InventoryFrame extends JFrame{
    private final JScrollPane scrollPane;
    private final JList itemList;
    private final JTextArea itemInfoArea;

    public static InventoryFrame instance;
    
    
    
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
        int width = 200;
        int height = 300;
        // setting the Size of the Frame
        // [width][height]
        this.setSize(new Dimension(width, height));
        // calculate Position
        int xGameFrame = Game.getInstance().getGameFrame().getxPosition();
        int yGameFrame = Game.getInstance().getGameFrame().getyPosition();
        int xInventoryFrame = xGameFrame + Game.getInstance().getGameFrame().getWidth();
        int yInventoryFrame = yGameFrame + height; // as it is same height as Spellbook it will be displayed below
        this.setLocation(xInventoryFrame, yInventoryFrame);
        this.setResizable(false);
        this.setFocusable(true);
        this.addKeyListener(Game.getKeyhandler());
        
        
        // Grid Layout of the Frame to put the components in.
        // [row, col]
        this.setLayout(new GridLayout(1, 2));
        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        
        
        
        // adding the comonents to the Frame
        // the order predicts the Grid Position
        this.add(this.scrollPane);
        this.add(this.itemInfoArea);
    }
    
    public static InventoryFrame getInstance() {
        if (instance == null) {
            instance = new InventoryFrame();
        }
        return instance;
    }
    
    /**
     * adding the data model to the list
     */
    private void addListModel()
    {
        DefaultListModel<Item> ItemListModel = new DefaultListModel<>();
        
        ItemListModel.addElement(main.Game.getPlayer().getArmorSlot());
        ItemListModel.addElement(main.Game.getPlayer().getWeaponSlot());
            
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
                        String baseClass = item.getClass().getSuperclass().getSimpleName();
                        String tmp = "";
                        if(baseClass.equalsIgnoreCase("Weapon"))
                        {
                            Weapon w = (Weapon) item;
                            tmp = "Name: " + w.getName() + "\n"
                                + "Type: " + w.getType() + "\n"
                                + "Max Dmg: " + (w.getDamageDie()*w.getDieCount()) + "\n"
                                + "Range: " + w.getDistance() + "\n"
                                + "Category: " + w.getCat() + "\n"
                                + "Weapon Group: " + w.getWeaponGroup() + "\n";
                        }
                        else if(baseClass.equalsIgnoreCase("Armor"))
                        {
                            Armor a = (Armor) item;
                            tmp = "Name: " + a.getName() + "\n"
                                + "Type: " + a.getType() + "\n"
                                + "Armor Value: " + a.getArmorValue()  + "\n"
                                + "Category: " + a.getCat();
                        }
                        itemInfoArea.setText(tmp);
                    }
                    catch (Exception exception)
                    {
                        System.err.println("gui.popups.InventoryFrame.valueChanged ==> LIST ERROR\n" + exception.getMessage());
                    }
                }
            }
        );
    }
}
