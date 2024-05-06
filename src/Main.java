import vista.InterfazUsuario;
import modelo.GestorGastos;
import controlador.Controlador;
import java.util.Scanner; // Importa Scanner

public class Main {
    public static void main(String[] args) {
        // Crear instancias de la vista y el modelo
        InterfazUsuario interfazUsuario = new InterfazUsuario();
        GestorGastos gestorGastos = new GestorGastos();
        Scanner scanner = new Scanner(System.in); // Crea un objeto Scanner

        // Crear una instancia del controlador y pasarle la vista, el modelo y el scanner
        Controlador controlador = new Controlador(interfazUsuario, gestorGastos, scanner);

        // Iniciar la aplicación a través del controlador
        controlador.iniciar();
    }
}


