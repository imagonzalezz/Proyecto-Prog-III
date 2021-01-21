package Datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import BaseDatos.BD;

public class CompraProducto extends Compra implements TienePrecio {
	
	protected int cantidad;

	/**
	 * 
	 * @param usuario usuario que ha hecho la compra
	 * @param codigoComprado codigo del producto que se ha comprado
	 * @param cantidad numero de productos comprados
	 */
	public CompraProducto(Usuario usuario, String codigoComprado, int cantidad) {
		super(usuario, codigoComprado);
		this.cantidad = cantidad;
		this.precio = calcPrecio();
	}

	/**
	 * 
	 * @return numero de productos comprados
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * 
	 * @param cantidad numero de productos comprados
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	/**
	 * 
	 * @return producto relacionado con la compra
	 */
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

	/**
	 * Calcula el precio de la compra teniendo en cuenta el precio y la cantidad
	 */
	@Override
	public double calcPrecio() {
		/*Connection con = BD.initBD();
		Statement st = null;
		String query;
		double precio = 0;
		try {
			st = con.createStatement();
			if(this.codigoComprado.substring(0, 2).equals("VI")) {
				query = "SELECT precio FROM Visitas WHERE codigo='" + this.codigoComprado+"'";
			}else {
				query = "SELECT precio FROM Vuelos WHERE codigo='" + this.codigoComprado+"'";
			}
			ResultSet rs = st.executeQuery(query);
			if(rs.next())
				precio = this.cantidad * rs.getDouble("precio");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		double precio = BD.obtenerPrecioCompraProducto(this.codigoComprado, this.cantidad);
		return precio;
	}
	
	
}
