/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cunoc.practica_1_lfp_2021.Archivo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author Benjamín de Jesús Pérez Aguilar<@Drymnz>
 */
public class ManejadorCargaArchivo {

    private FileInputStream entrada;

    public String cargarArchivoTexto(File carchivo) {
        String extraje = "";
        try {
            entrada = new FileInputStream(carchivo);
            int valor;
            while ((valor = entrada.read()) != -1) {
                char caracter = (char) valor;
                extraje += caracter;
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "error en lectura");
            Logger.getLogger(ManejadorCargaArchivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "error en lectura");
            Logger.getLogger(ManejadorCargaArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return extraje;
    }
}
