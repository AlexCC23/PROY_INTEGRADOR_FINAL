package Controlador;

import Modelo.especialidad;
import Modelo.especialidadDAO;
import Vistas.Software;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class especialidadController implements ActionListener, KeyListener {

    especialidadDAO esdao = new especialidadDAO();
    especialidad es = new especialidad();
    Software vista = new Software();
    DefaultTableModel modelo = new DefaultTableModel();

    public especialidadController(Software e) {
        this.vista = e;
        this.vista.jbtnGuardarEspecialidad.addActionListener(this);
        this.vista.jbtnEliminarEspecialidad.addActionListener(this);
        this.vista.jbtnEditarEspecialidad.addActionListener(this);
        this.vista.jtxtBuscarEspecialidad.addKeyListener(this);
        this.vista.jbtnLimpiarEspecialidad.addActionListener(this);
        this.vista.jbtnEspecialidad.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.jbtnGuardarEspecialidad) {
            guardarEspecialidad();
            limpiarcajas();
            limpiarTablaEs();
            listarEspecialidad(vista.jTablaEspecialidad);
        }
        if (e.getSource() == vista.jbtnEspecialidad) {
            limpiarcajas();
            limpiarTablaEs();
            listarEspecialidad(vista.jTablaEspecialidad);
        }

        if (e.getSource() == vista.jbtnLimpiarEspecialidad) {
            if ("".equals(vista.jtxtespecialidad.getText())) {
                JOptionPane.showMessageDialog(null, "Campo vacio");
            } else {
                limpiarcajas();
            }
        }
        if (e.getSource() == vista.jbtnEliminarEspecialidad) {
            eliminarEspecialidad();
            limpiarcajas();
            limpiarTablaEs();
            listarEspecialidad(vista.jTablaEspecialidad);
        }
        if (e.getSource() == vista.jbtnEditarEspecialidad) {
            editarEspecialidad();
        }

    }

    public void guardarEspecialidad() {
        if ("".equals(vista.jtxtespecialidad.getText())) {
            JOptionPane.showMessageDialog(null, "Complete datos");
        } else if (!"".equals(vista.jtxtespecialidad.getText())) {
            es = new especialidad();
            modelo = (DefaultTableModel) vista.jTablaEspecialidad.getModel();
            for (int i = 0; i < vista.jTablaEspecialidad.getRowCount(); i++) {
                if (vista.jTablaEspecialidad.getValueAt(i, 1).equals(vista.jtxtespecialidad.getText())) {
                    JOptionPane.showMessageDialog(null, "La especialidad ya existe");
                    return;
                } else {
                    es.setNom_espec(vista.jtxtespecialidad.getText());
                }
            }
            esdao.guardarespecialidad(es);
            JOptionPane.showMessageDialog(null, "Especialidad registrada");
        }

    }

    private void listarEspecialidad(JTable tabla) {
        modelo = (DefaultTableModel) tabla.getModel();
        List<especialidad> ListaEs = esdao.ListarEsspecialidad();

        Object[] object = new Object[2];
        for (int i = 0; i < ListaEs.size(); i++) {
            object[0] = ListaEs.get(i).getId_especialidad();
            object[1] = ListaEs.get(i).getNom_espec();
            modelo.addRow(object);
        }
        vista.jTablaEspecialidad.setModel(modelo);
    }

    public void limpiarTablaEs() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;

        }
    }

    public void limpiarcajas() {
        vista.jlabelespecialidad.setText("");
        vista.jtxtespecialidad.setText("");

    }

    public void eliminarEspecialidad() {
        if ("".equals(vista.jlabelespecialidad.getText())) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else if (!"".equals(vista.jtxtespecialidad.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar?");
            if (pregunta == 0) {
                String nom = vista.jtxtespecialidad.getText();
                esdao.deleteEspecialidad(nom);

            }
        }
    }

    private void editarEspecialidad() {
        if ("".equals(vista.jtxtespecialidad.getText())) {
            JOptionPane.showMessageDialog(null, "Campo vacio");
        } else {
            es.setNom_espec(vista.jtxtespecialidad.getText());
            es.setId_especialidad(Integer.parseInt(vista.jlabelespecialidad.getText()));

            if (!"".equals(vista.jtxtespecialidad.getText())) {
                esdao.editarEspecialidad(es);
                JOptionPane.showMessageDialog(null, "Especialidad modificada");
                limpiarcajas();
                limpiarTablaEs();
                listarEspecialidad(vista.jTablaEspecialidad);
            } else {
                JOptionPane.showMessageDialog(null, "Campo vacio");
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
        if (e.getSource() == vista.jtxtBuscarEspecialidad) {
            String nombre = vista.jtxtBuscarEspecialidad.getText();
            DefaultTableModel modeloE = new DefaultTableModel();
            vista.jTablaEspecialidad.setModel(modeloE);

            modeloE.addColumn("ID");
            modeloE.addColumn("ESPECIALIDAD");
            Object[] object = new Object[2];
            int numregistros = esdao.buscarEspecialidadXnombre(nombre).size();
            for (int i = 0; i < numregistros; i++) {
                object[0] = esdao.buscarEspecialidadXnombre(nombre).get(i).getId_especialidad();
                object[1] = esdao.buscarEspecialidadXnombre(nombre).get(i).getNom_espec();
                modeloE.addRow(object);
            }

            /* }else{
                limpiarTabla();
            }*/
        }
    }
}
