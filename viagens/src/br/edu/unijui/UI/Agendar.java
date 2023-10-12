/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.edu.unijui.UI;

import br.edu.unijui.dao.AviaoImpl;
import br.edu.unijui.dao.PassageiroImpl;
import br.edu.unijui.dao.ViagemImpl;
import br.edu.unijui.model.Aviao;
import br.edu.unijui.model.Passageiro;
import br.edu.unijui.model.Viagem;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
public class Agendar extends javax.swing.JFrame {

    PassageiroImpl passageiroImpl;
    ViagemImpl viagemImpl;
    AviaoImpl aviaoImpl;
            
    public Agendar() throws ClassNotFoundException, SQLException {
        passageiroImpl = new PassageiroImpl();
        viagemImpl = new ViagemImpl();
        aviaoImpl = new AviaoImpl();
        
        initComponents();
        setComboBoxPassageiros();
        setComboBoxViagens();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBoxPassageiros = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxViagens = new javax.swing.JComboBox<>();
        jButtonAbrirCadastroPassageiro = new javax.swing.JButton();
        jButtonAgendar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Passageiro:");

        jComboBoxPassageiros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxPassageiros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxPassageirosMouseClicked(evt);
            }
        });

        jLabel2.setText("Seleciona um passageiro e  em qual viagem deseja registra-lo:");

        jLabel3.setText("Viagem:");

        jComboBoxViagens.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxViagens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxViagensMouseClicked(evt);
            }
        });

        jButtonAbrirCadastroPassageiro.setText("Cadastrar novo passageiro");
        jButtonAbrirCadastroPassageiro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAbrirCadastroPassageiroMouseClicked(evt);
            }
        });

        jButtonAgendar.setText("Agendar");
        jButtonAgendar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAgendarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonAbrirCadastroPassageiro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxPassageiros, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxViagens, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonAgendar, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(165, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel2)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxPassageiros, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonAbrirCadastroPassageiro, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxViagens, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(jButtonAgendar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAbrirCadastroPassageiroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAbrirCadastroPassageiroMouseClicked
       CadastrarPassageiro frameCadastrarPassageiro;
        try {
            frameCadastrarPassageiro = new CadastrarPassageiro();
            frameCadastrarPassageiro.setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(Agendar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButtonAbrirCadastroPassageiroMouseClicked

    private void jComboBoxPassageirosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxPassageirosMouseClicked

    }//GEN-LAST:event_jComboBoxPassageirosMouseClicked

    private void jComboBoxViagensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxViagensMouseClicked

    }//GEN-LAST:event_jComboBoxViagensMouseClicked

    private void jButtonAgendarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAgendarMouseClicked
        agendarViagem();
        Home homeTela = new Home();
        homeTela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonAgendarMouseClicked

    public void agendarViagem(){
        try{
            Passageiro passageiro = (Passageiro) jComboBoxPassageiros.getSelectedItem();
            Viagem viagem = (Viagem) jComboBoxViagens.getSelectedItem();

           viagemImpl.agendarViagem(viagem, passageiro); 
        
        }catch(Exception ex){
            Logger.getLogger(Agendar.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    
    public void setComboBoxPassageiros(){
        jComboBoxPassageiros.removeAllItems();
        try {
            List<Passageiro> passageiros = passageiroImpl.getAllPassageiros();
            for(Passageiro p: passageiros){
                if(p.getIdViagem() == 0){
                  jComboBoxPassageiros.addItem(p);  
                }          
            }

        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
    } 
    
    public void setComboBoxViagens(){
        jComboBoxViagens.removeAllItems();
        try {
            List<Viagem> viagens = viagemImpl.getAllViagens();
            for(Viagem v: viagens){
                jComboBoxViagens.addItem(v);
            }

        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAbrirCadastroPassageiro;
    private javax.swing.JButton jButtonAgendar;
    private javax.swing.JComboBox<Object> jComboBoxPassageiros;
    private javax.swing.JComboBox<Object> jComboBoxViagens;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
