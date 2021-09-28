/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cunoc.practica_1_lfp_2021.Analisador;

import cunoc.practica_1_lfp_2021.Alfabeto.ListadoAlfabetoAFD;
import cunoc.practica_1_lfp_2021.Alfabeto.Puntuacion;
import cunoc.practica_1_lfp_2021.Errores.ListadoErrorLexema;
import cunoc.practica_1_lfp_2021.ManejadorTexto.ManejadorTexto;
import cunoc.practica_1_lfp_2021.Toke.Caracter;
import cunoc.practica_1_lfp_2021.Toke.ListadoToken;
import java.util.ArrayList;

/**
 * @author Benjamín de Jesús Pérez Aguilar<@Drymnz>
 */
public class VerificadorPatronToken {

    private ListadoErrorLexema tipoErro;
    protected VerificadorAlfabeto verificacionAlfabeto = new VerificadorAlfabeto();
    protected String palabra;
    private Caracter[] listadoCaracter;
    private String listadoErrores = "";
    private int caracter = 0;// esta variable se encargara si cumple toda la palabra sobre el token
    private int posicion = 0;

    public VerificadorPatronToken(String palabra) {
        this.palabra = palabra;
    }

// los token simples, son los que solo un alfabeto manejan en su exprecion regular
    public boolean tokenSimple(ListadoToken tipoToken) {
        ArrayList<String> listdo = (new ManejadorTexto()).dividirTextoLetras(palabra);
        listadoCaracter = new Caracter[palabra.length()];
        for (String string : listdo) {
            switch (tipoToken) {
                case AGRUPACION:
                    pertenecePatron(verificacionAlfabeto.agrupacion(string), string, ListadoAlfabetoAFD.AGRUPACION.toString());
                    break;
                case OPERADOR:
                    pertenecePatron(verificacionAlfabeto.operacion(string), string, ListadoAlfabetoAFD.OPERACION.toString());
                    break;
                case PUNTUACION:
                    pertenecePatron(verificacionAlfabeto.puntuacion(string), string, ListadoAlfabetoAFD.PUNTUACION.toString());
                    break;
                case NUMERO:
                    pertenecePatron(verificacionAlfabeto.numero(string), string, ListadoAlfabetoAFD.NUMERO.toString());
                    break;
                default:
                    return false;
            }
        }
        return listdo.size() == caracter;
    }
// verificar si es un patron de identificador

    public boolean esPatronIdentificador() {
        ArrayList<String> listdo = (new ManejadorTexto()).dividirTextoLetras(palabra);
        for (int i = 0; i < listdo.size(); i++) {
            if (i == 0) {
                pertenecePatron(verificacionAlfabeto.letra(listdo.get(i)), listdo.get(i) , ListadoAlfabetoAFD.LETRA.toString());
            } else {
                switch(verificacionAlfabeto.letra(listdo.get(i))? 1 : (verificacionAlfabeto.numero(listdo.get(i)))? 2 : 3){
                    case 1: 
                        pertenecePatron(true, palabra, ListadoAlfabetoAFD.LETRA.toString());
                        break;
                    case 2: 
                        pertenecePatron(true, palabra, ListadoAlfabetoAFD.NUMERO.toString());
                        break;
                    case 3: 
                        pertenecePatron(false, palabra, ListadoAlfabetoAFD.LETRA.toString());
                        break;
                }
            }
        }
        return listdo.size() == caracter;
    }
// verificar si es un patron de decimal

    public boolean esPatronDecimal() {
        ArrayList<String> listdo = (new ManejadorTexto()).dividirTextoLetras(palabra);
        boolean banderaNumero = true;
        for (String string : listdo) {
            banderaNumero = verificacionAlfabeto.numero(string);
            if (banderaNumero) {
                pertenecePatron(banderaNumero, string, ListadoAlfabetoAFD.NUMERO.toString());
            } else {
                pertenecePatron((string.equals(Puntuacion.COMMAT.getSimbolo())), palabra,ListadoAlfabetoAFD.PUNTUACION.toString());
            }
        }
        return listdo.size() == caracter;
    }

    // metodo donde vera si aumentar por que su caracter fue correto  o no pertenece al alfabeto
    protected void pertenecePatron(boolean pertence, String letra, String alfabeto) {
        if (pertence) {
            listadoCaracter[posicion] = new Caracter(letra, alfabeto);
            caracter++;
        } else {
            listadoCaracter[posicion] = new Caracter(letra, ListadoErrorLexema.ALFABETO.toString());
            tipoErro = ListadoErrorLexema.ALFABETO;
            listadoErrores += (letra + ",");
        }
        posicion++;
    }

    public ListadoErrorLexema getTipoErro() {
        return tipoErro;
    }

    public String getListadoErrores() {
        return listadoErrores;
    }
// get y set 

    public String getPalabra() {
        return palabra;
    }

    public VerificadorAlfabeto getVerificacionAlfabeto() {
        return verificacionAlfabeto;
    }

    public Caracter[] getListadoCaracter() {
        return listadoCaracter;
    }
    public void reiniciar (String palabra){
        this.palabra = palabra;
        this.caracter = 0;
        this.posicion = 0;
    }
    // fin get y set 

}
