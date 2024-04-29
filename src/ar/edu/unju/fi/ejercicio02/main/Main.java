package ar.edu.unju.fi.ejercicio02.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio02.constantes.Mes;
import ar.edu.unju.fi.ejercicio02.model.Efemeride;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Efemeride> efemerides = new ArrayList<>();
        int opcion;
        do {
            System.out.println("----------Menu----------");
            System.out.println("1) Crear efeméride");
            System.out.println("2) Mostrar efemérides");
            System.out.println("3) Modificar efeméride");
            System.out.println("4) Eliminar efeméride");
            System.out.println("5) Salir");
            System.out.println("Elija una opción: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    efemerides.add(crearEfemeride());
                    break;
                case 2:
                	try{
                		mostrarEfemerides(efemerides);
                    }catch(Exception e){
                        System.out.println("No hay efemérides");
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el código de la efeméride a modificar:");
                    String codigo = scanner.next();
                    boolean encontrado = false;
                    for (Efemeride efemeride : efemerides) {
                        if (efemeride.getCodigo().equals(codigo)) {
                            modificarEfemeride(efemeride);
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("No se encontró una efeméride con ese código.");
                    }
                    break;

                case 4:
                    eliminarEfemeride(efemerides);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (opcion != 5);

        scanner.close();
    }

    private static Efemeride crearEfemeride() {
        Efemeride efemeride = new Efemeride();

        System.out.println("Ingrese el código de la efeméride:");
        efemeride.setCodigo(scanner.next());
        
        efemeride.setMes(ingresarMes());
        
        System.out.println("Ingrese el día:");
        efemeride.setDia(scanner.nextInt());
        scanner.nextLine();
        
        System.out.println("Ingrese el detalle de la efeméride:");
        efemeride.setDetalle(scanner.nextLine());
        
        return efemeride;
    }

    private static void mostrarEfemerides(List<Efemeride> efemerides) {
        if(efemerides.isEmpty()) {
            throw new RuntimeException("No hay efemérides");
        }
        for (Efemeride efemeride : efemerides) {
            System.out.println(efemeride);
        }
    }

    private static void modificarEfemeride(Efemeride efemeride) {
        System.out.println("Modificando la efeméride: " + efemeride);
        System.out.println("Ingrese el nuevo día (actual: " + efemeride.getDia() + "):");
        efemeride.setDia(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Ingrese el nuevo detalle:");
        efemeride.setDetalle(scanner.nextLine());
        efemeride.setMes(ingresarMes());
        System.out.println("Efeméride modificada exitosamente.");
    }

    private static void eliminarEfemeride(List<Efemeride> efemerides) {
        System.out.println("Ingrese el código de la efeméride a eliminar:");
        String codigo = scanner.next();
        Efemeride toRemove = null;
        for (Efemeride efemeride : efemerides) {
            if (efemeride.getCodigo().equals(codigo)) {
                toRemove = efemeride;
                break;
            }
        }
        if (toRemove != null) {
            efemerides.remove(toRemove);
            System.out.println("Efeméride eliminada exitosamente.");
        } else {
            System.out.println("No se encontró una efeméride con ese código.");
        }
    }

    private static Mes ingresarMes() {
        int mes;
        do {
            System.out.println("Ingrese el número del mes (1 - 12):");
            mes = scanner.nextInt();
            if (mes < 1 || mes > 12) {
                System.out.println("Mes inválido. Ingrese un número entre 1 - 12");
            }
        } while (mes < 1 || mes > 12);

        return Mes.values()[mes - 1];
    }

}


