/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cunoc.practica_1_lfp_2021.view.sub_ventanas;

import cunoc.practica_1_lfp_2021.Analisador.Categorizador;
import cunoc.practica_1_lfp_2021.Start;
import java.io.File;

/**
@author Benjamín de Jesús Pérez Aguilar<@Drymnz>
 */
public class VentanaAnalisando extends javax.swing.JPanel {

    private String texto;
    private File archivo;
    private Thread iniciar;

    /**
     * Creates new form VentanaAnalisando
     */
    public VentanaAnalisando() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCarga1 = new cunoc.practica_1_lfp_2021.view.sub_ventanas.PanelCarga();
        jButtonIniciar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        javax.swing.GroupLayout panelCarga1Layout = new javax.swing.GroupLayout(panelCarga1);
        panelCarga1.setLayout(panelCarga1Layout);
        panelCarga1Layout.setHorizontalGroup(
            panelCarga1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelCarga1Layout.setVerticalGroup(
            panelCarga1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        jButtonIniciar.setText("Iniciar");
        jButtonIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelCarga1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonIniciar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 311, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(panelCarga1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonIniciar)
                    .addComponent(jButtonCancelar))
                .addContainerGap(125, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarActionPerformed
        iniciar = new Thread(new Categorizador(panelCarga1, texto), "Analisador");
        iniciar.start();
    }//GEN-LAST:event_jButtonIniciarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        Start.ejecutar.irEditor(texto, archivo);
        if (iniciar.isAlive()) {
            iniciar.stop();
        }
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonIniciar;
    private cunoc.practica_1_lfp_2021.view.sub_ventanas.PanelCarga panelCarga1;
    // End of variables declaration//GEN-END:variables
}
