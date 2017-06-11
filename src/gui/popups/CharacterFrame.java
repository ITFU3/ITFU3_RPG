package gui.popups;

import character.PlayerCharacter;
import java.awt.*;
import javax.swing.*;

/**
 * Simple Charater Screen, to show the Basic Information of the Charater.
 * @author Matthias Dröge
 */
public class CharacterFrame extends JFrame{
    private JTextArea charInfoArea;
    private JScrollPane scrollPane;

    public CharacterFrame(){
        
        initFrame();
        addData();
    }
    
    private void initFrame(){
        this.scrollPane = new JScrollPane();
        this.charInfoArea = new JTextArea();
        this.scrollPane.setViewportView( this.charInfoArea );
        this.charInfoArea.setEditable(false);
                
        this.setName("Character Screen");
        this.setTitle(this.getName());
        
        this.setSize(new Dimension(250, 600));
        this.setResizable(false);
        this.setFocusable(true);
        
        // Grid Layout of the Frame to put the components in.
        this.setLayout(new GridLayout(1, 1));
        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        
        this.add( this.scrollPane );
    }
    
    private void addData(){
        PlayerCharacter p = main.Game.getPlayer();
        String tmp = p.showCharInfo();
        this.charInfoArea.setText(tmp);
    }
            
}
