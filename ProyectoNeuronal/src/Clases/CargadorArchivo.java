package clases;

import javax.swing.*;
import java.io.*;

/**
 * Clase encargada de cargar archivos CSV al sistema.
 * Utiliza JFileChooser para que el usuario seleccione los archivos
 * y parsea la información para construir la red neuronal o el diccionario.
 */
public class CargadorArchivo {

    /**
     * Carga una red neuronal desde un archivo CSV seleccionado por el usuario.
     * Formato esperado: origen, destino, distancia, ID_Neurotransmisor, coef_eficiencia
     *
     * @param red  Red neuronal donde se almacenarán las neuronas y conexiones.
     * @param dicc Diccionario de neurotransmisores (se puede usar para validar).
     */
    public void cargarRedNeuronal(redNeuronal red, DiccionarioNeurotransmisores dicc) {
        if (!red.estaVacia()) {
            int opcion = JOptionPane.showConfirmDialog(null,
                    "Hay una red cargada en memoria. ¿Desea sobrescribirla?",
                    "Red existente",
                    JOptionPane.YES_NO_OPTION);
            if (opcion != JOptionPane.YES_OPTION) {
                return;
            }
            red.limpiar();
        }

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar archivo de red neuronal");
        int seleccion = fileChooser.showOpenDialog(null);
        if (seleccion != JFileChooser.APPROVE_OPTION) {
            return;
        }

        File archivo = fileChooser.getSelectedFile();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            br.readLine();
            int conexionesCargadas = 0;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length < 5) continue;

                String idOrigen = datos[0].trim();
                String idDestino = datos[1].trim();
                double distancia = Double.parseDouble(datos[2].trim());
                String idNeurotransmisor = datos[3].trim();
                double k = Double.parseDouble(datos[4].trim());

                Neurona origen = obtenerOCrearNeurona(red, idOrigen);
                Neurona destino = obtenerOCrearNeurona(red, idDestino);

                ConexionSinaptica conexion = new ConexionSinaptica(origen, destino, distancia, idNeurotransmisor, k);
                origen.agregarConexion(conexion);
                conexionesCargadas++;
            }

            JOptionPane.showMessageDialog(null,
                    "Red cargada exitosamente.\nNeuronas: " + red.getCantidadNeuronas() +
                    "\nConexiones: " + conexionesCargadas);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Error al leer el archivo:\n" + e.getMessage(),
                    "Error de carga",
                    JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "El archivo contiene valores numéricos no válidos.",
                    "Error de formato",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Carga el diccionario de neurotransmisores desde un archivo CSV.
     * Formato esperado: id, nombre, efecto, velocidad, descripcion
     *
     * @param dicc Diccionario donde se almacenarán los neurotransmisores.
     */
    public void cargarDiccionario(DiccionarioNeurotransmisores dicc) {
        if (!dicc.estaVacio()) {
            int opcion = JOptionPane.showConfirmDialog(null,
                    "Ya hay un diccionario cargado. ¿Desea reemplazarlo?",
                    "Diccionario existente",
                    JOptionPane.YES_NO_OPTION);
            if (opcion != JOptionPane.YES_OPTION) {
                return;
            }
            dicc.vaciar();
        }

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar archivo de diccionario de neurotransmisores");
        int seleccion = fileChooser.showOpenDialog(null);
        if (seleccion != JFileChooser.APPROVE_OPTION) {
            return;
        }

        File archivo = fileChooser.getSelectedFile();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            br.readLine();
            int cargados = 0;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",", 5);
                if (datos.length < 5) continue;

                String id = datos[0].trim();
                String nombre = datos[1].trim();
                String efecto = datos[2].trim();
                double velocidad = Double.parseDouble(datos[3].trim());
                String descripcion = datos[4].trim().replace("\"", "");

                Neurotransmisor nt = new Neurotransmisor(id, nombre, efecto, velocidad, descripcion);
                dicc.insertar(nt);
                cargados++;
            }

            JOptionPane.showMessageDialog(null,
                    "Diccionario cargado exitosamente.\nNeurotransmisores: " + cargados);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Error al leer el diccionario:\n" + e.getMessage(),
                    "Error de carga",
                    JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "El archivo contiene valores de velocidad no válidos.",
                    "Error de formato",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Busca una neurona por su ID en la red; si no existe, la crea, la agrega y la devuelve.
     *
     * @param red Red neuronal donde buscar o crear la neurona.
     * @param id  ID de la neurona.
     * @return La neurona existente o recién creada.
     */
    private Neurona obtenerOCrearNeurona(redNeuronal red, String id) {
        Neurona n = red.buscarNeurona(id);
        if (n == null) {
            n = new Neurona(id);
            red.agregarNeurona(n);
        }
        return n;
    }
}