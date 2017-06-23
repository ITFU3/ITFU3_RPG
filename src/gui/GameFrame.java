/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package gui;

import Base.UserInfo;
import gameHandler.InputHandler;
import gui.GuiHelper.HealthBarLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.text.DefaultCaret;
import main.Game;
import main.Map;

/**
 *
 * @author steffen
 */
public class GameFrame extends JFrame{
    
    // UI Components
    HealthBarLabel playerHealthBarLabel = new HealthBarLabel(Game.getPlayer().getHealth());
    
    JButton spellCastButton = new javax.swing.JButton();
    JButton upButton = new javax.swing.JButton();
    JButton rightButton = new javax.swing.JButton();
    JButton leftButton = new javax.swing.JButton();
    JButton changeInputTypeButton = new javax.swing.JButton();
    JButton downButton = new javax.swing.JButton();
    JButton btn_EndRound = new javax.swing.JButton();
    
    
    JLabel healthLabel = new javax.swing.JLabel();
    JLabel playerNamelLabel = new javax.swing.JLabel();
    JLabel monsterInfoTitleLabel = new javax.swing.JLabel();
    JLabel arenaTitleLabel = new javax.swing.JLabel();
    JLabel inputInfoLabel = new javax.swing.JLabel();
    JLabel numberOfMovesLeftLabel = new javax.swing.JLabel();
    JLabel valueMovesLeftLabel = new javax.swing.JLabel();
    
    JLabel numberOfAttacksLeftLabel1 = new javax.swing.JLabel();
    JLabel valueAttacksLeftLabel = new javax.swing.JLabel();
    JLabel currentActiveCharLabel = new javax.swing.JLabel();
    JLabel roundLabel = new javax.swing.JLabel();
    JLabel levelLabel = new javax.swing.JLabel();
    JLabel experienceTitelLabel = new javax.swing.JLabel();
    JLabel experienceValueLabel = new javax.swing.JLabel();
    
    JButton attackButton = new javax.swing.JButton();
    JScrollPane areanaJScrollPane = new javax.swing.JScrollPane();
    JTextArea arenaTextArea = new javax.swing.JTextArea();
    
    JScrollPane keyInforScrollPane = new javax.swing.JScrollPane();
    JTextArea keyInfoTextArea = new javax.swing.JTextArea();
    
    JScrollPane monsterScrollPane = new javax.swing.JScrollPane();
    JTextArea monsterInfoTextArea = new javax.swing.JTextArea();
    
    JScrollPane attackJScrollPane = new javax.swing.JScrollPane();
    JTextArea attackInfoTextArea = new javax.swing.JTextArea();
    
    
    ArrayList<JComponent> components = new ArrayList();
    int testHp = Game.getPlayer().getHealth();
    
    int xPosition;
    int yPosition;
    
    /**
     * Creates new form GameFrame
     */
    public GameFrame() {
        initFrameSetup();
        initComponents();
 
        this.initButtonList();
        
        // needed for keyboard to work
        this.setButtonFocus(false);
        
        // add the Listener for WindowClosing
        this.addWindowListener();
        
        
        // Show Frame
        this.setVisible(true);
    }
    
    /**
     *
     */
    private void initFrameSetup() {
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        this.setResizable(false);
        Dimension dimensions = new Dimension(900, 700);
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
        
    }
    
    private void initComponents() {
        
        // Arean Setup
        this.arenaTextArea.setText( new Map().getMap());
        this.arenaTextArea.setEnabled(false);
        this.arenaTextArea.setFocusable(false);
        this.arenaTextArea.setDisabledTextColor(Color.BLACK);
        this.arenaTextArea.setFont( new java.awt.Font("Courier New", 0, 19) );
        this.arenaTextArea.setColumns(20);
        this.arenaTextArea.setRows(5);
        this.areanaJScrollPane.setViewportView(arenaTextArea);
        getContentPane().add(areanaJScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 460, 310));
        
