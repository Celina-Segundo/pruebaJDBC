/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primer_intento_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Alumno
 */
public class Primer_intento_jdbc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        // TODO code application logic here
        Connection con;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/personal";
            con = DriverManager.getConnection(url, "root", "root");

            // obtener datos de la base de datos
            String sql = "SELECT nombre,salario FROM empleado";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            
            while (rs.next()) {
            String s = rs.getString("Nombre");
            int x = rs.getInt("Salario");
            System.out.println("Fila = " + x + " | " + s );
            }

        } catch (SQLException ex) {
            con = null;
            ex.printStackTrace();
            System.out.println("SQLExeption: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

}
