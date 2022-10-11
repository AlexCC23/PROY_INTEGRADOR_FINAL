package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class medicoDAO {

    Connection con;
    Conexion_bd cn = new Conexion_bd();
    PreparedStatement ps;
    ResultSet rs;
    int r = 0;

    public int guardarMedico(medico med) {
        String sql = "INSERT INTO medicos(dni_medico, nombre_medico, apellidos_medico, especialidad)"
                + "VALUES (?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, med.getDni_medico());
            ps.setString(2, med.getNombre_medico());
            ps.setString(3, med.getApellidos_medico());
            ps.setString(4, med.getEspecialidad());

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

    public List ListarMedico() {
        String sql = "SELECT * FROM medicos";
        List<medico> ListaMed = new ArrayList();

        try {
            con = Conexion_bd.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                medico med = new medico();
                med.setId_medico(rs.getInt("id_medico"));
                med.setDni_medico(rs.getInt("dni_medico"));
                med.setNombre_medico(rs.getString("nombre_medico"));
                med.setApellidos_medico(rs.getString("apellidos_medico"));
                med.setEspecialidad(rs.getString("especialidad"));
                ListaMed.add(med);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaMed;
    }

    public boolean deleteMedico(int dni_medico) {
        String sql = "DELETE FROM medicos where dni_medico=?";

        try {
            con = Conexion_bd.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, dni_medico);
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

    public boolean acutalizarMedico(medico med) {

        String sql = "update medicos set dni_medico=?, nombre_medico=?,apellidos_medico=?,especialidad=? where id_medico=?";
        try {
            con = Conexion_bd.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, med.getDni_medico());
            ps.setString(2, med.getNombre_medico());
            ps.setString(3, med.getApellidos_medico());
            ps.setString(4, med.getEspecialidad());
            ps.setInt(5, med.getId_medico());
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

    public ArrayList<medico> buscarMedicoXDni(int Dni) {
        ArrayList<medico> listaMe = new ArrayList();
        String sql = "SELECT * FROM medicos WHERE dni_medico LIKE '" + Dni + "%'";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                medico me = new medico();
                me.setId_medico(rs.getInt(1));
                me.setDni_medico(rs.getInt(2));
                me.setNombre_medico(rs.getString(3));
                me.setApellidos_medico(rs.getString(4));
                me.setEspecialidad(rs.getString(5));

                listaMe.add(me);
            }
            con.close();// importante, ya que estan metodo se ejecutan muchos canexion y el servidor conlapsa. 
            // cerrar la conexion cada que se escribe una letra o se borra
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return listaMe;
    }

}
