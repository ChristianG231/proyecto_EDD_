/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import Edd.TablaHash;

/**
 *
 * @author ischl
 */
public class DiccionarioNeurotransmisores {
    private TablaHash<String, Neurotransmisor> tabla;
    
    /**
     * Constructor.
     * Crea una tabla hash con capacidad para 53 elementos.
     * 53 es un número primo que ayuda a distribuir mejor las claves.
     */
    public DiccionarioNeurotransmisores(){
        this.tabla = new TablaHash<>(53);
    }
    
    /**
     * inserta un neurotransmisor en el diccionario.
     * Si ya existe uno con el mismo ID, se sobrescribe.
     * complejidad: O(1) promedio.
     * @param nt El neurotransmisor a guardar.
     */
    public void insertar(Neurotransmisor nt){
        tabla.insertar(nt.getId(), nt);
    }
    
    /**
     * Busca un neurotransmisor por su ID.
     * Complejidad: O(1) promedio.
     * @param id El código del neurotransmisor.
     * @return El neurotransmisor encontrado, o null si no existe.
     */
    public Neurotransmisor buscar(String id){
        return tabla.buscar(id);
    }
    
    /**
     * Verifica si un neurotransmisor existe en el diccionario.
     * complejidad: O(1) promedio.
     * @param id El código a verificar.
     * @return true si existe, false si no existe
     */
    public boolean contiene(String id){
        return tabla.contiene(id);
    }
    
    /**
     * Elimina un neurotransmisor del diccionario.
     * Complejidad: O(1) promedio.
     * @param id El código del neurotransmisor a eliminar
     * @return true si se eliminó, false si no existía.
     */
    public boolean eliminar(String id){
        return tabla.eliminar(id);
    }
    
    /**
     * Reemplaza el diccionario actual por uno nuevo vacio.
     * complejidad: O(1) promedio.
     */
    public void vaciar(){
        this.tabla = new TablaHash<>(53);
    }
    
    /**
     * 
     * @return Cantidad de neurotransmisores almacenados.
     */
    public int getCantidad(){
        return tabla.getSize();
    }
    
    /**
     * 
     * @return true si el diccionario está vacío.
     */
    public boolean estaVacio(){
        return tabla.estaVacia();
    }
}
