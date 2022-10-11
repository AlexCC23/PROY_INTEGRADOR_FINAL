/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controlador.citaController;
import Controlador.doctorController;
import Controlador.especialidadController;
import Controlador.historialController;
import Controlador.horarioController;
import Controlador.loginController;
import Controlador.pacienteController;
import Controlador.usuarioController;
import Modelo.citaDAO;
import Modelo.especialidad;
import Modelo.especialidadDAO;
import Modelo.horario;
import Modelo.horarioDAO;
import Modelo.medico;
import Modelo.medicoDAO;
import Reporte.Excel;
import java.awt.Color;
import static java.awt.Color.white;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.List;
import javax.swing.Icon;
import javax.swing.JOptionPane;

/**
 *
 * @author Sebastian
 */
public class Software extends javax.swing.JFrame {

    public Software() {
        initComponents();
        jlabelPaciente.setVisible(false);
        jlabelespecialidad.setVisible(false);
        jlabelUsuario.setVisible(false);
        jlabelMedico.setVisible(false);
        jLabelDisponibilidad.setVisible(false);
        jLabelHistorial.setVisible(false);
//       llenarDoctorEspecialidadCita();

        llenarDoctoEnHorario();
        llenarEspecialidad();
        llenarEspecialidadEnCita();
        llenarEspecialidadenDoctor();
//        llenarFechHorDoc();

        this.setLocationRelativeTo(null);
    }

    //LENNAR CBX EN LA VISTA CITA EL DOCTOR SEGUN LA ESPECIALIDAD
    public void llenarDoctorEspecialidadCita() {
        citaDAO cidao = new citaDAO();
        horario hor = new horario();
        String nombre_esp = jcbxEspecialidadCita.getSelectedItem().toString();
        List<horario> ListaEspMedCi = cidao.listarEnCitaDocSegunEspecialidad(nombre_esp);
        jcbxDocCita.removeAllItems();

        for (int i = 0; i < ListaEspMedCi.size(); i++) {
            jcbxDocCita.addItem(ListaEspMedCi.get(i).getNom_doctor());

        }
    }

//LLENAR CBX EN LA VISTA CITA LA FECHA Y HORA SEGUN DOCTOR
    public void llenarFechHorDoc() {
        citaDAO cidao = new citaDAO();
        horario hor = new horario();
        
        String nombr_do = jcbxDocCita.getSelectedItem().toString();
        List<horario> ListaFechHDoc = cidao.listarEnCitaFechHorSegunDoc(nombr_do);
        jcbxFechaCita.removeAllItems();
        jcbxHoraCita.removeAllItems();

        for (int i = 0; i < ListaFechHDoc.size(); i++) {
            jcbxFechaCita.addItem(ListaFechHDoc.get(i).getFecha_dispo().toString());
            jcbxHoraCita.addItem(ListaFechHDoc.get(i).getHora_dispo().toString());
            

        }
    }
    //LLENAR CBX EN LA VISTA HORARIO LA ESPECIALIDAD SEGUN EL DOCTOR
    public void llenarEspecialidad() {
        horarioDAO hordao = new horarioDAO();
        medico me = new medico();
        String nombre_doc = jcbxDoctorEnHorario.getSelectedItem().toString();
        List<medico> ListaEspMed = hordao.listarEnHorarioSegunDoctor(nombre_doc);
        jcbxEspecialidadEnHorario.removeAllItems();

        for (int i = 0; i < ListaEspMed.size(); i++) {
            jcbxEspecialidadEnHorario.addItem(ListaEspMed.get(i).getEspecialidad());

        }
    }

    //LLENAR CBX EN LA VISTA CITA LA ESPECIALIDAD
    public void llenarEspecialidadEnCita() {
        especialidadDAO especialdao = new especialidadDAO();
        especialidad esp = new especialidad();
        List<especialidad> ListaEsCi = especialdao.ListarEsspecialidad();
        jcbxEspecialidadCita.removeAllItems();

        for (int i = 0; i < ListaEsCi.size(); i++) {
            jcbxEspecialidadCita.addItem(ListaEsCi.get(i).getNom_espec());
        }
    }

    //LLENAR CBX EN LA VISTA HORARIO EL DOCTOR
    public void llenarDoctoEnHorario() {
        horarioDAO hodao = new horarioDAO();
        medico med = new medico();
        List<medico> ListaMedHor = hodao.ListarDoctorEnHorario();
        jcbxDoctorEnHorario.removeAllItems();

        for (int i = 0; i < ListaMedHor.size(); i++) {
            jcbxDoctorEnHorario.addItem(ListaMedHor.get(i).getNombre_medico());
        }
    }

    //LLENAR CBX EN LA VISTA DOCTOR LA ESPECIALIDAD
    public void llenarEspecialidadenDoctor() {
        especialidadDAO esdao = new especialidadDAO();
        especialidad es = new especialidad();
        List<especialidad> ListaEspe = esdao.ListarEsspecialidad();
        jcbxEspecialidadDoctor.removeAllItems();

        for (int i = 0; i < ListaEspe.size(); i++) {
            jcbxEspecialidadDoctor.addItem(ListaEspe.get(i).getNom_espec());
        }
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("img/ICONO.png"));
        return retValue;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jtxtTelefonoPacienteCita = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jcbxEspecialidadCita = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jbtnBuscarPacienteCita = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jbtnEnviarYfactura = new javax.swing.JButton();
        jbtnLimpiarCita = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jcbxGeneroPacienteCita = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jDateFechaNacPacienteCita = new com.toedter.calendar.JDateChooser();
        jtxtDniPacienteCita = new javax.swing.JTextField();
        jtxtNombrePacienteCita = new javax.swing.JTextField();
        jtxtApellidoPaPacienteCita = new javax.swing.JTextField();
        jtxtApellidoMaPaCita = new javax.swing.JTextField();
        jtxtCorreoPacienteCita = new javax.swing.JTextField();
        jtxtEdadPacienteCita = new javax.swing.JTextField();
        jcbxHoraCita = new javax.swing.JComboBox<>();
        jtxtDescripcion = new java.awt.TextArea();
        jtxtSeguroPacienteCita = new javax.swing.JLabel();
        jcbxDocCita = new javax.swing.JComboBox<>();
        jcbxFechaCita = new javax.swing.JComboBox<>();
        labelErrorCita1 = new javax.swing.JLabel();
        labelErrorCita2 = new javax.swing.JLabel();
        labelErrorCita3 = new javax.swing.JLabel();
        labelErrorCita4 = new javax.swing.JLabel();
        labelErrorCita5 = new javax.swing.JLabel();
        labelErrorCita6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jtxtDniDoctor = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jtxtNomDoctor = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jtxtApelliDoctor = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jcbxEspecialidadDoctor = new javax.swing.JComboBox<>();
        jbtnGuardarDoctor = new javax.swing.JButton();
        jbtnLimpiarDoctor = new javax.swing.JButton();
        jbtnEliminarDoctor = new javax.swing.JButton();
        jtxtBuscarDoctor = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablaDoctor = new javax.swing.JTable();
        jbtnEditarDoctor = new javax.swing.JButton();
        jlabelMedico = new javax.swing.JLabel();
        jlabelErrorBuscar = new javax.swing.JLabel();
        labelerror2 = new javax.swing.JLabel();
        labelerror3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jtxtDniPac = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTablePaciente = new javax.swing.JTable();
        jtxtNombrePac = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jtxtApelliPatiPac = new javax.swing.JTextField();
        jtxtApelliMatiPac = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jcbxGeneroPac = new javax.swing.JComboBox<>();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jDtFechaNacPac = new com.toedter.calendar.JDateChooser();
        jLabel27 = new javax.swing.JLabel();
        jtxtTelefPac = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jtxtCorreoPac = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jcbxSeguroPac = new javax.swing.JComboBox<>();
        jbtnGuardarPaciente = new javax.swing.JButton();
        jBtnLimpiar = new javax.swing.JButton();
        jbtnEliminarPaciente = new javax.swing.JButton();
        jbtnEditarPaciente = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        jtxtBuscarPaciente = new javax.swing.JTextField();
        jtxtEdadPac = new javax.swing.JTextField();
        jlabelPaciente = new javax.swing.JLabel();
        jlabelBuscarPaciente = new javax.swing.JLabel();
        labelerror5 = new javax.swing.JLabel();
        labelerror6 = new javax.swing.JLabel();
        labelerror7 = new javax.swing.JLabel();
        labelerror8 = new javax.swing.JLabel();
        labelerror9 = new javax.swing.JLabel();
        labelerror10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTablaEspecialidad = new javax.swing.JTable();
        jLabel31 = new javax.swing.JLabel();
        jtxtespecialidad = new javax.swing.JTextField();
        jbtnGuardarEspecialidad = new javax.swing.JButton();
        jbtnLimpiarEspecialidad = new javax.swing.JButton();
        jbtnEliminarEspecialidad = new javax.swing.JButton();
        jbtnEditarEspecialidad = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jtxtBuscarEspecialidad = new javax.swing.JTextField();
        jlabelespecialidad = new javax.swing.JLabel();
        labelerror11 = new javax.swing.JLabel();
        labelerror12 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableHistorialCita = new javax.swing.JTable();
        jLabel33 = new javax.swing.JLabel();
        jbtnEliminarHisto = new javax.swing.JButton();
        jbtnExcelHistorial = new javax.swing.JButton();
        jLabelHistorial = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableDisponibilidad = new javax.swing.JTable();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jDataFechaHorario = new com.toedter.calendar.JDateChooser();
        jLabel47 = new javax.swing.JLabel();
        jcbxHoraHorario = new javax.swing.JComboBox<>();
        jLabel49 = new javax.swing.JLabel();
        jtxtBuscarDisponibilidad = new javax.swing.JTextField();
        jbtnGuardarDisponibilidad = new javax.swing.JButton();
        jbtnLimpiarDisponibilidad = new javax.swing.JButton();
        jbtnEliminarDisponibilidad = new javax.swing.JButton();
        jbtnEditarDisponibilidad = new javax.swing.JButton();
        jcbxDoctorEnHorario = new javax.swing.JComboBox<>();
        jcbxEspecialidadEnHorario = new javax.swing.JComboBox<>();
        jLabel55 = new javax.swing.JLabel();
        jLabelDisponibilidad = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTableUsuario = new javax.swing.JTable();
        jtxtUsuarioUsu = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jtxtContraseñaUsu = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jtxtNombreUsu = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        buscarUsuario = new javax.swing.JTextField();
        jbtnGuardarUsuario = new javax.swing.JButton();
        jbtnLimpiarU = new javax.swing.JButton();
        jbtnEliminarU = new javax.swing.JButton();
        jbtnEditarU = new javax.swing.JButton();
        jlabelUsuario = new javax.swing.JLabel();
        jcbxRolUsu = new javax.swing.JComboBox<>();
        labelErrorUsuario = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jlabelIngreso = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jbtnColsultaMedica = new javax.swing.JButton();
        jbtnPaciente = new javax.swing.JButton();
        jbtnDoctores = new javax.swing.JButton();
        jbtnEspecialidad = new javax.swing.JButton();
        jbtnHistorial = new javax.swing.JButton();
        jbtnHorarios = new javax.swing.JButton();
        jbtnUsuarios = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jbtnSalir = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/portada.jpg"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 840, 180));

