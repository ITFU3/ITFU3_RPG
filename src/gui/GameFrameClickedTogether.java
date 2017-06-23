package gui;

import Base.UserInfo;
import main.*;
import gameHandler.*;
import gui.GuiHelper.HealthBarLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

/**
 *
 * @author Steffen Haas
 * @author Matthias Dröge
 * 
 * // OLD VERSION
 */
public class GameFrameClickedTogether extends javax.swing.JFrame {
    ArrayList<JComponent> components = new ArrayList();
    int testHp = Game.getPlayer().getHealth();
    
    int xPosition;
    int yPosition;
    
    /**
     * Creates new form GameFrame
     */
    public GameFrameClickedTogether() {
        initComponents();
        initFrameSetup();
        
        // Arean Setup
        this.arenaTextArea.setText( new Map().getMap());
        this.arenaTextArea.setEnabled(false);
        this.arenaTextArea.setFocusable(false);
        this.arenaTextArea.setDisabledTextColor(Color.BLACK);
        this.arenaTextArea.setFont( new java.awt.Font("Courier New", 0, 19) );
        
        // Attack Info Setup
        this.attackInfoTextArea.setText(Game.getInstance().attackInfo);
        this.attackInfoTextArea.setEnabled(false);
        this.attackInfoTextArea.setFocusable(false);
        this.attackInfoTextArea.setDisabledTextColor(Color.BLACK);
        this.attackInfoTextArea.setFont( new java.awt.Font("Courier New", 0, 13) );
        
        this.keyInfoTextArea.setText(UserInfo.KEYS);
        this.keyInfoTextArea.setEnabled(false);
        this.keyInfoTextArea.setFocusable(false);
        this.keyInfoTextArea.setDisabledTextColor(Color.BLACK);
        this.keyInfoTextArea.setFont( new java.awt.Font("Courier New", 0, 13) );
        
        DefaultCaret caret = (DefaultCaret)attackInfoTextArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        
        // Monster Info Setup
        this.monsterInfoTextArea.setText(Game.getInstance().getMonsterInfo());
        this.monsterInfoTextArea.setEnabled(false);
        this.monsterInfoTextArea.setFocusable(false);
        this.monsterInfoTextArea.setDisabledTextColor(Color.BLACK);
        this.monsterInfoTextArea.setFont( new java.awt.Font("Courier New", 0, 13) );
        
        this.playerNamelLabel.setFont(new Font("Courier New", Font.BOLD, 15));
        this.playerNamelLabel.setText(Game.getPlayer().getName());
        
        this.currentActiveCharLabel.setText( Game.getPlayer().getName()+ "'s turn");
        
        this.valueMovesLeftLabel.setText( Game.getPlayer().getAllowedMoves() + "" );
        this.valueAttacksLeftLabel.setText( Game.getPlayer().getAllowedAttacks() + "" );
        
        this.experienceValueLabel.setText(Game.getPlayer().getExperience() + "");
        
        // init Healthbar
        ((HealthBarLabel)this.playerHealthBarLabel).setHealthText(
            Game.getPlayer().getHealth()
        );
        
        this.initButtonList();
        
        // needed for keyboard to work
        this.setButtonFocus(false);
        
        // add the Listener for WindowClosing
        this.addWindowListener();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        arenaScrollPane = new javax.swing.JScrollPane();
        attackInfoTextArea = new javax.swing.JTextArea();
        downButton = new javax.swing.JButton();
        btn_EndRound = new javax.swing.JButton();
        healthLabel = new javax.swing.JLabel();
        playerHealthBarLabel = new HealthBarLabel(Game.getInstance().getPlayer().getHealth());
        jButton1 = new javax.swing.JButton();
        upButton = new javax.swing.JButton();
        rightButton = new javax.swing.JButton();
        leftButton = new javax.swing.JButton();
        playerNamelLabel = new javax.swing.JLabel();
        monsterScrollPane = new javax.swing.JScrollPane();
        monsterInfoTextArea = new javax.swing.JTextArea();
        monsterInfoTitleLabel = new javax.swing.JLabel();
        attackButton = new javax.swing.JButton();
        attackScrollPane = new javax.swing.JScrollPane();
        arenaTextArea = new javax.swing.JTextArea();
        arenaTitleLabel = new javax.swing.JLabel();
        inputInfoLabel = new javax.swing.JLabel();
        numberOfMovesLeftLabel = new javax.swing.JLabel();
        valueMovesLeftLabel = new javax.swing.JLabel();
        changeInputTypeButton = new javax.swing.JButton();
        numberOfActionsLeftLabel1 = new javax.swing.JLabel();
        valueAttacksLeftLabel = new javax.swing.JLabel();
        currentActiveCharLabel = new javax.swing.JLabel();
        roundLabel = new javax.swing.JLabel();
        levelLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        keyInfoTextArea = new javax.swing.JTextArea();
        experienceTitelLabel = new javax.swing.JLabel();
        experienceValueLabel = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        attackInfoTextArea.setColumns(20);
        attackInfoTextArea.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N
        attackInfoTextArea.setRows(5);
        attackInfoTextArea.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        arenaScrollPane.setViewportView(attackInfoTextArea);

        getContentPane().add(arenaScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, 460, 170));

