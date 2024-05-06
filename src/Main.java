import vista.VentanaInicio;
import vista.InterfazUsuario;
import modelo.GestorGastos;
import controlador.Controlador;
import java.util.Scanner;
import vista.VentanaPrincipal;
public class Main {
    public static void main(String[] args) {
        // Crear instancias de la vista y el modelo
        InterfazUsuario interfazUsuario = new InterfazUsuario();
        GestorGastos gestorGastos = new GestorGastos();
        Scanner scanner = new Scanner(System.in);

        // Crear instancias de las ventanas
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
        VentanaInicio ventanaInicio = new VentanaInicio();

        // Hacer visible la ventana principal
        ventanaPrincipal.setVisible(true);

        // Iniciar la aplicación a través del controlador después de que el usuario interactúe con la interfaz de usuario
        Controlador controlador = new Controlador(interfazUsuario, gestorGastos, scanner);
        controlador.iniciar();
    }
}




