package gestionclientes;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

public class View extends JFrame {
	
	// **** ATRIBUTOS ****
	
	private JPanel contenedor;
	
	// Etiquetas
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblNIF;
	protected JLabel lblStatus;
	
	// Cuadros de texto
	protected JTextField txtNombre;
	protected JTextField txtApellido;
	protected JTextField txtNIF;
	
	// Botones
	protected JButton btnAdd;
	protected JButton btnDel;
	protected JButton btnUpd;
	
	// Panel que contiene la tabla
	private JScrollPane scroll;
	// Cabecera de la tabla
	protected String[] cabecera;
	// Cuerpo de la tabla
	protected Object[][] datos;
	//Unión de la cabeera y la tabla
	protected DefaultTableModel dtm;
	// La tabla
	protected JTable tabla;
	//Para agilizar la coloación de los controles
        private final String OESTE=SpringLayout.WEST;
        private final String SUR=SpringLayout.SOUTH;
        private final String NORTE=SpringLayout.NORTH;
        private final String ESTE=SpringLayout.EAST;
	// **** MÉTODOS ****
	public View() {
            
            setBounds(100,100,450,350);
            setTitle("GESTIÓN DE CLIENTES");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            //Añadimos el panel al JFrame
            contenedor = new JPanel();
            getContentPane().add(contenedor);
            //Usar SpringLayout para disposición de controles
            SpringLayout layout = new SpringLayout();
            contenedor.setLayout(layout);
            //Etiqueta NIF
            lblNIF = new JLabel("NIF:");
            contenedor.add(lblNIF);
            layout.putConstraint(NORTE, lblNIF, 10, NORTE, contenedor);
            layout.putConstraint(OESTE, lblNIF, 10, OESTE, contenedor);
            
            lblNombre = new JLabel("Nombre:");
            contenedor.add(lblNombre);
            layout.putConstraint(NORTE, lblNombre, 50, NORTE, contenedor);
            layout.putConstraint(OESTE, lblNombre, 10, OESTE, contenedor);
            
            lblApellido = new JLabel("Apellido:");
            contenedor.add(lblApellido);
            layout.putConstraint(NORTE, lblApellido, 90, NORTE, contenedor);
            layout.putConstraint(OESTE, lblApellido, 10, OESTE, contenedor);
            
            txtNIF = new JTextField();
            contenedor.add(txtNIF);
            layout.putConstraint(NORTE, txtNIF, 10, NORTE, contenedor);
            layout.putConstraint(OESTE, txtNIF, 100, OESTE, contenedor);
            layout.putConstraint(ESTE, txtNIF, -150, ESTE, contenedor);
            
            txtNombre = new JTextField();
            contenedor.add(txtNombre);
            layout.putConstraint(NORTE, txtNombre, 50, NORTE, contenedor);
            layout.putConstraint(OESTE, txtNombre, 100, OESTE, contenedor);
            layout.putConstraint(ESTE, txtNombre, -150, ESTE, contenedor);
            
            txtApellido = new JTextField();
            contenedor.add(txtApellido);
            layout.putConstraint(NORTE, txtApellido,90, NORTE, contenedor);
            layout.putConstraint(OESTE, txtApellido, 100, OESTE, contenedor);
            layout.putConstraint(ESTE, txtApellido, -150, ESTE, contenedor);
            
            //Tabla
            scroll = new JScrollPane();
            cabecera = new String[] { "ID", "NIF", "NOMBRE" };
            datos = new Object[][] {{1,2,3},{4,5,6},{7,8,9}};
            dtm = new DefaultTableModel(datos,cabecera);
            tabla = new JTable(dtm);
            scroll.setViewportView(tabla);
            contenedor.add(scroll);
            layout.putConstraint(NORTE, scroll, 120, NORTE, contenedor);
            layout.putConstraint(OESTE, scroll, 10, OESTE, contenedor);
            layout.putConstraint(ESTE, scroll, -10, ESTE, contenedor);
            layout.putConstraint(SUR, scroll, -100, SUR, contenedor);
            //Etiqueta status (Estado)
            lblStatus = new JLabel("");
            contenedor.add(lblStatus);
            layout.putConstraint(SUR,lblStatus, -50, SUR, contenedor);
            layout.putConstraint(ESTE, lblStatus, 10, ESTE, contenedor);
            
            //Botón Insertar
            btnAdd = new JButton("INSERTAR");
            contenedor.add(btnAdd);
            layout.putConstraint(OESTE, btnAdd, 60, OESTE, contenedor);
            layout.putConstraint(SUR, btnAdd, -10, SUR, contenedor);
            
            //Botón Eliminar
            btnDel = new JButton("ELIMINAR");
            contenedor.add(btnDel);
            layout.putConstraint(OESTE, btnDel, 190, OESTE, contenedor);
            layout.putConstraint(SUR, btnDel, -10, SUR, contenedor);
            
            //Botón Modificar
            btnUpd = new JButton("MODIFICAR");
            contenedor.add(btnUpd);
            layout.putConstraint(OESTE, btnUpd, 310, OESTE, contenedor);
            layout.putConstraint(SUR, btnUpd, -10, SUR, contenedor);
            
            //Hacer Formulario (JFrame) visible
            setVisible(true);
	}
	
	public void conectaControlador(Controller c) {
		btnAdd.addActionListener(c);
		btnAdd.setActionCommand("INSERTAR");
		
		btnDel.addActionListener(c);
		btnDel.setActionCommand("ELIMINAR");
		
		btnUpd.addActionListener(c);
		btnUpd.setActionCommand("MODIFICAR");
		
		tabla.addMouseListener(c);
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	
}
