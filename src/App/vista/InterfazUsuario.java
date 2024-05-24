package App.vista;

import java.util.List;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import App.modelo.Gasto;
import javafx.scene.layout.VBox;

public class InterfazUsuario {
    private ListView<String> gastosListView;
    private Label mensajeLabel;
    private TextField cantidadTextField;
    private TextField descripcionTextField;
    private TextField diaTextField;
    private TextField mesTextField;
    private TextField añoTextField;
    private TextField categoriaTextField;
    private VBox formularioAgregarGasto; // Agregar el campo para el formulario de agregar gasto

    public InterfazUsuario(ListView<String> gastosListView, Label mensajeLabel, TextField cantidadTextField,
                           TextField descripcionTextField, TextField diaTextField, TextField mesTextField,
                           TextField añoTextField, TextField categoriaTextField, VBox formularioAgregarGasto) {
        this.gastosListView = gastosListView;
        this.mensajeLabel = mensajeLabel;
        this.cantidadTextField = cantidadTextField;
        this.descripcionTextField = descripcionTextField;
        this.diaTextField = diaTextField;
        this.mesTextField = mesTextField;
        this.añoTextField = añoTextField;
        this.categoriaTextField = categoriaTextField;
        this.formularioAgregarGasto = formularioAgregarGasto; // Inicializar el formulario de agregar gasto
    }

    public void mostrarListaGastos(List<Gasto> gastos) {
        gastosListView.getItems().clear();
        for (Gasto gasto : gastos) {
            gastosListView.getItems().add(gasto.getDescripcion() + ": $" + gasto.getCantidad());
        }
    }

    public String[] leerGasto() {
        String[] datosGasto = new String[6];
        datosGasto[0] = cantidadTextField.getText();
        datosGasto[1] = descripcionTextField.getText();
        datosGasto[2] = diaTextField.getText();
        datosGasto[3] = mesTextField.getText();
        datosGasto[4] = añoTextField.getText();
        datosGasto[5] = categoriaTextField.getText();
        return datosGasto;
    }

    public int leerIndice() {
        // Por implementar si es necesario en la GUI
        return 0;
    }

    public void mostrarMensaje(String mensaje) {
        mensajeLabel.setText(mensaje);
    }

    public void mostrarResumenPorCategoria(List<String> resumenPorCategoria) {
        // Por implementar si es necesario en la GUI
    }

    public void mostrarFormularioAgregarGasto() {
        // Hacer visible el formulario de agregar gasto
        formularioAgregarGasto.setVisible(true);
    }
}






