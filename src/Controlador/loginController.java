package Controlador;

import Modelo.*;
import Vistas.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class loginController implements ActionListener {

    usuario loginusu = null; //concreta
    usuarioDAO usudao; //dao
    Login logvista; //vista
    Software l;

    public loginController(Login logvista, usuarioDAO usudao, Software l) {
        this.l = l;
        this.logvista = logvista;
        this.usudao = usudao;
        this.logvista.jbtnIniciar.addActionListener(this);
        this.logvista.jbtnSalirLogin.addActionListener(this);
        this.l.jbtnSalir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logvista.jbtnIniciar) {
            validar();

        }
        if (e.getSource() == logvista.jbtnSalirLogin) {
            System.exit(0);
        }
        if (e.getSource() == l.jbtnSalir) {
            System.exit(0);
            //l.dispose();
            //logvista.setVisible(true);
            l.jbtnUsuarios.setEnabled(true);
            l.jbtnEspecialidad.setEnabled(true);
            l.jbtnDoctores.setEnabled(true);
        }

    }

    public void validar() {
        String usuario = logvista.jtxtLoginUsuario.getText();
        String contra = String.valueOf(logvista.jtxtLoginContraseña.getPassword());

        if ("".equals(logvista.jtxtLoginUsuario.getText()) || "".equals(logvista.jtxtLoginContraseña.getPassword())) {
            logvista.jlabelErrorUsuario.setText("Campos vacios");
        }

        if (!"".equals(usuario) && !"".equals(contra)) {
            loginusu = usudao.validar(usuario, contra);

            if (loginusu.getUsuario() != null && loginusu.getContraseña() != null) {

                pacienteController c = new pacienteController(l);
                especialidadController p = new especialidadController(l);
                citaController ve = new citaController(l);
                usuarioController u = new usuarioController(l);
                doctorController d = new doctorController(l);
                horarioController h = new horarioController(l);
                historialController t = new historialController(l);

                if (loginusu.getCargo().equals("Recepcionista")) {
                    l.jlabelIngreso.setText(usuario);
                    l.jbtnUsuarios.setEnabled(false);
                    l.jbtnEspecialidad.setEnabled(false);
                    l.jbtnDoctores.setEnabled(false);
                    logvista.dispose();
                    l.setVisible(true);
                } else {
                    l.jlabelIngreso.setText(usuario);
                    logvista.dispose();
                    l.setVisible(true);
                }
            } else {
                logvista.jlabelErrorUsuario.setText("Usuario no autorizado");
                //JOptionPane.showMessageDialog(null, "Usuario no autorizado");
            }

        }

    }

}
