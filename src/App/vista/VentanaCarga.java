package App.vista;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Objects;

public class VentanaCarga extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("Método start de VentanaCarga llamado");
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/resources/VentanaCarga.fxml")));
        Scene scene = new Scene(root, 300, 200);
        scene.getStylesheets().add(getClass().getResource("/resources/style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Cargando...");
        primaryStage.show();

        // Crear una transición de pausa para cambiar a la ventana de inicio después de 2 segundos
        PauseTransition delay = new PauseTransition(Duration.seconds(2));
        delay.setOnFinished(event -> {
            System.out.println("Transición de pausa completada");
            // Cambiar a la ventana de inicio
            try {
                new VentanaInicio().start(primaryStage); // Pasar el mismo Stage a VentanaInicio
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        delay.play();
    }
}













