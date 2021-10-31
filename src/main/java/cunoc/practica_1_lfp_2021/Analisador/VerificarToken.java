/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cunoc.practica_1_lfp_2021.Analisador;

import cunoc.practica_1_lfp_2021.Alfabeto.ListadoAlfabetoAFD;
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
        return contador == palabra.length;
    }

    // token si todos son numero 156165
    public boolean numeroEntero(Caracter[] palabra) {
        for (Caracter caracter : palabra) {
            if (caracter.getAlfabeto().equals(ListadoAlfabetoAFD.NUMERO.toString())) {
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
        return contador == palabra.length;
    }

    // token si todos son puntuacion ....
    public boolean puntuacion(Caracter[] palabra) {
        for (Caracter caracter : palabra) {
            if (caracter.getAlfabeto().equals(ListadoAlfabetoAFD.PUNTUACION.toString())) {
                contador++;
            }
        }
        return contador == palabra.length;
    }

    // verificar si es un patron de identificador
    public boolean esPatronIdentificador(Caracter[] palabra) {
        for (int i = 0; i < palabra.length; i++) {
            if ((i == 0) && (palabra[0].getAlfabeto().equals(ListadoAlfabetoAFD.LETRA.toString()))) {
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
