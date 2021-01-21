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

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BaseDatos.BD;
import Datos.Hotel;
import Datos.Oferta;
import Datos.Producto;
import Datos.Visita;
import Datos.Vuelo;

import javax.naming.BinaryRefAddr;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Admin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {


		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
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

		JPanel panelCentral = new JPanel();
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
		panelCentral.add(aVuelo);

		contentPane.add(panelCentral, BorderLayout.CENTER);
		JLabel label = new JLabel("VENTANA DE ADMINISTRACIÓN");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 19));
		contentPane.add(label, BorderLayout.NORTH);

	}


}
