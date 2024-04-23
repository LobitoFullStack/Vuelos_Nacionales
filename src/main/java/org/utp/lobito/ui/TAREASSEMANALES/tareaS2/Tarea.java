package org.utp.lobito.ui.TAREASSEMANALES.tareaS2;

import java.util.Random;
import java.util.Scanner;

public class Tarea {
    private static final int ARRAY_SIZE = 10;
    private static int[] values = new int[ARRAY_SIZE];
    private static boolean loaded = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Cargar valores");
            System.out.println("2. Mostrar valores");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    cargarValores(scanner);
                    break;
                case 2:
                    mostrarValores();
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (option != 3);

        scanner.close();
    }

    private static void cargarValores(Scanner scanner) {
        if (!loaded) {
            System.out.print("Ingrese su nombre: ");
            String nombre = scanner.next();
            System.out.print("¿Desea cargar valores aleatorios? (s/n): ");
            String respuesta = scanner.next();

            if (respuesta.equalsIgnoreCase("s")) {
                Random random = new Random();
                for (int i = 0; i < ARRAY_SIZE; i++) {
                    values[i] = random.nextInt(100); // Valores aleatorios entre 0 y 99
                }
                loaded = true;
                System.out.println("Valores cargados exitosamente.");
            } else {
                System.out.println("No se cargaron valores.");
            }
        } else {
            System.out.println("Los valores ya han sido cargados previamente.");
        }
    }

    private static void mostrarValores() {
        if (loaded) {
            System.out.println("Valores:");
            for (int value : values) {
                System.out.print(value + " ");
            }
            System.out.println();
        } else {
            System.out.println("No hay valores para mostrar. Por favor, cargue valores primero.");
        }
    }
}
