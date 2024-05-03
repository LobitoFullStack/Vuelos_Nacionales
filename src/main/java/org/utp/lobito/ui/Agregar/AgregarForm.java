package org.utp.lobito.ui.Agregar;

import org.utp.lobito.di.module.DatabaseConnection;
import org.utp.lobito.domain.dto.PersonaDTO;
import org.utp.lobito.domain.dto.UserDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AgregarForm extends JDialog {
    private JPanel agregarPanel;
    private JTabbedPane TblAgregar;
    private JPanel TblPersonas;
    private JPanel TblUsuarios;
    private JTextField txtName;
    private JTextField txtLastName;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private JTextField txtDocumento;
    private JButton agregarButton;
    private JLabel nameUser;
    private JLabel lastName;
    private JTextField txtCorreo;
    private JPasswordField txtContraseña;
    private JTextField txtValidarContraseña;
    private JButton btnAgregarUsuario;
    private JComboBox cmbRolUsuario;
    private Integer rolTrabajador;



    public AgregarForm(JFrame parent) {
        super(parent);
        setTitle("Agregar Clientes");
        this.setContentPane(agregarPanel);
        setMinimumSize(new Dimension(550,474));
        this.setModal(true);
        this.setLocationRelativeTo(parent);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        init();
        onClick();
        this.setVisible(true);


    }

    private void init(){
            cmbRolUsuario.addItem("Jefe");
            cmbRolUsuario.addItem("Administrador");
            cmbRolUsuario.addItem("Agente de Viaje");
    }

    private void onClick() {
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txtName.getText().trim();
                String lastName = txtLastName.getText().trim();
                String direccion = txtDireccion.getText().trim();
                String telefono = txtTelefono.getText().trim();
                String documento = txtDocumento.getText().trim();

                // Validar datos antes de intentar agregar a la base de datos
                if (validarDatosPersona(name, lastName, direccion, telefono, documento)) {
                    PersonaDTO persona = new PersonaDTO();
                    persona.setNombre(name);
                    persona.setApellido(lastName);
                    persona.setDireccion(direccion);
                    persona.setTelefono(telefono);
                    persona.setDocumentoIdentidad(documento);

                    agregarPersona(persona);
                }

            }
        });


        cmbRolUsuario.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedRole = cmbRolUsuario.getSelectedItem().toString();
                    if (selectedRole.equals("Jefe")) {
                        System.out.println("el rol seleccionado si es Jefe es igual a 1" );
                        rolTrabajador = 1;
                    } else if(selectedRole.equals("Administrador")){
                        System.out.println("el rol seleccionado si es Administrador es igual a 2" );
                        rolTrabajador = 2;
                    }else if(selectedRole.equals("Agente de Viaje")){
                        System.out.println("el rol seleccionado si es Agente de Viaje es igual a 3" );
                        rolTrabajador = 3;
                    }
                }
            }
        });
    }

    private void agregarPersona(PersonaDTO persona) {
        Connection conn = null;
        try {
            conn = DatabaseConnection.getConnection(); // Asume que esta clase maneja la conexión a la base de datos.
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO persona (nombre, apellido, direccion, telefono, documento_identidad) VALUES (?, ?, ?, ?, ?)");
            pstmt.setString(1, persona.getNombre());
            pstmt.setString(2, persona.getApellido());
            pstmt.setString(3, persona.getDireccion());
            pstmt.setString(4, persona.getTelefono());
            pstmt.setString(5, persona.getDocumentoIdentidad());


            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(null, "Persona agregada exitosamente!");
            } else {
                JOptionPane.showMessageDialog(null, "Error al agregar la persona.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }



    private boolean validarDatosPersona(String nombre, String apellido, String direccion, String telefono, String documento) {
        // Validar nombre: solo letras
        if (nombre.isEmpty() || !nombre.matches("[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ\\s]+")) { //todo : Estos son expresiones regualres regex permiten solo textos
            JOptionPane.showMessageDialog(this, "El campo 'Nombre' solo puede contener letras y espacios.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (apellido.isEmpty() || !apellido.matches("[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ\\s]+")) { //todo : Estos son expresiones regualres regex permiten solo textos
            JOptionPane.showMessageDialog(this, "El campo 'Apellido' solo puede contener letras y espacios.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (direccion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo 'Dirección' no puede estar vacío.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validar solo números
        if (telefono.isEmpty() || !telefono.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "El campo 'Teléfono' solo puede contener números.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (documento.isEmpty() || !documento.matches("\\d+")) { //todo : Estos son expresiones regualres regex pero este permite solo numero
            JOptionPane.showMessageDialog(this, "El campo 'Documento de Identidad' solo puede contener números.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }


}
