package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class pacienteDAO {

    Connection con;
    Conexion_bd cn = new Conexion_bd();
    PreparedStatement ps;
    ResultSet rs;

    int r = 0;

    public int guardarPaciente(paciente pac) {
        String sql = "INSERT INTO paciente(dni_pa, nombre_pa, apellidopat_pa,apellidomat_pa,genero_pa,edad_pa,"
                + "telefono_pa,correo_pa,seguro_pa,fecha_pa) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, pac.getDni_pa());
            ps.setString(2, pac.getNombre_pa());
            ps.setString(3, pac.getApellidopat_pa());
            ps.setString(4, pac.getApellidomat_pa());
            ps.setString(5, pac.getGenero_pa());
            ps.setInt(6, pac.getEdad_pa());
            ps.setInt(7, pac.getTelefono_pa());
            ps.setString(8, pac.getCorreo_pa());
            ps.setString(9, pac.getSeguro_pa());
            ps.setDate(10, pac.getFechanac_pa());

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

    public List ListarPaciente() {
        String sql = "SELECT * FROM paciente";
        List<paciente> ListaPa = new ArrayList();

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                paciente pa = new paciente();
                pa.setId_paciente(rs.getInt("id_paciente"));
                pa.setDni_pa(rs.getInt("dni_pa"));
                pa.setNombre_pa(rs.getString("nombre_pa"));
                pa.setApellidopat_pa(rs.getString("apellidopat_pa"));
                pa.setApellidomat_pa(rs.getString("apellidomat_pa"));
                pa.setGenero_pa(rs.getString("genero_pa"));
                pa.setEdad_pa(rs.getInt("edad_pa"));
                pa.setTelefono_pa(rs.getInt("telefono_pa"));
                pa.setCorreo_pa(rs.getString("correo_pa"));
                pa.setSeguro_pa(rs.getString("seguro_pa"));
                pa.setFechanac_pa(rs.getDate("fecha_pa"));

                ListaPa.add(pa);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaPa;
    }

    public boolean deletePaciente(int dni_pa) {
        String sql = "DELETE FROM paciente where dni_pa=?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, dni_pa);
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

    public paciente buscarPacienteCita(int dni) {
        //BUSCAR EN VISTA CITA POR DNI
        paciente pa = new paciente();
        String sql = "SELECT * FROM paciente WHERE dni_pa=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            rs = ps.executeQuery();
            if (rs.next()) {
                pa.setNombre_pa(rs.getString("nombre_pa"));
                pa.setApellidopat_pa(rs.getString("apellidopat_pa"));
                pa.setApellidomat_pa(rs.getString("apellidomat_pa"));
                pa.setGenero_pa(rs.getString("genero_pa"));
                pa.setEdad_pa(rs.getInt("edad_pa"));
                pa.setTelefono_pa(rs.getInt("telefono_pa"));
                pa.setCorreo_pa(rs.getString("correo_pa"));
                pa.setSeguro_pa(rs.getString("seguro_pa"));
                pa.setFechanac_pa(rs.getDate("fecha_pa"));
            }

        } catch (SQLException e) {
            System.out.println(e.toString());

        }
        return pa;
    }

    public boolean editarPaciente(paciente pa) {

        String sql = "update paciente set dni_pa=?, nombre_pa=?, apellidopat_pa=?, apellidomat_pa=?, "
                + "genero_pa=?, edad_pa=?, telefono_pa=?, correo_pa=?, seguro_pa=?, fecha_pa=? where id_paciente=?";
        try {
            //con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, pa.getDni_pa());
            ps.setString(2, pa.getNombre_pa());
            ps.setString(3, pa.getApellidopat_pa());
            ps.setString(4, pa.getApellidomat_pa());
            ps.setString(5, pa.getGenero_pa());
            ps.setInt(6, pa.getEdad_pa());
            ps.setInt(7, pa.getTelefono_pa());
            ps.setString(8, pa.getCorreo_pa());
            ps.setString(9, pa.getSeguro_pa());
            ps.setDate(10, pa.getFechanac_pa());
            ps.setInt(11, pa.getId_paciente());
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

    public ArrayList<paciente> buscarPacienteXDni(int Dni) {
        //BUSCAR EN VISTA PACIENTE POR DNI
        ArrayList<paciente> listaPac = new ArrayList();
        String sql = "SELECT * FROM paciente WHERE dni_pa LIKE '" + Dni + "%'";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                paciente pac = new paciente();
                pac.setId_paciente(rs.getInt(1));
                pac.setDni_pa(rs.getInt(2));
                pac.setNombre_pa(rs.getString(3));
                pac.setApellidopat_pa(rs.getString(4));
                pac.setApellidomat_pa(rs.getString(5));
                pac.setGenero_pa(rs.getString(6));
                pac.setEdad_pa(rs.getInt(7));
                pac.setTelefono_pa(rs.getInt(8));
                pac.setCorreo_pa(rs.getString(9));
                pac.setSeguro_pa(rs.getString(10));
                pac.setFechanac_pa(rs.getDate(11));

                listaPac.add(pac);
            }
            con.close();// importante, ya que estan metodo se ejecutan muchos canexion y el servidor conlapsa. 
            // cerrar la conexion cada que se escribe una letra o se borra
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return listaPac;
    }

}