        jPanel11.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 850, 4));

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Datos del Paciente ");

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel7.setText("DNI");

        jLabel8.setText("Nombres");

        jLabel13.setText("Apellido Paterno");

        jLabel14.setText("Apellido Materno");

        jLabel15.setText("Edad");

        jLabel16.setText("Fecha de Nacimiento");

        jLabel17.setText("Teléfono");

        jtxtTelefonoPacienteCita.setBackground(new java.awt.Color(204, 255, 255));
        jtxtTelefonoPacienteCita.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jtxtTelefonoPacienteCita.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtTelefonoPacienteCitaKeyTyped(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Datos de la Cita");

        jLabel20.setText("Doctor");

        jLabel21.setText("Especialidad");

        jcbxEspecialidadCita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbxEspecialidadCitaMouseClicked(evt);
            }
        });

        jLabel22.setText("Hora");

        jbtnBuscarPacienteCita.setBackground(new java.awt.Color(0, 51, 102));
        jbtnBuscarPacienteCita.setForeground(new java.awt.Color(255, 255, 255));
        jbtnBuscarPacienteCita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONO3.png"))); // NOI18N

        jLabel18.setText("Correo Electrónico");

        jbtnEnviarYfactura.setBackground(new java.awt.Color(0, 51, 102));
        jbtnEnviarYfactura.setForeground(new java.awt.Color(255, 255, 255));
        jbtnEnviarYfactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONO1.png"))); // NOI18N
        jbtnEnviarYfactura.setText("ENVIAR");

        jbtnLimpiarCita.setBackground(new java.awt.Color(0, 51, 102));
        jbtnLimpiarCita.setForeground(new java.awt.Color(255, 255, 255));
        jbtnLimpiarCita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONO2.png"))); // NOI18N
        jbtnLimpiarCita.setText("LIMPIAR");

        jLabel23.setText("Genero");

        jcbxGeneroPacienteCita.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));

        jLabel24.setText("Fecha Cita");

        jLabel39.setText("Seguro");

        jDateFechaNacPacienteCita.setDateFormatString("yyyy-MM-dd");

        jtxtDniPacienteCita.setBackground(new java.awt.Color(204, 255, 255));
        jtxtDniPacienteCita.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jtxtDniPacienteCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtDniPacienteCitaActionPerformed(evt);
            }
        });
        jtxtDniPacienteCita.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtDniPacienteCitaKeyTyped(evt);
            }
        });

        jtxtNombrePacienteCita.setBackground(new java.awt.Color(204, 255, 255));
        jtxtNombrePacienteCita.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jtxtNombrePacienteCita.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtNombrePacienteCitaKeyTyped(evt);
            }
        });

        jtxtApellidoPaPacienteCita.setBackground(new java.awt.Color(204, 255, 255));
        jtxtApellidoPaPacienteCita.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jtxtApellidoPaPacienteCita.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtApellidoPaPacienteCitaKeyTyped(evt);
            }
        });

        jtxtApellidoMaPaCita.setBackground(new java.awt.Color(204, 255, 255));
        jtxtApellidoMaPaCita.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jtxtApellidoMaPaCita.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtApellidoMaPaCitaKeyTyped(evt);
            }
        });

        jtxtCorreoPacienteCita.setBackground(new java.awt.Color(204, 255, 255));
        jtxtCorreoPacienteCita.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        jtxtEdadPacienteCita.setBackground(new java.awt.Color(204, 255, 255));
        jtxtEdadPacienteCita.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jtxtEdadPacienteCita.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtEdadPacienteCitaKeyTyped(evt);
            }
        });

        jcbxHoraCita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbxHoraCitaMouseClicked(evt);
            }
        });

        jtxtSeguroPacienteCita.setText("No");

        jcbxDocCita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbxDocCitaMouseClicked(evt);
            }
        });
        jcbxDocCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbxDocCitaActionPerformed(evt);
            }
        });

        jcbxFechaCita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbxFechaCitaMouseClicked(evt);
            }
        });

        labelErrorCita1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        labelErrorCita1.setForeground(new java.awt.Color(204, 0, 0));

        labelErrorCita2.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        labelErrorCita2.setForeground(new java.awt.Color(204, 0, 0));

        labelErrorCita3.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        labelErrorCita3.setForeground(new java.awt.Color(204, 0, 0));

        labelErrorCita4.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        labelErrorCita4.setForeground(new java.awt.Color(204, 0, 0));

        labelErrorCita5.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        labelErrorCita5.setForeground(new java.awt.Color(204, 0, 0));

        labelErrorCita6.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        labelErrorCita6.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jtxtDniPacienteCita, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jbtnBuscarPacienteCita, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel7)
                                            .addComponent(labelErrorCita1))
                                        .addGap(14, 14, 14)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtxtNombrePacienteCita)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(labelErrorCita2)
                                                    .addComponent(jLabel8))
                                                .addGap(0, 0, Short.MAX_VALUE))))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel21)
                                                    .addComponent(jDateFechaNacPacienteCita, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel19))
                                                .addGap(10, 10, 10))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jcbxEspecialidadCita, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtxtTelefonoPacienteCita)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(21, 21, 21))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel20)
                                                    .addComponent(jcbxDocCita, 0, 123, Short.MAX_VALUE)
                                                    .addComponent(labelErrorCita5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(0, 0, Short.MAX_VALUE)))))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(jtxtCorreoPacienteCita, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(166, 166, 166))
                                        .addComponent(labelErrorCita3)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel24)
                                            .addGap(81, 81, 81)
                                            .addComponent(jLabel22)))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addGap(1, 1, 1)
                                                    .addComponent(jtxtApellidoPaPacienteCita, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel18))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel14)
                                                        .addComponent(labelErrorCita6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                    .addGap(68, 68, 68))
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jtxtEdadPacienteCita, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel15))
                                                            .addGap(27, 27, 27)
                                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jtxtSeguroPacienteCita, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addComponent(labelErrorCita4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jtxtApellidoMaPaCita, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jcbxFechaCita, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jcbxHoraCita, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, Short.MAX_VALUE))))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23)
                                    .addComponent(jcbxGeneroPacienteCita, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(292, 292, 292))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jtxtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtnEnviarYfactura, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnLimpiarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtNombrePacienteCita)
                            .addComponent(jtxtApellidoPaPacienteCita)
                            .addComponent(jcbxGeneroPacienteCita, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtxtApellidoMaPaCita, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbtnBuscarPacienteCita)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel14)
                                        .addComponent(jLabel7)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxtDniPacienteCita, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelErrorCita1)
                        .addComponent(labelErrorCita2)
                        .addComponent(labelErrorCita3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(labelErrorCita4, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel39)
                    .addComponent(jLabel18)
                    .addComponent(jLabel16)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtxtSeguroPacienteCita, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtxtCorreoPacienteCita, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                        .addComponent(jtxtEdadPacienteCita, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtxtTelefonoPacienteCita)
                    .addComponent(jDateFechaNacPacienteCita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelErrorCita6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelErrorCita5, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel20)
                    .addComponent(jLabel24)
                    .addComponent(jLabel22))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbxHoraCita, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcbxEspecialidadCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcbxDocCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcbxFechaCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jbtnEnviarYfactura)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnLimpiarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtxtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62))
        );

        jTabbedPane1.addTab("tab1", jPanel2);

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));

        jLabel26.setText("DNI");

        jtxtDniDoctor.setBackground(new java.awt.Color(204, 255, 255));
        jtxtDniDoctor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jtxtDniDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtDniDoctorActionPerformed(evt);
            }
        });
        jtxtDniDoctor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtDniDoctorKeyTyped(evt);
            }
        });

        jLabel28.setText("Nombre");

        jtxtNomDoctor.setBackground(new java.awt.Color(204, 255, 255));
        jtxtNomDoctor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jtxtNomDoctor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtNomDoctorKeyTyped(evt);
            }
        });

        jLabel29.setText("Apellidos");

        jtxtApelliDoctor.setBackground(new java.awt.Color(204, 255, 255));
        jtxtApelliDoctor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        jLabel30.setText("Especialidad");

        jcbxEspecialidadDoctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbxEspecialidadDoctorMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jcbxEspecialidadDoctorMousePressed(evt);
            }
        });

        jbtnGuardarDoctor.setBackground(new java.awt.Color(0, 51, 102));
        jbtnGuardarDoctor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONO1.png"))); // NOI18N

        jbtnLimpiarDoctor.setBackground(new java.awt.Color(0, 51, 102));
        jbtnLimpiarDoctor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONO2.png"))); // NOI18N

        jbtnEliminarDoctor.setBackground(new java.awt.Color(0, 51, 102));
        jbtnEliminarDoctor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONO4.png"))); // NOI18N
        jbtnEliminarDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEliminarDoctorActionPerformed(evt);
            }
        });

        jtxtBuscarDoctor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtBuscarDoctorKeyTyped(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel42.setText("Buscar");

        jTablaDoctor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DNI", "NOMBRE", "APELLIDOS", "ESPECIALIDAD"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablaDoctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaDoctorMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTablaDoctor);
        if (jTablaDoctor.getColumnModel().getColumnCount() > 0) {
            jTablaDoctor.getColumnModel().getColumn(0).setResizable(false);
            jTablaDoctor.getColumnModel().getColumn(1).setResizable(false);
            jTablaDoctor.getColumnModel().getColumn(2).setResizable(false);
            jTablaDoctor.getColumnModel().getColumn(3).setResizable(false);
        }

        jbtnEditarDoctor.setBackground(new java.awt.Color(0, 51, 102));
        jbtnEditarDoctor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONO5.png"))); // NOI18N

        jlabelErrorBuscar.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jlabelErrorBuscar.setForeground(new java.awt.Color(255, 0, 0));

        labelerror2.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        labelerror2.setForeground(new java.awt.Color(204, 0, 0));

        labelerror3.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        labelerror3.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel28)
                    .addComponent(jtxtNomDoctor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(jLabel26)
                    .addComponent(jtxtDniDoctor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30)
                    .addComponent(jcbxEspecialidadDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelerror3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtApelliDoctor, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelerror2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtnLimpiarDoctor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnEliminarDoctor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnEditarDoctor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnGuardarDoctor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addGap(338, 338, 338)
                            .addComponent(jlabelMedico)
                            .addGap(227, 227, 227))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jLabel42)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jlabelErrorBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtxtBuscarDoctor, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtnGuardarDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jtxtDniDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelerror2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxtNomDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jbtnLimpiarDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jbtnEliminarDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnEditarDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(labelerror3, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxtApelliDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel30)
                                .addGap(4, 4, 4)
                                .addComponent(jcbxEspecialidadDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 11, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlabelMedico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(jtxtBuscarDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jlabelErrorBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
        );

        jTabbedPane1.addTab("tab2", jPanel3);

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));

        jLabel9.setText("DNI");

        jLabel10.setText("Apellido Paterno");

        jtxtDniPac.setBackground(new java.awt.Color(204, 255, 255));
        jtxtDniPac.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jtxtDniPac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtDniPacActionPerformed(evt);
            }
        });
        jtxtDniPac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtDniPacKeyTyped(evt);
            }
        });

        jTablePaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DNI", "NOMBRE", "APELLIDO PATERNO", "APELLIDO MATERNO", "GENERO", "EDAD", "TELEFONO", "CORREO", "SEGURO", "FECHA NACIMIENTO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePacienteMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTablePaciente);
        if (jTablePaciente.getColumnModel().getColumnCount() > 0) {
            jTablePaciente.getColumnModel().getColumn(0).setResizable(false);
            jTablePaciente.getColumnModel().getColumn(1).setResizable(false);
            jTablePaciente.getColumnModel().getColumn(2).setResizable(false);
            jTablePaciente.getColumnModel().getColumn(3).setResizable(false);
            jTablePaciente.getColumnModel().getColumn(4).setResizable(false);
            jTablePaciente.getColumnModel().getColumn(5).setResizable(false);
            jTablePaciente.getColumnModel().getColumn(6).setResizable(false);
            jTablePaciente.getColumnModel().getColumn(7).setResizable(false);
            jTablePaciente.getColumnModel().getColumn(8).setResizable(false);
            jTablePaciente.getColumnModel().getColumn(9).setResizable(false);
            jTablePaciente.getColumnModel().getColumn(10).setResizable(false);
        }

        jtxtNombrePac.setBackground(new java.awt.Color(204, 255, 255));
        jtxtNombrePac.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jtxtNombrePac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtNombrePacKeyTyped(evt);
            }
        });

        jLabel11.setText("Apellido Materno");

        jLabel12.setText("Nombre");

        jtxtApelliPatiPac.setBackground(new java.awt.Color(204, 255, 255));
        jtxtApelliPatiPac.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jtxtApelliPatiPac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtApelliPatiPacKeyTyped(evt);
            }
        });

        jtxtApelliMatiPac.setBackground(new java.awt.Color(204, 255, 255));
        jtxtApelliMatiPac.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jtxtApelliMatiPac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtApelliMatiPacKeyTyped(evt);
            }
        });

        jLabel34.setText("Genero");

        jcbxGeneroPac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione..", "Masculino", "Femenino" }));

        jLabel35.setText("Edad");

        jLabel36.setText("Fecha de Nacimiento");

        jDtFechaNacPac.setDateFormatString("yyyy-MM-dd");

        jLabel27.setText("Teléfono");

        jtxtTelefPac.setBackground(new java.awt.Color(204, 255, 255));
        jtxtTelefPac.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jtxtTelefPac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtTelefPacKeyTyped(evt);
            }
        });

        jLabel37.setText("Correo Electrónico");

        jtxtCorreoPac.setBackground(new java.awt.Color(204, 255, 255));
        jtxtCorreoPac.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        jLabel38.setText("Seguro");

        jcbxSeguroPac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione..", "Si", "No" }));

        jbtnGuardarPaciente.setBackground(new java.awt.Color(0, 51, 102));
        jbtnGuardarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONO1.png"))); // NOI18N

        jBtnLimpiar.setBackground(new java.awt.Color(0, 51, 102));
        jBtnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONO2.png"))); // NOI18N

        jbtnEliminarPaciente.setBackground(new java.awt.Color(0, 51, 102));
        jbtnEliminarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONO4.png"))); // NOI18N

        jbtnEditarPaciente.setBackground(new java.awt.Color(0, 51, 102));
        jbtnEditarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONO5.png"))); // NOI18N

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel43.setText("Buscar");

        jtxtBuscarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtBuscarPacienteActionPerformed(evt);
            }
        });
        jtxtBuscarPaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtBuscarPacienteKeyTyped(evt);
            }
        });

        jtxtEdadPac.setBackground(new java.awt.Color(204, 255, 255));
        jtxtEdadPac.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jtxtEdadPac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtEdadPacKeyTyped(evt);
            }
        });

        jlabelBuscarPaciente.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jlabelBuscarPaciente.setForeground(new java.awt.Color(255, 0, 0));

        labelerror5.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        labelerror5.setForeground(new java.awt.Color(204, 0, 0));

        labelerror6.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        labelerror6.setForeground(new java.awt.Color(204, 0, 0));

        labelerror7.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        labelerror7.setForeground(new java.awt.Color(204, 0, 0));

        labelerror8.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        labelerror8.setForeground(new java.awt.Color(204, 0, 0));

        labelerror9.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        labelerror9.setForeground(new java.awt.Color(204, 0, 0));

        labelerror10.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        labelerror10.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(labelerror5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDtFechaNacPac, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel36)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jbtnGuardarPaciente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jBtnLimpiar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jbtnEliminarPaciente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jbtnEditarPaciente))))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jLabel43)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jlabelBuscarPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jtxtBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jlabelPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel27)
                                            .addComponent(jtxtTelefPac, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelerror9, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(labelerror7))
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jtxtCorreoPac, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                                    .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(27, 27, 27)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel34)
                                                    .addComponent(jcbxGeneroPac, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                                        .addGap(19, 19, 19)
                                                        .addComponent(jLabel35))
                                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                                        .addGap(18, 18, 18)
                                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jtxtEdadPac, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(labelerror10, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))))))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtxtDniPac, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtxtNombrePac, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)
                                    .addComponent(labelerror6, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtxtApelliPatiPac, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jtxtApelliMatiPac, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelerror8, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel38)
                                    .addComponent(jcbxSeguroPac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel38))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtxtDniPac, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtxtNombrePac, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtxtApelliMatiPac, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jcbxSeguroPac, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtxtApelliPatiPac, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelerror5)
                            .addComponent(labelerror6)
                            .addComponent(labelerror7)
                            .addComponent(labelerror8))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(jLabel27)
                            .addComponent(jLabel37)
                            .addComponent(jLabel34)
                            .addComponent(jLabel35))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jDtFechaNacPac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jcbxGeneroPac, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtxtEdadPac, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtxtTelefPac)
                                    .addComponent(jtxtCorreoPac))
                                .addGap(3, 3, 3)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelerror9, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelerror10, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(166, 166, 166)
                                .addComponent(jlabelPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel43)
                                    .addComponent(jtxtBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlabelBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(19, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnGuardarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnEliminarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnEditarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))))
        );

        jTabbedPane1.addTab("tab3", jPanel4);

        jPanel5.setBackground(new java.awt.Color(204, 255, 255));

        jTablaEspecialidad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ESPECIALIDAD"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablaEspecialidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaEspecialidadMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTablaEspecialidad);
        if (jTablaEspecialidad.getColumnModel().getColumnCount() > 0) {
            jTablaEspecialidad.getColumnModel().getColumn(0).setResizable(false);
            jTablaEspecialidad.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel31.setText("Especialidad");

        jtxtespecialidad.setBackground(new java.awt.Color(204, 255, 255));
        jtxtespecialidad.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jtxtespecialidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtespecialidadKeyTyped(evt);
            }
        });

        jbtnGuardarEspecialidad.setBackground(new java.awt.Color(0, 51, 102));
        jbtnGuardarEspecialidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONO1.png"))); // NOI18N

        jbtnLimpiarEspecialidad.setBackground(new java.awt.Color(0, 51, 102));
        jbtnLimpiarEspecialidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONO2.png"))); // NOI18N

        jbtnEliminarEspecialidad.setBackground(new java.awt.Color(0, 51, 102));
        jbtnEliminarEspecialidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONO4.png"))); // NOI18N

        jbtnEditarEspecialidad.setBackground(new java.awt.Color(0, 51, 102));
        jbtnEditarEspecialidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONO5.png"))); // NOI18N

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Buscar");

        jtxtBuscarEspecialidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtBuscarEspecialidadKeyTyped(evt);
            }
        });

        labelerror11.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        labelerror11.setForeground(new java.awt.Color(204, 0, 0));

        labelerror12.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        labelerror12.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbtnEditarEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addComponent(jtxtespecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jlabelespecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(labelerror11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbtnEliminarEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnLimpiarEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnGuardarEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtBuscarEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelerror12, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtespecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelerror11))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jbtnGuardarEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnLimpiarEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnEliminarEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnEditarEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(jlabelespecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(labelerror12))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel25)
                                .addComponent(jtxtBuscarEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab4", jPanel5);

        jPanel6.setBackground(new java.awt.Color(204, 255, 255));

        jTableHistorialCita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID CITA", "PACIENTE", "MEDICO", "ESPECIALIDAD", "FECHA CITA", "HORA", "OPERADOR", "F. REGISTRO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableHistorialCita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableHistorialCitaMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTableHistorialCita);
        if (jTableHistorialCita.getColumnModel().getColumnCount() > 0) {
            jTableHistorialCita.getColumnModel().getColumn(0).setResizable(false);
            jTableHistorialCita.getColumnModel().getColumn(1).setResizable(false);
            jTableHistorialCita.getColumnModel().getColumn(2).setResizable(false);
            jTableHistorialCita.getColumnModel().getColumn(3).setResizable(false);
            jTableHistorialCita.getColumnModel().getColumn(4).setResizable(false);
            jTableHistorialCita.getColumnModel().getColumn(5).setResizable(false);
            jTableHistorialCita.getColumnModel().getColumn(6).setResizable(false);
        }

        jLabel33.setBackground(new java.awt.Color(0, 51, 102));
        jLabel33.setFont(new java.awt.Font("The Bold Font", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 51, 102));
        jLabel33.setText("HISTORIAL DE CONSULTAS");

        jbtnEliminarHisto.setBackground(new java.awt.Color(0, 51, 102));
        jbtnEliminarHisto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONO4.png"))); // NOI18N

        jbtnExcelHistorial.setBackground(new java.awt.Color(0, 51, 102));
        jbtnExcelHistorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONO6.png"))); // NOI18N
        jbtnExcelHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnExcelHistorialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 803, Short.MAX_VALUE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel33)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(238, 238, 238)
                        .addComponent(jbtnEliminarHisto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnExcelHistorial)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel33)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnExcelHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnEliminarHisto, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab5", jPanel6);

        jPanel7.setBackground(new java.awt.Color(204, 255, 255));

        jTableDisponibilidad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DOCTOR", "ESPECIALIDAD", "FECHA", "HORA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableDisponibilidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDisponibilidadMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTableDisponibilidad);
        if (jTableDisponibilidad.getColumnModel().getColumnCount() > 0) {
            jTableDisponibilidad.getColumnModel().getColumn(0).setResizable(false);
            jTableDisponibilidad.getColumnModel().getColumn(1).setResizable(false);
            jTableDisponibilidad.getColumnModel().getColumn(2).setResizable(false);
            jTableDisponibilidad.getColumnModel().getColumn(3).setResizable(false);
            jTableDisponibilidad.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel44.setText("Doctor");

        jLabel45.setText("Especialidad");

        jLabel46.setText("Fecha");

        jDataFechaHorario.setDateFormatString("yyyy-MM-dd");

        jcbxHoraHorario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione..", "08:00:00", "08:30:00", "09:00:00", "09:30:00", "10:00:00", "10:30:00", "11:00:00", "11:30:00", "12:00:00", "12:30:00", "14:00:00", "14:30:00", "15:00:00", "15:30:00", "16:00:00", "16:30:00", "17:00:00", "17:30:00", " " }));

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel49.setText("Buscar");

        jtxtBuscarDisponibilidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtBuscarDisponibilidadKeyTyped(evt);
            }
        });

        jbtnGuardarDisponibilidad.setBackground(new java.awt.Color(0, 51, 102));
        jbtnGuardarDisponibilidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONO1.png"))); // NOI18N
        jbtnGuardarDisponibilidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGuardarDisponibilidadActionPerformed(evt);
            }
        });

        jbtnLimpiarDisponibilidad.setBackground(new java.awt.Color(0, 51, 102));
        jbtnLimpiarDisponibilidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONO2.png"))); // NOI18N
        jbtnLimpiarDisponibilidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnLimpiarDisponibilidadActionPerformed(evt);
            }
        });

        jbtnEliminarDisponibilidad.setBackground(new java.awt.Color(0, 51, 102));
        jbtnEliminarDisponibilidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONO4.png"))); // NOI18N

        jbtnEditarDisponibilidad.setBackground(new java.awt.Color(0, 51, 102));
        jbtnEditarDisponibilidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONO5.png"))); // NOI18N

        jcbxDoctorEnHorario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbxDoctorEnHorarioMouseClicked(evt);
            }
        });

        jcbxEspecialidadEnHorario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbxEspecialidadEnHorarioMouseClicked(evt);
            }
        });

        jLabel55.setText("Hora");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel44)
                        .addGap(259, 259, 259)
                        .addComponent(jLabel47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jcbxEspecialidadEnHorario, 0, 99, Short.MAX_VALUE)
                                .addGap(28, 28, 28))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcbxHoraHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDataFechaHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel55)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jcbxDoctorEnHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(jLabel46))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(jLabel49)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtxtBuscarDisponibilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(154, 154, 154)
                                .addComponent(jLabelDisponibilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jbtnEditarDisponibilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbtnEliminarDisponibilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbtnLimpiarDisponibilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbtnGuardarDisponibilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)))
                .addGap(29, 29, 29))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel47)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jcbxDoctorEnHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(jLabel45)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcbxEspecialidadEnHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel46)
                                .addGap(2, 2, 2)
                                .addComponent(jDataFechaHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel55)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbxHoraHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jbtnGuardarDisponibilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbtnLimpiarDisponibilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnEliminarDisponibilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnEditarDisponibilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabelDisponibilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel49)
                            .addComponent(jtxtBuscarDisponibilidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(115, 115, 115))
        );

        jTabbedPane1.addTab("tab6", jPanel7);

        jPanel8.setBackground(new java.awt.Color(204, 255, 255));

        jLabel50.setText("Usuario");

        jTableUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "USUARIO", "CONTRASEÑA", "NOMBRE", "ROL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableUsuarioMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jTableUsuario);
        if (jTableUsuario.getColumnModel().getColumnCount() > 0) {
            jTableUsuario.getColumnModel().getColumn(0).setResizable(false);
            jTableUsuario.getColumnModel().getColumn(1).setResizable(false);
            jTableUsuario.getColumnModel().getColumn(2).setResizable(false);
            jTableUsuario.getColumnModel().getColumn(3).setResizable(false);
            jTableUsuario.getColumnModel().getColumn(4).setResizable(false);
        }

        jtxtUsuarioUsu.setBackground(new java.awt.Color(204, 255, 255));
        jtxtUsuarioUsu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        jLabel51.setText("Contraseña");

        jtxtContraseñaUsu.setBackground(new java.awt.Color(204, 255, 255));
        jtxtContraseñaUsu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        jLabel52.setText("Nombre");

        jtxtNombreUsu.setBackground(new java.awt.Color(204, 255, 255));
        jtxtNombreUsu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jtxtNombreUsu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtNombreUsuKeyTyped(evt);
            }
        });

        jLabel53.setText("Rol");

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel54.setText("Buscar");

        jbtnGuardarUsuario.setBackground(new java.awt.Color(0, 51, 102));
        jbtnGuardarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONO1.png"))); // NOI18N

        jbtnLimpiarU.setBackground(new java.awt.Color(0, 51, 102));
        jbtnLimpiarU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONO2.png"))); // NOI18N

        jbtnEliminarU.setBackground(new java.awt.Color(0, 51, 102));
        jbtnEliminarU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONO4.png"))); // NOI18N

        jbtnEditarU.setBackground(new java.awt.Color(0, 51, 102));
        jbtnEditarU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONO5.png"))); // NOI18N

        jcbxRolUsu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione..", "Recepcionista", "Administrador", " " }));

        labelErrorUsuario.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        labelErrorUsuario.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel53)
                            .addComponent(jLabel52)
                            .addComponent(jLabel51)
                            .addComponent(jLabel50)
                            .addComponent(labelErrorUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtUsuarioUsu)
                            .addComponent(jtxtContraseñaUsu)
                            .addComponent(jtxtNombreUsu)
                            .addComponent(jcbxRolUsu, 0, 111, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtnLimpiarU, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbtnGuardarUsuario, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbtnEliminarU, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbtnEditarU, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel54)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(398, 398, 398)
                        .addComponent(jlabelUsuario)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxtUsuarioUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel51)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxtContraseñaUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel52)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxtNombreUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelErrorUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel53)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbxRolUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jbtnGuardarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnLimpiarU, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnEliminarU, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnEditarU, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlabelUsuario)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel54)
                                .addComponent(buscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab7", jPanel8);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 840, 430));

        jPanel9.setBackground(new java.awt.Color(51, 51, 51));

        jlabelIngreso.setForeground(new java.awt.Color(0, 153, 153));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Usuario:");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/softwa1.png"))); // NOI18N

        jbtnColsultaMedica.setBackground(new java.awt.Color(51, 51, 51));
        jbtnColsultaMedica.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        jbtnColsultaMedica.setForeground(new java.awt.Color(167, 215, 219));
        jbtnColsultaMedica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONO8.png"))); // NOI18N
        jbtnColsultaMedica.setText("CITA MEDICA");
        jbtnColsultaMedica.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jbtnColsultaMedica.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnColsultaMedica.setDoubleBuffered(true);
        jbtnColsultaMedica.setFocusCycleRoot(true);
        jbtnColsultaMedica.setFocusPainted(false);
        jbtnColsultaMedica.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbtnColsultaMedica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnColsultaMedicaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtnColsultaMedicaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtnColsultaMedicaMouseExited(evt);
            }
        });
        jbtnColsultaMedica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnColsultaMedicaActionPerformed(evt);
            }
        });

        jbtnPaciente.setBackground(new java.awt.Color(51, 51, 51));
        jbtnPaciente.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        jbtnPaciente.setForeground(new java.awt.Color(167, 215, 219));
        jbtnPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONO10.png"))); // NOI18N
        jbtnPaciente.setText("PACIENTES");
        jbtnPaciente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jbtnPaciente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnPaciente.setDoubleBuffered(true);
        jbtnPaciente.setFocusCycleRoot(true);
        jbtnPaciente.setFocusPainted(false);
        jbtnPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnPacienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtnPacienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtnPacienteMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtnPacienteMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jbtnPacienteMouseReleased(evt);
            }
        });
        jbtnPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPacienteActionPerformed(evt);
            }
        });

        jbtnDoctores.setBackground(new java.awt.Color(51, 51, 51));
        jbtnDoctores.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnDoctores.setForeground(new java.awt.Color(167, 215, 219));
        jbtnDoctores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONO9.png"))); // NOI18N
        jbtnDoctores.setText("DOCTORES");
        jbtnDoctores.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jbtnDoctores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnDoctores.setDoubleBuffered(true);
        jbtnDoctores.setFocusCycleRoot(true);
        jbtnDoctores.setFocusPainted(false);
        jbtnDoctores.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbtnDoctores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnDoctoresMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtnDoctoresMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtnDoctoresMouseExited(evt);
            }
        });
        jbtnDoctores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDoctoresActionPerformed(evt);
            }
        });

        jbtnEspecialidad.setBackground(new java.awt.Color(51, 51, 51));
        jbtnEspecialidad.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        jbtnEspecialidad.setForeground(new java.awt.Color(167, 215, 219));
        jbtnEspecialidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONO11.png"))); // NOI18N
        jbtnEspecialidad.setText("ESPECIALIDAD");
        jbtnEspecialidad.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jbtnEspecialidad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnEspecialidad.setDoubleBuffered(true);
        jbtnEspecialidad.setFocusCycleRoot(true);
        jbtnEspecialidad.setFocusPainted(false);
        jbtnEspecialidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnEspecialidadMouseClicked(evt);
            }
        });
        jbtnEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEspecialidadActionPerformed(evt);
            }
        });

        jbtnHistorial.setBackground(new java.awt.Color(51, 51, 51));
        jbtnHistorial.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        jbtnHistorial.setForeground(new java.awt.Color(167, 215, 219));
        jbtnHistorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONO12.png"))); // NOI18N
        jbtnHistorial.setText("HISTORIAL");
        jbtnHistorial.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jbtnHistorial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnHistorial.setDoubleBuffered(true);
        jbtnHistorial.setFocusCycleRoot(true);
        jbtnHistorial.setFocusPainted(false);
        jbtnHistorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnHistorialMouseClicked(evt);
            }
        });
        jbtnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnHistorialActionPerformed(evt);
            }
        });

        jbtnHorarios.setBackground(new java.awt.Color(51, 51, 51));
        jbtnHorarios.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        jbtnHorarios.setForeground(new java.awt.Color(167, 215, 219));
        jbtnHorarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONO7.png"))); // NOI18N
        jbtnHorarios.setText("HORARIOS");
        jbtnHorarios.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jbtnHorarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnHorarios.setDoubleBuffered(true);
        jbtnHorarios.setFocusCycleRoot(true);
        jbtnHorarios.setFocusPainted(false);
        jbtnHorarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnHorariosMouseClicked(evt);
            }
        });
        jbtnHorarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnHorariosActionPerformed(evt);
            }
        });

        jbtnUsuarios.setBackground(new java.awt.Color(51, 51, 51));
        jbtnUsuarios.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        jbtnUsuarios.setForeground(new java.awt.Color(167, 215, 219));
        jbtnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONO13.png"))); // NOI18N
        jbtnUsuarios.setText("USUARIOS");
        jbtnUsuarios.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jbtnUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnUsuarios.setDoubleBuffered(true);
        jbtnUsuarios.setFocusCycleRoot(true);
        jbtnUsuarios.setFocusPainted(false);
        jbtnUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnUsuariosMouseClicked(evt);
            }
        });
        jbtnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnUsuariosActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imagen3.png"))); // NOI18N

        jbtnSalir.setBackground(new java.awt.Color(51, 51, 51));
        jbtnSalir.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        jbtnSalir.setForeground(new java.awt.Color(167, 215, 219));
        jbtnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salir.png"))); // NOI18N
        jbtnSalir.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jbtnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnSalir.setDoubleBuffered(true);
        jbtnSalir.setFocusCycleRoot(true);
        jbtnSalir.setFocusPainted(false);
        jbtnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbtnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnSalirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtnSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtnSalirMouseExited(evt);
            }
        });
        jbtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jbtnUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jbtnHorarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jbtnHistorial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jbtnEspecialidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jbtnPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jbtnDoctores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jbtnColsultaMedica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlabelIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jbtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jlabelIngreso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jbtnColsultaMedica, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jbtnDoctores, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 610));

        jPanel10.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 870, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 870, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtDniDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtDniDoctorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtDniDoctorActionPerformed

    private void jtxtDniPacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtDniPacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtDniPacActionPerformed

    private void jbtnEliminarDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEliminarDoctorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnEliminarDoctorActionPerformed

    private void jbtnColsultaMedicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnColsultaMedicaActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);

    }//GEN-LAST:event_jbtnColsultaMedicaActionPerformed

    private void jbtnDoctoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDoctoresActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jbtnDoctoresActionPerformed

    private void jbtnPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPacienteActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jbtnPacienteActionPerformed

    private void jbtnEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEspecialidadActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_jbtnEspecialidadActionPerformed

    private void jbtnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnHistorialActionPerformed
        
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_jbtnHistorialActionPerformed

    private void jbtnHorariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnHorariosActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_jbtnHorariosActionPerformed

    private void jbtnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnUsuariosActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(6);
    }//GEN-LAST:event_jbtnUsuariosActionPerformed

    private void jbtnColsultaMedicaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnColsultaMedicaMouseEntered
        // TODO add your handling code here: 


    }//GEN-LAST:event_jbtnColsultaMedicaMouseEntered

    private void jbtnColsultaMedicaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnColsultaMedicaMouseExited
        // TODO add your handling code here:


    }//GEN-LAST:event_jbtnColsultaMedicaMouseExited

    private void jbtnDoctoresMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnDoctoresMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_jbtnDoctoresMouseEntered

    private void jbtnDoctoresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnDoctoresMouseExited
        // TODO add your handling code here:


    }//GEN-LAST:event_jbtnDoctoresMouseExited

    private void jbtnPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnPacienteMouseClicked
        // TODO add your handling code here:
        jbtnPaciente.setBackground(new Color(0, 51, 102));
        jbtnColsultaMedica.setBackground(new Color(51, 51, 51));
        jbtnDoctores.setBackground(new Color(51, 51, 51));
        jbtnEspecialidad.setBackground(new Color(51, 51, 51));
        jbtnHistorial.setBackground(new Color(51, 51, 51));
        jbtnHorarios.setBackground(new Color(51, 51, 51));
        jbtnUsuarios.setBackground(new Color(51, 51, 51));
    }//GEN-LAST:event_jbtnPacienteMouseClicked

    private void jbtnPacienteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnPacienteMouseReleased
        // TODO add your handling code here:     
    }//GEN-LAST:event_jbtnPacienteMouseReleased

    private void jbtnColsultaMedicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnColsultaMedicaMouseClicked
        // TODO add your handling code here:
        jbtnColsultaMedica.setBackground(new Color(0, 51, 102));
        jbtnDoctores.setBackground(new Color(51, 51, 51));
        jbtnPaciente.setBackground(new Color(51, 51, 51));
        jbtnEspecialidad.setBackground(new Color(51, 51, 51));
        jbtnHistorial.setBackground(new Color(51, 51, 51));
        jbtnHorarios.setBackground(new Color(51, 51, 51));
        jbtnUsuarios.setBackground(new Color(51, 51, 51));
    }//GEN-LAST:event_jbtnColsultaMedicaMouseClicked

    private void jbtnPacienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnPacienteMouseEntered
        // TODO add your handling code here:   
    }//GEN-LAST:event_jbtnPacienteMouseEntered

    private void jbtnPacienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnPacienteMouseExited
        // TODO add your handling code here:        
    }//GEN-LAST:event_jbtnPacienteMouseExited

    private void jbtnPacienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnPacienteMousePressed
        // TODO add your handling code here: 
    }//GEN-LAST:event_jbtnPacienteMousePressed

    private void jbtnDoctoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnDoctoresMouseClicked
        // TODO add your handling code here:
        jbtnDoctores.setBackground(new Color(0, 51, 102));
        jbtnColsultaMedica.setBackground(new Color(51, 51, 51));
        jbtnPaciente.setBackground(new Color(51, 51, 51));
        jbtnEspecialidad.setBackground(new Color(51, 51, 51));
        jbtnHistorial.setBackground(new Color(51, 51, 51));
        jbtnHorarios.setBackground(new Color(51, 51, 51));
        jbtnUsuarios.setBackground(new Color(51, 51, 51));
    }//GEN-LAST:event_jbtnDoctoresMouseClicked

    private void jbtnEspecialidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnEspecialidadMouseClicked
        // TODO add your handling code here:
        jbtnEspecialidad.setBackground(new Color(0, 51, 102));
        jbtnColsultaMedica.setBackground(new Color(51, 51, 51));
        jbtnDoctores.setBackground(new Color(51, 51, 51));
        jbtnPaciente.setBackground(new Color(51, 51, 51));
        jbtnHistorial.setBackground(new Color(51, 51, 51));
        jbtnHorarios.setBackground(new Color(51, 51, 51));
        jbtnUsuarios.setBackground(new Color(51, 51, 51));
    }//GEN-LAST:event_jbtnEspecialidadMouseClicked

    private void jbtnHistorialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnHistorialMouseClicked
        // TODO add your handling code here:
        jbtnHistorial.setBackground(new Color(0, 51, 102));
        jbtnColsultaMedica.setBackground(new Color(51, 51, 51));
        jbtnDoctores.setBackground(new Color(51, 51, 51));
        jbtnPaciente.setBackground(new Color(51, 51, 51));
        jbtnEspecialidad.setBackground(new Color(51, 51, 51));
        jbtnHorarios.setBackground(new Color(51, 51, 51));
        jbtnUsuarios.setBackground(new Color(51, 51, 51));
    }//GEN-LAST:event_jbtnHistorialMouseClicked

    private void jbtnHorariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnHorariosMouseClicked
        // TODO add your handling code here:
        jbtnHorarios.setBackground(new Color(0, 51, 102));
        jbtnColsultaMedica.setBackground(new Color(51, 51, 51));
        jbtnDoctores.setBackground(new Color(51, 51, 51));
        jbtnPaciente.setBackground(new Color(51, 51, 51));
        jbtnEspecialidad.setBackground(new Color(51, 51, 51));
        jbtnHistorial.setBackground(new Color(51, 51, 51));
        jbtnUsuarios.setBackground(new Color(51, 51, 51));
    }//GEN-LAST:event_jbtnHorariosMouseClicked

    private void jbtnUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnUsuariosMouseClicked
        // TODO add your handling code here:
        jbtnUsuarios.setBackground(new Color(0, 51, 102));
        jbtnColsultaMedica.setBackground(new Color(51, 51, 51));
        jbtnDoctores.setBackground(new Color(51, 51, 51));
        jbtnPaciente.setBackground(new Color(51, 51, 51));
        jbtnEspecialidad.setBackground(new Color(51, 51, 51));
        jbtnHistorial.setBackground(new Color(51, 51, 51));
        jbtnHorarios.setBackground(new Color(51, 51, 51));
    }//GEN-LAST:event_jbtnUsuariosMouseClicked

    private void jbtnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnSalirMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnSalirMouseClicked

    private void jbtnSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnSalirMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnSalirMouseEntered

    private void jbtnSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnSalirMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnSalirMouseExited

    private void jbtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jbtnSalirActionPerformed

    private void jTablePacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePacienteMouseClicked
        // TODO add your handling code here:
        int fila = jTablePaciente.rowAtPoint(evt.getPoint());
        jlabelPaciente.setText(jTablePaciente.getValueAt(fila, 0).toString());
        jtxtDniPac.setText(jTablePaciente.getValueAt(fila, 1).toString());
        jtxtNombrePac.setText(jTablePaciente.getValueAt(fila, 2).toString());
        jtxtApelliPatiPac.setText(jTablePaciente.getValueAt(fila, 3).toString());
        jtxtApelliMatiPac.setText(jTablePaciente.getValueAt(fila, 4).toString());
        jcbxGeneroPac.setSelectedItem(jTablePaciente.getValueAt(fila, 5).toString());
        jtxtEdadPac.setText(jTablePaciente.getValueAt(fila, 6).toString());
        jtxtTelefPac.setText(jTablePaciente.getValueAt(fila, 7).toString());
        jtxtCorreoPac.setText(jTablePaciente.getValueAt(fila, 8).toString());
        jcbxSeguroPac.setSelectedItem(jTablePaciente.getValueAt(fila, 9).toString());
        jDtFechaNacPac.setDate((Date) jTablePaciente.getValueAt(fila, 10));

    }//GEN-LAST:event_jTablePacienteMouseClicked

    private void jtxtBuscarPacienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtBuscarPacienteKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            evt.consume();
            jlabelBuscarPaciente.setText("Ingresa solo número");
        } else if ((int) evt.getKeyChar() >= 32 && (int) evt.getKeyChar() <= 47
                || (int) evt.getKeyChar() >= 58 && (int) evt.getKeyChar() <= 64
                || (int) evt.getKeyChar() >= 91 && (int) evt.getKeyChar() <= 96
                || (int) evt.getKeyChar() >= 123 && (int) evt.getKeyChar() <= 255) {
            evt.consume();
            jlabelBuscarPaciente.setText("Ingresa solo número");
        } else jlabelBuscarPaciente.setText("");

    }//GEN-LAST:event_jtxtBuscarPacienteKeyTyped

    private void jTablaEspecialidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaEspecialidadMouseClicked
        // TODO add your handling code here:
        int fila = jTablaEspecialidad.rowAtPoint(evt.getPoint());
        jtxtespecialidad.setText(jTablaEspecialidad.getValueAt(fila, 1).toString());
        jlabelespecialidad.setText(jTablaEspecialidad.getValueAt(fila, 0).toString());

    }//GEN-LAST:event_jTablaEspecialidadMouseClicked

    private void jcbxEspecialidadDoctorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbxEspecialidadDoctorMouseClicked
        // TODO add your handling code here:
