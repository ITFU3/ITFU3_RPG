package gui.popups;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

import character.*;
import character.item.spells.*;
import gameHandler.BattleHandler;
import main.Game;

/**
 *
 * @author Matthias Dröge
 */
public class SpellbookFrame extends JFrame
{
    private final JScrollPane scrollPane;
    private final JList spellList;
    private final JTextArea spellInfoArea;
    private final JButton castSpellButton;
    private String selectedSpell;
    
    public SpellbookFrame()
    {
        this.scrollPane = new JScrollPane();
        this.spellList = new JList();
        this.spellInfoArea = new JTextArea();
        this.castSpellButton = new JButton();
        this.selectedSpell = "";
        
        this.initFrame();
        this.addListModel();
        this.addListListener();
        this.addButtonListener();
    }
    
    /**
     * ToDo: play with the size etc, to make it look better.
     */
    private void initFrame()
    {
        this.setName("Spellbook");
        this.setTitle(this.getName());
        this.castSpellButton.setText("cast spell");

        // setting the Size of the Frame
        this.setSize(new Dimension(300, 300));
        this.setResizable(false);
        this.setFocusable(true);
        
        // Grid Layout of the Frame to put the components in.
        this.setLayout(new GridLayout(2, 2));
        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        
        // adding the comonents to the Frame
        // the order predicts the Grid Position
        this.add(this.scrollPane);
        this.add(this.spellInfoArea);
        this.add(this.castSpellButton);
    }
    
    /**
     * adding the data model to the list
     */
    private void addListModel()
    {
        DefaultListModel<Spell> liederListModel = new DefaultListModel<>();
        for (Spell spell : Game.getPlayer().getpClass().getMyBook().getSpellBook()) {
            liederListModel.addElement(spell);
        }
        this.spellList.setModel(liederListModel);
        this.scrollPane.setViewportView(spellList);
    }
    
    /**
     * adding the selection listener to the list
     */
    private void addListListener(){
        this.spellList.addListSelectionListener(
            new ListSelectionListener(){
                @Override
                public void valueChanged(ListSelectionEvent e)
                {
                    Spell spell = (Spell) spellList.getSelectedValue();
                    try
                    {
                        selectedSpell = spell.getName();
                        String tmp = "Name: " + selectedSpell + "\n";
                        tmp += "Range: " + spell.getSpellRange() + "\n";
                        tmp += "max Dmg: " + ( spell.getDamageDie() * spell.getDieCount() ) + "\n";
                        spellInfoArea.setText(tmp);
                    }
                    catch (Exception exception)
                    {
                        System.err.println("Ooops!!! => Lieste?");
                    }
                }
            }
        );
    }
    
    /**
     * adding the listener to the button
     */
    private void addButtonListener(){
        this.castSpellButton.addActionListener(
            new java.awt.event.ActionListener(){
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    if( !selectedSpell.equalsIgnoreCase("") )
                    {
                        PlayerCharacter attacker = main.Game.getPlayer();
                        MonsterCharacter target = main.Game.getMonsters().get(
                            Game.getInstance().getMonsterClosedToPlayer()
                        );
                        BattleHandler.tryToSpellAttack(attacker, target, selectedSpell);
                        Game.updateGUI();
                    }
                    else
                    {
                        System.err.println("Select a Spell to cast.");
                    }
                }
            }
        );
    }
}
