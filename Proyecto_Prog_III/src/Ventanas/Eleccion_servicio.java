package Ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Eleccion_servicio extends JFrame {



	private JPanel contentPane;

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
		contentPane.setLayout(null);

		JButton lblNewLabel = new JButton("");
		lblNewLabel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				V_Ofertas ventanaOfertas= new V_Ofertas();
				ventanaOfertas.setVisible(true);dispose();

			}
		});
		lblNewLabel.setIcon(new ImageIcon(Eleccion_servicio.class.getResource("/Ventanas/Icono_Ahorro.png")));
		lblNewLabel.setBounds(144, 189, 108, 90);
		contentPane.add(lblNewLabel);

		JButton lblNewLabel_1 = new JButton("");
		lblNewLabel_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				V_Vuelos ventanaVuelos= new V_Vuelos();
				ventanaVuelos.setVisible(true);dispose();
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon(Eleccion_servicio.class.getResource("/Ventanas/Icono_Vuelo.png")));
		lblNewLabel_1.setBounds(343, 189, 108, 90);
		contentPane.add(lblNewLabel_1);

		JButton lblNewLabel_1_1 = new JButton("");
		lblNewLabel_1_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				V_Visitas ventanaVisitas= new V_Visitas();
				ventanaVisitas.setVisible(true);dispose();
			}
		});
		lblNewLabel_1_1.setIcon(new ImageIcon(Eleccion_servicio.class.getResource("/Ventanas/Icono_Visita.png")));
		lblNewLabel_1_1.setBounds(534, 189, 108, 90);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_2 = new JLabel("ELECCIÓN DE SERVICIO");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel_2.setBounds(248, 63, 298, 59);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("OFERTAS");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_3.setBounds(160, 300, 79, 18);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("VUELOS");
		lblNewLabel_3_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(367, 300, 61, 18);
		contentPane.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_1_1 = new JLabel("VISITAS");
		lblNewLabel_3_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_3_1_1.setBounds(560, 300, 61, 18);
		contentPane.add(lblNewLabel_3_1_1);

	}
}
