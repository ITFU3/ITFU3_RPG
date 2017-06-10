package gui.popups;

import character.MonsterCharacter;
import character.PlayerCharacter;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

import character.item.spells.*;
import gameHandler.BattleHandler;
import main.Game;
import main.Map;

/**
 *
 * @author Matthias Dröge
 */
public class SpellbookFrame extends JFrame
{
    private JScrollPane scrollPane = new JScrollPane();
    private JList spellList = new JList();
    private JTextArea spellInfoArea = new JTextArea();
    private JButton castSpellButton = new JButton();
    
    private String selectedSpell = "";
    
    public SpellbookFrame()
    {
        this.setLayout(new GridLayout(0, 1));
        this.initList();
        this.configInternals();
        
        this.spellList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Spell spell = (Spell) spellList.getSelectedValue();
                try {
                    selectedSpell = spell.getName();
                    String tmp = "Name: " + selectedSpell + "\n";
                    tmp += "Range: " + spell.getSpellRange() + "\n";
                    tmp += "max Dmg: " + ( spell.getDamageDie() * spell.getDieCount() ) + "\n";
                    spellInfoArea.setText(tmp);
                } catch (Exception exception) {
                    System.err.println("Ooops!!! => Lieste?");
                }
            }
        });
        
        this.castSpellButton.addActionListener(
            new java.awt.event.ActionListener()
            {
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
                    }else{
                        System.err.println("Select a Spell to cast.");
                    }
                }
            }
        );
    }
    
    private void initList()
    {
        DefaultListModel<Spell> liederListModel = new DefaultListModel<>();
        for (Spell spell : Game.getPlayer().getpClass().getMyBook().getSpellBook()) {
            liederListModel.addElement(spell);
        }
        this.spellList.setModel(liederListModel);
        this.scrollPane.setViewportView(spellList);
        this.castSpellButton.setText("cast spell");
        this.add(this.scrollPane);
        this.add(this.spellInfoArea);
        this.add(this.castSpellButton);
    }
    
    private void configInternals()
    {
        Dimension d = new Dimension(400, 600);
        this.scrollPane.setSize(d);
        this.setSize(d);
        this.setPreferredSize(d);
        this.setMinimumSize(d);
        this.setMaximumSize(d);
        this.setResizable(false);
        this.setFocusable(true);
        this.setName("Spellbook");
        this.setTitle(this.getName());
    }
}
