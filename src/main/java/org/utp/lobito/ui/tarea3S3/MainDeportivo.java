package org.utp.lobito.ui.tarea3S3;

public class MainDeportivo {

    public static void main(String[] args) {

        ComplejoDeportivo complejo = new ComplejoDeportivo("Fútbol 7", "Losa", "8:00 - 10:00");
        complejo.verDatos(); // Mostrar datos antes de reservar
        complejo.reservar(); // Reservar el complejo
        complejo.verDatos(); // Mostrar datos después de reservar
    }

}
