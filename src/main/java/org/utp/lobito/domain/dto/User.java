package org.utp.lobito.domain.dto;

public class User {
    private int id;
    private int idPersona;
    private String nombre;
    private String apellido;
    private String documentoIdentidad;
    private String rolTrabajador;

    // Constructor vacío
    public User() {
    }

    // Getters y setters para cada campo
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
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

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }


    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getRolTrabajador() {
        return rolTrabajador;
    }

    public void setRolTrabajador(String rolTrabajador) {
        this.rolTrabajador = rolTrabajador;
    }
}
