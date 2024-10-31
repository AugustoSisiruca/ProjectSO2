/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

//import Helpers.AudioManager;
//import Helpers.ImageUtils;
import proyecto2.App;
import javax.swing.ImageIcon;
import javax.swing.JSlider;

/**
 *
 * @author author
 */
public class Home2 extends javax.swing.JFrame {
    
    private ImageUtils imageUtils = new ImageUtils();
    private AudioManager audioManager;
    App app = App.getInstance();

    /**
     * Creates new form Home
     */
    public Home2() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        //Seteo del audioManager
        this.audioManager = new AudioManager(); 
        audioManager.playMusic("/GUI/Assets/backgroundSound.wav");
        
        ImageIcon cartoonNetworkLogo = imageUtils.loadScaledImage("/GUI/Assets/RegularShow/logo.png", 140, 80);
        ImageIcon nickelodeonLogo = imageUtils.loadScaledImage("/GUI/Assets/Avatar/logo.png", 120, 80);
        
        tvPanelUI1.getLogo().setIcon(cartoonNetworkLogo);
        tvPanelUI2.getLogo().setIcon(nickelodeonLogo);
        tvPanelUI1.getLogo().setText("");
        tvPanelUI2.getLogo().setText("");
        iaStatusLabel.setText("");
        WinnerLabelID.setText("");

        // Se setean las imagenes que la lucha en la IA.
//        ImageIcon regularShowCardIA=  imageUtils.loadScaledImage(app.getIaArena().getRegularShowFighter().getUrlSource(), 150, 200);
//        this.RegularShowCard.setIcon(regularShowCardIA);
//        ImageIcon avatarCardIA=  imageUtils.loadScaledImage(app.getIaArena().getAvatarFighter().getUrlSource(), 150, 200);
//        this.AvatarCard.setIcon(avatarCardIA);
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
        Winner1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        roundLabel = new javax.swing.JLabel();
        iaStatusLabel = new javax.swing.JLabel();
        battleDuration = new javax.swing.JSlider();
        clockVelocity = new javax.swing.JLabel();
        WinnerLabelID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(240, 233, 223));
        jPanel1.setMinimumSize(new java.awt.Dimension(1130, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        FightingTitle.setFont(new java.awt.Font("Montserrat", 1, 36)); // NOI18N
        FightingTitle.setForeground(new java.awt.Color(255, 255, 255));
        FightingTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FightingTitle.setText("FIGHTING AREA");
        jPanel1.add(FightingTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 10, 390, -1));

        Winner1.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        Winner1.setForeground(new java.awt.Color(255, 255, 255));
        Winner1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Winner1.setText("Ganador:");
        jPanel1.add(Winner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 630, 370, -1));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setForeground(new java.awt.Color(51, 51, 51));

        roundLabel.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        roundLabel.setForeground(new java.awt.Color(255, 255, 255));
        roundLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        roundLabel.setText("Round: 0");

        iaStatusLabel.setFont(new java.awt.Font("Montserrat", 1, 17)); // NOI18N
        iaStatusLabel.setForeground(new java.awt.Color(255, 255, 255));
        iaStatusLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iaStatusLabel.setText("IA STATUS LABEL");
        iaStatusLabel.setToolTipText("");

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

        clockVelocity.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        clockVelocity.setForeground(new java.awt.Color(255, 255, 255));
        clockVelocity.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clockVelocity.setText("AJUSTE LA VELOCIDAD ");

        WinnerLabelID.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        WinnerLabelID.setForeground(new java.awt.Color(255, 255, 255));
        WinnerLabelID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        WinnerLabelID.setText("Ganador");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(battleDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(iaStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(clockVelocity, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(roundLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(WinnerLabelID, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(clockVelocity)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(battleDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iaStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 461, Short.MAX_VALUE)
                .addComponent(WinnerLabelID)
                .addGap(53, 53, 53))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 400, 730));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(Home2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FightingTitle;
    private javax.swing.JLabel Winner1;
    private javax.swing.JLabel WinnerLabelID;
    private javax.swing.JSlider battleDuration;
    private javax.swing.JLabel clockVelocity;
    private javax.swing.JLabel iaStatusLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel roundLabel;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the tvPanelUI1
     */
    public GUIClasses.TvPanelUI getTvPanelUI1() {
        return tvPanelUI1;
    }

    /**
     * @return the tvPanelUI2
     */
    public GUIClasses.TvPanelUI getTvPanelUI2() {
        return tvPanelUI2;
    }

    /**
     * @return the avatarFighter
     */
    public GUIClasses.FighterUI getAvatarFighter() {
        return avatarFighter;
    }

    /**
     * @return the regularShowFighter
     */
    public GUIClasses.FighterUI getRegularShowFighter() {
        return regularShowFighter;
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
