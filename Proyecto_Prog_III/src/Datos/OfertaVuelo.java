package Datos;

import java.util.Date;

public class OfertaVuelo extends Oferta{

	protected Vuelo vuelo;

	/**
	 * Constructor por defecto
	 */
	public OfertaVuelo() {
		super();
	}
	
	/**
	 * 
	 * @param precio Precio total
	 * @param numHuespedes Número de huespedes
	 * @param hotel Hotel de alojamiento
	 * @param fechaEntrada Fecha de entrada al hotel
	 * @param fechaSalida Fecha de salida del hotel
	 * @param vuelo Vuelo incluido en la oferta
	 */
	public OfertaVuelo(double precio, int numHuespedes, Hotel hotel, Date fechaEntrada, Date fechaSalida, Vuelo vuelo) {
		super(precio, numHuespedes, hotel, fechaEntrada, fechaSalida);
		this.vuelo = vuelo;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

	@Override
	public String toString() {
		return "OfertaVuelo [vuelo=" + vuelo + "]";
	}
	
}
