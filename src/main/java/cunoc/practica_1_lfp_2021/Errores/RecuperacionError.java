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

    private final String INDICAR = "<-- Error, en ";
    private final String INDICARENCONTRO = ", pero dectecta ";
    private final String INDICARTOKEN = " TOKEN : ";

    private VerificadorPatronToken buscar;
    private String caracterDondeFallo = "";

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
            if ((listado[i].getAlfabeto().equals(ListadoErrorLexema.ALFABETO.getNombre()))) {
                encontre += listado[i].getCaracter();
                return (encontre);
            }
            encontre += listado[i].getCaracter();
        }
        return encontre;
    }

    // returnara un string con todos los identificador = fafasd, numero = 1564 POTS SE PUEDE MEJORAR
    private String todoLosTokenPosibles() {
        // String[] list --> 1 encontro, 2:palabraPrueva, 3:palabraAntesAdd, 4palabraDespuesAdd
        String[] list = {"", "", "", "", ""};
        Caracter[] listado = buscar.getListadoCaracter();
        ListadoToken token = null;
        Lexema verificar = null;
        for (int i = 0; i < (listado.length - 1); i++) {
            if (!listado[i].getAlfabeto().equals(ListadoErrorLexema.ALFABETO.getNombre())) {
                list[2] = list[1];
                list[1] += listado[i].getCaracter();
                verificar = (new VerificadorPatronToken(list[1], posicionY, posicionX)).analisarPatron();
                if (verificar != null) {
                    token = verificar.getTipoToken();
                    list[3] = list[1];
                } else if (token != null) {
                    indicarSimboloError(listado[i].getCaracter());
                    list[0] += indicarToken(token, list[2]);
                    for (int j = 1; j < list.length; j++) {
                        list[j] = "";
                    }
                    verificar = (new VerificadorPatronToken(listado[i].getCaracter(), posicionY, posicionX)).analisarPatron();
                    if (verificar != null) {
                        list[0] += indicarToken(token, listado[i].getCaracter());
                    }
                }
            } else if (!list[2].isEmpty() && verificar != null && token != null) {
                list[0] += indicarToken(token, list[2]);
                indicarSimboloError(listado[i].getCaracter());
            }
        }
        if (token != null) {
            list[0] += indicarToken(token, list[3]);
            //listado[listado.length-1] ver que tipo es el ultimo
            verificar = (new VerificadorPatronToken(listado[listado.length - 1].getCaracter(), posicionY, posicionX)).analisarPatron();
            if (verificar != null && verificar.getTipoToken() != null) {
                list[0] += indicarToken(verificar.getTipoToken(), listado[listado.length - 1].getCaracter());
            }
            indicarSimboloError(listado[listado.length - 1].getCaracter());
        }
        return list[0];
    }

    private void indicarSimboloError(String simbolo) {
        caracterDondeFallo += "< " + simbolo + ">";
    }

    private String indicarToken(ListadoToken token, String stringToken) {
        //  token decimal = 3.5 o todo token que esta en la app
        return INDICARTOKEN + token.getNombre() + " = " + stringToken + ",  ";
    }
}
