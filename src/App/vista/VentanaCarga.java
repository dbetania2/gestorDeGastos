package App.vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VentanaCarga extends Application {

    public VentanaCarga() {
        // Constructor vacío requerido por JavaFX
    }

    @Override
    public void start(Stage primaryStage) {
        // Configurar y mostrar la ventana de carga
        Label label = new Label("Bienvenido");
        Button abrirButton = new Button("Abrir");

        abrirButton.setOnAction(event -> {
            // Cuando se presiona el botón "Abrir", se muestra la ventana de inicio
            VentanaInicio ventanaInicio = new VentanaInicio();
            ventanaInicio.start(new Stage());
            primaryStage.close(); // Cerrar la ventana de carga
        });

        VBox root = new VBox(label, abrirButton);
        Scene scene = new Scene(root, 200, 100);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Ventana de Carga");
        primaryStage.show();
    }
}







