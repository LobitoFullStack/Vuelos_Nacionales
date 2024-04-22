package org.utp.lobito.di.module;

import org.utp.lobito.data.common.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/" + Constants.NAME_BD + "?autoReconnect=true&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "10701147";
    private static Connection connection;

    private DatabaseConnection() {} // Constructor privado para evitar instanciación externa

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                System.err.println("Error al establecer la conexión con la base de datos: " + e.getMessage());
            }
        }
        return connection;
    }
}
