/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.edu.unijui.UI;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
public class AdministrarViagens extends javax.swing.JFrame {

    /**
     * Creates new form AdministrarViagens
     */
    public AdministrarViagens() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonCriarViagem = new javax.swing.JButton();
        jButtonRegistrarAviao = new javax.swing.JButton();
        jButtonHome = new javax.swing.JButton();
        jButtonDetalharViagem1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonCriarViagem.setText("Criar nova Viagem");
        jButtonCriarViagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCriarViagemMouseClicked(evt);
            }
        });
        jButtonCriarViagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCriarViagemActionPerformed(evt);
            }
        });

        jButtonRegistrarAviao.setText("Registrar Avião");
        jButtonRegistrarAviao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonRegistrarAviaoMouseClicked(evt);
            }
        });
        jButtonRegistrarAviao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarAviaoActionPerformed(evt);
            }
        });

        jButtonHome.setText("HOME");
        jButtonHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonHomeMouseClicked(evt);
            }
        });
        jButtonHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHomeActionPerformed(evt);
            }
        });

        jButtonDetalharViagem1.setText("Detalhar Viagens");
        jButtonDetalharViagem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonDetalharViagem1MouseClicked(evt);
            }
        });
        jButtonDetalharViagem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDetalharViagem1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(210, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonDetalharViagem1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonHome, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRegistrarAviao, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCriarViagem, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(195, 195, 195))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jButtonCriarViagem, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonRegistrarAviao, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jButtonDetalharViagem1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                .addComponent(jButtonHome, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCriarViagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCriarViagemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCriarViagemActionPerformed

    private void jButtonRegistrarAviaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarAviaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRegistrarAviaoActionPerformed

    private void jButtonHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonHomeActionPerformed

    private void jButtonRegistrarAviaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRegistrarAviaoMouseClicked
        try {
            CadastrarAviao telaCadastrarAviao = new CadastrarAviao();
            telaCadastrarAviao.setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        } 
        
        
    }//GEN-LAST:event_jButtonRegistrarAviaoMouseClicked

    private void jButtonCriarViagemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCriarViagemMouseClicked
        try {
            CadastrarViagem telaCadastrarViagem = new CadastrarViagem();
            telaCadastrarViagem.setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(AdministrarViagens.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButtonCriarViagemMouseClicked

    private void jButtonHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonHomeMouseClicked
       
        try {
            Home homeTela = new Home();
             homeTela.setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(AdministrarViagens.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_jButtonHomeMouseClicked

    private void jButtonDetalharViagem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDetalharViagem1MouseClicked
        try {
            DetalharViagens detalharViagensTela = new DetalharViagens();
             detalharViagensTela.setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(AdministrarViagens.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonDetalharViagem1MouseClicked

    private void jButtonDetalharViagem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDetalharViagem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonDetalharViagem1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCriarViagem;
    private javax.swing.JButton jButtonDetalharViagem1;
    private javax.swing.JButton jButtonHome;
    private javax.swing.JButton jButtonRegistrarAviao;
    // End of variables declaration//GEN-END:variables
}
