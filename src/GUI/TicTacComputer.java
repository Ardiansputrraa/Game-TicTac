package GUI;

import javax.naming.ldap.Control;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;
import java.awt.*;
import Interface.*;
import controller.Musik;
import controller.Player;

public class TicTacComputer implements InterfaceControl {

    private final static ImageIcon logo = new ImageIcon("src/img/logo.png");
    private Frame frame = new JFrame("Tic Tac");
    private JButton btnUlang;
    private JButton btnKeluar;
    private JButton btnMain[][] = new JButton[3][3];
    private JLabel pemainA, pemainB;
    private JPanel pemainJP[][] = new JPanel[3][3];
    private JLabel pemainJL[][] = new JLabel[3][3];
    private JButton musicOn, musicOff;
    private int giliran;
    private Player pemain = new Player();
    String[] hasil = new String[8];
    private Musik musik = new Musik();

    public TicTacComputer() {
        musik.getClip().start();
        initcomponents();
        pemainA.setText(pemain.getPlayerA());
        pemainB.setText("Computer");
        music();
        runGame();
        resetGame();
        cekGame();
    }

    public void initcomponents() {

        frame.setIconImage(logo.getImage());
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550, 550);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout(5, 5));
        ((JFrame) frame).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel panelAtas = new JPanel();
        panelAtas.setBackground(Color.BLACK);
        panelAtas.setLayout(new GridLayout(1, 0, 0, 0));
        panelAtas.setPreferredSize(new Dimension(550, 80));
        frame.add(panelAtas, BorderLayout.NORTH);

        pemainA = new JLabel("Player A");
        pemainA.setHorizontalAlignment(SwingConstants.LEFT);
        pemainA.setFont(new Font("Thoma", Font.BOLD, 18));
        pemainA.setForeground(Color.CYAN);
        panelAtas.add(pemainA);

        pemainB = new JLabel("Player B");
        pemainB.setHorizontalAlignment(SwingConstants.LEFT);
        pemainB.setFont(new Font("Thoma", Font.BOLD, 18));
        pemainB.setForeground(Color.white);
        panelAtas.add(pemainB);

        JPanel music = new JPanel();
        music.setLayout(null);
        music.setBackground(Color.BLACK);
        music.setPreferredSize(new Dimension(50, 30));
        music.setFont(new Font("Thoma", Font.BOLD, 20));
        panelAtas.add(music);

        musicOn = new JButton("Music On");
        musicOn.setPreferredSize(new Dimension(50, 30));
        musicOn.setHorizontalAlignment(SwingConstants.CENTER);
        musicOn.setFont(new Font("Thoma", Font.BOLD, 17));
        musicOn.setVisible(false);
        musicOn.setBounds(20, 20, 130, 35);
        music.add(musicOn);

        musicOff = new JButton("Music Off");
        musicOff.setPreferredSize(new Dimension(50, 30));
        musicOff.setHorizontalAlignment(SwingConstants.CENTER);
        musicOff.setFont(new Font("Thoma", Font.BOLD, 17));
        musicOff.setBounds(20, 20, 130, 35);
        music.add(musicOff);

        JPanel panelPemain = new JPanel();
        panelPemain.setLayout(new GridLayout(3, 3, 15, 15));
        frame.add(panelPemain, BorderLayout.CENTER);

        JPanel panelBawah = new JPanel();
        frame.add(panelBawah, BorderLayout.SOUTH);
        panelBawah.setLayout(new GridLayout(1, 0, 5, 0));

        btnUlang = new JButton("Reset");
        btnUlang.setBackground(Color.CYAN);
        btnUlang.setFont(new Font("Thoma", Font.BOLD, 23));
        panelBawah.add(btnUlang);

        btnKeluar = new JButton("Keluar");
        btnKeluar.setBackground(Color.RED);
        btnKeluar.setFont(new Font("Thoma", Font.BOLD, 23));
        panelBawah.add(btnKeluar);

        panelPemain.setLayout(new GridLayout(3, 3));
        for (int i = 0; i < btnMain[0].length; i++) {
            for (int j = 0; j < btnMain[0].length; j++) {
                btnMain[i][j] = new JButton();
                btnMain[i][j].setFont(new Font("Thoma", Font.BOLD, 75));
                btnMain[i][j].setBackground(Color.black);
                panelPemain.add(btnMain[i][j]);
                pemainJP[i][j] = new JPanel();
                pemainJP[i][j].setBackground(Color.black);
                pemainJP[i][j].setVisible(false);
                btnMain[i][j].add(pemainJP[i][j]);
                pemainJL[i][j] = new JLabel();
                pemainJL[i][j].setFont(new Font("Thoma", Font.BOLD, 75));
                pemainJP[i][j].add(pemainJL[i][j]);
            }
        }
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
            btnKeluar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == btnKeluar) {
                        frame.dispose();
                        musik.getClip().stop();
                        new Menu();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void runGame() {
        // TODO Auto-generated method stub
        for (int i = 0; i < getBtnMain()[0].length; i++) {
            for (int j = 0; j < getBtnMain()[0].length; j++) {
                getBtnMain()[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        for (int a = 0; a < 3; a++) {
                            for (int b = 0; b < 3; b++) {
                                if (e.getSource() == getBtnMain()[a][b]) {
                                    getBtnMain()[a][b].setText("O");
                                    getBtnMain()[a][b].setForeground(Color.CYAN);
                                    getBtnMain()[a][b].setEnabled(false);
                                    getPemainJP()[a][b].setVisible(true);
                                    getPemainJL()[a][b].setText("O");
                                    getPemainJL()[a][b].setForeground(Color.CYAN);
                                    cekGame();
                                    for (int c = 0; c < 8; c++) {
                                        if (hasil[c].equalsIgnoreCase("OOO")) {
                                            JOptionPane.showMessageDialog(null,
                                                    "Pemenangnya adalah " + pemain.getPlayerA());
                                            for (int i = 0; i < getBtnMain()[0].length; i++) {
                                                for (int j = 0; j < getBtnMain()[0].length; j++) {
                                                    getBtnMain()[i][j].setText("");
                                                    getBtnMain()[i][j].setEnabled(true);
                                                    getPemainJP()[i][j].setVisible(false);
                                                    getPemainJL()[i][j].setText("");
                                                    getPemainA().setForeground(Color.CYAN);
                                                    getPemainB().setForeground(Color.WHITE);
                                                }
                                            }
                                            return;
                                        }
                                    }
                                    for (int c = 0; c < Thread.MAX_PRIORITY; c++) {
                                        int randomA = (int) (Math.random() * 3);
                                        int randomB = (int) (Math.random() * 3);
                                        for (int d = 0; d < Thread.MAX_PRIORITY; d++) {
                                            if (getBtnMain()[randomA][randomB].getText().equalsIgnoreCase("X")
                                                    || getBtnMain()[randomA][randomB].getText()
                                                            .equalsIgnoreCase("O")) {
                                                continue;
                                            } else {
                                                getBtnMain()[randomA][randomB].setText("X");
                                                getBtnMain()[randomA][randomB].setForeground(Color.RED);
                                                getBtnMain()[randomA][randomB].setEnabled(false);
                                                getPemainJP()[randomA][randomB].setVisible(true);
                                                getPemainJL()[randomA][randomB].setText("X");
                                                getPemainJL()[randomA][randomB].setForeground(Color.RED);
                                                getPemainA().setForeground(Color.CYAN);
                                                getPemainB().setForeground(Color.WHITE);
                                                cekGame();
                                                return;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    @Override
    public void resetGame() {
        // TODO Auto-generated method stub
        getBtnUlang().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == getBtnUlang()) {
                    for (int i = 0; i < getBtnMain()[0].length; i++) {
                        for (int j = 0; j < getBtnMain()[0].length; j++) {
                            getBtnMain()[i][j].setText("");
                            getBtnMain()[i][j].setEnabled(true);
                            getPemainJP()[i][j].setVisible(false);
                            getPemainJL()[i][j].setText("");
                            getPemainA().setForeground(Color.CYAN);
                            getPemainB().setForeground(Color.WHITE);
                        }
                    }
                }

            }
        });
    }

    @Override
    public void cekGame() {
        String pemenang = "";
        hasil[0] = btnMain[0][0].getText() + btnMain[0][1].getText() + btnMain[0][2].getText();
        hasil[1] = btnMain[1][0].getText() + btnMain[1][1].getText() + btnMain[1][2].getText();
        hasil[2] = btnMain[2][0].getText() + btnMain[2][1].getText() + btnMain[2][2].getText();
        hasil[3] = btnMain[0][0].getText() + btnMain[1][0].getText() + btnMain[2][0].getText();
        hasil[4] = btnMain[0][1].getText() + btnMain[1][1].getText() + btnMain[2][1].getText();
        hasil[5] = btnMain[0][2].getText() + btnMain[1][2].getText() + btnMain[2][2].getText();
        hasil[6] = btnMain[0][0].getText() + btnMain[1][1].getText() + btnMain[2][2].getText();
        hasil[7] = btnMain[0][2].getText() + btnMain[1][1].getText() + btnMain[2][0].getText();
        for (int a = 0; a < 8; a++) {
            if (hasil[a].equalsIgnoreCase("XXX") || hasil[a].equalsIgnoreCase("OOO")) {
                if (hasil[a].equalsIgnoreCase("XXX")) {
                    JOptionPane.showMessageDialog(null, "Pemenangnya adalah Computer");
                    for (int i = 0; i < getBtnMain()[0].length; i++) {
                        for (int j = 0; j < getBtnMain()[0].length; j++) {
                            getBtnMain()[i][j].setText("");
                            getBtnMain()[i][j].setEnabled(true);
                            getPemainJP()[i][j].setVisible(false);
                            getPemainJL()[i][j].setText("");
                            getPemainA().setForeground(Color.CYAN);
                            getPemainB().setForeground(Color.WHITE);
                        }
                    }
                    return;
                }
            }
        }
    }

    public JFrame getframe() {
        return (JFrame) this.frame;
    }

    public JButton[][] getBtnMain() {
        return this.btnMain;
    }

    public JPanel[][] getPemainJP() {
        return this.pemainJP;
    }

    public JButton getBtnUlang() {
        return this.btnUlang;
    }

    public JButton getBtnKeluar() {
        return this.btnKeluar;
    }

    public JLabel getPemainA() {
        return this.pemainA;
    }

    public JLabel getPemainB() {
        return this.pemainB;
    }

    public JLabel[][] getPemainJL() {
        return this.pemainJL;
    }

    public static ImageIcon getLogo() {
        return logo;
    }

    public JButton getMusicOn() {
        return musicOn;
    }

    public JButton getMusicOff() {
        return musicOff;
    }

    public int getGiliran() {
        return this.giliran;
    }

    public void setGiliran(int giliran) {
        this.giliran = giliran;
    }

    public Frame getFrame() {
        return frame;
    }

    public Player getPemain() {
        return pemain;
    }

    public String[] getHasil() {
        return hasil;
    }

}
