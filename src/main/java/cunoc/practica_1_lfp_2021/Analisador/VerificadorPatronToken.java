/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cunoc.practica_1_lfp_2021.Analisador;

import cunoc.practica_1_lfp_2021.Errores.ListadoErrorLexema;
import cunoc.practica_1_lfp_2021.ManejadorTexto.ManejadorTexto;
import cunoc.practica_1_lfp_2021.Toke.ListadoToken;
import java.util.ArrayList;

/**
 *
 * @author Benjamín de Jesús Pérez <@Drymnz>
 */
public class VerificadorPatronToken {

    private ListadoErrorLexema tipoErro;
    private VerificadorAlfabeto verificarLetra;
    private int caracter = 0;// esta variable se encargara si cumple toda la palabra sobre el token

    public boolean verificarExtrutura(ListadoToken tipoToken, String palabra) {
        ArrayList<String> listdo = (new ManejadorTexto()).dividirTextoLetras(palabra);
        for (String string : listdo) {
            switch (tipoToken) {
                case AGRUPACION:
                    if (verificarLetra.agrupacion(string)) {
                        caracter++;
                    }
                    break;
                case OPERADOR:
                    if (verificarLetra.operacion(string)) {
                        caracter++;
                    }
                    break;
                case PUNTUACION:
                    if (verificarLetra.puntuacion(string)) {
                        caracter++;
                    }
                    break;
                case NUMERO:
                    if (verificarLetra.numero(string)) {
                        caracter++;
                    }
                    break;
            }
        }
        return listdo.size() == caracter;
    }

    /*    private boolean tokenIdentificador(ArrayList<String> listdo) {
    if (listdo.get(0)) {
    
    }
    return listdo.size() == caracter;
    }*/
}
