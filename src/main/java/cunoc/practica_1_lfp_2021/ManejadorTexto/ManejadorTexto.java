/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cunoc.practica_1_lfp_2021.ManejadorTexto;

import cunoc.practica_1_lfp_2021.Toke.Caracter;
import java.util.ArrayList;

/**
 * @author Benjamín de Jesús Pérez Aguilar<@Drymnz>
 */
public class ManejadorTexto {

    public ArrayList<String> dividirTextoLetras(String texto) {
        ArrayList<String> listado = new ArrayList();
        for (char caracter : texto.toCharArray()) {
            listado.add(String.valueOf(caracter));
        }
        return listado;
    }

    public ArrayList<String> dividirTextoPalabra(String texto) {
        ArrayList<String> listado = new ArrayList();
        String palabra = "";
        for (char caracter : texto.toCharArray()) {
            String ver = String.valueOf(caracter);
            if (ver.equals(" ")) {
                listado.add(palabra);
                palabra = "";
            } else {
                palabra += ver;
            }
        }
        if (!palabra.isEmpty()) {
           listado.add(palabra); 
        }
        return listado;
    }

    public String convertirListadoCaracter(Caracter[] listado) {
        String recolectando = "";
        for (Caracter caracter : listado) {
            recolectando += caracter.getCaracter();
        }
        return recolectando;
    }

    public Caracter[] stringCaracter(String texto) {
        ArrayList<String> listadoLetra = dividirTextoLetras(texto);
        Caracter[] listado = new Caracter[listadoLetra.size()];
        for (String string : listadoLetra) {
            for (Caracter caracter : listado) {
                caracter = new Caracter(string, "ESPERA");
            }
        }
        return listado;
    }

}
