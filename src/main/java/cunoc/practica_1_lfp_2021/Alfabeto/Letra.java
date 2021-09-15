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
public enum Letra {

    A("A", "a"),
    B("B", "b"),
    C("C", "c"),
    D("D", "d"),
    E("E", "e"),
    F("F", "f"),
    G("G", "g"),
    H("H", "h"),
    I("I", "i"),
    J("J", "j"),
    K("K", "k"),
    L("L", "l"),
    M("M", "m"),
    N("N", "n"),
    O("O", "o"),
    P("P", "p"),
    Q("Q", "q"),
    R("R", "r"),
    S("S", "s"),
    T("T", "t"),
    U("U", "u"),
    V("V", "v"),
    W("W", "w"),
    X("X", "x"),
    Y("Y", "y"),
    Z("Z", "z");

    private String mayuscula;
    private String minuscula;

    private Letra(String mayuscula, String minuscula) {
        this.mayuscula = mayuscula;
        this.minuscula = minuscula;
    }

    public String getMayuscula() {
        return mayuscula;
    }

    public String getMinuscula() {
        return minuscula;
    }
    
}
