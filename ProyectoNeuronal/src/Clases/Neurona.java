package clases;

import Edd.ListaEnlazada;

/**
 * Representa una neurona dentro de la red neuronal.
 * Cada neurona tiene un identificador único, una lista de conexiones
 * sinápticas salientes y un atributo de marcado para los algoritmos
 * de recorrido (BFS/DFS).

 */
public class Neurona {


    private String id;

   
    private final ListaEnlazada<ConexionSinaptica> conexionesSalientes;

    /**
     * Atributo público usado por BFS y DFS para marcar la neurona como visitada.
     */
    public boolean visitado = false;

    /**
     * Constructor.
     * @param id Identificador único de la neurona .
     */
    public Neurona(String id) {
        this.id = id;
        this.conexionesSalientes = new ListaEnlazada<>();
    }

    /**
     * @return El identificador de la neurona.
     */
    public String getId() {
        return id;
    }

    /**
     * @return La lista de conexiones sinápticas que salen de esta neurona.
     */
    public ListaEnlazada<ConexionSinaptica> getConexionesSalientes() {
        return conexionesSalientes;
    }

    /**
     * Agrega una conexión sináptica a la lista de salientes.
     * @param conexion La conexión a agregar (origen = esta neurona).
     */
    public void agregarConexion(ConexionSinaptica conexion) {
        this.conexionesSalientes.agregar(conexion);
    }
}
