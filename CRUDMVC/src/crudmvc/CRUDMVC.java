// Cuando error time zone ejecuta en MySQL Workbench lo siguiente (España)
// SET GLOBAL time_zone = '+1:00';
package crudmvc;

import controlador.CtrlProducto;
import modelo.ConsultasProducto;
import modelo.Producto;
import vista.frmProducto;
import modelo.Conexion;



public class CRUDMVC {

   
    public static void main(String[] args) {
        
//        Conexion con = new Conexion();
//        con.getConexion();
        
 
        Producto mod = new Producto();
        ConsultasProducto modC = new ConsultasProducto();
        frmProducto frm = new frmProducto();
        
        CtrlProducto ctrl = new CtrlProducto(mod, modC, frm);
        ctrl.iniciar();
        frm.setVisible(true);
    }
    
}
