/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cunoc.practica_1_lfp_2021.view.Reportes;

import cunoc.practica_1_lfp_2021.Errores.ErrorLexema;
import cunoc.practica_1_lfp_2021.Toke.Lexema;
import cunoc.practica_1_lfp_2021.Toke.Palabra;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Benjamín de Jesús Pérez Aguilar<@Drymnz>
 */
public class Tablero extends javax.swing.JPanel {

    private final String[] Titulo;
    private final Palabra tipo;
    private ArrayList<Palabra> listadoLexema = new ArrayList<>();
    private final DefaultTableModel Diseño_Tabla = new DefaultTableModel();

    /**
     * Creates new form Tablero
     *
     * @param listadoLexema
     * @param Titulo
     * @param tipo
     */
    public Tablero(ArrayList<Palabra> listadoLexema, String[] Titulo, Palabra tipo) {
        initComponents();
        this.listadoLexema = listadoLexema;
        this.Titulo = Titulo;
        this.tipo = tipo;
        cargarTabla();
    }

    public void Refrescar() {
        int filas = Diseño_Tabla.getRowCount();
        for (int i = filas - 1; i >= 0; i--) {// limpieza de la tabla
            Diseño_Tabla.removeRow(i);
        }
        for (Palabra listadoLexema : listadoLexema) {
            Diseño_Tabla.addRow(segunTipo(listadoLexema));
        }
    }

    private Object[] segunTipo(Palabra comparar) {
        if ((tipo instanceof ErrorLexema) && (comparar instanceof ErrorLexema)) {
            ErrorLexema ver = (ErrorLexema) comparar;
            return new Object[]{ver.getCaracter(), ver.getPosicionX(), ver.getPosicionY()};
        }
        if ((tipo instanceof Lexema) && (comparar instanceof Lexema)) {
            Lexema ver = (Lexema) comparar;
            return new Object[]{ver.getTipoToken().getNombre(), ver.getPalabra(), ver.getPosicionX(), ver.getPosicionY()};
        }
        return null;
    }

    private void cargarTabla() {
        tabla.setModel(Diseño_Tabla);
        Diseño_Tabla.setColumnIdentifiers(Titulo);
        Refrescar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
