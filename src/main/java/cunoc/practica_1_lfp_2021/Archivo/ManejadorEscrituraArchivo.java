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
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ManejadorEscrituraArchivo {

    private FileOutputStream salida;

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
}
