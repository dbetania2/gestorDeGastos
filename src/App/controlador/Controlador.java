package App.controlador;
import javafx.scene.control.Button; // Asegúrate de tener esta importación
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import java.time.LocalDate;
import java.io.IOException;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader; // Importa la clase FXMLLoader

public class Controlador {

    @FXML
    private Button historialButton;
    @FXML
    private VBox formularioAgregarGasto;

    @FXML
    private TextField cantidadTextField;

    @FXML
    private TextField descripcionTextField;

    @FXML
    private TextField categoriaTextField;

    @FXML
    private TextField diaTextField;

    @FXML
    private TextField mesTextField;

    @FXML
    private TextField añoTextField;

    @FXML
    private void mostrarFormularioAgregarGasto() {
        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();

        // Obtener el día, mes y año
        int dia = fechaActual.getDayOfMonth();
        int mes = fechaActual.getMonthValue();
        int año = fechaActual.getYear();

        // Actualizar los campos de texto con la fecha actual
        diaTextField.setText(String.valueOf(dia));
        mesTextField.setText(String.valueOf(mes));
        añoTextField.setText(String.valueOf(año));

        formularioAgregarGasto.setVisible(true);
    }

    @FXML
    private void cambiarFecha() {
        // Obtener los valores de los campos de texto
        int nuevoDia = Integer.parseInt(diaTextField.getText());
        int nuevoMes = Integer.parseInt(mesTextField.getText());
        int nuevoAño = Integer.parseInt(añoTextField.getText());

        // Validar la nueva fecha
        if (nuevoDia < 1 || nuevoDia > 31 || nuevoMes < 1 || nuevoMes > 12 || nuevoAño < 1900 || nuevoAño > 2100) {
            // Manejar el error de fecha inválida, por ejemplo, mostrar un mensaje al usuario
            System.out.println("Fecha inválida. Por favor, ingrese una fecha válida.");
            return;
        }

        // Actualizar la fecha
        diaTextField.setText(String.valueOf(nuevoDia));
        mesTextField.setText(String.valueOf(nuevoMes));
        añoTextField.setText(String.valueOf(nuevoAño));
    }

    @FXML
    private void agregarGasto() {
        // Implementa la lógica para agregar un nuevo gasto
        String cantidad = cantidadTextField.getText();
        String descripcion = descripcionTextField.getText();
        String categoria = categoriaTextField.getText();
        String dia = diaTextField.getText();
        String mes = mesTextField.getText();
        String año = añoTextField.getText();

        // Validar y procesar los datos ingresados
        System.out.println("Gasto agregado: " + descripcion + " - " + cantidad + " - " + categoria + " - " + dia + "/" + mes + "/" + año);

        // Ocultar el formulario después de agregar el gasto
        formularioAgregarGasto.setVisible(false);
    }

    @FXML
    private void eliminarGasto() {
        // Implementa la lógica para eliminar un gasto
        System.out.println("Gasto eliminado");
    }
    @FXML
    private void mostrarHistorial() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/VentanaHistorial.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.setTitle("Historial de Gastos");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}














