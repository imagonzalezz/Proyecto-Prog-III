package Datos;

import java.util.Date;

public class OfertaVisita extends Oferta {

	protected Visita visita;

	/**
	 * Constructor por defecto
	 */
	public OfertaVisita() {
		super();
	}

	/**
	 * 
	 * @param precio Precio total
	 * @param numHuespedes Número de huéspedes
	 * @param hotel Hotel de alojamiento
	 * @param fechaEntrada Fecha de entrada al hotel
	 * @param fechaSalida Fecha de salida al hotel
	 * @param visita Visita incluida en el hotel
	 */
	public OfertaVisita(double precio, int numHuespedes, Hotel hotel, Date fechaEntrada, Date fechaSalida, Visita visita) {
		super(precio, numHuespedes, hotel, fechaEntrada, fechaSalida);
		this.visita = visita;
	}

	public Visita getVisita() {
		return visita;
	}

	public void setVisita(Visita visita) {
		this.visita = visita;
	}

	@Override
	public String toString() {
		return "OfertaVisita [visita=" + visita + "]";
	}
	
	
	
	
}
