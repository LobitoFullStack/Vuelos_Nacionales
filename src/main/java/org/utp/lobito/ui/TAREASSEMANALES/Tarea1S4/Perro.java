package org.utp.lobito.ui.TAREASSEMANALES.Tarea1S4;

public class Perro extends Mascota {
    private int kmRecorridos;
    private int cantidadPaseos;

    public Perro(String fechaNacimiento, String nombre, String raza, String tipo, String fechaAdopcion) {
        super(fechaNacimiento, nombre, raza, tipo, fechaAdopcion);
        this.kmRecorridos = 0;
        this.cantidadPaseos = 0;
    }

    public int getKmRecorridos() {
        return kmRecorridos;
    }

    public void setKmRecorridos(int kmRecorridos) {
        this.kmRecorridos = kmRecorridos;
    }

    public int getCantidadPaseos() {
        return cantidadPaseos;
    }

    public void paseoDiario(int km) {
        this.kmRecorridos += km;
        this.cantidadPaseos++;
    }
}