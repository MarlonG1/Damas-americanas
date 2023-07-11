package Interfaces;

import Clases.Movimiento;
import Clases.Tablero;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TableroJuego extends javax.swing.JFrame {

    private Tablero juego;

    private Image imgBaseTablero = new ImageIcon("src/Imagenes/tableroBase.png").getImage();
    private Image imgInfoPanel = new ImageIcon("src/Imagenes/infoPanel.png").getImage();
    private Font ftGrande, ftPequenia;

    public TableroJuego() throws FontFormatException, IOException {
        initComponents();

        iniciarFuente();
        juego = new Tablero(this.tableroGUI, lbCantFB, lbCantFN, lbTurno, lbImgFicha);
        juego.pintarTablero();
        this.repaint();
    }

    public void iniciarFuente() throws FontFormatException, IOException {
        ftGrande = Font.createFont(Font.TRUETYPE_FONT, new File("src/Fuente/ringbearermedium.ttf")).deriveFont(20f);
        ftPequenia = Font.createFont(Font.TRUETYPE_FONT, new File("src/Fuente/ringbearermedium.ttf")).deriveFont(18f);
        GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
        genv.registerFont(ftGrande);
        genv.registerFont(ftPequenia);

        JLabel[] lbs = {lbInfoTurno1, lbTurno};

        for (JLabel lb : lbs) {
            lb.setFont(ftGrande);
        }

        lbs = new JLabel[]{lbCantBtxt, lbCantNtxt, lbCantFB, lbCantFN};

        for (JLabel lb : lbs) {
            lb.setFont(ftPequenia);
        }

        btnReiniciar.setFont(ftPequenia);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        tableroBaseGUI = new javax.swing.JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imgBaseTablero, 0, 0, this);
            }
        };
        tableroGUI = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imgInfoPanel, 0, 0, this);
            }
        };
        lbImgFicha = new javax.swing.JLabel();
        lbTurno = new javax.swing.JLabel();
        lbInfoTurno1 = new javax.swing.JLabel();
        lbCantBtxt = new javax.swing.JLabel();
        lbCantNtxt = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbCantFB = new javax.swing.JLabel();
        lbFichaBlanca = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lbCantFN = new javax.swing.JLabel();
        lbFichaNegra = new javax.swing.JLabel();
        btnReiniciar = new javax.swing.JButton();
        btnInfo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Damas");
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setForeground(new java.awt.Color(0, 153, 255));

        tableroBaseGUI.setBackground(new java.awt.Color(204, 204, 0));
        tableroBaseGUI.setPreferredSize(new java.awt.Dimension(565, 565));

        tableroGUI.setBackground(new java.awt.Color(153, 153, 153));
        tableroGUI.setMaximumSize(new java.awt.Dimension(540, 540));
        tableroGUI.setMinimumSize(new java.awt.Dimension(590, 590));
        tableroGUI.setPreferredSize(new java.awt.Dimension(520, 520));

        javax.swing.GroupLayout tableroGUILayout = new javax.swing.GroupLayout(tableroGUI);
        tableroGUI.setLayout(tableroGUILayout);
        tableroGUILayout.setHorizontalGroup(
            tableroGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        tableroGUILayout.setVerticalGroup(
            tableroGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout tableroBaseGUILayout = new javax.swing.GroupLayout(tableroBaseGUI);
        tableroBaseGUI.setLayout(tableroBaseGUILayout);
        tableroBaseGUILayout.setHorizontalGroup(
            tableroBaseGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tableroBaseGUILayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(tableroGUI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        tableroBaseGUILayout.setVerticalGroup(
            tableroBaseGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tableroBaseGUILayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(tableroGUI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        lbImgFicha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fichaJ1Info.png"))); // NOI18N

        lbTurno.setBackground(new java.awt.Color(255, 255, 255));
        lbTurno.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        lbTurno.setForeground(new java.awt.Color(61, 30, 0));
        lbTurno.setText("Uno");

        lbInfoTurno1.setBackground(new java.awt.Color(255, 255, 255));
        lbInfoTurno1.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        lbInfoTurno1.setForeground(new java.awt.Color(61, 30, 0));
        lbInfoTurno1.setText("Turno Jugador");

        lbCantBtxt.setBackground(new java.awt.Color(255, 255, 255));
        lbCantBtxt.setFont(new java.awt.Font("Arial Black", 0, 19)); // NOI18N
        lbCantBtxt.setForeground(new java.awt.Color(61, 30, 0));
        lbCantBtxt.setText("Fichas blancas:");

        lbCantNtxt.setBackground(new java.awt.Color(255, 255, 255));
        lbCantNtxt.setFont(new java.awt.Font("Arial Black", 0, 19)); // NOI18N
        lbCantNtxt.setForeground(new java.awt.Color(61, 30, 0));
        lbCantNtxt.setText("Fichas negras:");

        jPanel3.setBackground(new java.awt.Color(191, 134, 48));
        jPanel3.setMaximumSize(new java.awt.Dimension(102, 42));
        jPanel3.setMinimumSize(new java.awt.Dimension(102, 42));

        lbCantFB.setBackground(new java.awt.Color(255, 255, 255));
        lbCantFB.setFont(new java.awt.Font("Arial Black", 0, 19)); // NOI18N
        lbCantFB.setForeground(new java.awt.Color(61, 30, 0));
        lbCantFB.setText("x12");

        lbFichaBlanca.setBackground(new java.awt.Color(102, 0, 51));
        lbFichaBlanca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fichaJ1_mini.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lbFichaBlanca, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(lbCantFB)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(lbCantFB))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lbFichaBlanca, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(191, 134, 48));
        jPanel5.setMaximumSize(new java.awt.Dimension(102, 42));
        jPanel5.setMinimumSize(new java.awt.Dimension(102, 42));

        lbCantFN.setBackground(new java.awt.Color(255, 255, 255));
        lbCantFN.setFont(new java.awt.Font("Arial Black", 0, 19)); // NOI18N
        lbCantFN.setForeground(new java.awt.Color(61, 30, 0));
        lbCantFN.setText("x12");

        lbFichaNegra.setBackground(new java.awt.Color(102, 0, 51));
        lbFichaNegra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fichaJ2_mini.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lbFichaNegra, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(lbCantFN)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(lbCantFN))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lbFichaNegra, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnReiniciar.setBackground(new java.awt.Color(83, 49, 23));
        btnReiniciar.setFont(new java.awt.Font("Arial Black", 0, 19)); // NOI18N
        btnReiniciar.setForeground(new java.awt.Color(191, 134, 48));
        btnReiniciar.setText("Reiniciar");
        btnReiniciar.setToolTipText("");
        btnReiniciar.setFocusable(false);
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });

        btnInfo.setBackground(new java.awt.Color(191, 134, 48));
        btnInfo.setForeground(new java.awt.Color(83, 49, 23));
        btnInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/infoGeneral4.png"))); // NOI18N
        btnInfo.setFocusable(false);
        btnInfo.setMaximumSize(new java.awt.Dimension(43, 43));
        btnInfo.setMinimumSize(new java.awt.Dimension(43, 43));
        btnInfo.setPreferredSize(new java.awt.Dimension(45, 45));
        btnInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lbCantBtxt)
                        .addGap(9, 9, 9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lbImgFicha)
                        .addGap(45, 45, 45))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lbInfoTurno1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lbCantNtxt)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnReiniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(lbTurno))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(btnInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbInfoTurno1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTurno)
                .addGap(22, 22, 22)
                .addComponent(lbImgFicha)
                .addGap(18, 18, 18)
                .addComponent(lbCantBtxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbCantNtxt)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnReiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(tableroBaseGUI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tableroBaseGUI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        var opc = JOptionPane.showConfirmDialog(this, "Realmente deseas reiniciar el juego?", "Reiniciar", JOptionPane.YES_OPTION);

        if (opc == JOptionPane.OK_OPTION) {
            juego.reiniciar();
        }

    }//GEN-LAST:event_btnReiniciarActionPerformed

    private void btnInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoActionPerformed
        Informacion inf;
        try {
            inf = new Informacion();
            inf.setVisible(true);
        } catch (FontFormatException ex) {
            Logger.getLogger(TableroJuego.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TableroJuego.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnInfoActionPerformed

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
            java.util.logging.Logger.getLogger(TableroJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TableroJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TableroJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TableroJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TableroJuego().setVisible(true);
                } catch (FontFormatException ex) {
                    Logger.getLogger(TableroJuego.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(TableroJuego.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInfo;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lbCantBtxt;
    private javax.swing.JLabel lbCantFB;
    private javax.swing.JLabel lbCantFN;
    private javax.swing.JLabel lbCantNtxt;
    private javax.swing.JLabel lbFichaBlanca;
    private javax.swing.JLabel lbFichaNegra;
    private javax.swing.JLabel lbImgFicha;
    private javax.swing.JLabel lbInfoTurno1;
    private javax.swing.JLabel lbTurno;
    private javax.swing.JPanel tableroBaseGUI;
    private javax.swing.JPanel tableroGUI;
    // End of variables declaration//GEN-END:variables
}
