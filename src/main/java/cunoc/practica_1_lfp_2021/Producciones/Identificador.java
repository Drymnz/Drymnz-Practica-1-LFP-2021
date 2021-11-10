/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cunoc.practica_1_lfp_2021.Producciones;

import cunoc.practica_1_lfp_2021.Toke.Caracter;
import cunoc.practica_1_lfp_2021.Toke.Lexema;
import cunoc.practica_1_lfp_2021.Toke.ListadoToken;

/**
 *
 * @author drymnz
 */
public class Identificador extends Lexema {

    private int valor;

    public Identificador(int valor, Caracter[] Palabra, int posicionX, int posicionY) {
        super(ListadoToken.IDENTIFICADOR, Palabra, posicionX, posicionY);
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

}
