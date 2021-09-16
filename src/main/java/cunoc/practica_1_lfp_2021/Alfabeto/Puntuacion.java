/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cunoc.practica_1_lfp_2021.Alfabeto;

/**
 *
 * @author Benjamín de Jesús Pérez <@Drymnz>
 */
public enum Puntuacion {
    DOUBLEPOINT(":"),
    SEMICOMMAT(";"),
    COMMAT(","),
    POINT(".");
    private String simbolo;
    private Puntuacion(String simbolo){
        this.simbolo = simbolo;
    }

    public String getSimbolo() {
        return simbolo;
    }
    
}
