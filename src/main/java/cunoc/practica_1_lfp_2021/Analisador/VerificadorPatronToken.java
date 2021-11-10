/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cunoc.practica_1_lfp_2021.Analisador;

import cunoc.practica_1_lfp_2021.Alfabeto.ListadoAlfabetoAFD;
import cunoc.practica_1_lfp_2021.Errores.ListadoErrorLexema;
import cunoc.practica_1_lfp_2021.ManejadorTexto.ManejadorTexto;
import cunoc.practica_1_lfp_2021.Toke.*;
import java.util.ArrayList;

/**
 * @author Benjamín de Jesús Pérez Aguilar<@Drymnz>
 */
public class VerificadorPatronToken {

    private final ListadoAlfabetoAFD[] listadoAlfabeto = ListadoAlfabetoAFD.values();
    private final ListadoToken[] listadoToken = ListadoToken.values();
    private final VerificadorAlfabeto verificacionAlfabeto = new VerificadorAlfabeto();
    private final VerificarToken verificacionToken = new VerificarToken();
    private String palabra;
    private String listadoError;
    private Caracter[] listadoCaracter;
    private int posicion = 0;// posicion para el listado de caracter
    private int posicionY;
    private int posicionX;

    public VerificadorPatronToken(String palabra, int posicionX, int posicionY) {
        this.palabra = palabra;
        this.posicionY = posicionY;
        this.posicionX = posicionX;
    }

    public Lexema analisarPatron() {
        listadoCaracter = new Caracter[palabra.length()];
        ArrayList<String> listdo = (new ManejadorTexto()).dividirTextoLetras(palabra);
        for (String string : listdo) {
            ListadoAlfabetoAFD pertence = pertenceAlfabeto(string);
            listadoCaracter[posicion] = asignarCaracter((pertence == null), pertence, string);
            posicion++;
        }
        ListadoToken pertneceToken = pertenceToken(this.listadoCaracter);
        return asignarPalabra(pertneceToken == null, pertneceToken);
    }

    // verificar si esta dentro del alfabeto que del enum
    public ListadoAlfabetoAFD pertenceAlfabeto(String string) {
        for (ListadoAlfabetoAFD listadoAlfabetoAFD : listadoAlfabeto) {
            if (asignarAlfabeto(listadoAlfabetoAFD, string)) {
                return listadoAlfabetoAFD;
            }
        }
        return null;
    }

    // ver si el caracter pertenece al alfabeto
    public boolean asignarAlfabeto(ListadoAlfabetoAFD tipoToken, String string) {
        switch (tipoToken) {
            case AGRUPACION:
                return verificacionAlfabeto.agrupacion(string);
            case OPERACION:
                return verificacionAlfabeto.operacion(string);
            case PUNTUACION:
                return verificacionAlfabeto.puntuacion(string);
            case NUMERO:
                return verificacionAlfabeto.numero(string);
            case LETRA:
                return verificacionAlfabeto.letra(string);
            case CARACTER_ESPECIAL:
                return verificacionAlfabeto.caracterEspecial(string);
            case PALABRA_RESERVADA:
                return verificacionAlfabeto.caracterPalabraReservada(string);
            default:
                return false;
        }
    }

    // asignar el caracter a listado de caracter para forma la palabra
    private Caracter asignarCaracter(boolean error, ListadoAlfabetoAFD pertence, String letra) {
        if (error) {
            return new Caracter(letra, ListadoErrorLexema.ALFABETO.getNombre());
        } else {
            listadoError += letra;
            return new Caracter(letra, pertence.toString());
        }
    }

    // verifica que token le pertence sino hay return null
    public ListadoToken pertenceToken(Caracter[] palabra) {
        for (ListadoToken listadoToken : listadoToken) {
            if (pertneceAlToken(listadoToken, palabra)) {
                return listadoToken;
            }
        }
        return null;
    }

    ///busca si pertene a un toke
    public boolean pertneceAlToken(ListadoToken tipoToken, Caracter[] palabra) {
        verificacionToken.setContador(0);
        switch (tipoToken) {
            case AGRUPACION:
                return verificacionToken.agrupacion(palabra);
            case NUMERO:
                return verificacionToken.numeroEntero(palabra);
            case OPERADOR:
                return verificacionToken.operacion(palabra);
            case PUNTUACION:
                return verificacionToken.puntuacion(palabra);
            case IDENTIFICADOR:
                return verificacionToken.esPatronIdentificador(palabra);
            case CARACTER_ESPECIAL:
                return verificacionToken.caracterEspecial(palabra);
            case COMENTARIO:
                return verificacionToken.comentario(palabra);
            case LITERAL:
                return verificacionToken.literal(palabra);
            case PALABRA_CLAVE:
                return verificacionToken.palabrasReservadas(palabra);
            default:
                return false;
        }
    }

    private Lexema asignarPalabra(boolean error, ListadoToken pertneceToken) {
        if (error) {
            return null;
        } else {
            return new Lexema(pertneceToken, listadoCaracter, posicionX, posicionY);
        }
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

    public void reiniciar(String palabra) {
        this.palabra = palabra;
        this.posicion = 0;
    }
    // fin get y set 

}
