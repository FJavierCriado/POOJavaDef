package gestionclientes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Conexion {
    
    
    private final String user = "root";
    private final String password = "admin";
    private final String url = "jdbc:mysql://localhost:3306";
    private String servidor = null;
    private static Connection con = null;
    
    public Conexion(String baseDatos){
        
    	
    	Statement stmt = null;
    	
    	this.servidor = url + "/" + baseDatos + "?serverTimezone=UTC";
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           con = DriverManager.getConnection(this.servidor, this.user, this.password);
           stmt = con.createStatement();
           // Set time_zone in MySQL for Spain. Sino ponemos UTC arriba dar�a error 
           // y no se ejecutar�a la siguiente l�nea
           stmt.executeUpdate("SET GLOBAL time_zone = '+1:00'");
        }
        catch (ClassNotFoundException ex) {
            System.err.print("ERROR AL RESGISTRAR EL DRIVER: " + ex);
            System.exit(0);
        }
        catch(SQLException ex){
        	System.err.print("ERROR AL CONECTAR CON EL SERVIDOR: " + ex);
            System.exit(0);
        } 
        
        System.out.println("Conectado a la base de datos:" + baseDatos);
    
    }
    
    public static Connection getConexion()
    {
    	return con;
    }
}