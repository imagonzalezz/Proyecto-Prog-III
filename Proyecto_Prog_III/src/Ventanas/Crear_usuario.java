package Ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Crear_usuario extends JFrame {

	private JPanel contentPane;
	private JPasswordField txtPassword2;
	private JButton btnNewButton;
	private JLabel lblNewLabel_3;
	private JTextField textField;
	private JButton btnInicio;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Crear_usuario frame = new Crear_usuario();
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
	public Crear_usuario() {
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
		
		JLabel lblNewLabel = new JLabel("Correo Electronico");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setBounds(173, 159, 140, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña"); 
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(220, 213, 82, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Comprobar Contraseña"); 
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(148, 260, 165, 20);
		contentPane.add(lblNewLabel_2);
		
		btnNewButton = new JButton("Crear Usuario");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("usuario creado");
				Inicio_sesion ventanaBienvenido= new Inicio_sesion();
				ventanaBienvenido.setVisible(true);
				dispose();
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.setBounds(449, 379, 173, 41);
		contentPane.add(btnNewButton);
		
		lblNewLabel_3 = new JLabel("Usuario");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(248, 113, 54, 35);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(330, 119, 203, 20);
		contentPane.add(textField);
		
		btnInicio = new JButton("Inicio");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bienvenido ventanaBienvenido = new Bienvenido();
				ventanaBienvenido.setVisible(true);dispose();
				
				
			}
		});
		btnInicio.setFont(new Font("Arial", Font.BOLD, 16));
		btnInicio.setBounds(125, 379, 173, 41);
		contentPane.add(btnInicio);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(330, 168, 203, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(330, 215, 203, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(330, 262, 203, 20);
		contentPane.add(textField_3);
	}
}