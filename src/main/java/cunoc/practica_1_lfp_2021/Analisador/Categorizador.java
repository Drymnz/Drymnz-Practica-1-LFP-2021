/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cunoc.practica_1_lfp_2021.Analisador;

import cunoc.practica_1_lfp_2021.view.sub_ventanas.PanelCarga;

/**
 *
 * @author Benjamín de Jesús Pérez <@Drymnz>
 */
public class Categorizador extends Thread {

    private PanelCarga mostrarProgreso;
    private String texto;

    public Categorizador(PanelCarga mostrarProgreso, String texto) {
        this.mostrarProgreso = mostrarProgreso;
        this.texto = texto;
    }

    @Override
    public void run() {
        for (int i = 0; i < 11; i++) {
            try {
                mostrarProgreso.setProgresoReferente(100, i * 10);
                sleep(1000);
            } catch (Exception e) {
            }
        }
    }
}
