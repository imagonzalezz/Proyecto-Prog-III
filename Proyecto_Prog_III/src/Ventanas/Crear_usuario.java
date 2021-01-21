package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BaseDatos.BD;
import Datos.Usuario;

import java.awt.GridLayout;
import javax.swing.SwingConstants;

public class Crear_usuario extends JFrame {

	private JPanel contentPane;
	private JPasswordField txtPassword2;
	private JButton btnNewButton;
	private JLabel lblNewLabel_3;
	private JTextField textFieldUsuario;
	private JButton btnInicio;
	private JTextField textFieldCorreo;
	private JPasswordField textFieldContrasenya;
	private JTextField textFieldConfirmarContra;
	


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
		contentPane.setLayout(new GridLayout(6, 2, 0, 0));
		
		lblNewLabel_3 = new JLabel("Usuario");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_3);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setColumns(10);
		contentPane.add(textFieldUsuario);
		
		JLabel lblNewLabel = new JLabel("Correo Electronico");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		contentPane.add(lblNewLabel);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setColumns(10);
		contentPane.add(textFieldCorreo);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña"); 
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_1);
		
		textFieldContrasenya = new JPasswordField();
		textFieldContrasenya.setColumns(10);
		contentPane.add(textFieldContrasenya);
		
		JLabel lblNewLabel_2 = new JLabel("Comprobar Contraseña"); 
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_2);
		
		textFieldConfirmarContra = new JPasswordField();
		textFieldConfirmarContra.setColumns(10);
		contentPane.add(textFieldConfirmarContra);
		
		
		btnNewButton = new JButton("Crear Usuario");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario,correo,contrasenya, confirmarContra;
				
				usuario= textFieldUsuario.getText();
				correo= textFieldCorreo.getText();
				contrasenya = textFieldContrasenya.getText();
				confirmarContra= textFieldConfirmarContra.getText();
				
				if (BD.comprobacionUsuario(usuario, contrasenya)==0) {
					
					
					
					if(contrasenya.equals(confirmarContra)) {
					Usuario usu= new Usuario (usuario, contrasenya, correo);
					BD.anyadirUsuario(usu);
					
					JOptionPane.showMessageDialog(null, "El usuario se ha creado correctamente");
					
					Inicio_sesion ventanaBienvenido= new Inicio_sesion();
					ventanaBienvenido.setVisible(true);
					dispose();
					
					
					}
					else {
						JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
						Crear_usuario cu= new Crear_usuario();
						cu.setVisible(true);dispose();
						}
				}
				
		
				else if(BD.comprobacionUsuario(usuario, contrasenya)==1 || BD.comprobacionUsuario(usuario, contrasenya)==2) {
					JOptionPane.showMessageDialog(null, "El usuario ya existe");
					Crear_usuario cu = new Crear_usuario();
					cu.setVisible(true);
					dispose();
			
					
					
				}
				
				
			
				
				
				
			}
		});
		
		btnInicio = new JButton("Inicio");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bienvenido ventanaBienvenido = new Bienvenido();
				ventanaBienvenido.setVisible(true);dispose();
				
				
			}
		});
		


		
		
		btnInicio.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(btnInicio);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(btnNewButton);
		

	}
}






