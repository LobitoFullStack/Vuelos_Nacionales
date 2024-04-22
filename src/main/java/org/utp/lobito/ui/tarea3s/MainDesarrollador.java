package org.utp.lobito.ui.tarea3s;

import java.util.Scanner;

public class MainDesarrollador {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Desarrollador desarrollador = new Desarrollador(50.00); // Precio por hora

        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Asignar requerimiento");
            System.out.println("2. Terminar desarrollo");
            System.out.println("3. Ver datos");
            System.out.println("4. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese cantidad de horas de desarrollo: ");
                    int horas = scanner.nextInt();
                    desarrollador.asignarRequerimiento(horas);
                    break;
                case 2:
                    desarrollador.terminarDesarrollo();
                    break;
                case 3:
                    desarrollador.verDatos();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 4);
    }
}