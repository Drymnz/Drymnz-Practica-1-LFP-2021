/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cunoc.practica_1_lfp_2021.Analisador;

import cunoc.practica_1_lfp_2021.Alfabeto.ListadoAlfabetoAFD;
import cunoc.practica_1_lfp_2021.Alfabeto.Numero;
import cunoc.practica_1_lfp_2021.Alfabeto.Puntuacion;
import cunoc.practica_1_lfp_2021.Toke.Caracter;

/**
 * @author Benjamín de Jesús Pérez Aguilar<@Drymnz>
 */
public class VerificarToken {

    private int contador = 0;

    // token si todos son agrupacion ((((
    public boolean agrupacion(Caracter[] palabra) {
        for (Caracter caracter : palabra) {
            if (caracter.getAlfabeto().equals(ListadoAlfabetoAFD.AGRUPACION.toString())) {
                contador++;
            }
        }
        return contador == 1;
    }

    // token si todos son numero 156165
    public boolean numeroEntero(Caracter[] palabra) {
        boolean ver = true;
        if (palabra.length > 1) {
            ver = !(palabra[0].getCaracter().equals(Numero.CERO)) && (palabra[1].getCaracter().equals(Numero.CERO));
        }
        for (int i = 0; i < palabra.length; i++) {
            if (ver && palabra[i].getAlfabeto().equals(ListadoAlfabetoAFD.NUMERO.toString())) {
                contador++;
            }
        }
        return contador == palabra.length;
    }

    // token si todos son operacion +++
    public boolean operacion(Caracter[] palabra) {
        for (Caracter caracter : palabra) {
            if (caracter.getAlfabeto().equals(ListadoAlfabetoAFD.OPERACION.toString())) {
                contador++;
            }
        }
        return contador == 1;
    }

    // token si todos son puntuacion ....
    public boolean puntuacion(Caracter[] palabra) {
        for (Caracter caracter : palabra) {
            if (caracter.getAlfabeto().equals(ListadoAlfabetoAFD.PUNTUACION.toString())) {
                contador++;
            }
        }
        return contador == 1;
    }

    // token literal "fdshoiasdfhfoihsdofai"
    public boolean literal(Caracter[] palabra) {
        if (palabra.length > 1) {
            boolean ver = (palabra[0].getCaracter().equals(Puntuacion.DOUBLE_QUOTE.getSimbolo()))
                    && (palabra[(palabra.length - 1)].getCaracter().equals(Puntuacion.DOUBLE_QUOTE.getSimbolo()));
            for (int i = 1; i < (palabra.length - 1); i++) {
                if (palabra[i].getAlfabeto().length() > 1) {
                    contador++;
                }
            }
            return contador == 1;
        } else {
            return false;
        }
    }

    // token comentario //comentario con el afabeto
    public boolean comentario(Caracter[] palabra) {
        if (palabra.length > 1) {
            boolean ver = (palabra[0].getCaracter().equals(Puntuacion.DIAGONAL.getSimbolo()))
                    && (palabra[1].getCaracter().equals(Puntuacion.DIAGONAL.getSimbolo()));
            for (int i = 2; i < (palabra.length); i++) {
                if (palabra[i].getAlfabeto().length() > 1) {
                    contador++;
                }
            }
            return contador == 1;
        } else {
            return false;
        }
    }

    // token literal caracter especial
    public boolean caracterEspecial(Caracter[] palabra) {
        for (Caracter caracter : palabra) {
            if (caracter.getAlfabeto().equals(ListadoAlfabetoAFD.CARACTER_ESPECIAL.toString())) {
                contador++;
            }
        }
        return contador == 1;
    }

    // verificar si es un patron de identificador
    public boolean esPatronIdentificador(Caracter[] palabra) {
        for (int i = 0; i < palabra.length; i++) {
            if ((i == 0) && ((palabra[0].getAlfabeto().equals(ListadoAlfabetoAFD.LETRA.toString()))
                    || ((palabra[0].getCaracter().equals(Puntuacion.GILLON_LESS.getSimbolo()))))) {
                contador++;
            }
            if ((i != 0) && ((palabra[i].getAlfabeto().equals(ListadoAlfabetoAFD.LETRA.toString()))) || ((palabra[i].getAlfabeto().equals(ListadoAlfabetoAFD.NUMERO.toString())))) {
                contador++;
            }
        }
        return contador == palabra.length;
    }
// verificar si es un patron de decimal

    public boolean esPatronDecimal(Caracter[] palabra) {
        for (int i = 0; i < (palabra.length - 1); i++) {
            if (((palabra[i].getAlfabeto().equals(ListadoAlfabetoAFD.NUMERO.toString())) && (palabra[i + 1].getAlfabeto().equals(ListadoAlfabetoAFD.NUMERO.toString())))
                    || ((palabra[i].getCaracter().equals(Puntuacion.POINT.getSimbolo())) && (palabra[i + 1].getAlfabeto().equals(ListadoAlfabetoAFD.NUMERO.toString())))
                    || ((palabra[i + 1].getCaracter().equals(Puntuacion.POINT.getSimbolo())) && (palabra[i].getAlfabeto().equals(ListadoAlfabetoAFD.NUMERO.toString())))) {
                contador++;
            }
        }
        if (palabra[palabra.length - 1].getAlfabeto().equals(ListadoAlfabetoAFD.NUMERO.toString())) {
            contador++;
        }
        return contador == palabra.length;
    }

    //set 
    public void setContador(int contador) {
        this.contador = contador;
    }
    // fin set
}
