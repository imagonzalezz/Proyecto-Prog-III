package Datos;

import java.util.ArrayList;
import java.util.Date;

public class Oferta extends TieneCod{
	
	protected String codigo;
	protected String codigoHotel;
	protected double precioPorAdulto;
	protected double precioPorMenor;
	
	/**
	 * Constructor para hacer una instancia de una oferta que ya esta en la base de datos
	 * @param codigo codigo de la oferta
	 * @param codigoHotel codigo del hotel relacionado con la oferta
	 * @param precioPorAdulto precio al dia por adulto
	 * @param precioPorMenor precio al dia por menor
	 */
	public Oferta(String codigo, String codigoHotel, double precioPorAdulto, double precioPorMenor) {
		super();
		this.codigo = codigo;
		this.codigoHotel = codigoHotel;
		this.precioPorAdulto = precioPorAdulto;
		this.precioPorMenor = precioPorMenor;
	}

	/**
	 * Constructor para hacer una instancia de una oferta que no esta en la base de datos
	 * @param codigoHotel codigo del hotel relacionado con la oferta
	 * @param precioPorAdulto precio al dia por adulto
	 * @param precioPorMenor precio al dia por menor
	 */
	public Oferta(String codigoHotel, double precioPorAdulto, double precioPorMenor) {
		super();
		this.codigoHotel = codigoHotel;
		this.precioPorAdulto = precioPorAdulto;
		this.precioPorMenor = precioPorMenor;
		ArrayList<String> codigos = codigosEnAL("Ofertas");
		String codigo = generarCodigo(codigos, "OF", (int) Math.floor(Math.random()*(9999-1000+1)+1000), codigos.size()-1);
		this.setCodigo(codigo);
	}

	/**
	 * 
	 * @return codigo de la oferta
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * 
	 * @param codigo codigo de la oferta
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * 
	 * @return codigo del hotel relacionado con la oferta
	 */
	public String getCodigoHotel() {
		return codigoHotel;
	}

	/**
	 * codigo del hotel relacionado con la oferta
	 * @param codigoHotel
	 */
	public void setCodigoHotel(String codigoHotel) {
		this.codigoHotel = codigoHotel;
	}

	/**
	 * 
	 * @return precio al dia por adulto
	 */
	public double getPrecioPorAdulto() {
		return precioPorAdulto;
	}

	/**
	 * 
	 * @param precioPorAdulto precio al dia por adulto
	 */
	public void setPrecioPorAdulto(double precioPorAdulto) {
		this.precioPorAdulto = precioPorAdulto;
	}

	/**
	 * 
	 * @return precio al dia por menor
	 */
	public double getPrecioPorMenor() {
		return precioPorMenor;
	}

	/**
	 * 
	 * @param precioPorMenor precio al dia por menor
	 */
	public void setPrecioPorMenor(double precioPorMenor) {
		this.precioPorMenor = precioPorMenor;
	}

	@Override
	public String toString() {
		return "Oferta [codigo=" + codigo + ", codigoHotel=" + codigoHotel + ", precioPorAdulto=" + precioPorAdulto
				+ ", precioPorMenor=" + precioPorMenor + "]";
	}
	
	
}