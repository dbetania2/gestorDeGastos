package App.vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VentanaInicio extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Cargar el archivo FXML de la Ventana de Inicio
        Parent root = FXMLLoader.load(getClass().getResource("/resources/VentanaInicio.fxml"));

        // Crear la escena y agregar el archivo CSS
        Scene scene = new Scene(root, 600, 400);
        scene.getStylesheets().add(getClass().getResource("/resources/Style.css").toExternalForm());

        // Configurar y mostrar la ventana de inicio
        primaryStage.setScene(scene);
        primaryStage.setTitle("Gestor de Gastos Personales");
        primaryStage.show();
    }

}

