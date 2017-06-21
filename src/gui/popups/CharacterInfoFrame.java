package gui.popups;

import character.PlayerCharacter;
import gameHandler.KeyHandler;
import java.awt.*;
import javax.swing.*;
import main.Game;

/**
 * Simple Charater Screen, to show the Basic Information of the Charater.
 * @author Matthias Dröge
 */
public class CharacterInfoFrame extends JFrame{
    private JTextArea charInfoArea;
    private JScrollPane scrollPane;
    
    private static CharacterInfoFrame instance;

    private CharacterInfoFrame(){
        
        initFrame();
        addData();
    }
    
    public static CharacterInfoFrame getInstance() {
        if (instance == null) {
            instance = new CharacterInfoFrame();
        }
        return instance;
    }
    
    private void initFrame(){
        this.scrollPane = new JScrollPane();
        this.charInfoArea = new JTextArea();
        this.scrollPane.setViewportView( this.charInfoArea );
        this.charInfoArea.setEditable(false);
                
        this.setName("Character Screen");
        this.setTitle(this.getName());
        int width = 200;
        int height = 600;
        this.setSize(new Dimension(width, height));
        // calculate Position
        int xGameFrame = Game.getInstance().getGameFrame().getxPosition();
        int yGameFrame = Game.getInstance().getGameFrame().getyPosition();
        int xCharacterFrame = xGameFrame - width;
        int yCharacterFrame = yGameFrame;
        this.setLocation(xCharacterFrame, yCharacterFrame);
        this.setResizable(false);
        this.setFocusable(true);
        
        // Grid Layout of the Frame to put the components in.
        this.setLayout(new GridLayout(1, 1));
        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        this.addKeyListener(Game.getKeyhandler());
        
        
        this.add( this.scrollPane );
    }
    
    private void addData(){
        PlayerCharacter p = main.Game.getPlayer();
        String tmp = p.showCharInfo();
        this.charInfoArea.setText(tmp);
    }
            
}
