package gui;

import main.*;
import character.*;
import gameHandler.*;
import gui.GuiHelper.HealthBarLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author Steffen Haas
 * @author Matthias Dröge
 */
public class GameFrame extends javax.swing.JFrame {
    ArrayList<JComponent> components = new ArrayList();
    int testHp = Game.getInstance().getPlayer().getHealth();
    /**
     * Creates new form GameFrame
     */
    public GameFrame() {
        initComponents();
        initFrameSetup();
        
        // Arean Setup
        this.arenaTextArea.setText( Map.getInstance().getMap());
        this.arenaTextArea.setEnabled(false);
        this.arenaTextArea.setFocusable(false);
        this.arenaTextArea.setDisabledTextColor(Color.BLACK);
        this.arenaTextArea.setFont( new java.awt.Font("Courier New", 0, 13) );
        
        // Attack Info Setup
        this.attackInfoTextArea.setText(Game.getInstance().attackInfo);
        this.attackInfoTextArea.setEnabled(false);
        this.attackInfoTextArea.setFocusable(false);
        this.attackInfoTextArea.setDisabledTextColor(Color.BLACK);
        this.attackInfoTextArea.setFont( new java.awt.Font("Courier New", 0, 13) );
        
        // Monster Info Setup
        this.monsterInfoTextArea.setText(Game.getInstance().getMonsterInfo());
        this.monsterInfoTextArea.setEnabled(false);
        this.monsterInfoTextArea.setFocusable(false);
        this.monsterInfoTextArea.setDisabledTextColor(Color.BLACK);
        this.monsterInfoTextArea.setFont( new java.awt.Font("Courier New", 0, 13) );
        
        this.playerNamelLabel.setFont(new Font("Courier New", Font.BOLD, 15));
        this.playerNamelLabel.setText(Game.getInstance().getPlayer().getName());
        
        // init Healthbar
        ((HealthBarLabel)this.playerHealthBarLabel).setHealthText(
            Game.getInstance().getPlayer().getHealth()
        );
        
        this.initComponentList();
        
        // needed for keyboard to work
        this.setButtonFocus(false);
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
        jLabel1 = new javax.swing.JLabel();
        attackInfoTitleLabel = new javax.swing.JLabel();
        inputInfoLabel = new javax.swing.JLabel();
        numberOfMovesLeftLabel = new javax.swing.JLabel();
        valueMovesLeftLabel = new javax.swing.JLabel();
        changeInputTypeButton = new javax.swing.JButton();
        numberOfActionsLeftLabel1 = new javax.swing.JLabel();
        valueAttacksLeftLabel = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        attackInfoTextArea.setColumns(20);
        attackInfoTextArea.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N
        attackInfoTextArea.setRows(5);
        attackInfoTextArea.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        arenaScrollPane.setViewportView(attackInfoTextArea);

        getContentPane().add(arenaScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, 500, 80));