        // Attack Info Setup
        this.attackInfoTextArea.setColumns(20);
        this.attackInfoTextArea.setRows(5);
        this.attackInfoTextArea.setText(Game.getInstance().attackInfo);
        this.attackInfoTextArea.setEnabled(false);
        this.attackInfoTextArea.setFocusable(false);
        this.attackInfoTextArea.setDisabledTextColor(Color.BLACK);
        this.attackInfoTextArea.setFont( new java.awt.Font("Courier New", 0, 13) );
        this.attackJScrollPane.setViewportView(attackInfoTextArea);
        getContentPane().add(attackJScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, 460, 170));
        DefaultCaret caret = (DefaultCaret)attackInfoTextArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        
        // Monster Info Setup
        this.monsterInfoTextArea.setText(Game.getInstance().getMonsterInfo());
        this.monsterInfoTextArea.setEnabled(false);
        this.monsterInfoTextArea.setFocusable(false);
        this.monsterInfoTextArea.setDisabledTextColor(Color.BLACK);
        this.monsterInfoTextArea.setFont( new java.awt.Font("Courier New", 0, 13) );
        this.monsterInfoTextArea.setColumns(20);
        this.monsterInfoTextArea.setRows(5);
        monsterScrollPane.setViewportView(monsterInfoTextArea);
        getContentPane().add(monsterScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 50, 200, 220));
        
        // KeyInfoSetup
        this.keyInfoTextArea.setColumns(20);
        this.keyInfoTextArea.setRows(5);
        this.keyInforScrollPane.setViewportView(keyInfoTextArea);
        this.keyInfoTextArea.setText(UserInfo.KEYS);
        this.keyInfoTextArea.setEnabled(false);
        this.keyInfoTextArea.setFocusable(false);
        this.keyInfoTextArea.setDisabledTextColor(Color.BLACK);
        this.keyInfoTextArea.setFont( new java.awt.Font("Courier New", 0, 13) );
        getContentPane().add(keyInforScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 330, 200, 300));
        
        // Labels
        healthLabel.setText("Health");
        getContentPane().add(healthLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 200, -1));
        
        this.playerNamelLabel.setFont(new Font("Courier New", Font.BOLD, 15));
        this.playerNamelLabel.setText(Game.getPlayer().getName());
        
        this.currentActiveCharLabel.setText( Game.getPlayer().getName()+ "'s turn");
        
        this.valueMovesLeftLabel.setText( Game.getPlayer().getAllowedMoves() + "" );
        this.valueAttacksLeftLabel.setText( Game.getPlayer().getAllowedAttacks() + "" );
        
        this.experienceValueLabel.setText(Game.getPlayer().getExperience() + "");
        
        // init Healthbar
        this.playerHealthBarLabel.setHealthText(
                Game.getPlayer().getHealth()
        );
      
        getContentPane().add(playerHealthBarLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 200, -1));
        
        playerNamelLabel.setText(Game.getPlayer().getName());
        getContentPane().add(playerNamelLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 200, -1));
        
        monsterInfoTitleLabel.setText("Monster");
        getContentPane().add(monsterInfoTitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, 170, 20));
        
        
        arenaTitleLabel.setText("Arena");
        getContentPane().add(arenaTitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 90, -1));
        
        inputInfoLabel.setText("KeyboardInput");
        getContentPane().add(inputInfoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 280, 90, 10));
        
        numberOfMovesLeftLabel.setText("Movement left:");
        getContentPane().add(numberOfMovesLeftLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 110, -1));
        
        valueMovesLeftLabel.setText(String.valueOf(Game.getPlayer().getMovement()));
        getContentPane().add(valueMovesLeftLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, -1, -1));
        
        numberOfAttacksLeftLabel1.setText("Attacks left:");
        getContentPane().add(numberOfAttacksLeftLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 80, -1));
        
        valueAttacksLeftLabel.setText(String.valueOf(Game.getPlayer().getAttacks()+"/"+Game.getPlayer().getAttacks()));
        getContentPane().add(valueAttacksLeftLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, -1, -1));
        
        this.currentActiveCharLabel.setText( Game.getPlayer().getName()+ "'s turn");
        getContentPane().add(currentActiveCharLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));
        
        roundLabel.setText("Round 1");
        getContentPane().add(roundLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));
        
        levelLabel.setText("Level 1");
        getContentPane().add(levelLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, -1));
        
        experienceTitelLabel.setText("Experience");
        getContentPane().add(experienceTitelLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));
        
        experienceValueLabel.setText("0");
        getContentPane().add(experienceValueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));
        
        // Buttons
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
        
        spellCastButton.setText("jButton1");
        spellCastButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                castSpellActionPerformed(evt);
            }
        });
        getContentPane().add(spellCastButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 620, -1, -1));
        
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
        
        attackButton.setText("Attack");
        attackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attackButtonActionPerformed(evt);
            }
        });
        getContentPane().add(attackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 650, 470, -1));
        
        changeInputTypeButton.setText("Keyboard");
        changeInputTypeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeInputTypeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(changeInputTypeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 300, -1, 30));
        pack();
    }
    
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
        components.add(spellCastButton);
        components.add(changeInputTypeButton);
        //scrollpanes
        components.add(areanaJScrollPane);
        components.add(monsterScrollPane);
        components.add(attackJScrollPane);
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
    
    /**
     * Movementcontrol of the Character via mouse
     * @param evt
     */
    private void downButtonActionPerformed(java.awt.event.ActionEvent evt) {
        InputHandler.moveDown();
    }
    
    /**
     * Movementcontrol of the Character via mouse
     * @param evt
     */
    private void leftButtonActionPerformed(java.awt.event.ActionEvent evt) {
        InputHandler.moveLeft();
    }
    
    /**
     * Attack command via mouse
     * @param evt
     */
    private void attackButtonActionPerformed(java.awt.event.ActionEvent evt) {
        InputHandler.attack();
    }
    
    /**
     * Change the Input Type back to Keyboard.
     * @param evt
     */
    private void changeInputTypeButtonActionPerformed(java.awt.event.ActionEvent evt) {
        InputHandler.setControlFocus(true);
    }
    
    /**
     * Movementcontrol of the Character via mouse
     * @param evt
     */
    private void upButtonActionPerformed(java.awt.event.ActionEvent evt) {
        InputHandler.moveUp();
    }
    
    /**
     * Movementcontrol of the Character via mouse
     * @param evt
     */
    private void rightButtonActionPerformed(java.awt.event.ActionEvent evt) {
        InputHandler.moveUp();
    }
    
    /**
     * Testing purpose
     * @param evt
     */
    private void castSpellActionPerformed(java.awt.event.ActionEvent evt) {
//        // reduce Player Health Test
//        testHp = testHp-1;
//        System.out.println(testHp);
//        ((HealthBarLabel)playerHealthBarLabel).setHealthText(testHp);
        InputHandler.openCloseSpellbook();
    }
    
    /**
     * Ending the Turn of the Player.
     * Starts the Turn of the Monster.
     * @param evt
     */
    private void btn_EndRoundActionPerformed(java.awt.event.ActionEvent evt) {
        InputHandler.endRound();
    }
    
    public HealthBarLabel getPlayerHealthBarLabel() {
        return playerHealthBarLabel;
    }
    
    public void setPlayerHealthBarLabel(HealthBarLabel playerHealthBarLabel) {
        this.playerHealthBarLabel = playerHealthBarLabel;
    }
    
    public JButton getjButton1() {
        return spellCastButton;
    }
    
    public void setjButton1(JButton jButton1) {
        this.spellCastButton = jButton1;
    }
    
    public JButton getUpButton() {
        return upButton;
    }
    
    public void setUpButton(JButton upButton) {
        this.upButton = upButton;
    }
    
    public JButton getRightButton() {
        return rightButton;
    }
    
    public void setRightButton(JButton rightButton) {
        this.rightButton = rightButton;
    }
    
    public JButton getLeftButton() {
        return leftButton;
    }
    
    public void setLeftButton(JButton leftButton) {
        this.leftButton = leftButton;
    }
    
    public JButton getChangeInputTypeButton() {
        return changeInputTypeButton;
    }
    
    public void setChangeInputTypeButton(JButton changeInputTypeButton) {
        this.changeInputTypeButton = changeInputTypeButton;
    }
    
    public JButton getDownButton() {
        return downButton;
    }
    
    public void setDownButton(JButton downButton) {
        this.downButton = downButton;
    }
    
    public JButton getBtn_EndRound() {
        return btn_EndRound;
    }
    
    public void setBtn_EndRound(JButton btn_EndRound) {
        this.btn_EndRound = btn_EndRound;
    }
    
    public JLabel getHealthLabel() {
        return healthLabel;
    }
    
    public void setHealthLabel(JLabel healthLabel) {
        this.healthLabel = healthLabel;
    }
    
    public JLabel getPlayerNamelLabel() {
        return playerNamelLabel;
    }
    
    public void setPlayerNamelLabel(JLabel playerNamelLabel) {
        this.playerNamelLabel = playerNamelLabel;
    }
    
    public JLabel getMonsterInfoTitleLabel() {
        return monsterInfoTitleLabel;
    }
    
    public void setMonsterInfoTitleLabel(JLabel monsterInfoTitleLabel) {
        this.monsterInfoTitleLabel = monsterInfoTitleLabel;
    }
    
    public JLabel getArenaTitleLabel() {
        return arenaTitleLabel;
    }
    
    public void setArenaTitleLabel(JLabel arenaTitleLabel) {
        this.arenaTitleLabel = arenaTitleLabel;
    }
    
    public JLabel getInputInfoLabel() {
        return inputInfoLabel;
    }
    
    public void setInputInfoLabel(JLabel inputInfoLabel) {
        this.inputInfoLabel = inputInfoLabel;
    }
    
    public JLabel getNumberOfMovesLeftLabel() {
        return numberOfMovesLeftLabel;
    }
    
    public void setNumberOfMovesLeftLabel(JLabel numberOfMovesLeftLabel) {
        this.numberOfMovesLeftLabel = numberOfMovesLeftLabel;
    }
    
    public JLabel getValueMovesLeftLabel() {
        return valueMovesLeftLabel;
    }
    
    public void setValueMovesLeftLabel(JLabel valueMovesLeftLabel) {
        this.valueMovesLeftLabel = valueMovesLeftLabel;
    }
    
    public JButton getSpellCastButton() {
        return spellCastButton;
    }
    
    public void setSpellCastButton(JButton spellCastButton) {
        this.spellCastButton = spellCastButton;
    }
    
    public JLabel getNumberOfAttacksLeftLabel() {
        return numberOfAttacksLeftLabel1;
    }
    
    public void setNumberOfAttacksLeftLabel1(JLabel numberOfAttacksLeftLabel1) {
        this.numberOfAttacksLeftLabel1 = numberOfAttacksLeftLabel1;
    }
    
    public JLabel getValueAttacksLeftLabel() {
        return valueAttacksLeftLabel;
    }
    
    public void setValueAttacksLeftLabel(JLabel valueAttacksLeftLabel) {
        this.valueAttacksLeftLabel = valueAttacksLeftLabel;
    }
    
    public JLabel getCurrentActiveCharLabel() {
        return currentActiveCharLabel;
    }
    
    public void setCurrentActiveCharLabel(JLabel currentActiveCharLabel) {
        this.currentActiveCharLabel = currentActiveCharLabel;
    }
    
    public JLabel getRoundLabel() {
        return roundLabel;
    }
    
    public void setRoundLabel(JLabel roundLabel) {
        this.roundLabel = roundLabel;
    }
    
    public JLabel getLevelLabel() {
        return levelLabel;
    }
    
    public void setLevelLabel(JLabel levelLabel) {
        this.levelLabel = levelLabel;
    }
    
    public JLabel getExperienceTitelLabel() {
        return experienceTitelLabel;
    }
    
    public void setExperienceTitelLabel(JLabel experienceTitelLabel) {
        this.experienceTitelLabel = experienceTitelLabel;
    }
    
    public JLabel getExperienceValueLabel() {
        return experienceValueLabel;
    }
    
    public void setExperienceValueLabel(JLabel experienceValueLabel) {
        this.experienceValueLabel = experienceValueLabel;
    }
    
    public JButton getAttackButton() {
        return attackButton;
    }
    
    public void setAttackButton(JButton attackButton) {
        this.attackButton = attackButton;
    }
    
    public JScrollPane getAttackScrollPane() {
        return areanaJScrollPane;
    }
    
    public void setAttackScrollPane(JScrollPane attackScrollPane) {
        this.areanaJScrollPane = attackScrollPane;
    }
    
    public JTextArea getArenaTextArea() {
        return arenaTextArea;
    }
    
    public void setArenaTextArea(JTextArea arenaTextArea) {
        this.arenaTextArea = arenaTextArea;
    }
    
    public JScrollPane getjScrollPane1() {
        return keyInforScrollPane;
    }
    
    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.keyInforScrollPane = jScrollPane1;
    }
    
    public JTextArea getKeyInfoTextArea() {
        return keyInfoTextArea;
    }
    
    public void setKeyInfoTextArea(JTextArea keyInfoTextArea) {
        this.keyInfoTextArea = keyInfoTextArea;
    }
    
    public JScrollPane getMonsterScrollPane() {
        return monsterScrollPane;
    }
    
    public void setMonsterScrollPane(JScrollPane monsterScrollPane) {
        this.monsterScrollPane = monsterScrollPane;
    }
    
    public JTextArea getMonsterInfoTextArea() {
        return monsterInfoTextArea;
    }
    
    public void setMonsterInfoTextArea(JTextArea monsterInfoTextArea) {
        this.monsterInfoTextArea = monsterInfoTextArea;
    }
    
    public JScrollPane getArenaScrollPane() {
        return attackJScrollPane;
    }
    
    public void setArenaScrollPane(JScrollPane arenaScrollPane) {
        this.attackJScrollPane = arenaScrollPane;
    }
    
    public JTextArea getAttackInfoTextArea() {
        return attackInfoTextArea;
    }
    
    public void setAttackInfoTextArea(JTextArea attackInfoTextArea) {
        this.attackInfoTextArea = attackInfoTextArea;
    }
    
    public int getTestHp() {
        return testHp;
    }
    
    public void setTestHp(int testHp) {
        this.testHp = testHp;
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
    
    
    
}
