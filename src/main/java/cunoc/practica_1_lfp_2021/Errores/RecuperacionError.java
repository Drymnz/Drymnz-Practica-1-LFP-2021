/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cunoc.practica_1_lfp_2021.Errores;

import cunoc.practica_1_lfp_2021.Analisador.VerificadorPatronToken;
import cunoc.practica_1_lfp_2021.ManejadorTexto.ManejadorTexto;
import cunoc.practica_1_lfp_2021.Toke.*;

/**
 * @author Benjamín de Jesús Pérez Aguilar<@Drymnz>
 */
public class RecuperacionError {

    private VerificadorPatronToken buscar;
    private String caracterDondeFallo = "";
    private final String INDICAR = "<-- Error, en ";
    private final String INDICARENCONTRO = ", pero dectecta ";
    private final String INDICARTOKEN = " token : ";
    private int posicionY;
    private int posicionX;

    public RecuperacionError(VerificadorPatronToken buscar, int posicionY, int posicionX) {
        this.buscar = buscar;
        this.posicionY = posicionY;
        this.posicionX = posicionX;
    }

    public Palabra recuperarError() {

        //recuperacionErro = 585f3.40 <--Error en 585f , pero dectectado token decimal = 3.5
        String recuperacionError = (new ManejadorTexto().convertirListadoCaracter(buscar.getListadoCaracter()))
                + INDICAR
                + buscarPalabraMasPrimeroError()
                + INDICARENCONTRO
                + todoLosTokenPosibles();
        return new ErrorLexema(caracterDondeFallo, recuperacionError, ListadoErrorLexema.ALFABETO, buscar.getListadoCaracter(), posicionX, posicionY);
    }

    // buscar el primer error
    private String buscarPalabraMasPrimeroError() {
        String encontre = "";
        Caracter[] listado = buscar.getListadoCaracter();
        for (int i = 0; i < listado.length; i++) {
            encontre += listado[i].getCaracter();
            if (listado[i].getAlfabeto().equals(ListadoErrorLexema.ALFABETO.getNombre())) {
                encontre += listado[i].getCaracter();
                return (encontre);
            }
        }
        return encontre;
    }

    // returnara un string con todos los identificador = fafasd, numero = 1564 POTS SE PUEDE MEJORAR
    private String todoLosTokenPosibles() {
        String encotnre = "";
        String palabraPrueva = "";
        String palabraAntesAdd = "";
        String palabraDespuesAdd = "";
        Caracter[] listado = buscar.getListadoCaracter();
        ListadoToken token = null;
        Lexema verificar = null;
        for (int i = 0; i < (listado.length - 1); i++) {
            if (!listado[i].getAlfabeto().equals(ListadoErrorLexema.ALFABETO.getNombre())) {
                palabraAntesAdd = palabraPrueva;
                palabraPrueva += listado[i].getCaracter();
                verificar = (new VerificadorPatronToken(palabraPrueva, posicionY, posicionX)).analisarPatron();
                if (verificar != null) {
                    token = verificar.getTipoToken();
                    palabraDespuesAdd = palabraPrueva;
                } else if (token != null) {
                    indicarSimboloError(listado[i].getCaracter());
                    encotnre += indicarToken(token, palabraAntesAdd);
                    palabraPrueva = "";
                    palabraAntesAdd = "";
                    palabraDespuesAdd = "";
                }
            } else if (!palabraAntesAdd.isEmpty() && verificar != null && token != null) {
                encotnre += indicarToken(token, palabraAntesAdd);
                indicarSimboloError(listado[i].getCaracter());
            }
        }
        if (token != null) {
            encotnre += indicarToken(token, palabraDespuesAdd);
            //listado[listado.length-1] ver que tipo es el ultimo
            verificar = (new VerificadorPatronToken(listado[listado.length - 1].getCaracter(), posicionY, posicionX)).analisarPatron();
            if (verificar != null && verificar.getTipoToken() != null) {
                encotnre += indicarToken(verificar.getTipoToken(), listado[listado.length - 1].getCaracter());
            }
            indicarSimboloError(listado[listado.length - 1].getCaracter());
        }
        return encotnre;
    }

    private void indicarSimboloError(String simbolo) {
        caracterDondeFallo += "( "+ simbolo + ")";
    }

    private String indicarToken(ListadoToken token, String stringToken) {
        //  token decimal = 3.5 o todo token que esta en la app
        return "TOKEN"+token.getNombre() + " = " + stringToken + ",  ";
    }
}
