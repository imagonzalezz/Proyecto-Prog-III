package Ventanas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BaseDatos.BD;
import Datos.Oferta;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class V_Ofertas extends JFrame {

	private JPanel contentPane;
	JComboBox<String> aBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					V_Ofertas frame = new V_Ofertas();
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
	public V_Ofertas() {
		
	
 		
		int alturaPantalla;
		int anchuraPantalla;
		Toolkit mipantalla = Toolkit.getDefaultToolkit(); 
		Dimension tamanoPantalla = mipantalla.getScreenSize(); 
		alturaPantalla = tamanoPantalla.height; 
		anchuraPantalla = tamanoPantalla.width; 
		
		setBounds(anchuraPantalla/4, alturaPantalla/4, 804, 614);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		ArrayList<String> destinos= BD.destinosOfertas();
		
		String opciones []= {};
		for (int i = 0; i <destinos.size(); i++) {
			System.out.println("f");
			opciones[i]=destinos.get(i);
			
		}
		aBox= new JComboBox<String>(opciones);		
		contentPane.add(aBox);
	
	}
}