        downButton.setText("Down");
        downButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downButtonActionPerformed(evt);
            }
        });
        getContentPane().add(downButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 610, -1, -1));

        btn_EndRound.setText("End Round");
        btn_EndRound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EndRoundActionPerformed(evt);
            }
        });
        getContentPane().add(btn_EndRound, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 530, -1, -1));

        healthLabel.setText("Health");
        getContentPane().add(healthLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 200, -1));

        playerHealthBarLabel.setText("");
        getContentPane().add(playerHealthBarLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 200, -1));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 620, -1, -1));

        upButton.setText("Up");
        upButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upButtonActionPerformed(evt);
            }
        });
        getContentPane().add(upButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 530, -1, -1));

        rightButton.setText("Right");
        rightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightButtonActionPerformed(evt);
            }
        });
        getContentPane().add(rightButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 570, -1, -1));

        leftButton.setText("Left");
        leftButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftButtonActionPerformed(evt);
            }
        });
        getContentPane().add(leftButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 570, -1, -1));

        playerNamelLabel.setText("- Player Name -");
        getContentPane().add(playerNamelLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 200, -1));

        monsterInfoTextArea.setColumns(20);
        monsterInfoTextArea.setRows(5);
        monsterScrollPane.setViewportView(monsterInfoTextArea);

        getContentPane().add(monsterScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 50, 200, 220));

        monsterInfoTitleLabel.setText("Monster");
        getContentPane().add(monsterInfoTitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, 170, 20));

        attackButton.setText("Attack");
        attackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attackButtonActionPerformed(evt);
            }
        });
        getContentPane().add(attackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 650, 470, -1));

        arenaTextArea.setColumns(20);
        arenaTextArea.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N
        arenaTextArea.setRows(5);
        arenaTextArea.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        attackScrollPane.setViewportView(arenaTextArea);

        getContentPane().add(attackScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 460, 310));

        arenaTitleLabel.setText("Arena");
        getContentPane().add(arenaTitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 90, -1));

        inputInfoLabel.setText("KeyboardInput");
        getContentPane().add(inputInfoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 280, 90, 10));

        numberOfMovesLeftLabel.setText("Movement left:");
        getContentPane().add(numberOfMovesLeftLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 110, -1));

        valueMovesLeftLabel.setText("6");
        getContentPane().add(valueMovesLeftLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, -1, -1));

        changeInputTypeButton.setText("Keyboard");
        changeInputTypeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeInputTypeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(changeInputTypeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 300, -1, 30));

        numberOfActionsLeftLabel1.setText("Attacks left:");
        getContentPane().add(numberOfActionsLeftLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 80, -1));

        valueAttacksLeftLabel.setText("6");
        getContentPane().add(valueAttacksLeftLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, -1, -1));

        currentActiveCharLabel.setText("Active gamer label");
        getContentPane().add(currentActiveCharLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        roundLabel.setText("Round 1");
        getContentPane().add(roundLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

        levelLabel.setText("Level 1");
        getContentPane().add(levelLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, -1));

        keyInfoTextArea.setColumns(20);
        keyInfoTextArea.setRows(5);
        jScrollPane1.setViewportView(keyInfoTextArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 330, 200, 280));

        experienceTitelLabel.setText("Experience");
        getContentPane().add(experienceTitelLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        experienceValueLabel.setText("0");
        getContentPane().add(experienceValueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Movementcontrol of the Character via mouse
     * @param evt 
     */
    private void downButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downButtonActionPerformed
       InputHandler.moveDown();
    }//GEN-LAST:event_downButtonActionPerformed

    /**
     * Movementcontrol of the Character via mouse
     * @param evt 
     */
    private void leftButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftButtonActionPerformed
        InputHandler.moveLeft();
    }//GEN-LAST:event_leftButtonActionPerformed

    /**
     * Attack command via mouse
     * @param evt 
     */
    private void attackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attackButtonActionPerformed
        InputHandler.attack();
    }//GEN-LAST:event_attackButtonActionPerformed

    /**
     * Change the Input Type back to Keyboard.
     * @param evt 
     */
    private void changeInputTypeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeInputTypeButtonActionPerformed
        InputHandler.setControlFocus(true);
    }//GEN-LAST:event_changeInputTypeButtonActionPerformed

    /**
     * Movementcontrol of the Character via mouse
     * @param evt 
     */
    private void upButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upButtonActionPerformed
        InputHandler.moveUp();
    }//GEN-LAST:event_upButtonActionPerformed

    /**
     * Movementcontrol of the Character via mouse
     * @param evt 
     */
    private void rightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightButtonActionPerformed
        InputHandler.moveUp();
    }//GEN-LAST:event_rightButtonActionPerformed

    /**
     * Testing purpose
     * @param evt 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        // reduce Player Health Test
//        testHp = testHp-1;
//        System.out.println(testHp);
//        ((HealthBarLabel)playerHealthBarLabel).setHealthText(testHp);
        InputHandler.openCloseSpellbook();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Ending the Turn of the Player.
     * Starts the Turn of the Monster.
     * @param evt 
     */
    private void btn_EndRoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EndRoundActionPerformed
        InputHandler.endRound();
    }//GEN-LAST:event_btn_EndRoundActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameFrameClickedTogether.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameFrameClickedTogether.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameFrameClickedTogether.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameFrameClickedTogether.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameFrameClickedTogether().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane arenaScrollPane;
    private javax.swing.JTextArea arenaTextArea;
    private javax.swing.JLabel arenaTitleLabel;
    private javax.swing.JButton attackButton;
    private javax.swing.JTextArea attackInfoTextArea;
    private javax.swing.JScrollPane attackScrollPane;
    private javax.swing.JButton btn_EndRound;
    private javax.swing.JButton changeInputTypeButton;
    private javax.swing.JLabel currentActiveCharLabel;
    private javax.swing.JButton downButton;
    private javax.swing.JLabel experienceTitelLabel;
    private javax.swing.JLabel experienceValueLabel;
    private javax.swing.JLabel healthLabel;
    private javax.swing.JLabel inputInfoLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea keyInfoTextArea;
    private javax.swing.JButton leftButton;
    private javax.swing.JLabel levelLabel;
    private javax.swing.JTextArea monsterInfoTextArea;
    private javax.swing.JLabel monsterInfoTitleLabel;
    private javax.swing.JScrollPane monsterScrollPane;
    private javax.swing.JLabel numberOfActionsLeftLabel1;
    private javax.swing.JLabel numberOfMovesLeftLabel;
    private javax.swing.JLabel playerHealthBarLabel;
    private javax.swing.JLabel playerNamelLabel;
    private javax.swing.JButton rightButton;
    private javax.swing.JLabel roundLabel;
    private javax.swing.JButton upButton;
    private javax.swing.JLabel valueAttacksLeftLabel;
    private javax.swing.JLabel valueMovesLeftLabel;
    // End of variables declaration//GEN-END:variables

    /**
     * collecting the GUI Elements for easy access.
     */
    private void initButtonList() {
       // Movement
        components.add(upButton);
        components.add(rightButton);
        components.add(downButton);
        components.add(leftButton);
        // Attack
        components.add(attackButton);
        // Other
        components.add(btn_EndRound);
        components.add(jButton1);
        components.add(changeInputTypeButton);
        //scrollpanes
        components.add(attackScrollPane);
        components.add(monsterScrollPane);
        components.add(arenaScrollPane);
    }
    
    /**
     * 
     * @param focus 
     */
    public void setButtonFocus(boolean focus ) {
        for(int i=0;i<this.components.size();i++){
            this.components.get(i).setFocusable(focus);
            if(this.components.get(i) instanceof JButton){
                this.components.get(i).setEnabled(focus);
            }
        }
        String inputType = "Keyboard";
        if(focus){ inputType = "Mouse"; } 
        this.inputInfoLabel.setText(inputType);
    }

    /**
     * 
     */
    private void initFrameSetup() {
        this.setResizable(false);
        Dimension dimensions = new Dimension(800, 700);
        this.setPreferredSize(dimensions);
        this.setMinimumSize(dimensions);
        this.setMaximumSize(dimensions);
        this.setFocusable(true);
        this.addKeyListener(Game.getKeyhandler());
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension windowSize = this.getSize();

        this.xPosition = Math.max(0, (screenSize.width  - windowSize.width ) / 2);
        this.yPosition = Math.max(0, (screenSize.height - windowSize.height) / 2);
        this.setLocation(xPosition, yPosition);
        this.setVisible(true);
    }
    
    /**
     * Override the close window function to save the HighScore
     */
    private void addWindowListener(){
	this.addWindowListener(new java.awt.event.WindowAdapter()
        {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent)
            {
                String ObjButtons[] = {"Yes","No"};
                int PromptResult = JOptionPane.showOptionDialog(
                    null, 
                    "Do you want to save your HighScore?",
                    "Ending Game", 
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null, 
                    ObjButtons,
                    ObjButtons[1]
                );
                if(PromptResult==0)
                {
                    fileHandler.DataHandler.writeHighScoreList();
                }
                System.out.println("main.GameFrame.addWindowListener.windowClosing: ==> SAVE");
                System.exit(0);
            }
	});
    }
    
    /* Getter and Setter after this line */
    public JLabel getHealthLabel() {
        return healthLabel;
    }
    public JLabel getPlayerHealthBarLabel() {
        return playerHealthBarLabel;
    }
    public JTextArea getMonsterTextArea() {
        return monsterInfoTextArea;
    }
    public JLabel getPlayerNamelLabel() {
        return playerNamelLabel;
    }
    public JTextArea getAttackInfoTextArea() {
        return attackInfoTextArea;
    }
    public JTextArea getMonsterInfoTextArea() {
        return monsterInfoTextArea;
    }
    public JLabel getValueAttacksLeftLabel() {
        return valueAttacksLeftLabel;
    }
    public JLabel getValueMovesLeftLabel() {
        return valueMovesLeftLabel;
    }
    public JTextArea getArenaTextArea() {
 
        return arenaTextArea;
    }
    public JLabel getCurrentActiveCharLabel() {
        return currentActiveCharLabel;
    }
    public JLabel getLevelLabel() {
        return levelLabel;
    }
    public JLabel getRoundLabel() {
        return roundLabel;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public JLabel getExperienceValueLabel() {
        return experienceValueLabel;
    }
    
    
    
    
}