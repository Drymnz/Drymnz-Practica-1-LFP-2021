/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cunoc.practica_1_lfp_2021;

import cunoc.practica_1_lfp_2021.view.Ventana;
import cunoc.practica_1_lfp_2021.view.editorTexto.Piezas.Acerca;
import java.awt.Graphics;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Start {

    public static Ventana ejecutar = new Ventana() {
        @Override
        public void paint(Graphics g) {
            super.paint(g); //To change body of generated methods, choose Tools | Templates.
            repaint();
        }
    };

    public static void main(String[] args) {
        ejecutar.setSize(338, 620);
        ejecutar.setTitle(Acerca.NOMBRE_PROGRAMA);
        ejecutar.setVisible(true);
        ejecutar.setLocationRelativeTo(null);//que  se ubique en el centro
    }
}
