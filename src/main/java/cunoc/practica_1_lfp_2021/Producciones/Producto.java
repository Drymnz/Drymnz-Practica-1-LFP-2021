/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cunoc.practica_1_lfp_2021.Producciones;

import cunoc.practica_1_lfp_2021.Alfabeto.ListadoPalabraClave;
import cunoc.practica_1_lfp_2021.Archivo.ManejadorEscrituraArchivo;
import cunoc.practica_1_lfp_2021.ManejadorTexto.ManejadorTexto;
import cunoc.practica_1_lfp_2021.Toke.Caracter;
import cunoc.practica_1_lfp_2021.Toke.Lexema;
import cunoc.practica_1_lfp_2021.Toke.ListadoToken;
import cunoc.practica_1_lfp_2021.Toke.Palabra;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author drymnz
 */
public class Producto {

    protected ArrayList<Palabra> pilaToken;
    protected ArrayList<Identificador> pilaIdentificadores;
    protected Arbol arbol;
    private ArrayList<String> pruevas = new ArrayList<>();
    private ArrayList<String> lineas = new ArrayList<>();

    public Producto(ArrayList<Palabra> pilaToken) {
        this.pilaToken = pilaToken;
    }

    public void examinar() {
        Caracter[] palabraToken = {new Caracter("$", "FINAL")};
        Lexema token = new Lexema(ListadoToken.PALABRA_CLAVE, palabraToken, 0, 0);
        arbol = new Arbol(new Nodo(ListadoProductos.P, token));
        pruevas.add("$");
        for (Palabra palabra : pilaToken) {
            if (palabra instanceof Lexema) {
                Lexema revisar = (Lexema) palabra;
                if ((arbol.getNodoObservado().getToken() == null) | (arbol.getNodoObservado().getToken() != revisar)) {
                    if (!analisiar(revisar)) {
                        System.out.println("ERRORRR TERMIANAR ANALSIIS SINTACTICO");
                    }
                }
            }
        }
        eliminarUlitmo();
        System.out.println(imprimir(lineas));
        System.out.println(imprimir(pruevas));
        aguardar();
    }

