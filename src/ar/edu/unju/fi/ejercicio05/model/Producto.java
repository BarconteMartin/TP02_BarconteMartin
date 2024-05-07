package ar.edu.unju.fi.ejercicio05.model;

public class Producto {
    private String nombre;
    private double precio;
    private boolean estado; // true para disponible, false para no stock

    public Producto(String nombre, double precio, boolean estado) {
        this.nombre = nombre;
        this.precio = precio;
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return "Producto: " + nombre + ", Precio: " + precio + ", Disponible: " + (estado ? "Sí" : "No");
    }

    public String getNombre() {
		return nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}
