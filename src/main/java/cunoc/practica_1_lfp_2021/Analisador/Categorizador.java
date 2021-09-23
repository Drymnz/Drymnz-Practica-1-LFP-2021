/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cunoc.practica_1_lfp_2021.Analisador;

import cunoc.practica_1_lfp_2021.Errores.ErrorLexema;
import cunoc.practica_1_lfp_2021.ManejadorTexto.ManejadorTexto;
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
    }
// analisara si la palabra cumple un patron
    private void analisar(String palabra) {
        VerificadorPatronToken analisar = null;
        ListadoToken menorFallo = null;
        ListadoToken[] listadoTipoToken = ListadoToken.values();
        String caracterFallo  = "";
        for (int i = 0; i < listadoTipoToken.length; i++) {
            if (((analisar = new VerificadorPatronToken()).tokenSimple(listadoTipoToken[i], palabra)) || ((listadoTipoToken[i] == ListadoToken.IDENTIFICADOR && analisar.esPatronIdentificador(palabra) || (listadoTipoToken[i] == ListadoToken.DECIMAL && analisar.esPatronDecimal(palabra))))) {
                listadoPalbras.add(new Lexema(listadoTipoToken[i], palabra, contadorFila, (contadorColumna - palabra.length())));
                i = listadoTipoToken.length;
            }else if (caracterFallo.isEmpty() || (caracterFallo.length() > analisar.getListadoErrores().length())){
                menorFallo = listadoTipoToken[i];
            }
        }
        if (menorFallo != null) {
            errorLexema = true;
            listadoPalbras.add((new ErrorLexema(caracterFallo, analisar.getTipoErro(), palabra, contadorFila, (contadorColumna - palabra.length()))));
        }
    }

    private void irReportes() {
        if (errorLexema) {

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
        }
    }
}
