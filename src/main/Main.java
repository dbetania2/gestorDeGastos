package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Verificar si el recurso FXML existe
        URL fxmlUrl = getClass().getResource("/resources/VentanaCarga.fxml");
        if (fxmlUrl == null) {
            // Manejar la situación en la que el recurso no se encuentra
            System.err.println("No se pudo encontrar el archivo FXML VentanaCarga.fxml");
            // Salir de la aplicación o tomar otras acciones según sea necesario
            return;
        }

        // Cargar el archivo FXML
        Parent root = FXMLLoader.load(fxmlUrl);
        Scene scene = new Scene(root, 600, 400);

        // Obtener la URL del recurso CSS
        URL cssUrl = getClass().getResource("/resources/style.css");
        if (cssUrl == null) {
            // Manejar la situación en la que el recurso no se encuentra
            System.err.println("No se pudo encontrar el archivo CSS style.css");
            // Salir de la aplicación o tomar otras acciones según sea necesario
            return;
        }

        // Agregar el archivo CSS a la escena si se encuentra
        scene.getStylesheets().add(cssUrl.toExternalForm());


        // Configurar la escena en el escenario y mostrarlo
        primaryStage.setScene(scene);
        primaryStage.setTitle("Pantalla de Carga");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}










