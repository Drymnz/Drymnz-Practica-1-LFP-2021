/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cunoc.practica_1_lfp_2021.view.sub_ventanas;

import cunoc.practica_1_lfp_2021.Analisador.Lexico;
import cunoc.practica_1_lfp_2021.Start;
import java.io.File;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 * @author Benjamín de Jesús Pérez Aguilar<@Drymnz>
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
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(162, 210, 255));

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

        jButtonIniciar.setBackground(new java.awt.Color(101, 230, 144));
        jButtonIniciar.setText("Iniciar");
        jButtonIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarActionPerformed(evt);
            }
        });

        jButtonCancelar.setBackground(new java.awt.Color(255, 134, 94));
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabel1.setText("Para iniciar el analisis presione iniciar, si desea regresar precione cancelar.");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelCarga1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonIniciar)
                    .addComponent(jButtonCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarActionPerformed
        iniciar = null;
        iniciar = new Thread(new Lexico(panelCarga1, texto), "Analisador" + LocalDate.now().toString());
        iniciar.start();
    }//GEN-LAST:event_jButtonIniciarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        if (texto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay nada que analisar, ingrese texto porfavor");
        } else {
            Start.ejecutar.irEditor(texto, archivo);
            try {
                if (iniciar.isAlive()) {
                    iniciar.stop();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Error al detener el hilo del analisador");
            }

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
    private javax.swing.JLabel jLabel1;
    private cunoc.practica_1_lfp_2021.view.sub_ventanas.PanelCarga panelCarga1;
    // End of variables declaration//GEN-END:variables

    public PanelCarga getPanelCarga1() {
        return panelCarga1;
    }

}
