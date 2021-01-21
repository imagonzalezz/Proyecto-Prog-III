package Datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import BaseDatos.BD;

public class CompraOferta extends Compra implements TienePrecio {

	protected int numAdultos;
	protected int numMenores;
	protected int numDias;
	public CompraOferta(Usuario usuario, String codigoComprado, int numAdultos, int numMenores, int numDias) {
		super(usuario, codigoComprado);
		this.numAdultos = numAdultos;
		this.numMenores = numMenores;
		this.numDias = numDias;
		this.precio = calcPrecio();
	}
	public int getNumAdultos() {
		return numAdultos;
	}
	public void setNumAdultos(int numAdultos) {
		this.numAdultos = numAdultos;
	}
	public int getNumMenores() {
		return numMenores;
	}
	public void setNumMenores(int numMenores) {
		this.numMenores = numMenores;
	}
	public int getNumDias() {
		return numDias;
	}
	public void setNumDias(int numDias) {
		this.numDias = numDias;
	}
	
	public Oferta getOferta() {
		Oferta o = BD.obtenerOferta(this.codigoComprado);
		return o;
	}
	
	public Hotel getHotel() {
		Hotel h = BD.obtenerHotel(this.getOferta().getCodigoHotel());
		return h;
	}
	
	@Override
	public String toString() {
		Oferta o = getOferta();
		Hotel h = getHotel();
		return "Reserva de " + numDias + " dias en el Hotel " + h.getNombre() + " de " + h.getCiudad() + " para " + numAdultos + " adultos y " + numMenores + " menores. PRECIO=" + precio + "€";
	}
	
	@Override
	public double calcPrecio() {
		Connection con = BD.initBD();
		Statement st = null;
		String query = "SELECT precioPorAdulto,precioPorMenor FROM Ofertas where codigo=" + this.codigoComprado;
		double precio = 0;
		double precioPorAdulto = 0;
		double precioPorMenor = 0;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			precioPorAdulto = rs.getDouble("precioPorAdulto");
			precioPorMenor = rs.getDouble("precioPorMenor");
			precio = ((precioPorAdulto*this.numAdultos) + (precioPorMenor*this.numMenores)) * numDias;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return precio;
	}
	
}
