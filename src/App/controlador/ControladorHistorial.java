package App.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import App.modelo.Gasto;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ControladorHistorial {

    @FXML
    private VBox root;

    @FXML
    private TableView<Gasto> historialTableView;

    @FXML
    private TableColumn<Gasto, String> descripcionColumn;

    @FXML
    private TableColumn<Gasto, String> categoriaColumn;

    @FXML
    private TableColumn<Gasto, Integer> diaColumn;

    @FXML
    private TableColumn<Gasto, Integer> mesColumn;

    @FXML
    private TableColumn<Gasto, Integer> añoColumn;

    @FXML
    private TableColumn<Gasto, Double> cantidadColumn;

    @FXML
    private void initialize() {
        // Configurar las columnas de la tabla
        descripcionColumn.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        categoriaColumn.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        diaColumn.setCellValueFactory(new PropertyValueFactory<>("dia"));
        mesColumn.setCellValueFactory(new PropertyValueFactory<>("mes"));
        añoColumn.setCellValueFactory(new PropertyValueFactory<>("año"));
        cantidadColumn.setCellValueFactory(new PropertyValueFactory<>("cantidad"));

        // Cargar el historial desde el JSON
        cargarHistorialDesdeJSON();
    }

    // Método para cargar el historial desde el JSON
    private void cargarHistorialDesdeJSON() {
        try {
            // Leer el JSON y mapearlo a una lista de objetos Gasto
            ObjectMapper objectMapper = new ObjectMapper();
            List<Gasto> historial = objectMapper.readValue(getClass().getResource("/resources/gastos.json"), objectMapper.getTypeFactory().constructCollectionType(List.class, Gasto.class));


            // Convertir la lista a una lista observable
            ObservableList<Gasto> observableHistorial = FXCollections.observableArrayList(historial);

            // Establecer los datos en la tabla
            historialTableView.setItems(observableHistorial);
        } catch (IOException e) {
            e.printStackTrace();
            // Manejar la excepción si ocurre un error al leer el JSON
        }
    }

    // Método para cargar el historial desde una lista proporcionada
    public void cargarHistorial(List<Gasto> historial) {
        // Convertir la lista a una lista observable
        ObservableList<Gasto> observableHistorial = FXCollections.observableArrayList(historial);

        // Establecer los datos en la tabla
        historialTableView.setItems(observableHistorial);
    }
}



