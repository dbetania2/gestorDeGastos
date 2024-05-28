package App.modelo;

import java.io.File;
import java.io.IOException;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GestorJSON {
    private final String rutaCarpeta = "src/resources/"; // Carpeta donde se guardarán los archivos JSON

    public GestorJSON() {
        // Constructor vacío
    }

    // Método para guardar un nuevo gasto en el archivo JSON
    public void agregarGasto(Gasto nuevoGasto, String nombreArchivo) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Crear el archivo si no existe
            crearArchivo(nombreArchivo);

            // Obtener la lista de gastos existente
            List<Gasto> gastos = cargarGastos(nombreArchivo);

            // Agregar el nuevo gasto a la lista
            gastos.add(nuevoGasto);

            // Guardar la lista actualizada en el archivo JSON
            File file = new File(rutaCarpeta + nombreArchivo + ".json");
            mapper.writeValue(file, gastos);

            System.out.println("Gasto agregado y guardado en el archivo JSON: " + nombreArchivo + ".json");
        } catch (IOException e) {
            System.err.println("Error al agregar el gasto y guardar en el archivo JSON: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Método para cargar la lista de gastos desde el archivo JSON
    public List<Gasto> cargarGastos(String nombreArchivo) {
        ObjectMapper mapper = new ObjectMapper();
        List<Gasto> gastos = null;
        try {
            File file = new File(rutaCarpeta + nombreArchivo + ".json");
            if (file.exists()) {
                // Cargar la lista de gastos si el archivo existe y no está vacío
                if (file.length() > 0) {
                    gastos = mapper.readValue(file, new TypeReference<List<Gasto>>() {});
                    System.out.println("Gastos cargados desde el archivo JSON: " + nombreArchivo + ".json");
                } else {
                    System.err.println("El archivo JSON está vacío: " + nombreArchivo + ".json");
                }
            } else {
                System.err.println("El archivo JSON no existe: " + nombreArchivo + ".json");
            }
        } catch (IOException e) {
            System.err.println("Error al cargar los gastos desde el archivo JSON: " + e.getMessage());
            e.printStackTrace();
        }
        return gastos;
    }

    // Método para crear el archivo si no existe
    public void crearArchivo(String nombreArchivo) {
        try {
            File file = new File(rutaCarpeta + nombreArchivo + ".json");
            if (file.createNewFile()) {
                System.out.println("Archivo JSON creado: " + nombreArchivo + ".json");
            } else {
                System.out.println("El archivo JSON ya existe: " + nombreArchivo + ".json");
            }
        } catch (IOException e) {
            System.err.println("Error al crear el archivo JSON: " + e.getMessage());
            e.printStackTrace();
        }
    }
}














