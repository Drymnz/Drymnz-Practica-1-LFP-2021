/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cunoc.practica_1_lfp_2021;

import cunoc.practica_1_lfp_2021.view.Ventana;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Start {

    public static Ventana ejecutar = new Ventana();

    public static void main(String[] args) {
        ejecutar.setSize(338, 620);
        //ejecutar.setResizable(false);// que no pueda modificar el tamaño el usuario
        ejecutar.setVisible(true);
        ejecutar.setLocationRelativeTo(null);//que  se ubique en el centro
    }
}
