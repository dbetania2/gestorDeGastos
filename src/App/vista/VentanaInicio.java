package App.vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class VentanaInicio extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Configura y muestra la ventana de inicio
        Label label = new Label("¡Bienvenido a la Ventana de Inicio!");
        StackPane root = new StackPane(label);
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Ventana de Inicio");
        primaryStage.show();
    }
}
