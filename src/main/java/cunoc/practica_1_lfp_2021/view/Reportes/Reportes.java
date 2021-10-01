/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cunoc.practica_1_lfp_2021.view.Reportes;

import cunoc.practica_1_lfp_2021.Errores.ErrorLexema;
import cunoc.practica_1_lfp_2021.ManejadorTexto.ManejadorTexto;
import cunoc.practica_1_lfp_2021.Start;
import cunoc.practica_1_lfp_2021.Toke.Lexema;
import cunoc.practica_1_lfp_2021.Toke.ListadoToken;
import cunoc.practica_1_lfp_2021.Toke.Palabra;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Benjamín de Jesús Pérez Aguilar<@Drymnz>
 */
public class Reportes extends javax.swing.JPanel implements Runnable {

    private Thread arranque = new Thread(this);
    private DefaultTableModel modelo;
    private ArrayList<Palabra> listadoLexema;

    /**
     * Creates new form ReportesErrores
     */
    public Reportes() {
        initComponents();
    }

    /*
     int tipoTabla 
    1 = reporteErrores
    2 = reporteTokens
    3 = reporteTokensResumido
    4 = Recuperador Error
     */
    public void cargarTabla(ArrayList<Palabra> listadoLexema, int tipoTabla) {
        this.listadoLexema = listadoLexema;
        modelo = (DefaultTableModel) jTableReporte.getModel();
        cargar(tipoTabla);
    }

    private void cargar(int tipoTabla) {
        refrescar();
        desctivarBotones(tipoTabla);
        modelo.setColumnIdentifiers(titulos(tipoTabla));
        cargarTabla(tipoTabla);
    }

    private void cargarTabla(int tipoTabla) {
        if (arranque.isAlive()) {
            arranque.stop();
        }
        if (tipoTabla == 3) {
            arranque.start();
        } else {
            for (Palabra palabra : listadoLexema) {
                Object[] asignar = segunTipo(palabra, tipoTabla);
                if (asignar != null) {
                    modelo.addRow(asignar);
                }
            }
        }
    }
// asignar los titulos de la tabla

    private Object[] segunTipo(Palabra comparar, int tipo) {
        switch (tipo) {
            case 1:
                if ((comparar instanceof ErrorLexema)) {
                    ErrorLexema ver = (ErrorLexema) comparar;
                    // {"simbolo o cadena de erro", "posicionY","posicionX"};
                    return new Object[]{ver.getCaracter(), ver.getPosicionX(), ver.getPosicionY()};
                }
                break;
            case 2:
                if ((comparar instanceof Lexema)) {
                    Lexema ver = (Lexema) comparar;
                    //{"nombre del token", "lexema", "posicionX","posicionY"};
                    return new Object[]{ver.getTipoToken().getNombre(), (new ManejadorTexto()).convertirListadoCaracter(ver.getPalabra()), ver.getPosicionX(), ver.getPosicionY()};
                }
                break;
            case 4:
                if ((comparar instanceof ErrorLexema)) {
                    ErrorLexema ver = (ErrorLexema) comparar;
                    // {"recuperar error"};
                    return new Object[]{ver.getRecuperacionError()};
                }
                break;
        }
        return null;
    }

