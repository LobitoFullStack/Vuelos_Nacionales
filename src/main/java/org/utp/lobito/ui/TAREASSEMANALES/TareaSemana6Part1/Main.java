package org.utp.lobito.ui.TAREASSEMANALES.TareaSemana6Part1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Pediatra pediatra = new Pediatra("Dr. Lopez", 50.0); // Iniciar de esta manera o
        System.out.print("Ingrese el nombre del pediatra: ");
        String nombrePediatra = scanner.nextLine();

        System.out.print("Ingrese el precio inicial por hora para " + nombrePediatra + ": ");
        double precioInicial = scanner.nextDouble();

        // Crear la instancia del pediatra con los datos ingresados
        Pediatra pediatra = new Pediatra(nombrePediatra, precioInicial);
        while (true) {
            System.out.println("\n1| Precio por hora");
            System.out.println("2| Cita");
            System.out.println("3| Sueldo");
            System.out.println("4| Info");
            System.out.println("5| Salir");
            System.out.print("Elija una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nuevo precio por hora: ");
                    double nuevoPrecio = scanner.nextDouble();
                    pediatra.setPrecioHora(nuevoPrecio);
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad de citas: ");
                    int citas = scanner.nextInt();
                    pediatra.cita(citas);
                    break;
                case 3:
                    pediatra.calcularSueldo();
                    System.out.println("Sueldo actualizado.");
                    break;
                case 4:
                    pediatra.info();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        }
    }
}
