/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cunoc.practica_1_lfp_2021.view.editorTexto;

import cunoc.practica_1_lfp_2021.Archivo.ManejadorEscrituraArchivo;
import cunoc.practica_1_lfp_2021.Start;
import cunoc.practica_1_lfp_2021.view.editorTexto.Piezas.Acerca;
import cunoc.practica_1_lfp_2021.view.editorTexto.Piezas.Retorno;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author Benjamín de Jesús Pérez Aguilar<@Drymnz>
 */
public class EditorTexto extends javax.swing.JPanel {

    private File archivo = null;
    private JFrame ventana = new JFrame();
    private Acerca detalles = new Acerca();

    /**
     * Creates new form EditorTexto
     */
    public EditorTexto() {
        initComponents();
        cargarExtras();
    }

    private void cargarExtras() {
        // cargar lo de acerca de la aplicacion
        ventana.setTitle("Acerca");
        detalles.setSize(525, 140);
        ventana.setSize(525, 140);
        ventana.setResizable(false);// evistar que modifique el tamaño de la ventana
        ventana.add(detalles);
        retorno1.registrar(jTextArea);// cargar la region de retorno 
        posicion1.setVer(jTextArea); // cargar lo de posicion dentro del area de texto
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldBuscador = new javax.swing.JTextField();
        JButtonRegresar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextArea();
        jButtonBuscar = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();
        jButtonGuardarComo = new javax.swing.JButton();
        jButtonAnalisar = new javax.swing.JButton();
        retorno1 = new cunoc.practica_1_lfp_2021.view.editorTexto.Piezas.Retorno();
        jButtonAcerca = new javax.swing.JButton();
        posicion1 = new cunoc.practica_1_lfp_2021.view.editorTexto.Piezas.Posicion();

        setBackground(new java.awt.Color(162, 210, 255));

        jTextFieldBuscador.setText("Buscar");
        jTextFieldBuscador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldBuscadorMouseClicked(evt);
            }
        });
        jTextFieldBuscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBuscadorActionPerformed(evt);
            }
        });

        JButtonRegresar.setBackground(new java.awt.Color(255, 134, 94));
        JButtonRegresar.setText("Regresar");
        JButtonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonRegresarActionPerformed(evt);
            }
        });

        jTextArea.setColumns(20);
        jTextArea.setRows(5);
        jScrollPane2.setViewportView(jTextArea);

        jButtonBuscar.setBackground(new java.awt.Color(254, 228, 64));
        jButtonBuscar.setText("buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jButtonGuardar.setBackground(new java.awt.Color(254, 249, 239));
        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jButtonGuardarComo.setBackground(new java.awt.Color(254, 249, 239));
        jButtonGuardarComo.setText("Guardar Como");
        jButtonGuardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarComoActionPerformed(evt);
            }
        });

        jButtonAnalisar.setBackground(new java.awt.Color(254, 228, 64));
        jButtonAnalisar.setText("Analisar");
        jButtonAnalisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnalisarActionPerformed(evt);
            }
        });

        jButtonAcerca.setText("Acerca");
        jButtonAcerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcercaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout posicion1Layout = new javax.swing.GroupLayout(posicion1);
        posicion1.setLayout(posicion1Layout);
        posicion1Layout.setHorizontalGroup(
            posicion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        posicion1Layout.setVerticalGroup(
            posicion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JButtonRegresar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonGuardarComo)
                        .addGap(18, 18, 18)
                        .addComponent(retorno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAcerca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 276, Short.MAX_VALUE)
                        .addComponent(jButtonAnalisar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(posicion1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonBuscar)
                                .addComponent(jButtonGuardar)
                                .addComponent(jButtonAnalisar)
                                .addComponent(jButtonAcerca))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(JButtonRegresar)
                                .addComponent(jButtonGuardarComo))))
                    .addComponent(retorno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(posicion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JButtonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonRegresarActionPerformed
        Start.ejecutar.irMenuPrincipal();
    }//GEN-LAST:event_JButtonRegresarActionPerformed

    private void jTextFieldBuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBuscadorActionPerformed
        (new Resaltador(jTextArea, jTextFieldBuscador.getText())).run();
    }//GEN-LAST:event_jTextFieldBuscadorActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        (new Resaltador(jTextArea, jTextFieldBuscador.getText())).run();
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        aguardar();
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarComoActionPerformed
        archivo = null;
        aguardar();
    }//GEN-LAST:event_jButtonGuardarComoActionPerformed

    private void jButtonAnalisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnalisarActionPerformed
        Start.ejecutar.irAnalisador(jTextArea.getText(), archivo);
    }//GEN-LAST:event_jButtonAnalisarActionPerformed

    private void jTextFieldBuscadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldBuscadorMouseClicked
        if (jTextFieldBuscador.getText().equals("Buscar")) {
            jTextFieldBuscador.setText("");
        }
    }//GEN-LAST:event_jTextFieldBuscadorMouseClicked

    private void jButtonAcercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAcercaActionPerformed
        if (!ventana.isVisible()) {
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);
        }
    }//GEN-LAST:event_jButtonAcercaActionPerformed
    private void aguardar() {
        String mensaje = "Fallo al aguardar";
        if (archivo == null) {
            FileNameExtensionFilter filtrado = new FileNameExtensionFilter(".txt", "txt");
            JFileChooser buscador = new JFileChooser();
            buscador.setFileFilter(filtrado);
            mensaje = ((buscador.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) && (new ManejadorEscrituraArchivo()).aguardarTexto((buscador).getSelectedFile(), jTextArea.getText())) ? "se aguardo correctamente" : "Fallo al aguardar";
        } else {
            mensaje = ((new ManejadorEscrituraArchivo()).aguardarTexto(archivo, jTextArea.getText())) ? "se aguardo correctamente" : "Fallo al aguardar";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButtonRegresar;
    private javax.swing.JButton jButtonAcerca;
    private javax.swing.JButton jButtonAnalisar;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonGuardarComo;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea;
    private javax.swing.JTextField jTextFieldBuscador;
    private cunoc.practica_1_lfp_2021.view.editorTexto.Piezas.Posicion posicion1;
    private cunoc.practica_1_lfp_2021.view.editorTexto.Piezas.Retorno retorno1;
    // End of variables declaration//GEN-END:variables
// set y get 
    public JTextArea getjTextArea1() {
        return jTextArea;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public Retorno getRetorno1() {
        return retorno1;
    }
// fin set y get 

}
