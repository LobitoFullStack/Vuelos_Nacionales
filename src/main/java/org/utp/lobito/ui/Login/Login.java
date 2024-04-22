package org.utp.lobito.ui.Login;

import org.utp.lobito.data.common.Constants;
import org.utp.lobito.di.module.DatabaseConnection;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class Login
{
    public static void main( String[] args )
    {
        try{
            Connection myConn = DatabaseConnection.getConnection();
            Statement myStmt = myConn.createStatement();
            String sql = "select * from auditoria.cambios";
            ResultSet rs = myStmt.executeQuery(sql);

              while(rs.next()){
                System.out.println(rs.getString("id"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }



        System.out.println( "Hello World!" );
    }
}
