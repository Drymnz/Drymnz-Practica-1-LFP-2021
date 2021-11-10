/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cunoc.practica_1_lfp_2021.Producciones;

/**
 *
 * @author drymnz
 */
public class Arbol {

    private Nodo primerNodo;
    private Nodo nodoObservado;

    public Arbol(Nodo primerNodo, Nodo nodoObservado) {
        this.primerNodo = primerNodo;
        this.nodoObservado = nodoObservado;
    }

    public Arbol(Nodo primerNodo) {
        this.primerNodo = primerNodo;
        this.nodoObservado = primerNodo;
    }

    public void regresarPadre() {
        this.nodoObservado = this.nodoObservado.getPadre();
    }

    public void observarHijo(int numero) {
        this.nodoObservado = this.nodoObservado.getHijos().get(numero);
    }

    public void nuevoHOja(Nodo nuevaHoja) {
        nodoObservado.agregarHijo(nuevaHoja);
        this.nodoObservado = nuevaHoja;
    }

    public Nodo getPrimerNodo() {
        return primerNodo;
    }

    public void setPrimerNodo(Nodo primerNodo) {
        this.primerNodo = primerNodo;
    }

    public Nodo getNodoObservado() {
        return nodoObservado;
    }

    public void setNodoObservado(Nodo nodoObservado) {
        this.nodoObservado = nodoObservado;
    }

}
