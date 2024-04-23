package org.utp.lobito.ui.Login;



import org.utp.lobito.di.module.DatabaseConnection;
import org.utp.lobito.domain.dto.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDateTime;

import static org.utp.lobito.domain.utils.Utils.isValidEmail;


public class LoginForm extends JDialog {
    private JTextField txtEmail;
    private JPasswordField txtpassword;
    private JButton btnSession;
    private JPanel loginPanel;
    public User user;

    public LoginForm(JFrame parent) {
        super(parent);
        setTitle("Login");
        this.setContentPane(loginPanel);
        setMinimumSize(new Dimension(450,474));
        this.setModal(true);
        this.setLocationRelativeTo(parent);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        onClick();
        this.setVisible(true);
    }

    public void onClick(){
        btnSession.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = txtEmail.getText();
                String password = txtpassword.getText();
                System.out.println("Inicio de sesión con correo electrónico: " + email + " y contraseña: " + password + ".");


                user = getAuthentication(email, password);
                if (user != null) {
                    JOptionPane.showMessageDialog(null, "Bienvenido " + user.getNombre());
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                }
            }
        });
    }



    private User getAuthentication(String email, String password) {
        if (!isValidEmail(email)) {
            JOptionPane.showMessageDialog(null, "Valide que sea un correo Valido");
            return null;
        }

        User user = null;
        Connection conn = null;



        try {
            conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT u.id, u.id_persona, p.nombre, p.apellido,p.documento_identidad, e.tipo FROM usuario u INNER JOIN persona p INNER JOIN tipo_empleado e ON u.id_persona = p.id WHERE u.correo = ? AND u.contraseña = ?");
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                if (rs.next()) {
                    user = new User();
                    user.setId(rs.getInt("id")); // Aquí utilizamos el alias "id_usuario" que asignamos en la consulta SQL
                    user.setIdPersona(rs.getInt("id_persona"));
                    user.setNombre(rs.getString("nombre"));
                    user.setApellido(rs.getString("apellido"));
                    user.setRolTrabajador(rs.getString("tipo")); // Usamos el alias "tipo_empleado"
                    user.setDocumentoIdentidad(rs.getString("documento_identidad")); // Usamos el nombre de columna directamente
                }

                // Obtener la hora de inicio de sesión actual
                LocalDateTime horaInicioSesion = LocalDateTime.now();

                // Insertar la hora de inicio de sesión en la tabla usuario
                PreparedStatement updateStmt = conn.prepareStatement("UPDATE usuario SET hora_inicio = ? WHERE id = ?");
                updateStmt.setTimestamp(1, Timestamp.valueOf(horaInicioSesion));
                updateStmt.setInt(2, user.getId());
                updateStmt.executeUpdate();
            } else {
                System.out.println("Inicio de sesión fallido. Correo electrónico o contraseña incorrectos.");
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public static void main(String[] args) {
        LoginForm loginForm = new LoginForm(null);
        User user = loginForm.user;
    }


}
