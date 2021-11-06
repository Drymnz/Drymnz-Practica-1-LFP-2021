/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cunoc.practica_1_lfp_2021.view.sub_ventanas;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author drymnz
 */
public class Acerca extends JPanel {
    
    public static final String NOMBRE_AUTOR = "Benjamín de Jesús Pérez AGuilar";
    public static final String NOMBRE_PROGRAMA = "Analisador sintactico -->  Analisador lexico";
    public static final String ESTADO = "Estudiante";
    
    private final int margen = 20;
    
    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g); //To change body of generated methods, choose Tools | Templates.
        g.drawString("Nombre : " + NOMBRE_AUTOR, 0, multiplicador(1));
        g.drawString("Nombre programa : " + NOMBRE_PROGRAMA, 0, multiplicador(2));
        g.drawString("Estado : " + ESTADO, 0, multiplicador(3));
    }

    private int multiplicador(int fila) {
        return (margen * fila);
    }
}
