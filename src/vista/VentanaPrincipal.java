package vista;

import javax.swing.*;
import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {

    private JLabel Jlabel;

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

        // Mostrar la ventana
        setVisible(true);
    }

    // Método main para probar la ventana
    public static void main(String[] args) {
        // Crear una instancia de la ventana principal en el hilo de despacho de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            new VentanaPrincipal();
        });
    }
}


