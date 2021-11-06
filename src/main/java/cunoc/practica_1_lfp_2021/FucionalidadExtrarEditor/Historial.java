/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cunoc.practica_1_lfp_2021.FucionalidadExtrarEditor;

import cunoc.practica_1_lfp_2021.Archivo.ManejadorCargaArchivo;
import cunoc.practica_1_lfp_2021.Archivo.ManejadorEscrituraArchivo;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import javax.swing.JTextArea;

/**
 *
 * @author drymnz
 */
public class Historial {

    private ManejadorEscrituraArchivo escribir = new ManejadorEscrituraArchivo();
    private ManejadorCargaArchivo leer = new ManejadorCargaArchivo();
    //estas son los detalles del archivo
    private final String DIRECCION = ".temp/historial";
    private final String NOMBRE_ARCHIVO = "doc";
    private final String EXTENCION_ARCHIVO = ".txt";

    private boolean todoBien = false;// este es para ver si se puede usar los archivos
    //para controlar el historial y no se confunda en que regresar
    private int contador = 0;
    private int contadorMax = 0;

    private JTextArea registrar;

    public Historial() {
        File ver = leer.exiteDireccion(new File(DIRECCION));
        if (ver != null) {
            todoBien = true;
        }
    }

    private KeyListener eventos = new KeyAdapter() {
        @Override
        public void keyTyped(KeyEvent e) {
            registrar();
        }
    };

    public void rehacer() {
        File archivoVer = new File(DIRECCION + "/" + NOMBRE_ARCHIVO + (contador + 1) + EXTENCION_ARCHIVO);
        if (todoBien && archivoVer.exists() && (contador + 1) <= contadorMax) {
            registrar.setText(new ManejadorCargaArchivo().cargarArchivoTexto(archivoVer));
            contador++;
        }
    }

    public void deshacer() {
        if ((contador - 1) == (contadorMax - 1)) {
            registrar();
        }
        File archivoVer = new File((DIRECCION + "/" + NOMBRE_ARCHIVO + (contador - 1) + EXTENCION_ARCHIVO));
        if (todoBien && archivoVer.exists() && (contador - 1) > 0) {
            registrar.setText(new ManejadorCargaArchivo().cargarArchivoTexto(archivoVer));
            contador--;
        }
    }

    public void setRegistrar(JTextArea registrar) {
        this.registrar = registrar;
        registrar.addKeyListener(eventos);
    }

    /*
    registrar el archvio con la dirreccion mecionada incrementado en uno en uno para aguardar el registro
     */
    private void registrar() {
        File archvio = new File((DIRECCION + "/" + NOMBRE_ARCHIVO + (contador + 1) + EXTENCION_ARCHIVO));
        if (todoBien) {
            escribir.setArchivoHilo(archvio);
            escribir.setContenidoHilo(registrar.getText());
            escribir.run();
            contador++;
            contadorMax = contador;
        }
    }

    public void reset() {
        contador = 0;
        contadorMax = contador;
    }
}
