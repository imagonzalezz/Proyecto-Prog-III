package Ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicio_sesion extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio_sesion frame = new Inicio_sesion();
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
	public Inicio_sesion() {
		//JFrame v=this;
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
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setBounds(278, 171, 54, 35);
		contentPane.add(lblNewLabel);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(383, 180, 149, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña"); 
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(250, 242, 82, 20);
		contentPane.add(lblNewLabel_1);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(383, 244, 149, 20);
		contentPane.add(txtPassword);
		
		JButton btnNewButton = new JButton("Crear Usuario");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Crear_usuario ventanaCU = new Crear_usuario();
				ventanaCU.setVisible(true);
				dispose();
				
				
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.setBounds(173, 354, 159, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Iniciar Sesión");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user,pwd;
				user= txtUsuario.getText();
				pwd=txtPassword.getText();
				
				
			if(user.equals("admin") && pwd.equals("admin")) {
				Admin vadmmAdmin= new Admin();
				vadmmAdmin.setVisible(true);
				//v.setVisible(false);
				
				
				
			}
				
				//TODO 
				//que pase a la siguiente ventana
				
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_1.setBounds(453, 354, 159, 35);
		contentPane.add(btnNewButton_1);
	}
}
