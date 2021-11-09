/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cunoc.practica_1_lfp_2021.view;

import cunoc.practica_1_lfp_2021.Start;
import cunoc.practica_1_lfp_2021.Toke.Palabra;
import cunoc.practica_1_lfp_2021.view.Reportes.ReportesError;
import cunoc.practica_1_lfp_2021.view.Reportes.ReportesLexemas;
import cunoc.practica_1_lfp_2021.view.editorTexto.EditorTexto;
import cunoc.practica_1_lfp_2021.view.editorTexto.Piezas.Acerca;
import cunoc.practica_1_lfp_2021.view.sub_ventanas.MenuPrincipal;
import cunoc.practica_1_lfp_2021.view.sub_ventanas.VentanaAnalisando;
import java.awt.CardLayout;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
    private ReportesError erroresLexema = new ReportesError();
    private ReportesLexemas reportesLexema = new ReportesLexemas();

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
        JPanel_Venantan.add(erroresLexema, "ReportesError");
        JPanel_Venantan.add(reportesLexema, "ReportesLexemas");
    }

    // fin agregar ventanas
    // cambio de menus, realizara los cambios de tamaño de la ventana y del JPanel que son los sub menos
    public void irMenuPrincipal() {
        carpeta.show(JPanel_Venantan, "MenuPrincipal");
        restarurarVentana(338, 620, Acerca.NOMBRE_PROGRAMA);
    }

    public void irEditor(String texto, File archivo) {
        editor.getRetorno1().iniciarHistorial();
        editor.getjTextArea1().setText(texto);
        editor.setArchivo(archivo);
        carpeta.show(JPanel_Venantan, "Editor");
        String titulo = ((archivo != null)) ? ("Editor --> " + archivo.getName()) : "Editor";
        restarurarVentana(1280, 620, titulo);
    }

    public void irAnalisador(String texto, File archivo) {
        analisador.getPanelCarga1().setProgreso(0);
        analisador.setArchivo(archivo);
        analisador.setTexto(texto);
        carpeta.show(JPanel_Venantan, "Analisador");
        restarurarVentana(640, 220, "Analisador");
    }

    public void irReportesError(ArrayList<Palabra> listadoLexemao) {
        erroresLexema.cargarTablas(listadoLexemao);
        carpeta.show(JPanel_Venantan, "ReportesError");
        restarurarVentana(1280, 640, "Reprotes Error");
    }

    public void irReportesToken(ArrayList<Palabra> listadoLexemao) {
        reportesLexema.cargarTablas(listadoLexemao);
        carpeta.show(JPanel_Venantan, "ReportesLexemas");
        restarurarVentana(1280, 640, "Reprotes token");
    }

    private void restarurarVentana(int ancho, int altura, String titulo) {
        Start.ejecutar.setTitle(titulo);
        this.setSize(ancho, altura);
        this.setLocationRelativeTo(null);//que  se ubique en el centro
    }
    // fin cambio de menus
}
