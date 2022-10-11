
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion_bd {
    
    public static Connection getConnection() {
        Connection cn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/pro_hospi", "root", "");
//            System.out.println("se conecto");

        } catch (Exception e) {
//            System.out.println("no se conecto");
        }
        return cn;
    }
}
