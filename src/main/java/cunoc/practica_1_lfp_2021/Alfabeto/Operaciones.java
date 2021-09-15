/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cunoc.practica_1_lfp_2021.Alfabeto;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public enum Operaciones {
    MORE("+"),
    LESS("-"),
    DIVIDE("/"),
    MODULE("%"),
    MULTIPLY("*");
    
    private String simbolo;

    private Operaciones(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getSimbolo() {
        return simbolo;
    }
}
