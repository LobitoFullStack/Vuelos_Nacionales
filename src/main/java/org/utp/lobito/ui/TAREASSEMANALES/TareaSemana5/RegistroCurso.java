package org.utp.lobito.ui.TAREASSEMANALES.TareaSemana5;

import java.util.Scanner;

public class RegistroCurso {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Declaración de variables
        String[] nombres = new String[7];
        int[] edades = new int[7];
        char[] sexos = new char[7];
        double[] promedios = new double[7];
        int contador = 0;

        // Registro de alumnos
        while (contador < 7) {
            System.out.println("Ingrese el nombre del estudiante:");
            nombres[contador] = scanner.nextLine();

            System.out.println("Ingrese la edad del estudiante:");
            edades[contador] = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            System.out.println("Ingrese el sexo del estudiante (M/F):");
            sexos[contador] = scanner.nextLine().charAt(0);

            System.out.println("Ingrese el promedio ponderado del estudiante:");
            promedios[contador] = scanner.nextDouble();
            scanner.nextLine(); // Consumir el salto de línea

            // Verificar si el estudiante puede inscribirse
            if (promedios[contador] < 14) {
                System.out.println("Lo siento, el promedio ponderado es menor a 14. No puede inscribirse al curso.");
            } else {
                System.out.println("¡Estudiante registrado correctamente!");
                contador++;
            }

            System.out.println("¿Desea registrar otro estudiante? (S/N)");
            char opcion = scanner.nextLine().charAt(0);

            if (opcion != 'S' && opcion != 's') {
                break;
            }
        }

        // Mostrar la lista de alumnos registrados
        System.out.println("\nLista de alumnos registrados:");
        for (int i = 0; i < contador; i++) {
            System.out.println("Nombre: " + nombres[i]);
            System.out.println("Edad: " + edades[i]);
            System.out.println("Sexo: " + sexos[i]);
            System.out.println("Promedio ponderado: " + promedios[i]);
            System.out.println();
        }

        scanner.close();
    }
}