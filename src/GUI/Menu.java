/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import controller.*;

/**
 *
 * @author User
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    private final static ImageIcon logo = new ImageIcon("src/img/logo.png");
    private static final File file = new File("src/sound/music.wav");
    private AudioInputStream audioInputStream;
    private Clip clip;
    private Player pemain;
    private Musik musik = new Musik();


    public Menu() {
        this.setTitle("Tic Tac");
        this.setIconImage(logo.getImage());
        this.setVisible(true);
        //this.setResizable(false);
        this.setIconImage(logo.getImage());
        musik.getClip().start();
        initComponents();
        button.setVisible(false);
        musicOn.setVisible(false);
        vsComputer.setVisible(false);
        vsPlayer.setVisible(false);
        addPlaceholderStyle(player);
        addPlaceholderStyle(playerA);
        addPlaceholderStyle(playerB);
        music();

    }

    public void addPlaceholderStyle(JTextField textField) {
        Font font = textField.getFont();
        font = font.deriveFont(Font.ITALIC);
        textField.setFont(font);
        textField.setForeground(Color.BLACK);
    }

    public void removePlaceholderStyle(JTextField textField) {
        Font font = textField.getFont();
        // font = font.deriveFont(Font.PLAIN|Font.BOLD);
        textField.setFont(font);
        textField.setForeground(Color.black);
    }

    public void music() {
        try {
            musicOn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == musicOn) {
                        musicOn.setVisible(false);
                        musicOff.setVisible(true);
                        musik.getClip().start();
                        musik.getClip().loop(Clip.LOOP_CONTINUOUSLY);
                    }
                }
            });
            musicOff.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == musicOff) {
                        musicOff.setVisible(false);
                        musicOn.setVisible(true);
                        musik.getClip().stop();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        musicOff = new javax.swing.JButton();
        musicOn = new javax.swing.JButton();
        next = new javax.swing.JButton();
        select = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        selectPlayer = new javax.swing.JComboBox<>();
        vsComputer = new javax.swing.JLayeredPane();
        jPanel2 = new javax.swing.JPanel();
        player = new javax.swing.JTextField();
        vsPlayer = new javax.swing.JLayeredPane();
        jPanel3 = new javax.swing.JPanel();
        playerA = new javax.swing.JTextField();
        playerB = new javax.swing.JTextField();
        button = new javax.swing.JLayeredPane();
        play = new javax.swing.JButton();
        back = new javax.swing.JButton();
        menu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        musicOff.setBackground(new java.awt.Color(51, 204, 255));
        musicOff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sound off.png"))); // NOI18N
        getContentPane().add(musicOff, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 90, 80));

        musicOn.setBackground(new java.awt.Color(102, 204, 255));
        musicOn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sound on.png"))); // NOI18N
        getContentPane().add(musicOn, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 90, 80));

        next.setBackground(new java.awt.Color(0, 0, 0));
        next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/next.png"))); // NOI18N
        next.setBorder(null);
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });
        getContentPane().add(next, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, 100, 97));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        selectPlayer.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        selectPlayer.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Player vs Player", "Player vs Computer" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(selectPlayer, 0, 254, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(selectPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(40, Short.MAX_VALUE)));

        select.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout selectLayout = new javax.swing.GroupLayout(select);
        select.setLayout(selectLayout);
        selectLayout.setHorizontalGroup(
                selectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 260, Short.MAX_VALUE)
                        .addGroup(selectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)));
        selectLayout.setVerticalGroup(
                selectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 190, Short.MAX_VALUE)
                        .addGroup(selectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(selectLayout.createSequentialGroup()
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))));

        getContentPane().add(select, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 260, 190));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        player.setFont(new java.awt.Font("Segoe UI", 2, 20)); // NOI18N
        player.setText("Player Name");
        player.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                playerFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                playerFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(player, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                                .addContainerGap()));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(83, Short.MAX_VALUE)
                                .addComponent(player, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)));

        vsComputer.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout vsComputerLayout = new javax.swing.GroupLayout(vsComputer);
        vsComputer.setLayout(vsComputerLayout);
        vsComputerLayout.setHorizontalGroup(
                vsComputerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 260, Short.MAX_VALUE)
                        .addGroup(vsComputerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)));
        vsComputerLayout.setVerticalGroup(
                vsComputerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 200, Short.MAX_VALUE)
                        .addGroup(vsComputerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(vsComputerLayout.createSequentialGroup()
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))));

        getContentPane().add(vsComputer, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 260, 200));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        playerA.setFont(new java.awt.Font("Segoe UI", 2, 20)); // NOI18N
        playerA.setText("Player Name 1");
        playerA.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                playerAFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                playerAFocusLost(evt);
            }
        });

        playerB.setFont(new java.awt.Font("Segoe UI", 2, 20)); // NOI18N
        playerB.setText("Player Name 2");
        playerB.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                playerBFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                playerBFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(playerA, javax.swing.GroupLayout.DEFAULT_SIZE, 248,
                                                Short.MAX_VALUE)
                                        .addComponent(playerB, javax.swing.GroupLayout.DEFAULT_SIZE, 248,
                                                Short.MAX_VALUE))
                                .addContainerGap()));
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(playerA, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(playerB, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(18, Short.MAX_VALUE)));

        vsPlayer.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout vsPlayerLayout = new javax.swing.GroupLayout(vsPlayer);
        vsPlayer.setLayout(vsPlayerLayout);
        vsPlayerLayout.setHorizontalGroup(
                vsPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 260, Short.MAX_VALUE)
                        .addGroup(vsPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)));
        vsPlayerLayout.setVerticalGroup(
                vsPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 190, Short.MAX_VALUE)
                        .addGroup(vsPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(vsPlayerLayout.createSequentialGroup()
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))));

        getContentPane().add(vsPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 260, 190));

        play.setBackground(new java.awt.Color(0, 0, 0));
        play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/play.png"))); // NOI18N
        play.setBorder(null);
        play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playActionPerformed(evt);
            }
        });

        back.setBackground(new java.awt.Color(0, 0, 0));
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back.png"))); // NOI18N
        back.setBorder(null);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        button.setLayer(play, javax.swing.JLayeredPane.DEFAULT_LAYER);
        button.setLayer(back, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout buttonLayout = new javax.swing.GroupLayout(button);
        button.setLayout(buttonLayout);
        buttonLayout.setHorizontalGroup(
                buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(buttonLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 93,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55,
                                        Short.MAX_VALUE)
                                .addComponent(play, javax.swing.GroupLayout.PREFERRED_SIZE, 92,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));
        buttonLayout.setVerticalGroup(
                buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(buttonLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(play, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(14, Short.MAX_VALUE)));

        getContentPane().add(button, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 260, 120));

        menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/home.png"))); // NOI18N
        getContentPane().add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, -1, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_playActionPerformed
        // TODO add your handling code here:
        musik.getClip().stop();
        this.dispose();
        if (selectPlayer.getSelectedIndex() == 0) {
            pemain = new Player(playerA.getText(), playerB.getText());
            new TicTacPlayer();
        } else {
            pemain = new Player(player.getText());
            new TicTacComputer();
        }

    }// GEN-LAST:event_playActionPerformed

    private void playerFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_playerFocusGained
        // TODO add your handling code here:
        if (player.getText().equals("Player Name")) {
            player.setText("");
            player.requestFocus();
            removePlaceholderStyle(player);
        }
    }// GEN-LAST:event_playerFocusGained

    private void playerFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_playerFocusLost
        // TODO add your handling code here:
        if (player.getText().length() == 0) {
            addPlaceholderStyle(player);
            player.setText("Player Name");
        }
    }// GEN-LAST:event_playerFocusLost

    private void playerAFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_playerAFocusGained
        // TODO add your handling code here:
        if (playerA.getText().equals("Player Name 1")) {
            playerA.setText("");
            playerA.requestFocus();
            removePlaceholderStyle(playerA);
        }
    }// GEN-LAST:event_playerAFocusGained

    private void playerAFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_playerAFocusLost
        // TODO add your handling code here:
        if (playerA.getText().length() == 0) {
            addPlaceholderStyle(playerA);
            playerA.setText("Player Name 1");
        }
    }// GEN-LAST:event_playerAFocusLost

    private void playerBFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_playerBFocusGained
        // TODO add your handling code here:
        if (playerB.getText().equals("Player Name 2")) {
            playerB.setText("");
            playerB.requestFocus();
            removePlaceholderStyle(playerB);
        }
    }// GEN-LAST:event_playerBFocusGained

    private void playerBFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_playerBFocusLost
        // TODO add your handling code here:
        if (playerB.getText().length() == 0) {
            addPlaceholderStyle(playerB);
            playerB.setText("Player Name 2");
        }
    }// GEN-LAST:event_playerBFocusLost

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_nextActionPerformed
        // TODO add your handling code here:
        if (selectPlayer.getSelectedIndex() == 0) {
            next.setVisible(false);
            vsPlayer.setVisible(true);
            vsComputer.setVisible(false);
            select.setVisible(false);
            button.setVisible(true);
        } else if (selectPlayer.getSelectedIndex() == 1) {
            next.setVisible(false);
            vsPlayer.setVisible(false);
            vsComputer.setVisible(true);
            select.setVisible(false);
            button.setVisible(true);
        }
    }// GEN-LAST:event_nextActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        next.setVisible(true);
        vsPlayer.setVisible(false);
        vsComputer.setVisible(false);
        select.setVisible(true);
        button.setVisible(false);
    }// GEN-LAST:event_backActionPerformed

    public static ImageIcon getLogo() {
        return logo;
    }

    public static File getFile() {
        return file;
    }

    public AudioInputStream getAudioInputStream() {
        return audioInputStream;
    }

    public Clip getClip() {
        return clip;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLayeredPane button;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel menu;
    private javax.swing.JButton musicOff;
    private javax.swing.JButton musicOn;
    private javax.swing.JButton next;
    private javax.swing.JButton play;
    public javax.swing.JTextField player;
    public javax.swing.JTextField playerA;
    public javax.swing.JTextField playerB;
    private javax.swing.JLayeredPane select;
    public javax.swing.JComboBox<String> selectPlayer;
    private javax.swing.JLayeredPane vsComputer;
    private javax.swing.JLayeredPane vsPlayer;
    // End of variables declaration//GEN-END:variables
}
