package ar.edu.unju.fi.ejercicio07.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio07.model.Producto;

public class Main {
    private static List<Producto> productos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        precargarProductos();
        
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpia el buffer del scanner
            switch (opcion) {
                case 1:
                    mostrarProductosPorEstado(true);
                    break;
                case 2:
                    mostrarProductosPorEstado(false);
                    break;
                case 3:
                    incrementarPrecios(20);
                    break;
                case 4:
                    mostrarProductosPorCategoria("Electrohogar");
                    break;
                case 5:
                    ordenarProductosPorPrecioDesc();
                    break;
                case 6:
                    convertirNombresAMayusculas();
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida, intente nuevamente.");
            }
        } while (opcion != 7);
        
        scanner.close();
    }

    private static void precargarProductos() {
        String[] categorias = {"Electrohogar", "Electrónica", "Ropa", "Jardinería", "Alimentos"};
        for (int i = 0; i < 15; i++) {
            String categoria = categorias[i % categorias.length];
            productos.add(new Producto(i, "Producto" + i, 100 + i * 10, categoria, i % 2 == 0));
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n1 - Mostrar productos disponibles");
        System.out.println("2 - Mostrar los productos faltantes");
        System.out.println("3 - Incrementar los precios de los productos en un 20%");
        System.out.println("4 - Mostrar los productos de Electrohogar disponibles");
        System.out.println("5 - Ordenar productos por precio descendente");
        System.out.println("6 - Mostrar los nombres de productos en mayúsculas");
        System.out.println("7 - Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void mostrarProductosPorEstado(boolean estado) {
        productos.stream()
                 .filter(p -> p.isEstado() == estado)
                 .forEach(System.out::println);
    }

    private static void incrementarPrecios(double porcentaje) {
        productos.forEach(p -> p.setPrecio(p.getPrecio() * (1 + porcentaje / 100)));
    }

    private static void mostrarProductosPorCategoria(String categoria) {
        productos.stream()
                 .filter(p -> p.getCategoria().equals(categoria) && p.isEstado())
                 .forEach(System.out::println);
    }

    private static void ordenarProductosPorPrecioDesc() {
        productos.sort(Comparator.comparing(Producto::getPrecio).reversed());
        productos.forEach(System.out::println);
    }

    private static void convertirNombresAMayusculas() {
        productos.stream()
                 .map(p -> p.getNombre().toUpperCase())
                 .forEach(System.out::println);
    }
}
