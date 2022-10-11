package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class horarioDAO {

    Connection con;
    Conexion_bd cn = new Conexion_bd();
    PreparedStatement ps;
    ResultSet rs;
    int r = 0;

    public int guardarHorario(horario hor) {
        String sql = "INSERT INTO disponibilidad(nom_doctor, especialidad, fecha, hora)"
                + "VALUES (?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, hor.getNom_doctor());
            ps.setString(2, hor.getEspecialidad());
            ps.setDate(3, hor.getFecha_dispo());
            ps.setTime(4, hor.getHora_dispo());
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

    public List ListarDisponibilidad() {
        String sql = "SELECT * FROM disponibilidad";
        List<horario> ListaDis = new ArrayList(); //parace que el tamaño aumenta...

        try {
            con = Conexion_bd.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                horario ho = new horario();
                ho.setId_dispo(rs.getInt("id_dispo"));
                ho.setNom_doctor(rs.getString("nom_doctor"));
                ho.setEspecialidad(rs.getString("especialidad"));
                ho.setFecha_dispo(rs.getDate("fecha"));
                ho.setHora_dispo(rs.getTime("hora"));
                ListaDis.add(ho);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaDis;
    }

    public boolean deleteDisponibilidad(int id_dis) {
        String sql = "DELETE FROM disponibilidad where id_dispo=?";

        try {
            con = Conexion_bd.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_dis);
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

    public boolean acutalizarDisponibilidad(horario hor) {

        String sql = "update disponibilidad set nom_doctor=?, especialidad=?, fecha=?, hora=? where id_dispo=?";
        try {
            con = Conexion_bd.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, hor.getNom_doctor());
            ps.setString(2, hor.getEspecialidad());
            ps.setDate(3, hor.getFecha_dispo());
            ps.setTime(4, hor.getHora_dispo());
            ps.setInt(5, hor.getId_dispo());
            ps.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }

    }

    public ArrayList<horario> buscarDisponibilidadXEspecialidad(String dis_especialidad) {
        //BUSCAR EN VISTA CLIENTE POR NOMBRE
        //String sql = "SELECT * FROM clientes";
        ArrayList<horario> listaHora = new ArrayList();
        String sql = "SELECT * FROM disponibilidad WHERE especialidad LIKE '" + dis_especialidad + "%'";
        try {
            con = Conexion_bd.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                horario hor = new horario();
                hor.setId_dispo(rs.getInt(1));
                hor.setNom_doctor(rs.getString(2));
                hor.setEspecialidad(rs.getString(3));
                hor.setFecha_dispo(rs.getDate(4));
                hor.setHora_dispo(rs.getTime(5));
                listaHora.add(hor);
            }
            con.close();// importante, ya que estan metodo se ejecutan muchos canexion y el servidor conlapsa. 
            // cerrar la conexion cada que se escribe una letra o se borra
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return listaHora;
    }

    public usuario validar(String usuario, String contraseña) {
        usuario usu = new usuario();
        String sql = "SELECT * FROM usuario WHERE usuario=? AND contraseña=?";
        try {
            con = Conexion_bd.getConnection(); //metodo static
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, contraseña);
            rs = ps.executeQuery();
            if (rs.next()) {

                usu.setId_usua(rs.getInt("id_usua"));
                usu.setUsuario(rs.getString("usuario"));
                usu.setContraseña(rs.getString("contraseña"));
                usu.setNombre(rs.getString("nombre"));
                usu.setCargo(rs.getString("cargo"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return usu;
    }

    //Metodos para jalar datos en otras ventanas
    public List ListarDoctorEnHorario() {
        String sql = "SELECT * FROM medicos";
        List<medico> ListaDocHorario = new ArrayList();

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                medico me = new medico();
                me.setId_medico(rs.getInt("id_medico"));
                me.setNombre_medico(rs.getString("nombre_medico"));
                ListaDocHorario.add(me);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaDocHorario;
    }

    public List listarEnHorarioSegunDoctor(String nombre_doctor) { // listarEspecialidadEnHorarioSegunDoctor
        String sql = "SELECT especialidad FROM medicos where nombre_medico=?";
        //String sql = "SELECT nom_doctor FROM disponiblidad where especialidad=?";
        //String sql = "SELECT fecha,hora FROM disponiblidad where nom_doctor=?";
        List<medico> ListaEsMedico = new ArrayList();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre_doctor);
            rs = ps.executeQuery();
            while (rs.next()) {
                medico es = new medico();
                es.setEspecialidad(rs.getString("especialidad"));
                ListaEsMedico.add(es);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaEsMedico;
    }

}
