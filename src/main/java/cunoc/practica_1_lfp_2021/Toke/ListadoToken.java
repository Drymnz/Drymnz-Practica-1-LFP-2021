/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cunoc.practica_1_lfp_2021.Toke;

/**
 *
 *  @author Benjamín de Jesús Pérez <@Drymnz>
 */
public enum ListadoToken {
    IDENTIFICADOR("IDENTIFICADOR"),
    NUMERO("NUMERO"),
    DECIMAL("DECIMAL"),
    PUNTUACION("PUNTUACION"),
    AGRUPACION("AGRUPACION");
    private String nombre;

    private ListadoToken(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

}
