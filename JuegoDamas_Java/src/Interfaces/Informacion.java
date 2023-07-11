/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

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


public class Informacion extends javax.swing.JFrame {

    private Image imgFondo = new ImageIcon("src/Imagenes/infoFondo.png").getImage();
    private Image imgFondo1 = new ImageIcon("src/Imagenes/infoBase.png").getImage();
    private Font ftGrande, ftPequenia, ftGrandota;
    
    public Informacion() throws FontFormatException, IOException {
        initComponents();
        iniciarFuente();
    }


    public void iniciarFuente() throws FontFormatException, IOException {
        ftGrandota = Font.createFont(Font.TRUETYPE_FONT, new File("src/Fuente/ringbearermedium.ttf")).deriveFont(36f);
        ftGrande = Font.createFont(Font.TRUETYPE_FONT, new File("src/Fuente/ringbearermedium.ttf")).deriveFont(24f);
        ftPequenia = Font.createFont(Font.TRUETYPE_FONT, new File("src/Fuente/ringbearermedium.ttf")).deriveFont(14f);
        GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
        genv.registerFont(ftGrandota);
        genv.registerFont(ftGrande);
        genv.registerFont(ftPequenia);

        
        lbTxtG1.setFont(ftGrandota);
        lbTxtG2.setFont(ftGrande);
        lbTxtG3.setFont(ftGrande);

        JLabel[] lbs = {lbR1,lbR2,lbR3,lbR4,lbR5,lbR6,lbR7,lbR8,lbR9,lbR10,lbR11,lbR12,lbR13,lbR14,lbR15,lbR16,lbR17};
        
        for(JLabel lb : lbs){
            lb.setFont(ftPequenia);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imgFondo, 0, 0, this);
            }
        };
        jPanel2 = new javax.swing.JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imgFondo1, 0, 0, this);
            }
        };
        lbR1 = new javax.swing.JLabel();
        lbR2 = new javax.swing.JLabel();
        lbR3 = new javax.swing.JLabel();
        lbR4 = new javax.swing.JLabel();
        lbR5 = new javax.swing.JLabel();
        lbR6 = new javax.swing.JLabel();
        lbR7 = new javax.swing.JLabel();
        lbR8 = new javax.swing.JLabel();
        lbR9 = new javax.swing.JLabel();
        lbTxtG2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imgFondo1, 0, 0, this);
            }
        };
        lbR10 = new javax.swing.JLabel();
        lbR11 = new javax.swing.JLabel();
        lbR12 = new javax.swing.JLabel();
        lbR13 = new javax.swing.JLabel();
        lbR14 = new javax.swing.JLabel();
        lbR15 = new javax.swing.JLabel();
        lbR16 = new javax.swing.JLabel();
        lbR17 = new javax.swing.JLabel();
        lbTxtG3 = new javax.swing.JLabel();
        lbTxtG1 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Informacion del juego");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 51));

        lbR1.setBackground(new java.awt.Color(255, 255, 255));
        lbR1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lbR1.setForeground(new java.awt.Color(255, 255, 255));
        lbR1.setText("Solo puedes mover una ficha por turno.");

        lbR2.setBackground(new java.awt.Color(255, 255, 255));
        lbR2.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lbR2.setForeground(new java.awt.Color(255, 255, 255));
        lbR2.setText("Los movimientos deben de ser en diagonal");

        lbR3.setBackground(new java.awt.Color(255, 255, 255));
        lbR3.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lbR3.setForeground(new java.awt.Color(255, 255, 255));
        lbR3.setText("según el tipo de ficha.");

        lbR4.setBackground(new java.awt.Color(255, 255, 255));
        lbR4.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lbR4.setForeground(new java.awt.Color(255, 255, 255));
        lbR4.setText("No se permite retroceder fichas, a menos");

        lbR5.setBackground(new java.awt.Color(255, 255, 255));
        lbR5.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lbR5.setForeground(new java.awt.Color(255, 255, 255));
        lbR5.setText("que sea una ficha Reina. ");

        lbR6.setBackground(new java.awt.Color(255, 255, 255));
        lbR6.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lbR6.setForeground(new java.awt.Color(255, 255, 255));
        lbR6.setText("No se permite mover fichas del oponente.");

        lbR7.setBackground(new java.awt.Color(255, 255, 255));
        lbR7.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lbR7.setForeground(new java.awt.Color(255, 255, 255));
        lbR7.setText("La captura es obligatoria si hay una oportunidad.");

        lbR8.setBackground(new java.awt.Color(255, 255, 255));
        lbR8.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lbR8.setForeground(new java.awt.Color(255, 255, 255));
        lbR8.setText("Existe la posibilidad de capturas múltiples");

        lbR9.setBackground(new java.awt.Color(255, 255, 255));
        lbR9.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lbR9.setForeground(new java.awt.Color(255, 255, 255));
        lbR9.setText("consecutivas si es posible.");

        lbTxtG2.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        lbTxtG2.setForeground(new java.awt.Color(255, 255, 255));
        lbTxtG2.setText("Reglas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(lbTxtG2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbR9)
                    .addComponent(lbR2)
                    .addComponent(lbR1)
                    .addComponent(lbR3)
                    .addComponent(lbR4)
                    .addComponent(lbR5)
                    .addComponent(lbR6)
                    .addComponent(lbR7)
                    .addComponent(lbR8))
                .addGap(22, 22, 22))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lbTxtG2)
                .addGap(36, 36, 36)
                .addComponent(lbR1)
                .addGap(18, 18, 18)
                .addComponent(lbR2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbR3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbR4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbR5)
                .addGap(18, 18, 18)
                .addComponent(lbR6)
                .addGap(18, 18, 18)
                .addComponent(lbR7)
                .addGap(18, 18, 18)
                .addComponent(lbR8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbR9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setPreferredSize(new java.awt.Dimension(399, 359));

        lbR10.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lbR10.setForeground(new java.awt.Color(255, 255, 255));
        lbR10.setText("Al jugador 1 le corresponden la fichas amarillas ");

        lbR11.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lbR11.setForeground(new java.awt.Color(255, 255, 255));
        lbR11.setText("y al jugador 2 las negras.");

        lbR12.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lbR12.setForeground(new java.awt.Color(255, 255, 255));
        lbR12.setText("Cuando una ficha llega a final del tablero del");

        lbR13.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lbR13.setForeground(new java.awt.Color(255, 255, 255));
        lbR13.setText("oponente se convierte en reina.");

        lbR14.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lbR14.setForeground(new java.awt.Color(255, 255, 255));
        lbR14.setText("Las reinas pueden moverse en sus diagonales");

        lbR15.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lbR15.setForeground(new java.awt.Color(255, 255, 255));
        lbR15.setText(" superiores e inferiores.");

        lbR16.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lbR16.setForeground(new java.awt.Color(255, 255, 255));
        lbR16.setText("El juego termina cuando el oponente se queda ");

        lbR17.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lbR17.setForeground(new java.awt.Color(255, 255, 255));
        lbR17.setText(" sin fichas.");

        lbTxtG3.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        lbTxtG3.setForeground(new java.awt.Color(255, 255, 255));
        lbTxtG3.setText("Informacion general");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbR11)
                            .addComponent(lbR10)
                            .addComponent(lbR12)
                            .addComponent(lbR14)
                            .addComponent(lbR15)
                            .addComponent(lbR16)
                            .addComponent(lbR13)
                            .addComponent(lbR17))
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(lbTxtG3)
                        .addGap(69, 69, 69))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lbTxtG3)
                .addGap(57, 57, 57)
                .addComponent(lbR10, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbR11)
                .addGap(18, 18, 18)
                .addComponent(lbR12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbR13)
                .addGap(18, 18, 18)
                .addComponent(lbR14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbR15)
                .addGap(18, 18, 18)
                .addComponent(lbR16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbR17)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        lbTxtG1.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        lbTxtG1.setForeground(new java.awt.Color(255, 255, 255));
        lbTxtG1.setText("Damas");

        jLabel21.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(204, 204, 204));
        jLabel21.setText("Hecho por: Marlon Garcia");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel21)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lbTxtG1)
                        .addGap(362, 362, 362))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lbTxtG1)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Informacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Informacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Informacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Informacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Informacion().setVisible(true);
                } catch (FontFormatException ex) {
                    Logger.getLogger(Informacion.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Informacion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbR1;
    private javax.swing.JLabel lbR10;
    private javax.swing.JLabel lbR11;
    private javax.swing.JLabel lbR12;
    private javax.swing.JLabel lbR13;
    private javax.swing.JLabel lbR14;
    private javax.swing.JLabel lbR15;
    private javax.swing.JLabel lbR16;
    private javax.swing.JLabel lbR17;
    private javax.swing.JLabel lbR2;
    private javax.swing.JLabel lbR3;
    private javax.swing.JLabel lbR4;
    private javax.swing.JLabel lbR5;
    private javax.swing.JLabel lbR6;
    private javax.swing.JLabel lbR7;
    private javax.swing.JLabel lbR8;
    private javax.swing.JLabel lbR9;
    private javax.swing.JLabel lbTxtG1;
    private javax.swing.JLabel lbTxtG2;
    private javax.swing.JLabel lbTxtG3;
    // End of variables declaration//GEN-END:variables
}
