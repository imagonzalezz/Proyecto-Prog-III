package Ventanas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import BaseDatos.BD;
import Datos.CompraOferta;
import Datos.Oferta;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class V_Ofertas extends JFrame {

	private JPanel contentPane,pNorte,pCentro;
	private JComboBox<String> aBox;
	private JTable tablaOfertas;
	private DefaultTableModel modeloTabla;
	private JButton botonAtras;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					V_Ofertas frame = new V_Ofertas();
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
	public V_Ofertas(JFrame ventanaAnterior) {
		
		JFrame ventana = this;
 	
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
		aBox = new JComboBox<>();
		for (String d: destinos) {
			aBox.addItem(d);
		}
		pNorte = new JPanel();	
		pNorte.add(aBox);
		contentPane.add(pNorte,BorderLayout.NORTH);
		
		String [] identificadores = {"CÓDIGO OFERTA","CÓDIGO HOTEL","PRECIO POR ADULTO","PRECIO POR MENOR"};
		modeloTabla = new DefaultTableModel();
		modeloTabla.setColumnIdentifiers(identificadores);
		tablaOfertas = new JTable(modeloTabla);
		JScrollPane scrollTabla = new JScrollPane(tablaOfertas);
		
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
		
		tablaOfertas.addMouseListener(new MouseAdapter()  {
			
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int fila = tablaOfertas.getSelectedRow();
				if(fila!=-1) {
					int resp = JOptionPane.showConfirmDialog(null, "¿Quieres comprar ésta oferta?");
					if(resp == JOptionPane.YES_OPTION) {
						String codigoOferta = String.valueOf(modeloTabla.getValueAt(fila, 0));
						String codigoHotel = String.valueOf(modeloTabla.getValueAt(fila, 1));
						double precioPorAdulto = Double.parseDouble(String.valueOf(modeloTabla.getValueAt(fila, 2)));
						double precioPorMenor = Double.parseDouble(String.valueOf(modeloTabla.getValueAt(fila, 3)));
						Oferta o = new Oferta(codigoOferta, codigoHotel, precioPorAdulto,precioPorMenor);
						int numAdultos = Integer.parseInt(JOptionPane.showInputDialog("Introduce el número de adultos: "));
						int numMenores = Integer.parseInt(JOptionPane.showInputDialog("Introduce el número de menores: "));
						int numDias = Integer.parseInt(JOptionPane.showInputDialog("Introduce el número de dias: "));
						CompraOferta co = new CompraOferta(Inicio_sesion.usuario, codigoOferta, numAdultos, numMenores, numDias);
						Eleccion_servicio.carrito.add(co);
					}
				}
			}
		});

	
	}
	
	public void actualizarModeloTabla(String destino) {
		modeloTabla.setRowCount(0);
		ArrayList<Oferta> ofertas = BD.obtenerOfertasDestino(destino);
		for(Oferta o: ofertas) {
			System.out.println(o);
			String fila[] = {o.getCodigo(),o.getCodigoHotel(),String.valueOf(o.getPrecioPorAdulto()),String.valueOf(o.getPrecioPorMenor())};
			modeloTabla.addRow(fila);
		}
	}
}