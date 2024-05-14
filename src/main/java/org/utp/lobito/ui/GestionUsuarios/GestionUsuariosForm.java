package org.utp.lobito.ui.GestionUsuarios;

import org.utp.lobito.domain.dto.UserDTO;
import org.utp.lobito.ui.Agregar.AgregarForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GestionUsuariosForm  extends JDialog {
    private UserDTO userDTO;
    private JPanel gestionPanel;
    private JButton btnAgregar;
    private JButton EDITARButton1;
    private JButton FILTROSDEBUSQUEDAButton;
    private JButton ELIMINARButton;


    public GestionUsuariosForm(JFrame parent, UserDTO userDTO) { // Modificar el constructor
        super(parent);
        this.userDTO = userDTO; // Asignar el usuario recibido al campo de clase
        setTitle("Gestión de Usuarios");
        this.setContentPane(gestionPanel);
        setMinimumSize(new Dimension(450,474));
        this.setModal(true);
        this.setLocationRelativeTo(parent);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        onClick();
        init();
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                imprimirInformacionUsuarioTest();
            }
        });
        this.setVisible(true);
    }
    private void init() {
//        lblName.setText(user.getNombre() + " " + user.getApellido());
//        lblOperario.setText(user.getRolTrabajador());
    }
    private void onClick(){
    btnAgregar.addActionListener(e -> {
        dispose(); // Cerrar la instancia actual de MenuForm
        AgregarForm agregarForm = new AgregarForm(null); // Puedes pasar "null" si no necesitas un JFrame padre
        agregarForm.setVisible(true);
    });



    }

    private void imprimirInformacionUsuarioTest() {
        if (userDTO != null) {
            System.out.println("Información del usuario:");
            System.out.println("ID: " + userDTO.getId());
            System.out.println("Nombre: " + userDTO.getNombre());
            System.out.println("Apellido: " + userDTO.getApellido());
            System.out.println("Rol de trabajador: " + userDTO.getRolTrabajador());
            System.out.println("Documento de identidad: " + userDTO.getDocumentoIdentidad());
        } else {
            System.out.println("No se proporcionó información de usuario.");
        }
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
