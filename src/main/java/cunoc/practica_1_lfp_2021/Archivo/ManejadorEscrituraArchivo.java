/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cunoc.practica_1_lfp_2021.Archivo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Benjamín de Jesús Pérez Aguilar<@Drymnz>
 */
public class ManejadorEscrituraArchivo implements Runnable {

    private FileOutputStream salida;
    private File archivoHilo;
    private String contenidoHilo;

    public boolean aguardarTexto(File archivo, String contenido) {
        try {
            salida = new FileOutputStream(archivo);
            byte[] bytes = contenido.getBytes();
            salida.write(bytes);
            salida.close();
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManejadorEscrituraArchivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManejadorEscrituraArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void run() {
        aguardarTexto(archivoHilo, contenidoHilo);
    }

    public void setArchivoHilo(File archivoHilo) {
        this.archivoHilo = archivoHilo;
    }

    public void setContenidoHilo(String contenidoHilo) {
        this.contenidoHilo = contenidoHilo;
    }

}
