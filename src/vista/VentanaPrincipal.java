package App.vista;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class VentanaPrincipal {

    public void mostrarVentana() {
        // Crear componentes de la interfaz
        Label label = new Label("Bienvenido al Gestor de Gastos Personales");
        Button botonAbrir = new Button("Abrir");

        // Configurar la acción del botón "Abrir"
        botonAbrir.setOnAction(e -> {
            // Crear y mostrar la ventana de inicio al hacer clic en el botón "Abrir"
            VentanaInicio ventanaInicio = new VentanaInicio();
            ventanaInicio.mostrarVentana();
        });

        // Crear el diseño de la ventana principal
        StackPane layout = new StackPane();
        layout.getChildren().addAll(label, botonAbrir);

        // Configurar la escena y mostrar la ventana principal
        Scene scene = new Scene(layout, 400, 300);
        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Gestor de Gastos Personales");
        primaryStage.show();
    }
}