//        especialidadDAO esdao = new especialidadDAO();
//        especialidad es = new especialidad();
//        List<especialidad> ListaEspe = esdao.ListarEsspecialidad();
//        jcbxEspecialidadDoctor.removeAllItems();
//
//        for (int i = 0; i < ListaEspe.size(); i++) {
//            jcbxEspecialidadDoctor.addItem(ListaEspe.get(i).getNom_espec());
//        }
        llenarEspecialidadenDoctor();
    }//GEN-LAST:event_jcbxEspecialidadDoctorMouseClicked

    private void jTableUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableUsuarioMouseClicked
        // TODO add your handling code here:
        int fila = jTableUsuario.rowAtPoint(evt.getPoint());
        jlabelUsuario.setText(jTableUsuario.getValueAt(fila, 0).toString());
        jtxtUsuarioUsu.setText(jTableUsuario.getValueAt(fila, 1).toString());
        jtxtContraseñaUsu.setText(jTableUsuario.getValueAt(fila, 2).toString());
        jtxtNombreUsu.setText(jTableUsuario.getValueAt(fila, 3).toString());
        jcbxRolUsu.setSelectedItem(jTableUsuario.getValueAt(fila, 4).toString());


    }//GEN-LAST:event_jTableUsuarioMouseClicked

    private void jcbxEspecialidadDoctorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbxEspecialidadDoctorMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbxEspecialidadDoctorMousePressed

    private void jTablaDoctorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaDoctorMouseClicked
        // TODO add your handling code here:
        int fila = jTablaDoctor.rowAtPoint(evt.getPoint());
        jlabelMedico.setText(jTablaDoctor.getValueAt(fila, 0).toString());
        jtxtDniDoctor.setText(jTablaDoctor.getValueAt(fila, 1).toString());
        jtxtNomDoctor.setText(jTablaDoctor.getValueAt(fila, 2).toString());
        jtxtApelliDoctor.setText(jTablaDoctor.getValueAt(fila, 3).toString());
        jcbxEspecialidadDoctor.setSelectedItem(jTablaDoctor.getValueAt(fila, 4).toString());


    }//GEN-LAST:event_jTablaDoctorMouseClicked

    private void jtxtBuscarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtBuscarPacienteActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jtxtBuscarPacienteActionPerformed

    private void jcbxDoctorEnHorarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbxDoctorEnHorarioMouseClicked
        // TODO add your handling code here:
        horarioDAO hodao = new horarioDAO();
        medico med = new medico();
        List<medico> ListaMedHor = hodao.ListarDoctorEnHorario();
        jcbxDoctorEnHorario.removeAllItems();

        for (int i = 0; i < ListaMedHor.size(); i++) {
            jcbxDoctorEnHorario.addItem(ListaMedHor.get(i).getNombre_medico());
        }
    }//GEN-LAST:event_jcbxDoctorEnHorarioMouseClicked

    private void jtxtBuscarDoctorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtBuscarDoctorKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            evt.consume();
            jlabelErrorBuscar.setText("Ingresa solo números");
        } else if ((int) evt.getKeyChar() >= 32 && (int) evt.getKeyChar() <= 47
                || (int) evt.getKeyChar() >= 58 && (int) evt.getKeyChar() <= 64
                || (int) evt.getKeyChar() >= 91 && (int) evt.getKeyChar() <= 96
                || (int) evt.getKeyChar() >= 123 && (int) evt.getKeyChar() <= 255) {

            evt.consume();
            jlabelErrorBuscar.setText("Ingresa solo números");
        } else {
            jlabelErrorBuscar.setText("");
        }

    }//GEN-LAST:event_jtxtBuscarDoctorKeyTyped

    private void jcbxEspecialidadEnHorarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbxEspecialidadEnHorarioMouseClicked
        // TODO add your handling code here:
        llenarEspecialidad();
    }//GEN-LAST:event_jcbxEspecialidadEnHorarioMouseClicked

    private void jbtnGuardarDisponibilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardarDisponibilidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnGuardarDisponibilidadActionPerformed

    private void jbtnLimpiarDisponibilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLimpiarDisponibilidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnLimpiarDisponibilidadActionPerformed

    private void jTableDisponibilidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDisponibilidadMouseClicked
        // TODO add your handling code here:
        int fila = jTableDisponibilidad.rowAtPoint(evt.getPoint());
        jLabelDisponibilidad.setText(jTableDisponibilidad.getValueAt(fila, 0).toString());
        jcbxDoctorEnHorario.setSelectedItem(jTableDisponibilidad.getValueAt(fila, 1).toString());
        jcbxEspecialidadEnHorario.setSelectedItem(jTableDisponibilidad.getValueAt(fila, 2).toString());
        jDataFechaHorario.setDate((Date) jTableDisponibilidad.getValueAt(fila, 3));
        jcbxHoraHorario.setSelectedItem(jTableDisponibilidad.getValueAt(fila, 4).toString());
    }//GEN-LAST:event_jTableDisponibilidadMouseClicked

    private void jtxtDniDoctorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtDniDoctorKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            evt.consume();
            labelerror2.setText("Ingrese solo números");
        } else if ((int) evt.getKeyChar() >= 32 && (int) evt.getKeyChar() <= 47
                || (int) evt.getKeyChar() >= 58 && (int) evt.getKeyChar() <= 64
                || (int) evt.getKeyChar() >= 91 && (int) evt.getKeyChar() <= 96
                || (int) evt.getKeyChar() >= 123 && (int) evt.getKeyChar() <= 255) {
            evt.consume();
            labelerror2.setText("Ingrese solo números");
        } else {
            labelerror2.setText("");
        }

    }//GEN-LAST:event_jtxtDniDoctorKeyTyped

    private void jtxtNomDoctorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtNomDoctorKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isLetter(c)) {
            evt.consume();
            labelerror3.setText("Ingrese solo letras");
        } else {
            labelerror3.setText("");
        }
    }//GEN-LAST:event_jtxtNomDoctorKeyTyped

    private void jtxtDniPacKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtDniPacKeyTyped
        // TODO add your handling code here:
         char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            evt.consume();
            labelerror5.setText("Ingrese solo números");
        } else if ((int) evt.getKeyChar() >= 32 && (int) evt.getKeyChar() <= 47
                || (int) evt.getKeyChar() >= 58 && (int) evt.getKeyChar() <= 64
                || (int) evt.getKeyChar() >= 91 && (int) evt.getKeyChar() <= 96
                || (int) evt.getKeyChar() >= 123 && (int) evt.getKeyChar() <= 255) {
            evt.consume();
            labelerror5.setText("Ingrese solo números");
        } else {
            labelerror5.setText("");
        }
    }//GEN-LAST:event_jtxtDniPacKeyTyped

    private void jtxtNombrePacKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtNombrePacKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isLetter(c)) {
            evt.consume();
            labelerror6.setText("Ingrese solo letras");
        } else {
            labelerror6.setText("");
        }
    }//GEN-LAST:event_jtxtNombrePacKeyTyped

    private void jtxtApelliMatiPacKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtApelliMatiPacKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isLetter(c)) {
            evt.consume();
            labelerror8.setText("Ingrese solo letras");
        } else {
            labelerror8.setText("");
        
    }  
    }//GEN-LAST:event_jtxtApelliMatiPacKeyTyped

    private void jtxtApelliPatiPacKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtApelliPatiPacKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isLetter(c)) {
            evt.consume();
            labelerror7.setText("Ingrese solo letras");
        } else {
            labelerror7.setText("");
        
    } 
    }//GEN-LAST:event_jtxtApelliPatiPacKeyTyped

    private void jtxtTelefPacKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtTelefPacKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            evt.consume();
            labelerror9.setText("Ingrese solo números");
        } else if ((int) evt.getKeyChar() >= 32 && (int) evt.getKeyChar() <= 47
                || (int) evt.getKeyChar() >= 58 && (int) evt.getKeyChar() <= 64
                || (int) evt.getKeyChar() >= 91 && (int) evt.getKeyChar() <= 96
                || (int) evt.getKeyChar() >= 123 && (int) evt.getKeyChar() <= 255) {
            evt.consume();
            labelerror9.setText("Ingrese solo números");
        } else {
            labelerror9.setText("");
        }
    }//GEN-LAST:event_jtxtTelefPacKeyTyped

    private void jtxtEdadPacKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtEdadPacKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            evt.consume();
            labelerror10.setText("Ingrese solo números");
        } else if ((int) evt.getKeyChar() >= 32 && (int) evt.getKeyChar() <= 47
                || (int) evt.getKeyChar() >= 58 && (int) evt.getKeyChar() <= 64
                || (int) evt.getKeyChar() >= 91 && (int) evt.getKeyChar() <= 96
                || (int) evt.getKeyChar() >= 123 && (int) evt.getKeyChar() <= 255) {
            evt.consume();
            labelerror10.setText("Ingrese solo números");
        } else {
            labelerror10.setText("");
        }
    }//GEN-LAST:event_jtxtEdadPacKeyTyped

    private void jtxtespecialidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtespecialidadKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isLetter(c)) {
            evt.consume();
            labelerror11.setText("Ingrese solo letras");
        } else {
            labelerror11.setText("");
        
    } 
    }//GEN-LAST:event_jtxtespecialidadKeyTyped

    private void jtxtBuscarEspecialidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtBuscarEspecialidadKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isLetter(c)) {
            evt.consume();
            labelerror12.setText("Ingrese solo letras");
        } else {
            labelerror12.setText("");
        
    }
    }//GEN-LAST:event_jtxtBuscarEspecialidadKeyTyped

    private void jtxtBuscarDisponibilidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtBuscarDisponibilidadKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtBuscarDisponibilidadKeyTyped

    private void jTableHistorialCitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableHistorialCitaMouseClicked
        // TODO add your handling code here:
        int fila = jTableHistorialCita.rowAtPoint(evt.getPoint());
        jLabelHistorial.setText(jTableHistorialCita.getValueAt(fila, 0).toString());
    }//GEN-LAST:event_jTableHistorialCitaMouseClicked

    private void jcbxFechaCitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbxFechaCitaMouseClicked
        // TODO add your handling code here:
        llenarFechHorDoc();
    }//GEN-LAST:event_jcbxFechaCitaMouseClicked

    private void jcbxDocCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbxDocCitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbxDocCitaActionPerformed

    private void jcbxDocCitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbxDocCitaMouseClicked
        // TODO add your handling code here:
        llenarDoctorEspecialidadCita();
    }//GEN-LAST:event_jcbxDocCitaMouseClicked

    private void jcbxHoraCitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbxHoraCitaMouseClicked
        // TODO add your handling code here:
        //        llenarFechHorDoc();
    }//GEN-LAST:event_jcbxHoraCitaMouseClicked

    private void jtxtApellidoMaPaCitaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtApellidoMaPaCitaKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isLetter(c)) {
            evt.consume();
            labelErrorCita4.setText("Ingrese solo letras");
        } else {
            labelErrorCita4.setText("");
        }
    }//GEN-LAST:event_jtxtApellidoMaPaCitaKeyTyped

    private void jtxtApellidoPaPacienteCitaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtApellidoPaPacienteCitaKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isLetter(c)) {
            evt.consume();
            labelErrorCita3.setText("Ingrese solo letras");
        } else {
            labelErrorCita3.setText("");
        }
    }//GEN-LAST:event_jtxtApellidoPaPacienteCitaKeyTyped

    private void jtxtNombrePacienteCitaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtNombrePacienteCitaKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isLetter(c)) {
            evt.consume();
            labelErrorCita2.setText("Ingrese solo letras");
        } else {
            labelErrorCita2.setText("");

        }
    }//GEN-LAST:event_jtxtNombrePacienteCitaKeyTyped

    private void jtxtDniPacienteCitaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtDniPacienteCitaKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            evt.consume();
            labelErrorCita1.setText("Ingrese solo números");
        } else if ((int) evt.getKeyChar() >= 32 && (int) evt.getKeyChar() <= 47
            || (int) evt.getKeyChar() >= 58 && (int) evt.getKeyChar() <= 64
            || (int) evt.getKeyChar() >= 91 && (int) evt.getKeyChar() <= 96
            || (int) evt.getKeyChar() >= 123 && (int) evt.getKeyChar() <= 255) {
            evt.consume();
            labelErrorCita1.setText("Ingrese solo números");
        } else {
            labelErrorCita1.setText("");
        }
    }//GEN-LAST:event_jtxtDniPacienteCitaKeyTyped

    private void jtxtDniPacienteCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtDniPacienteCitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtDniPacienteCitaActionPerformed

    private void jcbxEspecialidadCitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbxEspecialidadCitaMouseClicked
        // TODO add your handling code here:
        llenarEspecialidadEnCita();
    }//GEN-LAST:event_jcbxEspecialidadCitaMouseClicked

    private void jtxtTelefonoPacienteCitaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtTelefonoPacienteCitaKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            evt.consume();
            labelErrorCita5.setText("Ingrese solo números");
        } else if ((int) evt.getKeyChar() >= 32 && (int) evt.getKeyChar() <= 47
            || (int) evt.getKeyChar() >= 58 && (int) evt.getKeyChar() <= 64
            || (int) evt.getKeyChar() >= 91 && (int) evt.getKeyChar() <= 96
            || (int) evt.getKeyChar() >= 123 && (int) evt.getKeyChar() <= 255) {
            evt.consume();
            labelErrorCita5.setText("Ingrese solo números");
        } else {
            labelErrorCita5.setText("");
        }
    }//GEN-LAST:event_jtxtTelefonoPacienteCitaKeyTyped

    private void jtxtEdadPacienteCitaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtEdadPacienteCitaKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            evt.consume();
            labelErrorCita6.setText("Ingrese solo números");
        } else if ((int) evt.getKeyChar() >= 32 && (int) evt.getKeyChar() <= 47
            || (int) evt.getKeyChar() >= 58 && (int) evt.getKeyChar() <= 64
            || (int) evt.getKeyChar() >= 91 && (int) evt.getKeyChar() <= 96
            || (int) evt.getKeyChar() >= 123 && (int) evt.getKeyChar() <= 255) {
            evt.consume();
            labelErrorCita6.setText("Ingrese solo números");
        } else {
            labelErrorCita6.setText("");
        }
    }//GEN-LAST:event_jtxtEdadPacienteCitaKeyTyped

    private void jtxtNombreUsuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtNombreUsuKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isLetter(c)) {
            evt.consume();
           labelErrorUsuario.setText("Ingrese solo letras");
        } else {
            labelErrorUsuario.setText("");

        }
    }//GEN-LAST:event_jtxtNombreUsuKeyTyped

    private void jbtnExcelHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnExcelHistorialActionPerformed
        // TODO add your handling code here:
        Excel.reporte();
    }//GEN-LAST:event_jbtnExcelHistorialActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Software vista = new Software();
        pacienteController c = new pacienteController(vista);
        citaController v = new citaController(vista);
        especialidadController e = new especialidadController(vista);
        usuarioController u = new usuarioController(vista);
        doctorController m = new doctorController(vista);
        horarioController h = new horarioController(vista);
        historialController t = new historialController(vista);

        vista.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField buscarUsuario;
    public javax.swing.JButton jBtnLimpiar;
    public com.toedter.calendar.JDateChooser jDataFechaHorario;
    public com.toedter.calendar.JDateChooser jDateFechaNacPacienteCita;
    public com.toedter.calendar.JDateChooser jDtFechaNacPac;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JLabel jLabelDisponibilidad;
    public javax.swing.JLabel jLabelHistorial;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    public javax.swing.JPanel jPanel6;
    public javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JTable jTablaDoctor;
    public javax.swing.JTable jTablaEspecialidad;
    public javax.swing.JTable jTableDisponibilidad;
    public javax.swing.JTable jTableHistorialCita;
    public javax.swing.JTable jTablePaciente;
    public javax.swing.JTable jTableUsuario;
    public javax.swing.JButton jbtnBuscarPacienteCita;
    public javax.swing.JButton jbtnColsultaMedica;
    public javax.swing.JButton jbtnDoctores;
    public javax.swing.JButton jbtnEditarDisponibilidad;
    public javax.swing.JButton jbtnEditarDoctor;
    public javax.swing.JButton jbtnEditarEspecialidad;
    public javax.swing.JButton jbtnEditarPaciente;
    public javax.swing.JButton jbtnEditarU;
    public javax.swing.JButton jbtnEliminarDisponibilidad;
    public javax.swing.JButton jbtnEliminarDoctor;
    public javax.swing.JButton jbtnEliminarEspecialidad;
    public javax.swing.JButton jbtnEliminarHisto;
    public javax.swing.JButton jbtnEliminarPaciente;
    public javax.swing.JButton jbtnEliminarU;
    public javax.swing.JButton jbtnEnviarYfactura;
    public javax.swing.JButton jbtnEspecialidad;
    public javax.swing.JButton jbtnExcelHistorial;
    public javax.swing.JButton jbtnGuardarDisponibilidad;
    public javax.swing.JButton jbtnGuardarDoctor;
    public javax.swing.JButton jbtnGuardarEspecialidad;
    public javax.swing.JButton jbtnGuardarPaciente;
    public javax.swing.JButton jbtnGuardarUsuario;
    public javax.swing.JButton jbtnHistorial;
    public javax.swing.JButton jbtnHorarios;
    public javax.swing.JButton jbtnLimpiarCita;
    public javax.swing.JButton jbtnLimpiarDisponibilidad;
    public javax.swing.JButton jbtnLimpiarDoctor;
    public javax.swing.JButton jbtnLimpiarEspecialidad;
    public javax.swing.JButton jbtnLimpiarU;
    public javax.swing.JButton jbtnPaciente;
    public javax.swing.JButton jbtnSalir;
    public javax.swing.JButton jbtnUsuarios;
    public javax.swing.JComboBox<String> jcbxDocCita;
    public javax.swing.JComboBox<String> jcbxDoctorEnHorario;
    public javax.swing.JComboBox<String> jcbxEspecialidadCita;
    public javax.swing.JComboBox<String> jcbxEspecialidadDoctor;
    public javax.swing.JComboBox<String> jcbxEspecialidadEnHorario;
    public javax.swing.JComboBox<String> jcbxFechaCita;
    public javax.swing.JComboBox<String> jcbxGeneroPac;
    public javax.swing.JComboBox<String> jcbxGeneroPacienteCita;
    public javax.swing.JComboBox<String> jcbxHoraCita;
    public javax.swing.JComboBox<String> jcbxHoraHorario;
    public javax.swing.JComboBox<String> jcbxRolUsu;
    public javax.swing.JComboBox<String> jcbxSeguroPac;
    public javax.swing.JLabel jlabelBuscarPaciente;
    public javax.swing.JLabel jlabelErrorBuscar;
    public javax.swing.JLabel jlabelIngreso;
    public javax.swing.JLabel jlabelMedico;
    public javax.swing.JLabel jlabelPaciente;
    public javax.swing.JLabel jlabelUsuario;
    public javax.swing.JLabel jlabelespecialidad;
    public javax.swing.JTextField jtxtApelliDoctor;
    public javax.swing.JTextField jtxtApelliMatiPac;
    public javax.swing.JTextField jtxtApelliPatiPac;
    public javax.swing.JTextField jtxtApellidoMaPaCita;
    public javax.swing.JTextField jtxtApellidoPaPacienteCita;
    public javax.swing.JTextField jtxtBuscarDisponibilidad;
    public javax.swing.JTextField jtxtBuscarDoctor;
    public javax.swing.JTextField jtxtBuscarEspecialidad;
    public javax.swing.JTextField jtxtBuscarPaciente;
    public javax.swing.JTextField jtxtContraseñaUsu;
    public javax.swing.JTextField jtxtCorreoPac;
    public javax.swing.JTextField jtxtCorreoPacienteCita;
    public java.awt.TextArea jtxtDescripcion;
    public javax.swing.JTextField jtxtDniDoctor;
    public javax.swing.JTextField jtxtDniPac;
    public javax.swing.JTextField jtxtDniPacienteCita;
    public javax.swing.JTextField jtxtEdadPac;
    public javax.swing.JTextField jtxtEdadPacienteCita;
    public javax.swing.JTextField jtxtNomDoctor;
    public javax.swing.JTextField jtxtNombrePac;
    public javax.swing.JTextField jtxtNombrePacienteCita;
    public javax.swing.JTextField jtxtNombreUsu;
    public javax.swing.JLabel jtxtSeguroPacienteCita;
    public javax.swing.JTextField jtxtTelefPac;
    public javax.swing.JTextField jtxtTelefonoPacienteCita;
    public javax.swing.JTextField jtxtUsuarioUsu;
    public javax.swing.JTextField jtxtespecialidad;
    private javax.swing.JLabel labelErrorCita1;
    private javax.swing.JLabel labelErrorCita2;
    private javax.swing.JLabel labelErrorCita3;
    private javax.swing.JLabel labelErrorCita4;
    private javax.swing.JLabel labelErrorCita5;
    private javax.swing.JLabel labelErrorCita6;
    public javax.swing.JLabel labelErrorUsuario;
    public javax.swing.JLabel labelerror10;
    public javax.swing.JLabel labelerror11;
    public javax.swing.JLabel labelerror12;
    public javax.swing.JLabel labelerror2;
    public javax.swing.JLabel labelerror3;
    public javax.swing.JLabel labelerror5;
    public javax.swing.JLabel labelerror6;
    public javax.swing.JLabel labelerror7;
    public javax.swing.JLabel labelerror8;
    public javax.swing.JLabel labelerror9;
    // End of variables declaration//GEN-END:variables
}