    private String[] titulos(int tipo) {
        switch (tipo) {
            case 1:
                String[] reporteErrores = {"simbolo o cadena de erro", "posicionX", "posicionY"};
                return reporteErrores;
            case 2:
                String[] reporteTokens = {"nombre del token", "lexema", "posicionX", "posicionY"};
                return reporteTokens;
            case 3:
                String[] reporteTokensResumido = {"lexema", "token", "cantidad"};
                return reporteTokensResumido;
            case 4:
                String[] reporteErroresRecuperar = {"recuperar error"};
                return reporteErroresRecuperar;
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonRegrasarMenuPrincipal = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableReporte = new javax.swing.JTable();
        jButtonRecuperadorError = new javax.swing.JButton();
        jButtonReportesError = new javax.swing.JButton();
        jButtonResumenToken = new javax.swing.JButton();
        jButtonRerpoteToken = new javax.swing.JButton();

        jButtonRegrasarMenuPrincipal.setText("Regresar Menu Principal");
        jButtonRegrasarMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegrasarMenuPrincipalActionPerformed(evt);
            }
        });

        jTableReporte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "simbolo ocadena de error", "posicionX", "posicionX"
            }
        ));
        jScrollPane1.setViewportView(jTableReporte);

        jButtonRecuperadorError.setText("Recuperador Error");
        jButtonRecuperadorError.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRecuperadorErrorActionPerformed(evt);
            }
        });

        jButtonReportesError.setText("Reportes Error");
        jButtonReportesError.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReportesErrorActionPerformed(evt);
            }
        });

        jButtonResumenToken.setText("Resumen Token");
        jButtonResumenToken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResumenTokenActionPerformed(evt);
            }
        });

        jButtonRerpoteToken.setText("Reporte Token");
        jButtonRerpoteToken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRerpoteTokenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1256, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonRegrasarMenuPrincipal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonRerpoteToken)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonResumenToken)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonReportesError)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonRecuperadorError)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRegrasarMenuPrincipal)
                    .addComponent(jButtonRecuperadorError)
                    .addComponent(jButtonReportesError)
                    .addComponent(jButtonResumenToken)
                    .addComponent(jButtonRerpoteToken))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRegrasarMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegrasarMenuPrincipalActionPerformed
        Start.ejecutar.irMenuPrincipal();
    }//GEN-LAST:event_jButtonRegrasarMenuPrincipalActionPerformed

    private void jButtonRecuperadorErrorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRecuperadorErrorActionPerformed
        cargar(4);
    }//GEN-LAST:event_jButtonRecuperadorErrorActionPerformed

    private void jButtonReportesErrorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReportesErrorActionPerformed
        cargar(1);
    }//GEN-LAST:event_jButtonReportesErrorActionPerformed

    private void jButtonRerpoteTokenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRerpoteTokenActionPerformed
        cargar(2);
    }//GEN-LAST:event_jButtonRerpoteTokenActionPerformed

    private void jButtonResumenTokenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResumenTokenActionPerformed
        cargar(3);
    }//GEN-LAST:event_jButtonResumenTokenActionPerformed
    /*
     int tipoTabla 
    1 = reporteErrores
    2 = reporteTokens
    3 = reporteTokensResumido
    4 = Recuperador Error
     */
    private void desctivarBotones(int tipo) {
        switch (tipo) {
            case 1:
                jButtonRecuperadorError.setVisible(true);
                jButtonReportesError.setVisible(false);
                jButtonRerpoteToken.setVisible(false);
                jButtonResumenToken.setVisible(false);
                break;
            case 2:
                jButtonRecuperadorError.setVisible(false);
                jButtonReportesError.setVisible(false);
                jButtonRerpoteToken.setVisible(false);
                jButtonResumenToken.setVisible(true);
                break;
            case 3:
                jButtonRecuperadorError.setVisible(false);
                jButtonReportesError.setVisible(false);
                jButtonRerpoteToken.setVisible(true);
                jButtonResumenToken.setVisible(false);
                break;
            case 4:
                jButtonRecuperadorError.setVisible(false);
                jButtonReportesError.setVisible(true);
                jButtonRerpoteToken.setVisible(false);
                jButtonResumenToken.setVisible(false);
                break;
        }
    }
// eliminara todo lo que esta en la tabla

    public void refrescar() {
        int filas = modelo.getRowCount();
        if (filas != 0) {
            for (int i = filas - 1; i >= 0; i--) {// limpieza de la tabla
                modelo.removeRow(i);
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonRecuperadorError;
    private javax.swing.JButton jButtonRegrasarMenuPrincipal;
    private javax.swing.JButton jButtonReportesError;
    private javax.swing.JButton jButtonRerpoteToken;
    private javax.swing.JButton jButtonResumenToken;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableReporte;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        ListadoToken[] listadoToken = ListadoToken.values();
        for (ListadoToken listadoToken1 : listadoToken) {
            int cantidadToken = 0;
            String lexema = "";
            for (Palabra palabra : listadoLexema) {
                if (palabra instanceof Lexema) {
                    Lexema ver = (Lexema) palabra;
                    if (ver.getTipoToken().toString().equals(listadoToken1.getNombre())) {
                        lexema += (new ManejadorTexto()).convertirListadoCaracter(ver.getPalabra()) + "\n";
                        cantidadToken++;
                    }
                }
            }
            modelo.addRow((new Object[]{lexema, listadoToken1, cantidadToken}));
        }
    }
}
