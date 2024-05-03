package org.utp.lobito.ui.Login;



import org.utp.lobito.di.module.DatabaseConnection;
import org.utp.lobito.domain.dto.User;
import org.utp.lobito.ui.Menu.MenuForm;

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
        setMinimumSize(new Dimension(550,474));
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
                    // Cerrar la ventana actual
                    dispose(); // Cerrar la instancia actual de LoginForm

                    // Abrir la ventana del menú y pasar el usuario
                    MenuForm menuForm = new MenuForm(null, user); // Puedes pasar "null" si no necesitas un JFrame padre
                    menuForm.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                }
            }
        });
    }

    private User getAuthentication(String email, String password) {
        if (!isValidEmail(email)) {  //este regex valida que tenga el formato de un correo lobito@lobito.com
            JOptionPane.showMessageDialog(null, "Valide que sea un correo Valido");
            return null;
        }

        User user = null;
        Connection conn = null;

        try {
            conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT u.id_persona, u.id_usuario, p.nombre, p.apellido, p.direccion, p.telefono, p.documento_identidad, tp.tipo_empleado FROM usuario u INNER JOIN persona p ON u.id_persona = p.id_persona INNER JOIN tipo_empleado tp ON u.cod_tipo_empleado = tp.cod_tipo_empleado WHERE u.correo = ? AND u.contraseña = ?");
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id_usuario"));
                user.setIdPersona(rs.getInt("id_persona"));
                user.setNombre(rs.getString("nombre"));
                user.setApellido(rs.getString("apellido"));
                user.setRolTrabajador(rs.getString("tipo_empleado"));
                user.setDocumentoIdentidad(rs.getString("documento_identidad"));
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
