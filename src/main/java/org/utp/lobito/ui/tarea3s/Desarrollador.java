package org.utp.lobito.ui.tarea3s;

class Desarrollador {
    private int horasDesarrollo;
    private int horasPruebas;
    private double precioHora;

    public Desarrollador(double precioHora) {
        this.horasDesarrollo = 0;
        this.horasPruebas = 0;
        this.precioHora = precioHora;
    }

    public void asignarRequerimiento(int horas) {
        if (horasDesarrollo == 0) {
            this.horasDesarrollo = horas;
            this.horasPruebas = horas / 4; // Por cada 4 horas de desarrollo, una de prueba
            System.out.println("Requerimiento asignado correctamente.");
        } else {
            System.out.println("Ya hay horas de desarrollo asignadas. Termina el desarrollo actual primero.");
        }
    }

    public void terminarDesarrollo() {
        if (horasDesarrollo > 0) {
            double costoTotal = (horasDesarrollo + horasPruebas) * precioHora;
            System.out.println("Horas de desarrollo: " + horasDesarrollo);
            System.out.println("Horas de pruebas: " + horasPruebas);
            System.out.println("Costo total: S/ " + costoTotal);
            reiniciar();
        } else {
            System.out.println("No hay horas de desarrollo asignadas.");
        }
    }

    public void verDatos() {
        System.out.println("Horas de desarrollo: " + horasDesarrollo);
        System.out.println("Horas de pruebas: " + horasPruebas);
    }

    private void reiniciar() {
        horasDesarrollo = 0;
        horasPruebas = 0;
    }
}