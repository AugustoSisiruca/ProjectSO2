/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import Funciones.AudioManager;
import Funciones.ImageMovie;
import proyecto2.App;
import javax.swing.ImageIcon;
import javax.swing.JSlider;

/**
 *
 * @author author
 */
public class Home extends javax.swing.JFrame {
    
    private ImageMovie imageUtils = new ImageMovie();
    private AudioManager audioManager;
    App app = App.getInstance();

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        //Seteo del audioManager
        this.audioManager = new AudioManager(); 
        audioManager.playMusic("/GUI/Assets/backgroundSound.wav");
        
        ImageIcon cartoonNetworkLogo = imageUtils.loadScaledImage("/GUI/Assets/StarWars/logo.png", 140, 80);
        ImageIcon nickelodeonLogo = imageUtils.loadScaledImage("/GUI/Assets/StarTrek/logo.png", 120, 80);
        
        tvPanelUI1.getLogo().setIcon(cartoonNetworkLogo);
        tvPanelUI2.getLogo().setIcon(nickelodeonLogo);
        tvPanelUI1.getLogo().setText("");
        tvPanelUI2.getLogo().setText("");
        iaStatusLabel.setText("");
        WinnerLabelID.setText("");
        
        // Se setean las imagenes que la lucha en la IA.
        //ImageIcon regularShowCardIA=  imageUtils.loadScaledImage(app.getIaArena().getRegularShowFighter().getUrlSource(), 150, 200);
        //this.StarWarsCard.setIcon(regularShowCardIA);
        //ImageIcon avatarCardIA=  imageUtils.loadScaledImage(app.getIaArena().getAvatarFighter().getUrlSource(), 150, 200);
        //this.StarTrek.setIcon(avatarCardIA);
        // Se configura el slider 
        battleDuration.setOpaque(false);
        battleDuration.setMinimum(1);
        battleDuration.setMaximum(20);
        battleDuration.setValue(App.getBattleDuration());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        FightingTitle = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        roundLabel = new javax.swing.JLabel();
        iaStatusLabel = new javax.swing.JLabel();
        battleDuration = new javax.swing.JSlider();
        clockVelocity = new javax.swing.JLabel();
        WinnerLabelID = new javax.swing.JLabel();
        Winner1 = new javax.swing.JLabel();
        fighterUI1 = new Interfaz.FighterUI();
        fighterUI2 = new Interfaz.FighterUI();
        tvPanelUI1 = new Interfaz.TvPanelUI();
        tvPanelUI2 = new Interfaz.TvPanelUI();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setMinimumSize(new java.awt.Dimension(1130, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        FightingTitle.setFont(new java.awt.Font("Castellar", 1, 36)); // NOI18N
        FightingTitle.setForeground(new java.awt.Color(255, 255, 255));
        FightingTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FightingTitle.setText("STAR WARS VS STAR TREK");
        jPanel1.add(FightingTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 10, 700, -1));

        jPanel2.setBackground(new java.awt.Color(0, 0, 51));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        roundLabel.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        roundLabel.setForeground(new java.awt.Color(255, 255, 255));
        roundLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        roundLabel.setText("Round: 0");

        iaStatusLabel.setFont(new java.awt.Font("Castellar", 1, 17)); // NOI18N
        iaStatusLabel.setForeground(new java.awt.Color(255, 255, 255));
        iaStatusLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iaStatusLabel.setText("IA STATUS LABEL");
        iaStatusLabel.setToolTipText("");

        battleDuration.setBackground(new java.awt.Color(0, 0, 51));
        battleDuration.setForeground(new java.awt.Color(255, 255, 255));
        battleDuration.setMajorTickSpacing(9);
        battleDuration.setMaximum(20);
        battleDuration.setMinimum(1);
        battleDuration.setMinorTickSpacing(1);
        battleDuration.setPaintLabels(true);
        battleDuration.setPaintTicks(true);
        battleDuration.setToolTipText("Slider de Velocidad");
        battleDuration.setValue(10);
        battleDuration.setOpaque(true);
        battleDuration.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                battleDurationStateChanged(evt);
            }
        });
        battleDuration.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                battleDurationMouseClicked(evt);
            }
        });

        clockVelocity.setFont(new java.awt.Font("Century", 1, 16)); // NOI18N
        clockVelocity.setForeground(new java.awt.Color(255, 255, 255));
        clockVelocity.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clockVelocity.setText("AJUSTE LA VELOCIDAD ");

        WinnerLabelID.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        WinnerLabelID.setForeground(new java.awt.Color(255, 255, 255));
        WinnerLabelID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        WinnerLabelID.setText("Ganador");

        Winner1.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        Winner1.setForeground(new java.awt.Color(255, 255, 255));
        Winner1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Winner1.setText("Ganador:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(roundLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(iaStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(clockVelocity, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Winner1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(WinnerLabelID, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(fighterUI1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fighterUI2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(battleDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(clockVelocity)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(battleDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iaStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fighterUI1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fighterUI2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(Winner1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(WinnerLabelID, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 400, 730));
        jPanel1.add(tvPanelUI1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 60, 370, 740));
        jPanel1.add(tvPanelUI2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 370, 740));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void battleDurationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_battleDurationMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_battleDurationMouseClicked

    private void battleDurationStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_battleDurationStateChanged
        // TODO add your handling code here:
        int newSpeed = getBattleDuration().getValue();
//        app.getIaArena().setCombatSpeed(newSpeed);
    }//GEN-LAST:event_battleDurationStateChanged

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FightingTitle;
    private javax.swing.JLabel Winner1;
    private javax.swing.JLabel WinnerLabelID;
    private javax.swing.JSlider battleDuration;
    private javax.swing.JLabel clockVelocity;
    private Interfaz.FighterUI fighterUI1;
    private Interfaz.FighterUI fighterUI2;
    private javax.swing.JLabel iaStatusLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel roundLabel;
    private Interfaz.TvPanelUI tvPanelUI1;
    private Interfaz.TvPanelUI tvPanelUI2;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the tvPanelUI1
     */
    public Interfaz.TvPanelUI getTvPanelUI1() {
        return tvPanelUI1;
    }

    /**
     * @return the tvPanelUI2
     */
    public Interfaz.TvPanelUI getTvPanelUI2() {
        return tvPanelUI2;
    }

    /**
     * @return the avatarFighter
     */
    public Interfaz.FighterUI getAvatarFighter() {
        return fighterUI1;
    }

    /**
     * @return the regularShowFighter
     */
    public Interfaz.FighterUI getRegularShowFighter() {
        return fighterUI2;
    }

    /**
     * @return the iaStatusLabel
     */
    public javax.swing.JLabel getIaStatusLabel() {
        return iaStatusLabel;
    }

    /**
     * @return the WinnerLabelID
     */
    public javax.swing.JLabel getWinnerLabelID() {
        return WinnerLabelID;
    }

    /**
     * @return the roundLabel
     */
    public javax.swing.JLabel getRoundLabel() {
        return roundLabel;
    }

    /**
     * @return the battleDuration
     */
    public javax.swing.JSlider getBattleDuration() {
        return battleDuration;
    }
}
