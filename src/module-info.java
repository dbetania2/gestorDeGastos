module gestorDeGastosPersonales {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.core;
    exports main;
    exports App.vista;
    opens App.vista to javafx.fxml; // Asegúrate de abrir el paquete para javafx.fxml
    opens App.controlador to javafx.fxml; // Abre el paquete controlador también
    opens App.modelo to com.fasterxml.jackson.databind; // Abre el paquete modelo para Jackson
    opens main to javafx.fxml;
    exports App.controlador;
    exports App.modelo;
}

