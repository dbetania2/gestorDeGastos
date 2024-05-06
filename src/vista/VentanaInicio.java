package vista;

import javax.swing.*;

public class VentanaInicio extends JFrame {

    private JPanel panel1;

    public VentanaInicio() {
        // Configuración de la ventana de inicio
        setTitle("Inicio");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cambiar a DISPOSE_ON_CLOSE
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Crear componentes de la interfaz
        JPanel panel = new JPanel();
        JTextPane textPane = new JTextPane();
        JButton button = new JButton("Agregar Gasto");

        // Agregar componentes al panel
        panel.add(textPane);
        panel.add(button);

        // Agregar panel a la ventana de inicio
        add(panel);

        // Asignar acción al botón "Agregar Gasto"
        button.addActionListener(e -> {
            // Aquí debes manejar la lógica para agregar un gasto
            // Por ahora, simplemente mostraremos un mensaje
            JOptionPane.showMessageDialog(this, "¡Gasto agregado!"); // Ventana de mensaje
        });
    }
}


