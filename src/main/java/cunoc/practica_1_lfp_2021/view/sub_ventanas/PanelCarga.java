/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cunoc.practica_1_lfp_2021.view.sub_ventanas;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class PanelCarga extends JPanel {

    private String nombreCarga;
    private double progreso;
    private Color fondo;
    private Color colorProgreso;
    private Color colorLetra;

    public PanelCarga(String nombreCarga, double progreso, Color fondo, Color colorProgreso, Color colorLetra) {
        this.nombreCarga = nombreCarga;
        this.progreso = progreso;
        this.fondo = fondo;
        this.colorProgreso = colorProgreso;
        this.colorLetra = colorLetra;
    }

    public PanelCarga() {
        this("Cargando", 0, Color.WHITE, Color.GREEN, Color.black);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        g.drawString(nombreCarga + ": "+this.progreso +"%", this.getWidth() - (nombreCarga.length() / 2), 0);
        g.setColor(this.colorProgreso);
        g.fillRect(0, 0, (int) progreso, this.getHeight());
    }

    public void cantidaReferente(double referente, double valor) {
        double division = valor / referente;
        if (division < 1) {
            this.progreso = division * 100;
        } else {
            this.progreso = 100;
        }
    }
}
