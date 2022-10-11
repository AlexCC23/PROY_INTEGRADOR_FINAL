package Controlador;

import Modelo.paciente;
import Modelo.usuario;
import Modelo.usuarioDAO;
import Vistas.Software;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sebastian
 */
public class usuarioController implements ActionListener, KeyListener {

    usuarioDAO usudao = new usuarioDAO();
    usuario usu = new usuario();
    Software vista = new Software();
    DefaultTableModel modelo = new DefaultTableModel();

    public usuarioController(Software u) {
        this.vista = u;
        this.vista.jbtnGuardarUsuario.addActionListener(this);
        this.vista.jbtnLimpiarU.addActionListener(this);
        this.vista.jbtnEliminarU.addActionListener(this);
        this.vista.jbtnEditarU.addActionListener(this);
        this.vista.buscarUsuario.addKeyListener(this); //buscar
        this.vista.jbtnUsuarios.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.jbtnGuardarUsuario) {
            grabarUsuario();
            limpiarcajasUsuario();
            limpiarTabla();
            listarUsuario(vista.jTableUsuario);
        }

        if (e.getSource() == vista.jbtnUsuarios) {
            limpiarcajasUsuario();
            limpiarTabla();
            listarUsuario(vista.jTableUsuario);
        }
        if (e.getSource() == vista.jbtnLimpiarU) {
            if ("".equals(vista.jtxtUsuarioUsu.getText())
                    || "".equals(vista.jtxtContraseñaUsu.getText())
                    || "".equals(vista.jtxtNombreUsu.getText())
                    || "".equals(vista.jcbxRolUsu.getSelectedItem())) {
                JOptionPane.showMessageDialog(null, "Los campos ya estan vacios");
            } else {
                limpiarcajasUsuario();
            }
        }
        if (e.getSource() == vista.jbtnEliminarU) {
            eliminarUsuario();
            limpiarcajasUsuario();
            limpiarTabla();
            listarUsuario(vista.jTableUsuario);
        }

