package Ventanas;

import java.awt.BorderLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BaseDatos.BD;
import Datos.CompraOferta;
import Datos.CompraProducto;
import Datos.TienePrecio;

public class PanelCompras extends JPanel{
	public PanelCompras() {
		this.setLayout(new BorderLayout());
		JButton btnAtras = new JButton("VOLVER");
		this.add(btnAtras, BorderLayout.SOUTH);
		
		DefaultTableModel modeloTabla = new DefaultTableModel();
		String identificadores[] = {"USUARIO","PRECIO","TIPO"};
		modeloTabla.setColumnIdentifiers(identificadores);
		
		TreeMap<String, ArrayList<TienePrecio>> tm = BD.obtenerComprasPorUsuario();
		for(String usuario: tm.keySet()) {
			for(TienePrecio tp: tm.get(usuario)) {
				if(tp instanceof CompraOferta) {
					CompraOferta co = (CompraOferta)tp;
					String fila[] = {co.getUsuario().getUsuario(),String.valueOf(co.getPrecio()),"OFERTA"};
					modeloTabla.addRow(fila);
				}else {
					CompraProducto cp = (CompraProducto)tp;
					if(cp.getCodigoComprado().substring(0, 2).equals("VI")) {
						String fila[] = {cp.getUsuario().getUsuario(),String.valueOf(cp.getPrecio()),"VISITA"};
						modeloTabla.addRow(fila);
					}else {
						String fila[] = {cp.getUsuario().getUsuario(),String.valueOf(cp.getPrecio()),"VUELO"};
						modeloTabla.addRow(fila);
					}
				}
			}
		}
		JTable tablaCompras = new JTable(modeloTabla);
		JScrollPane scrollTabla = new JScrollPane(tablaCompras);
		this.add(scrollTabla,BorderLayout.CENTER);
		
		btnAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int numV = Window.getWindows().length;
				Window.getWindows()[numV-1].dispose();
				Admin a = new Admin(new PanelCentral());
				a.setVisible(true);
			}
		});

	}
}
