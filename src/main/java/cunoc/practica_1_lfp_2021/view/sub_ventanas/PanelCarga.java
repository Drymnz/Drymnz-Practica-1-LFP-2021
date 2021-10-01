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
 * @author Benjamín de Jesús Pérez Aguilar<@Drymnz>
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
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(this.colorProgreso);
        g.fillRect(0, 0, (int) progreso, this.getHeight());
        g.setColor(this.colorLetra);
        g.drawString(nombreCarga + ": " + calculoPorcentaje() + "%", (this.getWidth() / 3) - (nombreCarga.length()), this.getHeight() / 2);
    }

    public void setProgresoReferente(double referente, double valor) {
        double division = valor / referente;
        if (division < 1) {
            this.progreso = division * this.getWidth();
        } else {
            this.progreso = this.getWidth();
        }
    }

    private int calculoPorcentaje() {
        return (int) ((this.progreso / this.getWidth()) * 100);
    }

    //set y get
    public String getNombreCarga() {
        return nombreCarga;
    }

    public void setNombreCarga(String nombreCarga) {
        this.nombreCarga = nombreCarga;
    }

    public double getProgreso() {
        return progreso;
    }

    public void setProgreso(double progreso) {
        this.progreso = progreso;
    }

    public Color getFondo() {
        return fondo;
    }

    public void setFondo(Color fondo) {
        this.fondo = fondo;
    }

    public Color getColorProgreso() {
        return colorProgreso;
    }

    public void setColorProgreso(Color colorProgreso) {
        this.colorProgreso = colorProgreso;
    }

    public Color getColorLetra() {
        return colorLetra;
    }

    public void setColorLetra(Color colorLetra) {
        this.colorLetra = colorLetra;
    }
    //fin set y get
}
