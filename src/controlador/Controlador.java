package controlador;

import java.util.List;
import java.util.Scanner;
import modelo.Gasto;
import modelo.GestorGastos;
import vista.InterfazUsuario;

public class Controlador {
    private InterfazUsuario interfazUsuario;
    private GestorGastos gestorGastos;
    private Scanner scanner;

    public Controlador(InterfazUsuario interfazUsuario, GestorGastos gestorGastos, Scanner scanner) {
        this.interfazUsuario = interfazUsuario;
        this.gestorGastos = gestorGastos;
        this.scanner = scanner;
    }

    public void iniciar() {
        boolean ejecutando = true;
        while (ejecutando) {
            interfazUsuario.mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner
            switch (opcion) {
                case 1:
                    // Leer los datos del gasto desde la interfaz de usuario
                    String[] datosGasto = interfazUsuario.leerGasto();
                    double cantidad = Double.parseDouble(datosGasto[0]);
                    String descripcion = datosGasto[1];
                    int dia = Integer.parseInt(datosGasto[2]);
                    int mes = Integer.parseInt(datosGasto[3]);
                    int año = Integer.parseInt(datosGasto[4]);
                    String categoria = datosGasto[5]; // Agregar la categoría
                    // Agregar el nuevo gasto al gestor de gastos
                    gestorGastos.agregarGasto(new Gasto(cantidad, descripcion, dia, mes, año, categoria));
                    interfazUsuario.mostrarMensaje("Gasto agregado correctamente.");
                    break;

                case 2:
                    // Obtener la lista de gastos del gestor de gastos y mostrarla en la interfaz de usuario
                    List<Gasto> gastos = gestorGastos.obtenerGastos();
                    interfazUsuario.mostrarListaGastos(gastos);
                    break;
                case 3:
                    // Salir del bucle y terminar la aplicación
                    ejecutando = false;
                    break;
                case 4:
                    // Leer el índice del gasto a editar desde la interfaz de usuario
                    int indiceEditar = interfazUsuario.leerIndice();
                    // Leer los nuevos datos del gasto desde la interfaz de usuario
                    String[] datosEditar = interfazUsuario.leerGasto();
                    double cantidadEditar = Double.parseDouble(datosEditar[0]);
                    String descripcionEditar = datosEditar[1];
                    int diaEditar = Integer.parseInt(datosEditar[2]);
                    int mesEditar = Integer.parseInt(datosEditar[3]);
                    int añoEditar = Integer.parseInt(datosEditar[4]);
                    // Editar el gasto en el gestor de gastos
                    gestorGastos.editarGasto(indiceEditar, cantidadEditar, descripcionEditar, diaEditar, mesEditar, añoEditar);
                    interfazUsuario.mostrarMensaje("Gasto editado correctamente.");
                    break;

                case 5:
                    // Leer el índice del gasto a eliminar desde la interfaz de usuario
                    int indiceEliminar = interfazUsuario.leerIndice();
                    // Eliminar el gasto del gestor de gastos
                    gestorGastos.eliminarGasto(indiceEliminar);
                    interfazUsuario.mostrarMensaje("Gasto eliminado correctamente.");
                    break;
                case 6:
                    // Leer el día para filtrar desde la interfaz de usuario
                    int diaFiltrar = interfazUsuario.leerDia();
                    // Obtener y mostrar el total de gastos del día filtrado
                    double totalDia = gestorGastos.obtenerTotalGastosDia(diaFiltrar);
                    interfazUsuario.mostrarMensaje("Total de gastos del día " + diaFiltrar + ": $" + totalDia);
                    break;
                case 7:
                    // Leer el mes para filtrar desde la interfaz de usuario
                    int mesFiltrar = interfazUsuario.leerMes();
                    // Obtener y mostrar el total de gastos del mes filtrado
                    double totalMes = gestorGastos.obtenerTotalGastosMes(mesFiltrar);
                    interfazUsuario.mostrarMensaje("Total de gastos del mes " + mesFiltrar + ": $" + totalMes);
                    break;
                case 8:
                    // Leer el año para filtrar desde la interfaz de usuario
                    int añoFiltrar = interfazUsuario.leerAño();
                    // Obtener y mostrar el total de gastos del año filtrado
                    double totalAño = gestorGastos.obtenerTotalGastosAño(añoFiltrar);
                    interfazUsuario.mostrarMensaje("Total de gastos del año " + añoFiltrar + ": $" + totalAño);
                    break;
                case 9:
                    // Obtener y mostrar el resumen de gastos por categoría
                    List<String> resumenPorCategoria = gestorGastos.obtenerResumenGastosPorCategoria();
                    interfazUsuario.mostrarResumenPorCategoria(resumenPorCategoria);
                    break;
                default:
                    // Mostrar un mensaje de error si la opción ingresada no es válida
                    interfazUsuario.mostrarMensaje("Opción no válida. Inténtelo de nuevo.");
            }
        }
        // Mostrar un mensaje de despedida al usuario al salir de la aplicación
        interfazUsuario.mostrarMensaje("¡Hasta luego!");
    }
}




