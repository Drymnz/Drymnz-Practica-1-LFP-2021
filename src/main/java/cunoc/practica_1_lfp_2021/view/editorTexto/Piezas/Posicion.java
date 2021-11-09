/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cunoc.practica_1_lfp_2021.view.editorTexto.Piezas;

import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author drymnz
 */
public class Posicion extends JPanel {

    private final int margen = 20;
    private JTextArea ver;
    private int maximoCaracter = 0;

    public Posicion() {

    }

    public Posicion(JTextArea ver) {
        this.ver = ver;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g); //To change body of generated methods, choose Tools | Templates.
        try {
            if (ver != null) {
                Thread.sleep(3);
                g.drawString("Total Lineas : " + ver.getLineCount(), 0, multiplicador(1));// menciona cuantas lineas tiene el documento
                g.drawString("Total Caracter :" + maximo(ver.getText().length()), 155, multiplicador(1));// este es la cantida de caracters escritos
                g.drawString(posicion(), 350, multiplicador(1));// este es la cantida de caracters escritos 
            }
        } catch (Exception e) {
        }
    }

    private String posicion() {
        int linea = 1;
        int columna = 1;
        try {
            if (ver != null) {
                Thread.sleep(3);
                int posicion = ver.getCaretPosition();
                linea = ver.getLineOfOffset(posicion);
                columna = posicion - ver.getLineStartOffset(linea);
            }
            linea += 1;
        } catch (Exception ex) {
        }
        return " Posicion --> Linea(Y) : " + linea + " Columno(X) : " + columna;
    }

    private int maximo(int comparar) {
        if ((maximoCaracter <= comparar)) {
            maximoCaracter = comparar;
        }
        return maximoCaracter;
    }

    private int multiplicador(int fila) {
        return (margen * fila);
    }

    public void setVer(JTextArea ver) {
        this.ver = ver;
    }

}
