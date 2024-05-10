package App.vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VentanaCarga extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/resources/VentanaCarga.fxml"));
        Scene scene = new Scene(root, 200, 100);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Ventana de Carga");
        primaryStage.show();
    }
}








