package org.utp.lobito.ui.TAREASSEMANALES.Tarea1S4;

public class Gato extends Mascota {
    private boolean areneroLimpio;
    private int porcentajeUsoArenero;

    public Gato(String fechaNacimiento, String fechaAdopcion, String nombre, String raza, String tipo) {
        super(fechaNacimiento,fechaAdopcion, nombre, raza, tipo);
        this.areneroLimpio = false;
        this.porcentajeUsoArenero = 0;
    }

    public void limpiarArenero(boolean limpio, int porcentajeUso) {
        this.areneroLimpio = limpio;
        this.porcentajeUsoArenero = porcentajeUso;
    }

    public boolean isAreneroLimpio() {
        return areneroLimpio;
    }

    public void setAreneroLimpio(boolean areneroLimpio) {
        this.areneroLimpio = areneroLimpio;
    }

    public int getPorcentajeUsoArenero() {
        return porcentajeUsoArenero;
    }

    public void setPorcentajeUsoArenero(int porcentajeUsoArenero) {
        this.porcentajeUsoArenero = porcentajeUsoArenero;
    }
}