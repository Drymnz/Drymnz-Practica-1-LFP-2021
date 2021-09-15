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
public enum Agrupacion {
    PARENTHESIS("(",")"),
    SQUERE_BRACKET("{","}"),
    SQUERE_BRACKET_TWO("[","]");

    private String simboloInicio;
    private String simboloFinal;

    private Agrupacion(String simboloInicio,String simboloFinal) {
        this.simboloInicio = simboloInicio;
        this.simboloFinal = simboloFinal;
    }


}
