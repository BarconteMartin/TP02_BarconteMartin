package ar.edu.unju.fi.ejercicio02.model;

import ar.edu.unju.fi.ejercicio02.constantes.Mes;

public class Efemeride {
	
	private String codigo;
	private Mes mes;
	private int dia;
	private String detalle;
	
	public Efemeride() {

	}

	public Efemeride(String codigo, Mes mes, int dia, String detalle) {
		this.codigo = codigo;
		this.mes = mes;
		this.dia = dia;
		this.detalle = detalle;
	}

	public String getCodigo() {
		return codigo;
	}

	public Mes getMes() {
		return mes;
	}

	public int getDia() {
		return dia;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setMes(Mes mes) {
		this.mes = mes;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	@Override
	public String toString() {
		return "Efemeride [codigo=" + codigo + ", mes=" + mes + ", dia=" + dia + ", detalle=" + detalle + "]";
	}
	

}