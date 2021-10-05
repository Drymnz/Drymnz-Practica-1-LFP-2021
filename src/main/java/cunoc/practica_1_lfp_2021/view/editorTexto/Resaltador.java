/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cunoc.practica_1_lfp_2021.view.editorTexto;

import cunoc.practica_1_lfp_2021.ManejadorTexto.ManejadorTexto;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Resaltador implements Runnable {

    private Highlighter.HighlightPainter reslatarTexto = new DefaultHighlighter.DefaultHighlightPainter(Color.red);
    private Highlighter lin;
    private Document doc;
    private String palabra = "";

    public Resaltador(JTextComponent comp, String palabra) {
        lin = comp.getHighlighter();
        doc = comp.getDocument();
        this.palabra = palabra;
    }

    @Override
    public void run() {
        try {
            lin.removeAllHighlights();
            String texto = doc.getText(0, doc.getLength());
            ArrayList<String> listado = (new ManejadorTexto()).dividirTextoLetras(texto);
            ArrayList<String> bucar = (new ManejadorTexto()).dividirTextoLetras(palabra);
            for (int j = 0; j < listado.size(); j++) {
                if (bucar.get(0).equalsIgnoreCase(listado.get(j))) {
                    String encontre = "";
                    for (int k = 0; k < palabra.length(); k++) {
                        encontre += listado.get(k+j);
                    }
                    if (encontre.equalsIgnoreCase(palabra)) {
                        lin.addHighlight(j, j + palabra.length(), reslatarTexto);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
