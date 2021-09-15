/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cunoc.practica_1_lfp_2021.Toke;

/**
 * 
 * @author Benjamín de Jesús Pérez <@Drymnz>
 */
public class Lexema extends Palabra{
    private ListadoToken tipoToken;

    public Lexema(ListadoToken tipoToken, String Palabra, int posicionX, int posicionY) {
        super(Palabra, posicionX, posicionY);
        this.tipoToken = tipoToken;
    }

    public ListadoToken getTipoToken() {
        return tipoToken;
    }

    public void setTipoToken(ListadoToken tipoToken) {
        this.tipoToken = tipoToken;
    }
    

}
