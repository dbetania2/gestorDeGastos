package modelo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.ArrayList;
import java.util.List;

public class GestorGastos {
    private List<Gasto> listaGastos;

    // Constructor
    public GestorGastos() {
        this.listaGastos = new ArrayList<>();
    }

    // Método para agregar un gasto a la lista
    public void agregarGasto(Gasto gasto) {
        listaGastos.add(gasto);
    }

    // Método para obtener la lista de gastos
    public List<Gasto> obtenerGastos() {
        return listaGastos;
    }

    // Método para obtener el total de gastos de un día específico
    public double obtenerTotalGastosDia(int dia) {
        double total = 0;
        for (Gasto gasto : listaGastos) {
            if (gasto.getDia() == dia) {
                total += gasto.getCantidad();
            }
        }
        return total;
    }

    // Método para obtener el total de gastos de un mes específico
    public double obtenerTotalGastosMes(int mes) {
        double total = 0;
        for (Gasto gasto : listaGastos) {
            if (gasto.getMes() == mes) {
                total += gasto.getCantidad();
            }
        }
        return total;
    }

    // Método para obtener el total de gastos de un año específico
    public double obtenerTotalGastosAño(int año) {
        double total = 0;
        for (Gasto gasto : listaGastos) {
            if (gasto.getAño() == año) {
                total += gasto.getCantidad();
            }
        }
        return total;
    }

    // Método para editar un gasto en la lista
    public void editarGasto(int indice, double cantidad, String descripcion, int dia, int mes, int año) {
        Gasto gasto = listaGastos.get(indice);
        gasto.setCantidad(cantidad);
        gasto.setDescripcion(descripcion);
        gasto.setDia(dia);
        gasto.setMes(mes);
        gasto.setAño(año);
    }

    // Método para eliminar un gasto de la lista
    public void eliminarGasto(int indice) {
        listaGastos.remove(indice);
    }

    // Método para obtener el resumen de gastos por categoría
    public List<String> obtenerResumenGastosPorCategoria() {
        // Mapa para almacenar el total de gastos por categoría
        Map<String, Double> resumenPorCategoria = new HashMap<>();

        // Calcular el total de gastos por categoría
        for (Gasto gasto : listaGastos) {
            String categoria = gasto.getCategoria();
            double cantidad = gasto.getCantidad();
            resumenPorCategoria.put(categoria, resumenPorCategoria.getOrDefault(categoria, 0.0) + cantidad);
        }

        // Crear una lista de cadenas para almacenar el resumen
        List<String> resumen = new ArrayList<>();

        // Agregar los resultados al resumen
        for (Map.Entry<String, Double> entry : resumenPorCategoria.entrySet()) {
            String categoria = entry.getKey();
            double total = entry.getValue();
            resumen.add(categoria + ": $" + total);
        }

        return resumen;
    }
}


