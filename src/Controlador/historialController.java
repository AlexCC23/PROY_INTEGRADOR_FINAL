package Controlador;

import Modelo.*;

import Vistas.Software;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class historialController implements ActionListener {

    cita ci = new cita();
    citaDAO cidao = new citaDAO();
    Software vista = new Software();
    DefaultTableModel modelo = new DefaultTableModel();

    public historialController(Software h) {
        this.vista = h;
        this.vista.jbtnEliminarHisto.addActionListener(this);
        this.vista.jbtnHistorial.addActionListener(this);
        this.vista.jbtnExcelHistorial.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.jbtnHistorial) {
            limpiarTabla();
            listarHistorial(vista.jTableHistorialCita);
        }

        if (e.getSource() == vista.jbtnEliminarHisto) {
            eliminarHistorialCita();
            limpiarTabla();
            listarHistorial(vista.jTableHistorialCita);
        }
    }

    public void listarHistorial(JTable tabla) {
        modelo = (DefaultTableModel) tabla.getModel();
        List<cita> ListaCitaH = cidao.listarCitaH();

        Object[] object = new Object[8];
        for (int i = 0; i < ListaCitaH.size(); i++) {
            object[0] = ListaCitaH.get(i).getId_cita();
            object[1] = ListaCitaH.get(i).getNombre_paciente();
            object[2] = ListaCitaH.get(i).getNombre_doctor();
            object[3] = ListaCitaH.get(i).getEspecialidad();
            object[4] = ListaCitaH.get(i).getFecha_cita();
            object[5] = ListaCitaH.get(i).getHora_cita();
            object[6] = ListaCitaH.get(i).getUsuario();
            object[7] = ListaCitaH.get(i).getFecha_regis();

            modelo.addRow(object);
        }
        vista.jTableHistorialCita.setModel(modelo);

    }

    public void eliminarHistorialCita() {
        if ("".equals(vista.jLabelHistorial.getText())) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else {
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar?");
            if (pregunta == 0) {
                int id = Integer.parseInt(vista.jLabelHistorial.getText());
                cidao.deleteCitaH(id);

            }
        }

    }

    public void limpiarTabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;

        }
    }

}
