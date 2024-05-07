package ar.edu.unju.fi.ejercicio07.model;

public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private String categoria;
    private boolean estado;

    public Producto(int id, String nombre, double precio, String categoria, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return String.format("Producto {id=%d, nombre='%s', precio=%.2f, categoria='%s', estado=%s}", 
                             id, nombre, precio, categoria, estado ? "Disponible" : "No disponible");
    }
}
