/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

/**
 *
 * @author alise
 */
public class GameFrame extends javax.swing.JFrame {

    /**
     * Creates new form GameFrame
     */
    public GameFrame() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonPass = new javax.swing.JButton();
        jButtonTakeLetter = new javax.swing.JButton();
        jButtonEstimate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaHiddenAnswer = new javax.swing.JTextArea();
        jLabelScore = new javax.swing.JLabel();
        jLabelReachablePoint = new javax.swing.JLabel();
        jLabelLifeOrTime = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonPass.setText("Pass");
        jButtonPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPassActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 210, 108, 33));

        jButtonTakeLetter.setText("Take Letter");
        jPanel1.add(jButtonTakeLetter, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 108, 35));

        jButtonEstimate.setText("Estimate");
        jButtonEstimate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEstimateActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonEstimate, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 108, 35));

        jTextAreaHiddenAnswer.setColumns(20);
        jTextAreaHiddenAnswer.setRows(5);
        jTextAreaHiddenAnswer.setText("\n\n------------------ ");
        jScrollPane1.setViewportView(jTextAreaHiddenAnswer);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, -1, -1));

        jLabelScore.setText("Score :");
        jPanel1.add(jLabelScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 70, -1));

        jLabelReachablePoint.setText("reachable point");
        jPanel1.add(jLabelReachablePoint, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabelLifeOrTime.setText("can/süre");
        jPanel1.add(jLabelLifeOrTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setText("SORUSU geşcek buraya");
        jScrollPane2.setViewportView(jTextArea2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 240, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonPassActionPerformed

    private void jButtonEstimateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEstimateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEstimateActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      
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
    private javax.swing.JButton jButtonEstimate;
    private javax.swing.JButton jButtonPass;
    private javax.swing.JButton jButtonTakeLetter;
    private javax.swing.JLabel jLabelLifeOrTime;
    private javax.swing.JLabel jLabelReachablePoint;
    private javax.swing.JLabel jLabelScore;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextAreaHiddenAnswer;
    // End of variables declaration//GEN-END:variables
}
