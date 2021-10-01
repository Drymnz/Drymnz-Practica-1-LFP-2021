package cunoc.practica_1_lfp_2021.Analisador;

import cunoc.practica_1_lfp_2021.Alfabeto.*;

/**
 * @author Benjamín de Jesús Pérez <@Drymnz>
 */
public class VerificadorAlfabeto {
    

    /*
    NOTA: esta clase solo pertence a verificar los caracter de un listado enum, para su pertencia de alfabeto
     */
    public boolean agrupacion(String letra) {
        Agrupacion[] alfabeto = Agrupacion.values();
        for (Agrupacion agrupacion : alfabeto) {
            if (agrupacion.getSimboloFinal().equals(letra) || agrupacion.getSimboloInicio().equals(letra)) {
                return true;
            }
        }
        return false;
    }

    public boolean letra(String Caracter) {
        Letra[] alfabeto = Letra.values();
        for (Letra letra : alfabeto) {
            if (letra.getMinuscula().equals(Caracter) || letra.getMayuscula().equals(Caracter)) {
                return true;
            }
        }
        return false;
    }

    public boolean numero(String letra) {
        Numero[] alfabeto = Numero.values();
        for (Numero numero : alfabeto) {
            if (numero.getNumero().equals(letra)) {
                return true;
            }
        }
        return false;
    }
    public boolean operacion(String caracter){
        Operaciones[] alfabeto = Operaciones.values();
         for (Operaciones operaciones : alfabeto) {
                if (operaciones.getSimbolo().equals(caracter)) {
                    return true;
                }
            }
        return false;
    }
    public boolean puntuacion(String caracter){
        Puntuacion[] alfabeto = Puntuacion.values();
          for (Puntuacion puntuacion : alfabeto) {
                if (puntuacion.getSimbolo().equals(caracter)) {
                   return true;
                }
            }
        return false;
    }
}
