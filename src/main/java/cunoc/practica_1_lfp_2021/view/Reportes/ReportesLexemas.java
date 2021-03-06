/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package cunoc.practica_1_lfp_2021.view.Reportes;

import cunoc.practica_1_lfp_2021.Alfabeto.CaracterEspecial;
import cunoc.practica_1_lfp_2021.ManejadorTexto.ManejadorTexto;
import cunoc.practica_1_lfp_2021.Start;
import cunoc.practica_1_lfp_2021.Toke.Lexema;
import cunoc.practica_1_lfp_2021.Toke.ListadoToken;
import cunoc.practica_1_lfp_2021.Toke.Palabra;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 * @author Benjamín de Jesús Pérez Aguilar<@Drymnz>
 */
public class ReportesLexemas extends javax.swing.JPanel implements Runnable {

    private Thread ejecutar = new Thread(this);
    private DefaultTableModel modeloListadoToken;
    private DefaultTableModel modeloResumen;
    private ArrayList<Palabra> listadoLexema;

    /**
     * Creates new form ReportesLexemas
     */
    public ReportesLexemas() {
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

        jButton1 = new javax.swing.JButton();
        jScrollPaneResumen = new javax.swing.JScrollPane();
        jTableRemen = new javax.swing.JTable();
        jScrollPaneListadoToken = new javax.swing.JScrollPane();
        jTableListadoToken = new javax.swing.JTable();

        setBackground(new java.awt.Color(168, 210, 255));

        jButton1.setBackground(new java.awt.Color(254, 228, 64));
        jButton1.setText("Menu Principal");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTableRemen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPaneResumen.setViewportView(jTableRemen);

        jTableListadoToken.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPaneListadoToken.setViewportView(jTableListadoToken);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPaneResumen, javax.swing.GroupLayout.DEFAULT_SIZE, 1256, Short.MAX_VALUE)
                    .addComponent(jScrollPaneListadoToken, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneResumen, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneListadoToken, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ejecutar = new Thread(this);
        modeloListadoToken = null;
        modeloResumen = null;
        listadoLexema = null;
        Start.ejecutar.irMenuPrincipal();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPaneListadoToken;
    private javax.swing.JScrollPane jScrollPaneResumen;
    private javax.swing.JTable jTableListadoToken;
    private javax.swing.JTable jTableRemen;
    // End of variables declaration//GEN-END:variables
    public void cargarTablas(ArrayList<Palabra> listadoLexema) {
        this.listadoLexema = listadoLexema;
        modeloListadoToken = (DefaultTableModel) jTableListadoToken.getModel();
        modeloResumen = (DefaultTableModel) jTableRemen.getModel();
        refrescar(modeloResumen);
        refrescar(modeloListadoToken);
        cargarTitulos();
        cargarTabla();
    }

    public void refrescar(DefaultTableModel modelo) {
        int filas = modelo.getRowCount();
        if (filas != 0) {
            for (int i = filas - 1; i >= 0; i--) {// limpieza de la tabla
                modelo.removeRow(i);
            }
        }
    }

    // cargar el contenido a mostar en la tabla
    private void cargarTabla() {
        if (ejecutar.isDaemon() || ejecutar.isAlive()) {
            ejecutar.stop();
        }
        ejecutar.start();
        for (Palabra palabra : listadoLexema) {
            if (palabra != null) {
                if ((palabra instanceof Lexema)) {
                    try {
                        Lexema ver = (Lexema) palabra;
                        //{"nombre del token", "lexema", "posicionX","posicionY"};
                        modeloListadoToken.addRow(new Object[]{ver.getTipoToken().getNombre(), caracterEspecial((new ManejadorTexto()).convertirListadoCaracter(ver.getPalabra())), ver.getPosicionX(), ver.getPosicionY()});
                    } catch (IllegalThreadStateException e) {
                        System.out.println("Error de conversion de palabra a Lexema");
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }
    private String caracterEspecial(String verificar){
        CaracterEspecial[] listadoCaracterEspecial = CaracterEspecial.values();
        for (CaracterEspecial caracterEspecial : listadoCaracterEspecial) {
            if (caracterEspecial.getSimbolo().equals(verificar)) {
                return caracterEspecial.toString();
            }
        }
        return verificar;
    }

    // asignar titulos a las tablas
    private void cargarTitulos() {
        String[] reporteTokensResumido = {"lexema", "token", "cantidad"};
        String[] reporteTokens = {"nombre del token", "lexema", "posicionX", "posicionY"};
        modeloListadoToken.setColumnIdentifiers(reporteTokens);
        modeloResumen.setColumnIdentifiers(reporteTokensResumido);
    }
//hilo que contara cuantas veces se revipen los token

    @Override
    public void run() {
        ListadoToken[] listadoToken = ListadoToken.values();
        for (ListadoToken listadoToken1 : listadoToken) {
            int cantidadToken = 0;
            String lexema = "";
            for (int i = 0; i < listadoLexema.size(); i++) {
                if (listadoLexema.get(i) != null) {
                    if (listadoLexema.get(i) instanceof Lexema) {
                        try {
                            Lexema ver = (Lexema) listadoLexema.get(i);
                            if (ver.getTipoToken().toString().equals(listadoToken1.getNombre())) {
                                lexema += (new ManejadorTexto()).convertirListadoCaracter(ver.getPalabra()) + "\n";
                                cantidadToken++;
                            }
                        } catch (IllegalThreadStateException e) {
                            System.out.println("Error de conversion de palabra a Lexema");
                            System.out.println(e.getMessage());
                        }
                    }
                }
            }
            modeloResumen.addRow((new Object[]{lexema, listadoToken1, cantidadToken}));
        }
    }

}
