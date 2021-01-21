package Ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle.Control;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BaseDatos.BD;
import Datos.CompraOferta;
import Datos.CompraProducto;
import Datos.Hotel;
import Datos.Oferta;
import Datos.Producto;
import Datos.TienePrecio;
import Datos.Visita;
import Datos.Vuelo;

import javax.naming.BinaryRefAddr;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Admin extends JFrame {

	private JPanel contentPane,panelCentral,panelCompras;

	/**
	 * Launch the application.
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {


		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin(new PanelCentral());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	//

	/**
	 * Create the frame.
	 */
	public Admin(JPanel panel) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int alturaPantalla;
		int anchuraPantalla;
		Toolkit mipantalla = Toolkit.getDefaultToolkit(); 
		Dimension tamanoPantalla = mipantalla.getScreenSize(); 
		alturaPantalla = tamanoPantalla.height; 
		anchuraPantalla = tamanoPantalla.width; 

		setBounds(anchuraPantalla/4, alturaPantalla/4, 804, 614);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JButton btnNewButton = new JButton("Inicio");
		contentPane.add(btnNewButton, BorderLayout.SOUTH);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Bienvenido bienvenido= new Bienvenido();
				bienvenido.setVisible(true);dispose();
			}
		});	

		/*panelCentral = new JPanel();
		panelCentral.setLayout(new GridLayout(2, 2));
		
		

		JButton aHotel= new JButton("Añadir Hotel");
		JButton aOferta= new JButton("Añadir Oferta");
		JButton aVuelo= new JButton("Añadir Vuelo");
		JButton aVisita= new JButton("Añadir Visita");


		aHotel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre= JOptionPane.showInputDialog("Nombre Del Hotel");
				String ciudad= JOptionPane.showInputDialog("Nombre De La Ciudad");
				int estrellas= Integer.parseInt(JOptionPane.showInputDialog("Numero De Estrellas"));
				
				Hotel hotel = new Hotel(nombre, ciudad, estrellas);
				BD.anyadirHotel(hotel);
				JOptionPane.showMessageDialog(null, "Hotel añadido correctamente");

			}
		});
		aOferta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String codHotel= JOptionPane.showInputDialog("Codigo Del Hotel");
				double precioA= Integer.parseInt(JOptionPane.showInputDialog("Precio Por Adulto"));
				double precioM= Integer.parseInt(JOptionPane.showInputDialog("Precio Por Menor"));

				Oferta ofer= new Oferta(codHotel, precioA, precioM);
				BD.anyadirOferta(ofer);
				JOptionPane.showMessageDialog(null, "Oferta añadida correctamente");

			}
		});

		aVuelo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String origen= JOptionPane.showInputDialog("Lugar De Origen");
				String des= JOptionPane.showInputDialog("Lugar De Destino");
				String feyh= JOptionPane.showInputDialog("Fecha y hora (dd/mm/aaaa hh:mm)");
				

				double precio= Integer.parseInt(JOptionPane.showInputDialog("Precio "));
				double duracion= Integer.parseInt(JOptionPane.showInputDialog("Duracion (Horas)"));

				Producto vuelo= new Vuelo(origen, des, feyh, precio, duracion);
				
				BD.anyadirProducto(vuelo);
				JOptionPane.showMessageDialog(null, "Vuelo añadido correctamente");
			}
		});

		aVisita.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String lugarInteres= JOptionPane.showInputDialog("Lugar De Interés");
				String ciudad= JOptionPane.showInputDialog("Ciudad");
				

				double valoracion= Integer.parseInt(JOptionPane.showInputDialog("Valoración (s/5)"));
				double precio= Integer.parseInt(JOptionPane.showInputDialog("Precio"));
				double duracion= Integer.parseInt(JOptionPane.showInputDialog("Duracion (Horas)"));

				Producto visita= new Visita(lugarInteres, ciudad, valoracion, precio, duracion);
				
				
				BD.anyadirProducto(visita);
				JOptionPane.showMessageDialog(null, "Visita añadida correctamente");

			}
		});


		panelCentral.add(aHotel);
		panelCentral.add(aOferta);
		panelCentral.add(aVisita);
		panelCentral.add(aVuelo);*/

		contentPane.add(panel, BorderLayout.CENTER);
		JLabel label = new JLabel("VENTANA DE ADMINISTRACIÓN");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 19));
		contentPane.add(label, BorderLayout.NORTH);
		
		JButton btnVerCompras = new JButton("VER TODAS LAS COMPRAS");
		JPanel pSur = new JPanel();
		pSur.add(btnVerCompras);
		getContentPane().add(pSur,BorderLayout.SOUTH);
		
		
		/*panelCompras = new JPanel(new BorderLayout());
		JButton btnAtras = new JButton("VOLVER");
		panelCompras.add(btnAtras, BorderLayout.SOUTH);
		
		DefaultTableModel modeloTabla = new DefaultTableModel();
		String identificadores[] = {"USUARIO","PRECIO","TIPO"};
		modeloTabla.setColumnIdentifiers(identificadores);
		
		TreeMap<String, ArrayList<TienePrecio>> tm = BD.obtenerComprasPorUsuario();
		for(String usuario: tm.keySet()) {
			for(TienePrecio tp: tm.get(usuario)) {
				if(tp instanceof CompraOferta) {
					CompraOferta co = (CompraOferta)tp;
					String fila[] = {co.getUsuario().getUsuario(),String.valueOf(co.getPrecio()),"OFERTA"};
					modeloTabla.addRow(fila);
				}else {
					CompraProducto cp = (CompraProducto)tp;
					if(cp.getCodigoComprado().substring(0, 2).equals("VI")) {
						String fila[] = {cp.getUsuario().getUsuario(),String.valueOf(cp.getPrecio()),"VISITA"};
						modeloTabla.addRow(fila);
					}else {
						String fila[] = {cp.getUsuario().getUsuario(),String.valueOf(cp.getPrecio()),"VUELO"};
						modeloTabla.addRow(fila);
					}
				}
			}
		}
		JTable tablaCompras = new JTable(modeloTabla);
		JScrollPane scrollTabla = new JScrollPane(tablaCompras);
		panelCompras.add(scrollTabla,BorderLayout.CENTER);
		
		btnAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				contentPane.add(panelCentral,BorderLayout.CENTER);
			}
		});*/

		JFrame v = this;
		btnVerCompras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				v.dispose();
				Admin a = new Admin(new PanelCompras());
				a.setVisible(true);
			}
		});
		

	}

}
