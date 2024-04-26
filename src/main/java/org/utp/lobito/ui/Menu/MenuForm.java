package org.utp.lobito.ui.Menu;

import org.utp.lobito.domain.dto.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuForm extends JDialog {
    private User user;


    private JPanel menuPanel;
    private JButton panelDeVuelosButton;
    private JButton vuelosReservadosButton;
    private JButton gestionDeUsuariosButton;
    private JLabel lblName;
    private JLabel lblOperario;


    public MenuForm(JFrame parent, User user) { // Modificar el constructor
        super(parent);
        this.user = user; // Asignar el usuario recibido al campo de clase
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
        lblName.setText(user.getNombre() + " " + user.getApellido());
        lblOperario.setText(user.getRolTrabajador());
    }

    private void imprimirInformacionUsuarioTest() {
        if (user != null) {
            System.out.println("Información del usuario:");
            System.out.println("ID: " + user.getId());
            System.out.println("Nombre: " + user.getNombre());
            System.out.println("Apellido: " + user.getApellido());
            System.out.println("Rol de trabajador: " + user.getRolTrabajador());
            System.out.println("Documento de identidad: " + user.getDocumentoIdentidad());
        } else {
            System.out.println("No se proporcionó información de usuario.");
        }
    }


    public void onClick(){
        gestionDeUsuariosButton.addActionListener(e -> {
            System.out.println("Botón 1");
        });

        panelDeVuelosButton.addActionListener(e -> {
            System.out.println("Botón 2");
        });

        vuelosReservadosButton.addActionListener(e -> {
            System.out.println("Botón 3");
        });
    }
}
