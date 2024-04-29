package ar.edu.unju.fi.ejercicio01.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio01.model.Producto;

public class Main {
    private static List<Producto> productos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int opcion;
        do {
            opcion = menu();
            switch(opcion) {
                case 1:
                    productos.add(crearProducto());
                    break;
                case 2:
                    try{
                        mostrarProductos(productos);
                    }catch(Exception e){
                        System.out.println("No hay productos");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el código del producto a modificar: ");
                    String codigo = scanner.nextLine();
                    for (Producto producto : productos) {
                        if (producto.getCodigo().equals(codigo)) {
                            modificarProducto(producto);
                            System.out.println("Producto modificado exitosamente!");
                            break;
                        }else {
                        	System.out.println("Producto no encontrado.");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción Inválida.");
            }
        } while(opcion != 4);
        scanner.close();
    }

    private static int menu() {
        System.out.println("MENU");
        System.out.println("1) Crear Producto");
        System.out.println("2) Mostrar Productos");
        System.out.println("3) Modificar Producto");
        System.out.println("4) Salir");
        System.out.println("Elije una opcion: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }

    private static Producto crearProducto() {
        Producto producto = new Producto();
        System.out.println("Ingrese código: ");
        producto.setCodigo(scanner.nextLine());
        System.out.println("Ingrese descripción: ");
        producto.setDescripcion(scanner.nextLine());
        System.out.println("Ingrese precio unitario: ");
        producto.setPrecioU(scanner.nextDouble());
        scanner.nextLine();
        producto.setOrigenFabricacion(menuFabricacion());
        producto.setCategoria(menuCategoria());
        return producto;
    }

    private static Producto.OrigenFabricacion menuFabricacion() {
        System.out.println("---- Origen de fabricación ------");
        System.out.println("1) Argentina");
        System.out.println("2) China");
        System.out.println("3) Brasil");
        System.out.println("4) Uruguay");
        System.out.println("Elije una opcion: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        switch(opcion) {
            case 1:
                return Producto.OrigenFabricacion.ARGENTINA;
            case 2:
                return Producto.OrigenFabricacion.CHINA;
            case 3:
                return Producto.OrigenFabricacion.BRASIL;
            case 4:
                return Producto.OrigenFabricacion.URUGUAY;
            default:
                System.out.println("Opción Inválida.");
                return null;
        }
    }

    private static Producto.Categoria menuCategoria() {
        System.out.println("---- Categoría ------");
        System.out.println("1) Telefonía");
        System.out.println("2) Informática");
        System.out.println("3) Electrohogar");
        System.out.println("4) Herramientas");
        int opcion = scanner.nextInt();
        System.out.println("Elije una opcion: ");
        scanner.nextLine();
        switch(opcion) {
            case 1:
                return Producto.Categoria.TELEFONIA;
            case 2:
                return Producto.Categoria.INFORMATICA;
            case 3:
                return Producto.Categoria.ELECTROHOGAR;
            case 4:
                return Producto.Categoria.HERRAMIENTAS;
            default:
                System.out.println("Opción Inválida.");
                return null;
        }
    }

    private static void mostrarProductos (List<Producto> productos) throws Exception {
    	if(productos.isEmpty())
	    	throw new Exception("No hay productos");
	    	for (Producto producto: productos) {
	    		System.out.println(producto.toString());
	    	}
    	}
    
    private static void modificarProducto(Producto producto) {
        System.out.print("Ingrese la nueva descripción: ");
        producto.setDescripcion(scanner.nextLine());
        System.out.print("Ingrese el nuevo precio unitario: ");
        producto.setPrecioU(scanner.nextDouble());
        scanner.nextLine();
        producto.setOrigenFabricacion(menuFabricacion());
        producto.setCategoria(menuCategoria());
    }
}