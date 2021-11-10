/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cunoc.practica_1_lfp_2021.Producciones;

import cunoc.practica_1_lfp_2021.Toke.Lexema;
import java.util.ArrayList;

/**
 *
 * @author drymnz
 */
public class Nodo {

    private ListadoProductos producto;
    private Nodo padre;
    private ArrayList<Nodo> hijos = new ArrayList<>();
    private Lexema token;

    public Nodo(ListadoProductos producto, Nodo padre, Lexema token) {
        this.producto = producto;
        this.padre = padre;
        this.token = token;
    }

    public Nodo(ListadoProductos producto, Nodo padre) {
        this(producto, padre, null);
    }

    public Nodo(ListadoProductos producto, Lexema token) {
        this(producto, null, token);
    }

    public Nodo(Lexema token) {
        this(null, null, token);
    }

    public Nodo(ListadoProductos producto) {
        this(producto, null, null);
    }

    public void agregarHijo(Nodo hijoNuevo) {
        hijoNuevo.setPadre(this);
        hijos.add(hijoNuevo);
    }

    public ListadoProductos getProducto() {
        return producto;
    }

    public Nodo getPadre() {
        return padre;
    }

    public void setProducto(ListadoProductos producto) {
        this.producto = producto;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    public Lexema getToken() {
        return token;
    }

    public void setToken(Lexema token) {
        this.token = token;
    }

    public boolean vacio() {
        return (producto == null) && (hijos == null) && (token == null);
    }

    public ArrayList<Nodo> getHijos() {
        return hijos;
    }

    public void setHijos(ArrayList<Nodo> hijos) {
        this.hijos = hijos;
    }

}
