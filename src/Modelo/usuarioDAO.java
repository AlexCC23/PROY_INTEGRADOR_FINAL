package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class usuarioDAO {

    Connection con;
    Conexion_bd cn = new Conexion_bd();
    PreparedStatement ps;
    ResultSet rs;

    int r = 0;

    public int guardarUsuario(usuario usu) {
        String sql = "INSERT INTO usuario(usuario, contraseña, nombre, cargo)"
                + "VALUES (?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, usu.getUsuario());
            ps.setString(2, usu.getContraseña());
            ps.setString(3, usu.getNombre());
            ps.setString(4, usu.getCargo());

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

    public List ListarUsuario() {
        String sql = "SELECT * FROM usuario";
        List<usuario> ListaUs = new ArrayList(); //parace que el tamaño aumenta...

        try {
            con = Conexion_bd.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                usuario us = new usuario();
                us.setId_usua(rs.getInt("id_usua"));
                us.setUsuario(rs.getString("usuario"));
                us.setContraseña(rs.getString("contraseña"));
                us.setNombre(rs.getString("nombre"));
                us.setCargo(rs.getString("cargo"));
                ListaUs.add(us);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaUs;
    }

    public boolean deleteUsuario(int id_u) {
        String sql = "DELETE FROM usuario where id_usua=?";

        try {
            con = Conexion_bd.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_u);
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

    public boolean acutalizarUsuario(usuario usu) {

        String sql = "update usuario set nombre=?, usuario=?,contraseña=?,cargo=? where id_usua=?";
        try {
            con = Conexion_bd.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, usu.getNombre());
            ps.setString(2, usu.getUsuario());
            ps.setString(3, usu.getContraseña());
            ps.setString(4, usu.getCargo());
            ps.setInt(5, usu.getId_usua());
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

    public ArrayList<usuario> buscarUsuarioXUsuario(String usuario) {
        //BUSCAR EN VISTA CLIENTE POR NOMBRE
        //String sql = "SELECT * FROM clientes";
        ArrayList<usuario> listaUsua = new ArrayList();
        String sql = "SELECT * FROM usuario WHERE usuario LIKE '" + usuario + "%'";
        try {
            con = Conexion_bd.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                usuario us = new usuario();
                us.setId_usua(rs.getInt(1));
                us.setUsuario(rs.getString(2));
                us.setContraseña(rs.getString(3));
                us.setNombre(rs.getString(4));
                us.setCargo(rs.getString(5));
                listaUsua.add(us);
            }
            con.close();// importante, ya que estan metodo se ejecutan muchos canexion y el servidor conlapsa. 
            // cerrar la conexion cada que se escribe una letra o se borra
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return listaUsua;
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
}
