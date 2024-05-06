package vista;

import javax.swing.*;

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {
        // Configuración de la ventana principal
        setTitle("Gestor de Gastos Personales");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Crear componentes de la interfaz
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Bienvenido al Gestor de Gastos Personales");
        JButton boton = new JButton("Abrir");

        // Agregar componentes al panel
        panel.add(label);
        panel.add(boton);

        // Agregar panel a la ventana principal
        add(panel);

        // Asignar acción al botón "Abrir"
        boton.addActionListener(e -> {
            // Crear y mostrar la ventana de inicio al hacer clic en el botón "Abrir"
            VentanaInicio ventanaInicio = new VentanaInicio();
            ventanaInicio.setVisible(true);
        });
    }
}