        if (e.getSource() == vista.jbtnEditarU) {
            editarUsuario();

        }

    }

    private void grabarUsuario() {
        if ("".equals(vista.jtxtUsuarioUsu.getText())
                || "".equals(vista.jtxtContraseñaUsu.getText())
                || "".equals(vista.jtxtNombreUsu.getText())
                || "".equals(vista.jcbxRolUsu.getSelectedItem())) {
            JOptionPane.showMessageDialog(null, "Complete datos");
        } else if (!"".equals(vista.jtxtUsuarioUsu.getText())
                || !"".equals(vista.jtxtContraseñaUsu.getText())
                || !"".equals(vista.jtxtNombreUsu.getText())
                || !"".equals(vista.jcbxRolUsu.getSelectedItem())) {

            usu = new usuario();
            modelo = (DefaultTableModel) vista.jTableUsuario.getModel();
            for (int i = 0; i < vista.jTableUsuario.getRowCount(); i++) {
                if (vista.jTableUsuario.getValueAt(i, 1).equals(vista.jtxtUsuarioUsu.getText())) {
                    JOptionPane.showMessageDialog(null, "El usuario ya existe");
                    return;
                } else {
                    usu.setUsuario(vista.jtxtUsuarioUsu.getText());
                    usu.setContraseña(vista.jtxtContraseñaUsu.getText());
                    usu.setNombre(vista.jtxtNombreUsu.getText());
                    usu.setCargo(vista.jcbxRolUsu.getSelectedItem().toString());
                }
            }
            usudao.guardarUsuario(usu);
            JOptionPane.showMessageDialog(null, "Usuario registrado");
        }
    }

    public void listarUsuario(JTable tabla) {
        modelo = (DefaultTableModel) tabla.getModel();
        List<usuario> ListaUs = usudao.ListarUsuario(); // lista para la cantidad de usuarios

        Object[] object = new Object[5]; // la cantida de datos de cada usuario
        for (int i = 0; i < ListaUs.size(); i++) {
            object[0] = ListaUs.get(i).getId_usua();
            object[1] = ListaUs.get(i).getUsuario();
            object[2] = ListaUs.get(i).getContraseña();
            object[3] = ListaUs.get(i).getNombre();
            object[4] = ListaUs.get(i).getCargo();
            modelo.addRow(object);
        }
        vista.jTableUsuario.setModel(modelo);

    }

    public void limpiarTabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;

        }
    }

    public void limpiarcajasUsuario() {
        vista.jlabelUsuario.setText("");
        vista.jtxtUsuarioUsu.setText("");
        vista.jtxtContraseñaUsu.setText("");
        vista.jtxtNombreUsu.setText("");
        vista.jcbxRolUsu.setSelectedIndex(0);
    }

    public void eliminarUsuario() {
        if ("".equals(vista.jlabelUsuario.getText())) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else if (!"".equals(vista.jlabelUsuario.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar?");
            if (pregunta == 0) {
                int id_u = Integer.parseInt(vista.jlabelUsuario.getText());
                usudao.deleteUsuario(id_u);
            }
        }

    }

    public void editarUsuario() {
        if ("".equals(vista.jtxtUsuarioUsu.getText()) || "".equals(vista.jtxtContraseñaUsu.getText())
                || "".equals(vista.jtxtNombreUsu.getText())
                || "".equals(vista.jcbxRolUsu.getSelectedItem())) {
            JOptionPane.showMessageDialog(null, "Campos vacios");
        } else {
            usu.setUsuario(vista.jtxtUsuarioUsu.getText());
            usu.setContraseña(vista.jtxtContraseñaUsu.getText());
            usu.setNombre(vista.jtxtNombreUsu.getText());
            usu.setCargo(vista.jcbxRolUsu.getSelectedItem().toString());
            usu.setId_usua(Integer.parseInt(vista.jlabelUsuario.getText()));
            if (!"".equals(vista.jtxtNombreUsu.getText()) || !"".equals(vista.jtxtUsuarioUsu.getText())
                    || !"".equals(vista.jtxtContraseñaUsu.getText()) || !"".equals(vista.jcbxRolUsu.getSelectedItem())) {
                usudao.acutalizarUsuario(usu);
                JOptionPane.showMessageDialog(null, "Usuario Modificado");
                limpiarcajasUsuario();
                limpiarTabla();
                listarUsuario(vista.jTableUsuario);
                //JOptionPane.showMessageDialog(null, "Actualizado");
            } else {
                JOptionPane.showMessageDialog(null, "Los campos estan vacios");
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == vista.buscarUsuario) {
            String usuario = vista.buscarUsuario.getText();
            DefaultTableModel modeloB = new DefaultTableModel();
            vista.jTableUsuario.setModel(modeloB);

            modeloB.addColumn("ID"); //solo se creado cada letra que se ingrese
            modeloB.addColumn("USUARIO");
            modeloB.addColumn("CONTRASEÑA");
            modeloB.addColumn("NOMBRE");
            modeloB.addColumn("ROL");
            //POR SI SE DESEA LIMPIAR LA TABLA CUANDO ESTA VACIO LA CAJA DE TEXTO
            //if (!"".equals(vistaC.buscarListacliente.getText())) {/
            Object[] object = new Object[5];
            int numregistros = usudao.buscarUsuarioXUsuario(usuario).size();
            for (int i = 0; i < numregistros; i++) {
                object[0] = usudao.buscarUsuarioXUsuario(usuario).get(i).getId_usua();
                object[1] = usudao.buscarUsuarioXUsuario(usuario).get(i).getUsuario();
                object[2] = usudao.buscarUsuarioXUsuario(usuario).get(i).getContraseña();
                object[3] = usudao.buscarUsuarioXUsuario(usuario).get(i).getNombre();
                object[4] = usudao.buscarUsuarioXUsuario(usuario).get(i).getCargo();
                modeloB.addRow(object);
            }

            /* }else{
                limpiarTabla();
            }*/
        }
    }
}
