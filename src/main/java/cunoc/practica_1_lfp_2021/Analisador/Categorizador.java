/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cunoc.practica_1_lfp_2021.Analisador;

import cunoc.practica_1_lfp_2021.Errores.ErrorLexema;
import cunoc.practica_1_lfp_2021.Errores.RecuperacionError;
import cunoc.practica_1_lfp_2021.ManejadorTexto.ManejadorTexto;
import cunoc.practica_1_lfp_2021.Start;
import cunoc.practica_1_lfp_2021.Toke.Lexema;
import cunoc.practica_1_lfp_2021.Toke.ListadoToken;
import cunoc.practica_1_lfp_2021.Toke.Palabra;
import cunoc.practica_1_lfp_2021.view.sub_ventanas.PanelCarga;
import java.util.ArrayList;

/**
 * @author Benjamín de Jesús Pérez Aguilar<@Drymnz>
 */
public class Categorizador extends Thread {

    private PanelCarga mostrarProgreso;
    private String texto;
    private VerificadorPatronToken analisar = null;
    private ListadoToken dar = null;
    private VerificadorPatronToken analisarError = null;
    private boolean errorLexema;
    private int contadorFila = 1;
    private int contadorColumna = 0;
    private ArrayList<Palabra> listadoPalbras = new ArrayList<>();

    public Categorizador(PanelCarga mostrarProgreso, String texto) {
        this.mostrarProgreso = mostrarProgreso;
        this.texto = texto;
    }

    private void categorizarToken() {
        int totalLetra = this.texto.length();
        ArrayList<String> analisar = (new ManejadorTexto()).dividirTextoLetras(texto);
        String palabra = "";
        for (String string : analisar) {
            contarFilaColumna(string);
            if (string.equals("\n") || string.equals(" ")) {
                analisar(palabra);
            } else {
                palabra += string;
            }
            mostrarProgreso.setProgresoReferente(totalLetra, contadorFila * contadorColumna);
        }
        if (!palabra.isEmpty()) {
            analisar(palabra);
        }
    }
// analisara si la palabra cumple un patron

    private void analisar(String palabra) {
        analisar = null;
        dar = null;
        analisarError = null;
        if (((dar = tipoToken(palabra)) == null) && analisarError != null) {
            errorLexema = true;
            listadoPalbras.add((new ErrorLexema(analisarError.getListadoErrores(), (new RecuperacionError(analisarError, this)).recuperarError(), analisar.getTipoErro(), analisarError.getListadoCaracter(), (contadorColumna - palabra.length()), contadorFila)));
        } else if (analisar != null) {
            listadoPalbras.add(new Lexema(dar, analisar.getListadoCaracter(), (contadorColumna - palabra.length()), contadorFila));
        }
    }

    public ListadoToken tipoToken(String palabra) {
        ListadoToken[] listadoTipoToken = ListadoToken.values();
        String caracterFallo = "";
        for (int i = 0; i < listadoTipoToken.length; i++) {
            if (((analisar = new VerificadorPatronToken(palabra)).tokenSimple(listadoTipoToken[i])) || ((listadoTipoToken[i] == ListadoToken.IDENTIFICADOR && analisar.esPatronIdentificador() || (listadoTipoToken[i] == ListadoToken.DECIMAL && analisar.esPatronDecimal())))) {
                listadoPalbras.add(new Lexema(listadoTipoToken[i], analisar.getListadoCaracter(), contadorFila, (contadorColumna - palabra.length())));
                return listadoTipoToken[i];
            } else if ((caracterFallo.isEmpty() || (caracterFallo.length() > analisar.getListadoErrores().length()))) {
                analisarError = analisar;
            }
        }
        return null;
    }

    private void irReportes() {
        if (errorLexema) {
            Start.ejecutar.irReportesError(listadoPalbras);
        } else {

        }
    }
// indicador de posicion para la palabra en el reporte.

    private void contarFilaColumna(String string) {
        if (string.equals("\n")) {
            contadorFila++;
            contadorColumna = 0;
        }
        contadorColumna++;
    }

    @Override
    public void run() {
        try {
            categorizarToken();
            sleep(10);
            irReportes();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
