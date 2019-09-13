package gestionclientes;

import java.sql.Connection;
public class GestionClientes {

	public static void main(String[] args) {
		 new Conexion("tienda");
		 Connection con = Conexion.getConexion();
		 System.out.println("Conexi�n Correcta");
		 View vista = new View();
		 Controller controlador = new Controller(vista);
		 vista.conectaControlador(controlador);
		

	}

}
