package Controlador;

import Modelo.*;
import Vistas.Software;
import java.awt.event.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class horarioController implements ActionListener, KeyListener {

    horario hor = new horario();
    horarioDAO hordao = new horarioDAO();
    Software vista = new Software();
    DefaultTableModel modelo = new DefaultTableModel();

    public horarioController(Software h) {
        this.vista = h;
        this.vista.jbtnGuardarDisponibilidad.addActionListener(this);
        this.vista.jbtnLimpiarDisponibilidad.addActionListener(this);
        this.vista.jbtnEliminarDisponibilidad.addActionListener(this);
        this.vista.jbtnEditarDisponibilidad.addActionListener(this);
        this.vista.jtxtBuscarDisponibilidad.addKeyListener(this);
        this.vista.jbtnHorarios.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.jbtnGuardarDisponibilidad) {
            grabarDisponibilidad();
            limpiarcajas();
            limpiarTabla();
            listarDisponibilidad(vista.jTableDisponibilidad);
        }
        if (e.getSource() == vista.jbtnHorarios) {
            limpiarTabla();
            listarDisponibilidad(vista.jTableDisponibilidad);
            limpiarcajas();
        }
        if (e.getSource() == vista.jbtnLimpiarDisponibilidad) {
            if ("".equals(vista.jcbxDoctorEnHorario.getSelectedItem())
                    || "".equals(vista.jcbxEspecialidadEnHorario.getSelectedItem())
                    || "".equals(((JTextField) vista.jDataFechaHorario.getDateEditor().getUiComponent()).getText())
                    || "".equals(vista.jcbxHoraHorario.getSelectedItem())) {
                JOptionPane.showMessageDialog(null, "Los campos ya estan vacios");
            } else {
                limpiarcajas();
            }
        }
        if (e.getSource() == vista.jbtnEliminarDisponibilidad) {
            eliminarDisponibilidad();
            limpiarcajas();
            limpiarTabla();
            listarDisponibilidad(vista.jTableDisponibilidad);

        }
        if (e.getSource() == vista.jbtnEditarDisponibilidad) {
            editarDisponibilidad();

        }
    }

    private void grabarDisponibilidad() {
        if ("".equals(vista.jcbxDoctorEnHorario.getSelectedItem())
                || "".equals(vista.jcbxEspecialidadEnHorario.getSelectedItem())
                || "".equals(((JTextField) vista.jDataFechaHorario.getDateEditor().getUiComponent()).getText())
                || "".equals(vista.jcbxHoraHorario.getSelectedItem())) {
            JOptionPane.showMessageDialog(null, "Complete datos");
        } else if (!"".equals(vista.jcbxDoctorEnHorario.getSelectedItem())
                || !"".equals(vista.jcbxEspecialidadEnHorario.getSelectedItem())
                || !"".equals(((JTextField) vista.jDataFechaHorario.getDateEditor().getUiComponent()).getText())
                || !"".equals(vista.jcbxHoraHorario.getSelectedItem())) {

            hor = new horario();
            hor.setNom_doctor(vista.jcbxDoctorEnHorario.getSelectedItem().toString());
            hor.setEspecialidad(vista.jcbxEspecialidadEnHorario.getSelectedItem().toString());
            hor.setFecha_dispo(Date.valueOf(((JTextField) vista.jDataFechaHorario.getDateEditor().getUiComponent()).getText()));
            hor.setHora_dispo(Time.valueOf(vista.jcbxHoraHorario.getSelectedItem().toString()));
            hordao.guardarHorario(hor);
            JOptionPane.showMessageDialog(null, "Horario registrado");
        }
    }

    public void listarDisponibilidad(JTable tabla) {
        modelo = (DefaultTableModel) tabla.getModel();
        List<horario> ListaDis = hordao.ListarDisponibilidad(); // lista para la cantidad de usuarios

        Object[] object = new Object[5]; // la cantida de datos de cada usuario
        for (int i = 0; i < ListaDis.size(); i++) {
            object[0] = ListaDis.get(i).getId_dispo();
            object[1] = ListaDis.get(i).getNom_doctor();
            object[2] = ListaDis.get(i).getEspecialidad();
            object[3] = ListaDis.get(i).getFecha_dispo();
            object[4] = ListaDis.get(i).getHora_dispo();
            modelo.addRow(object);
        }
        vista.jTableDisponibilidad.setModel(modelo);

    }

    public void limpiarTabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;

        }
    }

    public void limpiarcajas() {
        vista.jcbxHoraHorario.setSelectedIndex(0);
        ((JTextField) vista.jDataFechaHorario.getDateEditor().getUiComponent()).setText("");
    }

    public void eliminarDisponibilidad() {
        if ("".equals(vista.jLabelDisponibilidad.getText())) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else if (!"".equals(vista.jLabelDisponibilidad.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar?");
            if (pregunta == 0) {
                int id_dis = Integer.parseInt(vista.jLabelDisponibilidad.getText());
                hordao.deleteDisponibilidad(id_dis);
            }
        }

    }

    public void editarDisponibilidad() {
        if ("".equals(vista.jcbxDoctorEnHorario.getSelectedItem())
                || "".equals(vista.jcbxEspecialidadEnHorario.getSelectedItem())
                || "".equals(((JTextField) vista.jDataFechaHorario.getDateEditor().getUiComponent()).getText())
                || "".equals(vista.jcbxHoraHorario.getSelectedItem())) {
            JOptionPane.showMessageDialog(null, "Campos vacios");
        } else {
            hor.setNom_doctor(vista.jcbxDoctorEnHorario.getSelectedItem().toString());
            hor.setEspecialidad(vista.jcbxEspecialidadEnHorario.getSelectedItem().toString());
            String fecha_dis = ((JTextField) vista.jDataFechaHorario.getDateEditor().getUiComponent()).getText();
            hor.setFecha_dispo(Date.valueOf(fecha_dis));
            hor.setHora_dispo(Time.valueOf(vista.jcbxHoraHorario.getSelectedItem().toString()));
            hor.setId_dispo(Integer.parseInt(vista.jLabelDisponibilidad.getText()));
            if (!"".equals(vista.jcbxDoctorEnHorario.getSelectedItem().toString()) || !"".equals(vista.jcbxEspecialidadEnHorario.getSelectedItem().toString())
                    || !"".equals(fecha_dis) || !"".equals(vista.jcbxHoraHorario.getSelectedItem())) {
                hordao.acutalizarDisponibilidad(hor);
                JOptionPane.showMessageDialog(null, "Horario Modificado");
                limpiarcajas();
                limpiarTabla();
                listarDisponibilidad(vista.jTableDisponibilidad);
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
        if (e.getSource() == vista.jtxtBuscarDisponibilidad) {
            String especialidad = vista.jtxtBuscarDisponibilidad.getText();
            DefaultTableModel modeloB = new DefaultTableModel();
            vista.jTableDisponibilidad.setModel(modeloB);

            modeloB.addColumn("ID"); //solo se creado cada letra que se ingrese
            modeloB.addColumn("DOCTOR");
            modeloB.addColumn("ESPECIALIDAD");
            modeloB.addColumn("FECHA");
            modeloB.addColumn("HORA");
            //POR SI SE DESEA LIMPIAR LA TABLA CUANDO ESTA VACIO LA CAJA DE TEXTO
            //if (!"".equals(vistaC.buscarListacliente.getText())) {/
            Object[] object = new Object[5];
            int numregistros = hordao.buscarDisponibilidadXEspecialidad(especialidad).size();
            for (int i = 0; i < numregistros; i++) {
                object[0] = hordao.buscarDisponibilidadXEspecialidad(especialidad).get(i).getId_dispo();
                object[1] = hordao.buscarDisponibilidadXEspecialidad(especialidad).get(i).getNom_doctor();
                object[2] = hordao.buscarDisponibilidadXEspecialidad(especialidad).get(i).getEspecialidad();
                object[3] = hordao.buscarDisponibilidadXEspecialidad(especialidad).get(i).getFecha_dispo();
                object[4] = hordao.buscarDisponibilidadXEspecialidad(especialidad).get(i).getHora_dispo();
                modeloB.addRow(object);
            }

            /* }else{
                limpiarTabla();
            }*/
        }
    }

}
