package App.vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import App.modelo.GestorJSON; // Importamos la clase GestorJSON

import java.util.Objects;

public class VentanaInicio extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("Método start de VentanaInicio llamado");

        // Configurar el GestorJSON
        String rutaArchivoJSON = "src/resources/gastos.json"; // Ruta al archivo JSON
        GestorJSON gestorJSON = new GestorJSON(rutaArchivoJSON);
        gestorJSON.crearArchivo(); // Crear el archivo JSON

        // Cargar el archivo FXML de la Ventana de Inicio
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/resources/VentanaInicio.fxml")));

        // Crear la escena y agregar el archivo CSS
        Scene scene = new Scene(root, 600, 400);
        scene.getStylesheets().add(getClass().getResource("/resources/style.css").toExternalForm());

        // Configurar y mostrar la ventana de inicio
        primaryStage.setScene(scene);
        primaryStage.setTitle("Gestor de Gastos Personales");
        primaryStage.show();

        // Cerrar la ventana de carga después de que la ventana de inicio esté lista
        primaryStage.setOnShown(event -> {
            ((Stage) root.getScene().getWindow()).close(); // Cerrar la ventana de carga
        });
    }
}







