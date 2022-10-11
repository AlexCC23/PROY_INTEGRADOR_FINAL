package Controlador;

import Modelo.medico;
import Modelo.medicoDAO;
import Vistas.Software;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class doctorController implements ActionListener, KeyListener {

    medico med = new medico();
    medicoDAO medao = new medicoDAO();
    Software vista = new Software();
    DefaultTableModel modelo = new DefaultTableModel();

    public doctorController(Software m) {
        this.vista = m;
        this.vista.jbtnGuardarDoctor.addActionListener(this);
        this.vista.jbtnDoctores.addActionListener(this);
        this.vista.jbtnLimpiarDoctor.addActionListener(this);
        this.vista.jbtnEliminarDoctor.addActionListener(this);
        this.vista.jbtnEditarDoctor.addActionListener(this);
        this.vista.jtxtBuscarDoctor.addKeyListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.jbtnGuardarDoctor) {
            guardarDoctor();
            limpiarcajas();
            limpiarTabla();
            listarDoctor(vista.jTablaDoctor);
        }
        
        if (e.getSource() == vista.jbtnLimpiarDoctor) {
            if ("".equals(vista.jtxtDniDoctor.getText()) || "".equals(vista.jtxtNomDoctor.getText())
                    || "".equals(vista.jtxtApelliDoctor.getText())
                    || "".equals(vista.jcbxEspecialidadDoctor.getSelectedItem())) {
                JOptionPane.showMessageDialog(null, "Campos vacios");
            } else {
                limpiarcajas();
            }
        }
        if (e.getSource() == vista.jbtnEliminarDoctor) {
            eliminarDoctor();
            limpiarcajas();
            limpiarTabla();
            listarDoctor(vista.jTablaDoctor);

        }
        if (e.getSource() == vista.jbtnEditarDoctor) {
            editarDoctor();

        }
        if (e.getSource() == vista.jbtnDoctores) {
            limpiarcajas();
            limpiarTabla();
            listarDoctor(vista.jTablaDoctor);

        }
        
        

    }

    public void guardarDoctor() {
        if ("".equals(vista.jtxtDniDoctor.getText()) || "".equals(vista.jtxtNomDoctor.getText())
                || "".equals(vista.jtxtApelliDoctor.getText())
                || "".equals(vista.jcbxEspecialidadDoctor.getSelectedItem())) {
            JOptionPane.showMessageDialog(null, "Complete datos");
        } else if (!"".equals(vista.jtxtDniDoctor.getText()) || !"".equals(vista.jtxtNomDoctor.getText())
                || !"".equals(vista.jtxtApelliDoctor.getText())
                || !"".equals(vista.jcbxEspecialidadDoctor.getSelectedItem())) {
            med = new medico();
            modelo = (DefaultTableModel) vista.jTablaDoctor.getModel();
            for (int i = 0; i < vista.jTablaDoctor.getRowCount(); i++) {
                int dni = Integer.parseInt(vista.jtxtDniDoctor.getText());
                if (vista.jTablaDoctor.getValueAt(i, 1).equals(dni)) {
                    JOptionPane.showMessageDialog(null, "El doctor ya existe");
                    return;
                } else {
                    med.setDni_medico(Integer.parseInt(vista.jtxtDniDoctor.getText()));
                    med.setNombre_medico(vista.jtxtNomDoctor.getText());
                    med.setApellidos_medico(vista.jtxtApelliDoctor.getText());
                    med.setEspecialidad(vista.jcbxEspecialidadDoctor.getSelectedItem().toString());
                }

            }
            medao.guardarMedico(med);
            JOptionPane.showMessageDialog(null, "Doctor registrado");
        }
    }

    public void limpiarTabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;

        }
    }

    public void limpiarcajas() {

        vista.jlabelMedico.setText("");
        vista.jtxtDniDoctor.setText("");
        vista.jtxtNomDoctor.setText("");
        vista.jtxtApelliDoctor.setText("");
        vista.jcbxEspecialidadDoctor.setSelectedIndex(0);
    }

    public void listarDoctor(JTable tabla) {
        modelo = (DefaultTableModel) tabla.getModel();
        List<medico> ListaMe = medao.ListarMedico();

        Object[] object = new Object[5];
        for (int i = 0; i < ListaMe.size(); i++) {
            object[0] = ListaMe.get(i).getId_medico();
            object[1] = ListaMe.get(i).getDni_medico();
            object[2] = ListaMe.get(i).getNombre_medico();
            object[3] = ListaMe.get(i).getApellidos_medico();
            object[4] = ListaMe.get(i).getEspecialidad();

            modelo.addRow(object);
        }
        vista.jTablaDoctor.setModel(modelo);

    }

    public void eliminarDoctor() {
        if ("".equals(vista.jlabelMedico.getText())) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else if (!"".equals(vista.jtxtDniDoctor.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar?");
            if (pregunta == 0) {
                int dni = Integer.parseInt(vista.jtxtDniDoctor.getText());
                medao.deleteMedico(dni);

            }
        }
    }

    public void editarDoctor() {
        if ("".equals(vista.jtxtDniDoctor.getText()) || "".equals(vista.jtxtNomDoctor.getText())
                || "".equals(vista.jtxtApelliDoctor.getText())
                || "".equals(vista.jcbxEspecialidadDoctor.getSelectedItem())) {
            JOptionPane.showMessageDialog(null, "Campos vacios");
        } else {
            med.setDni_medico(Integer.parseInt(vista.jtxtDniDoctor.getText()));
            med.setNombre_medico(vista.jtxtNomDoctor.getText());
            med.setApellidos_medico(vista.jtxtApelliDoctor.getText());
            med.setEspecialidad(vista.jcbxEspecialidadDoctor.getSelectedItem().toString());
            med.setId_medico(Integer.parseInt(vista.jlabelMedico.getText()));
            if (!"".equals(vista.jtxtDniDoctor.getText()) || !"".equals(vista.jtxtNomDoctor.getText())
                    || !"".equals(vista.jtxtApelliDoctor.getText())
                    || !"".equals(vista.jcbxEspecialidadDoctor.getSelectedItem())) {
                medao.acutalizarMedico(med);
                JOptionPane.showMessageDialog(null, "Doctor Modificado");
                limpiarcajas();
                limpiarTabla();
                listarDoctor(vista.jTablaDoctor);

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
        if ("".equals(vista.jtxtBuscarDoctor.getText())) {
            vista.jlabelErrorBuscar.setText("Ingresa solo números");
        } else if (e.getSource()== vista.jtxtBuscarDoctor) {
            int dni = Integer.parseInt(vista.jtxtBuscarDoctor.getText());

            DefaultTableModel modeloB = new DefaultTableModel();
            vista.jTablaDoctor.setModel(modeloB);

            modeloB.addColumn("ID"); //solo se creado cada letra que se ingrese
            modeloB.addColumn("DNI");
            modeloB.addColumn("NOMBRE");
            modeloB.addColumn("APELLIDOS");
            modeloB.addColumn("ESPECIALIDAD");
            Object[] object = new Object[5];
            int numregistros = medao.buscarMedicoXDni(dni).size();
            for (int i = 0; i < numregistros; i++) {
                object[0] = medao.buscarMedicoXDni(dni).get(i).getId_medico();
                object[1] = medao.buscarMedicoXDni(dni).get(i).getDni_medico();
                object[2] = medao.buscarMedicoXDni(dni).get(i).getNombre_medico();
                object[3] = medao.buscarMedicoXDni(dni).get(i).getApellidos_medico();
                object[4] = medao.buscarMedicoXDni(dni).get(i).getEspecialidad();
                modeloB.addRow(object);
                vista.jlabelErrorBuscar.setText("");
            }

        }

    }
}

