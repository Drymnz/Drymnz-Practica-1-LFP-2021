/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cunoc.practica_1_lfp_2021.Analisador;

import cunoc.practica_1_lfp_2021.Alfabeto.Puntuacion;
import cunoc.practica_1_lfp_2021.Errores.ListadoErrorLexema;
import cunoc.practica_1_lfp_2021.ManejadorTexto.ManejadorTexto;
import cunoc.practica_1_lfp_2021.Toke.ListadoToken;
import java.util.ArrayList;

/**
 * @author Benjamín de Jesús Pérez Aguilar<@Drymnz>
 */
public class VerificadorPatronToken {

    private ListadoErrorLexema tipoErro;
    private VerificadorAlfabeto verificacionAlfabeto;
    private String listadoErrores = "";
    private int caracter = 0;// esta variable se encargara si cumple toda la palabra sobre el token

// los token simples, son los que solo un alfabeto manejan en su exprecion regular
    public boolean tokenSimple(ListadoToken tipoToken, String palabra) {
        ArrayList<String> listdo = (new ManejadorTexto()).dividirTextoLetras(palabra);
        for (String string : listdo) {
            switch (tipoToken) {
                case AGRUPACION:
                    pertenecePatron(verificacionAlfabeto.agrupacion(string), string);
                    break;
                case OPERADOR:
                    pertenecePatron(verificacionAlfabeto.operacion(string), string);
                    break;
                case PUNTUACION:
                    pertenecePatron(verificacionAlfabeto.puntuacion(string), string);
                    break;
                case NUMERO:
                    pertenecePatron(verificacionAlfabeto.numero(string), string);
                    break;
                default:
                    return false;
            }
        }
        return listdo.size() == caracter;
    }
// verificar si es un patron de identificador

    public boolean esPatronIdentificador(String palabra) {
        ArrayList<String> listdo = (new ManejadorTexto()).dividirTextoLetras(palabra);
        for (int i = 0; i < listdo.size(); i++) {
            if (i == 0) {
                pertenecePatron(verificacionAlfabeto.letra(listdo.get(i)), listdo.get(i));
            } else {
                pertenecePatron((verificacionAlfabeto.letra(listdo.get(i)) | verificacionAlfabeto.numero(listdo.get(i))), listdo.get(i));
            }
        }
        return listdo.size() == caracter;
    }
// verificar si es un patron de decimal

    public boolean esPatronDecimal(String palabra) {
        ArrayList<String> listdo = (new ManejadorTexto()).dividirTextoLetras(palabra);
        boolean banderaNumero = true;
        for (String string : listdo) {
            banderaNumero = verificacionAlfabeto.numero(string);
            if (banderaNumero) {
                pertenecePatron(banderaNumero, string);
            } else {
                pertenecePatron((string.equals(Puntuacion.COMMAT.getSimbolo())), palabra);
            }
        }
        return listdo.size() == caracter;
    }

    // metodo donde vera si aumentar por que su caracter fue correto  o no pertenece al alfabeto
    private void pertenecePatron(boolean pertence, String letra) {
        if (pertence) {
            caracter++;
        } else {
            tipoErro = ListadoErrorLexema.ESTRUCTURA;
            listadoErrores += (letra + ",");
        }
    }

    public ListadoErrorLexema getTipoErro() {
        return tipoErro;
    }

    public String getListadoErrores() {
        return listadoErrores;
    }

}
