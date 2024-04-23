package org.utp.lobito.ui.TAREASSEMANALES.TareaS3;

public class Supervisor {
    private String nombre;
    private int personasACargo;
    private double sueldo;
    private int jerarquia;


    public Supervisor(String nombre, int jerarquia) {
        this.nombre = nombre;
        this.jerarquia = jerarquia;
        this.personasACargo = 2; // Todos inician con 2 personas a cargo
        this.sueldo = 3500; // Todos inician con un sueldo de 3500
    }


    public void aumentarPersonasACargo() {
        if (personasACargo < 10) { // Aqui indico que no se puede ser mayor de 10 personas
            personasACargo++;
            System.out.println("Se ha aumentado una persona a cargo. Ahora tiene " + personasACargo + " personas a cargo.");
        } else {
            System.out.println("No se pueden agregar más personas a cargo, ya tiene el máximo (10).");
        }
    }

    // Método para modificar sueldo
    public void modificarSueldo(double nuevoSueldo) {
        if (nuevoSueldo > sueldo) { // El nuevo sueldo debe ser mayor al anterior
            sueldo = nuevoSueldo;
            System.out.println("El sueldo ha sido modificado correctamente. Nuevo sueldo: " + sueldo);
        } else {
            System.out.println("El nuevo sueldo debe ser mayor al anterior.");
        }
    }

    // Método para ver datos
    public void verDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Jerarquía: " + jerarquia);
        System.out.println("Personas a cargo: " + personasACargo);
        System.out.println("Sueldo: " + sueldo);
    }

    public void modificarJerarquia(int nuevaJerarquia) {
        if (nuevaJerarquia >= 1 && nuevaJerarquia <= 3) { // Validar que la nueva jerarquía esté dentro del rango permitido
            jerarquia = nuevaJerarquia;
            System.out.println("La jerarquía ha sido modificada correctamente. Nueva jerarquía: " + jerarquia);
        } else {
            System.out.println("La jerarquía debe ser 1, 2 o 3.");
        }
    }


}
