/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Edd;

/**
 * Implementaci&oacute;n de una pila con lista enlazada.
 * Utilizada en el algoritmo DFS.
 *
 * @param <T> Tipo de dato.
 * @author chris
 */
public class Pila<T> {
    private Nodo<T> tope;

    /**
     * Apila un elemento.
     *
     * @param dato Elemento a colocar en la cima.
     */
    public void apilar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.setSiguiente(tope);
        tope = nuevo;
    }

    /**
     * Desapila el elemento de la cima.
     *
     * @return El elemento desapilado, o {@code null} si la pila est&aacute vac&iacute;a.
     */
    public T desapilar() {
        if (tope == null) return null;
        T dato = tope.getDato();
        tope = tope.getSiguiente();
        return dato;
    }

    /**
     * Verifica si la pila est&aacute vac&iacute;a.
     *
     * @return {@code true} si no hay elementos.
     */
    public boolean estaVacia() {
        return tope == null;
    }
}