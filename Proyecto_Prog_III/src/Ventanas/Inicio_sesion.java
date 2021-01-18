package Ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BaseDatos.BD;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.SwingConstants;

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
		contentPane.setLayout(new BorderLayout());
		
		JPanel panelCentro= new JPanel(new GridLayout(5,2));
		
		
		JPanel panelLbl = new JPanel( new GridLayout(2,2));
		JPanel panelSuperior= new JPanel();
		JLabel tS= new JLabel("k");
		tS.setForeground(new Color(240,240,240));
		tS.setFont(new Font("Tahoma", Font.PLAIN, 98));
		
		panelSuperior.add(tS);
		panelCentro.add(panelLbl);
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña"); 
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtPassword = new JPasswordField();
		
		
		panelLbl.add(lblNewLabel);
		panelLbl.add(txtUsuario);
		panelLbl.add(lblNewLabel_1);
		panelLbl.add(txtPassword);
		
		
		JPanel PanelBotones= new JPanel(new GridLayout(1,1));
		
		JButton btnNewButton = new JButton("Crear Usuario");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Crear_usuario ventanaCU = new Crear_usuario();
				ventanaCU.setVisible(true);
				dispose();
				
				
			}
		});
		
		
		
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		
		
		
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
			
			else if(BD.comprobacionUsuario(user, pwd)==1) {
				JOptionPane.showMessageDialog(null, "Contraseña Incorrecta", null, 1);
				Inicio_sesion i= new Inicio_sesion();
				i.setVisible(true);dispose();
				
			}
			else if(BD.comprobacionUsuario(user, pwd)==2) {
				
				
			}
				
				//TODO
			
				//que pase a la siguiente ventana
				
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 16));
		
		PanelBotones.add(btnNewButton);		PanelBotones.add(btnNewButton_1);

		
		panelCentro.add(PanelBotones);
		
		contentPane.add(panelSuperior, BorderLayout.NORTH);
		contentPane.add(panelCentro, BorderLayout.CENTER);
		
		
	}
		
}
