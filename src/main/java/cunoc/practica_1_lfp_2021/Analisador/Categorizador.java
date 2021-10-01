/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cunoc.practica_1_lfp_2021.Analisador;

import cunoc.practica_1_lfp_2021.Errores.RecuperacionError;
import cunoc.practica_1_lfp_2021.ManejadorTexto.ManejadorTexto;
import cunoc.practica_1_lfp_2021.Start;
import cunoc.practica_1_lfp_2021.Toke.Palabra;
import cunoc.practica_1_lfp_2021.view.sub_ventanas.PanelCarga;
import java.util.ArrayList;

/**
 * @author Benjamín de Jesús Pérez Aguilar<@Drymnz>
 */
public class Categorizador extends Thread {

    private PanelCarga mostrarProgreso;
    private String texto;
    private boolean errorLexema;
    private int posicionY = 1;
    private int posicionX = 0;
    private ArrayList<Palabra> listadoPalbras = new ArrayList<>();

    public Categorizador(PanelCarga mostrarProgreso, String texto) {
        this.mostrarProgreso = mostrarProgreso;
        this.texto = texto;
        errorLexema = false;
    }

    private void categorizar() {
        int totalLetra = this.texto.length();
        int contador = 0;
        ArrayList<String> analisar = (new ManejadorTexto()).dividirTextoLetras(texto);
        String palabra = "";
        for (String caracterAnalisar : analisar) {
            if (!palabra.isEmpty() && (caracterAnalisar.equals("\n") || caracterAnalisar.equals(" "))) {
                analisar(palabra);
                palabra = "";
            } else {
                palabra += caracterAnalisar;
            }
            contador++;
            mostrarProgreso.setProgresoReferente(totalLetra, contador);
            contarFilaColumna(caracterAnalisar);
        }
        if (!palabra.isEmpty()) {
            analisar(palabra);
        }
    }

    // analisara si la palabra cumple un patron
    private void analisar(String palabra) {
        VerificadorPatronToken cumpleUnPatron = new VerificadorPatronToken(palabra, (posicionX - palabra.length()) + 1, posicionY);
        Palabra verificar = cumpleUnPatron.analisarPatron();
        if (verificar == null) {
            errorLexema = true;
            listadoPalbras.add((new RecuperacionError(cumpleUnPatron, posicionY, (posicionX - palabra.length()) + 1)).recuperarError());
        } else {
            listadoPalbras.add(verificar);
        }
    }

// indicador de posicion para la palabra en el reporte.
    private void contarFilaColumna(String string) {
        posicionX++;
        if (string.equals("\n")) {
            posicionY++;
            posicionX = 0;
        }
    }

    private void irReportes() {
        if (errorLexema) {
            Start.ejecutar.irReportesError(listadoPalbras);
        } else {
            Start.ejecutar.irReportesToken(listadoPalbras);
        }
    }

    @Override
    public void run() {
        try {
            categorizar();
            sleep(10);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            System.out.println("Local --->" + e.toString());
        }
        irReportes();
    }
}
