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
public class Lexico extends Thread {

    protected PanelCarga mostrarProgreso;
    protected String texto;
    protected boolean errorLexema;
    protected int posicionY = 1;
    protected int posicionX = 0;
    protected ArrayList<Palabra> pilaToken = new ArrayList<>();

    public Lexico(PanelCarga mostrarProgreso, String texto) {
        this.mostrarProgreso = mostrarProgreso;
        this.texto = texto;
        errorLexema = false;
    }

    protected void categorizar() {
        int totalLetra = this.texto.length();
        int contador = 0;
        mostrarProgreso.setProgreso(contador);
        ArrayList<String> analisar = (new ManejadorTexto()).dividirTextoLetras(texto);
        String palabra = "";
        for (String caracterAnalisar : analisar) {
            boolean loAnalisastes = false;
            boolean terminoPalabra = ((new VerificadorAlfabeto()).caracterEspecial(caracterAnalisar)
                    || comentarioLiteral(palabra, caracterAnalisar));
            boolean parentesi = (new VerificadorAlfabeto()).agrupacion(caracterAnalisar) || (new VerificadorAlfabeto()).puntuacion(caracterAnalisar)
                    || (new VerificadorAlfabeto()).caracterEspecial(caracterAnalisar);
            if (parentesi) {

                if (!palabra.isEmpty()) {
                    ArrayList<String> verEsteAnalisis = (new ManejadorTexto()).dividirTextoLetras(palabra);
                    if ((((verEsteAnalisis.size() >= 1))
                            && (verEsteAnalisis.get(0).equals("\"")
                            || verEsteAnalisis.get(0).equals("/")))) {
                        palabra += caracterAnalisar;
                    }
                } else {
                    analisar(caracterAnalisar);
                    loAnalisastes = true;
                }
            } else if (!palabra.isEmpty() && terminoPalabra) {
                analisar(palabra);
                loAnalisastes = true;
                palabra = "";
            } else {
                palabra += caracterAnalisar;
            }
            if (terminoPalabra) {
                if (!loAnalisastes) {
                    analisar(palabra);
                }
                palabra = "";
            }
            contador++;
            mostrarProgreso.setProgresoReferente(totalLetra, contador);
            contarFilaColumna(caracterAnalisar);
        }
        if (!palabra.isEmpty() && !palabra.equals("\n") && !palabra.equals(" ")) {
            analisar(palabra);
        }
    }

    protected boolean comentarioLiteral(String palabra, String caracterAnalisar) {
        boolean seretorna = false;
        seretorna = ((caracterAnalisar.equals("\"") || caracterAnalisar.equals("/")) && palabra.isEmpty());
        if (seretorna) {
            return false;
        }
        if (!seretorna) {
            ArrayList<String> analisar = (new ManejadorTexto()).dividirTextoLetras(palabra);
            seretorna = (analisar.size() > 2)
                    && analisar.get(0).equals("/")
                    && analisar.get(1).equals("/")
                    && analisar.get((analisar.size() - 1)).equals("\n");
        }
        if (!seretorna) {
            ArrayList<String> analisar = (new ManejadorTexto()).dividirTextoLetras(palabra);
            seretorna = (analisar.size() > 2)
                    && analisar.get(0).equals("\"")
                    && analisar.get((analisar.size() - 1)).equals("\"");
        }
        if (!seretorna) {
            seretorna = caracterAnalisar.equals(" ");
            if (seretorna) {
                VerificadorPatronToken cumpleUnPatron = new VerificadorPatronToken(palabra, (posicionX - palabra.length()) + 1, posicionY);
                Palabra verificar = cumpleUnPatron.analisarPatron();
                if (verificar == null) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        return seretorna;
    }

    // analisara si la palabra cumple un patron
    protected void analisar(String palabra) {
        VerificadorPatronToken cumpleUnPatron = new VerificadorPatronToken(palabra, (posicionX - palabra.length()) + 1, posicionY);
        Palabra verificar = cumpleUnPatron.analisarPatron();
        if (verificar == null) {
            errorLexema = true;
            pilaToken.add((new RecuperacionError(cumpleUnPatron, posicionY, (posicionX - palabra.length()) + 1)).recuperarError());
        } else {
            pilaToken.add(verificar);
        }
    }

// indicador de posicion para la palabra en el reporte.
    protected void contarFilaColumna(String string) {
        posicionX++;
        if (string.equals("\n")) {
            posicionY++;
            posicionX = 0;
        }
    }

    protected void irReportes() {
        try {
            if (errorLexema) {
                Start.ejecutar.irReportesError(pilaToken);
            } else {
                Start.ejecutar.irReportesToken(pilaToken);
            }
        } catch (IllegalThreadStateException e) {
            System.out.println(e.getMessage());
            System.out.println(e.toString());
            System.out.println("Al ir reportes");
        }

    }

    @Override
    public void run() {
        try {
            categorizar();
            sleep(10);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.fillInStackTrace().toString());
            System.out.println("Local --->" + e.toString());
        }
        irReportes();
    }
}
