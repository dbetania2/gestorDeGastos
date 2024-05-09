package App.vista;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class VentanaInicio {

    public void mostrarVentana() {
        // Configuración de la ventana de inicio
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Inicio");

        // Crear componentes de la interfaz
        BorderPane root = new BorderPane();
        TextArea textArea = new TextArea();
        Button button = new Button("Agregar Gasto");

        // Agregar componentes al layout
        root.setCenter(textArea);
        root.setBottom(button);

        // Configurar la acción del botón "Agregar Gasto"
        button.setOnAction(e -> {
            // Aquí debes manejar la lógica para agregar un gasto
            // Por ahora, simplemente mostraremos un mensaje
            System.out.println("¡Gasto agregado!"); // Imprimir en consola
        });

        // Configurar la escena y mostrar la ventana de inicio
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}




