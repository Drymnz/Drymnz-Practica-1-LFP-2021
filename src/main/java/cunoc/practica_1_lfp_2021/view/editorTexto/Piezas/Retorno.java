/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package cunoc.practica_1_lfp_2021.view.editorTexto.Piezas;

import cunoc.practica_1_lfp_2021.FucionalidadExtrarEditor.Historial;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextArea;

/**
 * @author drymnz
 */
public class Retorno extends javax.swing.JPanel {

    private Historial historial = new Historial();

    /**
     * Creates new form Historial
     */
    public Retorno() {
        initComponents();
    }

    public void registrar(JTextArea registrar) {
        historial.setRegistrar(registrar);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonDeshacer = new javax.swing.JButton();
        jButtonRehacer = new javax.swing.JButton();

        setBackground(new java.awt.Color(162, 210, 255));

        jButtonDeshacer.setText("Deshacer");
        jButtonDeshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeshacerActionPerformed(evt);
            }
        });

        jButtonRehacer.setText("Rehacer");
        jButtonRehacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRehacerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonDeshacer)
                .addGap(18, 18, 18)
                .addComponent(jButtonRehacer)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDeshacer)
                    .addComponent(jButtonRehacer))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeshacerActionPerformed
        historial.deshacer();
    }//GEN-LAST:event_jButtonDeshacerActionPerformed

    private void jButtonRehacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRehacerActionPerformed
        historial.rehacer();
    }//GEN-LAST:event_jButtonRehacerActionPerformed
    public void iniciarHistorial() {
        historial.reset();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDeshacer;
    private javax.swing.JButton jButtonRehacer;
    // End of variables declaration//GEN-END:variables
}
