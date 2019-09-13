package gestionclientes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Controller implements ActionListener, MouseListener {
	
	private View vista;
	
	public Controller(View frm) {
		this.vista = frm;
		cargarTabla();
	}
	
	// M�todo que resetea los campos del formulario
	private void limpiar()
	{
		this.vista.txtNIF.setText("");
		this.vista.txtNombre.setText("");
		this.vista.txtApellido.setText("");
	}
	
	// Carga los datos procedente de la BD al formulario
	private void cargarTabla() {
		
		// Declarar variables
		CallableStatement cs = null;
		String sql = null;
		ResultSet rs = null;
		Vector<Object> fila = null;
		//Object[] fila = null;
		int t_filas = 0;
		
		// Limpiar los datos de la tabla
		t_filas = this.vista.dtm.getRowCount();
		for(int i=t_filas; i>0; i--) {
			this.vista.dtm.removeRow(i-1);
		}
		
		// Cargar datos de la tabla
		try{
			sql = "{CALL obtenerClientes()}";
			cs = Conexion.getConexion().prepareCall(sql);
			rs = cs.executeQuery();
			
			while(rs.next()){
				fila = new Vector<Object>();
				fila.add(rs.getInt("id"));
				fila.add(rs.getString("nif"));
				fila.add(rs.getString("nombre"));
			  //alternativo
			  //fila = new Object[]{rs.getInt("id"), rs.getString("nif"), rs.getString("nombre")};
			  
				this.vista.dtm.addRow(fila);
			}
		}
		catch(SQLException e) {
			System.err.println("Error al CARGAR DATOS");
		}
			
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// Declarar variables
		CallableStatement cs = null;
		String sql = null;
		ResultSet rs = null;
		int filaPulsada = 0;
		int identificador = 0;
		
		filaPulsada = this.vista.tabla.getSelectedRow();
	
		if(filaPulsada >= 0) {
			// Obtener el campo id de la fila pulsada
			identificador = (int)this.vista.dtm.getValueAt(filaPulsada, 0);
			try{
				sql = "{CALL obtenerCliente(?)}";
				cs = Conexion.getConexion().prepareCall(sql);
				cs.setInt(1, identificador);
				rs = cs.executeQuery();
				
				if(rs.next()){
					this.vista.txtNIF.setText(rs.getString(1));
					this.vista.txtNombre.setText(rs.getString(2));
					this.vista.txtApellido.setText(rs.getString(3));
				}
			}
			catch(SQLException e) {
				System.err.println("Error al CARGAR DATOS");
			}
		}
		

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// Objeto para invocar los procedimientos almacenados de BD
		CallableStatement cs = null;
		String sql = null;
		
		int filaPulsada = 0;
		int identificador = 0;
		
		// Obtener el bot�n ejecutado
		String accion = arg0.getActionCommand();
		
		//System.out.println("Acci�n: " + accion);
		
		switch(accion) {
			case "INSERTAR":
				try{
					sql = "{CALL insertarCliente(?,?,?)}";
					cs = Conexion.getConexion().prepareCall(sql);
					
					//Obtener los par�metros de la vista
					cs.setString(1, this.vista.txtNIF.getText());
					cs.setString(2, this.vista.txtNombre.getText());
					cs.setString(3, this.vista.txtApellido.getText());
					
					// Ejecutar el procedimiento
					cs.execute();
					
					this.vista.lblStatus.setText("Registro Insertado");	
				}
				catch(SQLException e) {
					System.err.println("Error en la INSERCI�N:" + sql);
				}
				break;
			case "ELIMINAR":
				filaPulsada = this.vista.tabla.getSelectedRow();
				
				if(filaPulsada >= 0) {
					// Obtener el campo id de la fila pulsada
					identificador = (int)this.vista.dtm.getValueAt(filaPulsada, 0);
					try{
						sql = "{CALL eliminarCliente(?)}";
						cs = Conexion.getConexion().prepareCall(sql);
						
						//Obtener los par�metros de la vista
						cs.setInt(1, identificador);
						
						// Ejecutar el procedimiento
						cs.execute();
					
						this.vista.lblStatus.setText("Registro Eliminado");	
					}
					catch(SQLException e) {
						System.err.println("Error en la ELIMINACI�N:" + sql);
					}
				}
				break;
			case "MODIFICAR":
				
				filaPulsada = this.vista.tabla.getSelectedRow();
				
				if(filaPulsada >= 0) {
					// Obtener el campo id de la fila pulsada
					identificador = (int)this.vista.dtm.getValueAt(filaPulsada, 0);
					try{
						sql = "{CALL modificarCliente(?,?,?,?)}";
						cs = Conexion.getConexion().prepareCall(sql);
						//System.out.println(sql);
						//Obtener los par�metros de la vista
						cs.setInt(1, identificador);
						cs.setString(2, this.vista.txtNIF.getText());
						cs.setString(3, this.vista.txtNombre.getText());
						cs.setString(4, this.vista.txtApellido.getText());
						
						// Ejecutar el procedimiento
						cs.execute();
						
						this.vista.lblStatus.setText("Registro Modificado");	
					}
					catch(SQLException e) {
						System.err.println("Error en la MODIFICACI�N:" + sql);
					}
				}
				break;
				
			default:
				System.err.println("Accion no válida");
		}
		
		// Resetea el formulario
		limpiar();
		
		// Actualiza la tabla (refresh)
		cargarTabla();
		
		

	}

}
