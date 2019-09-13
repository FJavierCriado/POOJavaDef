/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author usuario
 */
public class Conexion {
    private final String base = "tienda";
    private final String user = "root";
    private final String password = "admin";
    private final String url ="jdbc:mysql://localhost:3306/" + base;
    private Connection con = null;
    
    public Connection getConextion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(this.url,this.user,this.password);
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e);
        }
        return con;
    }
    
}
