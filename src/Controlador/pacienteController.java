package Controlador;

import Modelo.paciente;
import Modelo.pacienteDAO;
import Vistas.Software;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class pacienteController implements ActionListener, KeyListener {

    pacienteDAO pacdao = new pacienteDAO();
    paciente pac = new paciente();
    Software vista = new Software();
    DefaultTableModel modelo = new DefaultTableModel();

    public pacienteController(Software v) {
        this.vista = v;
        this.vista.jbtnGuardarPaciente.addActionListener(this);
        this.vista.jBtnLimpiar.addActionListener(this);
        this.vista.jbtnEliminarPaciente.addActionListener(this);
        this.vista.jbtnEditarPaciente.addActionListener(this);
        this.vista.jtxtBuscarPaciente.addKeyListener(this);
        this.vista.jbtnPaciente.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.jbtnGuardarPaciente) {
            grabarPaciente();
            limpiarcajasPaciente();
            limpiarTabla();
            listarPaciente(vista.jTablePaciente);
        }
        if (e.getSource() == vista.jbtnPaciente) {
            limpiarcajasPaciente();
            limpiarTabla();
            listarPaciente(vista.jTablePaciente);

        }
        if (e.getSource() == vista.jBtnLimpiar) {
            if ("".equals(vista.jtxtDniPac.getText()) || "".equals(vista.jtxtNombrePac.getText())
                    || "".equals(vista.jtxtApelliPatiPac.getText())
                    || "".equals(vista.jtxtApelliMatiPac.getText())
                    || "".equals(vista.jcbxGeneroPac.getSelectedItem())
                    || "".equals(vista.jtxtEdadPac.getText())
                    || "".equals(vista.jtxtTelefPac.getText())
                    || "".equals(vista.jtxtCorreoPac.getText())
                    || "".equals(vista.jcbxSeguroPac.getSelectedItem())
                    || "".equals(((JTextField) vista.jDtFechaNacPac.getDateEditor().getUiComponent()).getText())) {
                JOptionPane.showMessageDialog(null, "Los campos ya estan vacios");

            } else {
                limpiarcajasPaciente();
            }
        }
        if (e.getSource() == vista.jbtnEliminarPaciente) {
            eliminarPaciente();
            limpiarcajasPaciente();
            limpiarTabla();
            listarPaciente(vista.jTablePaciente);
        }
        if (e.getSource() == vista.jbtnEditarPaciente) {
            editarPaciente();
        }

    }

    public void grabarPaciente() {
        if ("".equals(vista.jtxtDniPac.getText()) || "".equals(vista.jtxtNombrePac.getText())
                || "".equals(vista.jtxtApelliPatiPac.getText())
                || "".equals(vista.jtxtApelliMatiPac.getText())
                || "".equals(vista.jcbxGeneroPac.getSelectedItem())
                || "".equals(vista.jtxtEdadPac.getText())
                || "".equals(vista.jtxtTelefPac.getText())
                || "".equals(vista.jtxtCorreoPac.getText())
                || "".equals(vista.jcbxSeguroPac.getSelectedItem())
                || "".equals(((JTextField) vista.jDtFechaNacPac.getDateEditor().getUiComponent()).getText())) {
            JOptionPane.showMessageDialog(null, "Complete datos");

        } else if (!"".equals(vista.jtxtDniPac.getText()) || !"".equals(vista.jtxtNombrePac.getText())
                || !"".equals(vista.jtxtApelliPatiPac.getText())
                || !"".equals(vista.jtxtApelliMatiPac.getText())
                || !"".equals(vista.jcbxGeneroPac.getSelectedItem())
                || !"".equals(vista.jtxtEdadPac.getText())
                || !"".equals(vista.jtxtTelefPac.getText())
                || !"".equals(vista.jtxtCorreoPac.getText())
                || !"".equals(vista.jcbxSeguroPac.getSelectedItem())
                || !"".equals(((JTextField) vista.jDtFechaNacPac.getDateEditor().getUiComponent()).getText())) {
            pac = new paciente();
            modelo = (DefaultTableModel) vista.jTablePaciente.getModel();
            for (int i = 0; i < vista.jTablePaciente.getRowCount(); i++) {
                int dnipac = Integer.parseInt(vista.jtxtDniPac.getText());
                if (vista.jTablePaciente.getValueAt(i, 1).equals(dnipac)) {
                    JOptionPane.showMessageDialog(null, "El paciente ya existe");
                    return;
                } else {
                    pac.setDni_pa(Integer.parseInt(vista.jtxtDniPac.getText()));
                    pac.setNombre_pa(vista.jtxtNombrePac.getText());
                    pac.setApellidopat_pa(vista.jtxtApelliPatiPac.getText());
                    pac.setApellidomat_pa(vista.jtxtApelliMatiPac.getText());
                    pac.setGenero_pa(vista.jcbxGeneroPac.getSelectedItem().toString());
                    pac.setEdad_pa(Integer.parseInt(vista.jtxtEdadPac.getText()));
                    pac.setTelefono_pa(Integer.parseInt(vista.jtxtTelefPac.getText()));
                    pac.setCorreo_pa(vista.jtxtCorreoPac.getText());
                    pac.setSeguro_pa(vista.jcbxSeguroPac.getSelectedItem().toString());
                    pac.setFechanac_pa(Date.valueOf(((JTextField) vista.jDtFechaNacPac.getDateEditor().getUiComponent()).getText()));
                }

            }

            pacdao.guardarPaciente(pac);
            JOptionPane.showMessageDialog(null, "Paciente registrado");
        }
    }

    public void listarPaciente(JTable tabla) {
        modelo = (DefaultTableModel) tabla.getModel();
        List<paciente> ListaPa = pacdao.ListarPaciente();

        Object[] object = new Object[11];
        for (int i = 0; i < ListaPa.size(); i++) {
            object[0] = ListaPa.get(i).getId_paciente();
            object[1] = ListaPa.get(i).getDni_pa();
            object[2] = ListaPa.get(i).getNombre_pa();
            object[3] = ListaPa.get(i).getApellidopat_pa();
            object[4] = ListaPa.get(i).getApellidomat_pa();
            object[5] = ListaPa.get(i).getGenero_pa();
            object[6] = ListaPa.get(i).getEdad_pa();
            object[7] = ListaPa.get(i).getTelefono_pa();
            object[8] = ListaPa.get(i).getCorreo_pa();
            object[9] = ListaPa.get(i).getSeguro_pa();
            object[10] = ListaPa.get(i).getFechanac_pa();
            modelo.addRow(object);
        }
        vista.jTablePaciente.setModel(modelo);

    }

    public void limpiarTabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;

        }
    }

    public void limpiarcajasPaciente() {
        vista.jlabelPaciente.setText("");
        vista.jtxtDniPac.setText("");
        vista.jtxtNombrePac.setText("");
        vista.jtxtApelliPatiPac.setText("");
        vista.jtxtApelliMatiPac.setText("");
        vista.jtxtDniPac.setText("");
        vista.jcbxGeneroPac.setSelectedIndex(0);
        vista.jcbxSeguroPac.setSelectedIndex(0);
        vista.jtxtTelefPac.setText("");
        vista.jtxtCorreoPac.setText("");
        vista.jtxtEdadPac.setText("");
        //Limpiar Caja Fecha Nacimiento
        ((JTextField) vista.jDtFechaNacPac.getDateEditor().getUiComponent()).setText("");//para limpiar jdataChosser

    }

    public void eliminarPaciente() {
        if ("".equals(vista.jlabelPaciente.getText())) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else if (!"".equals(vista.jtxtDniPac.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar?");
            if (pregunta == 0) {
                int id = Integer.parseInt(vista.jtxtDniPac.getText());
                pacdao.deletePaciente(id);

            }
        }

    }

    private void editarPaciente() {
        if ("".equals(vista.jtxtDniPac.getText()) || "".equals(vista.jtxtNombrePac.getText())
                || "".equals(vista.jtxtApelliPatiPac.getText())
                || "".equals(vista.jtxtApelliMatiPac.getText())
                || "".equals(vista.jcbxGeneroPac.getSelectedItem())
                || "".equals(vista.jtxtEdadPac.getText())
                || "".equals(vista.jtxtTelefPac.getText())
                || "".equals(vista.jtxtCorreoPac.getText())
                || "".equals(vista.jcbxSeguroPac.getSelectedItem())
                || "".equals(((JTextField) vista.jDtFechaNacPac.getDateEditor().getUiComponent()).getText())) {
            JOptionPane.showMessageDialog(null, "Campos vacios");

        } else {
            pac.setDni_pa(Integer.parseInt(vista.jtxtDniPac.getText()));
            pac.setNombre_pa(vista.jtxtNombrePac.getText());
            pac.setApellidopat_pa(vista.jtxtApelliPatiPac.getText());
            pac.setApellidomat_pa(vista.jtxtApelliMatiPac.getText());
            pac.setGenero_pa(vista.jcbxGeneroPac.getSelectedItem().toString());
            pac.setEdad_pa(Integer.parseInt(vista.jtxtEdadPac.getText()));
            pac.setTelefono_pa(Integer.parseInt(vista.jtxtTelefPac.getText()));
            pac.setCorreo_pa(vista.jtxtCorreoPac.getText());
            pac.setSeguro_pa(vista.jcbxSeguroPac.getSelectedItem().toString());
            pac.setFechanac_pa(Date.valueOf(((JTextField) vista.jDtFechaNacPac.getDateEditor().getUiComponent()).getText()));
            pac.setId_paciente(Integer.parseInt(vista.jlabelPaciente.getText()));
            if (!"".equals(vista.jtxtDniPac.getText()) || !"".equals(vista.jtxtNombrePac.getText())
                    || !"".equals(vista.jtxtApelliPatiPac.getText())
                    || !"".equals(vista.jtxtApelliMatiPac.getText())
                    || !"".equals(vista.jcbxGeneroPac.getSelectedItem())
                    || !"".equals(vista.jtxtEdadPac.getText())
                    || !"".equals(vista.jtxtTelefPac.getText())
                    || !"".equals(vista.jtxtCorreoPac.getText())
                    || !"".equals(vista.jcbxSeguroPac.getSelectedItem())
                    || !"".equals(((JTextField) vista.jDtFechaNacPac.getDateEditor().getUiComponent()).getText())) {
                pacdao.editarPaciente(pac);
                JOptionPane.showMessageDialog(null, "Paciente modificado");
                limpiarcajasPaciente();
                limpiarTabla();
                listarPaciente(vista.jTablePaciente);
                //JOptionPane.showMessageDialog(null, "Actualizado");
            } else {
                JOptionPane.showMessageDialog(null, "Campos vacios");
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
        if ("".equals(vista.jtxtBuscarPaciente.getText())) {
            vista.jlabelBuscarPaciente.setText("Ingresa solo número");
        } else if (e.getSource() == vista.jtxtBuscarPaciente) {
            int dni = Integer.parseInt(vista.jtxtBuscarPaciente.getText());
            DefaultTableModel modeloB = new DefaultTableModel();
            vista.jTablePaciente.setModel(modeloB);

            modeloB.addColumn("ID"); //solo se creado cada letra que se ingrese
            modeloB.addColumn("DNI");
            modeloB.addColumn("NOMBRE");
            modeloB.addColumn("APELLIDO PATERNO");
            modeloB.addColumn("APELLIDO MATERNO");
            modeloB.addColumn("GENERO");
            modeloB.addColumn("EDAD");
            modeloB.addColumn("TELEFONO");
            modeloB.addColumn("CORREO");
            modeloB.addColumn("SEGURO");
            modeloB.addColumn("FECHA NACIMIENTO");
            //POR SI SE DESEA LIMPIAR LA TABLA CUANDO ESTA VACIO LA CAJA DE TEXTO
            /*if (!"".equals(vistaC.buscarListacliente.getText())) {*/
            Object[] object = new Object[11];
            int numregistros = pacdao.buscarPacienteXDni(dni).size();
            for (int i = 0; i < numregistros; i++) {
                object[0] = pacdao.buscarPacienteXDni(dni).get(i).getId_paciente();
                object[1] = pacdao.buscarPacienteXDni(dni).get(i).getDni_pa();
                object[2] = pacdao.buscarPacienteXDni(dni).get(i).getNombre_pa();
                object[3] = pacdao.buscarPacienteXDni(dni).get(i).getApellidopat_pa();
                object[4] = pacdao.buscarPacienteXDni(dni).get(i).getApellidomat_pa();
                object[5] = pacdao.buscarPacienteXDni(dni).get(i).getGenero_pa();
                object[6] = pacdao.buscarPacienteXDni(dni).get(i).getEdad_pa();
                object[7] = pacdao.buscarPacienteXDni(dni).get(i).getTelefono_pa();
                object[8] = pacdao.buscarPacienteXDni(dni).get(i).getCorreo_pa();
                object[9] = pacdao.buscarPacienteXDni(dni).get(i).getSeguro_pa();
                object[10] = pacdao.buscarPacienteXDni(dni).get(i).getFechanac_pa();
                modeloB.addRow(object);
                vista.jlabelBuscarPaciente.setText("");
            }
        }

    }

}
