package org.utp.lobito.ui.TareaS3;
import java.util.Scanner;

public class Presentar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Crear una instancia de Supervisor
        Supervisor supervisor = new Supervisor("Juan", 1);

        int opcion;
        do {
            // Mostrar el menú de opciones
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Aumentar personas a cargo");
            System.out.println("2. Modificar sueldo");
            System.out.println("3. Modificar jerarquía");
            System.out.println("4. Ver datos");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();

            // Realizar acciones según la opción seleccionada
            switch (opcion) {
                case 1:
                    supervisor.aumentarPersonasACargo();
                    break;
                case 2:
                    System.out.print("Ingrese el nuevo sueldo: ");
                    double nuevoSueldo = scanner.nextDouble();
                    supervisor.modificarSueldo(nuevoSueldo);
                    break;
                case 3:
                    System.out.print("Ingrese la nueva jerarquía: ");
                    int nuevaJerarquia = scanner.nextInt();
                    supervisor.modificarJerarquia(nuevaJerarquia);
                    break;
                case 4:
                    supervisor.verDatos();
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
