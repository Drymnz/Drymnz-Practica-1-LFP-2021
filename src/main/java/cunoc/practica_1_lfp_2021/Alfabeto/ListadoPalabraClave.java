/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package cunoc.practica_1_lfp_2021.Alfabeto;

/**
 *
 * @author drymnz
 */
public enum ListadoPalabraClave {
    ESCRIBIR("ESCRIBIR"),
    REPETIR("REPETIR"),
    INICIO("INICIO"),
    SI("SI"),
    VERDADERO("VERDADERO"),
    FALSO("FALSO"),
    ENTONCES("ENTONCES"),
    IGUAL("="),
    FIN("FIN");
       private String simbolo;
    private ListadoPalabraClave(String simbolo){
        this.simbolo = simbolo;
    }

    public String getSimbolo() {
        return simbolo;
    }
    
}
