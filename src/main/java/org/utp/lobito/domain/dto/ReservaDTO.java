package org.utp.lobito.domain.dto;

import java.util.Date;

public class ReservaDTO {
    private int idReserva;
    private int idUsuario;
    private int idVuelo;
    private Date fechaReserva;
    private int cantidadPasajeros;

    // Constructor sin parámetros
    public ReservaDTO() {
    }

    // Constructor con parámetros
    public ReservaDTO(int idReserva, int idUsuario, int idVuelo, Date fechaReserva, int cantidadPasajeros) {
        this.idReserva = idReserva;
        this.idUsuario = idUsuario;
        this.idVuelo = idVuelo;
        this.fechaReserva = fechaReserva;
        this.cantidadPasajeros = cantidadPasajeros;
    }

    // Getters y Setters
    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public void setCantidadPasajeros(int cantidadPasajeros) {
        this.cantidadPasajeros = cantidadPasajeros;
    }


}