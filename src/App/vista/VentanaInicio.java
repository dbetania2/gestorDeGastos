package App.vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import App.modelo.GestorJSON; // Importamos la clase GestorJSON

import java.net.URL; // Importamos la clase URL

public class VentanaInicio extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("Método start de VentanaInicio llamado");

        // Configurar el GestorJSON
        //GestorJSON gestorJSON = new GestorJSON(); // Instanciamos GestorJSON sin argumentos

        // Cargar el archivo FXML de la Ventana de Inicio
        URL resourceUrl = getClass().getResource("/resources/VentanaInicio.fxml");
        if (resourceUrl != null) {
            Parent root = FXMLLoader.load(resourceUrl);

            // Crear la escena y agregar el archivo CSS
            Scene scene = new Scene(root, 600, 400);
            URL cssUrl = getClass().getResource("/resources/style.css");
            if (cssUrl != null) {
                scene.getStylesheets().add(cssUrl.toExternalForm());
            } else {
                System.err.println("No se pudo cargar el archivo CSS.");
            }

            // Configurar y mostrar la ventana de inicio
            primaryStage.setScene(scene);
            primaryStage.setTitle("Gestor de Gastos Personales");
            primaryStage.show();

            // Cerrar la ventana de carga después de que la ventana de inicio esté lista
            primaryStage.setOnShown(event -> {
                ((Stage) root.getScene().getWindow()).close(); // Cerrar la ventana de carga
            });
        } else {
            System.err.println("No se pudo cargar el archivo FXML de la Ventana de Inicio.");
        }
    }
}








