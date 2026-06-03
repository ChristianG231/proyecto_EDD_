package clases;

import Edd.ListaEnlazada;
import Edd.Nodo;

/**
 * Representa la red neuronal completa.
 * Contiene todas las neuronas y permite buscar, agregar, eliminar
 * y reiniciar el estado de visitado para los algoritmos de recorrido.
 */
public class redNeuronal {


    private ListaEnlazada<Neurona> todasLasNeuronas;

    /**
     * Constructor. Inicializa la red vacía.
     */
    public redNeuronal() {
        this.todasLasNeuronas = new ListaEnlazada<>();
    }



    /**
     * Busca una neurona por su ID.
     * Actualmente realiza una búsqueda secuencial O(n).
     * (Futuro: se podría delegar en una TablaHash para O(1)).
     *
     * @param id El identificador de la neurona a buscar.
     * @return La neurona encontrada, o null si no existe.
     */
    public Neurona buscarNeurona(String id) {
        Nodo<Neurona> temp = todasLasNeuronas.getCabeza();
        while (temp != null) {
            if (temp.getDato().getId().equals(id)) {
                return temp.getDato();
            }
            temp = temp.getSiguiente();
        }
        return null;
    }

    /**
     * Agrega una neurona a la red.
     * No verifica duplicados; se asume que quien la invoca ya validó.
     *
     * @param n La neurona a agregar.
     */
    public void agregarNeurona(Neurona n) {
        this.todasLasNeuronas.agregar(n);
    }

    /**
     * Elimina una neurona de la red por su ID.
     * También deberían eliminarse sus conexiones entrantes y salientes.

     *
     * @param id El identificador de la neurona a eliminar.
     * @return true si se eliminó, false si no existía.
     */
    public boolean eliminarNeurona(String id) {
        Nodo<Neurona> actual = todasLasNeuronas.getCabeza();
        Nodo<Neurona> anterior = null;

        while (actual != null) {
            if (actual.getDato().getId().equals(id)) {
                if (anterior == null) {
                    todasLasNeuronas.setCabeza(actual.getSiguiente());
                } else {
                    anterior.setSiguiente(actual.getSiguiente());
                }
                todasLasNeuronas.setTamaño(todasLasNeuronas.getTamaño() - 1);
                return true;
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }
        return false;
    }



    /**
     * Reinicia el atributo visitado de todas las neuronas a false.
     * Se invoca antes de ejecutar BFS o DFS para garantizar
     * que las marcas de recorridos anteriores no interfieran.
     */
    public void reiniciarVisitados() {
        Nodo<Neurona> temp = todasLasNeuronas.getCabeza();
        while (temp != null) {
            temp.getDato().visitado = false;
            temp = temp.getSiguiente();
        }
    }



    /**
     * @return La lista enlazada que contiene todas las neuronas.
     */
    public ListaEnlazada<Neurona> getListaTodasLasNeuronas() {
        return todasLasNeuronas;
    }

    /**
     * @return La cantidad de neuronas en la red.
     */
    public int getCantidadNeuronas() {
        return todasLasNeuronas.getTamaño();
    }

    /**
     * Vacía completamente la red, eliminando todas las neuronas.
     */
    public void limpiar() {
        this.todasLasNeuronas = new ListaEnlazada<>();
    }

    /**
     * Verifica si la red está vacía.
     * @return true si no hay neuronas.
     */
    public boolean estaVacia() {
        return todasLasNeuronas.estaVacia();
    }
}