        downButton.setText("Down");
        downButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downButtonActionPerformed(evt);
            }
        });
        getContentPane().add(downButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 540, -1, -1));

        btn_EndRound.setText("End Round");
        btn_EndRound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EndRoundActionPerformed(evt);
            }
        });
        getContentPane().add(btn_EndRound, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 510, -1, -1));

        healthLabel.setText("Health");
        getContentPane().add(healthLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 200, -1));

        playerHealthBarLabel.setText("");
        getContentPane().add(playerHealthBarLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 200, -1));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 550, -1, -1));

        upButton.setText("Up");
        upButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upButtonActionPerformed(evt);
            }
        });
        getContentPane().add(upButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 460, -1, -1));

        rightButton.setText("Right");
        rightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightButtonActionPerformed(evt);
            }
        });
        getContentPane().add(rightButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 500, -1, -1));

        leftButton.setText("Left");
        leftButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftButtonActionPerformed(evt);
            }
        });
        getContentPane().add(leftButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 500, -1, -1));

        playerNamelLabel.setText("- Player Name -");
        getContentPane().add(playerNamelLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 200, -1));

        monsterInfoTextArea.setColumns(20);
        monsterInfoTextArea.setRows(5);
        monsterScrollPane.setViewportView(monsterInfoTextArea);

        getContentPane().add(monsterScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 50, 170, 260));

        monsterInfoTitleLabel.setText("Monster");
        getContentPane().add(monsterInfoTitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, 170, 20));

        attackButton.setText("Attack");
        attackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attackButtonActionPerformed(evt);
            }
        });
        getContentPane().add(attackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 590, 500, -1));

        arenaTextArea.setColumns(20);
        arenaTextArea.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N
        arenaTextArea.setRows(5);
        arenaTextArea.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        attackScrollPane.setViewportView(arenaTextArea);

        getContentPane().add(attackScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 500, 260));

        jLabel1.setText("Arena");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 500, -1));

        attackInfoTitleLabel.setText("Attack Information");
        getContentPane().add(attackInfoTitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, 250, -1));

        inputInfoLabel.setText("KeyboardInput");
        getContentPane().add(inputInfoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 90, -1));

        numberOfMovesLeftLabel.setText("Movement left:");
        getContentPane().add(numberOfMovesLeftLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 110, -1));

        valueMovesLeftLabel.setText("6");
        getContentPane().add(valueMovesLeftLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, -1, -1));

        changeInputTypeButton.setText("Keyboard");
        changeInputTypeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeInputTypeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(changeInputTypeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 450, -1, -1));

        numberOfActionsLeftLabel1.setText("Attacks left:");
        getContentPane().add(numberOfActionsLeftLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 80, -1));

        valueAttacksLeftLabel.setText("6");
        getContentPane().add(valueAttacksLeftLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void downButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downButtonActionPerformed
        MovementHandler.down();
        Game.updateGUI();
    }//GEN-LAST:event_downButtonActionPerformed

    private void btn_EndRoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EndRoundActionPerformed
        if( Game.getInstance().getMonsters().size() <= 0 ){
            Game.getInstance().nextLevel();
            System.out.println("NEXT LEVEL: " + Game.getInstance().getLevel());
        }else{
            //DoMonsters Turn HERE!!!
            
        }
        // Reset PLayerCharacter
        Game.getInstance().getPlayer().setAllowedMoves(
            //sollte eingerückt sein, ist ein Parameter
            Game.getInstance().getPlayer().getMovement()
        );
        Game.getInstance().getPlayer().setAllowedAttacks(1);
    }//GEN-LAST:event_btn_EndRoundActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       // reduce Player Health Test
        testHp = testHp-1;
        System.out.println(testHp);
        ((HealthBarLabel)playerHealthBarLabel).setHealthText(testHp);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void upButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upButtonActionPerformed
       MovementHandler.up();
       Game.updateGUI();
    }//GEN-LAST:event_upButtonActionPerformed

    private void rightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightButtonActionPerformed
        MovementHandler.right();
        Game.updateGUI();
    }//GEN-LAST:event_rightButtonActionPerformed

    private void leftButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftButtonActionPerformed
        MovementHandler.left();
        Game.updateGUI();
    }//GEN-LAST:event_leftButtonActionPerformed

    private void attackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attackButtonActionPerformed
        System.out.println("Attack");
        PlayerCharacter attacker = main.Game.getInstance().getPlayer();
        MonsterCharacter target = main.Game.getInstance().getMonsters().get(0);
        String tmpOutput = BattleHandler.tryToAttack(attacker, target);

        System.out.println(tmpOutput);
        Game.updateGUI();
    }//GEN-LAST:event_attackButtonActionPerformed

    private void changeInputTypeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeInputTypeButtonActionPerformed
        setButtonFocus(false);
    }//GEN-LAST:event_changeInputTypeButtonActionPerformed

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
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane arenaScrollPane;
    private javax.swing.JTextArea arenaTextArea;
    private javax.swing.JButton attackButton;
    private javax.swing.JTextArea attackInfoTextArea;
    private javax.swing.JLabel attackInfoTitleLabel;
    private javax.swing.JScrollPane attackScrollPane;
    private javax.swing.JButton btn_EndRound;
    private javax.swing.JButton changeInputTypeButton;
    private javax.swing.JButton downButton;
    private javax.swing.JLabel healthLabel;
    private javax.swing.JLabel inputInfoLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton leftButton;
    private javax.swing.JTextArea monsterInfoTextArea;
    private javax.swing.JLabel monsterInfoTitleLabel;
    private javax.swing.JScrollPane monsterScrollPane;
    private javax.swing.JLabel numberOfActionsLeftLabel1;
    private javax.swing.JLabel numberOfMovesLeftLabel;
    private javax.swing.JLabel playerHealthBarLabel;
    private javax.swing.JLabel playerNamelLabel;
    private javax.swing.JButton rightButton;
    private javax.swing.JButton upButton;
    private javax.swing.JLabel valueAttacksLeftLabel;
    private javax.swing.JLabel valueMovesLeftLabel;
    // End of variables declaration//GEN-END:variables

    private void initComponentList() {
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

    private void initFrameSetup() {
        this.setResizable(false);
        Dimension dimensions = new Dimension(900, 600);
        
        this.setPreferredSize(dimensions);
        this.setMinimumSize(dimensions);
        this.setMaximumSize(dimensions);
        
        this.addKeyListener(new KeyHandler());
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
    }

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
}