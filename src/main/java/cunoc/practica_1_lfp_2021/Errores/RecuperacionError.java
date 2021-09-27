/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cunoc.practica_1_lfp_2021.Errores;

import cunoc.practica_1_lfp_2021.Alfabeto.ListadoAlfabetoAFD;
import cunoc.practica_1_lfp_2021.Alfabeto.Puntuacion;
import cunoc.practica_1_lfp_2021.Analisador.Categorizador;
import cunoc.practica_1_lfp_2021.Analisador.VerificadorPatronToken;
import cunoc.practica_1_lfp_2021.Toke.Caracter;
import cunoc.practica_1_lfp_2021.Toke.ListadoToken;
import cunoc.practica_1_lfp_2021.view.Reportes.SubReporteToken.ListadoResumenToken;

/**
 * @author Benjamín de Jesús Pérez Aguilar<@Drymnz>
 */
public class RecuperacionError {

    private VerificadorPatronToken verificadorPatron;
    private Categorizador verTipoToken;

    private final String INDICAR = "<-- Error, en ";
    private final String INDICARTOKEN = ", pero dectecta token : ";

    public RecuperacionError(VerificadorPatronToken verificadorPatron, Categorizador verTipoToken) {
        this.verificadorPatron = verificadorPatron;
        this.verTipoToken = verTipoToken;
    }

    public String recuperarError() {
        String returnarString = "";
        returnarString += indicar();
        boolean primeraVez = true;
        Caracter[] listadoCaracter = verificadorPatron.getListadoCaracter();
        String palabra = listadoCaracter[0].getCaracter();
        for (int i = 0; i < (listadoCaracter.length - 1); i++) {
            if (listadoCaracter[i].getAlfabeto().equals(listadoCaracter[i + 1].getAlfabeto())) {
                palabra += listadoCaracter[i + 1].getCaracter();
            } else if ((tokenComplejo(palabra, listadoCaracter[i], listadoCaracter[i + 1]))) {
                palabra += listadoCaracter[i + 1].getCaracter();
            } else {
                returnarString = tokenPosibles(primeraVez, palabra, 
                        verTipoToken.tipoToken(palabra, verificadorPatron, verificadorPatron)
                        , palabra + listadoCaracter[i+1].getCaracter());
                palabra = "";
            }
        }
        return returnarString;
    }

    private boolean tokenComplejo(String palabra, Caracter anterior, Caracter siguiente) {
        //si es un id con empieza con letra y pude ir (numero)+ | (letras)+
        verificadorPatron.reiniciar(palabra);
        if (verificadorPatron.esPatronIdentificador()) {
            if ((siguiente.getAlfabeto().equals(ListadoAlfabetoAFD.LETRA.toString())) || (siguiente.getAlfabeto().equals(ListadoAlfabetoAFD.NUMERO.toString()))) {
                return true;
            } else {
                return false;
            }
        }
        //si es un decimal con estructura de muchos numeros + (punto . )  muchos numeros +
        if ( (anterior.getAlfabeto().equals(ListadoAlfabetoAFD.NUMERO.toString()) && siguiente.getAlfabeto().equals(ListadoAlfabetoAFD.NUMERO.toString())) 
                | 
                (anterior.getAlfabeto().equals(ListadoAlfabetoAFD.NUMERO.toString()) && siguiente.getAlfabeto().equals(Puntuacion.POINT.getSimbolo()))
                    |
                    ( anterior.getAlfabeto().equals(Puntuacion.POINT.getSimbolo()) && siguiente.getAlfabeto().equals(ListadoAlfabetoAFD.NUMERO.toString()))) {
            return true;
        }
        return false;
    }

    private String indicar() {
        return verificadorPatron.getPalabra() + INDICAR;
    }

    private String tokenPosibles(boolean primeraVez, String en, ListadoToken token, String stringToken) {
        if (primeraVez) {
            // 585f3.40 <--Error en 585f , pero dectectado token decimal = 3.5
            return en + INDICARTOKEN + indicarToken(token, INDICARTOKEN);
        } else {
            return indicarToken(token, INDICARTOKEN);
        }
    }

    private String indicarToken(ListadoToken token, String stringToken) {
        return token.getNombre()+ " = " + stringToken + ",";
    }
}
