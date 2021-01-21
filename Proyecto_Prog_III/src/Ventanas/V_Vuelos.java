package Ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BaseDatos.BD;
import Datos.CompraOferta;
import Datos.CompraProducto;
import Datos.Oferta;
import Datos.Vuelo;

public class V_Vuelos extends JFrame {

	private JPanel contentPane,pNorte,pCentro;
	private JComboBox<String> aBox;
	private JTable tablaVuelos;
	private DefaultTableModel modeloTabla;
	private JButton botonAtras;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					V_Vuelos frame = new V_Vuelos();
//					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public V_Vuelos(JFrame ventanaAnterior) {
		JFrame ventana= this;
		
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
		
		ArrayList<String> origenes= BD.origenesVuelo();
		aBox = new JComboBox<>();
		for (String d: origenes) {
			aBox.addItem(d);
		}
		pNorte = new JPanel();	
		pNorte.add(aBox);
		contentPane.add(pNorte,BorderLayout.NORTH);
		
		String [] identificadores = {"CÓDIGO","ORIGEN","DESTINO","FECHA Y HORA","PRECIO", "DURACIÓN"};
		modeloTabla = new DefaultTableModel();
		modeloTabla.setColumnIdentifiers(identificadores);
		tablaVuelos = new JTable(modeloTabla);
		JScrollPane scrollTabla = new JScrollPane(tablaVuelos);
		
		
		botonAtras= new JButton("Atras");
		contentPane.add(botonAtras, BorderLayout.SOUTH);
		botonAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ventanaAnterior.setVisible(true);
				ventana.dispose();
				
			}
		});
		
		pCentro = new JPanel();
		pCentro.add(scrollTabla);
		contentPane.add(pCentro,BorderLayout.CENTER);
		
		aBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String destino = (String) aBox.getSelectedItem();
				if(destino!=null) {
					actualizarModeloTabla(destino);
				}
			}
		});
		
		tablaVuelos.addMouseListener(new MouseAdapter()  {
			
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int fila = tablaVuelos.getSelectedRow();
				if(fila!=-1) {
					int resp = JOptionPane.showConfirmDialog(null, "¿Quieres comprar ésta visita?");
					if(resp == JOptionPane.YES_OPTION) {
						String codigoVuelo = String.valueOf(modeloTabla.getValueAt(fila, 0));
						String origen = String.valueOf(modeloTabla.getValueAt(fila, 1));
						String destino = String.valueOf(modeloTabla.getValueAt(fila, 2));
						String fechaYHora = String.valueOf(modeloTabla.getValueAt(fila, 3));
						double precio = Double.parseDouble(String.valueOf(modeloTabla.getValueAt(fila, 4)));
						double duracion = Double.parseDouble(String.valueOf(modeloTabla.getValueAt(fila, 5)));
						Vuelo vuelo = new Vuelo(origen, destino, fechaYHora, precio,duracion);
						int numPersonas = Integer.parseInt(JOptionPane.showInputDialog("Introduce el número de personas: "));
						CompraProducto co = new CompraProducto(Inicio_sesion.usuario, codigoVuelo,  numPersonas);
						Eleccion_servicio.carrito.add(co);
					}
				}
			}
		});

	
	}
	
	public void actualizarModeloTabla(String destino) {
		modeloTabla.setRowCount(0);
		ArrayList<Vuelo> vuelos = BD.obtenerVuelosOrigen(destino);
		for(Vuelo v: vuelos) {
			System.out.println(v);
			String fila[] = {v.getCodigo(),String.valueOf(v.getOrigen()),String.valueOf(v.getDestino()),String.valueOf(v.getFechaYHora()), String.valueOf(v.getPrecio()+" €"),String.valueOf(v.getDuracion()+" Horas")};
			modeloTabla.addRow(fila);
		}
	}
}