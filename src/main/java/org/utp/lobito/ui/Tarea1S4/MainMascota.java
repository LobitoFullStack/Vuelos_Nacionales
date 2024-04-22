package org.utp.lobito.ui.Tarea1S4;
import java.util.Scanner;

public class MainMascota {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Clase Padre mascota ");
            System.out.println("2. Para perro ");
            System.out.println("3. Para gato ");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea después de leer el entero

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese la fecha de nacimiento de la mascota (dd/mm/yyyy): ");
                    String fechaNacimientoMascota = scanner.nextLine();

                    System.out.println("Ingrese el nombre de la mascota: ");
                    String nombreMascota = scanner.nextLine();

                    System.out.println("Ingrese la raza de la mascota: ");
                    String razaMascota = scanner.nextLine();

                    System.out.println("Ingrese el tipo de mascota: ");
                    String tipoMascota = scanner.nextLine();

                    System.out.println("Ingrese la fecha de adopción de la mascota (dd/mm/yyyy): ");
                    String fechaAdopcion = scanner.nextLine();

                    Mascota mascota = new Mascota(fechaNacimientoMascota, nombreMascota, razaMascota, tipoMascota, fechaAdopcion);
                    break;

                case 2:
                    System.out.println("Ingrese la fecha de nacimiento del perro (dd/mm/yyyy): ");
                    String fechaNacimientoPerro = scanner.nextLine();

                    System.out.println("Ingrese el nombre del perro: ");
                    String nombrePerro = scanner.nextLine();

                    System.out.println("Ingrese la raza del perro: ");
                    String razaPerro = scanner.nextLine();

                    System.out.println("Ingrese el tipo de mascota: ");
                    String tipoPerro = scanner.nextLine();

                    System.out.println("Ingrese la fecha de adopción del perro (dd/mm/yyyy): ");
                    String fechaAdopcionPerro = scanner.nextLine();

                    Perro perro = new Perro(fechaNacimientoPerro, nombrePerro, razaPerro, tipoPerro, fechaAdopcionPerro);

                    System.out.println("¿Cuántos kilómetros recorrió el perro en el paseo diario?");
                    int km = scanner.nextInt();
                    perro.paseoDiario(km);
                    break;

                case 3:
                    System.out.println("Ingrese la fecha de nacimiento del gato (dd/mm/yyyy): ");
                    String fechaNacimientoGato = scanner.nextLine();

                    System.out.println("Ingrese el nombre del gato: ");
                    String nombreGato = scanner.nextLine();

                    System.out.println("Ingrese la raza del gato: ");
                    String razaGato = scanner.nextLine();

                    System.out.println("Ingrese el tipo de mascota: ");
                    String tipoGato = scanner.nextLine();

                    System.out.println("Ingrese la fecha de adopción del gato (dd/mm/yyyy): ");
                    String fechaAdopcionGato = scanner.nextLine();

                    Gato gato = new Gato(fechaNacimientoGato, nombreGato, razaGato, tipoGato, fechaAdopcionGato);

                    System.out.println("¿El arenero está limpio? (true/false): ");
                    boolean areneroLimpio = scanner.nextBoolean();

                    System.out.println("¿En qué porcentaje de uso se encuentra el arenero?");
                    int porcentajeUso = scanner.nextInt();
                    gato.limpiarArenero(areneroLimpio, porcentajeUso);
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
