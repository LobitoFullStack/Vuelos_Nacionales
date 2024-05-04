package org.utp.lobito.ui.TAREASSEMANALES.TareaSemana6Part1;

public abstract class Doctor {
    protected String nombre;
    protected double sueldo;
    protected double precioHora;

    public Doctor(String nombre, double precioHora) {
        this.nombre = nombre;
        this.precioHora = precioHora;
        this.sueldo = 0;
    }

    public void setPrecioHora(double precioHora) {
        this.precioHora = precioHora;
    }

    public abstract void calcularSueldo();

    public abstract void info();
}
