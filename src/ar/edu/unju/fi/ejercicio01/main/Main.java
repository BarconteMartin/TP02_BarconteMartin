package ar.edu.unju.fi.ejercicio01.main;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.ejercicio01.model.Producto;
import ar.edu.unju.fi.ejercicio01.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio01.model.Producto.OrigenFabricacion;

public class Main {

	public static void main(String[] args) {
		List<Producto> listado = new ArrayList<Producto>();
		
		Producto prod01 = new Producto("p01","caracteristica p01",23, OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR);
		
		Producto prod02 = new Producto();
		prod02.setCodigo("p02");
		prod02.setDescripcion("descripcion p02");
		prod02.setPrecioU(334);
		prod02.setOrigenFabricacion(OrigenFabricacion.BRASIL);
		prod02.setCategoria(Categoria.HERRAMIENTAS);
		
		Producto prod03 = new Producto();
		prod02.setCodigo("p03");
		prod02.setDescripcion("descripcion p03");
		prod02.setPrecioU(33);
		prod02.setOrigenFabricacion(OrigenFabricacion.CHINA);
		prod02.setCategoria(Categoria.INFORMATICA);
		
		listado.add(prod01);
		listado.add(prod02);	
		listado.add(prod03);
		
		System.out.println(listado);
	}

}