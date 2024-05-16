package App.vista;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class VentanaCarga extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/resources/VentanaCarga.fxml"));
        Scene scene = new Scene(root, 300, 200);
        scene.getStylesheets().add(getClass().getResource("/resources/style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Cargando...");
        primaryStage.show();

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











