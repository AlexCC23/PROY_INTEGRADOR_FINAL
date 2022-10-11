package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class especialidadDAO {

    Connection con;
    Conexion_bd cn = new Conexion_bd();
    PreparedStatement ps;
    ResultSet rs;
    int r = 0;

    public int guardarespecialidad(especialidad es) {
        String sql = "INSERT INTO especialidad (nom_espec) " + "VALUES (?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, es.getNom_espec());

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

    public List ListarEsspecialidad() {
        String sql = "SELECT * FROM especialidad";
        List<especialidad> ListaEs = new ArrayList();

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                especialidad es = new especialidad();
                es.setId_especialidad(rs.getInt("id_especialidad"));
                es.setNom_espec(rs.getString("nom_espec"));
                ListaEs.add(es);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaEs;
    }
    public List ListarEsspecialidadenDoctor() {
        String sql = "SELECT * FROM especialidad";
        List<especialidad> ListaEspecialidadDoctor = new ArrayList();

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                especialidad es = new especialidad();
                es.setId_especialidad(rs.getInt("id_especialidad"));
                es.setNom_espec(rs.getString("nom_espec"));
                ListaEspecialidadDoctor.add(es);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaEspecialidadDoctor;
    }

    public boolean deleteEspecialidad(String nom) {
        String sql = "DELETE FROM especialidad where nom_espec=?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nom);
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
    
    public boolean editarEspecialidad(especialidad espe) {

        String sql = "update especialidad set nom_espec=? where id_especialidad=?";
        try {
            //con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1,  espe.getNom_espec());
            ps.setInt(2, espe.getId_especialidad());
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
     public ArrayList<especialidad> buscarEspecialidadXnombre(String nombre) {
        ArrayList<especialidad> listaEspe = new ArrayList();
        String sql = "SELECT * FROM especialidad WHERE nom_espec LIKE '" + nombre + "%'";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                especialidad espe = new especialidad();
                espe.setId_especialidad(rs.getInt(1));
                espe.setNom_espec(rs.getString(2));

                listaEspe.add(espe);
            }
            con.close();// importante, ya que estan metodo se ejecutan muchos canexion y el servidor conlapsa. 
            // cerrar la conexion cada que se escribe una letra o se borra
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return listaEspe;
    }
    
}
