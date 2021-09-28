/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cunoc.practica_1_lfp_2021.view;

import cunoc.practica_1_lfp_2021.Errores.ErrorLexema;
import cunoc.practica_1_lfp_2021.Errores.ListadoErrorLexema;
import cunoc.practica_1_lfp_2021.Toke.Caracter;
import cunoc.practica_1_lfp_2021.Toke.Palabra;
import cunoc.practica_1_lfp_2021.view.Reportes.ReportesErrores;
import cunoc.practica_1_lfp_2021.view.editorTexto.EditorTexto;
import cunoc.practica_1_lfp_2021.view.sub_ventanas.MenuPrincipal;
import cunoc.practica_1_lfp_2021.view.sub_ventanas.VentanaAnalisando;
import java.awt.CardLayout;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * @author Benjamín de Jesús Pérez Aguilar<@Drymnz>
 */
public class Ventana extends JFrame {

    private CardLayout carpeta;
    // sub ventanas
    private MenuPrincipal menuPrincipal = new MenuPrincipal();
    private JPanel JPanel_Venantan = new JPanel();
    private EditorTexto editor = new EditorTexto();
    private VentanaAnalisando analisador = new VentanaAnalisando();
    private ReportesErrores erroresLexema = new ReportesErrores();
    //fin sub ventanas
    public Ventana() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(JPanel_Venantan);
        JPanel_Venantan.setLayout(new CardLayout());
        subVentanas();
    }
    // agregar ventanas
    private void subVentanas() {
        carpeta = (CardLayout) JPanel_Venantan.getLayout();
        JPanel_Venantan.add(menuPrincipal, "MenuPrincipal");
        JPanel_Venantan.add(editor, "Editor");
        JPanel_Venantan.add(analisador, "Analisador");
        JPanel_Venantan.add(erroresLexema, "ErrorLexema");
    }

    // fin agregar ventanas
    // cambio de menus, realizara los cambios de tamaño de la ventana y del JPanel que son los sub menos
    public void irMenuPrincipal() {
        carpeta.show(JPanel_Venantan, "MenuPrincipal");
        restarurarVentana(338, 620);
    }

    public void irEditor(String texto, File archivo) {
        editor.getjTextArea1().setText(texto);
        editor.setArchivo(archivo);
        carpeta.show(JPanel_Venantan, "Editor");
        restarurarVentana(1280, 620);
    }

    public void irAnalisador(String texto, File archivo) {
        analisador.setArchivo(archivo);
        analisador.setTexto(texto);
        carpeta.show(JPanel_Venantan, "Analisador");
        restarurarVentana(480, 360);
    }
    public void irReportesError(ArrayList<Palabra> listadoLexemao) {
        Caracter[] e = {(new Caracter("", ""))};
        ErrorLexema tipo = new ErrorLexema("", "", ListadoErrorLexema.ALFABETO, e, SOMEBITS, SOMEBITS);
        erroresLexema.cargarTabla(listadoLexemao, new String[]{""}, tipo);
        carpeta.show(JPanel_Venantan, "ErrorLexema");
        restarurarVentana(1280, 640);
    }

    private void restarurarVentana(int ancho, int altura) {
        this.setSize(ancho, altura);
        SwingUtilities.updateComponentTreeUI(this);
        this.repaint();
        this.setLocationRelativeTo(null);//que  se ubique en el centro
    }
    // fin cambio de menus
}
