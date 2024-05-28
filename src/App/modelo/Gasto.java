package App.modelo;

public class Gasto {
    private double cantidad;
    private String descripcion;
    private int dia;
    private int mes;
    private int año;
    private String categoria;

    // Constructor predeterminado necesario para la deserialización
    public Gasto() {
    }

    public Gasto(double cantidad, String descripcion, int dia, int mes, int año, String categoria) {
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.dia = dia;
        this.mes = mes;
        this.año = año;
        this.categoria = categoria;
    }

    public double getCantidad() {
        return cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAño() {
        return año;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}





