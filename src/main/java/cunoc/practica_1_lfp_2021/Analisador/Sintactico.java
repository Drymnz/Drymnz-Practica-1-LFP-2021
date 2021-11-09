/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cunoc.practica_1_lfp_2021.Analisador;

import cunoc.practica_1_lfp_2021.ManejadorTexto.ManejadorTexto;
import cunoc.practica_1_lfp_2021.Toke.Caracter;
import cunoc.practica_1_lfp_2021.view.sub_ventanas.PanelCarga;
import java.util.ArrayList;

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
        int totalLetra = texto.length();
        int contador = 0;
        mostrarProgreso.setProgreso(contador);
        ArrayList<String> analisar = (new ManejadorTexto()).dividirTextoLetras(texto);
        String palabraAntes = "";
        String palabra = "";
        boolean esperar = true;
        for (String string : analisar) {
        
            palabraAntes = palabra;
            contador++;
            mostrarProgreso.setProgresoReferente(totalLetra, contador);
            contarFilaColumna(string);
        }
        if (!palabra.isEmpty() && !palabra.equals("\n") && !palabra.equals(" ")) {
            analisar(palabra);
        }
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
