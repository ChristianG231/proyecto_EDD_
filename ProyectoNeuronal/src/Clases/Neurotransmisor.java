/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 * Representa un neurotransmisor con sus propiedades químicas.
 * Sus atributos son inmutables una vez creado porque se cargan desde el archivo CSV del diccionario y no se modifican
 * @author ischl
 */
public class Neurotransmisor {
    private final String id;
    private final String nombre;
    private final String efecto;
    private final double velocidad;
    private final String descripcion;
    
    /**
     * Constructor.
     * 
     * @param id Código único.
     * @param nombre Nombre completo.
     * @param efecto Tipo de efecto.
     * @param velocidad Factor de velocidad (v) para la fórmula del tiempo.
     * @param descripcion Descripción breve
     */
    public Neurotransmisor(String id, String nombre, String efecto, double velocidad, String descripcion){
        this.id = id;
        this.nombre = nombre;
        this.efecto = efecto;
        this.velocidad = velocidad;
        this.descripcion = descripcion;
    }
    
    public String getId(){
        return id;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getEfecto(){
        return efecto;
    }
    
    public double getVelocidad(){
        return velocidad;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
}
