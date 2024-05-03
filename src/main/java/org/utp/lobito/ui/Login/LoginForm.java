package org.utp.lobito.ui.Login;



import org.utp.lobito.di.module.DatabaseConnection;
import org.utp.lobito.domain.dto.UserDTO;
import org.utp.lobito.ui.Menu.MenuForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import static org.utp.lobito.domain.utils.Utils.isValidEmail;


public class LoginForm extends JDialog {
    private JTextField txtEmail;
    private JPasswordField txtpassword;
    private JButton btnSession;
    private JPanel loginPanel;
    public UserDTO userDTO;

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

                if (!isValidEmail(email)) {  //este regex valida que tenga el formato de un correo lobito@lobito.com
                    JOptionPane.showMessageDialog(null, "Valide que sea un correo Valido");
                    return;
                }
                System.out.println("Inicio de sesión con correo electrónico: " + email + " y contraseña: " + password + ".");


                userDTO = getAuthentication(email, password);
                if (userDTO != null) {
                    JOptionPane.showMessageDialog(null, "Bienvenido " + userDTO.getNombre());
                    // Cerrar la ventana actual
                    dispose(); // Cerrar la instancia actual de LoginForm

                    // Abrir la ventana del menú y pasar el usuario
                    MenuForm menuForm = new MenuForm(null, userDTO); // Puedes pasar "null" si no necesitas un JFrame padre
                    menuForm.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                }
            }
        });
    }

    private UserDTO getAuthentication(String email, String password) {


        UserDTO userDTO = null;
        Connection conn = null;

        try {
            conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT u.id_persona, u.id_usuario, p.nombre, p.apellido, p.direccion, p.telefono, p.documento_identidad, tp.tipo_empleado FROM usuario u INNER JOIN persona p ON u.id_persona = p.id_persona INNER JOIN tipo_empleado tp ON u.cod_tipo_empleado = tp.cod_tipo_empleado WHERE u.correo = ? AND u.contraseña = ?");
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                userDTO = new UserDTO();
                userDTO.setId(rs.getInt("id_usuario"));
                userDTO.setIdPersona(rs.getInt("id_persona"));
                userDTO.setNombre(rs.getString("nombre"));
                userDTO.setApellido(rs.getString("apellido"));
                userDTO.setRolTrabajador(rs.getString("tipo_empleado"));
                userDTO.setDocumentoIdentidad(rs.getString("documento_identidad"));
            } else {
                System.out.println("Inicio de sesión fallido. Correo electrónico o contraseña incorrectos.");
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userDTO;
    }

    public static void main(String[] args) {
        LoginForm loginForm = new LoginForm(null);
        UserDTO userDTO = loginForm.userDTO;
    }



}
