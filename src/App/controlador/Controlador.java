package App.controlador;

import App.modelo.Gasto;
import App.modelo.GestorJSON;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controlador {
    @FXML
    private Button historialButton;

    @FXML
   // private ControladorHistorial controladorHistorial;

    private final GestorJSON gestorJSON;

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

    public Controlador() {
        this.gestorJSON = new GestorJSON();
    }

    @FXML
    public void initialize() {
        // Crear el archivo JSON si no existe
        gestorJSON.crearArchivo("gastos");

        // Cargar los gastos al iniciar la aplicación
        List<Gasto> gastos = gestorJSON.cargarGastos("gastos");
        if (gastos != null) {
            // Manejar los gastos cargados, por ejemplo, mostrarlos en algún lugar de la interfaz
        }
    }
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
    private void guardarGasto() {
        try {
            // Obtener los valores ingresados en los campos de texto del formulario
            double cantidad = Double.parseDouble(cantidadTextField.getText());
            String descripcion = descripcionTextField.getText();
            String categoria = categoriaTextField.getText();
            int dia = Integer.parseInt(diaTextField.getText());
            int mes = Integer.parseInt(mesTextField.getText());
            int año = Integer.parseInt(añoTextField.getText());

            // Crear el objeto Gasto
            Gasto nuevoGasto = new Gasto(cantidad, descripcion, dia, mes, año, categoria);

            // Guardar el gasto en el JSON
            List<Gasto> listaGastos = new ArrayList<>();
            listaGastos.add(nuevoGasto);
            gestorJSON.agregarGasto(nuevoGasto, "gastos");


            // Limpiar los campos del formulario
            limpiarCampos();

            // Hacer invisible el formulario de agregar gasto
            formularioAgregarGasto.setVisible(false);
        } catch (NumberFormatException e) {
            // Capturar la excepción si hay un error al convertir texto en números
            System.err.println("Error: Los valores ingresados no son válidos.");
            e.printStackTrace();
            // Aquí puedes mostrar un mensaje de error al usuario si prefieres
        } catch (Exception e) {
            // Capturar cualquier otra excepción que pueda ocurrir
            System.err.println("Error: No se pudo guardar el gasto.");
            e.printStackTrace();
            // Aquí puedes mostrar un mensaje de error al usuario si prefieres
        }
    }
    @FXML
    private void salirDelFormulario() {
        formularioAgregarGasto.setVisible(false);
        limpiarCampos();
    }


    private void limpiarCampos() {
        cantidadTextField.setText("");
        descripcionTextField.setText("");
        categoriaTextField.setText("");
        diaTextField.setText("");
        mesTextField.setText("");
        añoTextField.setText("");
    }


    @FXML
    private void eliminarGasto() {
        // Implementar la lógica para eliminar un gasto

    }

    @FXML
    private void cargarHistorial() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/VentanaHistorial.fxml"));

            Parent root = loader.load();

            ControladorHistorial controladorHistorial = loader.getController();
            List<Gasto> historial = gestorJSON.cargarGastos("gastos");

            if (historial != null) {
                controladorHistorial.cargarHistorial(historial);
            } else {
                System.out.println("No se pudo cargar el historial de gastos desde el archivo JSON.");
            }

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Historial de Gastos");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}



















