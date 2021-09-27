/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cunoc.practica_1_lfp_2021.Toke;

/**
 * @author Benjamín de Jesús Pérez Aguilar<@Drymnz>
 */
public class Caracter {
    private String caracter;
    private String Alfabeto;

    public Caracter(String caracter, String Alfabeto) {
        this.caracter = caracter;
        this.Alfabeto = Alfabeto;
    }

    public String getCaracter() {
        return caracter;
    }

    public void setCaracter(String caracter) {
        this.caracter = caracter;
    }

    public String getAlfabeto() {
        return Alfabeto;
    }

    public void setAlfabeto(String Alfabeto) {
        this.Alfabeto = Alfabeto;
    }
    
}
