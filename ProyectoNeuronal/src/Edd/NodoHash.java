package Edd;

/**
 * Nodo para la lista enlazada interna de la tabla hash.
 * Guarda un {@link ParClaveValor} y una referencia al siguiente nodo.
 *
 * @param <K> Tipo de la clave.
 * @param <V> Tipo del valor.
 * @author ischl
 */
public class NodoHash<K, V> {
    private final ParClaveValor<K, V> dato;
    private NodoHash<K, V> siguiente;

    /**
     * Constructor.
     *
     * @param dato Par clave-valor que almacena este nodo.
     */
    public NodoHash(ParClaveValor<K, V> dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    /**
     * @return El dato almacenado.
     */
    public ParClaveValor<K, V> getDato() {
        return dato;
    }

    /**
     * @return El siguiente nodo en la lista.
     */
    public NodoHash<K, V> getSiguiente() {
        return siguiente;
    }

    /**
     * Asigna el siguiente nodo.
     *
     * @param siguiente Nodo a enlazar.
     */
    public void setSiguiente(NodoHash<K, V> siguiente) {
        this.siguiente = siguiente;
    }
}
