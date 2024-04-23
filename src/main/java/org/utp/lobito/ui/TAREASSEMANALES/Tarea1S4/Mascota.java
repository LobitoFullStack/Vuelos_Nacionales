package org.utp.lobito.ui.TAREASSEMANALES.Tarea1S4;

public class Mascota {
    private String fechaNacimiento;
    private String nombre;
    private String raza;
    private String tipo;
    private String fechaAdopcion;

    public Mascota(String fechaNacimiento, String nombre, String raza, String tipo, String fechaAdopcion) {
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
        this.raza = raza;
        this.tipo = tipo;
        this.fechaAdopcion = fechaAdopcion;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFechaAdopcion() {
        return fechaAdopcion;
    }

    public void setFechaAdopcion(String fechaAdopcion) {
        this.fechaAdopcion = fechaAdopcion;
    }
}