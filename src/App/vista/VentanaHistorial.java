package App.vista;
import App.modelo.Gasto;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

import java.util.List;

public class VentanaHistorial {

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
    }

    // Método para cargar el historial de gastos en la tabla
    public void cargarHistorial(List<Gasto> historial) {
        ObservableList<Gasto> observableHistorial = FXCollections.observableArrayList(historial);
        historialTableView.setItems(observableHistorial);
    }

    // Otros métodos para manejar la funcionalidad de la ventana del historial
}
