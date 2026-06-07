package BfsDfs;

import Clases.ConexionSinaptica;
import Clases.Neurona;
import Clases.redNeuronal;
import Edd.ListaEnlazada;
import Edd.Cola;
import Edd.Nodo;

/**
 * Algoritmo de búsqueda en anchura (BFS) aplicado a la red neuronal.
 * Determina el conjunto de neuronas alcanzables desde un nodo fuente.
 *
 * @author chris
 */
public class BFS {

    /**
     * Ejecuta BFS desde una neurona con identificador dado.
     *
     * @param red      Red neuronal.
     * @param idInicio Identificador de la neurona fuente.
     * @return Lista enlazada con las neuronas alcanzables (incluye la fuente).
     */
    public ListaEnlazada<Neurona> BFS(redNeuronal red, String idInicio) {
        ListaEnlazada<Neurona> visitados = new ListaEnlazada<>();
        Neurona inicio = red.buscarNeurona(idInicio);
        if (inicio == null) return visitados;

        Cola<Neurona> cola = new Cola<>();
        cola.encolar(inicio);
        visitados.agregar(inicio);

        while (!cola.estaVacia()) {
            Neurona actual = cola.desencolar();
            Nodo<ConexionSinaptica> temp = actual.getConexionesSalientes().getCabeza();
            while (temp != null) {
                Neurona vecino = temp.getDato().getDestino();
                if (!visitados.contiene(vecino)) {
                    visitados.agregar(vecino);
                    cola.encolar(vecino);
                }
                temp = temp.getSiguiente();
            }
        }
        return visitados;
    }
}
