package main;

import App.vista.VentanaCarga;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("Método start de Main llamado");
        VentanaCarga ventanaCarga = new VentanaCarga();
        ventanaCarga.start(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}



















