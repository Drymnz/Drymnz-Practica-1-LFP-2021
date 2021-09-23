/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cunoc.practica_1_lfp_2021.ManejadorTexto;

import java.util.ArrayList;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ManejadorTexto {

    private int posicionInicial;

    public ManejadorTexto(int posicionInicial) {
        this.posicionInicial = posicionInicial;
    }

    public ManejadorTexto() {
        this(0);
    }
    /*
    public ArrayList<String> dividirTextoPalabra(String texto) {
    ArrayList<String> listado = new ArrayList();
    String palabra = "";
    char temporal;
    while ((posicionInicial < texto.length())) {
    if (Character.isSpaceChar(temporal = texto.charAt(posicionInicial))) {
    listado.add(palabra);
    palabra = "";
    } else {
    palabra += temporal;
    }
    posicionInicial++;
    }
    return listado;
    }*/

    public ArrayList<String> dividirTextoLetras(String texto) {
        ArrayList<String> listado = new ArrayList();
        for (char caracter : texto.toCharArray()) {
            listado.add(String.valueOf(caracter));
        }
        return listado;
    }

}
