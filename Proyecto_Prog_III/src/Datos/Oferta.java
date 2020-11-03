package Datos;

import java.util.Date;

public class Oferta {
	
	protected double precio;
	protected int numHuespedes;
	protected Hotel hotel;
	protected Date fechaEntrada;
	protected Date fechaSalida;
	
	/**
	 * Constructor por defecto
	 */
	public Oferta() {
		super();
	}
	
	/**
	 * 
	 * @param precio Precio total
	 * @param numHuespedes Número de huéspedes
	 * @param hotel Hotel de alojamiento
	 * @param fechaEntrada Fecha de entrada al hotel
	 * @param fechaSalida Fecha de salida del hotel
	 */
	public Oferta(double precio, int numHuespedes, Hotel hotel, Date fechaEntrada, Date fechaSalida) {
		super();
		this.precio = precio;
		this.numHuespedes = numHuespedes;
		this.hotel = hotel;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getNumHuespedes() {
		return numHuespedes;
	}

	public void setNumHuespedes(int numHuespedes) {
		this.numHuespedes = numHuespedes;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	@Override
	public String toString() {
		return "Oferta [precio=" + precio + ", numHuespedes=" + numHuespedes + ", hotel=" + hotel + ", fechaEntrada="
				+ fechaEntrada + ", fechaSalida=" + fechaSalida + "]";
	}
	
	
	
	
	
	
	

}
