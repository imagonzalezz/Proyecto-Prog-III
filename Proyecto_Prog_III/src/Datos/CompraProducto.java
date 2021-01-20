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
