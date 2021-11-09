/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package cunoc.practica_1_lfp_2021.Alfabeto;

/**
 *
 * @author drymnz
 */
public enum CaracterEspecial {
    PAG_BREAK("\f"),
    CAR_RETURN("\r"),
    TABULATION("\t"),
    LINE_BREAK("\n");
       private String simbolo;
    private CaracterEspecial(String simbolo){
        this.simbolo = simbolo;
    }

    public String getSimbolo() {
        return simbolo;
    }
}
