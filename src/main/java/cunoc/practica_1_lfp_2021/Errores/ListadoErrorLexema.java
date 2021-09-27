/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cunoc.practica_1_lfp_2021.Errores;

/**
 *
 * @author Benjamín de Jesús Pérez <@Drymnz>
 */
public enum ListadoErrorLexema {
    ESTRUCTURA("ERROR-ESTRUCTURA"),
    ALFABETO("ERROR-ALFABETO");
    private String nombre;

    private ListadoErrorLexema(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

}
