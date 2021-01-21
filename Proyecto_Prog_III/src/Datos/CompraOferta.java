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
	
	/**
	 * 
	 * @param usuario usuario que ha hecho la compra
	 * @param codigoComprado codigo de la oferta que se ha comprado
	 * @param numAdultos numero de adultos
	 * @param numMenores numero de menores
	 * @param numDias numero de dias
	 */
	public CompraOferta(Usuario usuario, String codigoComprado, int numAdultos, int numMenores, int numDias) {
		super(usuario, codigoComprado);
		this.numAdultos = numAdultos;
		this.numMenores = numMenores;
		this.numDias = numDias;
		this.precio = calcPrecio();
	}
	/**
	 * 
	 * @return numero de adultos
	 */
	public int getNumAdultos() {
		return numAdultos;
	}
	/**
	 * 
	 * @param numAdultos numero de adultos
	 */
	public void setNumAdultos(int numAdultos) {
		this.numAdultos = numAdultos;
	}
	/**
	 * 
	 * @return numero de menores
	 */
	public int getNumMenores() {
		return numMenores;
	}
	/**
	 * 
	 * @param numMenores numero de menores
	 */
	public void setNumMenores(int numMenores) {
		this.numMenores = numMenores;
	}
	/**
	 * 
	 * @return numero de dias
	 */
	public int getNumDias() {
		return numDias;
	}
	/**
	 * 
	 * @param numDias numero de dias
	 */
	public void setNumDias(int numDias) {
		this.numDias = numDias;
	}
	
	/**
	 * 
	 * @return oferta relacionada con la compra
	 */
	public Oferta getOferta() {
		Oferta o = BD.obtenerOferta(this.codigoComprado);
		return o;
	}
	
	/**
	 * 
	 * @return hotel relacionado con la oferta comprada
	 */
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
	
	/**
	 * Calcula el precio de la compra teniendo en cuenta el precio por adulto y menor y el n�mero de los mismos
	 */
	@Override
	public double calcPrecio() {
		/*Connection con = BD.initBD();
		Statement st = null;
		String query = "SELECT precioPorAdulto,precioPorMenor FROM Ofertas where codigo='" + this.codigoComprado+"'";
		double precio = 0;
		double precioPorAdulto = 0;
		double precioPorMenor = 0;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			precioPorAdulto = rs.getDouble("precioPorAdulto");
			precioPorMenor = rs.getDouble("precioPorMenor");
			precio = ((precioPorAdulto*this.numAdultos) + (precioPorMenor*this.numMenores)) * this.numDias;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		double precio = BD.obtenerPrecioCompraOferta(this.codigoComprado, this.numAdultos, this.numMenores, this.numDias);
		return precio;
	}
	
}
