package org.utp.lobito.ui.TAREASSEMANALES.TareaSemana6Part1;

public class Pediatra extends Doctor {
    private int horasRealizadas;

    public Pediatra(String nombre, double precioHora) {
        super(nombre, precioHora);
        this.horasRealizadas = 0;
    }

    public void cita(int numeroCitas) {
        this.horasRealizadas += numeroCitas;
    }

    @Override
    public void calcularSueldo() {
        this.sueldo = this.horasRealizadas * this.precioHora;
    }

    @Override
    public void info() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Horas Realizadas: " + horasRealizadas);
        System.out.println("Precio por Hora: $" + precioHora);
        System.out.println("Sueldo: $" + sueldo);
    }
}
