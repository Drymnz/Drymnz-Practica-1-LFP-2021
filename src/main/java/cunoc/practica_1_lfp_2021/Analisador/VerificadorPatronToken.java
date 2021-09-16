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
    private VerificadorAlfabeto verificacionAlfabeto;
    private int caracter = 0;// esta variable se encargara si cumple toda la palabra sobre el token
// los token simples, son los que solo un alfabeto manejan en su exprecion regular
    public boolean tokenSimple(ListadoToken tipoToken, String palabra) {
        ArrayList<String> listdo = (new ManejadorTexto()).dividirTextoLetras(palabra);
        for (String string : listdo) {
            switch (tipoToken) {
                case AGRUPACION:
                    perteneceAlfabeto(verificacionAlfabeto.agrupacion(string));
                    break;
                case OPERADOR:
                    perteneceAlfabeto(verificacionAlfabeto.operacion(string));
                    break;
                case PUNTUACION:
                    perteneceAlfabeto(verificacionAlfabeto.puntuacion(string));
                    break;
                case NUMERO:
                    perteneceAlfabeto(verificacionAlfabeto.numero(string));
                    break;
                default:
                    return false;
            }
        }
        return listdo.size() == caracter;
    }

    // metodo donde vera si aumentar por que su caracter fue correto o no pertenece al alfabeto
    private void perteneceAlfabeto(boolean pertence) {
        if (pertence) {
            caracter++;
        } else {
            tipoErro = ListadoErrorLexema.ALFABETO;
        }
    }
    // fin

}
