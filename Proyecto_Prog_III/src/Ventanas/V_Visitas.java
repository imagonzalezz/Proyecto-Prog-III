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
import Datos.Visita;

public class V_Visitas extends JFrame {

	private JPanel contentPane,pNorte,pCentro;
	private JComboBox<String> aBox;
	private JTable tablaVisitas;
	private DefaultTableModel modeloTabla;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					V_Visitas frame = new V_Visitas();
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
	public V_Visitas() {
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
		
		ArrayList<String> destinos= BD.destinosOfertas();
		aBox = new JComboBox<>();
		for (String d: destinos) {
			aBox.addItem(d);
		}
		pNorte = new JPanel();	
		pNorte.add(aBox);
		contentPane.add(pNorte,BorderLayout.NORTH);
		
		String [] identificadores = {"CÓDIGO","LUGAR DE INTERÉS","CIUDAD","VALORACIÓN","PRECIO","DURACIÓN"};
		modeloTabla = new DefaultTableModel();
		modeloTabla.setColumnIdentifiers(identificadores);
		tablaVisitas = new JTable(modeloTabla);
		JScrollPane scrollTabla = new JScrollPane(tablaVisitas);
		
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
		tablaVisitas.addMouseListener(new MouseAdapter()  {
			
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int fila = tablaVisitas.getSelectedRow();
				if(fila!=-1) {
					int resp = JOptionPane.showConfirmDialog(null, "¿Quieres comprar ésta visita?");
					if(resp == JOptionPane.YES_OPTION) {
						String codigoVisita = String.valueOf(modeloTabla.getValueAt(fila, 0));
						String lugarDeInteres = String.valueOf(modeloTabla.getValueAt(fila, 1));
						String ciudad = String.valueOf(modeloTabla.getValueAt(fila, 2));
						double valoracion = Double.parseDouble(String.valueOf(modeloTabla.getValueAt(fila, 3)));
						double precio = Double.parseDouble(String.valueOf(modeloTabla.getValueAt(fila, 3)));
						double duracion = Double.parseDouble(String.valueOf(modeloTabla.getValueAt(fila, 3)));
						Visita v= new Visita(codigoVisita, lugarDeInteres, ciudad, valoracion, precio, duracion);
						
						int numPersonas = Integer.parseInt(JOptionPane.showInputDialog("Introduce el número de personas: "));
						CompraProducto co = new CompraProducto(Inicio_sesion.usuario, codigoVisita,  numPersonas);
						Eleccion_servicio.carrito.add(co);
					}
				}
			}
			
		});

	
	}
	
	public void actualizarModeloTabla(String destino) {
		modeloTabla.setRowCount(0);
		ArrayList<Visita> visitas = BD.obtenerVisitasDestino(destino);
		for(Visita v: visitas) {
			System.out.println(v);
			String fila[] = {v.getCodigo(),v.getLugarInteres(),v.getDireccion(),String.valueOf(v.getValoracion()), String.valueOf(v.getPrecio())+"€",String.valueOf(v.getDuracion())};
			modeloTabla.addRow(fila);
		}
	}
}