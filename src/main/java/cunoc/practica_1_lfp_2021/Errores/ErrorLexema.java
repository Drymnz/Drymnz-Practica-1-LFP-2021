/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cunoc.practica_1_lfp_2021.Errores;

import cunoc.practica_1_lfp_2021.Toke.Palabra;

/**
 *
 * @author Benjamín de Jesús Pérez <@Drymnz>
 */
public class ErrorLexema extends Palabra {

    private String caracter;
    private ListadoErrorLexema tipo;

    public ErrorLexema(String caracter, ListadoErrorLexema tipo, String Palabra, int posicionX, int posicionY) {
        super(Palabra, posicionX, posicionY);
        this.caracter = caracter;
        this.tipo = tipo;
    }

    public String getCaracter() {
        return caracter;
    }

    public void setCaracter(String caracter) {
        this.caracter = caracter;
    }

    public ListadoErrorLexema getTipo() {
        return tipo;
    }

    public void setTipo(ListadoErrorLexema tipo) {
        this.tipo = tipo;
    }

}