    private void aguardar() {
        String mensaje = "Fallo al aguardar";
        FileNameExtensionFilter filtrado = new FileNameExtensionFilter(".txt", "txt");
        JFileChooser buscador = new JFileChooser();
        buscador.setFileFilter(filtrado);
        mensaje = ((buscador.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) && (new ManejadorEscrituraArchivo()).aguardarTexto((buscador).getSelectedFile(), imprimir(lineas))) ? "se aguardo correctamente" : "Fallo al aguardar";
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private String imprimir(ArrayList<String> imprimri) {
        String impr = "";
        for (String string : imprimri) {
            impr += string + "\n";
        }
        return impr;
    }

    private boolean analisiar(Lexema revisar) {
        switch (revisar.getTipoToken()) {
            case CARACTER_ESPECIAL:
                lineas.add(new ManejadorTexto().convertirListadoCaracter(revisar.getPalabra()));
                return true;
            case COMENTARIO:
                lineas.add(new ManejadorTexto().convertirListadoCaracter(revisar.getPalabra()));
                return true;
            default:
                if (realizoMatcher(arbol.getNodoObservado().getProducto(), revisar)) {
                    eliminarUlitmo();
                    return true;
                }
        }

        return false;
    }

    private boolean realizoMatcher(ListadoProductos verproducion, Lexema revisar) {
        if (verproducion != null) {
            switch (verproducion) {
                case P:
                    if (revisar.getTipoToken().equals(ListadoToken.IDENTIFICADOR)) {
                        agregar("P' U");
                        arbol.nuevoHOja(new Nodo(ListadoProductos.P_PRIMA));
                        return realizoMatcher(ListadoProductos.P_PRIMA, revisar);//////////////////////////////////////////
                    }
                    if (revisar.getTipoToken().equals(ListadoToken.PALABRA_CLAVE)) {
                        agregar("P' U");
                        arbol.getNodoObservado().agregarHijo(new Nodo(ListadoProductos.P_PRIMA));
                        arbol.getNodoObservado().agregarHijo(new Nodo(ListadoProductos.U));
                        arbol.observarHijo(1);
                        if (new ManejadorTexto().convertirListadoCaracter(revisar.getPalabra()).equals(ListadoPalabraClave.ESCRIBIR.getSimbolo())) {
                            return realizoMatcher(arbol.getNodoObservado().getProducto(), revisar);
                        }
                    }
                    break;
                case U:
                    if (revisar.getTipoToken().equals(ListadoToken.PALABRA_CLAVE)) {
                        if (new ManejadorTexto().convertirListadoCaracter(revisar.getPalabra()).equals(ListadoPalabraClave.ESCRIBIR.getSimbolo())) {
                            eliminarUlitmo();
                            agregar("E");
                            arbol.nuevoHOja(new Nodo(ListadoProductos.E));
                            return realizoMatcher(arbol.getNodoObservado().getProducto(), revisar);
                        }
                    }
                    break;
                case P_PRIMA:
                    if (revisar.getTipoToken().equals(ListadoToken.IDENTIFICADOR)) {
                        agregar("P' U");
                        arbol.nuevoHOja(new Nodo(ListadoProductos.A));
                        return realizoMatcher(ListadoProductos.A, revisar);
                    }
                    if (revisar.getTipoToken().equals(ListadoToken.PALABRA_CLAVE)) {
                        if (new ManejadorTexto().convertirListadoCaracter(revisar.getPalabra()).equals(ListadoPalabraClave.ESCRIBIR.getSimbolo())) {
                            agregar("P' U");
                            arbol.nuevoHOja(new Nodo(ListadoProductos.E));
                            return realizoMatcher(ListadoProductos.E, revisar);
                        }
                    }
                    break;
                case E:
                    if (revisar.getTipoToken().equals(ListadoToken.PALABRA_CLAVE)) {
                        if (new ManejadorTexto().convertirListadoCaracter(revisar.getPalabra()).equals(ListadoPalabraClave.ESCRIBIR.getSimbolo())) {
                            agregar("FIN H ESCRIBIR");
                            arbol.getNodoObservado().agregarHijo((new Nodo((new Lexema(ListadoToken.PALABRA_CLAVE, (new ManejadorTexto().stringCaracter("FIN")), 0, 0)))));
                            arbol.getNodoObservado().agregarHijo(new Nodo(ListadoProductos.H, arbol.getNodoObservado()));
                            arbol.getNodoObservado().agregarHijo(new Nodo(revisar));
                            arbol.observarHijo(1);
                            return true;
                        }
                    }
                    break;
                case A:
                    if (revisar.getTipoToken().equals(ListadoToken.IDENTIFICADOR)) {

                    }
                    break;
                case H:
                    if (revisar.getTipoToken().equals(ListadoToken.LITERAL)) {
                        eliminarUlitmo();
                        agregar("literal");
                        arbol.nuevoHOja(new Nodo(revisar));
                        arbol.regresarPadre();
                        arbol.regresarPadre();
                        arbol.observarHijo(0);
                        salida(ListadoPalabraClave.ESCRIBIR, revisar);
                        return true;
                    }
                    break;

            }
        }
        if (arbol.getNodoObservado() != null && arbol.getNodoObservado().getToken() != null) {
            switch (arbol.getNodoObservado().getToken().getTipoToken()) {
                case PALABRA_CLAVE:
                    String listado = new ManejadorTexto().convertirListadoCaracter(arbol.getNodoObservado().getToken().getPalabra());
                    String listadoCon = new ManejadorTexto().convertirListadoCaracter(revisar.getPalabra());
                    if (listadoCon.equals(listado)) {
                        eliminarUlitmo();
                        arbol.regresarRamaInicial();
                        arbol.observarHijo(0);
                        return true;
                    } else {
                        return false;
                    }
            }

        }
        return false;
    }

    private void salida(ListadoPalabraClave clabe, Lexema revisar) {
        switch (clabe) {
            case ESCRIBIR:
                Caracter[] verlistado = revisar.getPalabra();
                String escribir = "";
                for (int i = 1; i < (verlistado.length - 1); i++) {
                    escribir += verlistado[i].getCaracter();
                }
                lineas.add(escribir);
                break;
        }
    }

    private void eliminarUlitmo() {
        String dividir = pruevas.get((pruevas.size() - 1));
        ArrayList<String> listado = new ManejadorTexto().dividirTextoPalabra(dividir);
        String meter = "";
        for (int i = 0; i < (listado.size() - 1); i++) {
            String get = listado.get(i);
            String colocar = (i != (listado.size() - 2)) ? " " : "";
            meter += get + colocar;
        }
        pruevas.add(meter);
    }

    private void agregar(String produccion) {
        String antes = pruevas.get(pruevas.size() - 1);
        String meter;
        meter = (antes + " " + produccion);
        pruevas.add(meter);
    }

}
