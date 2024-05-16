package App.vista;

import java.util.List;
import java.util.Scanner;
import App.modelo.Gasto;

public class InterfazUsuario {
    private Scanner scanner;

    public InterfazUsuario() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("1. Agregar gasto");
        System.out.println("2. Ver gastos");
        System.out.println("3. Salir");
        System.out.println("4. Editar gasto");
        System.out.println("5. Eliminar gasto");
        System.out.println("6. Ver total de gastos por día");
        System.out.println("7. Ver total de gastos por mes");
        System.out.println("8. Ver total de gastos por año");
    }

    public void mostrarListaGastos(List<Gasto> gastos) {
        System.out.println("Lista de gastos:");
        for (int i = 0; i < gastos.size(); i++) {
            Gasto gasto = gastos.get(i);
            System.out.println(i + 1 + ". " + gasto.getDescripcion() + ": $" + gasto.getCantidad());
        }
    }

    public String[] leerGasto() {
        String[] datosGasto = new String[6]; // Array para almacenar cantidad, descripción, día, mes, año y categoría
        System.out.print("Ingrese la cantidad del gasto: ");
        datosGasto[0] = scanner.nextLine(); // Cantidad del gasto
        System.out.print("Ingrese la descripción del gasto: ");
        datosGasto[1] = scanner.nextLine(); // Descripción del gasto
        System.out.print("Ingrese el día: ");
        datosGasto[2] = scanner.nextLine(); // Día del gasto
        System.out.print("Ingrese el mes: ");
        datosGasto[3] = scanner.nextLine(); // Mes del gasto
        System.out.print("Ingrese el año: ");
        datosGasto[4] = scanner.nextLine(); // Año del gasto
        System.out.print("Ingrese la categoría del gasto: ");
        datosGasto[5] = scanner.nextLine(); // Categoría del gasto
        return datosGasto;
    }



    public int leerIndice() {
        System.out.print("Ingrese el número del gasto que desea editar/eliminar: ");
        return scanner.nextInt();
    }

    public int leerDia() {
        System.out.print("Ingrese el día para filtrar los gastos: ");
        return scanner.nextInt();
    }

    public int leerMes() {
        System.out.print("Ingrese el mes para filtrar los gastos: ");
        return scanner.nextInt();
    }

    public int leerAño() {
        System.out.print("Ingrese el año para filtrar los gastos: ");
        return scanner.nextInt();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public String leerCategoria() {
        System.out.print("Ingrese la categoría del gasto: ");
        return scanner.nextLine();
    }

    public void mostrarResumenPorCategoria(List<String> resumenPorCategoria) {
        System.out.println("Resumen de gastos por categoría:");
        for (String categoria : resumenPorCategoria) {
            System.out.println(categoria);
        }
    }
}




