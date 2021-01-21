package Ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PipedWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BaseDatos.BD;
import Datos.Compra;
import Datos.CompraOferta;
import Datos.CompraProducto;
import Datos.Producto;
import Datos.TienePrecio;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

public class Carrito extends JFrame {

	private JPanel contentPane;
	JList list;
	DefaultListModel<String> modeloLista;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Carrito frame = new Carrito();
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
	public Carrito() {
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
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Finalizar Compra");
		contentPane.add(btnNewButton, BorderLayout.SOUTH);
		
		
		
		double total = 0;
		modeloLista= new DefaultListModel<String>();
		for (TienePrecio p : Eleccion_servicio.carrito) {
			modeloLista.addElement(p.toString());
			Compra c = (Compra)p;
			total += c.getPrecio();
		}
		modeloLista.addElement("TOTAL: "+total+" €");
		list=new JList();
		list.setModel(modeloLista);
		
		
		contentPane.add(list, BorderLayout.CENTER);
		
	
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
				Date d = new Date(System.currentTimeMillis());
				String nomfich = Inicio_sesion.usuario.getUsuario()+" "+sdf.format(d)+".txt";
				PrintWriter pw;
				try {
					pw = new PrintWriter(nomfich);
					double total = 0;
					for(TienePrecio tp: Eleccion_servicio.carrito){
						pw.println(tp);
						Compra c = (Compra)tp;
						total += c.getPrecio();
						if(tp instanceof CompraOferta)
							BD.anyadirCompraOferta((CompraOferta) tp);
						else
							BD.anyadirCompraProducto((CompraProducto) tp);
					}
					pw.println("TOTAL: "+total+" €");	
					pw.flush();
					pw.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
	}

}










