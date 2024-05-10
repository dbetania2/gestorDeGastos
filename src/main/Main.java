package main;

import App.vista.VentanaCarga;
import App.vista.VentanaInicio;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Iniciar la ventana de carga
        VentanaCarga ventanaCarga = new VentanaCarga();
        ventanaCarga.start(primaryStage);

        // Crear una transición de pausa para cambiar a la ventana de inicio después de 2 segundos
        PauseTransition delay = new PauseTransition(Duration.seconds(2));
        delay.setOnFinished(event -> {
            // Cambiar a la ventana de inicio
            VentanaInicio ventanaInicio = new VentanaInicio();
            try {
                ventanaInicio.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        delay.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}












