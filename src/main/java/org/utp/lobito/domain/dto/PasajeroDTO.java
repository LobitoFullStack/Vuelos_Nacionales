package org.utp.lobito.domain.dto;

public class PasajeroDTO {
    private int idPasajero;
    private int idReserva;
    private String nombre;
    private String apellido;
    private int edad;
    private char sexo;

    // Constructor sin parámetros
    public PasajeroDTO() {
    }

    // Constructor con parámetros
    public PasajeroDTO(int idPasajero, int idReserva, String nombre, String apellido, int edad, char sexo) {
        this.idPasajero = idPasajero;
        this.idReserva = idReserva;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sexo = sexo;
    }

    // Getters y Setters
    public int getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(int idPasajero) {
        this.idPasajero = idPasajero;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

}
