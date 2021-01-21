package Ventanas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import BaseDatos.BD;
import Datos.Hotel;
import Datos.Oferta;
import Datos.Producto;
import Datos.Visita;
import Datos.Vuelo;

public class PanelCentral extends JPanel{

	public PanelCentral() {
		this.setLayout(new GridLayout(2, 2));
		
		

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


		this.add(aHotel);
		this.add(aOferta);
		this.add(aVisita);
		this.add(aVuelo);

	}
}
