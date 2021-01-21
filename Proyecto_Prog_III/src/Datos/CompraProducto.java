package Datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import BaseDatos.BD;

public class CompraProducto extends Compra implements TienePrecio {
	
	protected int cantidad;

	public CompraProducto(Usuario usuario, String codigoComprado, int cantidad) {
		super(usuario, codigoComprado);
		this.cantidad = cantidad;
		this.precio = calcPrecio();
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public Producto getProducto() {
		Producto p = BD.obtenerProducto(codigoComprado);
		return p;
	}
	
	@Override
	public String toString() {
		Producto p = getProducto();
		if(p instanceof Visita) {
			Visita v = (Visita) p;
			return "Compra de visita a " +v.getLugarInteres()+ " en " +v.getDireccion()+ " para " +cantidad+ "personas. PRECIO=" +precio+ "€";
		}else {
			Vuelo vu = (Vuelo) p;
			return "Compra de " +cantidad+ " billetes para el vuelo desde " +vu.getOrigen()+ " hasta " +vu.getDestino()+ " el dia " +vu.getFechaYHora()+ ". PRECIO=" +precio+ "€";
		}
	}

	@Override
	public double calcPrecio() {
		Connection con = BD.initBD();
		Statement st = null;
		String query;
		double precio = 0;
		try {
			st = con.createStatement();
			if(this.codigoComprado.substring(0, 2).equals("VI")) {
				query = "SELECT precio FROM Visitas WHERE codigo=" + this.codigoComprado;
			}else {
				query = "SELECT precio FROM Vuelos WHERE codigo=" + this.codigoComprado;
			}
			ResultSet rs = st.executeQuery(query);
			if(rs.next())
				precio = this.cantidad * rs.getDouble("precio");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return precio;
	}
	
	
}
