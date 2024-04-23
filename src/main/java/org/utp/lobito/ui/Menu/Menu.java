package org.utp.lobito.ui.Menu;

public class Menu {
    public static void mostrarMenu(String rolTrabajador) {
        if ("Jefe".equals(rolTrabajador)) {
            mostrarMenuJefe();
        } else if ("Empleado".equals(rolTrabajador)) {
            mostrarMenuOperario();
        } else {
            System.out.println("Rol de trabajador no reconocido.");
        }
    }

    private static void mostrarMenuJefe() {
        System.out.println("Menú para Jefe:");
        System.out.println("1. Reservas de vuelos");
        System.out.println("2. Registrar usuarios");
        System.out.println("3. Editar usuario");
        System.out.println("4. Eliminar usuario");
    }

    private static void mostrarMenuOperario() {
        System.out.println("Menú para Operario:");
        System.out.println("1. Reservas de vuelos");
    }
}
