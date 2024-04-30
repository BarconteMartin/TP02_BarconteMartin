package ar.edu.unju.fi.ejercicio04.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio04.constantes.Posicion;
import ar.edu.unju.fi.ejercicio04.model.Jugador;

public class Main {
    private static ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;
        do {
            System.out.println("-------------------Menu------------------");
            System.out.println("1) Alta de jugador");
            System.out.println("2) Mostrar Datos del jugador");
            System.out.println("3) Modificar la posición de un jugador");
            System.out.println("4) Eliminar un jugador");
            System.out.println("5) Salir");
            System.out.println("Elija una opcion: ");

            opcion = scanner.nextInt();
            switch (opcion) {
            	case 1:
	                Jugador nuevoJugador = new Jugador(); 
	                jugadores.add(altaJugador(nuevoJugador));
	                break;
                case 2:
                    try {
                        mostrarDatosJugadores(jugadores);
                    } catch (Exception e) {
                        System.out.println("No hay jugadores registrados");
                    }
                    break;
                case 3:
                	modificarPosicion(jugadores);
                    break;
                case 4:
                    eliminarJugador(jugadores);
                    break;
                case 5:
                	System.out.println("Saliendo del programa....");
                	break;
                default:
                	System.out.println("Fuera de Rango - Ingrese un numero valido");
                	break;
            }

        } while (opcion != 5);
        scanner.close();
    }

    private static Jugador altaJugador(Jugador jugador) {
        Boolean band = false;

        System.out.println("---- Ingrese los datos del  jugador ----");

        System.out.print("Nombre: ");
        jugador.setNombre(scanner.next());

        System.out.print("Apellido: ");
        jugador.setApellido(scanner.next());

        System.out.print("Fecha de Nacimiento (yyyy-MM-dd): ");
        do {
            String Fecha = scanner.next();
            try {
                LocalDate FechaNac = LocalDate.parse(Fecha);
                jugador.setFechaNacimiento(FechaNac);
                band = true;
            } catch (Exception e) {
                System.out.println("La fecha ingresada es inválida - Comprueba el formato");
                System.out.println("Reingrese una fecha valida: ");
            }
        } while (!band);
        band = false;

        System.out.print("Nacionalidad: ");
        jugador.setNacionalidad(scanner.next());

        System.out.print("Estatura (metros con ,): ");
        jugador.setEstatura(scanner.nextFloat());

        System.out.print("Peso (kg con ,): ");
        jugador.setPeso(scanner.nextFloat());

        System.out.println("Ingrese la nueva posición (1=DELANTERO, 2=MEDIO, 3=DEFENSA, 4=ARQUERO): ");
        int pos = scanner.nextInt();
        if (pos >= 1 && pos <= 4) {
            jugador.setPosicion(Posicion.values()[pos - 1]);
            band = true;
        } else {
            System.out.println("Fuera de rango");
        }

        return jugador;
    }

    public static void mostrarDatosJugadores(ArrayList<Jugador> jugadores) throws Exception {
        if (jugadores.isEmpty()) {
            throw new Exception("No hay jugadores registrados");
        }
        for (Jugador jugador : jugadores) {
            System.out.println(jugador.toString());
        }
    }

    public static void modificarPosicion(ArrayList<Jugador> jugadores) {
        try {
            System.out.println("Ingrese el nombre:");
            String nombre = scanner.next();
            System.out.println("Ingrese el apellido:");
            String apellido = scanner.next();
            
            boolean encontrado = false;
            for (Jugador jugador : jugadores) {
                if (jugador.getNombre().equals(nombre) && jugador.getApellido().equals(apellido)) {
                    encontrado = true;
                    System.out.println("Ingrese la nueva posición (1=DELANTERO, 2=MEDIO, 3=DEFENSA, 4=ARQUERO): ");
                    int pos = scanner.nextInt();
                    if (pos >= 1 && pos <= 4) {
                        jugador.setPosicion(Posicion.values()[pos - 1]);
                        System.out.println("Posición modificada correctamente.");
                    } else {
                        System.out.println("Fuera de rango");
                    }
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("El jugador no existe.");
            }
        } catch (Exception e) {
            System.out.println("Error en el ingreso de datos");
        }
    }

    public static void eliminarJugador(ArrayList<Jugador> jugadores) {
        System.out.print("Ingrese el nombre del jugador: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el apellido del jugador: ");
        String apellido = scanner.next();
        Iterator<Jugador> iterator = jugadores.iterator();
        boolean jugadorEncontrado = false;
        while (iterator.hasNext()) {
            Jugador jugadorActual = iterator.next();
            if (jugadorActual.getNombre().equals(nombre) && jugadorActual.getApellido().equals(apellido)) {
                iterator.remove();
                jugadorEncontrado = true;
                System.out.println("Jugador eliminado.");
                break;
            }
        }
        if (!jugadorEncontrado) {
            System.out.println("No se encontró el jugador.");
        }
    }

}
