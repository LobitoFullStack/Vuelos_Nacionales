package org.utp.lobito.ui.tarea3S3;

public class ComplejoDeportivo {
    private String tamaño;
    private String tipo;
    private String horario;
    private boolean estado;

    // Constructor
    public ComplejoDeportivo(String tamaño, String tipo, String horario) {
        this.tamaño = tamaño;
        this.tipo = tipo;
        this.horario = horario;
        this.estado = false; // Al inicio el complejo está libre
    }


    public void reservar() {
        if (!estado) {
            estado = true;
            System.out.println("¡Complejo reservado exitosamente!");
        } else {
            System.out.println("El complejo ya está reservado en este horario.");
        }
    }

    public void verDatos() {
        System.out.println("Tamaño: " + tamaño);
        System.out.println("Tipo: " + tipo);
        System.out.println("Horario: " + horario);
        System.out.println("Estado: " + (estado ? "Reservado" : "Libre"));
    }
}