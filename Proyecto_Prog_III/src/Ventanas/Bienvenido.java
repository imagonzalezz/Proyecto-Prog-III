package Ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

import javax.swing.ImageIcon;

public class Bienvenido extends JFrame {

	private JPanel contentPane;
	private static JLabelGraficoAjustado imagen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
//		(new Thread() {
//			@Override
//			public void run() {
//				for (int op=-100; op<=100; op++ ) {
//					imagen.setOpacidad( Math.abs(op*0.01f) );
//					try { Thread.sleep( 20 ); } catch (Exception e) {}  
//					System.out.println("hola");	
//				}
//			}
//		}).start(); //FIXME

		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bienvenido frame = new Bienvenido();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}); 
		//funcionOpacidad(); //FIXME
		} 

	/**
	 * Create the frame.
	 */
	public Bienvenido() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
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
		
		JLabel lblNewLabel = new JLabel("BIENVENIDO A UD TRAVELS");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 24));
		lblNewLabel.setBounds(234, 49, 362, 70);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(Bienvenido.class.getResource("/Ventanas/logo Deusto.png")));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(104, 29, 111, 107);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setIcon(new ImageIcon(Bienvenido.class.getResource("/Ventanas/logo Deusto.png")));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(574, 29, 111, 107);
		contentPane.add(lblNewLabel_1_1_1);
		
		JButton btnNewButton = new JButton("Crear Usuario");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Crear_usuario ventCrear_usuario= new Crear_usuario();
				ventCrear_usuario.setVisible(true);
				dispose();
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBounds(180, 419, 149, 47);
		contentPane.add(btnNewButton);
		
		JButton btnIniciarSesin = new JButton("Iniciar Sesión");
		btnIniciarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio_sesion vetnaInicio_sesion= new Inicio_sesion();
				vetnaInicio_sesion.setVisible(true);dispose();
				
				
			}
		});
		btnIniciarSesin.setFont(new Font("Arial", Font.BOLD, 14));
		btnIniciarSesin.setBounds(459, 419, 149, 47);
		contentPane.add(btnIniciarSesin);
		
		
		
		JLabelGraficoAjustado imagen = new JLabelGraficoAjustado("src/Ventanas/paris.jpg",900,500);
		imagen.setBounds(0, 147, 798, 200);
		contentPane.add(imagen);
		
		System.out.println("hola");
	
		
		
	}
	
	
	public static void funcionOpacidad() {
		
		for (int op=-100; op<=100; op++ ) {
			imagen.setOpacidad( Math.abs(op*0.01f) );
			try { Thread.sleep( 20 ); } catch (Exception e) {}  
			System.out.println("hola");	
		}
	}
}
