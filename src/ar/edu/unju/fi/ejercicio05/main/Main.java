package ar.edu.unju.fi.ejercicio05.main;

import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio05.interfaces.Pago;
import ar.edu.unju.fi.ejercicio05.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio05.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio05.model.Producto;

public class Main {
    private static ArrayList<Producto> productos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            productos.add(new Producto("Producto " + (i+1), (i+1) * 100, i % 2 == 0));
        }

        int opcion = 0;
        do {
            System.out.println("\n1 – Mostrar productos");
            System.out.println("2 – Realizar compra");
            System.out.println("3 – Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mostrarProductos();
                    break;
                case 2:
                    realizarCompra();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        } while (opcion != 3);
    }

    private static void mostrarProductos() {
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

    private static void realizarCompra() {
        ArrayList<Producto> seleccionados = new ArrayList<>();
        System.out.println("Seleccione productos a comprar (ingrese 0 para terminar):");
        mostrarProductos();
        int productoId;
        double total = 0;
        do {
            productoId = scanner.nextInt();
            if (productoId > 0 && productoId <= productos.size()) {
                Producto producto = productos.get(productoId - 1);
                if (producto.isEstado()) {
                    seleccionados.add(producto);
                    total += producto.getPrecio();
                } else {
                    System.out.println("Producto no disponible.");
                }
            }
        } while (productoId != 0);

        System.out.println("Seleccione método de pago:");
        System.out.println("1 – Pago efectivo");
        System.out.println("2 – Pago con tarjeta");
        int pagoOpcion = scanner.nextInt();
        Pago pago;
        if (pagoOpcion == 1) {
            pago = new PagoEfectivo();
        } else {
            System.out.print("Ingrese número de tarjeta: ");
            String numTarjeta = scanner.next();
            pago = new PagoTarjeta(numTarjeta);
        }
        pago.realizarPago(total);
        pago.imprimirRecibo();
    }
}
