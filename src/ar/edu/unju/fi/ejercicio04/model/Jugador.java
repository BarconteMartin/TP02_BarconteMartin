package ar.edu.unju.fi.ejercicio04.model;

import java.time.LocalDate;
import java.time.Period;

import ar.edu.unju.fi.ejercicio04.constantes.Posicion;

public class Jugador {
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String nacionalidad;
    private double estatura;
    private double peso;
    private Posicion posicion;
    
    public Jugador() {
    }

    public Jugador(String nombre, String apellido, LocalDate fechaNacimiento, String nacionalidad, double estatura, double peso, Posicion posicion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.estatura = estatura;
        this.peso = peso;
        this.posicion = posicion;
    }

    public int calcularEdad() {
        return Period.between(this.fechaNacimiento, LocalDate.now()).getYears();
    }

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public double getEstatura() {
		return estatura;
	}

	public double getPeso() {
		return peso;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
	@Override
	public String toString() {
	    String ficha = "Nombre: " + this.nombre + "\n"
	            + "Apellido: " + this.apellido + "\n"
	            + "Fecha de Nacimiento: " + this.fechaNacimiento + "\n"
	            + "Edad: " + calcularEdad() + " años" + "\n"
	            + "Nacionalidad: " + this.nacionalidad + "\n"
	            + "Estatura: " + String.format("%.2f", this.estatura) + " m" + "\n"
	            + "Peso: " + this.peso + " kg" + "\n"
	            + "Posición: " + this.posicion + "\n";
	    return ficha;
	}


}
