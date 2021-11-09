/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cunoc.practica_1_lfp_2021.Analisador;

import cunoc.practica_1_lfp_2021.view.sub_ventanas.PanelCarga;

/**
 *
 * @author drymnz
 */
public class Sintactico extends Lexico {

    public Sintactico(PanelCarga mostrarProgreso, String texto) {
        super(mostrarProgreso, texto);
    }

    @Override
    protected void categorizar() {
        super.categorizar(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void analisar(String palabra) {
        super.analisar(palabra); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void contarFilaColumna(String string) {
        super.contarFilaColumna(string); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void irReportes() {
        super.irReportes(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.
    }
}
