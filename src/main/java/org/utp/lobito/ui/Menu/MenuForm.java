package org.utp.lobito.ui.Menu;

import org.utp.lobito.domain.dto.UserDTO;
import org.utp.lobito.ui.Agregar.AgregarForm;
import org.utp.lobito.ui.GestionUsuarios.GestionUsuariosForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuForm extends JDialog {
    private UserDTO userDTO;


    private JPanel menuPanel;
    private JButton panelDeVuelosButton;
    private JButton vuelosReservadosButton;
    private JButton gestionDeUsuariosButton;
    private JLabel lblName;
    private JLabel lblOperario;


    public MenuForm(JFrame parent, UserDTO userDTO) { // Modificar el constructor
        super(parent);
        this.userDTO = userDTO; // Asignar el usuario recibido al campo de clase
        setTitle("Menu Principal");
        this.setContentPane(menuPanel);
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

    public void init() {
        lblName.setText(userDTO.getNombre() + " " + userDTO.getApellido());
        lblOperario.setText(userDTO.getRolTrabajador());
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


    public void onClick(){
        gestionDeUsuariosButton.addActionListener(e -> {
            dispose(); // Cerrar la instancia actual de MenuForm
            GestionUsuariosForm gestionUsuariosForm = new GestionUsuariosForm(null, userDTO); // Puedes pasar "null" si no necesitas un JFrame padre
            gestionUsuariosForm.setVisible(true);
        });

        panelDeVuelosButton.addActionListener(e -> {
            System.out.println("Botón 2");
        });

        vuelosReservadosButton.addActionListener(e -> {
            System.out.println("Botón 3");
        });
    }
}
