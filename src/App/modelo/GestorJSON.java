package App.modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GestorJSON {
    private String rutaArchivo;

    public GestorJSON(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public void crearArchivo() {
        try {
            File archivo = new File(rutaArchivo);
            if (archivo.createNewFile()) {
                System.out.println("Archivo JSON creado en: " + archivo.getAbsolutePath());
            } else {
                System.out.println("El archivo JSON ya existe en: " + archivo.getAbsolutePath());
            }
        } catch (IOException e) {
            System.err.println("Error al crear el archivo JSON: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void guardarGastos(List<Gasto> gastos) {
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            // Inicializar el JSON
            writer.write("[\n");

            // Escribir cada gasto en el JSON
            for (int i = 0; i < gastos.size(); i++) {
                Gasto gasto = gastos.get(i);
                String jsonGasto = "{\"cantidad\":\"" + gasto.getCantidad() + "\", \"descripcion\":\"" + gasto.getDescripcion() + "\", \"categoria\":\"" + gasto.getCategoria() + "\", \"dia\":\"" + gasto.getDia() + "\", \"mes\":\"" + gasto.getMes() + "\", \"año\":\"" + gasto.getAño() + "\"}";
                writer.write(jsonGasto);

                // Si no es el último gasto, añadir una coma
                if (i < gastos.size() - 1) {
                    writer.write(",\n");
                }
            }

            // Finalizar el JSON
            writer.write("\n]");
            System.out.println("Gastos guardados en el archivo JSON.");
        } catch (IOException e) {
            System.err.println("Error al guardar los gastos en el archivo JSON: " + e.getMessage());
            e.printStackTrace();
        }
    }
}








