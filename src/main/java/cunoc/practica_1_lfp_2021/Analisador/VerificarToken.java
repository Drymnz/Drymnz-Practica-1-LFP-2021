/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cunoc.practica_1_lfp_2021.Analisador;

import cunoc.practica_1_lfp_2021.Alfabeto.*;
import cunoc.practica_1_lfp_2021.Toke.Caracter;

/**
 * @author Benjamín de Jesús Pérez Aguilar<@Drymnz>
 */
public class VerificarToken {

    private int contador = 0;

    // token si todos son numero 156165 -1859
    public boolean numeroEntero(Caracter[] palabra) {
        boolean ver = true;
        if (palabra.length > 1) {

            ver = !(palabra[0].getCaracter().equals(Numero.CERO.toString()) && palabra[1].getCaracter().equals(Numero.CERO.toString()));
        }
        for (int i = 0; i < palabra.length; i++) {
            if (ver) {
                if (palabra[i].getAlfabeto().equals(ListadoAlfabetoAFD.NUMERO.toString())) {
                    contador++;
                }
            }
        }
        return contador == palabra.length;
    }

    // verificar si es un patron de identificador
    public boolean esPatronIdentificador(Caracter[] palabra) {
        for (int i = 0; i < palabra.length; i++) {
            if ((i == 0) && ((palabra[0].getAlfabeto().equals(ListadoAlfabetoAFD.LETRA.toString()))
                    || ((palabra[0].getCaracter().equals(Puntuacion.GILLON_LESS.getSimbolo()))))) {
                contador++;
            }
            if ((i != 0) && ((palabra[i].getAlfabeto().equals(ListadoAlfabetoAFD.LETRA.toString())) || palabra[i].getAlfabeto().equals(ListadoAlfabetoAFD.NUMERO.toString())
                    || palabra[i].getCaracter().equals(Puntuacion.GILLON_LESS.getSimbolo())
                    || palabra[i].getCaracter().equals(Puntuacion.GILLON.getSimbolo()))) {
                contador++;
            }
        }
        return contador == palabra.length;
    }

    // token si todos son agrupacion ((((
    public boolean agrupacion(Caracter[] palabra) {
        for (Caracter caracter : palabra) {
            if (caracter.getAlfabeto().equals(ListadoAlfabetoAFD.AGRUPACION.toString())) {
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

    // token literal "fdshoiasdfhfoihsdofai"
    public boolean literal(Caracter[] palabra) {
        ListadoAlfabetoAFD[] listadoAlfabeto = ListadoAlfabetoAFD.values();
        if (palabra.length > 1) {
            boolean ver = (palabra[0].getCaracter().equals("\""))
                    && (palabra[(palabra.length - 1)].getCaracter().equals("\""));
            if (ver) {
                for (Caracter palabraSigle : palabra) {
                    if (palabraSigle.getCaracter().equals(" ")) {
                        contador++;
                    } else {
                        for (ListadoAlfabetoAFD cualalfa : listadoAlfabeto) {
                            if ((palabraSigle.getAlfabeto().equals(cualalfa.toString()))) {
                                contador++;
                            }
                        }
                    }
                }
            } else {
                return false;
            }
            return contador == (palabra.length - 2);
        } else {
            return false;
        }
    }

    // token comentario //comentario con el afabeto
    public boolean comentario(Caracter[] palabra) {
        ListadoAlfabetoAFD[] listadoAlfabeto = ListadoAlfabetoAFD.values();
        if (palabra.length > 1) {
            boolean ver = (palabra[0].getCaracter().equals(Puntuacion.DIAGONAL.getSimbolo()))
                    && (palabra[1].getCaracter().equals(Puntuacion.DIAGONAL.getSimbolo()));
            if (ver) {
                for (Caracter palabraSigle : palabra) {
                    if (palabraSigle.getCaracter().equals(" ")) {
                        contador++;
                    } else {
                        for (ListadoAlfabetoAFD cualalfa : listadoAlfabeto) {
                            if ((palabraSigle.getAlfabeto().equals(cualalfa.toString()))) {
                                contador++;
                            }
                        }
                    }
                }
                return contador == palabra.length;
            } else {
                return false;
            }
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

    // token palabras clave
    public boolean palabrasReservadas(Caracter[] palabra) {
        ListadoPalabraClave[] listadopalabras = ListadoPalabraClave.values();
        String palabraString = "";
        for (Caracter caracter : palabra) {
            palabraString += caracter.getCaracter();
        }
        for (ListadoPalabraClave listadopalabra : listadopalabras) {
            if (palabraString.equals(listadopalabra.getSimbolo())) {
                return true;
            }
        }
        return contador == palabra.length;
    }

    //set 
    public void setContador(int contador) {
        this.contador = contador;
    }
    // fin set
}
