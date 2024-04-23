package org.utp.lobito.ui.Login;

import org.utp.lobito.di.module.DatabaseConnection;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Login
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese su correo electrónico:");
        String correo = scanner.nextLine();

        System.out.println("Ingrese su contraseña:");
        String contraseña = scanner.nextLine();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT u.id, p.nombre, p.apellido, p.rol_trabajador FROM usuarios u INNER JOIN personas p ON u.id_persona = p.id WHERE u.correo = ? AND u.contraseña = ?")) {

            // Establecer la hora de inicio de sesión como la hora actual
            LocalDateTime horaInicioSesion = LocalDateTime.now();
            stmt.setTimestamp(1, Timestamp.valueOf(horaInicioSesion));
            stmt.setString(1, correo);
            stmt.setString(2, contraseña);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Autenticación exitosa, se encontró un usuario con las credenciales proporcionadas
                    int idUsuario = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String apellido = rs.getString("apellido");
                    String rolTrabajador = rs.getString("rol_trabajador");

                    System.out.println("Inicio de sesión exitoso para el usuario " + nombre + " " + apellido);
                    System.out.println("ID: " + idUsuario);
                    System.out.println("Rol de trabajador: " + rolTrabajador);
                } else {
                    // Autenticación fallida, no se encontró ningún usuario con las credenciales proporcionadas
                    System.out.println("Inicio de sesión fallido. Correo electrónico o contraseña incorrectos.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}
