package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;

public class citaDAO {

    Connection con;
    Conexion_bd cn = new Conexion_bd();
    PreparedStatement ps;
    ResultSet rs;

    int r = 0;

    public int guardarCita(cita ci) {
        String sql = "INSERT INTO cita(dni_paciente, nombre_paciente, apellido_paterno, apellido_materno, "
                + "genero_paciente, edad_paciente, fecha_nacimiento, telefono_paciente, correo_paciente, "
                + "seguro_paciente, nombre_doctor, especialidad, fecha_cita, hora, descripcion_cita, usuario)"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ci.getDni_paciente());
            ps.setString(2, ci.getNombre_paciente());
            ps.setString(3, ci.getApellido_paterno());
            ps.setString(4, ci.getApellido_materno());
            ps.setString(5, ci.getGenero_paciente());
            ps.setInt(6, ci.getEdad_paciente());
            ps.setDate(7, ci.getFecha_nacimiento());
            ps.setInt(8, ci.getTelefono_paciente());
            ps.setString(9, ci.getCorreo_paciente());
            ps.setString(10, ci.getSeguro_paciente());
            ps.setString(11, ci.getNombre_doctor());
            ps.setString(12, ci.getEspecialidad());
            ps.setDate(13, ci.getFecha_cita());
            ps.setTime(14, ci.getHora_cita());
            ps.setString(15, ci.getDescripcion_cita());
            ps.setString(16, ci.getUsuario());

            ps.execute();

        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());

            }
        }
        return r;
    }

    public List listarCitaH() {
        String sql = "SELECT * FROM cita";
        List<cita> ListaCih = new ArrayList();

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cita cih = new cita();
                cih.setId_cita(rs.getInt("id_cita"));
                cih.setDni_paciente(rs.getInt("dni_paciente"));
                cih.setNombre_paciente(rs.getString("nombre_paciente"));
                cih.setApellido_paterno(rs.getString("apellido_paterno"));
                cih.setApellido_materno(rs.getString("apellido_materno"));
                cih.setGenero_paciente(rs.getString("genero_paciente"));
                cih.setEdad_paciente(rs.getInt("edad_paciente"));
                cih.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                cih.setFecha_cita(rs.getDate("fecha_cita"));
                cih.setHora_cita(rs.getTime("hora"));
                cih.setTelefono_paciente(rs.getInt("telefono_paciente"));
                cih.setCorreo_paciente(rs.getString("correo_paciente"));
                cih.setSeguro_paciente(rs.getString("seguro_paciente"));
                cih.setNombre_doctor(rs.getString("nombre_doctor"));
                cih.setEspecialidad(rs.getString("especialidad"));
                cih.setDescripcion_cita(rs.getString("descripcion_cita"));
                cih.setUsuario(rs.getString("usuario"));
                cih.setFecha_regis(rs.getString("fecha_regis"));

                ListaCih.add(cih);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaCih;
    }
    
    public boolean deleteCitaH(int id_cita) {
        String sql = "DELETE FROM cita where id_cita=?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_cita);
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }

    }

    public List listarEnCitaDocSegunEspecialidad(String especialidad) {
        //String sql = "SELECT especialidad FROM medicos where nombre_medico=?";
        String sql = "SELECT nom_doctor FROM disponibilidad where especialidad=?";
        //String sql = "SELECT fecha,hora FROM disponiblidad where nom_doctor=?";
        List<horario> ListaDocEsp = new ArrayList();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, especialidad);
            rs = ps.executeQuery();
            while (rs.next()) {
                horario hor = new horario();
                hor.setNom_doctor(rs.getString("nom_doctor"));
                ListaDocEsp.add(hor);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaDocEsp;
    }

    public List listarEnCitaFechHorSegunDoc(String nom_doc) {

        String sql = "SELECT fecha, hora FROM disponibilidad where nom_doctor=?";
        List<horario> ListaFeHoDoc = new ArrayList();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nom_doc);
            rs = ps.executeQuery();
            while (rs.next()) {
                horario hor = new horario();
                hor.setFecha_dispo(rs.getDate("fecha"));
                hor.setHora_dispo(rs.getTime("hora"));
                ListaFeHoDoc.add(hor);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaFeHoDoc;
    }

}
