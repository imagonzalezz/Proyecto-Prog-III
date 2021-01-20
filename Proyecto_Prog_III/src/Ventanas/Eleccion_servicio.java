package Ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Datos.TienePrecio;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Eleccion_servicio extends JFrame {
	

	private JPanel contentPane;
	public static ArrayList<TienePrecio> carrito = new ArrayList<>();
	private JButton cerrarSesion;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eleccion_servicio frame = new Eleccion_servicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Eleccion_servicio() {
		JFrame ventana=this;
		int alturaPantalla;
		int anchuraPantalla;
		Toolkit mipantalla = Toolkit.getDefaultToolkit(); 
		Dimension tamanoPantalla = mipantalla.getScreenSize(); 
		alturaPantalla = tamanoPantalla.height; 
		anchuraPantalla = tamanoPantalla.width; 
		
		setBounds(anchuraPantalla/4, alturaPantalla/4, 804, 614);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		JPanel panelcentro= new JPanel(new GridLayout(3,1));
		JLabel eleccion= new JLabel("ELECCIÓN DE SERVICIO");
		eleccion.setFont(new Font("Tahoma", Font.BOLD, 20));
		eleccion.setHorizontalAlignment(SwingConstants.CENTER);
		panelcentro.add(eleccion);
		
		
		JPanel panelf2 = new JPanel(new GridLayout(1,3));
		
		
		JButton cerrarSesion= new JButton("Cerrar sesion");
		contentPane.add(cerrarSesion, BorderLayout.SOUTH);
		
		cerrarSesion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Bienvenido b= new Bienvenido();
				b.setVisible(true);dispose();
			}
		} );
		
		
		
		JButton b1 = new JButton("");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				V_Ofertas v= new V_Ofertas(ventana);
				v.setVisible(true);ventana.setVisible(false);
;
			}
		});
		b1.setIcon(new ImageIcon(Eleccion_servicio.class.getResource("/Ventanas/Icono_Ahorro.png")));
		JButton b2= new JButton("");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				V_Vuelos v = new V_Vuelos(ventana);
				v.setVisible(true);ventana.setVisible(false);
			}
		});
		b2.setIcon(new ImageIcon(Eleccion_servicio.class.getResource("/Ventanas/Icono_Vuelo.png")));
		JButton b3 = new JButton("");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				V_Visitas v = new V_Visitas(ventana);
				v.setVisible(true);ventana.setVisible(false);

			}
		});
		b3.setIcon(new ImageIcon(Eleccion_servicio.class.getResource("/Ventanas/Icono_Visita.png")));

		
		panelf2.add(b1);panelf2.add(b2);panelf2.add(b3);

		
		panelcentro.add(panelf2);
		
		JPanel panelabajo = new JPanel(new GridLayout(1,3));
		
		JLabel t1= new JLabel("OFERTAS");
		t1.setHorizontalAlignment(SwingConstants.CENTER);
		t1.setVerticalAlignment(SwingConstants.TOP);
		JLabel t2= new JLabel("VUELOS");
		t2.setHorizontalAlignment(SwingConstants.CENTER);
		t2.setVerticalAlignment(SwingConstants.TOP);
		JLabel t3= new JLabel("VISITAS");
		t3.setHorizontalAlignment(SwingConstants.CENTER);
		t3.setVerticalAlignment(SwingConstants.TOP);
		
		panelabajo.add(t1);	panelabajo.add(t2);panelabajo.add(t3);
		
		panelcentro.add(panelabajo);
		
		contentPane.add(panelcentro, BorderLayout.CENTER);
		
		
		
	}


}
