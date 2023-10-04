/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.edu.unijui.UI;

import br.edu.unijui.dao.PassageiroImpl;
import br.edu.unijui.model.Passageiro;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
public class CadastrarPassageiro extends javax.swing.JFrame {

    PassageiroImpl passageiroImpl;
    
    public CadastrarPassageiro() throws ClassNotFoundException, SQLException {
        passageiroImpl = new PassageiroImpl();
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonCadastrarPasssageiro = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNomePassageiro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldPassaportePassageiro = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonCadastrarPasssageiro.setText("CADASTRAR");
        jButtonCadastrarPasssageiro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCadastrarPasssageiroMouseClicked(evt);
            }
        });
        jButtonCadastrarPasssageiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarPasssageiroActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome:");

        jTextFieldNomePassageiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomePassageiroActionPerformed(evt);
            }
        });

        jLabel2.setText("Passaporte:");

        jTextFieldPassaportePassageiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPassaportePassageiroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(30, 30, 30)
                        .addComponent(jTextFieldNomePassageiro))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPassaportePassageiro, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonCadastrarPasssageiro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(92, 92, 92))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNomePassageiro, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldPassaportePassageiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(94, 94, 94)
                .addComponent(jButtonCadastrarPasssageiro)
                .addGap(54, 54, 54))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCadastrarPasssageiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarPasssageiroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCadastrarPasssageiroActionPerformed

    private void jTextFieldNomePassageiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomePassageiroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomePassageiroActionPerformed

    private void jTextFieldPassaportePassageiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPassaportePassageiroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPassaportePassageiroActionPerformed

    private void jButtonCadastrarPasssageiroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCadastrarPasssageiroMouseClicked
       
        try {
            Passageiro passageiro = new Passageiro(
                    jTextFieldNomePassageiro.getText(),
                    jTextFieldPassaportePassageiro.getText()
                     );
           
            passageiroImpl.inserirPassageiro(passageiro);
            Agendar telaAgendar = new Agendar();
            telaAgendar.setVisible(true);
            this.dispose();        
        } catch (Exception ex) {
           Logger.getLogger(CadastrarPassageiro.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }//GEN-LAST:event_jButtonCadastrarPasssageiroMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCadastrarPasssageiro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextFieldNomePassageiro;
    private javax.swing.JTextField jTextFieldPassaportePassageiro;
    // End of variables declaration//GEN-END:variables
}
