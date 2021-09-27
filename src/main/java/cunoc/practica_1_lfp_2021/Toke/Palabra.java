/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cunoc.practica_1_lfp_2021.Toke;

/**
 *
 * @author Benjamín de Jesús Pérez Aguilar<@Drymnz>
 */
public class Palabra {

    private Caracter[] Palabra;
    private int posicionX;
    private int posicionY;

    public Palabra(Caracter[] Palabra, int posicionX, int posicionY) {
        this.Palabra = Palabra;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    public Caracter[] getPalabra() {
        return Palabra;
    }

    public void setPalabra(Caracter[] Palabra) {
        this.Palabra = Palabra;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }

}
