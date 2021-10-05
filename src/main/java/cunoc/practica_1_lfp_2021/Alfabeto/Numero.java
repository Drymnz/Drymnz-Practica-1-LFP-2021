/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cunoc.practica_1_lfp_2021.Alfabeto;

/**
 * @author Benjamín de Jesús Pérez Aguilar<@Drymnz>
 */
public enum Numero {
    ONE("1"),
    TWO("2"),
    THEREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    CERO("0");
    private String numero;
    private Numero(String numero){
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }
    
}
