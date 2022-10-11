package Controlador;

import Modelo.*;
import Vistas.Software;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class citaController implements ActionListener {

    cita ci = new cita();
    citaDAO cidao = new citaDAO();
    paciente pac = new paciente();
    pacienteDAO pacdao = new pacienteDAO();

    Software vista = new Software();
    DefaultTableModel modelo = new DefaultTableModel();

    public citaController(Software v) {
        this.vista = v;
        this.vista.jbtnBuscarPacienteCita.addActionListener(this);
        this.vista.jbtnEnviarYfactura.addActionListener(this);
        this.vista.jbtnLimpiarCita.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.jbtnBuscarPacienteCita) {

            completarPaciente();
            
        }

        if (e.getSource() == vista.jbtnEnviarYfactura) {
            guardarCita();
            limpiascajasCita();
        }

        if (e.getSource() == vista.jbtnLimpiarCita) {
            if ("".equals(vista.jtxtDniPacienteCita.getText()) || "".equals(vista.jtxtNombrePacienteCita.getText())
                    || "".equals(vista.jtxtApellidoPaPacienteCita.getText())
                    || "".equals(vista.jtxtApellidoMaPaCita.getText())
                    || "".equals(vista.jcbxGeneroPacienteCita.getSelectedItem())
                    || "".equals(vista.jtxtEdadPacienteCita.getText())
                    || "".equals(((JTextField) vista.jDateFechaNacPacienteCita.getDateEditor().getUiComponent()).getText())
                    || "".equals(vista.jtxtTelefonoPacienteCita.getText())
                    || "".equals(vista.jtxtCorreoPacienteCita.getText())
                    || "".equals(vista.jtxtSeguroPacienteCita.getText())
                    || "".equals(vista.jcbxEspecialidadCita.getSelectedItem())
                    || "".equals(vista.jcbxDocCita.getSelectedItem())
                    || "".equals(vista.jcbxFechaCita.getSelectedItem())
                    || "".equals(vista.jcbxHoraCita.getSelectedItem())
                    || "".equals(vista.jtxtDescripcion.getText())) {
                JOptionPane.showMessageDialog(null, "Campos vacios");
            } else {
                limpiascajasCita();
            }
        }

    }

    public void completarPaciente() {
        if (!"".equals(vista.jtxtDniPacienteCita.getText())) {
            int dni = Integer.parseInt(vista.jtxtDniPacienteCita.getText());
            pac = pacdao.buscarPacienteCita(dni);

            if (pac.getNombre_pa() != null) {
                vista.jtxtNombrePacienteCita.setText("" + pac.getNombre_pa());
                vista.jtxtApellidoPaPacienteCita.setText("" + pac.getApellidopat_pa());
                vista.jtxtApellidoMaPaCita.setText("" + pac.getApellidomat_pa());
                vista.jcbxGeneroPacienteCita.setSelectedItem("" + pac.getGenero_pa());
                vista.jtxtEdadPacienteCita.setText("" + pac.getEdad_pa());
                vista.jtxtTelefonoPacienteCita.setText("" + pac.getTelefono_pa());
                vista.jtxtCorreoPacienteCita.setText("" + pac.getCorreo_pa());
                vista.jtxtSeguroPacienteCita.setText("" + pac.getSeguro_pa());
                vista.jDateFechaNacPacienteCita.setDate(pac.getFechanac_pa());

            } else {
                vista.jtxtNombrePacienteCita.setText("");
                vista.jtxtApelliPatiPac.setText("");
                vista.jtxtApelliMatiPac.setText("");
                vista.jcbxGeneroPacienteCita.setSelectedItem("");
                vista.jtxtEdadPacienteCita.setText("");
                vista.jtxtTelefonoPacienteCita.setText("");
                vista.jtxtCorreoPacienteCita.setText("");
                vista.jtxtSeguroPacienteCita.setText("");
                //vista.jDateFechaNacPacienteCita.setDate();

                JOptionPane.showMessageDialog(null, "No existe el paciente");

            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese dni del paciente");
            vista.jtxtDniPacienteCita.requestFocus();
        }
    }

    public void guardarCita() {
        if ("".equals(vista.jtxtDniPacienteCita.getText()) || "".equals(vista.jtxtNombrePacienteCita.getText())
                || "".equals(vista.jtxtApellidoPaPacienteCita.getText())
                || "".equals(vista.jtxtApellidoMaPaCita.getText())
                || "".equals(vista.jcbxGeneroPacienteCita.getSelectedItem())
                || "".equals(vista.jtxtEdadPacienteCita.getText())
                || "".equals(((JTextField) vista.jDateFechaNacPacienteCita.getDateEditor().getUiComponent()).getText())
                || "".equals(vista.jtxtTelefonoPacienteCita.getText())
                || "".equals(vista.jtxtCorreoPacienteCita.getText())
                || "".equals(vista.jtxtSeguroPacienteCita.getText())
                || "".equals(vista.jcbxEspecialidadCita.getSelectedItem())
                || "".equals(vista.jcbxDocCita.getSelectedItem())
                || "".equals(vista.jcbxFechaCita.getSelectedItem())
                || "".equals(vista.jcbxHoraCita.getSelectedItem())
                || "".equals(vista.jtxtDescripcion.getText())) {
            JOptionPane.showMessageDialog(null, "Complete datos");
        } else if (!"".equals(vista.jtxtDniPacienteCita.getText()) || !"".equals(vista.jtxtNombrePacienteCita.getText())
                || !"".equals(vista.jtxtApellidoPaPacienteCita.getText())
                || !"".equals(vista.jtxtApellidoMaPaCita.getText())
                || !"".equals(vista.jcbxGeneroPacienteCita.getSelectedItem())
                || !"".equals(vista.jtxtEdadPacienteCita.getText())
                || !"".equals(((JTextField) vista.jDateFechaNacPacienteCita.getDateEditor().getUiComponent()).getText())
                || !"".equals(vista.jtxtTelefonoPacienteCita.getText())
                || !"".equals(vista.jtxtCorreoPacienteCita.getText())
                || !"".equals(vista.jtxtSeguroPacienteCita.getText())
                || !"".equals(vista.jcbxEspecialidadCita.getSelectedItem())
                || !"".equals(vista.jcbxDocCita.getSelectedItem())
                || !"".equals(vista.jcbxFechaCita.getSelectedItem())
                || !"".equals(vista.jcbxHoraCita.getSelectedItem())
                || !"".equals(vista.jtxtDescripcion.getText())) {
            ci = new cita();
            ci.setDni_paciente(Integer.parseInt(vista.jtxtDniPacienteCita.getText()));
            ci.setNombre_paciente(vista.jtxtNombrePacienteCita.getText());
            ci.setApellido_paterno(vista.jtxtApellidoPaPacienteCita.getText());
            ci.setApellido_materno(vista.jtxtApellidoMaPaCita.getText());
            ci.setGenero_paciente(vista.jcbxGeneroPacienteCita.getSelectedItem().toString());
            ci.setEdad_paciente(Integer.parseInt(vista.jtxtEdadPacienteCita.getText()));
            ci.setFecha_nacimiento(Date.valueOf(((JTextField) vista.jDateFechaNacPacienteCita.getDateEditor().getUiComponent()).getText()));
            ci.setFecha_cita(Date.valueOf(vista.jcbxFechaCita.getSelectedItem().toString()));
            ci.setHora_cita(Time.valueOf(vista.jcbxHoraCita.getSelectedItem().toString()));
            ci.setTelefono_paciente(Integer.parseInt(vista.jtxtTelefonoPacienteCita.getText()));
            ci.setCorreo_paciente(vista.jtxtCorreoPacienteCita.getText());
            ci.setSeguro_paciente(vista.jtxtSeguroPacienteCita.getText());
            ci.setNombre_doctor(vista.jcbxDocCita.getSelectedItem().toString());
            ci.setEspecialidad(vista.jcbxEspecialidadCita.getSelectedItem().toString());
            ci.setDescripcion_cita(vista.jtxtDescripcion.getText());
            ci.setUsuario(vista.jlabelIngreso.getText());

            cidao.guardarCita(ci);
            JOptionPane.showMessageDialog(null, "¡¡Cita registrada exitosa!!");
        }
    }

    public void limpiascajasCita() {
        vista.jtxtDniPacienteCita.setText("");
        vista.jtxtNombrePacienteCita.setText("");
        vista.jtxtApellidoPaPacienteCita.setText("");
        vista.jtxtApellidoMaPaCita.setText("");
        vista.jcbxGeneroPacienteCita.setSelectedIndex(0);
        vista.jtxtEdadPacienteCita.setText("");
        ((JTextField) vista.jDateFechaNacPacienteCita.getDateEditor().getUiComponent()).setText("");
        vista.jcbxFechaCita.setSelectedItem(0);
        vista.jcbxHoraCita.setSelectedIndex(0);
        vista.jtxtTelefonoPacienteCita.setText("");
        vista.jtxtCorreoPacienteCita.setText("");
        vista.jtxtSeguroPacienteCita.setText("");
        vista.jcbxDocCita.setSelectedIndex(0);
        vista.jcbxEspecialidadCita.setSelectedIndex(0);
        vista.jtxtDescripcion.setText("");
        vista.jlabelIngreso.setText("");

    }

}
