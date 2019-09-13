
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    private final String base = "tienda";
    private final String user = "root";
    private final String password = "admin";
    private final String url = "jdbc:mysql://localhost:3306/" +  base + "?serverTimezone=UTC";
    private Connection con = null;
    
    public Connection getConexion(){
        
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           con = DriverManager.getConnection(this.url, this.user, this.password);
        }
        catch(SQLException e){
            System.err.print(e);
        } 
        catch (ClassNotFoundException ex) {
            System.err.println(ex);
        }
        
        return con;
    }
}
